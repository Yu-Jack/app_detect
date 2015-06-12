// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum bo
{
    a("CREATED", 0, bp.a), 
    b("CREATED_TOKEN_LOADED", 1, bp.a), 
    c("OPENING", 2, bp.a), 
    d("OPENED", 3, bp.b), 
    e("OPENED_TOKEN_UPDATED", 4, bp.b), 
    f("CLOSED_LOGIN_FAILED", 5, bp.c), 
    g("CLOSED", 6, bp.c);
    
    private final bp h;
    
    static {
        i = new bo[] { bo.a, bo.b, bo.c, bo.d, bo.e, bo.f, bo.g };
    }
    
    private bo(final String name, final int ordinal, final bp h) {
        this.h = h;
    }
    
    public final boolean a() {
        return this.h == bp.b;
    }
    
    public final boolean b() {
        return this.h == bp.c;
    }
}
