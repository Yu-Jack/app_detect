// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum af
{
    a("AUTHENTICATION_RETRY", 0), 
    b("AUTHENTICATION_REOPEN_SESSION", 1), 
    c("PERMISSION", 2), 
    d("SERVER", 3), 
    e("THROTTLING", 4), 
    f("OTHER", 5), 
    g("BAD_REQUEST", 6), 
    h("CLIENT", 7);
    
    static {
        i = new af[] { af.a, af.b, af.c, af.d, af.e, af.f, af.g, af.h };
    }
    
    private af(final String name, final int ordinal) {
    }
}
