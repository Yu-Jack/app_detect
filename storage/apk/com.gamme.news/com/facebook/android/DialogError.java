// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.android;

public class DialogError extends Throwable
{
    private static final long serialVersionUID = 1L;
    private int mErrorCode;
    private String mFailingUrl;
    
    public DialogError(final String message, final int mErrorCode, final String mFailingUrl) {
        super(message);
        this.mErrorCode = mErrorCode;
        this.mFailingUrl = mFailingUrl;
    }
    
    @Deprecated
    public int getErrorCode() {
        return this.mErrorCode;
    }
    
    @Deprecated
    public String getFailingUrl() {
        return this.mFailingUrl;
    }
}
