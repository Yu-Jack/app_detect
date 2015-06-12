// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.lang.reflect.AnnotatedElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class d extends e
{
    protected final Field a;
    
    public d(final Field a, final j j) {
        super(j);
        this.a = a;
    }
    
    @Override
    public <A extends Annotation> A a(final Class<A> clazz) {
        return this.b.a(clazz);
    }
    
    public d a(final j j) {
        return new d(this.a, j);
    }
    
    @Override
    public void a(final Object obj, final Object value) {
        try {
            this.a.set(obj, value);
        }
        catch (IllegalAccessException cause) {
            throw new IllegalArgumentException("Failed to setValue() for field " + this.f() + ": " + cause.getMessage(), cause);
        }
    }
    
    public void a(final Annotation annotation) {
        this.b.b(annotation);
    }
    
    @Override
    public String b() {
        return this.a.getName();
    }
    
    @Override
    public Type c() {
        return this.a.getGenericType();
    }
    
    @Override
    public Class<?> d() {
        return this.a.getType();
    }
    
    public Field e() {
        return this.a;
    }
    
    public String f() {
        return this.h().getName() + "#" + this.b();
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
        return "[field " + this.b() + ", annotations: " + this.b + "]";
    }
}
