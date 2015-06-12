// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.a;

public final class a
{
    public static byte a(final Boolean b) {
        if (b == null) {
            return -1;
        }
        if (b) {
            return 1;
        }
        return 0;
    }
    
    public static Boolean a(final byte b) {
        switch (b) {
            default: {
                return null;
            }
            case 1: {
                return Boolean.TRUE;
            }
            case 0: {
                return Boolean.FALSE;
            }
        }
    }
}
