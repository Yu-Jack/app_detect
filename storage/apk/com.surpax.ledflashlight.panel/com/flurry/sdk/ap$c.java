// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum ap$c
{
    a("STREAM_ONLY", 0, 0), 
    b("CACHE_ONLY", 1, 1), 
    c("CACHE_OR_STREAM", 2, 2);
    
    private final int d;
    
    private ap$c(final String name, final int ordinal, final int d) {
        this.d = d;
    }
    
    public static ap$c a(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 0: {
                return ap$c.a;
            }
            case 1: {
                return ap$c.b;
            }
            case 2: {
                return ap$c.c;
            }
        }
    }
}
