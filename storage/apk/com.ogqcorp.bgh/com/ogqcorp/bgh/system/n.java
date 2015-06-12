// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import java.util.HashMap;

public final class n
{
    public static final HashMap<String, Object> a(final Object... array) {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        a(hashMap, new String[] { "version", "session", "platform" }, array);
        return hashMap;
    }
    
    private static final void a(final HashMap<String, Object> hashMap, final String[] array, final Object[] array2) {
        for (int i = 0; i < array.length; ++i) {
            hashMap.put(array[i], array2[i]);
        }
    }
    
    public static final HashMap<String, Object> b(final Object... array) {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        a(hashMap, new String[] { "session" }, array);
        return hashMap;
    }
    
    public static final HashMap<String, Object> c(final Object... array) {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        a(hashMap, new String[] { "referrer" }, array);
        return hashMap;
    }
    
    public static final HashMap<String, Object> d(final Object... array) {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        a(hashMap, new String[] { "id", "type", "order" }, array);
        return hashMap;
    }
    
    public static final HashMap<String, Object> e(final Object... array) {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        a(hashMap, new String[] { "id" }, array);
        return hashMap;
    }
}
