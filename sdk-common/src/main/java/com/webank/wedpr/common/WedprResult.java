// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.common;

/** Base result class used by WeDPR Java SDK. */
public class WedprResult {
    public String wedprErrorMessage;

    /** Checks whether any error occurred. */
    public boolean hasError() {
        return wedprErrorMessage != null;
    }
}
