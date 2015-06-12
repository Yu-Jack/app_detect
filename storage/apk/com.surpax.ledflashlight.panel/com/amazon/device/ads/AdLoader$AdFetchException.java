// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public class AdLoader$AdFetchException extends Exception
{
    private static final long serialVersionUID = 1L;
    private final AdError adError;
    final /* synthetic */ AdLoader this$0;
    
    public AdLoader$AdFetchException(final AdLoader this$0, final AdError adError) {
        this.this$0 = this$0;
        this.adError = adError;
    }
    
    public AdLoader$AdFetchException(final AdLoader this$0, final AdError adError, final Throwable cause) {
        this.this$0 = this$0;
        super(cause);
        this.adError = adError;
    }
    
    public AdError getAdError() {
        return this.adError;
    }
}
