// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.b.t;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.ar;
import java.util.Collection;

@b
public class f extends g<Collection<Object>> implements ar
{
    protected final a a;
    protected final x<Object> b;
    protected final az c;
    protected final t d;
    protected x<Object> e;
    
    public f(final a a, final x<Object> b, final az c, final t d) {
        super(a.p());
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    private final Collection<Object> b(final k k, final p p3, final Collection<Object> collection) {
        if (!p3.a(o.o)) {
            throw p3.b(this.a.p());
        }
        final x<Object> b = this.b;
        final az c = this.c;
        Object o;
        if (k.e() == org.codehaus.jackson.p.m) {
            o = null;
        }
        else if (c == null) {
            o = b.a(k, p3);
        }
        else {
            o = b.a(k, p3, c);
        }
        collection.add(o);
        return collection;
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        return az.b(k, p3);
    }
    
    @Override
    public Collection<Object> a(final k k, final p p2, Collection<Object> b) {
        if (!k.j()) {
            b = this.b(k, p2, b);
        }
        else {
            final x<Object> b2 = this.b;
            final az c = this.c;
            while (true) {
                final org.codehaus.jackson.p b3 = k.b();
                if (b3 == org.codehaus.jackson.p.e) {
                    break;
                }
                Object o;
                if (b3 == org.codehaus.jackson.p.m) {
                    o = null;
                }
                else if (c == null) {
                    o = b2.a(k, p2);
                }
                else {
                    o = b2.a(k, p2, c);
                }
                b.add(o);
            }
        }
        return b;
    }
    
    @Override
    public void a(final n n, final org.codehaus.jackson.c.t t) {
        if (this.d.i()) {
            final a l = this.d.l();
            if (l == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.d.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            this.e = this.a(n, t, l, new org.codehaus.jackson.c.g(null, l, null, this.d.o()));
        }
    }
    
    public Collection<Object> b(final k k, final p p2) {
        if (this.e != null) {
            return (Collection<Object>)this.d.a(this.e.a(k, p2));
        }
        if (k.e() == org.codehaus.jackson.p.h) {
            final String i = k.k();
            if (i.length() == 0) {
                return (Collection<Object>)this.d.a(i);
            }
        }
        return this.a(k, p2, (Collection<Object>)this.d.m());
    }
    
    @Override
    public x<Object> d() {
        return this.b;
    }
}
