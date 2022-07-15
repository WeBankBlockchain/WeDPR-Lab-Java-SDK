// Copyright 2022 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.acv;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by VCL client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class VoterResult extends WedprResult {
    public String voter_secret;
    public String  registration_blinding_point;
    public String registration_request;
    public String vote_request;

    /** Expects no error occurred, otherwise throws an Exception. */
    public VoterResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }
}