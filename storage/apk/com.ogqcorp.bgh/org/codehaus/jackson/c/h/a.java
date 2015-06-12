// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.lang.reflect.Type;
import java.lang.reflect.Array;
import org.codehaus.jackson.f.a;

public final class a extends i
{
    protected final org.codehaus.jackson.f.a a;
    protected final Object b;
    
    private a(final org.codehaus.jackson.f.a a, final Object b, final Object o, final Object o2) {
        super(b.getClass(), a.hashCode(), o, o2);
        this.a = a;
        this.b = b;
    }
    
    public static a a(final org.codehaus.jackson.f.a a, final Object o, final Object o2) {
        return new a(a, Array.newInstance(a.p(), 0), null, null);
    }
    
    @Override
    protected String a() {
        return this.d.getName();
    }
    
    @Override
    public String a(final int n) {
        if (n == 0) {
            return "E";
        }
        return null;
    }
    
    public a a(final Object o) {
        if (o == this.g) {
            return this;
        }
        return new a(this.a, this.b, this.f, o);
    }
    
    @Override
    protected org.codehaus.jackson.f.a a(final Class<?> clazz) {
        if (!clazz.isArray()) {
            throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + this.toString() + " to class " + clazz.getName());
        }
        return a(k.a().a((Type)clazz.getComponentType()), this.f, this.g);
    }
    
    public a b(final Object o) {
        if (o == this.a.o()) {
            return this;
        }
        return new a(this.a.f(o), this.b, this.f, this.g);
    }
    
    @Override
    public org.codehaus.jackson.f.a b(final int n) {
        if (n == 0) {
            return this.a;
        }
        return null;
    }
    
    @Override
    public org.codehaus.jackson.f.a b(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return a(this.a.f(clazz), this.f, this.g);
    }
    
    @Override
    public boolean b() {
        return true;
    }
    
    public a c(final Object o) {
        if (o == this.f) {
            return this;
        }
        return new a(this.a, this.b, o, this.g);
    }
    
    @Override
    public org.codehaus.jackson.f.a c(final Class<?> clazz) {
        if (clazz == this.a.p()) {
            return this;
        }
        return a(this.a.h(clazz), this.f, this.g);
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public boolean d() {
        return true;
    }
    
    @Override
    public boolean e() {
        return this.a.e();
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            b = false;
            if (o != null) {
                final Class<?> class1 = o.getClass();
                final Class<? extends a> class2 = this.getClass();
                b = false;
                if (class1 == class2) {
                    return this.a.equals(((a)o).a);
                }
            }
        }
        return b;
    }
    
    @Override
    public boolean f() {
        return true;
    }
    
    @Override
    public org.codehaus.jackson.f.a g() {
        return this.a;
    }
    
    @Override
    public int h() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "[array type, component type: " + this.a + "]";
    }
}
