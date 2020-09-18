// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.common;

/** Base exception class used by WeDPR Java SDK. */
public class WedprException extends Exception {

  public WedprException() {
    super();
  }

  public WedprException(String message) {
    super(message);
  }

  public WedprException(Throwable cause) {
    super(cause);
  }
}
