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
public class SelectiveDisclosureDemo {
  public static void run(SelectiveDisclosureClient selectiveDisclosureClient) throws Exception {
    System.out.println("\n*******\nSELECTIVE DISCLOSURE RUN\n*******");

    // issuer make template
    ArrayList<String> attributes = new ArrayList<String>();
    attributes.add("name");
    attributes.add("age");
    attributes.add("gender");
    attributes.add("time");
    String encodeAttributeTemplate = selectiveDisclosureClient.makeAttributeTemplate(attributes);
    System.out.println("Encoded attributeTemplate = " + encodeAttributeTemplate);

    IssuerResult issuerResult =
        selectiveDisclosureClient.makeCredentialTemplate(encodeAttributeTemplate);

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
    String credentialInfo = selectiveDisclosureClient.makeCredentialInfo(maps);
    UserResult userResult =
        selectiveDisclosureClient.makeCredential(credentialInfo, credentialTemplate);

    String signatureRequest = userResult.signCertificateRequest;
    String masterSecret = userResult.userPrivateKey;
    String credentialSecretsBlindingFactors = userResult.certificateSecretsBlindingFactors;
    String userNonce = userResult.userNonce;
    System.out.println("Encoded signatureRequest = " + signatureRequest);
    System.out.println("Encoded masterSecret = " + masterSecret);
    System.out.println(
        "Encoded credentialSecretsBlindingFactors = " + credentialSecretsBlindingFactors);
    System.out.println("Encoded userNonce = " + userNonce);

    // Issuer sign user's request to generate credential
    issuerResult =
        selectiveDisclosureClient.signCredential(
            credentialTemplate, templateSecretKey, signatureRequest, "id1", userNonce);

    String credentialSignature = issuerResult.certificateSignature;
    String issuerNonce = issuerResult.issuerNonce;
    System.out.println("Encoded credentialSignature = " + credentialSignature);
    System.out.println("Encoded issuerNonce = " + issuerNonce);

    // User generate new credentialSignature
    userResult =
        selectiveDisclosureClient.blindCredentialSignature(
            credentialSignature,
            credentialInfo,
            credentialTemplate,
            masterSecret,
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
        SelectiveDisclosureClient.protoToEncodedString(verificationRuleSet);
    System.out.println("Encoded verificationRuleStr = " + verificationRuleStr);

    // User prove by verification rules
    String verificationNonce =
        selectiveDisclosureClient.verifierGetVerificationNonce().verificationNonce;
    userResult =
        selectiveDisclosureClient.proveCredentialInfo(
            verificationRuleStr,
            credentialSignatureNew,
            credentialInfo,
            credentialTemplate,
            masterSecret,
            verificationNonce);

    String verificationRequest = userResult.verifyRequest;
    System.out.println("Encoded verificationRequest = " + verificationRequest);

    // Verifier verify proof
    VerifierResult verifierResult =
        selectiveDisclosureClient.verifyProof(verificationRuleStr, verificationRequest);
    System.out.println("result = " + verifierResult.boolResult);

    verifierResult =
        selectiveDisclosureClient.getRevealedAttrsFromVerificationRequest(verificationRequest);
    String revealedAttributeDict = verifierResult.revealedAttributeDict;
    AttributeDict attributeDict =
        AttributeDict.parseFrom(Utils.stringToBytes(revealedAttributeDict));
    System.out.println("revealedAttributeDict =" + attributeDict);
  }
}
