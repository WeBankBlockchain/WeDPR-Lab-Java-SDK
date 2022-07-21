// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.demo;

import com.webank.wedpr.common.Utils;
import com.webank.wedpr.scd.*;
import com.webank.wedpr.scd.proto.*;
import java.util.*;

/**
 * Minimalist demo of selective certificate disclosure (SCD).
 *
 * <p>For a better interactive demo, please try our Rust version at
 * https://github.com/WeBankBlockchain/WeDPR-Lab-Core
 */
public class ScdDemo {
  private static final String NAME = "name";
  private static final String AGE = "age";
  private static final String GENDER = "gender";
  private static final String ISSUE_TIME = "issue_time";
  private static final String DEFAULT_USER_ID = "default_user_id";

  public static void run(
      IssuerClient issuerClient, UserClient userClient, VerifierClient verifierClient)
      throws Exception {
    System.out.println("\n*******\nSCD DEMO RUN\n*******");

    // An issuer defines the certificate schema and generates the certificate template.
    List<String> schema = Arrays.asList(NAME, AGE, GENDER, ISSUE_TIME);
    System.out.println("Encoded schema = " + schema);

    IssuerResult issuerResult = issuerClient.makeCertificateTemplate(schema);

    String certificateTemplate = issuerResult.certificateTemplate;
    String templatePrivateKey = issuerResult.templatePrivateKey;
    System.out.println("Encoded certificateTemplate = " + certificateTemplate);
    System.out.println("Encoded templatePrivateKey = " + templatePrivateKey);

    // A user fills the certificate template and prepares a request for the issuer to sign.
    Map<String, String> certificateDataInput = new HashMap<>();
    // TODO: Add a utility function to convert any string to a decimal string.
    // Before this utility function is implemented, the attribute value can only be a decimal
    // string.
    certificateDataInput.put(NAME, "123");
    certificateDataInput.put(AGE, "19");
    certificateDataInput.put(GENDER, "1");
    certificateDataInput.put(ISSUE_TIME, "12345");
    String certificateData = userClient.encodeAttributeDict(certificateDataInput);
    UserResult userResult = userClient.fillCertificate(certificateData, certificateTemplate);

    String signCertificateRequest = userResult.signCertificateRequest;
    String userPrivateKey = userResult.userPrivateKey;
    String certificateSecretsBlindingFactors = userResult.certificateSecretsBlindingFactors;
    String userNonce = userResult.userNonce;
    System.out.println("Encoded signCertificateRequest = " + signCertificateRequest);
    System.out.println("Encoded userPrivateKey = " + userPrivateKey);
    System.out.println(
        "Encoded certificateSecretsBlindingFactors = " + certificateSecretsBlindingFactors);
    System.out.println("Encoded userNonce = " + userNonce);

    // The issuer verifies the certificate signing request from the user and signs the certificate.
    issuerResult =
        issuerClient.signCertificate(
            certificateTemplate,
            templatePrivateKey,
            signCertificateRequest,
            DEFAULT_USER_ID,
            userNonce);

    String certificateSignature = issuerResult.certificateSignature;
    String issuerNonce = issuerResult.issuerNonce;
    System.out.println("Encoded certificateSignature = " + certificateSignature);
    System.out.println("Encoded issuerNonce = " + issuerNonce);

    // The user blinds the received certificateSignature to prevent the issuer to track the
    // certificate usage.
    userResult =
        userClient.blindCertificateSignature(
            certificateSignature,
            certificateData,
            certificateTemplate,
            userPrivateKey,
            certificateSecretsBlindingFactors,
            issuerNonce);

    String blindedCertificateSignature = userResult.certificateSignature;
    System.out.println("Encoded blindedCertificateSignature = " + blindedCertificateSignature);

    // A verifier sets a verification rule to:
    // Check AGE > 18 and,
    VerificationRuleSet.Builder verificationRuleSetBuilder = VerificationRuleSet.newBuilder();
    Predicate predicate =
        Predicate.newBuilder()
            .setAttributeName(AGE)
            .setPredicateType(PredicateType.GT.name())
            .setPredicateValue(18)
            .build();
    verificationRuleSetBuilder.addAttributePredicate(predicate);
    // Reveal the ISSUE_TIME attribute.
    verificationRuleSetBuilder.addRevealedAttributeName(ISSUE_TIME);

    String encodedVerificationRuleSet =
        verifierClient.protoToEncodedString(verificationRuleSetBuilder.build());
    System.out.println("Encoded verificationRuleSet = " + encodedVerificationRuleSet);

    String verificationNonce = verifierClient.getVerificationNonce().verificationNonce;

    // The user proves the signed certificate data satisfying the verification rules and does not
    // reveal any extra data.
    userResult =
        userClient.proveSelectiveDisclosure(
            encodedVerificationRuleSet,
            blindedCertificateSignature,
            certificateData,
            certificateTemplate,
            userPrivateKey,
            verificationNonce);

    String verifyRequest = userResult.verifyRequest;
    System.out.println("Encoded verifyRequest = " + verifyRequest);

    // The verifier verifies the required verification rule is satisfied and extracts the required
    // attribute.
    // This verification should be done before calling revealedAttributeDict.
    VerifierResult verifierResult =
        verifierClient.verifySelectiveDisclosure(encodedVerificationRuleSet, verifyRequest);
    System.out.println("Proof verification result = " + verifierResult.boolResult);

    verifierResult = verifierClient.getRevealedAttributes(verifyRequest);
    String encodedRevealedCertificateData = verifierResult.revealedAttributeDict;
    AttributeDict revealedCertificateData =
        AttributeDict.parseFrom(Utils.stringToBytes(encodedRevealedCertificateData));
    System.out.println("revealedCertificateData =" + revealedCertificateData);
  }
}
