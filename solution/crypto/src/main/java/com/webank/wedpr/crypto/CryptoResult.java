// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.crypto;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by Crypto client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class CryptoResult extends WedprResult {
  public String signature;
  public String publicKey;
  public String privateKey;
  public byte[] hash;
  public boolean booleanResult;
  public String encryptedData;
  public String decryptedData;

  /** Expects no error occurred, otherwise throws an Exception. */
  public CryptoResult expectNoError() throws WedprException {
    if (hasError()) {
      throw new WedprException(wedprErrorMessage);
    }
    return this;
  }
}
