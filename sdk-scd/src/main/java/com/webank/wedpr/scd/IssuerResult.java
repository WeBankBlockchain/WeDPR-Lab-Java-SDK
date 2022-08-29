// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.scd;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by a SCD certificate issuer.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class IssuerResult extends WedprResult {
    public String certificateTemplate;
    public String templatePrivateKey;
    public String certificateSignature;
    public String issuerNonce;

    /** Expects no error occurred, otherwise throws an Exception. */
    public IssuerResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }
}
