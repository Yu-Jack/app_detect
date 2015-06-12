// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.e.i;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.b.t;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.ar;
import java.util.Collection;

@b
public final class bv extends g<Collection<String>> implements ar
{
    protected final a a;
    protected final x<String> b;
    protected final boolean c;
    protected final t d;
    protected x<Object> e;
    
    public bv(final a a, final x<?> b, final t d) {
        super(a.p());
        this.a = a;
        this.b = (x<String>)b;
        this.d = d;
        this.c = this.a(b);
    }
    
    private Collection<String> b(final k k, final p p3, final Collection<String> collection) {
        final x<String> b = this.b;
        while (true) {
            final org.codehaus.jackson.p b2 = k.b();
            if (b2 == org.codehaus.jackson.p.e) {
                break;
            }
            String s;
            if (b2 == org.codehaus.jackson.p.m) {
                s = null;
            }
            else {
                s = b.a(k, p3);
            }
            collection.add(s);
        }
        return collection;
    }
    
    private final Collection<String> c(final k k, final p p3, final Collection<String> collection) {
        if (!p3.a(o.o)) {
            throw p3.b(this.a.p());
        }
        final x<String> b = this.b;
        String i;
        if (k.e() == org.codehaus.jackson.p.m) {
            i = null;
        }
        else if (b == null) {
            i = k.k();
        }
        else {
            i = b.a(k, p3);
        }
        collection.add(i);
        return collection;
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        return az.b(k, p3);
    }
    
    @Override
    public Collection<String> a(final k k, final p p2, Collection<String> c) {
        if (!k.j()) {
            c = this.c(k, p2, c);
        }
        else {
            if (!this.c) {
                return this.b(k, p2, c);
            }
            while (true) {
                final org.codehaus.jackson.p b = k.b();
                if (b == org.codehaus.jackson.p.e) {
                    break;
                }
                String i;
                if (b == org.codehaus.jackson.p.m) {
                    i = null;
                }
                else {
                    i = k.k();
                }
                c.add(i);
            }
        }
        return c;
    }
    
    @Override
    public void a(final n n, final org.codehaus.jackson.c.t t) {
        final i o = this.d.o();
        if (o != null) {
            final a l = this.d.l();
            this.e = this.a(n, t, l, new org.codehaus.jackson.c.g(null, l, null, o));
        }
    }
    
    public Collection<String> b(final k k, final p p2) {
        if (this.e != null) {
            return (Collection<String>)this.d.a(this.e.a(k, p2));
        }
        return this.a(k, p2, (Collection<String>)this.d.m());
    }
    
    @Override
    public x<Object> d() {
        return (x<Object>)this.b;
    }
}
