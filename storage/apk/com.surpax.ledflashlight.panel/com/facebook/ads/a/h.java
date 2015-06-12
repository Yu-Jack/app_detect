// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import java.util.Locale;

public enum h
{
    a("NONE", 0), 
    b("INSTALLED", 1), 
    c("NOT_INSTALLED", 2);
    
    private h(final String name, final int ordinal) {
    }
    
    public static h a(final String s) {
        if (ab.a(s)) {
            return h.a;
        }
        try {
            return valueOf(s.toUpperCase(Locale.US));
        }
        catch (IllegalArgumentException ex) {
            return h.a;
        }
    }
}
