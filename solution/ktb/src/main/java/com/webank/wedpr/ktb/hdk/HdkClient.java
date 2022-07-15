// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.ktb.hdk;

import com.webank.wedpr.common.WedprException;

/**
 * Client class used by KTB-HDK. This is the main interface class for Java apps using HDK functions.
 */
public class HdkClient {

  /**
   * Creates an English mnemonic for later generating the master key.
   *
   * @param wordCount the word count of the mnemonic.
   * @return HdkResult containing data for mnemonic.
   * @throws WedprException if any error occurred.
   */
  public HdkResult createMnemonicEn(int wordCount) throws WedprException {
    return NativeInterface.createMnemonicEn(wordCount).expectNoError();
  }

  /**
   * Creates a master key from a English mnemonic and a password.
   *
   * @param password the password used together with the mnemonic.
   * @param mnemonic the mnemonic for master key recovery.
   * @return HdkResult containing data for masterKey.
   * @throws WedprException if any error occurred.
   */
  public HdkResult createMasterKeyEn(String password, String mnemonic) throws WedprException {
    return NativeInterface.createMasterKeyEn(password, mnemonic).expectNoError();
  }

  /**
   * Derives an extended key pair based on a key derivation path.
   *
   * @param masterKey the master key for key derivation.
   * @param purposeType the purpose type of the derived key.
   * @param assetType the asset subtype of the derived key.
   * @param account the account subtype of the derived key.
   * @param change the change subtype of the derived key.
   * @param addressIndex the address index of the derived key.
   * @return HdkResult containing data for extendedPublicKey, extendedPrivateKey.
   * @throws WedprException if any error occurred.
   */
  public HdkResult deriveExtendedKey(
      String masterKey, int purposeType, int assetType, int account, int change, int addressIndex)
      throws WedprException {
    return NativeInterface.deriveExtendedKey(
            masterKey, purposeType, assetType, account, change, addressIndex)
        .expectNoError();
  }
}
