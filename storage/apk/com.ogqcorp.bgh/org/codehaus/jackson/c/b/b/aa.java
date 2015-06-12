// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.util.Iterator;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.z;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import java.util.HashSet;
import org.codehaus.jackson.c.b.a.i;
import org.codehaus.jackson.c.b.t;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.af;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.ar;
import java.util.Map;

@b
public class aa extends g<Map<Object, Object>> implements ar
{
    protected final a a;
    protected final af b;
    protected final x<Object> c;
    protected final az d;
    protected final t e;
    protected final boolean f;
    protected i g;
    protected x<Object> h;
    protected HashSet<String> i;
    
    public aa(final a a, final t e, final af b, final x<Object> c, final az d) {
        super(Map.class);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        if (e.j()) {
            this.g = new i(e);
        }
        else {
            this.g = null;
        }
        this.f = e.h();
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        return az.a(k, p3);
    }
    
    @Override
    public Map<Object, Object> a(final k k, final p p3, final Map<Object, Object> map) {
        final org.codehaus.jackson.p e = k.e();
        if (e != org.codehaus.jackson.p.b && e != org.codehaus.jackson.p.f) {
            throw p3.b(this.e());
        }
        this.b(k, p3, map);
        return map;
    }
    
    protected void a(final Throwable t, final Object o) {
        Throwable cause;
        for (cause = t; cause instanceof InvocationTargetException && cause.getCause() != null; cause = cause.getCause()) {}
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        if (cause instanceof IOException && !(cause instanceof z)) {
            throw (IOException)cause;
        }
        throw z.a(cause, o, null);
    }
    
    @Override
    public void a(final n n, final org.codehaus.jackson.c.t t) {
        if (this.e.i()) {
            final a l = this.e.l();
            if (l == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.e.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            this.h = this.a(n, t, l, new org.codehaus.jackson.c.g(null, l, null, this.e.o()));
        }
        if (this.g != null) {
            for (final org.codehaus.jackson.c.b.i i : this.g.a()) {
                if (!i.f()) {
                    this.g.a(i, this.a(n, t, i.a(), i));
                }
            }
        }
    }
    
    public void a(final String[] array) {
        HashSet<String> a;
        if (array == null || array.length == 0) {
            a = null;
        }
        else {
            a = org.codehaus.jackson.c.i.b.a(array);
        }
        this.i = a;
    }
    
    public Map<Object, Object> b(final k k, final p p2) {
        if (this.g != null) {
            return this.c(k, p2);
        }
        if (this.h != null) {
            return (Map<Object, Object>)this.e.a(this.h.a(k, p2));
        }
        if (!this.f) {
            throw p2.a(this.e(), "No default constructor found");
        }
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.b || e == org.codehaus.jackson.p.f || e == org.codehaus.jackson.p.c) {
            final Map map = (Map)this.e.m();
            this.b(k, p2, map);
            return (Map<Object, Object>)map;
        }
        if (e == org.codehaus.jackson.p.h) {
            return (Map<Object, Object>)this.e.a(k.k());
        }
        throw p2.b(this.e());
    }
    
    protected final void b(final k k, final p p3, final Map<Object, Object> map) {
        org.codehaus.jackson.p p4 = k.e();
        if (p4 == org.codehaus.jackson.p.b) {
            p4 = k.b();
        }
        final af b = this.b;
        final x<Object> c = this.c;
        final az d = this.d;
        while (p4 == org.codehaus.jackson.p.f) {
            final String g = k.g();
            final Object a = b.a(g, p3);
            final org.codehaus.jackson.p b2 = k.b();
            if (this.i != null && this.i.contains(g)) {
                k.d();
            }
            else {
                Object o;
                if (b2 == org.codehaus.jackson.p.m) {
                    o = null;
                }
                else if (d == null) {
                    o = c.a(k, p3);
                }
                else {
                    o = c.a(k, p3, d);
                }
                map.put(a, o);
            }
            p4 = k.b();
        }
    }
    
    public Map<Object, Object> c(final k k, final p p2) {
        final i g = this.g;
        final org.codehaus.jackson.c.b.a.n a = g.a(k, p2);
        org.codehaus.jackson.p p3 = k.e();
        if (p3 == org.codehaus.jackson.p.b) {
            p3 = k.b();
        }
        final x<Object> c = this.c;
        final az d = this.d;
        while (p3 == org.codehaus.jackson.p.f) {
            final String g2 = k.g();
            final org.codehaus.jackson.p b = k.b();
            Label_0089: {
                if (this.i != null && this.i.contains(g2)) {
                    k.d();
                }
                else {
                    final org.codehaus.jackson.c.b.i a2 = g.a(g2);
                    if (a2 != null) {
                        if (!a.a(a2.j(), a2.a(k, p2))) {
                            break Label_0089;
                        }
                        k.b();
                        try {
                            final Map map = (Map)g.a(a);
                            this.b(k, p2, map);
                            return (Map<Object, Object>)map;
                        }
                        catch (Exception ex) {
                            this.a(ex, this.a.p());
                            return null;
                        }
                    }
                    final Object a3 = this.b.a(k.g(), p2);
                    Object o;
                    if (b == org.codehaus.jackson.p.m) {
                        o = null;
                    }
                    else if (d == null) {
                        o = c.a(k, p2);
                    }
                    else {
                        o = c.a(k, p2, d);
                    }
                    a.a(a3, o);
                }
            }
            p3 = k.b();
        }
        try {
            return (Map<Object, Object>)g.a(a);
        }
        catch (Exception ex2) {
            this.a(ex2, this.a.p());
            return null;
        }
    }
    
    @Override
    public x<Object> d() {
        return this.c;
    }
    
    public final Class<?> e() {
        return this.a.p();
    }
}
