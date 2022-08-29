// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.
package com.webank.wedpr.crypto;

import com.webank.wedpr.common.WedprException;

/**
 * Client class used by crypto tools. This is the main interface class for Java apps using crypto
 * functions.
 */
public class CryptoClient {

    /**
     * Encrypts an encoded message by ECIES with a public key on the secp256k1 curve.
     *
     * @param publicKey encoded public key.
     * @param message encoded message to encrypt.
     * @return CryptoResult containing data for encryptedData.
     * @throws WedprException if any error occurred.
     */
    public CryptoResult secp256k1EciesEncrypt(String publicKey, String message)
            throws WedprException {
        return NativeInterface.secp256k1EciesEncrypt(publicKey, message).expectNoError();
    }

    /**
     * Decrypts an encoded encryptedData by ECIES with a private key on the secp256k1 curve.
     *
     * @param privateKey encoded private key.
     * @param encryptedData encoded ciphertext to decrypt.
     * @return CryptoResult containing data for decryptedData.
     * @throws WedprException if any error occurred.
     */
    public CryptoResult secp256k1EciesDecrypt(String privateKey, String encryptedData)
            throws WedprException {
        return NativeInterface.secp256k1EciesDecrypt(privateKey, encryptedData).expectNoError();
    }

    /**
     * Generates a new key pair for signature algorithm on the secp256k1 curve.
     *
     * @return CryptoResult containing data for publicKey, privateKey.
     * @throws WedprException if any error occurred.
     */
    public CryptoResult secp256k1GenKeyPair() throws WedprException {
        return NativeInterface.secp256k1GenKeyPair().expectNoError();
    }

    /**
     * Signs a message hash with the private key on the secp256k1 curve.
     *
     * @param privateKey encoded private key.
     * @param messageHash encoded hash of a message to sign.
     * @return CryptoResult containing data for signature.
     * @throws WedprException if any error occurred.
     */
    public CryptoResult secp256k1Sign(String privateKey, String messageHash) throws WedprException {
        return NativeInterface.secp256k1Sign(privateKey, messageHash).expectNoError();
    }

    /**
     * Verifies a message hash with the public key on the secp256k1 curve.
     *
     * @param publicKey encoded public key.
     * @param messageHash encoded hash of a message to verify.
     * @param signature encoded signature
     * @return CryptoResult containing data for booleanResult.
     * @throws WedprException if any error occurred.
     */
    public CryptoResult secp256k1Verify(String publicKey, String messageHash, String signature)
            throws WedprException {
        return NativeInterface.secp256k1Verify(publicKey, messageHash, signature).expectNoError();
    }

    /**
     * Generates a keccak256 hash string from a bytes array of any length.
     *
     * @param message
     * @return CryptoResult containing data for hash.
     * @throws WedprException if any error occurred.
     */
    public CryptoResult keccak256Hash(String message) throws WedprException {
        return NativeInterface.keccak256Hash(message).expectNoError();
    }
}
