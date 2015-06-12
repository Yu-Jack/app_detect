// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum bm
{
    a("NONE", 0, (String)null), 
    b("ONLY_ME", 1, "only_me"), 
    c("FRIENDS", 2, "friends"), 
    d("EVERYONE", 3, "everyone");
    
    private final String e;
    
    static {
        f = new bm[] { bm.a, bm.b, bm.c, bm.d };
    }
    
    private bm(final String name, final int ordinal, final String e) {
        this.e = e;
    }
    
    public final String a() {
        return this.e;
    }
}
