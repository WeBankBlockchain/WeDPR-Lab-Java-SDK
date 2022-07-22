// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.scd;

import com.google.protobuf.Message;
import com.webank.wedpr.common.Utils;
import com.webank.wedpr.scd.proto.AttributeDict;
import com.webank.wedpr.scd.proto.StringToStringPair;
import java.util.Map;

/** Base client class used by SCD. */
abstract class ScdClient {
    /**
     * Encodes a filled attribute KV map to a String.
     *
     * @param attributeDictInput the KV map containing the filled data of a certificate.
     * @return the encoded string for attributeDictInput.
     */
    public String encodeAttributeDict(Map<String, String> attributeDictInput) {
        AttributeDict attributeDict = AttributeDict.getDefaultInstance();
        for (Map.Entry<String, String> entry : attributeDictInput.entrySet()) {
            StringToStringPair pair =
                    StringToStringPair.newBuilder()
                            .setKey(entry.getKey())
                            .setValue(entry.getValue())
                            .build();
            attributeDict = attributeDict.toBuilder().addPair(pair).build();
        }
        return protoToEncodedString(attributeDict);
    }

    /**
     * Encodes a Protobuf object to a String.
     *
     * @param message the Protobuf object.
     * @return the encoded string of message.
     */
    public String protoToEncodedString(Message message) {
        return Utils.bytesToString(message.toByteArray());
    }
}
