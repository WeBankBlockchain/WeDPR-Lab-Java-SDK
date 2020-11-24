// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.selectivedisclosure;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.common.WedprResult;

/**
 * Result class used by selective disclosure client.
 *
 * <p>This is an easy way to return multiple data from a single JNI interface.
 */
public class VerifierResult extends WedprResult {
  public String revealedAttributeInfo;
  public boolean result;

  /** Expects no error occurred, otherwise throws an Exception. */
  public VerifierResult expectNoError() throws WedprException {
    if (hasError()) {
      throw new WedprException(wedprErrorMessage);
    }
    return this;
  }
}
