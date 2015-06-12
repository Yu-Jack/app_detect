// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum SessionDefaultAudience
{
    EVERYONE("EVERYONE", 3, "EVERYONE"), 
    FRIENDS("FRIENDS", 2, "ALL_FRIENDS"), 
    NONE("NONE", 0, (String)null), 
    ONLY_ME("ONLY_ME", 1, "SELF");
    
    private final String nativeProtocolAudience;
    
    private SessionDefaultAudience(final String name, final int ordinal, final String nativeProtocolAudience) {
        this.nativeProtocolAudience = nativeProtocolAudience;
    }
    
    String getNativeProtocolAudience() {
        return this.nativeProtocolAudience;
    }
}
