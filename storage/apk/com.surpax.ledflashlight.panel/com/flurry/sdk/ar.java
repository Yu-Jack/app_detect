// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum ar
{
    a("NONE", 0, 0), 
    b("QUEUED", 1, 1), 
    c("IN_PROGRESS", 2, 2), 
    d("COMPLETE", 3, 3), 
    e("CANCELLED", 4, 4), 
    f("EVICTED", 5, 5), 
    g("ERROR", 6, 6);
    
    private final int h;
    
    private ar(final String name, final int ordinal, final int h) {
        this.h = h;
    }
    
    public static ar a(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 0: {
                return ar.a;
            }
            case 1: {
                return ar.b;
            }
            case 2: {
                return ar.c;
            }
            case 3: {
                return ar.d;
            }
            case 4: {
                return ar.e;
            }
            case 5: {
                return ar.f;
            }
            case 6: {
                return ar.g;
            }
        }
    }
    
    public final int a() {
        return this.h;
    }
}
