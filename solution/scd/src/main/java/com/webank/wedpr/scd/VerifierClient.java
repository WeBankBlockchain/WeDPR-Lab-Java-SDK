// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.scd;

import com.webank.wedpr.common.WedprException;

/**
 * Client class used by a SCD certificate verifier. This is the main interface class for Java apps
 * using SCD functions.
 */
public class VerifierClient extends ScdClient {
  /**
   * Verifies the validity of a VerifyRequest containing selected attribute values and their value
   * predicates.
   *
   * @param ruleSet the encoded rule set for the disclosure.
   * @param verifyRequest the encoded disclosure verifying request from the user.
   * @return VerifierResult containing data for boolResult.
   * @throws WedprException if any error occurred.
   */
  public VerifierResult verifySelectiveDisclosure(String ruleSet, String verifyRequest)
      throws WedprException {
    return NativeInterface.verifierVerifySelectiveDisclosure(ruleSet, verifyRequest)
        .expectNoError();
  }

  /**
   * Gets revealed attributes selected by a user. Before calling this function,
   * verifySelectiveDisclosure should be called to verify the validity of the VerifyRequest.
   *
   * @param verifyRequest the encoded disclosure verifying request from the user.
   * @return VerifierResult containing data for revealedAttributeDict.
   * @throws WedprException if any error occurred.
   */
  public VerifierResult getRevealedAttributes(String verifyRequest) throws WedprException {
    return NativeInterface.verifierGetRevealedAttributes(verifyRequest).expectNoError();
  }

  /**
   * Generates a new encoded nonce as the challenge for a user to generate a fresh proof.
   *
   * @return VerifierResult containing data for verificationNonce.
   * @throws WedprException if any error occurred.
   */
  public VerifierResult getVerificationNonce() throws WedprException {
    return NativeInterface.verifierGetVerificationNonce().expectNoError();
  }
}
