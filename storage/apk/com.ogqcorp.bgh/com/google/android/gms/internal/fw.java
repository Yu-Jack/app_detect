// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Log;
import android.os.Looper;

public final class fw
{
    public static void a(final Object o) {
        if (o == null) {
            throw new IllegalArgumentException("null reference");
        }
    }
    
    public static void a(final String s) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(s);
        }
    }
    
    public static void a(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }
    
    public static void a(final boolean b, final Object obj) {
        if (!b) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
    
    public static void b(final String s) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(s);
        }
    }
}
