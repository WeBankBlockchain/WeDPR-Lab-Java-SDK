package com.webank.wedpr.vcl;

import com.webank.wedpr.common.WedprException;

/** Client class used by VCL. This is the main interface class for Java apps using VCL functions. */
public class VclClient {
  /**
   * Makes a confidential credit record and owner secret for a numeric value.
   *
   * @param value credit value.
   * @return VclResult containing data for confidentialCredit, ownerSecret.
   * @throws WedprException if any error occurred.
   */
  public VclResult makeCredit(long value) throws WedprException {
    return NativeInterface.makeCredit(value).expectNoError();
  }

  /**
   * Proves three confidential credit records satisfying a sum relationship, i.e. the values
   * embedded in them satisfying c1_value + c2_value = c3_value. c?_secret are the owner secrets for
   * spending those credit.
   *
   * @param c1Secret the owner secret for spending the credit of c1_value.
   * @param c2Secret the owner secret for spending the credit of c2_value.
   * @param c3Secret the owner secret for spending the credit of c3_value.
   * @return VclResult containing data for proof.
   * @throws WedprException if any error occurred.
   */
  public VclResult proveSumBalance(String c1Secret, String c2Secret, String c3Secret)
      throws WedprException {
    return NativeInterface.proveSumBalance(c1Secret, c2Secret, c3Secret).expectNoError();
  }

  /**
   * Verifies three commitments satisfying a sum relationship, i.e. the values embedded in
   * c1_credit, c2_credit, c3_credit satisfying c1_value + c2_value = c3_value.
   *
   * @param c1Credit the confidential credit record of c1_value.
   * @param c2Credit the confidential credit record of c2_value.
   * @param c3Credit the confidential credit record of c3_value.
   * @param proof the proof of satisfying the sum relationship or not.
   * @return VclResult containing data for verificationResult.
   * @throws WedprException if any error occurred.
   */
  public VclResult verifySumBalance(String c1Credit, String c2Credit, String c3Credit, String proof)
      throws WedprException {
    return NativeInterface.verifySumBalance(c1Credit, c2Credit, c3Credit, proof).expectNoError();
  }

  /**
   * Proves three confidential credit records satisfying a product relationship, i.e. the values
   * embedded in them satisfying c1_value * c2_value = c3_value. c?_secret are the owner secrets for
   * spending those commitments.
   *
   * @param c1Secret the owner secret for spending the credit of c1_value.
   * @param c2Secret the owner secret for spending the credit of c2_value.
   * @param c3Secret the owner secret for spending the credit of c3_value.
   * @return VclResult containing data for proof.
   * @throws WedprException if any error occurred.
   */
  public VclResult proveProductBalance(String c1Secret, String c2Secret, String c3Secret)
      throws WedprException {
    return NativeInterface.proveProductBalance(c1Secret, c2Secret, c3Secret).expectNoError();
  }

  /**
   * Verifies three commitments satisfying a product relationship, i.e. the values embedded in
   * c1_credit, c2_credit, c3_credit satisfying c1_value * c2_value = c3_value.
   *
   * @param c1Credit the confidential credit record of c1_value.
   * @param c2Credit the confidential credit record of c2_value.
   * @param c3Credit the confidential credit record of c3_value.
   * @param proof the proof of satisfying the product relationship or not.
   * @return VclResult containing data for verificationResult.
   * @throws WedprException if any error occurred.
   */
  public VclResult verifyProductBalance(
      String c1Credit, String c2Credit, String c3Credit, String proof) throws WedprException {
    return NativeInterface.verifyProductBalance(c1Credit, c2Credit, c3Credit, proof)
        .expectNoError();
  }

  /**
   * Proves whether the value embedded in a confidential credit record belongs to (0,
   * 2^RANGE_SIZE_IN_BITS - 1]. RANGE_SIZE_IN_BITS is defined in the dynamic library of VCL, whose
   * typical value is 32.
   *
   * @param ownerSecret the owner secret for spending a credit.
   * @return VclResult containing data for proof.
   * @throws WedprException if any error occurred.
   */
  public VclResult proveRange(String ownerSecret) throws WedprException {
    return NativeInterface.proveRange(ownerSecret).expectNoError();
  }

  /**
   * Verifies whether the value embedded in a confidential credit record belongs to (0,
   * 2^RANGE_SIZE_IN_BITS - 1]. RANGE_SIZE_IN_BITS is defined in the dynamic library of VCL, whose
   * typical value is 32.
   *
   * @param confidentialCredit the confidential credit record of a value.
   * @param proof the proof of satisfying the range constraint or not.
   * @return VclResult containing data for verificationResult.
   * @throws WedprException if any error occurred.
   */
  public VclResult verifyRange(String confidentialCredit, String proof) throws WedprException {
    return NativeInterface.verifyRange(confidentialCredit, proof).expectNoError();
  }

  // TODO: Add a getVclConfig function to expose the value of RANGE_SIZE_IN_BITS.
}
