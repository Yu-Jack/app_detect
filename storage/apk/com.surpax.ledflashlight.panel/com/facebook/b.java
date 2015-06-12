// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum b
{
    a("NONE", 0, false), 
    b("FACEBOOK_APPLICATION_WEB", 1, true), 
    c("FACEBOOK_APPLICATION_NATIVE", 2, true), 
    d("FACEBOOK_APPLICATION_SERVICE", 3, true), 
    e("WEB_VIEW", 4, false), 
    f("TEST_USER", 5, true), 
    g("CLIENT_TOKEN", 6, true);
    
    private final boolean h;
    
    static {
        i = new b[] { b.a, b.b, b.c, b.d, b.e, b.f, b.g };
    }
    
    private b(final String name, final int ordinal, final boolean h) {
        this.h = h;
    }
    
    final boolean a() {
        return this.h;
    }
}
