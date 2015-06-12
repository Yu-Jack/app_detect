// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.f.a;

public final class h extends i
{
    protected final a[] a;
    protected final String[] b;
    
    protected h(final Class<?> clazz) {
        this(clazz, null, null, null, null);
    }
    
    protected h(final Class<?> clazz, final String[] b, final a[] a, final Object o, final Object o2) {
        super(clazz, 0, o, o2);
        if (b == null || b.length == 0) {
            this.b = null;
            this.a = null;
            return;
        }
        this.b = b;
        this.a = a;
    }
    
    public static h d(final Class<?> clazz) {
        return new h(clazz, null, null, null, null);
    }
    
    public static h e(final Class<?> clazz) {
        if (Map.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Can not construct SimpleType for a Map (class: " + clazz.getName() + ")");
        }
        if (Collection.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Can not construct SimpleType for a Collection (class: " + clazz.getName() + ")");
        }
        if (clazz.isArray()) {
            throw new IllegalArgumentException("Can not construct SimpleType for an array (class: " + clazz.getName() + ")");
        }
        return new h(clazz);
    }
    
    @Override
    protected String a() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.d.getName());
        if (this.a != null && this.a.length > 0) {
            sb.append('<');
            int n = 1;
            for (final a a2 : this.a) {
                if (n != 0) {
                    n = 0;
                }
                else {
                    sb.append(',');
                }
                sb.append(a2.m());
            }
            sb.append('>');
        }
        return sb.toString();
    }
    
    @Override
    public String a(final int n) {
        if (n < 0 || this.b == null || n >= this.b.length) {
            return null;
        }
        return this.b[n];
    }
    
    public h a(final Object o) {
        return new h(this.d, this.b, this.a, this.f, o);
    }
    
    @Override
    protected a a(final Class<?> clazz) {
        return new h(clazz, this.b, this.a, this.f, this.g);
    }
    
    public h b(final Object o) {
        if (o == this.f) {
            return this;
        }
        return new h(this.d, this.b, this.a, o, this.g);
    }
    
    @Override
    public a b(final int n) {
        if (n < 0 || this.a == null || n >= this.a.length) {
            return null;
        }
        return this.a[n];
    }
    
    @Override
    public a b(final Class<?> clazz) {
        throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
    }
    
    @Override
    public a c(final Class<?> clazz) {
        throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
    }
    
    @Override
    public a e(final Object o) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            b = false;
            if (o != null) {
                final Class<?> class1 = o.getClass();
                final Class<? extends h> class2 = this.getClass();
                b = false;
                if (class1 == class2) {
                    final h h = (h)o;
                    final Class<?> d = h.d;
                    final Class<?> d2 = this.d;
                    b = false;
                    if (d == d2) {
                        final a[] a = this.a;
                        final a[] a2 = h.a;
                        if (a == null) {
                            if (a2 != null) {
                                final int length = a2.length;
                                b = false;
                                if (length != 0) {
                                    return b;
                                }
                            }
                            return true;
                        }
                        b = false;
                        if (a2 != null) {
                            final int length2 = a.length;
                            final int length3 = a2.length;
                            b = false;
                            if (length2 == length3) {
                                for (int length4 = a.length, i = 0; i < length4; ++i) {
                                    final boolean equals = a[i].equals(a2[i]);
                                    b = false;
                                    if (!equals) {
                                        return b;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }
    
    @Override
    public boolean f() {
        return false;
    }
    
    @Override
    public int h() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ").append(this.a()).append(']');
        return sb.toString();
    }
}
