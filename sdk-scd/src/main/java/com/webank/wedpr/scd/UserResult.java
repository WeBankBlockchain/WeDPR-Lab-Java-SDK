// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.scd;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by a SCD certificate user.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class UserResult extends WedprResult {
    public String signCertificateRequest;
    public String userPrivateKey;
    public String certificateSecretsBlindingFactors;
    public String userNonce;
    public String certificateSignature;
    public String verifyRequest;

    /** Expects no error occurred, otherwise throws an Exception. */
    public UserResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }
}
