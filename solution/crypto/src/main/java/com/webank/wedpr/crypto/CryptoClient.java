// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.
package com.webank.wedpr.crypto;

import com.webank.wedpr.common.WedprException;

/**
 * Client class used by WeDPR crypto. This is the main interface class for Java apps using VCL
 * functions.
 */
public class CryptoClient {

  /**
   * @param pubKey
   * @param plaintext
   * @return
   * @throws WedprException
   */
  public CryptoResult secp256k1EciesEncrypt(String pubKey, String plaintext) throws WedprException {
    return NativeInterface.secp256k1EciesEncrypt(pubKey, plaintext).expectNoError();
  }

  public CryptoResult secp256k1EciesDecrypt(String priKey, String ciphertext)
      throws WedprException {
    return NativeInterface.secp256k1EciesDecrypt(priKey, ciphertext).expectNoError();
  }

  public CryptoResult secp256k1GenKeyPair() throws WedprException {
    return NativeInterface.secp256k1GenKeyPair().expectNoError();
  }

  public CryptoResult keccak256Hash(String message) throws WedprException {
    return NativeInterface.keccak256Hash(message).expectNoError();
  }

  public CryptoResult secp256k1Sign(String priKey, String messageHash) throws WedprException {
    return NativeInterface.secp256k1Sign(priKey, messageHash).expectNoError();
  }

  public CryptoResult secp256k1Verify(String pubKey, String messageHash, String signature)
      throws WedprException {
    return NativeInterface.secp256k1Verify(pubKey, messageHash, signature).expectNoError();
  }

  // TODO: Add a getVclConfig function to expose the value of RANGE_SIZE_IN_BITS.
}
