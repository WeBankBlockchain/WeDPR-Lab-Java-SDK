// Copyright 2022 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.acv;

import com.webank.wedpr.common.NativeUtils;
import java.io.IOException;
import com.webank.wedpr.acv.CoordinatorResult;
import com.webank.wedpr.acv.CounterResult;
import com.webank.wedpr.acv.VerifierResult;
import com.webank.wedpr.acv.VoterResult;

public class NativeInterface
{
    private static final String LIB_NAME = "WeDPR_dynamic_lib/";
    static {
        try {
            // Load the dynamic library of VCL on different operating systems.
            String osName = System.getProperty("os.name").toLowerCase();
            String libPostFix;
            if (osName.contains("windows")) {
                libPostFix = "ffi_java_acv.dll";
            } else if (osName.contains("linux")) {
                libPostFix = "libffi_java_acv.so";
            } else if (osName.contains("mac")) {
                libPostFix = "libffi_java_acv.dylib";
            } else {
                throw new IOException(
                        String.format("Operating system %s is not supported.", osName));
            }
            String libPathInJar = LIB_NAME + libPostFix;
            NativeUtils.loadLibrary(libPathInJar);
        } catch (IOException e) {
            // TODO: Provide more instructions on resolving dynamic library loading errors.
            throw new RuntimeException(e);
        }
    }
    // coordinator related interfaces
    public static native CoordinatorResult makePollParameters(String candidateList, String counterParameters);
    public static native CoordinatorResult certifyVoter(String secretKey, String registrationRequest);
    public static native CoordinatorResult certifyUnboundedVoter(String secretKey, String registrationRequest);
    public static native CoordinatorResult aggregateVoteSumResponse(String pollParameters, String votePart, String voteSum);
    public static native CoordinatorResult aggregateVoteSumResponseUnlisted(String pollParameters, String votePart, String voteSum);
    public static native CoordinatorResult aggregateDecryptedPartSum(String pollParameters, String partiallyDecryptedResult, String aggregatedDecryptedResult);
    public static native CoordinatorResult aggregateDecryptedPartSumUnlisted(String pollParameters, String partiallyDecryptedResult, String aggregatedDecryptedResult);
    public static native CoordinatorResult finalizeVoteResult(String poolParameters, String voterSum, String aggregatedDecryptedResult, long maxVoteLimit);
    public static native CoordinatorResult finalizeVoteResultUnlisted(String pollParameters, String voteSum, String aggregatedDecryptedResult, long maxVoteLimit, long maxCandidateNum);

    // counter related interfaces
    public static native CounterResult makeCounterSecret();
    public static native CounterResult makeCounterParametersShare(String counterID, String counterSecret);
    public static native CounterResult count(String counterID, String counterSecret, String encryptedVoteSum);
    public static native CounterResult countUnlisted(String counterID, String counterSecret, String encryptedVoteSum);

    // verifier related interfaces
    public static native VerifierResult verifyVoteRequest(String pollParameters, String voteRequest, String publicKey);
    public static native VerifierResult verifyUnboundedVoteRequest(String pollParameters, String voteRequest, String publicKey);
    public static native VerifierResult verifyUnboundedVoteRequestUnlisted(String pollParameters, String voteRequest, String publicKey);
    public static native VerifierResult verifyCountRequest(String pollParameter, String encryptedVoteSum, String counterShared, String partiallyDecryptedResult);
    public static native VerifierResult verifyCountRequestUnlisted(String pollParameter, String encryptedVoteSum, String counterShared, String partiallyDecryptedResult);
    public static native VerifierResult verifyVoteResult(String pollParameters, String voteSum, String aggregatedDecryptedResult, String voteResult);

    // voter related interfaces
    public static native VoterResult makeVoterSecret();
    public static native VoterResult generateRegistrationBlindingPoint(String voteSecret, String pollParameters);
    public static native VoterResult makeUnboundedRegistrationRequest(String zeroSecret, String voteSecret, String pollParameters);
    public static native VoterResult vote(String voteSecret, String voteChoices, String registrationResponse, String pollParameters);
    public static native VoterResult voteUnbounded(String voteSecret, String zeroSecret, String voteChoices, String registrationResponse, String pollParameters);
    public static native VoterResult voteUnboundedUnlisted(String voteSecret, String zeroSecret, String voteChoices, String registrationResponse, String pollParameters);
}