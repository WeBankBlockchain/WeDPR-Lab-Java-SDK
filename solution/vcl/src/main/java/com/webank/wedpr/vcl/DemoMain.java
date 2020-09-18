// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.vcl;

import com.webank.wedpr.common.WedprException;

/**
 * Minimalist demo of verifiable confidential ledger (VCL).
 *
 * <p>For a better interactive demo, please try our Rust version at
 * https://github.com/WeBankBlockchain/WeDPR-Lab-Core
 */
public class DemoMain {

  public static void main(String[] args) throws Exception {
    VclClient vclClient = new VclClient();

    runVclProofs(vclClient, 2, 2, 4);
    runVclProofs(vclClient, 3, 4, 12);
    runVclProofs(vclClient, 1, 2, 3);
    runVclProofs(vclClient, 3, 4, 5);
    runVclProofs(vclClient, -1, 4, 3);
  }

  private static void runVclProofs(VclClient vclClient, long c1Value, long c2Value, long c3Value)
      throws WedprException {
    System.out.println("\n*******\nVCL PROOF RUN\n*******");
    System.out.println(
        "c1_value = " + c1Value + ", c2_value = " + c2Value + ", c3_value = " + c3Value + "\n");

    if (c1Value < 0 || c2Value < 0 || c3Value < 0) {
      System.out.println(
          "[WARNING] Non-positive value detected.\n"
              + "All the balance proofs (sum and product) will fail intentionally.\n");
    }

    // Create confidential credit records for those values.
    VclResult c1Result = vclClient.makeCredit(c1Value);
    System.out.println("c1_credit (publicly verifiable) = " + c1Result.confidentialCredit);
    System.out.println("c1_secret (only known by the owner) = " + c1Result.ownerSecret);

    VclResult c2Result = vclClient.makeCredit(c2Value);
    System.out.println("c2_credit (publicly verifiable) = " + c2Result.confidentialCredit);
    System.out.println("c2_secret (only known by the owner) = " + c2Result.ownerSecret);

    VclResult c3Result = vclClient.makeCredit(c3Value);
    System.out.println("c3_credit (publicly verifiable) = " + c3Result.confidentialCredit);
    System.out.println("c3_secret (only known by the owner) = " + c3Result.ownerSecret);

    // Prove c1_value + c2_value = c3_value.
    VclResult sumResult =
        vclClient.proveSumBalance(c1Result.ownerSecret, c2Result.ownerSecret, c3Result.ownerSecret);
    System.out.println(
        "\nproof of " + c1Value + " + " + c2Value + " =? " + c3Value + ":\n" + sumResult.proof);

    VclResult verifySumResult =
        vclClient.verifySumBalance(
            c1Result.confidentialCredit,
            c2Result.confidentialCredit,
            c3Result.confidentialCredit,
            sumResult.proof);
    if (verifySumResult.verificationResult) {
      System.out.println(">> Pass: " + c1Value + " + " + c2Value + " == " + c3Value);
    } else {
      System.out.println("<< Fail: " + c1Value + " + " + c2Value + " != " + c3Value);
    }

    // Prove c1_value * c2_value = c3_value.
    VclResult productResult =
        vclClient.proveProductBalance(
            c1Result.ownerSecret, c2Result.ownerSecret, c3Result.ownerSecret);
    System.out.println(
        "\nproof of " + c1Value + " * " + c2Value + " =? " + c3Value + ":\n" + productResult.proof);

    VclResult verifyMultiResult =
        vclClient.verifyProductBalance(
            c1Result.confidentialCredit,
            c2Result.confidentialCredit,
            c3Result.confidentialCredit,
            productResult.proof);
    if (verifyMultiResult.verificationResult) {
      System.out.println(">> Pass: " + c1Value + " * " + c2Value + " == " + c3Value);
    } else {
      System.out.println("<< Fail: " + c1Value + " * " + c2Value + " != " + c3Value);
    }

    // Prove c1_value in [0, 2^32-1].
    VclResult rangeResult = vclClient.proveRange(c1Result.ownerSecret);
    System.out.println("\nproof of " + c1Value + " in [0, 2^32-1]:\n" + productResult.proof);

    VclResult verifyRangeResult =
        vclClient.verifyRange(c1Result.confidentialCredit, rangeResult.proof);
    if (verifyRangeResult.verificationResult) {
      System.out.println(">> Pass: " + c1Value + " in [0, 2^32-1]");
    } else {
      System.out.println("<< Fail: " + c1Value + " not in [0, 2^32-1]");
    }
  }
}
