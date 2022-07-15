// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.vcl;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by VCL client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class VclResult extends WedprResult {
    public String confidentialCredit;
    public String ownerSecret;
    public String proof;
    public boolean verificationResult;

    /** Expects no error occurred, otherwise throws an Exception. */
    public VclResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }
}
