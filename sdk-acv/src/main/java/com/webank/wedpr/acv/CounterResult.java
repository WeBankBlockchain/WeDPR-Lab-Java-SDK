// Copyright 2022 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.acv;

import com.google.protobuf.InvalidProtocolBufferException;
import com.webank.wedpr.acv.proto.CounterParametersShareRequest;
import com.webank.wedpr.acv.proto.CounterSecret;
import com.webank.wedpr.acv.proto.DecryptedResultPartStorage;
import com.webank.wedpr.common.Utils;
import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by VCL client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class CounterResult extends WedprResult {
    public String counter_secret;
    public String counter_parameters_share;
    public String counter_decrypted_result;

    /** Expects no error occurred, otherwise throws an Exception. */
    public CounterResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }

    public String getCounter_secret() {
        return counter_secret;
    }

    public void setCounter_secret(String counter_secret) {
        this.counter_secret = counter_secret;
    }

    public String getCounter_parameters_share() {
        return counter_parameters_share;
    }

    public void setCounter_parameters_share(String counter_parameters_share) {
        this.counter_parameters_share = counter_parameters_share;
    }

    public String getCounter_decrypted_result() {
        return counter_decrypted_result;
    }

    public void setCounter_decrypted_result(String counter_decrypted_result) {
        this.counter_decrypted_result = counter_decrypted_result;
    }

    public CounterSecret getCounterSecret() throws InvalidProtocolBufferException
    {
        if(counter_secret.isEmpty())
        {
            return null;
        }
        return CounterSecret.parseFrom(Utils.stringToBytes(counter_secret));
    }

    public CounterParametersShareRequest getCounterParametersShare() throws InvalidProtocolBufferException
    {
        if(counter_parameters_share.isEmpty())
        {
            return null;
        }
        return CounterParametersShareRequest.parseFrom(Utils.stringToBytes(counter_parameters_share));
    }
    public DecryptedResultPartStorage getCounterDecryptedResult() throws InvalidProtocolBufferException
    {
        if(counter_decrypted_result.isEmpty())
        {
            return null;
        }
        return DecryptedResultPartStorage.parseFrom(Utils.stringToBytes(counter_decrypted_result));
    }
}