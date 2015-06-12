// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum bn
{
    a("SSO_WITH_FALLBACK", 0, true, true), 
    b("SSO_ONLY", 1, true, false), 
    c("SUPPRESS_SSO", 2, false, true);
    
    private final boolean d;
    private final boolean e;
    
    static {
        f = new bn[] { bn.a, bn.b, bn.c };
    }
    
    private bn(final String name, final int ordinal, final boolean d, final boolean e) {
        this.d = d;
        this.e = e;
    }
    
    final boolean a() {
        return this.d;
    }
    
    final boolean b() {
        return this.e;
    }
}
