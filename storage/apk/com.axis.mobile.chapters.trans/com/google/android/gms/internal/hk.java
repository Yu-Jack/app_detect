// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Arrays;

public final class hk
{
    public static hk$a e(final Object o) {
        return new hk$a(o, null);
    }
    
    public static boolean equal(final Object o, final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
    
    public static int hashCode(final Object... a) {
        return Arrays.hashCode(a);
    }
}
