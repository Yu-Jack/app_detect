// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum ay
{
    a("UNKNOWN", 0, 0), 
    b("VIDEO", 1, 1), 
    c("IMAGE", 2, 2), 
    d("TEXT", 3, 3);
    
    private final int e;
    
    private ay(final String name, final int ordinal, final int e) {
        this.e = e;
    }
    
    public static ay a(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 0: {
                return ay.a;
            }
            case 1: {
                return ay.b;
            }
            case 2: {
                return ay.c;
            }
            case 3: {
                return ay.d;
            }
        }
    }
    
    public final int a() {
        return this.e;
    }
}
