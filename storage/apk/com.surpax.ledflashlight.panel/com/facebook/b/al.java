// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.util.Iterator;
import java.util.Collection;

public final class al
{
    public static void a(final Object o, final String str) {
        if (o == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }
    
    public static void a(final String s, final String str) {
        if (aj.a(s)) {
            throw new IllegalArgumentException("Argument '" + str + "' cannot be null or empty");
        }
    }
    
    public static void a(final Collection collection, final String s) {
        a((Object)collection, s);
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                throw new NullPointerException("Container '" + s + "' cannot contain null values");
            }
        }
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + s + "' cannot be empty");
        }
    }
}
