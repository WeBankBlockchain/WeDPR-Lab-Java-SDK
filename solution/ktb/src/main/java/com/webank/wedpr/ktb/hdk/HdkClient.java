// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.
package com.webank.wedpr.ktb.hdk;

import com.webank.wedpr.common.WedprException;

/**
 * Client class used by ktb tools. This is the main interface class for Java apps using crypto
 * functions.
 */
public class HdkClient {

  /**
   * Create English Mnemonic
   *
   * @param wordCount
   * @return
   * @throws WedprException
   */
  public HdkResult createMnemonicEn(int wordCount) throws WedprException {
    return NativeInterface.createMnemonicEn(wordCount).expectNoError();
  }

  /**
   * Create Master key
   *
   * @param password
   * @param mnemonic
   * @return
   * @throws WedprException
   */
  public HdkResult createMasterKeyEn(String password, String mnemonic) throws WedprException {
    return NativeInterface.createMasterKeyEn(password, mnemonic).expectNoError();
  }

  /**
   * Derive Extended Key
   *
   * @param masterKey
   * @param purposeType
   * @param assetType
   * @param account
   * @param change
   * @param addressIndex
   * @return
   * @throws WedprException
   */
  public HdkResult deriveExtendedKey(
      String masterKey, int purposeType, int assetType, int account, int change, int addressIndex)
      throws WedprException {
    return NativeInterface.deriveExtendedKey(
            masterKey, purposeType, assetType, account, change, addressIndex)
        .expectNoError();
  }
}
