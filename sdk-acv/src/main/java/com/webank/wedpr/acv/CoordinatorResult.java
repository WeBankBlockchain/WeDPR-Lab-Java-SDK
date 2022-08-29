// Copyright 2022 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.acv;

import com.google.protobuf.InvalidProtocolBufferException;
import com.webank.wedpr.acv.proto.DecryptedResultPartStorage;
import com.webank.wedpr.acv.proto.PollParametersStorage;
import com.webank.wedpr.acv.proto.RegistrationResponse;
import com.webank.wedpr.acv.proto.VoteResultStorage;
import com.webank.wedpr.acv.proto.VoteStorage;
import com.webank.wedpr.common.Utils;
import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by VCL client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class CoordinatorResult extends WedprResult {
    public String poll_parameters;
    public String registration_response;
    public String vote_sum;
    public String aggregated_decrypted_result;
    public String vote_result;

    /** Expects no error occurred, otherwise throws an Exception. */
    public CoordinatorResult expectNoError() throws WedprException {
        if (hasError()) {
            throw new WedprException(wedprErrorMessage);
        }
        return this;
    }

    public String getPoll_parameters() {
        return poll_parameters;
    }

    public void setPoll_parameters(String poll_parameters) {
        this.poll_parameters = poll_parameters;
    }

    public String getRegistration_response() {
        return registration_response;
    }

    public void setRegistration_response(String registration_response) {
        this.registration_response = registration_response;
    }

    public String getVote_sum() {
        return vote_sum;
    }

    public void setVote_sum(String vote_sum) {
        this.vote_sum = vote_sum;
    }

    public String getAggregated_decrypted_result() {
        return aggregated_decrypted_result;
    }

    public void setAggregated_decrypted_result(String aggregated_decrypted_result) {
        this.aggregated_decrypted_result = aggregated_decrypted_result;
    }

    public String getVote_result() {
        return vote_result;
    }

    public void setVote_result(String vote_result) {
        this.vote_result = vote_result;
    }

    public PollParametersStorage getPollParameters() throws InvalidProtocolBufferException
    {
        if(poll_parameters.isEmpty())
        {
            return null;
        }
            return PollParametersStorage.parseFrom(Utils.stringToBytes(poll_parameters));
    }

    public RegistrationResponse getRegistrationResponse()throws InvalidProtocolBufferException
    {
        if(registration_response.isEmpty())
        {
            return null;
        }
        return RegistrationResponse.parseFrom(Utils.stringToBytes(registration_response));
    }

    public VoteStorage getVoteSum() throws InvalidProtocolBufferException
    {
        if(vote_sum.isEmpty())
        {
            return null;
        }
        return VoteStorage.parseFrom(Utils.stringToBytes(vote_sum));
    }

    public DecryptedResultPartStorage getAggregatedDecryptedResult() throws InvalidProtocolBufferException
    {
    if(aggregated_decrypted_result.isEmpty())
    {
        return null;
    }
    return DecryptedResultPartStorage.parseFrom(Utils.stringToBytes(aggregated_decrypted_result));
    }

    public VoteResultStorage getVoteResult() throws InvalidProtocolBufferException
    {
        if(vote_result.isEmpty())
        {
            return null;
        }
        return VoteResultStorage.parseFrom(Utils.stringToBytes(vote_result));
    }
}