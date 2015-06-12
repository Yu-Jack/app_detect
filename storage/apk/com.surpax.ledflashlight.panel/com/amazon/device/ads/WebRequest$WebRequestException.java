// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public class WebRequest$WebRequestException extends Exception
{
    private static final long serialVersionUID = -4980265484926465548L;
    private final WebRequest$WebRequestStatus status;
    final /* synthetic */ WebRequest this$0;
    
    protected WebRequest$WebRequestException(final WebRequest webRequest, final WebRequest$WebRequestStatus webRequest$WebRequestStatus, final String s) {
        this(webRequest, webRequest$WebRequestStatus, s, null);
    }
    
    protected WebRequest$WebRequestException(final WebRequest this$0, final WebRequest$WebRequestStatus status, final String message, final Throwable cause) {
        this.this$0 = this$0;
        super(message, cause);
        this.status = status;
    }
    
    public WebRequest$WebRequestStatus getStatus() {
        return this.status;
    }
}
