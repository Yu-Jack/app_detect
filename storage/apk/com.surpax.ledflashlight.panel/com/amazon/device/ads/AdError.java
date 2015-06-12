// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public final class AdError
{
    private final AdError$ErrorCode code;
    private final String message;
    
    AdError(final AdError$ErrorCode code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    public final AdError$ErrorCode getCode() {
        return this.code;
    }
    
    public final String getMessage() {
        return this.message;
    }
}
