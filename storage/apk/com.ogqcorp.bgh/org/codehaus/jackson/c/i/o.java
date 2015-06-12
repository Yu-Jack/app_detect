// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import org.codehaus.jackson.c.b;
import java.util.HashMap;

public class o<T extends Enum<T>>
{
    protected final Class<T> a;
    protected final T[] b;
    protected final HashMap<String, T> c;
    
    protected o(final Class<T> a, final T[] b, final HashMap<String, T> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static <ET extends Enum<ET>> o<ET> a(final Class<ET> clazz) {
        final ET[] array = clazz.getEnumConstants();
        final HashMap<String, Enum> hashMap = new HashMap<String, Enum>();
        int length = array.length;
        while (--length >= 0) {
            final Enum<ET> value = array[length];
            hashMap.put(value.toString(), value);
        }
        return new o<ET>((Class<Enum>)clazz, array, hashMap);
    }
    
    public static <ET extends Enum<ET>> o<ET> a(final Class<ET> clazz, final b b) {
        final ET[] array = clazz.getEnumConstants();
        if (array == null) {
            throw new IllegalArgumentException("No enum constants for class " + clazz.getName());
        }
        final HashMap<String, Enum> hashMap = new HashMap<String, Enum>();
        for (final Enum<ET> value : array) {
            hashMap.put(b.a(value), value);
        }
        return new o<ET>((Class<Enum>)clazz, array, hashMap);
    }
    
    public static o<?> b(final Class<?> clazz) {
        return a(clazz);
    }
    
    public static o<?> b(final Class<?> clazz, final b b) {
        return a(clazz, b);
    }
    
    public Class<T> a() {
        return this.a;
    }
    
    public T a(final int n) {
        if (n < 0 || n >= this.b.length) {
            return null;
        }
        return (T)this.b[n];
    }
    
    public T a(final String key) {
        return this.c.get(key);
    }
    
    public int b() {
        return -1 + this.b.length;
    }
}
