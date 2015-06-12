// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.s;
import java.lang.reflect.Array;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.a.b;

@b
public class ab extends g<Object[]>
{
    protected final a a;
    protected final boolean b;
    protected final Class<?> c;
    protected final x<Object> d;
    protected final az e;
    
    public ab(final org.codehaus.jackson.c.h.a a, final x<Object> d, final az e) {
        super(Object[].class);
        this.a = a;
        this.c = a.g().p();
        this.b = (this.c == Object.class);
        this.d = d;
        this.e = e;
    }
    
    private final Object[] d(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (p2.a(o.o)) {
            Object o;
            if (k.e() == org.codehaus.jackson.p.m) {
                o = null;
            }
            else if (this.e == null) {
                o = this.d.a(k, p2);
            }
            else {
                o = this.d.a(k, p2, this.e);
            }
            Object[] array;
            if (this.b) {
                array = new Object[] { null };
            }
            else {
                array = (Object[])Array.newInstance(this.c, 1);
            }
            array[0] = o;
            return array;
        }
        if (k.e() == org.codehaus.jackson.p.h && this.c == Byte.class) {
            return this.c(k, p2);
        }
        throw p2.b(this.a.p());
    }
    
    public Object[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.d(k, p2);
        }
        final s g = p2.g();
        final Object[] a = g.a();
        final az e = this.e;
        Object[] a2 = a;
        int n = 0;
        while (true) {
            final org.codehaus.jackson.p b = k.b();
            if (b == org.codehaus.jackson.p.e) {
                break;
            }
            Object o;
            if (b == org.codehaus.jackson.p.m) {
                o = null;
            }
            else if (e == null) {
                o = this.d.a(k, p2);
            }
            else {
                o = this.d.a(k, p2, e);
            }
            int n2;
            if (n >= a2.length) {
                a2 = g.a(a2);
                n2 = 0;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            a2[n2] = o;
        }
        Object[] array;
        if (this.b) {
            array = g.a(a2, n);
        }
        else {
            array = g.a(a2, n, this.c);
        }
        p2.a(g);
        return array;
    }
    
    public Object[] b(final k k, final p p3, final az az) {
        return (Object[])az.b(k, p3);
    }
    
    protected Byte[] c(final k k, final p p2) {
        final byte[] a = k.a(p2.c());
        final Byte[] array = new Byte[a.length];
        for (int i = 0; i < a.length; ++i) {
            array[i] = a[i];
        }
        return array;
    }
    
    @Override
    public x<Object> d() {
        return this.d;
    }
}
