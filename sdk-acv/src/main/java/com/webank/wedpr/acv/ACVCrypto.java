package com.webank.wedpr.acv;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.webank.wedpr.acv.NativeInterface;
import com.webank.wedpr.acv.proto.Acv;
import com.webank.wedpr.acv.proto.Ballot;
import com.webank.wedpr.acv.proto.CandidateList;
import com.webank.wedpr.acv.proto.CounterSecret;
import com.webank.wedpr.acv.proto.DecryptedResultPartStorage;
import com.webank.wedpr.acv.proto.PollParametersStorage;
import com.webank.wedpr.acv.proto.RegistrationBlindingPoint;
import com.webank.wedpr.acv.proto.RegistrationRequest;
import com.webank.wedpr.acv.proto.RegistrationResponse;
import com.webank.wedpr.acv.proto.VoteChoice;
import com.webank.wedpr.acv.proto.VoteRequest;
import com.webank.wedpr.acv.proto.VoteResultStorage;
import com.webank.wedpr.acv.proto.VoteStorage;
import com.webank.wedpr.acv.proto.VoterSecret;
import com.webank.wedpr.common.Utils;
import com.webank.wedpr.common.WedprException;

public class ACVCrypto
{

    private static NativeInterface nativeInterface;

    // coordinator related interfaces
    public static CoordinatorResult makePollParameters(CandidateList candidateList, PollParametersStorage counterParameters)
    {
        return nativeInterface.makePollParameters(Utils.bytesToString(candidateList.toByteArray()), Utils.bytesToString(counterParameters.toByteArray()));
    }

    public static CoordinatorResult certifyVoter(String secretKey, RegistrationRequest registrationRequest)
    {
    return nativeInterface.certifyVoter(secretKey, Utils.bytesToString(registrationRequest.toByteArray()));
    }

    public static CoordinatorResult certifyUnboundedVoter(String secretKey, RegistrationRequest registrationRequest)
    {
    return nativeInterface.certifyUnboundedVoter(secretKey, Utils.bytesToString(registrationRequest.toByteArray()));
    }

    public static CoordinatorResult aggregateVoteSumResponse(PollParametersStorage pollParameters, VoteStorage votePart, VoteStorage voteSum)
    {
    return nativeInterface.aggregateVoteSumResponse(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(votePart.toByteArray()), Utils.bytesToString(voteSum.toByteArray()));
    }


    public static CoordinatorResult aggregateVoteSumResponseUnlisted(PollParametersStorage pollParameters, VoteStorage votePart, VoteStorage voteSum)
    {
    return nativeInterface.aggregateVoteSumResponseUnlisted(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(votePart.toByteArray()), Utils.bytesToString(voteSum.toByteArray()));
    }

    public static CoordinatorResult aggregateDecryptedPartSum(PollParametersStorage pollParameters, DecryptedResultPartStorage partiallyDecryptedResult, DecryptedResultPartStorage aggregatedDecryptedResult)
    {
    return nativeInterface.aggregateDecryptedPartSum(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(partiallyDecryptedResult.toByteArray()), Utils.bytesToString(aggregatedDecryptedResult.toByteArray()));
    }

    public static CoordinatorResult aggregateDecryptedPartSumUnlisted(PollParametersStorage pollParameters, DecryptedResultPartStorage partiallyDecryptedResult, DecryptedResultPartStorage aggregatedDecryptedResult)
    {
    return nativeInterface.aggregateDecryptedPartSumUnlisted(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(partiallyDecryptedResult.toByteArray()), Utils.bytesToString(aggregatedDecryptedResult.toByteArray()));
    }

    public static CoordinatorResult finalizeVoteResult(PollParametersStorage pollParameters, VoteStorage voteSum, DecryptedResultPartStorage aggregatedDecryptedResult, long maxVoteLimit)
    {
    return nativeInterface.finalizeVoteResult(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(voteSum.toByteArray()), Utils.bytesToString(aggregatedDecryptedResult.toByteArray()), maxVoteLimit);
    }
    public static CoordinatorResult finalizeVoteResultUnlisted(PollParametersStorage pollParameters, VoteStorage voteSum, DecryptedResultPartStorage aggregatedDecryptedResult, long maxVoteLimit, long maxCandidateNum)
    {
    return nativeInterface.finalizeVoteResultUnlisted(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(voteSum.toByteArray()), Utils.bytesToString(aggregatedDecryptedResult.toByteArray()), maxVoteLimit, maxCandidateNum);
    }

    // counter related interfaces
    public static CounterResult makeCounterSecret()
    {
    return nativeInterface.makeCounterSecret();
    }

    public static CounterResult makeCounterParametersShare(String counterID, CounterSecret counterSecret)
    {
    return nativeInterface.makeCounterParametersShare(counterID, Utils.bytesToString(counterSecret.toByteArray()));
    }

    public static CounterResult count(String counterID, CounterSecret counterSecret, VoteStorage encryptedVoteSum)
    {
    return nativeInterface.count(counterID, Utils.bytesToString(counterSecret.toByteArray()), Utils.bytesToString(encryptedVoteSum.toByteArray()));
    }
    public static CounterResult countUnlisted(String counterID, CounterSecret counterSecret, VoteStorage encryptedVoteSum)
    {
    return nativeInterface.countUnlisted(counterID, Utils.bytesToString(counterSecret.toByteArray()), Utils.bytesToString(encryptedVoteSum.toByteArray()));
    }

    /// verifier related interfaces
    public static VerifierResult verifyVoteRequest(PollParametersStorage pollParameters, VoteRequest voteRequest, String publicKey)
    {
        return nativeInterface.verifyVoteRequest(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(voteRequest.toByteArray()), publicKey);
    }
    public static VerifierResult verifyUnboundedVoteRequest(PollParametersStorage pollParameters, VoteRequest voteRequest, String publicKey)
    {
    return nativeInterface.verifyUnboundedVoteRequest(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(voteRequest.toByteArray()), publicKey);
    }
    public static VerifierResult verifyUnboundedVoteRequestUnlisted(PollParametersStorage pollParameters, VoteRequest voteRequest, String publicKey)
    {
        return nativeInterface.verifyUnboundedVoteRequestUnlisted(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(voteRequest.toByteArray()), publicKey);
    }
    public static VerifierResult verifyCountRequest(PollParametersStorage pollParameters, VoteStorage encryptedVoteSum, String counterShared, DecryptedResultPartStorage partiallyDecryptedResult)
    {
    return nativeInterface.verifyCountRequest(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(encryptedVoteSum.toByteArray()), counterShared, Utils.bytesToString(partiallyDecryptedResult.toByteArray()));
    }
    public static VerifierResult verifyCountRequestUnlisted(PollParametersStorage pollParameters, VoteStorage encryptedVoteSum, String counterShared, DecryptedResultPartStorage partiallyDecryptedResult)
    {
        return nativeInterface.verifyCountRequestUnlisted(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(encryptedVoteSum.toByteArray()), counterShared, Utils.bytesToString(partiallyDecryptedResult.toByteArray()));

    }
    public static VerifierResult verifyVoteResult(PollParametersStorage pollParameters, VoteStorage voteSum, DecryptedResultPartStorage aggregatedDecryptedResult, VoteResultStorage voteResult)
    {
    return nativeInterface.verifyVoteResult(Utils.bytesToString(pollParameters.toByteArray()), Utils.bytesToString(voteSum.toByteArray()), Utils.bytesToString(aggregatedDecryptedResult.toByteArray()), Utils.bytesToString(voteResult.toByteArray()));
    }

    public static VerifierResult verifyBlankBallot(RegistrationRequest registrationRequest, RegistrationResponse registrationResponse)
    {
        return nativeInterface.verifyBlankBallot(Utils.bytesToString(registrationRequest.toByteArray()), Utils.bytesToString(registrationResponse.toByteArray()));
    }

    /// voter related interfaces
    public static VoterResult makeVoterSecret()
    {
        return nativeInterface.makeVoterSecret();
    }

    public static VoterResult generateRegistrationBlindingPoint(VoterSecret voterSecret, PollParametersStorage pollParameters)
    {
    return nativeInterface.generateRegistrationBlindingPoint(Utils.bytesToString(voterSecret.toByteArray()), Utils.bytesToString(pollParameters.toByteArray()));
    }
    public static VoterResult makeUnboundedRegistrationRequest(VoterSecret zeroSecret, VoterSecret voterSecret, PollParametersStorage pollParameters)
    {
        return nativeInterface.makeUnboundedRegistrationRequest(Utils.bytesToString(zeroSecret.toByteArray()), Utils.bytesToString(voterSecret.toByteArray()), Utils.bytesToString(pollParameters.toByteArray()));
    }
    public static VoterResult vote(VoterSecret voterSecret, VoteChoice voteChoice, RegistrationResponse registrationResponse, PollParametersStorage pollParameters)
    {
        return nativeInterface.vote(Utils.bytesToString(voterSecret.toByteArray()), Utils.bytesToString(voteChoice.toByteArray()), Utils.bytesToString(registrationResponse.toByteArray()), Utils.bytesToString(pollParameters.toByteArray()));
    }
    public static VoterResult voteUnbounded(VoterSecret voterSecret, VoterSecret zeroSecret, VoteChoice voteChoice, RegistrationResponse registrationResponse, PollParametersStorage pollParameters)
    {
    return nativeInterface.voteUnbounded(Utils.bytesToString(voterSecret.toByteArray()), Utils.bytesToString(zeroSecret.toByteArray()), Utils.bytesToString(voteChoice.toByteArray()), Utils.bytesToString(registrationResponse.toByteArray()), Utils.bytesToString(pollParameters.toByteArray()));
    }
    public static VoterResult voteUnboundedUnlisted(VoterSecret voterSecret, VoterSecret zeroSecret, VoteChoice voteChoice, RegistrationResponse registrationResponse, PollParametersStorage pollParameters)
    {
        return nativeInterface.voteUnboundedUnlisted(Utils.bytesToString(voterSecret.toByteArray()), Utils.bytesToString(zeroSecret.toByteArray()), Utils.bytesToString(voteChoice.toByteArray()), Utils.bytesToString(registrationResponse.toByteArray()), Utils.bytesToString(pollParameters.toByteArray()));
    }

    public static boolean verifyWeightBallot(int weightValue, byte[] weightBlindingPoint, byte[] weightBlindingPointG2, String voteRequest) throws InvalidProtocolBufferException, WedprException {
        RegistrationBlindingPoint weightPoint = RegistrationBlindingPoint.newBuilder().
                setBlindingPollPoint(ByteString.copyFrom(weightBlindingPoint)).
                setBlindingBasepointG2(ByteString.copyFrom(weightBlindingPointG2)).build();
        RegistrationRequest registrationRequest = RegistrationRequest.newBuilder().setWeightPoint(weightPoint).build();

        VoteRequest voteRequestPb = VoteRequest.parseFrom(Utils.stringToBytes(voteRequest));
        Ballot ballot =
                Ballot.newBuilder()
                        .setCiphertext1(voteRequestPb.getVote().getBlankBallot().getCiphertext1())
                        .setCiphertext2(voteRequestPb.getVote().getBlankBallot().getCiphertext2())
                        .build();

        RegistrationResponse registrationResponse =
                RegistrationResponse.newBuilder()
                        .setVoterWeight(weightValue)
                        .setBallot(ballot)
                        .build();

        VerifierResult verifierResult =
                ACVCrypto.verifyBlankBallot(
                        registrationRequest,
                        registrationResponse);
        if(verifierResult.hasError())
        {
            String errorMsg = "verifyWeightBallot error, error: " + verifierResult.wedprErrorMessage +
                "weightValue: " + weightValue + "voteRequest: " +  voteRequest;
            throw new WedprException(errorMsg);
        }
        return verifierResult.verifyResult;
    }
}