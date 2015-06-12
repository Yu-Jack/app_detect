// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

enum w
{
    a("SUCCESS", 0, "success"), 
    b("CANCEL", 1, "cancel"), 
    c("ERROR", 2, "error");
    
    private final String d;
    
    static {
        e = new w[] { w.a, w.b, w.c };
    }
    
    private w(final String name, final int ordinal, final String d) {
        this.d = d;
    }
    
    final String a() {
        return this.d;
    }
}
