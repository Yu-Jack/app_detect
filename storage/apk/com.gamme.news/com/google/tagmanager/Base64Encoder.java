// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import android.os.Build$VERSION;
import android.util.Base64;

class Base64Encoder
{
    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    public static final int URL_SAFE = 2;
    
    public static byte[] decode(final String s, final int n) {
        int n2 = 1;
        if (getSdkVersion() >= 8) {
            int n3 = 2;
            if ((n & 0x1) != 0x0) {
                n3 |= 0x1;
            }
            if ((n & 0x2) != 0x0) {
                n3 |= 0x8;
            }
            return Base64.decode(s, n3);
        }
        if ((n & 0x1) == 0x0) {}
        if ((n & 0x2) == 0x0) {
            n2 = 0;
        }
        if (n2 != 0) {
            return com.google.tagmanager.Base64.decodeWebSafe(s);
        }
        return com.google.tagmanager.Base64.decode(s);
    }
    
    public static String encodeToString(final byte[] array, final int n) {
        boolean b = true;
        if (getSdkVersion() >= 8) {
            int n2 = 2;
            if ((n & 0x1) != 0x0) {
                n2 |= 0x1;
            }
            if ((n & 0x2) != 0x0) {
                n2 |= 0x8;
            }
            return Base64.encodeToString(array, n2);
        }
        final boolean b2 = (n & 0x1) == 0x0 && b;
        if ((n & 0x2) == 0x0) {
            b = false;
        }
        if (b) {
            return com.google.tagmanager.Base64.encodeWebSafe(array, b2);
        }
        return com.google.tagmanager.Base64.encode(array, b2);
    }
    
    @VisibleForTesting
    static int getSdkVersion() {
        return Build$VERSION.SDK_INT;
    }
}
