// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.crypto;

import com.webank.wedpr.common.WedprException;
import java.util.Base64;

/**
 * Minimalist demo of WeDPR Crypto.
 *
 * <p>For a better interactive demo, please try our Rust version at
 * https://github.com/WeBankBlockchain/WeDPR-Lab-Core
 */
public class DemoMain {

  public static void main(String[] args) throws Exception {
    CryptoClient cryptoClient = new CryptoClient();
    runCryptoDemo(cryptoClient);
  }

  private static void runCryptoDemo(CryptoClient cryptoClient) throws WedprException {
    System.out.println("\n*******\nWeDPR CRYPTO RUN\n*******");
    System.out.println("Generate EC keyPair\n");

    CryptoResult cryptoResult = cryptoClient.secp256k1GenKeyPair();
    String publicKey = cryptoResult.publicKey;
    String privateKey = cryptoResult.privateKey;
    System.out.println("public key = " + publicKey);
    System.out.println("private key = " + privateKey);

    String message = Base64.getEncoder().encodeToString("WeDPR Crypto Demo".getBytes());
    System.out.println("Hash message = " + message + " with keccak256" + "\n");
    String messageHash = cryptoClient.keccak256Hash(message).hash;
    System.out.println("messageHash = " + messageHash);

    System.out.println(
        "Sign data with message hash = " + messageHash + " by EC keyPair private key" + "\n");

    String signature = cryptoClient.secp256k1Sign(privateKey, messageHash).signature;

    System.out.println("Signature = " + signature);

    System.out.println(
        "Verify Signature with message hash = " + messageHash + " by EC keyPair public key" + "\n");
    boolean result = cryptoClient.secp256k1Verify(publicKey, messageHash, signature).booleanResult;
    System.out.println("result = " + result);

    System.out.println(
        "Encrypt data with messageHash = " + messageHash + " by EC keyPair public key" + "\n");
    String cipherData = cryptoClient.secp256k1EciesEncrypt(publicKey, messageHash).encryptedData;
    System.out.println("cipherData = " + cipherData);

    System.out.println("Decrypt data by EC keyPair private key" + "\n");
    String plainData = cryptoClient.secp256k1EciesDecrypt(privateKey, cipherData).decryptedData;
    System.out.println("plainData = " + plainData);
  }
}
