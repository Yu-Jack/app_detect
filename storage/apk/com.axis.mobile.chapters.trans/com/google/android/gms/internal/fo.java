// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class fo
{
    private static final String[] xZ;
    private static final Map ya;
    
    static {
        int i = 0;
        xZ = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity" };
        ya = new HashMap(fo.xZ.length);
        while (i < fo.xZ.length) {
            fo.ya.put(fo.xZ[i], i);
            ++i;
        }
    }
    
    public static String H(final int n) {
        if (n < 0 || n >= fo.xZ.length) {
            return null;
        }
        return fo.xZ[n];
    }
    
    public static int Y(final String str) {
        final Integer n = fo.ya.get(str);
        if (n == null) {
            throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
        }
        return n;
    }
    
    public static int dP() {
        return fo.xZ.length;
    }
}
