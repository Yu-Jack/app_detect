// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.h;
import org.codehaus.jackson.c.z;
import java.io.IOException;
import org.codehaus.jackson.c.ai;
import java.util.Date;
import org.codehaus.jackson.c.au;
import org.codehaus.jackson.c.m;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.g.b.p;
import org.codehaus.jackson.c.at;
import org.codehaus.jackson.c.g.a.n;
import org.codehaus.jackson.c.g.b.as;
import org.codehaus.jackson.c.g.a.a;
import java.text.DateFormat;
import org.codehaus.jackson.c.g.a.k;
import org.codehaus.jackson.c.i.x;
import org.codehaus.jackson.c.g.a.l;
import org.codehaus.jackson.c.av;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.ax;

public class t extends ax
{
    public static final ad<Object> d;
    @Deprecated
    public static final ad<Object> e;
    public static final ad<Object> f;
    protected final av g;
    protected final l h;
    protected final x i;
    protected ad<Object> j;
    protected ad<Object> k;
    protected ad<Object> l;
    protected ad<Object> m;
    protected final k n;
    protected DateFormat o;
    
    static {
        d = new a("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
        e = new as();
        f = new n();
    }
    
    public t() {
        super(null);
        this.j = t.f;
        this.l = p.a;
        this.m = t.d;
        this.g = null;
        this.h = new l();
        this.n = null;
        this.i = new x();
    }
    
    protected t(final at at, final t t, final av g) {
        super(at);
        this.j = t.f;
        this.l = p.a;
        this.m = t.d;
        if (at == null) {
            throw new NullPointerException();
        }
        this.g = g;
        this.h = t.h;
        this.j = t.j;
        this.k = t.k;
        this.l = t.l;
        this.m = t.m;
        this.i = t.i;
        this.n = this.h.a();
    }
    
    public ad<Object> a(final Class<?> clazz) {
        return this.j;
    }
    
    @Override
    public ad<Object> a(final Class<?> clazz, final f f) {
        ad<Object> ad = this.n.b(clazz);
        if (ad == null) {
            ad = this.h.a(clazz);
            if (ad == null) {
                ad = this.h.a(this.b.b(clazz));
                if (ad == null) {
                    ad = this.b(clazz, f);
                    if (ad == null) {
                        return this.a(clazz);
                    }
                }
            }
        }
        return this.a(ad, f);
    }
    
    @Override
    public ad<Object> a(final Class<?> clazz, final boolean b, final f f) {
        ad<Object> ad = this.n.a(clazz);
        if (ad == null) {
            ad = this.h.b(clazz);
            if (ad == null) {
                final ad<Object> a = this.a(clazz, f);
                final ba b2 = this.g.b(this.b, this.b.b(clazz), f);
                if (b2 != null) {
                    ad = new u(b2, a);
                }
                else {
                    ad = a;
                }
                if (b) {
                    this.h.a(clazz, ad);
                    return ad;
                }
            }
        }
        return ad;
    }
    
    protected ad<Object> a(final ad<Object> ad, final f f) {
        if (!(ad instanceof m)) {
            return ad;
        }
        Object a = ((m<Object>)ad).a(this.b, f);
        if (a != ad) {
            if (a instanceof org.codehaus.jackson.c.as) {
                ((org.codehaus.jackson.c.as)a).a(this);
            }
        }
        else {
            a = ad;
        }
        return (ad<Object>)a;
    }
    
    @Override
    public ad<Object> a(final org.codehaus.jackson.f.a a, final f f) {
        ad<Object> ad = this.n.b(a);
        if (ad == null) {
            ad = this.h.a(a);
            if (ad == null) {
                ad = this.c(a, f);
                if (ad == null) {
                    return this.a(a.p());
                }
            }
        }
        return this.a(ad, f);
    }
    
    @Override
    public ad<Object> a(final org.codehaus.jackson.f.a a, final boolean b, final f f) {
        ad<Object> ad = this.n.a(a);
        if (ad == null) {
            ad = this.h.b(a);
            if (ad == null) {
                final ad<Object> a2 = this.a(a, f);
                final ba b2 = this.g.b(this.b, a, f);
                if (b2 != null) {
                    ad = new u(b2, a2);
                }
                else {
                    ad = a2;
                }
                if (b) {
                    this.h.a(a, ad);
                    return ad;
                }
            }
        }
        return ad;
    }
    
    protected t a(final at at, final av av) {
        return new t(at, this, av);
    }
    
    @Override
    public final void a(final long date, final org.codehaus.jackson.f f) {
        if (this.a(au.q)) {
            f.a(date);
            return;
        }
        if (this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
        }
        f.b(this.o.format(new Date(date)));
    }
    
    @Override
    public final void a(final Date date, final org.codehaus.jackson.f f) {
        if (this.a(au.q)) {
            f.a(date.getTime());
            return;
        }
        if (this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
        }
        f.b(this.o.format(date));
    }
    
    @Override
    public final void a(final at at, final org.codehaus.jackson.f f, final Object o, final av av) {
        if (av == null) {
            throw new IllegalArgumentException("Can not pass null serializerFactory");
        }
        final t a = this.a(at, av);
        if (a.getClass() != this.getClass()) {
            throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + a.getClass() + "; blueprint of type " + this.getClass());
        }
        a.a(f, o);
    }
    
    protected void a(final org.codehaus.jackson.f f, final Object o) {
        Label_0029: {
            if (o != null) {
                break Label_0029;
            }
            ad<Object> ad = this.d();
            boolean a = false;
            try {
                // iftrue(Label_0012:, !a)
                while (true) {
                    while (true) {
                        ad.a(o, f, this);
                        if (a) {
                            f.e();
                        }
                        return;
                        f.d();
                        f.a(this.i.a(o.getClass(), this.b));
                        continue;
                    }
                    ad = this.a(o.getClass(), true, null);
                    a = this.b.a(au.j);
                    continue;
                }
            }
            catch (IOException ex) {
                throw ex;
            }
            catch (Exception ex2) {
                String s = ex2.getMessage();
                if (s == null) {
                    s = "[no message for " + ex2.getClass().getName() + "]";
                }
                throw new z(s, ex2);
            }
        }
    }
    
    protected ad<Object> b(final Class<?> clazz, final f f) {
        try {
            final ad<Object> d = this.d(this.b.b(clazz), f);
            if (d != null) {
                this.h.a(clazz, d, this);
            }
            return d;
        }
        catch (IllegalArgumentException ex) {
            throw new z(ex.getMessage(), null, ex);
        }
    }
    
    @Override
    public ad<Object> b(final org.codehaus.jackson.f.a a, final f f) {
        ad<Object> ad = this.g.c(this.b, a, f);
        if (ad == null) {
            if (this.k == null) {
                ad = org.codehaus.jackson.c.g.b.at.a(a);
            }
            else {
                ad = this.k;
            }
        }
        if (ad instanceof m) {
            ad = ((m<Object>)ad).a(this.b, f);
        }
        return ad;
    }
    
    @Override
    public void b(final long n, final org.codehaus.jackson.f f) {
        if (this.a(au.r)) {
            f.a(String.valueOf(n));
            return;
        }
        if (this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
        }
        f.a(this.o.format(new Date(n)));
    }
    
    @Override
    public void b(final Date date, final org.codehaus.jackson.f f) {
        if (this.a(au.r)) {
            f.a(String.valueOf(date.getTime()));
            return;
        }
        if (this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
        }
        f.a(this.o.format(date));
    }
    
    @Override
    public ad<Object> c() {
        return this.m;
    }
    
    protected ad<Object> c(final org.codehaus.jackson.f.a a, final f f) {
        try {
            final ad<Object> d = this.d(a, f);
            if (d != null) {
                this.h.a(a, d, this);
            }
            return d;
        }
        catch (IllegalArgumentException ex) {
            throw new z(ex.getMessage(), null, ex);
        }
    }
    
    @Override
    public ad<Object> d() {
        return this.l;
    }
    
    protected ad<Object> d(final org.codehaus.jackson.f.a a, final f f) {
        return this.g.a(this.b, a, f);
    }
}
