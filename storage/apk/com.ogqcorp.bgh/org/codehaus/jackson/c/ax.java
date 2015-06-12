// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.c.g.j;
import java.util.Date;
import java.lang.reflect.Type;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.f.a;

public abstract class ax
{
    protected static final a a;
    protected final at b;
    protected final Class<?> c;
    
    static {
        a = k.a().a(Object.class);
    }
    
    protected ax(final at b) {
        this.b = b;
        Class<?> f;
        if (b == null) {
            f = null;
        }
        else {
            f = this.b.f();
        }
        this.c = f;
    }
    
    public final Class<?> a() {
        return this.c;
    }
    
    public abstract ad<Object> a(final Class<?> p0, final f p1);
    
    public abstract ad<Object> a(final Class<?> p0, final boolean p1, final f p2);
    
    public abstract ad<Object> a(final a p0, final f p1);
    
    public abstract ad<Object> a(final a p0, final boolean p1, final f p2);
    
    public a a(final Type type) {
        return this.b.m().a(type);
    }
    
    public a a(final a a, final Class<?> clazz) {
        return this.b.a(a, clazz);
    }
    
    public abstract void a(final long p0, final org.codehaus.jackson.f p1);
    
    public final void a(final Object o, final org.codehaus.jackson.f f) {
        if (o == null) {
            this.d().a(null, f, this);
            return;
        }
        this.a(o.getClass(), true, null).a(o, f, this);
    }
    
    public abstract void a(final Date p0, final org.codehaus.jackson.f p1);
    
    public abstract void a(final at p0, final org.codehaus.jackson.f p1, final Object p2, final av p3);
    
    public final void a(final org.codehaus.jackson.f f) {
        this.d().a(null, f, this);
    }
    
    public final boolean a(final au au) {
        return this.b.a(au);
    }
    
    public abstract ad<Object> b(final a p0, final f p1);
    
    public final j b() {
        return this.b.h();
    }
    
    public abstract void b(final long p0, final org.codehaus.jackson.f p1);
    
    public abstract void b(final Date p0, final org.codehaus.jackson.f p1);
    
    public abstract ad<Object> c();
    
    public abstract ad<Object> d();
}
