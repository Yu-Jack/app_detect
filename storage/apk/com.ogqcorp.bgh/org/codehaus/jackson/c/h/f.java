// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.util.Map;
import org.codehaus.jackson.f.a;

public class f extends i
{
    protected final a a;
    protected final a b;
    
    protected f(final Class<?> clazz, final a a, final a b, final Object o, final Object o2) {
        super(clazz, a.hashCode() ^ b.hashCode(), o, o2);
        this.a = a;
        this.b = b;
    }
    
    @Override
    protected String a() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.d.getName());
        if (this.a != null) {
            sb.append('<');
            sb.append(this.a.m());
            sb.append(',');
            sb.append(this.b.m());
            sb.append('>');
        }
        return sb.toString();
    }
    
    @Override
    public String a(final int n) {
        if (n == 0) {
            return "K";
        }
        if (n == 1) {
            return "V";
        }
        return null;
    }
    
    public f a(final Object o) {
        return new f(this.d, this.a, this.b, this.f, o);
    }
    
    @Override
    protected a a(final Class<?> clazz) {
        return new f(clazz, this.a, this.b, this.f, this.g);
    }
    
    public f b(final Object o) {
        return new f(this.d, this.a, this.b.f(o), this.f, this.g);
    }
    
    @Override
    public a b(final int n) {
        if (n == 0) {
            return this.a;
        }
        if (n == 1) {
            return this.b;
        }
        return null;
    }
    
    @Override
    public a b(final Class<?> clazz) {
        if (clazz == this.b.p()) {
            return this;
        }
        return new f(this.d, this.a, this.b.f(clazz), this.f, this.g);
    }
    
    public f c(final Object o) {
        return new f(this.d, this.a, this.b, o, this.g);
    }
    
    @Override
    public a c(final Class<?> clazz) {
        if (clazz == this.b.p()) {
            return this;
        }
        return new f(this.d, this.a, this.b.h(clazz), this.f, this.g);
    }
    
    public a d(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new f(this.d, this.a.f(clazz), this.b, this.f, this.g);
    }
    
    public a e(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return new f(this.d, this.a.h(clazz), this.b, this.f, this.g);
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
            final f f = (f)o;
            if (this.d != f.d || !this.a.equals(f.a) || !this.b.equals(f.b)) {
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
        return this.b;
    }
    
    @Override
    public int h() {
        return 2;
    }
    
    @Override
    public boolean j() {
        return true;
    }
    
    @Override
    public a k() {
        return this.a;
    }
    
    public boolean l() {
        return Map.class.isAssignableFrom(this.d);
    }
    
    @Override
    public String toString() {
        return "[map-like type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
    }
}
