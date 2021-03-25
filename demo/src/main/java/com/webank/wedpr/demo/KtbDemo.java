// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.demo;

import com.webank.wedpr.ktb.hdk.HdkClient;
import com.webank.wedpr.ktb.hdk.HdkResult;

/** Minimalist demo of WeDPR Crypto Tools. */
public class KtbDemo {
  public static void run(HdkClient hdkClient) throws Exception {
    System.out.println("\n*******\nHDK DEMO RUN\n*******");

    HdkResult hdkResult = hdkClient.createMnemonicEn(24);
    String mnemonic = hdkResult.mnemonic;
    System.out.println("mnemonic = " + mnemonic);

    String password = "123456";
    hdkResult = hdkClient.createMasterKeyEn(password, mnemonic);
    String masterKey = hdkResult.masterKey;
    System.out.println("masterKey = " + masterKey);

    int purposeType = 44;
    int assetType = 513866;
    int account = 1;
    int change = 0;
    int addressIndex = 1000;

    hdkResult =
        hdkClient.deriveExtendedKey(
            masterKey, purposeType, assetType, account, change, addressIndex);
    String extendedPrivateKey = hdkResult.extendedPrivateKey;
    String extendedPublicKey = hdkResult.extendedPublicKey;
    System.out.println("extendedPrivateKey = " + extendedPrivateKey);
    System.out.println("extendedPublicKey = " + extendedPublicKey);
  }
}
