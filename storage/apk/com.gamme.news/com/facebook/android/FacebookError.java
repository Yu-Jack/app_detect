// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.android;

public class FacebookError extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    private int mErrorCode;
    private String mErrorType;
    
    public FacebookError(final String message) {
        super(message);
        this.mErrorCode = 0;
    }
    
    public FacebookError(final String message, final String mErrorType, final int mErrorCode) {
        super(message);
        this.mErrorCode = 0;
        this.mErrorType = mErrorType;
        this.mErrorCode = mErrorCode;
    }
    
    @Deprecated
    public int getErrorCode() {
        return this.mErrorCode;
    }
    
    @Deprecated
    public String getErrorType() {
        return this.mErrorType;
    }
}
