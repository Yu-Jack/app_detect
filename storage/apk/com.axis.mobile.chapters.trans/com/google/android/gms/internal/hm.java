// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class hm
{
    public static void A(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }
    
    public static void C(final boolean b) {
        if (!b) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void a(final boolean b, final Object obj) {
        if (!b) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
    
    public static void a(final boolean b, final String format, final Object... args) {
        if (!b) {
            throw new IllegalStateException(String.format(format, args));
        }
    }
    
    public static String aE(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return s;
    }
    
    public static void ay(final String s) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(s);
        }
    }
    
    public static void az(final String s) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(s);
        }
    }
    
    public static Object b(final Object o, final Object obj) {
        if (o == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return o;
    }
    
    public static String b(final String s, final Object obj) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return s;
    }
    
    public static void b(final boolean b, final Object obj) {
        if (!b) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }
    
    public static void b(final boolean b, final String format, final Object... args) {
        if (!b) {
            throw new IllegalArgumentException(String.format(format, args));
        }
    }
    
    public static Object f(final Object o) {
        if (o == null) {
            throw new NullPointerException("null reference");
        }
        return o;
    }
}
