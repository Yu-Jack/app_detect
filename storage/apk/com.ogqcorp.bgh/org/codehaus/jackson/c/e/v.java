// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import org.codehaus.jackson.c.h;

public class v extends h implements Comparable<v>
{
    protected final String a;
    protected final String b;
    protected w<d> c;
    protected w<org.codehaus.jackson.c.e.h> d;
    protected w<f> e;
    protected w<f> f;
    
    public v(final String s) {
        this.b = s;
        this.a = s;
    }
    
    public v(final v v, final String a) {
        this.b = v.b;
        this.a = a;
        this.c = v.c;
        this.d = v.d;
        this.e = v.e;
        this.f = v.f;
    }
    
    private j a(final int n, final w<? extends e>... array) {
        final j j = ((e)array[n].a).j();
        for (int i = n + 1; i < array.length; ++i) {
            if (array[i] != null) {
                return org.codehaus.jackson.c.e.j.a(j, this.a(i, array));
            }
        }
        return j;
    }
    
    private <T> w<T> a(final w<T> w) {
        if (w == null) {
            return w;
        }
        return w.a();
    }
    
    private static <T> w<T> a(final w<T> w, final w<T> w2) {
        if (w == null) {
            return w2;
        }
        if (w2 == null) {
            return w;
        }
        return (w<T>)((w<Object>)w).b((w<Object>)w2);
    }
    
    private <T> w<T> b(final w<T> w) {
        if (w == null) {
            return w;
        }
        return w.b();
    }
    
    private w<? extends e> b(final w<? extends e> w, final w<? extends e> w2) {
        w<? extends e> w3 = w2;
        for (w<? extends e> b = w; b != null; b = b.b) {
            final String c = b.c;
            if (c != null && !c.equals(this.a)) {
                if (w3 == null) {
                    w3 = b;
                }
                else if (!c.equals(w3.c)) {
                    throw new IllegalStateException("Conflicting property name definitions: '" + w3.c + "' (for " + w3.a + ") vs '" + b.c + "' (for " + b.a + ")");
                }
            }
        }
        return w3;
    }
    
    private <T> w<T> c(final w<T> w) {
        if (w == null) {
            return w;
        }
        return w.c();
    }
    
    private <T> boolean d(w<T> b) {
        while (b != null) {
            if (b.c != null && b.c.length() > 0) {
                return true;
            }
            b = b.b;
        }
        return false;
    }
    
    private <T> boolean e(w<T> b) {
        while (b != null) {
            if (b.d) {
                return true;
            }
            b = b.b;
        }
        return false;
    }
    
    private <T> boolean f(w<T> b) {
        while (b != null) {
            if (b.e) {
                return true;
            }
            b = b.b;
        }
        return false;
    }
    
    public int a(final v v) {
        if (this.d != null) {
            if (v.d == null) {
                return -1;
            }
        }
        else if (v.d != null) {
            return 1;
        }
        return this.a().compareTo(v.a());
    }
    
    @Override
    public String a() {
        return this.a;
    }
    
    public v a(final String s) {
        return new v(this, s);
    }
    
    public void a(final d d, final String s, final boolean b, final boolean b2) {
        this.c = new w<d>(d, this.c, s, b, b2);
    }
    
    public void a(final f f, final String s, final boolean b, final boolean b2) {
        this.e = new w<f>(f, this.e, s, b, b2);
    }
    
    public void a(final org.codehaus.jackson.c.e.h h, final String s, final boolean b, final boolean b2) {
        this.d = new w<org.codehaus.jackson.c.e.h>(h, this.d, s, b, b2);
    }
    
    public void a(final boolean b) {
        if (b) {
            if (this.e != null) {
                this.e = this.e.a(this.e.a.a(this.a(0, this.e, this.c, this.d, this.f)));
            }
            else if (this.c != null) {
                this.c = this.c.a(this.c.a.a(this.a(0, this.c, this.d, this.f)));
            }
        }
        else {
            if (this.d != null) {
                this.d = this.d.a(this.d.a.a(this.a(0, this.d, this.f, this.c, this.e)));
                return;
            }
            if (this.f != null) {
                this.f = this.f.a(this.f.a.a(this.a(0, this.f, this.c, this.e)));
                return;
            }
            if (this.c != null) {
                this.c = this.c.a(this.c.a.a(this.a(0, this.c, this.e)));
            }
        }
    }
    
    public void b(final f f, final String s, final boolean b, final boolean b2) {
        this.f = new w<f>(f, this.f, s, b, b2);
    }
    
    public void b(final v v) {
        this.c = a(this.c, v.c);
        this.d = a(this.d, v.d);
        this.e = a(this.e, v.e);
        this.f = a(this.f, v.f);
    }
    
    @Override
    public boolean b() {
        return this.r();
    }
    
    @Override
    public boolean c() {
        return this.e != null;
    }
    
    @Override
    public boolean d() {
        return this.f != null;
    }
    
    @Override
    public boolean e() {
        return this.c != null;
    }
    
    @Override
    public boolean f() {
        return this.d != null;
    }
    
    @Override
    public f h() {
        f f;
        if (this.e == null) {
            f = null;
        }
        else {
            final f f2 = this.e.a;
            w<f> w = this.e.b;
            f = f2;
            while (w != null) {
                f f3 = w.a;
                final Class<?> h = f.h();
                final Class<?> h2 = f3.h();
                if (h != h2) {
                    if (!h.isAssignableFrom(h2)) {
                        if (!h2.isAssignableFrom(h)) {
                            throw new IllegalArgumentException("Conflicting getter definitions for property \"" + this.a() + "\": " + f.n() + " vs " + f3.n());
                        }
                        f3 = f;
                    }
                    w = w.b;
                    f = f3;
                    continue;
                }
                throw new IllegalArgumentException("Conflicting getter definitions for property \"" + this.a() + "\": " + f.n() + " vs " + f3.n());
            }
        }
        return f;
    }
    
    @Override
    public f i() {
        f f;
        if (this.f == null) {
            f = null;
        }
        else {
            final f f2 = this.f.a;
            w<f> w = this.f.b;
            f = f2;
            while (w != null) {
                f f3 = w.a;
                final Class<?> h = f.h();
                final Class<?> h2 = f3.h();
                if (h != h2) {
                    if (!h.isAssignableFrom(h2)) {
                        if (!h2.isAssignableFrom(h)) {
                            throw new IllegalArgumentException("Conflicting setter definitions for property \"" + this.a() + "\": " + f.n() + " vs " + f3.n());
                        }
                        f3 = f;
                    }
                    w = w.b;
                    f = f3;
                    continue;
                }
                throw new IllegalArgumentException("Conflicting setter definitions for property \"" + this.a() + "\": " + f.n() + " vs " + f3.n());
            }
        }
        return f;
    }
    
    @Override
    public d j() {
        d d;
        if (this.c == null) {
            d = null;
        }
        else {
            final d d2 = this.c.a;
            w<d> w = this.c.b;
            d = d2;
            while (w != null) {
                d d3 = w.a;
                final Class<?> h = d.h();
                final Class<?> h2 = d3.h();
                if (h != h2) {
                    if (!h.isAssignableFrom(h2)) {
                        if (!h2.isAssignableFrom(h)) {
                            throw new IllegalArgumentException("Multiple fields representing property \"" + this.a() + "\": " + d.f() + " vs " + d3.f());
                        }
                        d3 = d;
                    }
                    w = w.b;
                    d = d3;
                    continue;
                }
                throw new IllegalArgumentException("Multiple fields representing property \"" + this.a() + "\": " + d.f() + " vs " + d3.f());
            }
        }
        return d;
    }
    
    @Override
    public e k() {
        e e = this.h();
        if (e == null) {
            e = this.j();
        }
        return e;
    }
    
    @Override
    public e l() {
        e e = this.n();
        if (e == null) {
            e = this.i();
            if (e == null) {
                e = this.j();
            }
        }
        return e;
    }
    
    public String m() {
        return this.b;
    }
    
    public org.codehaus.jackson.c.e.h n() {
        if (this.d == null) {
            return null;
        }
        w<org.codehaus.jackson.c.e.h> d;
        w<org.codehaus.jackson.c.e.h> b;
        for (d = this.d; !(d.a.f() instanceof c); d = b) {
            b = d.b;
            if (b == null) {
                return this.d.a;
            }
        }
        return d.a;
    }
    
    public void o() {
        this.c = this.a(this.c);
        this.e = this.a(this.e);
        this.f = this.a(this.f);
        this.d = this.a(this.d);
    }
    
    public void p() {
        this.e = this.b(this.e);
        this.d = this.b(this.d);
        if (this.e == null) {
            this.c = this.b(this.c);
            this.f = this.b(this.f);
        }
    }
    
    public void q() {
        this.c = this.c(this.c);
        this.e = this.c(this.e);
        this.f = this.c(this.f);
        this.d = this.c(this.d);
    }
    
    public boolean r() {
        return this.d(this.c) || this.d(this.e) || this.d(this.f) || this.d(this.d);
    }
    
    public boolean s() {
        return this.e(this.c) || this.e(this.e) || this.e(this.f) || this.e(this.d);
    }
    
    public boolean t() {
        return this.f(this.c) || this.f(this.e) || this.f(this.f) || this.f(this.d);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[Property '").append(this.a).append("'; ctors: ").append(this.d).append(", field(s): ").append(this.c).append(", getter(s): ").append(this.e).append(", setter(s): ").append(this.f);
        sb.append("]");
        return sb.toString();
    }
    
    public boolean u() {
        return this.f(this.c) || this.f(this.f) || this.f(this.d);
    }
    
    public String v() {
        final w<? extends e> b = this.b(this.d, this.b(this.f, this.b(this.e, this.b(this.c, null))));
        if (b == null) {
            return null;
        }
        return b.c;
    }
}
