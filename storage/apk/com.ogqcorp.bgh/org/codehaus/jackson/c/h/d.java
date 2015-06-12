// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import org.codehaus.jackson.f.a;

public final class d extends c
{
    private d(final Class<?> clazz, final a a, final Object o, final Object o2) {
        super(clazz, a, o, o2);
    }
    
    public static d a(final Class<?> clazz, final a a) {
        return new d(clazz, a, null, null);
    }
    
    @Override
    protected a a(final Class<?> clazz) {
        return new d(clazz, this.a, null, null);
    }
    
    @Override
    public a b(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new d(this.d, this.a.f(clazz), this.f, this.g);
    }
    
    @Override
    public a c(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new d(this.d, this.a.h(clazz), this.f, this.g);
    }
    
    public d g(final Object o) {
        return new d(this.d, this.a, this.f, o);
    }
    
    public d h(final Object o) {
        return new d(this.d, this.a.f(o), this.f, this.g);
    }
    
    public d i(final Object o) {
        return new d(this.d, this.a, o, this.g);
    }
    
    @Override
    public String toString() {
        return "[collection type; class " + this.d.getName() + ", contains " + this.a + "]";
    }
}
