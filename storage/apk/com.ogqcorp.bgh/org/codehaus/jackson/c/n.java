// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.annotate.JsonAutoDetect$Visibility;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.e.t;
import java.util.HashMap;
import org.codehaus.jackson.c.e.x;
import org.codehaus.jackson.d.k;
import org.codehaus.jackson.c.i.r;

public class n extends al<o, n>
{
    protected r<q> a;
    protected final k b;
    protected boolean c;
    
    public n(final i<? extends e> i, final b b, final x<?> x, final org.codehaus.jackson.c.f.b b2, final ao ao, final org.codehaus.jackson.c.h.k k, final v v) {
        super(i, b, x, b2, ao, k, v, al.d(o.class));
        this.b = k.a;
    }
    
    private n(final n n, final HashMap<org.codehaus.jackson.c.h.b, Class<?>> f, final org.codehaus.jackson.c.f.b h) {
        this(n, n.e);
        this.f = f;
        this.h = h;
    }
    
    protected n(final n n, final aj aj) {
        super(n, aj, n.h);
        this.a = n.a;
        this.b = n.b;
        this.c = n.c;
    }
    
    @Override
    public b a() {
        if (this.a(o.a)) {
            return super.a();
        }
        return t.a;
    }
    
    @Override
    public <T extends e> T a(final a a) {
        return (T)this.i().a((ai<?>)this, a, this);
    }
    
    protected n a(final int n) {
        this.c = ((n & au.l.b()) != 0x0);
        return this;
    }
    
    public n a(final org.codehaus.jackson.c.f.b b) {
        final HashMap<org.codehaus.jackson.c.h.b, Class<?>> f = this.f;
        this.g = true;
        return new n(this, f, b);
    }
    
    public org.codehaus.jackson.c.x<Object> a(final org.codehaus.jackson.c.e.a a, final Class<? extends org.codehaus.jackson.c.x<?>> clazz) {
        final v k = this.k();
        if (k != null) {
            final org.codehaus.jackson.c.x<?> a2 = k.a(this, a, clazz);
            if (a2 != null) {
                return (org.codehaus.jackson.c.x<Object>)a2;
            }
        }
        return l.b(clazz, this.c());
    }
    
    @Deprecated
    @Override
    public void a(final o o, final boolean b) {
        super.a(o, b);
    }
    
    @Override
    public boolean a(final o o) {
        return (this.i & o.b()) != 0x0;
    }
    
    public af b(final org.codehaus.jackson.c.e.a a, final Class<? extends af> clazz) {
        final v k = this.k();
        if (k != null) {
            final af b = k.b(this, a, clazz);
            if (b != null) {
                return b;
            }
        }
        return l.b(clazz, this.c());
    }
    
    public <T extends e> T b(final a a) {
        return (T)this.i().a(this, a, this);
    }
    
    @Deprecated
    @Override
    public void b(final o o) {
        super.b(o);
    }
    
    @Override
    public boolean b() {
        return this.a(o.a);
    }
    
    public org.codehaus.jackson.c.b.t c(final org.codehaus.jackson.c.e.a a, final Class<? extends org.codehaus.jackson.c.b.t> clazz) {
        final v k = this.k();
        if (k != null) {
            final org.codehaus.jackson.c.b.t c = k.c(this, a, clazz);
            if (c != null) {
                return c;
            }
        }
        return l.b(clazz, this.c());
    }
    
    public <T extends e> T c(final a a) {
        return (T)this.i().b(this, a, this);
    }
    
    @Deprecated
    public void c(final o o) {
        super.a(o);
    }
    
    @Override
    public boolean c() {
        return this.a(o.f);
    }
    
    @Override
    public boolean d() {
        return this.c;
    }
    
    @Override
    public x<?> e() {
        Object o = super.e();
        if (!this.a(org.codehaus.jackson.c.o.b)) {
            o = ((x<?>)o).c(JsonAutoDetect$Visibility.NONE);
        }
        if (!this.a(org.codehaus.jackson.c.o.c)) {
            o = ((x<?>)o).d(JsonAutoDetect$Visibility.NONE);
        }
        if (!this.a(org.codehaus.jackson.c.o.d)) {
            o = ((x<?>)o).e(JsonAutoDetect$Visibility.NONE);
        }
        return (x<?>)o;
    }
    
    public r<q> f() {
        return this.a;
    }
    
    public org.codehaus.jackson.a g() {
        return org.codehaus.jackson.b.a();
    }
    
    public final k h() {
        return this.b;
    }
}
