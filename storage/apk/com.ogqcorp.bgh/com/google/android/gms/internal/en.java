// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Log;

public final class en
{
    public static void a(final String s) {
        if (a(3)) {
            Log.d("Ads", s);
        }
    }
    
    public static void a(final String s, final Throwable t) {
        if (a(3)) {
            Log.d("Ads", s, t);
        }
    }
    
    public static boolean a(final int n) {
        return (n >= 5 || Log.isLoggable("Ads", n)) && n != 2;
    }
    
    public static void b(final String s) {
        if (a(6)) {
            Log.e("Ads", s);
        }
    }
    
    public static void b(final String s, final Throwable t) {
        if (a(6)) {
            Log.e("Ads", s, t);
        }
    }
    
    public static void c(final String s) {
        if (a(4)) {
            Log.i("Ads", s);
        }
    }
    
    public static void c(final String s, final Throwable t) {
        if (a(5)) {
            Log.w("Ads", s, t);
        }
    }
    
    public static void d(final String s) {
        if (a(2)) {
            Log.v("Ads", s);
        }
    }
    
    public static void e(final String s) {
        if (a(5)) {
            Log.w("Ads", s);
        }
    }
}
