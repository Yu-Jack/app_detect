// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public enum AdError$ErrorCode
{
    INTERNAL_ERROR("INTERNAL_ERROR", 3), 
    NETWORK_ERROR("NETWORK_ERROR", 0), 
    NETWORK_TIMEOUT("NETWORK_TIMEOUT", 1), 
    NO_FILL("NO_FILL", 2), 
    REQUEST_ERROR("REQUEST_ERROR", 4);
    
    private AdError$ErrorCode(final String name, final int ordinal) {
    }
}
