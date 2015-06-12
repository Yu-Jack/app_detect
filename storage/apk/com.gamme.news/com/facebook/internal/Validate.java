// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

import java.util.Iterator;
import java.util.Collection;

public final class Validate
{
    public static void containsNoNullOrEmpty(final Collection<String> collection, final String s) {
        notNull(collection, s);
        for (final String s2 : collection) {
            if (s2 == null) {
                throw new NullPointerException("Container '" + s + "' cannot contain null values");
            }
            if (s2.length() == 0) {
                throw new IllegalArgumentException("Container '" + s + "' cannot contain empty values");
            }
        }
    }
    
    public static <T> void containsNoNulls(final Collection<T> collection, final String str) {
        notNull(collection, str);
        final Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }
    
    public static <T> void notEmpty(final Collection<T> collection, final String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }
    
    public static <T> void notEmptyAndContainsNoNulls(final Collection<T> collection, final String s) {
        containsNoNulls((Collection<Object>)collection, s);
        notEmpty((Collection<Object>)collection, s);
    }
    
    public static void notNull(final Object o, final String str) {
        if (o == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }
    
    public static void notNullOrEmpty(final String s, final String str) {
        if (Utility.isNullOrEmpty(s)) {
            throw new IllegalArgumentException("Argument '" + str + "' cannot be null or empty");
        }
    }
    
    public static void oneOf(final Object obj, final String str, final Object... array) {
        for (final Object o : array) {
            if (o != null) {
                if (o.equals(obj)) {
                    return;
                }
            }
            else if (obj == null) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
    }
}
