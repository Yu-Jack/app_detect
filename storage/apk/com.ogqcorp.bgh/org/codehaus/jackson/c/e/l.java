// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import org.codehaus.jackson.c.at;
import org.codehaus.jackson.c.e;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.c.j;
import org.codehaus.jackson.c.h.h;
import org.codehaus.jackson.c.i;

public class l extends i<k>
{
    protected static final k a;
    protected static final k b;
    protected static final k c;
    protected static final k d;
    @Deprecated
    public static final m e;
    @Deprecated
    public static final p f;
    @Deprecated
    public static final o g;
    protected static final s h;
    public static final l i;
    
    static {
        a = k.a(null, org.codehaus.jackson.c.h.h.d(String.class), org.codehaus.jackson.c.e.b.b(String.class, null, null));
        b = k.a(null, org.codehaus.jackson.c.h.h.d(Boolean.TYPE), org.codehaus.jackson.c.e.b.b(Boolean.TYPE, null, null));
        c = k.a(null, org.codehaus.jackson.c.h.h.d(Integer.TYPE), org.codehaus.jackson.c.e.b.b(Integer.TYPE, null, null));
        d = k.a(null, org.codehaus.jackson.c.h.h.d(Long.TYPE), org.codehaus.jackson.c.e.b.b(Long.TYPE, null, null));
        e = new m(null);
        f = new p();
        g = new o();
        h = new n(null);
        i = new l();
    }
    
    protected k a(final a a) {
        final Class<?> p = a.p();
        if (p == String.class) {
            return l.a;
        }
        if (p == Boolean.TYPE) {
            return l.b;
        }
        if (p == Integer.TYPE) {
            return l.c;
        }
        if (p == Long.TYPE) {
            return l.d;
        }
        return null;
    }
    
    protected u a(final ai<?> ai, final b b, final a a, final boolean b2) {
        return new u(ai, b2, a, b);
    }
    
    public u a(final ai<?> ai, final a a, final j j, final boolean b) {
        final b c = this.c(ai, a, j);
        c.a(l.h);
        c.n();
        return this.a(ai, c, a, b).k();
    }
    
    public k b(final ai<?> ai, final a a, final j j) {
        final boolean b = ai.b();
        org.codehaus.jackson.c.b a2 = ai.a();
        final Class<?> p3 = a.p();
        if (!b) {
            a2 = null;
        }
        return k.a(ai, a, org.codehaus.jackson.c.e.b.a(p3, a2, j));
    }
    
    public k b(final at at, final a a, final j j) {
        k k = this.a(a);
        if (k == null) {
            k = org.codehaus.jackson.c.e.k.b(this.a(at, a, j, true));
        }
        return k;
    }
    
    public b c(final ai<?> ai, final a a, final j j) {
        final boolean b = ai.b();
        org.codehaus.jackson.c.b a2 = ai.a();
        final Class<?> p3 = a.p();
        if (!b) {
            a2 = null;
        }
        final b a3 = org.codehaus.jackson.c.e.b.a(p3, a2, j);
        a3.a(l.h);
        a3.a(true);
        return a3;
    }
    
    public k c(final org.codehaus.jackson.c.n n, final a a, final j j) {
        k k = this.a(a);
        if (k == null) {
            k = org.codehaus.jackson.c.e.k.a(this.a(n, a, j, false));
        }
        return k;
    }
    
    public k d(final org.codehaus.jackson.c.n n, final a a, final j j) {
        k k = this.a(a);
        if (k == null) {
            k = org.codehaus.jackson.c.e.k.a(this.a(n, a, j, false));
        }
        return k;
    }
}
