// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import org.codehaus.jackson.f.a;

public final class g extends f
{
    private g(final Class<?> clazz, final a a, final a a2, final Object o, final Object o2) {
        super(clazz, a, a2, o, o2);
    }
    
    public static g a(final Class<?> clazz, final a a, final a a2) {
        return new g(clazz, a, a2, null, null);
    }
    
    @Override
    protected a a(final Class<?> clazz) {
        return new g(clazz, this.a, this.b, this.f, this.g);
    }
    
    @Override
    public a b(final Class<?> clazz) {
        if (clazz == this.b.p()) {
            return this;
        }
        return new g(this.d, this.a, this.b.f(clazz), this.f, this.g);
    }
    
    @Override
    public a c(final Class<?> clazz) {
        if (clazz == this.b.p()) {
            return this;
        }
        return new g(this.d, this.a, this.b.h(clazz), this.f, this.g);
    }
    
    @Override
    public a d(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new g(this.d, this.a.f(clazz), this.b, this.f, this.g);
    }
    
    @Override
    public a e(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new g(this.d, this.a.h(clazz), this.b, this.f, this.g);
    }
    
    public g g(final Object o) {
        return new g(this.d, this.a, this.b, this.f, o);
    }
    
    public g h(final Object o) {
        return new g(this.d, this.a, this.b.f(o), this.f, this.g);
    }
    
    public g i(final Object o) {
        return new g(this.d, this.a, this.b, o, this.g);
    }
    
    @Override
    public String toString() {
        return "[map type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
    }
}
