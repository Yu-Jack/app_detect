// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.i;
import org.codehaus.jackson.c.h.d;
import org.codehaus.jackson.c.h.g;
import org.codehaus.jackson.c.j;
import org.codehaus.jackson.c.e.b;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.h;
import org.codehaus.jackson.c.af;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.ar;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.b.k;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.r;
import java.util.HashMap;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.f.a;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.c.t;

public class q extends t
{
    protected final ConcurrentHashMap<a, x<Object>> a;
    protected final HashMap<a, x<Object>> b;
    protected final org.codehaus.jackson.c.i.x c;
    protected r d;
    
    public q() {
        this(e.h);
    }
    
    public q(final r d) {
        this.a = new ConcurrentHashMap<a, x<Object>>(64, 0.75f, 2);
        this.b = new HashMap<a, x<Object>>(8);
        this.d = d;
        this.c = new org.codehaus.jackson.c.i.x();
    }
    
    @Override
    public k a(final n n, final a a) {
        return this.c.a(a, n);
    }
    
    @Override
    public x<Object> a(final n n, final a a, final f f) {
        x<Object> x = this.a(a);
        if (x != null) {
            if (x instanceof org.codehaus.jackson.c.k) {
                x = ((org.codehaus.jackson.c.k<Object>)x).a(n, f);
            }
        }
        else {
            x = this.d(n, a, f);
            if (x == null) {
                x = this.b(a);
            }
            if (x instanceof org.codehaus.jackson.c.k) {
                return ((org.codehaus.jackson.c.k<Object>)x).a(n, f);
            }
        }
        return x;
    }
    
    protected x<Object> a(final a key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return this.a.get(key);
    }
    
    protected void a(final n n, final ar ar) {
        ar.a(n, this);
    }
    
    @Override
    public x<Object> b(final n n, final a a, final f f) {
        final x<Object> a2 = this.a(n, a, f);
        final az b = this.d.b(n, a, f);
        if (b != null) {
            return new org.codehaus.jackson.c.b.r(b, a2);
        }
        return a2;
    }
    
    protected x<Object> b(final a a) {
        if (!l.d(a.p())) {
            throw new z("Can not find a Value deserializer for abstract type " + a);
        }
        throw new z("Can not find a Value deserializer for type " + a);
    }
    
    @Override
    public af c(final n n, final a a, final f f) {
        af af = this.d.a(n, a, f);
        if (af instanceof org.codehaus.jackson.c.l) {
            af = ((org.codehaus.jackson.c.l)af).a(n, f);
        }
        if (af == null) {
            af = this.c(a);
        }
        return af;
    }
    
    protected af c(final a obj) {
        throw new z("Can not find a (Map) Key deserializer for type " + obj);
    }
    
    protected x<Object> d(final n n, final a key, final f f) {
        final int size;
        synchronized (this.b) {
            final x<Object> a = this.a(key);
            if (a != null) {
                return a;
            }
            size = this.b.size();
            if (size > 0) {
                final x<Object> x = this.b.get(key);
                if (x != null) {
                    return x;
                }
            }
        }
        try {
            final x<Object> e = this.e(n, key, f);
            if (size == 0 && this.b.size() > 0) {
                this.b.clear();
            }
            // monitorexit(hashMap)
            return e;
        }
        finally {
            if (size == 0 && this.b.size() > 0) {
                this.b.clear();
            }
        }
    }
    
    protected x<Object> e(final n n, final a key, final f f) {
        Object f2;
        while (true) {
            try {
                f2 = this.f(n, key, f);
                if (f2 == null) {
                    f2 = null;
                    return (x<Object>)f2;
                }
            }
            catch (IllegalArgumentException ex) {
                throw new z(ex.getMessage(), null, ex);
            }
            final boolean b = f2 instanceof ar;
            boolean booleanValue;
            if (((x<Object>)f2).getClass() == c.class) {
                booleanValue = true;
            }
            else {
                booleanValue = false;
            }
            if (!booleanValue && n.a(o.a)) {
                final org.codehaus.jackson.c.b a = n.a();
                final Boolean a2 = a.a(org.codehaus.jackson.c.e.b.a(((x<Object>)f2).getClass(), a, null));
                if (a2 != null) {
                    booleanValue = a2;
                }
            }
            if (b) {
                this.b.put(key, (x<Object>)f2);
                this.a(n, (ar)f2);
                this.b.remove(key);
            }
            if (booleanValue) {
                break;
            }
            return (x<Object>)f2;
        }
        this.a.put(key, (x<Object>)f2);
        return (x<Object>)f2;
    }
    
    protected x<Object> f(final n n, final a a, final f f) {
        if (a.r()) {
            return (x<Object>)this.d.b(n, this, a, f);
        }
        if (a.f()) {
            if (a.b()) {
                return (x<Object>)this.d.a(n, this, (org.codehaus.jackson.c.h.a)a, f);
            }
            if (a.j()) {
                final org.codehaus.jackson.c.h.f f2 = (org.codehaus.jackson.c.h.f)a;
                if (f2.l()) {
                    return (x<Object>)this.d.a(n, this, (g)f2, f);
                }
                return (x<Object>)this.d.a(n, this, f2, f);
            }
            else if (a.i()) {
                final org.codehaus.jackson.c.h.c c = (org.codehaus.jackson.c.h.c)a;
                if (c.b_()) {
                    return (x<Object>)this.d.a(n, this, (d)c, f);
                }
                return (x<Object>)this.d.a(n, this, c, f);
            }
        }
        if (i.class.isAssignableFrom(a.p())) {
            return (x<Object>)this.d.c(n, this, a, f);
        }
        return this.d.a(n, this, a, f);
    }
}
