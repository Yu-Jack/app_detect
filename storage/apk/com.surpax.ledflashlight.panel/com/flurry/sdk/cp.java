// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum cp
{
    a("Unknown", 0, 0), 
    b("ClickThrough", 1, 1), 
    c("ClickTracking", 2, 2), 
    d("CustomClick", 3, 3);
    
    private int e;
    
    private cp(final String name, final int ordinal, final int e) {
        this.e = e;
    }
}
