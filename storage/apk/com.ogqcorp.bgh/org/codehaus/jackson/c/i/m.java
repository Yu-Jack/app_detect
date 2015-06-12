// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.util.EnumMap;
import java.util.EnumSet;
import java.lang.reflect.Field;

class m
{
    static final m a;
    private final Field b;
    private final Field c;
    
    static {
        a = new m();
    }
    
    private m() {
        this.b = a(EnumSet.class, "elementType", Class.class);
        this.c = a(EnumMap.class, "elementType", Class.class);
    }
    
    private Object a(final Object obj, final Field field) {
        try {
            return field.get(obj);
        }
        catch (Exception cause) {
            throw new IllegalArgumentException(cause);
        }
    }
    
    private static Field a(final Class<?> clazz, final String s, final Class<?> clazz2) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        final int length = declaredFields.length;
        int i = 0;
        while (true) {
            while (i < length) {
                Field field = declaredFields[i];
                if (s.equals(field.getName()) && field.getType() == clazz2) {
                    if (field == null) {
                        final int length2 = declaredFields.length;
                        int j = 0;
                        Field field2 = field;
                        while (j < length2) {
                            Field field3 = declaredFields[j];
                            if (field3.getType() == clazz2) {
                                if (field2 != null) {
                                    field = null;
                                    return field;
                                }
                            }
                            else {
                                field3 = field2;
                            }
                            ++j;
                            field2 = field3;
                        }
                        field = field2;
                    }
                    Label_0119: {
                        break Label_0119;
                    }
                    if (field != null) {
                        try {
                            field.setAccessible(true);
                            return field;
                        }
                        catch (Throwable t) {
                            return field;
                        }
                        break;
                    }
                    return field;
                }
                else {
                    ++i;
                }
            }
            Field field = null;
            continue;
        }
    }
    
    public Class<? extends Enum<?>> a(final EnumMap<?, ?> enumMap) {
        if (this.c != null) {
            return (Class<? extends Enum<?>>)this.a(enumMap, this.c);
        }
        throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
    }
    
    public Class<? extends Enum<?>> a(final EnumSet<?> set) {
        if (this.b != null) {
            return (Class<? extends Enum<?>>)this.a(set, this.b);
        }
        throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
    }
}
