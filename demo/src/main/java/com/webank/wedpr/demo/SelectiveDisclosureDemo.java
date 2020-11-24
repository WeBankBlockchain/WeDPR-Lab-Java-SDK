// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.demo;

import com.webank.wedpr.common.Utils;
import com.webank.wedpr.selectivedisclosure.*;
import com.webank.wedpr.selectivedisclosure.proto.*;
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

    String credentialTemplate = issuerResult.credentialTemplate;
    String templateSecretKey = issuerResult.templateSecretKey;
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

    String signatureRequest = userResult.credentialSignatureRequest;
    String masterSecret = userResult.masterSecret;
    String credentialSecretsBlindingFactors = userResult.credentialSecretsBlindingFactors;
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

    String credentialSignature = issuerResult.credentialSignature;
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

    String credentialSignatureNew = userResult.credentialSignature;
    System.out.println("Encoded credentialSignatureNew = " + credentialSignatureNew);

    // Verifier set verification rules
    VerificationRule verificationRule = VerificationRule.getDefaultInstance();
    Predicate predicate =
        Predicate.newBuilder()
            .setAttributeName("age")
            .setPredicateType(PredicateType.GT.name())
            .setValue(17)
            .build();
    verificationRule = verificationRule.toBuilder().addPredicateAttribute(predicate).build();

    predicate =
        Predicate.newBuilder()
            .setAttributeName("gender")
            .setPredicateType(PredicateType.EQ.name())
            .setValue(1)
            .build();
    verificationRule = verificationRule.toBuilder().addPredicateAttribute(predicate).build();

    String verificationRuleStr = selectiveDisclosureClient.protoToEncodedString(verificationRule);
    System.out.println("Encoded verificationRuleStr = " + verificationRuleStr);

    // User prove by verification rules
    userResult =
        selectiveDisclosureClient.proveCredentialInfo(
            verificationRuleStr,
            credentialSignatureNew,
            credentialInfo,
            credentialTemplate,
            masterSecret);

    String verificationRequest = userResult.verificationRequest;
    System.out.println("Encoded verificationRequest = " + verificationRequest);

    // Verifier verify proof
    VerifierResult verifierResult =
        selectiveDisclosureClient.verifyProof(verificationRuleStr, verificationRequest);
    System.out.println("result = " + verifierResult.result);

    verifierResult =
        selectiveDisclosureClient.getRevealedAttrsFromVerificationRequest(verificationRequest);
    String revealedAttributeInfo = verifierResult.revealedAttributeInfo;
    RevealedAttributeInfo revealedAttributeInfoPb =
        RevealedAttributeInfo.parseFrom(Utils.stringToBytes(revealedAttributeInfo));
    System.out.println("revealedAttributeInfo =" + revealedAttributeInfoPb);
  }
}
