// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum AccessTokenSource
{
    CLIENT_TOKEN("CLIENT_TOKEN", 6, true), 
    FACEBOOK_APPLICATION_NATIVE("FACEBOOK_APPLICATION_NATIVE", 2, true), 
    FACEBOOK_APPLICATION_SERVICE("FACEBOOK_APPLICATION_SERVICE", 3, true), 
    FACEBOOK_APPLICATION_WEB("FACEBOOK_APPLICATION_WEB", 1, true), 
    NONE("NONE", 0, false), 
    TEST_USER("TEST_USER", 5, true), 
    WEB_VIEW("WEB_VIEW", 4, false);
    
    private final boolean canExtendToken;
    
    private AccessTokenSource(final String name, final int ordinal, final boolean canExtendToken) {
        this.canExtendToken = canExtendToken;
    }
    
    boolean canExtendToken() {
        return this.canExtendToken;
    }
}
