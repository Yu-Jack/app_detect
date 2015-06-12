// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Log;

public final class eu
{
    public static void A(final String s) {
        if (p(6)) {
            Log.e("Ads", s);
        }
    }
    
    public static void B(final String s) {
        if (p(4)) {
            Log.i("Ads", s);
        }
    }
    
    public static void C(final String s) {
        if (p(2)) {
            Log.v("Ads", s);
        }
    }
    
    public static void D(final String s) {
        if (p(5)) {
            Log.w("Ads", s);
        }
    }
    
    public static void a(final String s, final Throwable t) {
        if (p(3)) {
            Log.d("Ads", s, t);
        }
    }
    
    public static void b(final String s, final Throwable t) {
        if (p(6)) {
            Log.e("Ads", s, t);
        }
    }
    
    public static void c(final String s, final Throwable t) {
        if (p(5)) {
            Log.w("Ads", s, t);
        }
    }
    
    public static boolean p(final int n) {
        return (n >= 5 || Log.isLoggable("Ads", n)) && n != 2;
    }
    
    public static void z(final String s) {
        if (p(3)) {
            Log.d("Ads", s);
        }
    }
}
