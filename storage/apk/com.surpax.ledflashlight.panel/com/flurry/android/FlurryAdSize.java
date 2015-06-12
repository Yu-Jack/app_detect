// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

public enum FlurryAdSize
{
    BANNER_BOTTOM("BANNER_BOTTOM", 1, 2), 
    BANNER_TOP("BANNER_TOP", 0, 1), 
    FULLSCREEN("FULLSCREEN", 2, 3);
    
    private int a;
    
    private FlurryAdSize(final String name, final int ordinal, final int a) {
        this.a = a;
    }
    
    public final int getValue() {
        return this.a;
    }
}
