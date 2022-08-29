package com.webank.wedpr.common;

import java.util.*;

public class Utils {

    public static String bytesToString(byte[] param) {
        return Base64.getEncoder().encodeToString(param);
    }

    public static byte[] stringToBytes(String param) {
        return Base64.getDecoder().decode(param);
    }
}
