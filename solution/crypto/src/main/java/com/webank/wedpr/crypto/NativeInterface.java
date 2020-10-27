// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.crypto;

import com.webank.wedpr.common.NativeUtils;
import java.io.IOException;

/** Native interface for Crypto client. */
public class NativeInterface {

  static {
    try {
      // Load the dynamic library of Crypto on different operating systems.
      String osName = System.getProperty("os.name").toLowerCase();
      String libPathInJar;
      if (osName.contains("windows")) {
        libPathInJar = "/WeDPR_dynamic_lib/ffi_java_crypto.dll";
      } else if (osName.contains("linux")) {
        libPathInJar = "/WeDPR_dynamic_lib/libffi_java_crypto.so";
      } else if (osName.contains("mac")) {
        libPathInJar = "/WeDPR_dynamic_lib/libffi_java_crypto.dylib";
      } else {
        throw new IOException(String.format("Operating system %s is not supported.", osName));
      }
      NativeUtils.loadLibraryFromJar(libPathInJar);
    } catch (IOException e) {
      // TODO: Provide more instructions on resolving dynamic library loading errors.
      throw new RuntimeException(e);
    }
  }

  // JNI function section.
  public static native CryptoResult secp256k1EciesEncrypt(String publicKey, String message);

  public static native CryptoResult secp256k1EciesDecrypt(String privateKey, String encryptedData);

  public static native CryptoResult secp256k1GenKeyPair();

  public static native CryptoResult secp256k1Sign(String privateKey, String messageHash);

  public static native CryptoResult secp256k1Verify(
      String publicKey, String messageHash, String signature);

  public static native CryptoResult keccak256Hash(String message);
}
