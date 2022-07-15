// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.vcl;

import com.webank.wedpr.common.NativeUtils;
import java.io.IOException;

/** Native interface for VCL client. */
public class NativeInterface {

    static {
        try {
            // Load the dynamic library of VCL on different operating systems.
            String osName = System.getProperty("os.name").toLowerCase();
            String libPathInJar;
            if (osName.contains("windows")) {
                libPathInJar = "/WeDPR_dynamic_lib/ffi_java_vcl.dll";
            } else if (osName.contains("linux")) {
                libPathInJar = "/WeDPR_dynamic_lib/libffi_java_vcl.so";
            } else if (osName.contains("mac")) {
                libPathInJar = "/WeDPR_dynamic_lib/libffi_java_vcl.dylib";
            } else {
                throw new IOException(
                        String.format("Operating system %s is not supported.", osName));
            }
            NativeUtils.loadLibraryFromJar(libPathInJar);
        } catch (IOException e) {
            // TODO: Provide more instructions on resolving dynamic library loading errors.
            throw new RuntimeException(e);
        }
    }

    public static native VclResult makeCredit(long value);

    public static native VclResult proveSumBalance(
            String c1Secret, String c2Secret, String c3Secret);

    public static native VclResult verifySumBalance(
            String c1Credit, String c2Credit, String c3Credit, String proof);

    public static native VclResult proveProductBalance(
            String c1Secret, String c2Secret, String c3Secret);

    public static native VclResult verifyProductBalance(
            String c1Credit, String c2Credit, String c3Credit, String proof);

    public static native VclResult proveRange(String ownerSecret);

    public static native VclResult verifyRange(String confidentialCredit, String proof);
}
