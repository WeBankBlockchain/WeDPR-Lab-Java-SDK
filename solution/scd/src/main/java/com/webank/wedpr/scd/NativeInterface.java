// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.scd;

import com.webank.wedpr.common.NativeUtils;
import com.webank.wedpr.common.WedprException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/** Native interface for SCD client. */
public class NativeInterface {

  public static final String WEDPR_SCD_LIB_PATH;
  public static final String LIBSSL_1_1 = "libssl.so.1.1";
  public static final String LIBSSL_1_0 = "libssl.so.10";

  static {
    try {
      String osName = System.getProperty("os.name").toLowerCase();
      if (osName.contains("windows")) {
        WEDPR_SCD_LIB_PATH = "/WeDPR_dynamic_lib/ffi_java_scd.dll";
        NativeUtils.loadLibraryFromJar("/WeDPR_dynamic_lib/libeay32md.dll");
        NativeUtils.loadLibraryFromJar("/WeDPR_dynamic_lib/ssleay32md.dll");
      } else if (osName.contains("linux")) {
        if (hasLibsslVersion(LIBSSL_1_0)) {
          WEDPR_SCD_LIB_PATH = "/WeDPR_dynamic_lib/libffi_java_scd_libssl_1_0.so";
        } else if (hasLibsslVersion(LIBSSL_1_1)) {
          WEDPR_SCD_LIB_PATH = "/WeDPR_dynamic_lib/libffi_java_scd_libssl_1_1.so";
        } else {
          throw new WedprException("Linux requires " + LIBSSL_1_1 + " or " + LIBSSL_1_0);
        }
      } else if (osName.contains("mac")) {
        WEDPR_SCD_LIB_PATH = "/WeDPR_dynamic_lib/libffi_java_scd.dylib";
      } else {
        throw new IOException(String.format("Operating system %s is not supported.", osName));
      }
      NativeUtils.loadLibraryFromJar(WEDPR_SCD_LIB_PATH);
    } catch (IOException | WedprException e) {
      throw new RuntimeException(e);
    }
  }

  private static boolean hasLibsslVersion(String libsslVersion)
      throws IOException, UnsupportedEncodingException {
    Process process = Runtime.getRuntime().exec("locate " + libsslVersion);
    InputStream inputStream = process.getInputStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    String version = bufferedReader.readLine();
    return version != null;
  }

  public static native IssuerResult issuerMakeCertificateTemplate(String schema);

  public static native IssuerResult issuerSignCertificate(
      String certificateTemplate,
      String templatePrivateKey,
      String signRequest,
      String userId,
      String userNonce);

  public static native UserResult userFillCertificate(
      String attributeDict, String certificateTemplate);

  public static native UserResult userBlindCertificateSignature(
      String certificateSignature,
      String attributeDict,
      String certificateTemplate,
      String userPrivateKey,
      String certificateSecretsBlindingFactors,
      String issuerNonce);

  public static native UserResult userProveSelectiveDisclosure(
      String ruleSet,
      String certificateSignature,
      String attributeDict,
      String certificateTemplate,
      String userPrivateKey,
      String verificationNonce);

  public static native VerifierResult verifierVerifySelectiveDisclosure(
      String ruleSet, String verifyRequest);

  public static native VerifierResult verifierGetRevealedAttributes(String verifyRequest);

  public static native VerifierResult verifierGetVerificationNonce();
}
