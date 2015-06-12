// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum ak
{
    a("REQUESTS", 0), 
    b("INCLUDE_ACCESS_TOKENS", 1), 
    c("INCLUDE_RAW_RESPONSES", 2), 
    d("CACHE", 3), 
    e("APP_EVENTS", 4), 
    f("DEVELOPER_ERRORS", 5);
    
    @Deprecated
    public static final ak g;
    
    static {
        h = new ak[] { ak.a, ak.b, ak.c, ak.d, ak.e, ak.f };
        g = ak.e;
    }
    
    private ak(final String name, final int ordinal) {
    }
}
