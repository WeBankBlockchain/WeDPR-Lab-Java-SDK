// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.demo;

import com.webank.wedpr.common.Utils;
import com.webank.wedpr.scd.*;
import com.webank.wedpr.scd.proto.*;
import java.util.*;

/**
 * Minimalist demo of selective disclosure.
 *
 * <p>For a better interactive demo, please try our Rust version at
 * https://github.com/WeBankBlockchain/WeDPR-Lab-Core
 */
public class ScdDemo {
  public static void run(ScdClient scdClient) throws Exception {
    System.out.println("\n*******\nSELECTIVE DISCLOSURE RUN\n*******");

    // issuer make template
    ArrayList<String> attributes = new ArrayList<String>();
    attributes.add("name");
    attributes.add("age");
    attributes.add("gender");
    attributes.add("time");
    String encodeAttributeTemplate = scdClient.issuerMakeCertificateSchema(attributes);
    System.out.println("Encoded attributeTemplate = " + encodeAttributeTemplate);

    IssuerResult issuerResult =
        scdClient.issuerMakeCertificateTemplate(encodeAttributeTemplate);

    String credentialTemplate = issuerResult.certificateTemplate;
    String templateSecretKey = issuerResult.templatePrivateKey;
    System.out.println("Encoded credentialTemplate = " + credentialTemplate);
    System.out.println("Encoded templateSecretKey = " + templateSecretKey);

    // User fill template
    Map<String, String> maps = new HashMap<String, String>();
    maps.put("name", "123");
    maps.put("age", "18");
    maps.put("gender", "1");
    maps.put("time", "12345");
    String credentialInfo = scdClient.userMakeAttributeDict(maps);
    UserResult userResult =
        scdClient.userFillCertificate(credentialInfo, credentialTemplate);

    String signatureRequest = userResult.signCertificateRequest;
    String userPrivateKey = userResult.userPrivateKey;
    String credentialSecretsBlindingFactors = userResult.certificateSecretsBlindingFactors;
    String userNonce = userResult.userNonce;
    System.out.println("Encoded signatureRequest = " + signatureRequest);
    System.out.println("Encoded userPrivateKey = " + userPrivateKey);
    System.out.println(
        "Encoded credentialSecretsBlindingFactors = " + credentialSecretsBlindingFactors);
    System.out.println("Encoded userNonce = " + userNonce);

    // Issuer sign user's request to generate credential
    issuerResult =
        scdClient.issuerSignCertificate(
            credentialTemplate, templateSecretKey, signatureRequest, "id1", userNonce);

    String credentialSignature = issuerResult.certificateSignature;
    String issuerNonce = issuerResult.issuerNonce;
    System.out.println("Encoded credentialSignature = " + credentialSignature);
    System.out.println("Encoded issuerNonce = " + issuerNonce);

    // User generate new credentialSignature
    userResult =
        scdClient.userBlindCertificateSignature(
            credentialSignature,
            credentialInfo,
            credentialTemplate,
            userPrivateKey,
            credentialSecretsBlindingFactors,
            issuerNonce);

    String credentialSignatureNew = userResult.certificateSignature;
    System.out.println("Encoded credentialSignatureNew = " + credentialSignatureNew);

    // Verifier set verification rules
    VerificationRuleSet verificationRuleSet = VerificationRuleSet.getDefaultInstance();
    Predicate predicate =
        Predicate.newBuilder()
            .setAttributeName("age")
            .setPredicateType(PredicateType.GT.name())
            .setPredicateValue(17)
            .build();
    verificationRuleSet = verificationRuleSet.toBuilder().addAttributePredicate(predicate).build();

    predicate =
        Predicate.newBuilder()
            .setAttributeName("gender")
            .setPredicateType(PredicateType.EQ.name())
            .setPredicateValue(1)
            .build();
    verificationRuleSet = verificationRuleSet.toBuilder().addAttributePredicate(predicate).build();

    String verificationRuleStr =
        ScdClient.protoToEncodedString(verificationRuleSet);
    System.out.println("Encoded verificationRuleStr = " + verificationRuleStr);

    // User prove by verification rules
    String verificationNonce =
        scdClient.verifierGetVerificationNonce().verificationNonce;
    userResult =
        scdClient.userProveSelectiveDisclosure(
            verificationRuleStr,
            credentialSignatureNew,
            credentialInfo,
            credentialTemplate,
            userPrivateKey,
            verificationNonce);

    String verificationRequest = userResult.verifyRequest;
    System.out.println("Encoded verificationRequest = " + verificationRequest);

    // Verifier verify proof
    VerifierResult verifierResult =
        scdClient.verifierVerifySelectiveDisclosure(verificationRuleStr, verificationRequest);
    System.out.println("result = " + verifierResult.boolResult);

    verifierResult =
        scdClient.verifierGetRevealedAttrsFromVerifyRequest(verificationRequest);
    String revealedAttributeDict = verifierResult.revealedAttributeDict;
    AttributeDict attributeDict =
        AttributeDict.parseFrom(Utils.stringToBytes(revealedAttributeDict));
    System.out.println("revealedAttributeDict =" + attributeDict);
  }
}
