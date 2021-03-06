// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.demo;

import com.webank.wedpr.crypto.CryptoClient;
import com.webank.wedpr.ktb.hdk.HdkClient;
import com.webank.wedpr.scd.IssuerClient;
import com.webank.wedpr.scd.UserClient;
import com.webank.wedpr.scd.VerifierClient;
import com.webank.wedpr.vcl.VclClient;

/** Demo Launcher. */
public class DemoMain {

  public static void main(String[] args) throws Exception {
    CryptoClient cryptoClient = new CryptoClient();
    CryptoDemo.run(cryptoClient);

    VclClient vclClient = new VclClient();
    VclDemo.run(vclClient, 2, 2, 4);
    VclDemo.run(vclClient, 3, 4, 12);
    VclDemo.run(vclClient, 1, 2, 3);
    VclDemo.run(vclClient, 3, 4, 5);
    VclDemo.run(vclClient, -1, 4, 3);

    IssuerClient issuerClient = new IssuerClient();
    UserClient userClient = new UserClient();
    VerifierClient verifierClient = new VerifierClient();
    ScdDemo.run(issuerClient, userClient, verifierClient);

    HdkClient hdkClient = new HdkClient();
    KtbDemo.run(hdkClient);
  }
}
