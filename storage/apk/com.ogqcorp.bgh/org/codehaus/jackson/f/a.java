// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.f;

import java.lang.reflect.Modifier;

public abstract class a
{
    protected final Class<?> d;
    protected final int e;
    protected Object f;
    protected Object g;
    
    protected a(final Class<?> d, final int n) {
        this.d = d;
        this.e = n + d.getName().hashCode();
        this.f = null;
        this.g = null;
    }
    
    public String a(final int n) {
        return null;
    }
    
    protected abstract a a(final Class<?> p0);
    
    protected void a(final Class<?> clazz, final Class<?> clazz2) {
        if (!this.d.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Class " + clazz.getName() + " is not assignable to " + this.d.getName());
        }
    }
    
    public a b(final int n) {
        return null;
    }
    
    public abstract a b(final Class<?> p0);
    
    public boolean b() {
        return false;
    }
    
    public abstract a c(final Class<?> p0);
    
    public boolean c() {
        return Modifier.isAbstract(this.d.getModifiers());
    }
    
    public a d(final Object o) {
        this.j(o);
        return this;
    }
    
    public boolean d() {
        return (0x600 & this.d.getModifiers()) == 0x0 || this.d.isPrimitive();
    }
    
    public abstract a e(final Object p0);
    
    public boolean e() {
        return this.h() > 0;
    }
    
    @Override
    public abstract boolean equals(final Object p0);
    
    public a f(final Class<?> clazz) {
        if (clazz == this.d) {
            return this;
        }
        this.a(clazz, this.d);
        a a = this.a(clazz);
        if (this.f != a.n()) {
            a = a.d(this.f);
        }
        if (this.g != a.o()) {
            a = a.f(this.g);
        }
        return a;
    }
    
    public abstract a f(final Object p0);
    
    public abstract boolean f();
    
    public a g() {
        return null;
    }
    
    public a g(final Class<?> clazz) {
        if (clazz == this.d) {
            return this;
        }
        a a = this.a(clazz);
        if (this.f != a.n()) {
            a = a.d(this.f);
        }
        if (this.g != a.o()) {
            a = a.f(this.g);
        }
        return a;
    }
    
    public int h() {
        return 0;
    }
    
    public a h(final Class<?> clazz) {
        if (clazz == this.d) {
            return this;
        }
        this.a(this.d, clazz);
        return this.i(clazz);
    }
    
    @Override
    public final int hashCode() {
        return this.e;
    }
    
    protected a i(final Class<?> clazz) {
        return this.a(clazz);
    }
    
    public boolean i() {
        return false;
    }
    
    @Deprecated
    public void j(final Object f) {
        if (f != null && this.f != null) {
            throw new IllegalStateException("Trying to reset value handler for type [" + this.toString() + "]; old handler of type " + this.f.getClass().getName() + ", new handler of type " + f.getClass().getName());
        }
        this.f = f;
    }
    
    public boolean j() {
        return false;
    }
    
    public a k() {
        return null;
    }
    
    public abstract String m();
    
    public <T> T n() {
        return (T)this.f;
    }
    
    public <T> T o() {
        return (T)this.g;
    }
    
    public final Class<?> p() {
        return this.d;
    }
    
    public boolean q() {
        return Throwable.class.isAssignableFrom(this.d);
    }
    
    public final boolean r() {
        return this.d.isEnum();
    }
    
    public final boolean s() {
        return this.d.isInterface();
    }
    
    public final boolean t() {
        return this.d.isPrimitive();
    }
    
    @Override
    public abstract String toString();
    
    public final boolean u() {
        return Modifier.isFinal(this.d.getModifiers());
    }
}
