// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

enum i
{
    a("SUCCESS", 0), 
    b("SERVER_ERROR", 1), 
    c("NO_CONNECTIVITY", 2), 
    d("UNKNOWN_ERROR", 3);
    
    static {
        e = new i[] { i.a, i.b, i.c, i.d };
    }
    
    private i(final String name, final int ordinal) {
    }
}
