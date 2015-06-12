// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Base64;

public final class ht
{
    public static String a(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 0);
    }
    
    public static String b(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 10);
    }
}
