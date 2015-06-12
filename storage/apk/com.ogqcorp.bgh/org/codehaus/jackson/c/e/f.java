// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;
import org.codehaus.jackson.f.a;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public final class f extends i
{
    protected final Method a;
    protected Class<?>[] c;
    
    public f(final Method a, final j j, final j[] array) {
        super(j, array);
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
        return this.a.invoke(null, o);
    }
    
    @Override
    public final Object a(final Object[] args) {
        return this.a.invoke(null, args);
    }
    
    public f a(final Method method) {
        return new f(method, this.b, this.d);
    }
    
    public f a(final j j) {
        return new f(this.a, j, this.d);
    }
    
    @Override
    public org.codehaus.jackson.f.a a(final org.codehaus.jackson.c.h.j j) {
        return this.a(j, this.a.getTypeParameters());
    }
    
    @Override
    public void a(final Object obj, final Object o) {
        try {
            this.a.invoke(obj, o);
        }
        catch (IllegalAccessException cause) {
            throw new IllegalArgumentException("Failed to setValue() with method " + this.n() + ": " + cause.getMessage(), cause);
        }
        catch (InvocationTargetException cause2) {
            throw new IllegalArgumentException("Failed to setValue() with method " + this.n() + ": " + cause2.getMessage(), cause2);
        }
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
        return this.a.getGenericReturnType();
    }
    
    @Override
    public Class<?> d() {
        return this.a.getReturnType();
    }
    
    public Method e() {
        return this.a;
    }
    
    public int f() {
        return this.l().length;
    }
    
    @Override
    public final Object g() {
        return this.a.invoke(null, new Object[0]);
    }
    
    @Override
    public Class<?> h() {
        return this.a.getDeclaringClass();
    }
    
    @Override
    public Member i() {
        return this.a;
    }
    
    public Type[] l() {
        return this.a.getGenericParameterTypes();
    }
    
    public Class<?>[] m() {
        if (this.c == null) {
            this.c = this.a.getParameterTypes();
        }
        return this.c;
    }
    
    public String n() {
        return this.h().getName() + "#" + this.b() + "(" + this.f() + " params)";
    }
    
    @Override
    public String toString() {
        return "[method " + this.b() + ", annotations: " + this.b + "]";
    }
}
