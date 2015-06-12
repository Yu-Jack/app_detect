// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum SessionLoginBehavior
{
    SSO_ONLY("SSO_ONLY", 1, true, false), 
    SSO_WITH_FALLBACK("SSO_WITH_FALLBACK", 0, true, true), 
    SUPPRESS_SSO("SUPPRESS_SSO", 2, false, true);
    
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;
    
    private SessionLoginBehavior(final String name, final int ordinal, final boolean allowsKatanaAuth, final boolean allowsWebViewAuth) {
        this.allowsKatanaAuth = allowsKatanaAuth;
        this.allowsWebViewAuth = allowsWebViewAuth;
    }
    
    boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }
    
    boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
