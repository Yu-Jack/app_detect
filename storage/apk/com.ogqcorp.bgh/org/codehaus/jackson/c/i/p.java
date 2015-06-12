// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.util.HashMap;
import org.codehaus.jackson.c.b;
import java.util.Map;
import org.codehaus.jackson.b.k;
import java.util.EnumMap;

public final class p
{
    private final EnumMap<?, k> a;
    
    private p(final Map<Enum<?>, k> m) {
        this.a = new EnumMap<Object, k>(m);
    }
    
    public static p a(final Class<Enum<?>> clazz, final b b) {
        return b(clazz, b);
    }
    
    public static p b(final Class<Enum<?>> clazz, final b b) {
        final Enum[] array = (Enum[])l.g(clazz).getEnumConstants();
        if (array != null) {
            final HashMap<Enum<?>, k> hashMap = new HashMap<Enum<?>, k>();
            for (final Enum enum1 : array) {
                hashMap.put(enum1, new k(b.a(enum1)));
            }
            return new p(hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + clazz.getName());
    }
    
    public static p c(final Class<Enum<?>> clazz, final b b) {
        final Enum[] array = (Enum[])l.g(clazz).getEnumConstants();
        if (array != null) {
            final HashMap<Enum<?>, k> hashMap = new HashMap<Enum<?>, k>();
            for (final Enum enum1 : array) {
                hashMap.put(enum1, new k(enum1.toString()));
            }
            return new p(hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + clazz.getName());
    }
    
    public k a(final Enum<?> key) {
        return this.a.get(key);
    }
}
