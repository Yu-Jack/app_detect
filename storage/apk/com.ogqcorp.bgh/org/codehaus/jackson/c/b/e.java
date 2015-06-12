// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import java.lang.reflect.Member;
import org.codehaus.jackson.c.b.b.bx;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.c;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.g;
import org.codehaus.jackson.c.e.h;
import org.codehaus.jackson.c.e;
import org.codehaus.jackson.c.ah;
import java.util.Iterator;
import org.codehaus.jackson.c.i.o;
import org.codehaus.jackson.c.b.b.bs;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.e.k;
import org.codehaus.jackson.c.af;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.u;
import org.codehaus.jackson.c.s;

public class e extends b
{
    public static final e h;
    private static final Class<?>[] j;
    protected final s i;
    
    static {
        j = new Class[] { Throwable.class };
        h = new e(null);
    }
    
    public e() {
        this(null);
    }
    
    public e(s i) {
        if (i == null) {
            i = new f();
        }
        this.i = i;
    }
    
    private af c(final n n, final a a, final org.codehaus.jackson.c.f f) {
        final k k = n.b(a);
        final Class<?> p3 = a.p();
        final o<?> a2 = this.a(p3, n);
        for (final org.codehaus.jackson.c.e.f f2 : k.o()) {
            if (n.a().k(f2)) {
                if (f2.f() != 1 || !f2.d().isAssignableFrom(p3)) {
                    throw new IllegalArgumentException("Unsuitable method (" + f2 + ") decorated with @JsonCreator (for Enum type " + p3.getName() + ")");
                }
                if (f2.b(0) != String.class) {
                    throw new IllegalArgumentException("Parameter #0 type for factory method (" + f2 + ") not suitable, must be java.lang.String");
                }
                if (n.c()) {
                    l.a(f2.i());
                }
                return bs.a(a2, f2);
            }
        }
        return bs.a(a2);
    }
    
    @Override
    public af a(final n n, final a key, final org.codehaus.jackson.c.f f) {
        if (this.i.f()) {
            final k k = n.c(key.p());
            final Iterator<ah> iterator = this.i.b().iterator();
            while (iterator.hasNext()) {
                final af a = iterator.next().a(key, n, k, f);
                if (a != null) {
                    return a;
                }
            }
        }
        Label_0081: {
            break Label_0081;
        }
        final Class<?> p3 = key.p();
        if (p3 == String.class || p3 == Object.class) {
            return bs.a(n, key);
        }
        final af af = e.c.get(key);
        if (af != null) {
            return af;
        }
        if (key.r()) {
            return this.c(n, key, f);
        }
        return bs.b(n, key);
    }
    
    protected org.codehaus.jackson.c.b.a.e a(final n n, final k k, final String s, final int n2, final h h, final Object o) {
        final a a = n.m().a(h.e(), k.j());
        g a2 = new g(s, a, k.i(), h);
        final a a3 = this.a(n, k, a, h, a2);
        if (a3 != a) {
            a2 = a2.a(a3);
        }
        final x<Object> a4 = this.a(n, h, a2);
        final a a5 = this.a(n, h, a3, s);
        final az az = a5.o();
        az b;
        if (az == null) {
            b = this.b(n, a5, a2);
        }
        else {
            b = az;
        }
        org.codehaus.jackson.c.b.a.e b2 = new org.codehaus.jackson.c.b.a.e(s, a5, b, k.i(), h, n2, o);
        if (a4 != null) {
            b2 = b2.b(a4);
        }
        return b2;
    }
    
    protected d a(final k k) {
        return new d(k);
    }
    
    protected org.codehaus.jackson.c.b.h a(final n n, final k k, final org.codehaus.jackson.c.e.f f) {
        if (n.a(org.codehaus.jackson.c.o.f)) {
            f.k();
        }
        final a a = k.j().a(f.b(1));
        final g g = new g(f.b(), a, k.i(), f);
        final a a2 = this.a(n, k, a, f, g);
        final x<Object> a3 = this.a(n, f, g);
        if (a3 != null) {
            return new org.codehaus.jackson.c.b.h(g, f, a2, a3);
        }
        return new org.codehaus.jackson.c.b.h(g, f, this.a(n, f, a2, g.c()), null);
    }
    
    protected i a(final n n, final k k, final String s, final org.codehaus.jackson.c.e.d d) {
        if (n.a(org.codehaus.jackson.c.o.f)) {
            d.k();
        }
        final a a = k.j().a(d.c());
        g a2 = new g(s, a, k.i(), d);
        final a a3 = this.a(n, k, a, d, a2);
        if (a3 != a) {
            a2 = a2.a(a3);
        }
        final x<Object> a4 = this.a(n, d, a2);
        final a a5 = this.a(n, d, a3, s);
        i a6 = new j(s, a5, a5.o(), k.i(), d);
        if (a4 != null) {
            a6 = a6.a(a4);
        }
        final c a7 = n.a().a((org.codehaus.jackson.c.e.e)d);
        if (a7 != null && a7.b()) {
            a6.a(a7.a());
        }
        return a6;
    }
    
    protected i a(final n n, final k k, final String s, final org.codehaus.jackson.c.e.f f) {
        if (n.a(org.codehaus.jackson.c.o.f)) {
            f.k();
        }
        final a a = k.j().a(f.b(0));
        g a2 = new g(s, a, k.i(), f);
        final a a3 = this.a(n, k, a, f, a2);
        if (a3 != a) {
            a2 = a2.a(a3);
        }
        final x<Object> a4 = this.a(n, f, a2);
        final a a5 = this.a(n, f, a3, s);
        i a6 = new m(s, a5, a5.o(), k.i(), f);
        if (a4 != null) {
            a6 = a6.a(a4);
        }
        final c a7 = n.a().a((org.codehaus.jackson.c.e.e)f);
        if (a7 != null && a7.b()) {
            a6.a(a7.a());
        }
        return a6;
    }
    
    @Override
    public t a(final n n, final k k) {
        final org.codehaus.jackson.c.e.b c = k.c();
        final Object j = n.a().j(c);
        t t;
        if (j != null) {
            if (j instanceof t) {
                t = (t)j;
            }
            else {
                if (!(j instanceof Class)) {
                    throw new IllegalStateException("Invalid value instantiator returned for type " + k + ": neither a Class nor ValueInstantiator");
                }
                final Class<?> clazz = (Class<?>)j;
                if (!t.class.isAssignableFrom(clazz)) {
                    throw new IllegalStateException("Invalid instantiator Class<?> returned for type " + k + ": " + clazz.getName() + " not a ValueInstantiator");
                }
                t = n.c(c, (Class<? extends t>)clazz);
            }
        }
        else {
            t = this.c(n, k);
        }
        t a;
        if (this.i.i()) {
            final Iterator<org.codehaus.jackson.c.b.u> iterator = this.i.e().iterator();
            a = t;
            while (iterator.hasNext()) {
                final org.codehaus.jackson.c.b.u u = iterator.next();
                a = u.a(n, k, a);
                if (a == null) {
                    throw new z("Broken registered ValueInstantiators (of type " + u.getClass().getName() + "): returned null ValueInstantiator");
                }
            }
        }
        else {
            a = t;
        }
        return a;
    }
    
    @Override
    protected x<?> a(final Class<?> clazz, final n n, final k k, final org.codehaus.jackson.c.f f) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a = iterator.next().a(clazz, n, k, f);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    protected x<?> a(final Class<? extends org.codehaus.jackson.i> clazz, final n n, final org.codehaus.jackson.c.f f) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a = iterator.next().a(clazz, n, f);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    protected x<?> a(final org.codehaus.jackson.c.h.a a, final n n, final org.codehaus.jackson.c.t t, final org.codehaus.jackson.c.f f, final az az, final x<?> x) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a2 = iterator.next().a(a, n, t, f, az, x);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }
    
    @Override
    protected x<?> a(final org.codehaus.jackson.c.h.c c, final n n, final org.codehaus.jackson.c.t t, final k k, final org.codehaus.jackson.c.f f, final az az, final x<?> x) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a = iterator.next().a(c, n, t, k, f, az, x);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    protected x<?> a(final org.codehaus.jackson.c.h.d d, final n n, final org.codehaus.jackson.c.t t, final k k, final org.codehaus.jackson.c.f f, final az az, final x<?> x) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a = iterator.next().a(d, n, t, k, f, az, x);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    protected x<?> a(final org.codehaus.jackson.c.h.f f, final n n, final org.codehaus.jackson.c.t t, final k k, final org.codehaus.jackson.c.f f2, final af af, final az az, final x<?> x) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a = iterator.next().a(f, n, t, k, f2, af, az, x);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    protected x<?> a(final org.codehaus.jackson.c.h.g g, final n n, final org.codehaus.jackson.c.t t, final k k, final org.codehaus.jackson.c.f f, final af af, final az az, final x<?> x) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a = iterator.next().a(g, n, t, k, f, af, az, x);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    public x<Object> a(final n n, final org.codehaus.jackson.c.t t, a a, final org.codehaus.jackson.c.f f) {
        if (a.c()) {
            a = this.a(n, a);
        }
        final k k = n.b(a);
        final x<Object> a2 = this.a(n, k.c(), f);
        x<Object> x;
        if (a2 != null) {
            x = a2;
        }
        else {
            a a3 = this.a(n, k.c(), a, null);
            k i;
            if (a3.p() != a.p()) {
                i = n.b(a3);
            }
            else {
                i = k;
                a3 = a;
            }
            x = this.a(a3, n, t, i, f);
            if (x == null) {
                if (a3.q()) {
                    return this.b(n, a3, i, f);
                }
                if (a3.c()) {
                    final a b = this.b(n, i);
                    if (b != null) {
                        return this.a(n, b, (k)n.b(b), f);
                    }
                }
                x = this.d(n, t, a3, f);
                if (x == null) {
                    if (!this.a(a3.p())) {
                        return null;
                    }
                    return this.a(n, a3, i, f);
                }
            }
        }
        return x;
    }
    
    public x<Object> a(final n n, final a a, final k k, final org.codehaus.jackson.c.f f) {
        final t a2 = this.a(n, k);
        x<?> a3;
        if (a.c() && !a2.b()) {
            a3 = new org.codehaus.jackson.c.b.a(a);
        }
        else {
            final d a4 = this.a(k);
            a4.a(a2);
            this.a(n, k, a4);
            this.b(n, k, a4);
            this.c(n, k, a4);
            d a5;
            if (this.i.g()) {
                final Iterator<org.codehaus.jackson.c.b.g> iterator = this.i.c().iterator();
                a5 = a4;
                while (iterator.hasNext()) {
                    a5 = iterator.next().a(n, k, a5);
                }
            }
            else {
                a5 = a4;
            }
            final x<?> a6 = a5.a(f);
            if (!this.i.g()) {
                return (x<Object>)a6;
            }
            final Iterator<org.codehaus.jackson.c.b.g> iterator2 = this.i.c().iterator();
            a3 = a6;
            while (iterator2.hasNext()) {
                a3 = iterator2.next().a(n, k, a3);
            }
        }
        return (x<Object>)a3;
    }
    
    protected x<Object> a(final a a, final n n, final org.codehaus.jackson.c.t t, final k k, final org.codehaus.jackson.c.f f) {
        final Iterator<u> iterator = this.i.a().iterator();
        while (iterator.hasNext()) {
            final x<?> a2 = iterator.next().a(a, n, t, k, f);
            if (a2 != null) {
                return (x<Object>)a2;
            }
        }
        return null;
    }
    
    @Override
    public a a(final n n, a obj) {
        while (true) {
            final a b = this.b(n, obj);
            if (b == null) {
                return obj;
            }
            final Class<?> p2 = obj.p();
            final Class<?> p3 = b.p();
            if (p2 == p3 || !p2.isAssignableFrom(p3)) {
                throw new IllegalArgumentException("Invalid abstract type resolution from " + obj + " to " + b + ": latter is not a subtype of former");
            }
            obj = b;
        }
    }
    
    protected void a(final n n, final k k, final d d) {
        final List<org.codehaus.jackson.c.h> d2 = k.d();
        final org.codehaus.jackson.c.b a = n.a();
        final Boolean d3 = a.d(k.c());
        if (d3 != null) {
            d.a(d3);
        }
        final HashSet<String> a2 = org.codehaus.jackson.c.i.b.a(a.c(k.c()));
        final Iterator<String> iterator = a2.iterator();
        while (iterator.hasNext()) {
            d.a(iterator.next());
        }
        final org.codehaus.jackson.c.e.f l = k.l();
        Set<String> set;
        if (l == null) {
            set = k.f();
        }
        else {
            set = k.g();
        }
        if (set != null) {
            final Iterator<Object> iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                d.a(iterator2.next());
            }
        }
        final HashMap<Class<?>, Boolean> hashMap = new HashMap<Class<?>, Boolean>();
        for (final org.codehaus.jackson.c.h h : d2) {
            final String a3 = h.a();
            if (!a2.contains(a3)) {
                if (h.f()) {
                    d.a(h);
                }
                else if (h.d()) {
                    final org.codehaus.jackson.c.e.f i = h.i();
                    if (this.a(n, k, i.a(0), hashMap)) {
                        d.a(a3);
                    }
                    else {
                        final i a4 = this.a(n, k, a3, i);
                        if (a4 == null) {
                            continue;
                        }
                        d.a(a4);
                    }
                }
                else {
                    if (!h.e()) {
                        continue;
                    }
                    final org.codehaus.jackson.c.e.d j = h.j();
                    if (this.a(n, k, j.d(), hashMap)) {
                        d.a(a3);
                    }
                    else {
                        final i a5 = this.a(n, k, a3, j);
                        if (a5 == null) {
                            continue;
                        }
                        d.a(a5);
                    }
                }
            }
        }
        if (l != null) {
            d.a(this.a(n, k, l));
        }
        if (n.a(org.codehaus.jackson.c.o.e)) {
            for (final org.codehaus.jackson.c.h h2 : d2) {
                if (h2.c()) {
                    final String a6 = h2.a();
                    if (d.b(a6) || a2.contains(a6)) {
                        continue;
                    }
                    final org.codehaus.jackson.c.e.f h3 = h2.h();
                    final Class<?> d4 = h3.d();
                    if ((!Collection.class.isAssignableFrom(d4) && !Map.class.isAssignableFrom(d4)) || a2.contains(a6) || d.b(a6)) {
                        continue;
                    }
                    d.a(this.b(n, k, a6, h3));
                }
            }
        }
    }
    
    protected void a(final n n, final k k, final org.codehaus.jackson.c.e.x<?> x, final org.codehaus.jackson.c.b b, final org.codehaus.jackson.c.b.a.d d) {
        for (final org.codehaus.jackson.c.e.c c : k.n()) {
            final int f = c.f();
            if (f >= 1) {
                final boolean i = b.k(c);
                final boolean a = x.a(c);
                if (f == 1) {
                    this.a(n, k, x, b, d, c, i, a);
                }
                else {
                    if (!i && !a) {
                        continue;
                    }
                    h h = null;
                    int n2 = 0;
                    int n3 = 0;
                    final org.codehaus.jackson.c.b.a.e[] array = new org.codehaus.jackson.c.b.a.e[f];
                    h c2;
                    for (int j = 0; j < f; ++j, h = c2) {
                        c2 = c.c(j);
                        String a2;
                        if (c2 == null) {
                            a2 = null;
                        }
                        else {
                            a2 = b.a(c2);
                        }
                        final Object d2 = b.d(c2);
                        if (a2 != null && a2.length() > 0) {
                            ++n2;
                            array[j] = this.a(n, k, a2, j, c2, d2);
                            c2 = h;
                        }
                        else if (d2 != null) {
                            ++n3;
                            array[j] = this.a(n, k, a2, j, c2, d2);
                            c2 = h;
                        }
                        else if (h != null) {
                            c2 = h;
                        }
                    }
                    if (!i && n2 <= 0 && n3 <= 0) {
                        continue;
                    }
                    if (n2 + n3 == f) {
                        d.a(c, array);
                    }
                    else {
                        if (n2 == 0 && n3 + 1 == f) {
                            throw new IllegalArgumentException("Delegated constructor with Injectables not yet supported (see [JACKSON-712]) for " + c);
                        }
                        throw new IllegalArgumentException("Argument #" + h.g() + " of constructor " + c + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                    }
                }
            }
        }
    }
    
    protected boolean a(final Class<?> clazz) {
        final String a = l.a(clazz);
        if (a != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + clazz.getName() + " (of type " + a + ") as a Bean");
        }
        if (l.c(clazz)) {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + clazz.getName() + " as a Bean");
        }
        final String a2 = l.a(clazz, true);
        if (a2 != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + clazz.getName() + " (of type " + a2 + ") as a Bean");
        }
        return true;
    }
    
    protected boolean a(final n n, final k k, final Class<?> clazz, final Map<Class<?>, Boolean> map) {
        Boolean b = map.get(clazz);
        if (b == null) {
            b = n.a().e(n.c(clazz).c());
            if (b == null) {
                b = Boolean.FALSE;
            }
        }
        return b;
    }
    
    protected boolean a(final n n, final k k, final org.codehaus.jackson.c.e.x<?> x, final org.codehaus.jackson.c.b b, final org.codehaus.jackson.c.b.a.d d, final org.codehaus.jackson.c.e.c c, final boolean b2, final boolean b3) {
        final h c2 = c.c(0);
        final String a = b.a(c2);
        final Object d2 = b.d(c2);
        if (d2 != null || (a != null && a.length() > 0)) {
            d.a(c, new org.codehaus.jackson.c.b.a.e[] { this.a(n, k, a, 0, c2, d2) });
            return true;
        }
        final Class<?> a2 = c.a(0);
        if (a2 == String.class) {
            if (b2 || b3) {
                d.a((org.codehaus.jackson.c.e.i)c);
            }
            return true;
        }
        if (a2 == Integer.TYPE || a2 == Integer.class) {
            if (b2 || b3) {
                d.b(c);
            }
            return true;
        }
        if (a2 == Long.TYPE || a2 == Long.class) {
            if (b2 || b3) {
                d.c(c);
            }
            return true;
        }
        if (a2 == Double.TYPE || a2 == Double.class) {
            if (b2 || b3) {
                d.d(c);
            }
            return true;
        }
        if (b2) {
            d.f(c);
            return true;
        }
        return false;
    }
    
    protected boolean a(final n n, final k k, final org.codehaus.jackson.c.e.x<?> x, final org.codehaus.jackson.c.b b, final org.codehaus.jackson.c.b.a.d d, final org.codehaus.jackson.c.e.f f, final boolean b2) {
        final Class<?> a = f.a(0);
        if (a == String.class) {
            if (b2 || x.a((org.codehaus.jackson.c.e.e)f)) {
                d.a(f);
            }
        }
        else if (a == Integer.TYPE || a == Integer.class) {
            if (b2 || x.a((org.codehaus.jackson.c.e.e)f)) {
                d.b(f);
                return true;
            }
        }
        else if (a == Long.TYPE || a == Long.class) {
            if (b2 || x.a((org.codehaus.jackson.c.e.e)f)) {
                d.c(f);
                return true;
            }
        }
        else if (a == Double.TYPE || a == Double.class) {
            if (b2 || x.a((org.codehaus.jackson.c.e.e)f)) {
                d.d(f);
                return true;
            }
        }
        else if (a == Boolean.TYPE || a == Boolean.class) {
            if (b2 || x.a((org.codehaus.jackson.c.e.e)f)) {
                d.e(f);
                return true;
            }
        }
        else {
            if (b.k(f)) {
                d.f(f);
                return true;
            }
            return false;
        }
        return true;
    }
    
    protected i b(final n n, final k k, final String s, final org.codehaus.jackson.c.e.f f) {
        if (n.a(org.codehaus.jackson.c.o.f)) {
            f.k();
        }
        final a a = f.a(k.j());
        final x<Object> a2 = this.a(n, f, new g(s, a, k.i(), f));
        final a a3 = this.a(n, f, a, s);
        i a4 = new org.codehaus.jackson.c.b.o(s, a3, a3.o(), k.i(), f);
        if (a2 != null) {
            a4 = a4.a(a2);
        }
        return a4;
    }
    
    public x<Object> b(final n n, final a a, final k k, final org.codehaus.jackson.c.f f) {
        final d a2 = this.a(k);
        a2.a(this.a(n, k));
        this.a(n, k, a2);
        final org.codehaus.jackson.c.e.f a3 = k.a("initCause", e.j);
        if (a3 != null) {
            final i a4 = this.a(n, k, "cause", a3);
            if (a4 != null) {
                a2.a(a4, true);
            }
        }
        a2.a("localizedMessage");
        a2.a("message");
        a2.a("suppressed");
        d a5;
        if (this.i.g()) {
            final Iterator<org.codehaus.jackson.c.b.g> iterator = this.i.c().iterator();
            a5 = a2;
            while (iterator.hasNext()) {
                a5 = iterator.next().a(n, k, a5);
            }
        }
        else {
            a5 = a2;
        }
        x<?> a6 = a5.a(f);
        if (a6 instanceof org.codehaus.jackson.c.b.c) {
            a6 = new bx((org.codehaus.jackson.c.b.c)a6);
        }
        x<?> a7;
        if (this.i.g()) {
            final Iterator<org.codehaus.jackson.c.b.g> iterator2 = this.i.c().iterator();
            a7 = a6;
            while (iterator2.hasNext()) {
                a7 = iterator2.next().a(n, k, a7);
            }
        }
        else {
            a7 = a6;
        }
        return (x<Object>)a7;
    }
    
    protected a b(final n n, final k k) {
        final a a = k.a();
        final Iterator<org.codehaus.jackson.c.a> iterator = this.i.d().iterator();
        while (iterator.hasNext()) {
            final a b = iterator.next().b(n, a);
            if (b != null) {
                return b;
            }
        }
        return null;
    }
    
    protected a b(final n n, final a a) {
        final Class<?> p2 = a.p();
        if (this.i.h()) {
            final Iterator<org.codehaus.jackson.c.a> iterator = this.i.d().iterator();
            while (iterator.hasNext()) {
                final a a2 = iterator.next().a(n, a);
                if (a2 != null && a2.p() != p2) {
                    return a2;
                }
            }
        }
        return null;
    }
    
    protected void b(final n n, final k k, final d d) {
        final Map<String, org.codehaus.jackson.c.e.e> q = k.q();
        if (q != null) {
            for (final Map.Entry<String, org.codehaus.jackson.c.e.e> entry : q.entrySet()) {
                final String s = entry.getKey();
                final org.codehaus.jackson.c.e.e e = entry.getValue();
                if (e instanceof org.codehaus.jackson.c.e.f) {
                    d.a(s, this.a(n, k, e.b(), (org.codehaus.jackson.c.e.f)e));
                }
                else {
                    d.a(s, this.a(n, k, e.b(), (org.codehaus.jackson.c.e.d)e));
                }
            }
        }
    }
    
    protected void b(final n n, final k k, final org.codehaus.jackson.c.e.x<?> x, final org.codehaus.jackson.c.b b, final org.codehaus.jackson.c.b.a.d d) {
        for (final org.codehaus.jackson.c.e.f obj : k.o()) {
            final int f = obj.f();
            if (f >= 1) {
                final boolean i = b.k(obj);
                if (f == 1) {
                    final h c = obj.c(0);
                    final String a = b.a(c);
                    if (b.d(c) == null && (a == null || a.length() == 0)) {
                        this.a(n, k, x, b, d, obj, i);
                        continue;
                    }
                }
                else if (!b.k(obj)) {
                    continue;
                }
                final org.codehaus.jackson.c.b.a.e[] array = new org.codehaus.jackson.c.b.a.e[f];
                for (int j = 0; j < f; ++j) {
                    final h c2 = obj.c(j);
                    final String a2 = b.a(c2);
                    final Object d2 = b.d(c2);
                    if ((a2 == null || a2.length() == 0) && d2 == null) {
                        throw new IllegalArgumentException("Argument #" + j + " of factory method " + obj + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
                    }
                    array[j] = this.a(n, k, a2, j, c2, d2);
                }
                d.a(obj, array);
            }
        }
    }
    
    protected t c(final n n, final k k) {
        final boolean a = n.a(org.codehaus.jackson.c.o.f);
        final org.codehaus.jackson.c.b.a.d d = new org.codehaus.jackson.c.b.a.d(k, a);
        final org.codehaus.jackson.c.b a2 = n.a();
        if (k.a().d()) {
            final org.codehaus.jackson.c.e.c i = k.k();
            if (i != null) {
                if (a) {
                    l.a(i.e());
                }
                d.a(i);
            }
        }
        final org.codehaus.jackson.c.e.x<?> a3 = n.a().a(k.c(), n.e());
        this.b(n, k, a3, a2, d);
        this.a(n, k, a3, a2, d);
        return d.a(n);
    }
    
    protected void c(final n n, final k k, final d d) {
        final Map<Object, org.codehaus.jackson.c.e.e> m = k.m();
        if (m != null) {
            final boolean a = n.a(org.codehaus.jackson.c.o.f);
            for (final Map.Entry<K, org.codehaus.jackson.c.e.e> entry : m.entrySet()) {
                final org.codehaus.jackson.c.e.e e = entry.getValue();
                if (a) {
                    e.k();
                }
                d.a(e.b(), k.a(e.c()), k.i(), e, entry.getKey());
            }
        }
    }
}
