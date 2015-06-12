// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.m;
import org.codehaus.jackson.d.a;
import org.codehaus.jackson.d.o;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.i;

abstract class c<N extends i> extends an<N>
{
    public c(final Class<N> clazz) {
        super(clazz);
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        return az.d(k, p3);
    }
    
    protected final o a(final k k, final p p3, final org.codehaus.jackson.d.k i) {
        final o c = i.c();
        org.codehaus.jackson.p p4 = k.e();
        if (p4 == org.codehaus.jackson.p.b) {
            p4 = k.b();
        }
        while (p4 == org.codehaus.jackson.p.f) {
            final String g = k.g();
            i j = null;
            switch (c$1.a[k.b().ordinal()]) {
                default: {
                    j = this.c(k, p3, i);
                    break;
                }
                case 1: {
                    j = this.a(k, p3, i);
                    break;
                }
                case 2: {
                    j = this.b(k, p3, i);
                    break;
                }
                case 3: {
                    j = i.a(k.k());
                    break;
                }
            }
            final i a = c.a(g, j);
            if (a != null) {
                this.a(g, c, a, j);
            }
            p4 = k.b();
        }
        return c;
    }
    
    protected void a(final String s, final o o, final i i, final i j) {
    }
    
    protected final a b(final k k, final p p3, final org.codehaus.jackson.d.k i) {
        final a b = i.b();
    Label_0109:
        while (true) {
            switch (c$1.a[k.b().ordinal()]) {
                default: {
                    b.a(this.c(k, p3, i));
                    continue;
                }
                case 1: {
                    b.a(this.a(k, p3, i));
                    continue;
                }
                case 2: {
                    b.a(this.b(k, p3, i));
                    continue;
                }
                case 3: {
                    b.a(i.a(k.k()));
                    continue;
                }
                case 4: {
                    break Label_0109;
                }
            }
        }
        return b;
    }
    
    protected final i c(final k k, final p p3, final org.codehaus.jackson.d.k i) {
        switch (c$1.a[k.e().ordinal()]) {
            default: {
                throw p3.b(this.f());
            }
            case 1: {
                return this.a(k, p3, i);
            }
            case 2: {
                return this.b(k, p3, i);
            }
            case 5: {
                return this.a(k, p3, i);
            }
            case 6: {
                final Object z = k.z();
                if (z == null) {
                    return i.a();
                }
                if (((byte[])z).getClass() == byte[].class) {
                    return i.a((byte[])z);
                }
                return i.a(z);
            }
            case 3: {
                return i.a(k.k());
            }
            case 7: {
                final m q = k.q();
                if (q == m.c || p3.a(org.codehaus.jackson.c.o.h)) {
                    return i.a(k.v());
                }
                if (q == m.a) {
                    return i.a(k.t());
                }
                return i.a(k.u());
            }
            case 8: {
                if (k.q() == m.f || p3.a(org.codehaus.jackson.c.o.g)) {
                    return i.a(k.y());
                }
                return i.a(k.x());
            }
            case 9: {
                return i.a(true);
            }
            case 10: {
                return i.a(false);
            }
            case 11: {
                return i.a();
            }
        }
    }
}
