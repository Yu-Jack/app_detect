// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.annotate.JsonAutoDetect$Visibility;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.e.a;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.c.e.x;
import org.codehaus.jackson.c.h.b;
import java.util.HashMap;
import org.codehaus.jackson.c.g.j;
import org.codehaus.jackson.c.a.h;

public class at extends al<au, at>
{
    protected h a;
    protected Class<?> b;
    protected org.codehaus.jackson.c.g.j c;
    
    protected at(final at at, final HashMap<b, Class<?>> f, final org.codehaus.jackson.c.f.b h) {
        this(at, at.e);
        this.f = f;
        this.h = h;
    }
    
    protected at(final at at, final aj aj) {
        super(at, aj, at.h);
        this.a = null;
        this.a = at.a;
        this.b = at.b;
        this.c = at.c;
    }
    
    public at(final i<? extends e> i, final org.codehaus.jackson.c.b b, final x<?> x, final org.codehaus.jackson.c.f.b b2, final ao ao, final k k, final v v) {
        super(i, b, x, b2, ao, k, v, al.d(au.class));
        this.a = null;
        this.c = null;
    }
    
    public ad<Object> a(final a a, final Class<? extends ad<?>> clazz) {
        final v k = this.k();
        if (k != null) {
            final ad<?> a2 = k.a(this, a, clazz);
            if (a2 != null) {
                return (ad<Object>)a2;
            }
        }
        return l.b(clazz, this.c());
    }
    
    public at a(final org.codehaus.jackson.c.f.b b) {
        final HashMap<b, Class<?>> f = this.f;
        this.g = true;
        return new at(this, f, b);
    }
    
    @Override
    public org.codehaus.jackson.c.b a() {
        if (this.a(au.a)) {
            return super.a();
        }
        return org.codehaus.jackson.c.b.a();
    }
    
    @Override
    public <T extends e> T a(final org.codehaus.jackson.f.a a) {
        return (T)this.i().a((ai<?>)this, a, this);
    }
    
    @Deprecated
    @Override
    public void a(final au au, final boolean b) {
        super.a(au, b);
    }
    
    @Override
    public boolean a(final au au) {
        return (this.i & au.b()) != 0x0;
    }
    
    public <T extends e> T b(final org.codehaus.jackson.f.a a) {
        return (T)this.i().a(this, a, this);
    }
    
    @Deprecated
    @Override
    public void b(final au au) {
        super.b(au);
    }
    
    @Override
    public boolean b() {
        return this.a(au.a);
    }
    
    @Deprecated
    public void c(final au au) {
        super.a(au);
    }
    
    @Override
    public boolean c() {
        return this.a(au.e);
    }
    
    @Override
    public boolean d() {
        return this.a(au.l);
    }
    
    @Override
    public x<?> e() {
        Object o = super.e();
        if (!this.a(au.b)) {
            o = ((x<?>)o).a(JsonAutoDetect$Visibility.NONE);
        }
        if (!this.a(au.c)) {
            o = ((x<?>)o).b(JsonAutoDetect$Visibility.NONE);
        }
        if (!this.a(au.d)) {
            o = ((x<?>)o).e(JsonAutoDetect$Visibility.NONE);
        }
        return (x<?>)o;
    }
    
    public Class<?> f() {
        return this.b;
    }
    
    public h g() {
        if (this.a != null) {
            return this.a;
        }
        if (this.a(au.g)) {
            return org.codehaus.jackson.c.a.h.a;
        }
        return org.codehaus.jackson.c.a.h.b;
    }
    
    public org.codehaus.jackson.c.g.j h() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return "[SerializationConfig: flags=0x" + Integer.toHexString(this.i) + "]";
    }
}
