// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

public final class b
{
    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    private final int e;
    private final String f;
    
    static {
        a = new b(1001, "No Fill");
        b = new b(1002, "Ad was re-loaded too frequently");
        c = new b(2001, "Internal Error");
        d = new b(2002, "Native ad failed to load due to missing properties");
    }
    
    public b(final int e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    public final String a() {
        return this.f;
    }
}
