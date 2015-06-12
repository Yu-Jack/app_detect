// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum cn
{
    a("Unknown", 0, "unknown"), 
    b("Streaming", 1, "streaming"), 
    c("Progressive", 2, "progressive");
    
    private String d;
    
    private cn(final String name, final int ordinal, final String d) {
        this.d = d;
    }
    
    public static cn a(final String s) {
        if (cn.b.a().equals(s)) {
            return cn.b;
        }
        if (cn.c.a().equals(s)) {
            return cn.c;
        }
        return cn.a;
    }
    
    public final String a() {
        return this.d;
    }
}
