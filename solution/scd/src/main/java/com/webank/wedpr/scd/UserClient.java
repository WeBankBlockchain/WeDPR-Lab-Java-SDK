// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.scd;

import com.webank.wedpr.common.WedprException;

/**
 * Client class used by a SCD certificate user. This is the main interface class for Java apps using
 * SCD functions.
 */
public class UserClient extends ScdClient {
  /**
   * Fills a certificate and generates a SignCertificateRequest for an issuer to sign.
   *
   * @param attributeDict the encode KV map for the filled data of a certificate.
   * @param certificateTemplate the encoded certificate template.
   * @return UserResult containing data for signCertificateRequest, userPrivateKey,
   *     certificateSecretsBlindingFactors, userNonce.
   * @throws WedprException if any error occurred.
   */
  public UserResult fillCertificate(String attributeDict, String certificateTemplate)
      throws WedprException {
    return NativeInterface.userFillCertificate(attributeDict, certificateTemplate).expectNoError();
  }

  /**
   * Blinds the signature of a signed certificate to prevent the issuer from tracking its usage.
   *
   * @param certificateSignature the encoded certificate signature signed by the issuer.
   * @param attributeDict the encode KV map for the filled data of a certificate.
   * @param certificateTemplate the encoded certificate template.
   * @param userPrivateKey the encoded user private key.
   * @param certificateSecretsBlindingFactors the encoded blinding factors.
   * @param issuerNonce the encoded nonce from the issuer.
   * @return UserResult containing data for certificateSignature.
   * @throws WedprException if any error occurred.
   */
  public UserResult blindCertificateSignature(
      String certificateSignature,
      String attributeDict,
      String certificateTemplate,
      String userPrivateKey,
      String certificateSecretsBlindingFactors,
      String issuerNonce)
      throws WedprException {
    return NativeInterface.userBlindCertificateSignature(
            certificateSignature,
            attributeDict,
            certificateTemplate,
            userPrivateKey,
            certificateSecretsBlindingFactors,
            issuerNonce)
        .expectNoError();
  }

  /**
   * Generate a VerifyRequest to prove the validity of selected attribute values and their value
   * predicates from a certificate, while those unselected attributes will not be revealed.
   *
   * @param ruleSet the encoded rule set for the disclosure from the verifier.
   * @param certificateSignature the encoded certificate signature.
   * @param attributeDict the encode KV map for the filled data of a certificate.
   * @param certificateTemplate the encoded certificate template.
   * @param userPrivateKey the encoded user private key.
   * @return UserResult containing data for verifyRequest.
   * @throws WedprException if any error occurred.
   */
  public UserResult proveSelectiveDisclosure(
      String ruleSet,
      String certificateSignature,
      String attributeDict,
      String certificateTemplate,
      String userPrivateKey,
      String verificationNonce)
      throws WedprException {
    return NativeInterface.userProveSelectiveDisclosure(
            ruleSet,
            certificateSignature,
            attributeDict,
            certificateTemplate,
            userPrivateKey,
            verificationNonce)
        .expectNoError();
  }
}
