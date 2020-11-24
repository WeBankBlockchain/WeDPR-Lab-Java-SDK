// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.demo;

import com.webank.wedpr.crypto.CryptoClient;
import com.webank.wedpr.crypto.CryptoResult;
import java.util.Base64;

/** Minimalist demo of WeDPR Crypto Tools. */
public class CryptoDemo {
  public static void run(CryptoClient cryptoClient) throws Exception {
    System.out.println("\n*******\nCRYPTO TOOL RUN\n*******");

    CryptoResult cryptoResult = cryptoClient.secp256k1GenKeyPair();
    String publicKey = cryptoResult.publicKey;
    String privateKey = cryptoResult.privateKey;
    System.out.println("public key = " + publicKey);
    System.out.println("private key = " + privateKey);

    // Base64 encoding for "WeDPR Demo", which is currently required to pass bytes input to API.
    // TODO: Allow non-encoded UTF8 input.
    String message = Base64.getEncoder().encodeToString("WeDPR Demo".getBytes());
    String messageHash = cryptoClient.keccak256Hash(message).hash;
    System.out.println("messageHash = " + messageHash);

    String signature = cryptoClient.secp256k1Sign(privateKey, messageHash).signature;
    System.out.println("signature = " + signature);

    boolean result = cryptoClient.secp256k1Verify(publicKey, messageHash, signature).booleanResult;
    System.out.println("signature verify result = " + result);

    String encryptedData = cryptoClient.secp256k1EciesEncrypt(publicKey, messageHash).encryptedData;
    System.out.println("encryptedData = " + encryptedData);

    String decryptedData =
        cryptoClient.secp256k1EciesDecrypt(privateKey, encryptedData).decryptedData;
    System.out.println("decryptedData = " + decryptedData);
  }
}
