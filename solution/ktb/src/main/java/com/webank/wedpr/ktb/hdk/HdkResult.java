// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.ktb.hdk;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by HDK client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class HdkResult extends WedprResult {
    public String mnemonic;
    public String masterKey;
    public String extendedPrivateKey;
    public String extendedPublicKey;

    /** Expects no error occurred, otherwise throws an Exception. */
    public HdkResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }
}
