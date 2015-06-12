// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import java.util.HashMap;
import org.codehaus.jackson.c.c;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.g;
import org.codehaus.jackson.c.h.j;
import java.util.Collection;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.e;
import org.codehaus.jackson.c.g.b.n;
import org.codehaus.jackson.c.au;
import java.util.ArrayList;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.f;
import java.util.Iterator;
import java.util.HashSet;
import java.util.List;
import org.codehaus.jackson.c.e.k;
import org.codehaus.jackson.c.at;
import org.codehaus.jackson.c.ay;
import org.codehaus.jackson.c.aw;

public class g extends b
{
    public static final g e;
    protected final aw f;
    
    static {
        e = new g(null);
    }
    
    protected g(aw f) {
        if (f == null) {
            f = new h();
        }
        this.f = f;
    }
    
    @Override
    protected Iterable<ay> a() {
        return this.f.c();
    }
    
    protected List<d> a(final at at, final k k, final List<d> list) {
        final String[] c = at.a().c(k.c());
        if (c != null && c.length > 0) {
            final HashSet<String> a = org.codehaus.jackson.c.i.b.a(c);
            final Iterator<d> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (a.contains(iterator.next().d())) {
                    iterator.remove();
                }
            }
        }
        return list;
    }
    
    protected ad<Object> a(final at at, final k k, final f f) {
        if (k.b() == Object.class) {
            throw new IllegalArgumentException("Can not create bean serializer for Object.class");
        }
        final org.codehaus.jackson.c.g.f a = this.a(k);
        List<d> c = this.c(at, k);
        if (c == null) {
            c = new ArrayList<d>();
        }
        List<d> a2;
        if (this.f.b()) {
            final Iterator<i> iterator = this.f.e().iterator();
            a2 = c;
            while (iterator.hasNext()) {
                a2 = iterator.next().a(at, k, a2);
            }
        }
        else {
            a2 = c;
        }
        final List<d> b = this.b(at, k, this.a(at, k, a2));
        List<d> b2;
        if (this.f.b()) {
            final Iterator<i> iterator2 = this.f.e().iterator();
            b2 = b;
            while (iterator2.hasNext()) {
                b2 = iterator2.next().b(at, k, b2);
            }
        }
        else {
            b2 = b;
        }
        a.a(b2);
        a.a(this.b(at, k));
        final org.codehaus.jackson.c.e.f p3 = k.p();
        if (p3 != null) {
            if (at.a(au.e)) {
                p3.k();
            }
            final org.codehaus.jackson.f.a a3 = p3.a(k.j());
            a.a(new a(p3, n.a(null, a3, at.a(au.h), this.b(at, a3.g(), f), f, null, null)));
        }
        this.a(at, a);
        org.codehaus.jackson.c.g.f a4;
        if (this.f.b()) {
            final Iterator<i> iterator3 = this.f.e().iterator();
            a4 = a;
            while (iterator3.hasNext()) {
                a4 = iterator3.next().a(at, k, a4);
            }
        }
        else {
            a4 = a;
        }
        ad<?> ad = a4.b();
        if (ad == null && k.h()) {
            ad = a4.c();
        }
        return (ad<Object>)ad;
    }
    
    public ad<Object> a(final at at, final org.codehaus.jackson.f.a a, final k k, final f f) {
        ad<?> a2;
        if (!this.b(a.p())) {
            a2 = null;
        }
        else {
            final ad<Object> a3 = this.a(at, k, f);
            if (!this.f.b()) {
                return a3;
            }
            final Iterator<i> iterator = this.f.e().iterator();
            a2 = a3;
            while (iterator.hasNext()) {
                a2 = iterator.next().a(at, k, a2);
            }
        }
        return (ad<Object>)a2;
    }
    
    @Override
    public ad<Object> a(final at at, final org.codehaus.jackson.f.a a, final f f) {
        final k k = at.b(a);
        final ad<Object> a2 = this.a(at, (org.codehaus.jackson.c.e.a)k.c(), f);
        ad<?> ad;
        if (a2 != null) {
            ad = a2;
        }
        else {
            final org.codehaus.jackson.f.a a3 = this.a(at, k.c(), a);
            final boolean b = a3 != a;
            k i;
            if (a3 != a && a3.p() != a.p()) {
                i = at.b(a3);
            }
            else {
                i = k;
            }
            if (a.f()) {
                return (ad<Object>)this.b(at, a3, i, f, b);
            }
            final Iterator<ay> iterator = this.f.c().iterator();
            while (iterator.hasNext()) {
                final ad<?> a4 = iterator.next().a(at, a3, i, f);
                if (a4 != null) {
                    return (ad<Object>)a4;
                }
            }
            ad = this.a(a3, at, i, f, b);
            if (ad == null) {
                ad = this.b(a3, at, i, f, b);
                if (ad == null) {
                    ad = this.a(at, a3, i, f);
                    if (ad == null) {
                        return (ad<Object>)this.a(at, a3, i, f, b);
                    }
                }
            }
        }
        return (ad<Object>)ad;
    }
    
    public ba a(final org.codehaus.jackson.f.a a, final at at, final org.codehaus.jackson.c.e.e e, final f f) {
        final org.codehaus.jackson.c.b a2 = at.a();
        final org.codehaus.jackson.c.f.d<?> a3 = a2.a(at, e, a);
        if (a3 == null) {
            return this.b(at, a, f);
        }
        return a3.a(at, a, at.l().a(e, at, a2), f);
    }
    
    protected d a(final at at, final j j, final org.codehaus.jackson.c.g.n n, final boolean b, final String s, final org.codehaus.jackson.c.e.e e) {
        if (at.a(au.e)) {
            e.k();
        }
        final org.codehaus.jackson.f.a a = e.a(j);
        final org.codehaus.jackson.c.g g = new org.codehaus.jackson.c.g(s, a, n.a(), e);
        final ad<Object> a2 = this.a(at, (org.codehaus.jackson.c.e.a)e, (f)g);
        final boolean e2 = l.e(a.p());
        ba b2 = null;
        if (e2) {
            b2 = this.b(a, at, e, g);
        }
        final d a3 = n.a(s, a, a2, this.a(a, at, e, g), b2, e, b);
        a3.a(at.a().g(e));
        return a3;
    }
    
    protected d a(final d d, final Class<?>[] array) {
        return org.codehaus.jackson.c.g.k.a(d, array);
    }
    
    protected org.codehaus.jackson.c.g.f a(final k k) {
        return new org.codehaus.jackson.c.g.f(k);
    }
    
    protected org.codehaus.jackson.c.g.n a(final at at, final k k) {
        return new org.codehaus.jackson.c.g.n(at, k);
    }
    
    protected void a(final at at, final org.codehaus.jackson.c.g.f f) {
        final List<d> a = f.a();
        final boolean a2 = at.a(au.i);
        final int size = a.size();
        final d[] array = new d[size];
        int i = 0;
        int n = 0;
    Label_0083_Outer:
        while (i < size) {
            final d d = a.get(i);
            final Class<?>[] h = d.h();
            while (true) {
                Label_0109: {
                    if (h != null) {
                        ++n;
                        array[i] = this.a(d, h);
                        break Label_0109;
                    }
                    if (!a2) {
                        break Label_0109;
                    }
                    array[i] = d;
                    final int n2 = n;
                    ++i;
                    n = n2;
                    continue Label_0083_Outer;
                }
                final int n2 = n;
                continue;
            }
        }
        if (a2 && n == 0) {
            return;
        }
        f.a(array);
    }
    
    protected Object b(final at at, final k k) {
        return at.a().f(k.c());
    }
    
    @Deprecated
    protected List<d> b(final at at, final k k, final List<d> list) {
        return list;
    }
    
    public ba b(final org.codehaus.jackson.f.a a, final at at, final org.codehaus.jackson.c.e.e e, final f f) {
        final org.codehaus.jackson.f.a g = a.g();
        final org.codehaus.jackson.c.b a2 = at.a();
        final org.codehaus.jackson.c.f.d<?> b = a2.b(at, e, a);
        if (b == null) {
            return this.b(at, g, f);
        }
        return b.a(at, g, at.l().a(e, at, a2), f);
    }
    
    protected boolean b(final Class<?> clazz) {
        return l.a(clazz) == null && !l.c(clazz);
    }
    
    protected List<d> c(final at at, final k k) {
        final List<org.codehaus.jackson.c.h> d = k.d();
        final org.codehaus.jackson.c.b a = at.a();
        this.c(at, k, d);
        if (at.a(au.f)) {
            this.d(at, k, d);
        }
        if (d.isEmpty()) {
            return null;
        }
        final boolean a2 = this.a(at, k, null, null);
        final org.codehaus.jackson.c.g.n a3 = this.a(at, k);
        final ArrayList list = new ArrayList<d>(d.size());
        final j j = k.j();
        for (final org.codehaus.jackson.c.h h : d) {
            final org.codehaus.jackson.c.e.e i = h.k();
            final c a4 = a.a(i);
            if (a4 == null || !a4.c()) {
                final String a5 = h.a();
                if (i instanceof org.codehaus.jackson.c.e.f) {
                    list.add(this.a(at, j, a3, a2, a5, i));
                }
                else {
                    list.add(this.a(at, j, a3, a2, a5, i));
                }
            }
        }
        return (List<d>)list;
    }
    
    @Override
    public ad<Object> c(final at at, final org.codehaus.jackson.f.a a, final f f) {
        final boolean a2 = this.f.a();
        ad<?> a3 = null;
        if (a2) {
            final k k = at.c(a.p());
            final Iterator<ay> iterator = this.f.d().iterator();
            while (iterator.hasNext()) {
                a3 = iterator.next().a(at, a, k, f);
                if (a3 != null) {
                    return (ad<Object>)a3;
                }
            }
        }
        return (ad<Object>)a3;
    }
    
    protected void c(final at at, final k k, final List<org.codehaus.jackson.c.h> list) {
        final org.codehaus.jackson.c.b a = at.a();
        final HashMap<Object, Boolean> hashMap = (HashMap<Object, Boolean>)new HashMap<Class<?>, Boolean>();
        final Iterator<org.codehaus.jackson.c.h> iterator = list.iterator();
        while (iterator.hasNext()) {
            final org.codehaus.jackson.c.e.e i = iterator.next().k();
            if (i == null) {
                iterator.remove();
            }
            else {
                final Class<?> d = i.d();
                Boolean value = hashMap.get(d);
                if (value == null) {
                    value = a.e(at.c(d).c());
                    if (value == null) {
                        value = Boolean.FALSE;
                    }
                    hashMap.put(d, value);
                }
                if (!value) {
                    continue;
                }
                iterator.remove();
            }
        }
    }
    
    protected void d(final at at, final k k, final List<org.codehaus.jackson.c.h> list) {
        final Iterator<org.codehaus.jackson.c.h> iterator = list.iterator();
        while (iterator.hasNext()) {
            final org.codehaus.jackson.c.h h = iterator.next();
            if (!h.g() && !h.b()) {
                iterator.remove();
            }
        }
    }
}
