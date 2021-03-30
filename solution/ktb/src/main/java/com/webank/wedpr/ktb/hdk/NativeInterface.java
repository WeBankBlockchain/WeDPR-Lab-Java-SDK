// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.ktb.hdk;

import com.webank.wedpr.common.NativeUtils;
import java.io.IOException;

/** Native interface for HDK client. */
public class NativeInterface {

  static {
    try {
      // Load the dynamic library of HDK on different operating systems.
      String osName = System.getProperty("os.name").toLowerCase();
      String libPathInJar;
      if (osName.contains("windows")) {
        libPathInJar = "/WeDPR_dynamic_lib/ffi_java_ktb.dll";
      } else if (osName.contains("linux")) {
        libPathInJar = "/WeDPR_dynamic_lib/libffi_java_ktb.so";
      } else if (osName.contains("mac")) {
        libPathInJar = "/WeDPR_dynamic_lib/libffi_java_ktb.dylib";
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
  public static native HdkResult createMnemonicEn(int wordCount);

  public static native HdkResult createMasterKeyEn(String password, String mnemonic);

  public static native HdkResult deriveExtendedKey(
      String masterKey, int purposeType, int assetType, int account, int change, int addressIndex);
}
