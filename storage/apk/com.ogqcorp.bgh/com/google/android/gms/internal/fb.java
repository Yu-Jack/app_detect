// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class fb
{
    public static <T> boolean a(final T t, final T obj) {
        return (t == null && obj == null) || (t != null && obj != null && t.equals(obj));
    }
}
