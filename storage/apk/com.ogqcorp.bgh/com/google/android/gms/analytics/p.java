// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

public class p
{
    private static c a;
    
    public static void a(final String s) {
        final i b = b();
        if (b != null) {
            b.d(s);
        }
    }
    
    public static boolean a() {
        final i b = b();
        boolean b2 = false;
        if (b != null) {
            final int a = b().a();
            b2 = false;
            if (a == 0) {
                b2 = true;
            }
        }
        return b2;
    }
    
    private static i b() {
        if (p.a == null) {
            p.a = c.a();
        }
        if (p.a != null) {
            return p.a.d();
        }
        return null;
    }
    
    public static void b(final String s) {
        final i b = b();
        if (b != null) {
            b.b(s);
        }
    }
    
    public static void c(final String s) {
        final i b = b();
        if (b != null) {
            b.a(s);
        }
    }
    
    public static void d(final String s) {
        final i b = b();
        if (b != null) {
            b.c(s);
        }
    }
}
