// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Arrays;

public final class gw
{
    public static int a(final Object... a) {
        return Arrays.hashCode(a);
    }
    
    public static gx a(final Object o) {
        return new gx(o, null);
    }
    
    public static boolean a(final Object o, final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
}
