// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum cm
{
    a("Unknown", 0, 0), 
    b("Linear", 1, 1), 
    c("NonLinearAds", 2, 2), 
    d("CompanionAds", 3, 3);
    
    private int e;
    
    private cm(final String name, final int ordinal, final int e) {
        this.e = e;
    }
}
