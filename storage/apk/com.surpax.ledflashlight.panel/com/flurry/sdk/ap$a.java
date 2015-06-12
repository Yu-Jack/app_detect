// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum ap$a
{
    a("NOT_STARTED", 0, 0), 
    b("IN_PROGRESS", 1, 1), 
    c("INCOMPLETE", 2, 2), 
    d("COMPLETE", 3, 3), 
    e("EVICTED", 4, 4), 
    f("ERROR", 5, 5);
    
    private final int g;
    
    private ap$a(final String name, final int ordinal, final int g) {
        this.g = g;
    }
}
