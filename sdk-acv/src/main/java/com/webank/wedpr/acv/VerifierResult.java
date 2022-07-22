// Copyright 2022 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.acv;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by VCL client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class VerifierResult extends WedprResult {
    public boolean verifyResult;

    /** Expects no error occurred, otherwise throws an Exception. */
    public VerifierResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }

    public boolean isVerifyResult() {
        return verifyResult;
    }

    public void setVerifyResult(boolean verifyResult) {
        this.verifyResult = verifyResult;
    }
}