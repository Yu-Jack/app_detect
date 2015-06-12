// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.c.f.c;
import org.codehaus.jackson.c.i.l;
import java.lang.reflect.Type;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.f.d;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.c.e.x;
import org.codehaus.jackson.c.i.y;
import org.codehaus.jackson.c.h.b;
import java.util.HashMap;
import java.text.DateFormat;

public abstract class ai<T extends ai<T>> implements j
{
    protected static final DateFormat d;
    protected aj e;
    protected HashMap<b, Class<?>> f;
    protected boolean g;
    protected org.codehaus.jackson.c.f.b h;
    
    static {
        d = y.f;
    }
    
    protected ai(final ai<T> ai, final aj e, final org.codehaus.jackson.c.f.b h) {
        this.e = e;
        this.h = h;
        this.g = true;
        this.f = ai.f;
    }
    
    protected ai(final i<? extends e> i, final org.codehaus.jackson.c.b b, final x<?> x, final org.codehaus.jackson.c.f.b h, final ao ao, final k k, final v v) {
        this.e = new aj(i, b, x, ao, k, null, ai.d, v);
        this.h = h;
        this.g = true;
    }
    
    @Override
    public final Class<?> a(final Class<?> clazz) {
        if (this.f == null) {
            return null;
        }
        return this.f.get(new b(clazz));
    }
    
    public org.codehaus.jackson.c.b a() {
        return this.e.b();
    }
    
    public abstract <DESC extends e> DESC a(final a p0);
    
    public a a(final a a, final Class<?> clazz) {
        return this.m().a(a, clazz);
    }
    
    public final a b(final Class<?> clazz) {
        return this.m().a((Type)clazz, (org.codehaus.jackson.c.h.j)null);
    }
    
    public abstract boolean b();
    
    public <DESC extends e> DESC c(final Class<?> clazz) {
        return this.a(this.b(clazz));
    }
    
    public abstract boolean c();
    
    public d<?> d(final org.codehaus.jackson.c.e.a a, final Class<? extends d<?>> clazz) {
        final v k = this.k();
        if (k != null) {
            final d<?> a2 = k.a(this, a, clazz);
            if (a2 != null) {
                return a2;
            }
        }
        return l.b(clazz, this.c());
    }
    
    public final d<?> d(final a a) {
        return this.e.f();
    }
    
    public abstract boolean d();
    
    public x<?> e() {
        return this.e.c();
    }
    
    public c e(final org.codehaus.jackson.c.e.a a, final Class<? extends c> clazz) {
        final v k = this.k();
        if (k != null) {
            final c b = k.b(this, a, clazz);
            if (b != null) {
                return b;
            }
        }
        return l.b(clazz, this.c());
    }
    
    public i<? extends e> i() {
        return this.e.a();
    }
    
    public final ao j() {
        return this.e.d();
    }
    
    public final v k() {
        return this.e.h();
    }
    
    public final org.codehaus.jackson.c.f.b l() {
        if (this.h == null) {
            this.h = new org.codehaus.jackson.c.f.a.k();
        }
        return this.h;
    }
    
    public final k m() {
        return this.e.e();
    }
    
    public final DateFormat n() {
        return this.e.g();
    }
}
