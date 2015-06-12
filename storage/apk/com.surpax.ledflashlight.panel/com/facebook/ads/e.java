// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

public enum e
{
    a("BANNER_320_50", 0, 320, 50), 
    b("INTERSTITIAL", 1, 0, 0);
    
    private final int c;
    private final int d;
    
    private e(final String name, final int ordinal, final int c, final int d) {
        this.c = c;
        this.d = d;
    }
    
    public final int a() {
        return this.c;
    }
    
    public final int b() {
        return this.d;
    }
}
