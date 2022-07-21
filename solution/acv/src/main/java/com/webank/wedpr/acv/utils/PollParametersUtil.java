package com.webank.wedpr.acv.utils;

import com.google.protobuf.ByteString;
import com.webank.wedpr.acv.proto.CandidateList;
import com.webank.wedpr.acv.proto.PollParametersStorage;
import com.webank.wedpr.common.Utils;

import java.util.List;

public class PollParametersUtil
{
    public static PollParametersStorage makePollParameters(byte[] pollPoint, List<String> candidateList)
    {
        PollParametersStorage.Builder builder = PollParametersStorage.newBuilder();
        builder.setPollPoint(ByteString.copyFrom(pollPoint));

        CandidateList.Builder candidateListBuilder = CandidateList.newBuilder();
        for(int i = 0; i < candidateList.size(); i++)
        {
            candidateListBuilder.addCandidate(candidateList.get(i));
        }
        builder.setCandidates(candidateListBuilder.build());
        return builder.build();
    }

    public static String makeStringPollParameters(byte[] pollPoint, List<String> candidateList)
    {
        PollParametersStorage pollParametersStorage = makePollParameters(pollPoint, candidateList);
        return Utils.bytesToString(pollParametersStorage.toByteArray());
    }
}