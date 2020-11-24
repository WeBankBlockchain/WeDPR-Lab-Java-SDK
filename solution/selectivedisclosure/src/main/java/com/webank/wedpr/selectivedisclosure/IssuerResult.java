// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.selectivedisclosure;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by selective disclosure client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class IssuerResult extends WedprResult {
  public String credentialTemplate;
  public String templateSecretKey;
  public String credentialSignature;
  public String issuerNonce;

  /** Expects no error occurred, otherwise throws an Exception. */
  public IssuerResult expectNoError() throws WedprException {
    if (hasError()) {
      throw new WedprException(wedprErrorMessage);
    }
    return this;
  }
}
