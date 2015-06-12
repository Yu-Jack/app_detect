// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public final class r
{
    static final Class<?>[] a;
    final String b;
    final Class<?>[] c;
    
    static {
        a = new Class[0];
    }
    
    public r(final String b, Class<?>[] a) {
        this.b = b;
        if (a == null) {
            a = r.a;
        }
        this.c = a;
    }
    
    public r(final Constructor<?> constructor) {
        this("", constructor.getParameterTypes());
    }
    
    public r(final Method method) {
        this(method.getName(), method.getParameterTypes());
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            final r r = (r)o;
            if (!this.b.equals(r.b)) {
                return false;
            }
            final Class<?>[] c = r.c;
            final int length = this.c.length;
            if (c.length != length) {
                return false;
            }
            for (int i = 0; i < length; ++i) {
                final Class<?> clazz = c[i];
                final Class<?> clazz2 = this.c[i];
                if (clazz != clazz2 && !clazz.isAssignableFrom(clazz2) && !clazz2.isAssignableFrom(clazz)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode() + this.c.length;
    }
    
    @Override
    public String toString() {
        return this.b + "(" + this.c.length + "-args)";
    }
}
