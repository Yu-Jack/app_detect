// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Base64;

class er implements ky
{
    @Override
    public String a(final byte[] array, final boolean b) {
        int n;
        if (b) {
            n = 11;
        }
        else {
            n = 2;
        }
        return Base64.encodeToString(array, n);
    }
    
    @Override
    public byte[] a(final String s, final boolean b) {
        int n;
        if (b) {
            n = 11;
        }
        else {
            n = 2;
        }
        return Base64.decode(s, n);
    }
}
