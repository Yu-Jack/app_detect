// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import java.util.Collection;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.b.i;
import java.util.HashMap;
import org.codehaus.jackson.c.b.t;

public final class i
{
    protected final t a;
    protected final HashMap<String, org.codehaus.jackson.c.b.i> b;
    protected final int c;
    protected Object[] d;
    protected final org.codehaus.jackson.c.b.i[] e;
    
    public i(final t a) {
        Object[] d = null;
        this.a = a;
        this.b = new HashMap<String, org.codehaus.jackson.c.b.i>();
        final org.codehaus.jackson.c.b.i[] k = a.k();
        final int length = k.length;
        this.c = length;
        int i = 0;
        org.codehaus.jackson.c.b.i[] e = null;
        while (i < length) {
            final org.codehaus.jackson.c.b.i value = k[i];
            this.b.put(value.c(), value);
            if (value.a().t()) {
                if (d == null) {
                    d = new Object[length];
                }
                d[i] = l.f(value.a().p());
            }
            if (value.k() != null) {
                if (e == null) {
                    e = new org.codehaus.jackson.c.b.i[length];
                }
                e[i] = value;
            }
            ++i;
        }
        this.d = d;
        this.e = e;
    }
    
    public Object a(final n n) {
        final Object a = this.a.a(n.a(this.d));
        for (j j = n.a(); j != null; j = j.a) {
            j.a(a);
        }
        return a;
    }
    
    public Collection<org.codehaus.jackson.c.b.i> a() {
        return this.b.values();
    }
    
    public n a(final k k, final p p2) {
        final n n = new n(k, p2, this.c);
        if (this.e != null) {
            n.a(this.e);
        }
        return n;
    }
    
    public org.codehaus.jackson.c.b.i a(final String key) {
        return this.b.get(key);
    }
    
    public void a(final org.codehaus.jackson.c.b.i i, final x<Object> x) {
        final org.codehaus.jackson.c.b.i a = i.a(x);
        this.b.put(a.c(), a);
        final Object b = x.b();
        if (b != null) {
            if (this.d == null) {
                this.d = new Object[this.b.size()];
            }
            this.d[a.j()] = b;
        }
    }
}
