// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.util.Collection;
import org.codehaus.jackson.f.a;

public class c extends i
{
    protected final a a;
    
    protected c(final Class<?> clazz, final a a, final Object o, final Object o2) {
        super(clazz, a.hashCode(), o, o2);
        this.a = a;
    }
    
    @Override
    protected String a() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.d.getName());
        if (this.a != null) {
            sb.append('<');
            sb.append(this.a.m());
            sb.append('>');
        }
        return sb.toString();
    }
    
    @Override
    public String a(final int n) {
        if (n == 0) {
            return "E";
        }
        return null;
    }
    
    public c a(final Object o) {
        return new c(this.d, this.a, this.f, o);
    }
    
    @Override
    protected a a(final Class<?> clazz) {
        return new c(clazz, this.a, this.f, this.g);
    }
    
    public c b(final Object o) {
        return new c(this.d, this.a.f(o), this.f, this.g);
    }
    
    @Override
    public a b(final int n) {
        if (n == 0) {
            return this.a;
        }
        return null;
    }
    
    @Override
    public a b(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new c(this.d, this.a.f(clazz), this.f, this.g);
    }
    
    public boolean b_() {
        return Collection.class.isAssignableFrom(this.d);
    }
    
    public c c(final Object o) {
        return new c(this.d, this.a, o, this.g);
    }
    
    @Override
    public a c(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new c(this.d, this.a.h(clazz), this.f, this.g);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            final c c = (c)o;
            if (this.d != c.d || !this.a.equals(c.a)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean f() {
        return true;
    }
    
    @Override
    public a g() {
        return this.a;
    }
    
    @Override
    public int h() {
        return 1;
    }
    
    @Override
    public boolean i() {
        return true;
    }
    
    @Override
    public String toString() {
        return "[collection-like type; class " + this.d.getName() + ", contains " + this.a + "]";
    }
}
