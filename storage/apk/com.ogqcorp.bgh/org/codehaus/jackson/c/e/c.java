// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.codehaus.jackson.f.a;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;

public final class c extends i
{
    protected final Constructor<?> a;
    
    public c(final Constructor<?> a, final j j, final j[] array) {
        super(j, array);
        if (a == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this.a = a;
    }
    
    public Class<?> a(final int n) {
        final Class<?>[] parameterTypes = this.a.getParameterTypes();
        if (n >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[n];
    }
    
    @Override
    public final Object a(final Object o) {
        return this.a.newInstance(o);
    }
    
    @Override
    public final Object a(final Object[] initargs) {
        return this.a.newInstance(initargs);
    }
    
    @Override
    public org.codehaus.jackson.f.a a(final org.codehaus.jackson.c.h.j j) {
        return this.a(j, this.a.getTypeParameters());
    }
    
    @Override
    public void a(final Object o, final Object o2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + this.h().getName());
    }
    
    @Override
    public String b() {
        return this.a.getName();
    }
    
    @Override
    public Type b(final int n) {
        final Type[] genericParameterTypes = this.a.getGenericParameterTypes();
        if (n >= genericParameterTypes.length) {
            return null;
        }
        return genericParameterTypes[n];
    }
    
    @Override
    public Type c() {
        return this.d();
    }
    
    @Override
    public Class<?> d() {
        return this.a.getDeclaringClass();
    }
    
    public Constructor<?> e() {
        return this.a;
    }
    
    public int f() {
        return this.a.getParameterTypes().length;
    }
    
    @Override
    public final Object g() {
        return this.a.newInstance(new Object[0]);
    }
    
    @Override
    public Class<?> h() {
        return this.a.getDeclaringClass();
    }
    
    @Override
    public Member i() {
        return this.a;
    }
    
    @Override
    public String toString() {
        return "[constructor for " + this.b() + ", annotations: " + this.b + "]";
    }
}
