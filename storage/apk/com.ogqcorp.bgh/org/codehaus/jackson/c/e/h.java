// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Member;
import org.codehaus.jackson.c.h.k;
import java.lang.reflect.AnnotatedElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class h extends e
{
    protected final i a;
    protected final Type c;
    protected final int d;
    
    public h(final i a, final Type c, final j j, final int d) {
        super(j);
        this.a = a;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public <A extends Annotation> A a(final Class<A> clazz) {
        return this.b.a(clazz);
    }
    
    @Override
    public AnnotatedElement a() {
        return null;
    }
    
    public h a(final j j) {
        if (j == this.b) {
            return this;
        }
        return this.a.a(this.d, j);
    }
    
    @Override
    public void a(final Object o, final Object o2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + this.h().getName());
    }
    
    @Override
    public String b() {
        return "";
    }
    
    @Override
    public Type c() {
        return this.c;
    }
    
    @Override
    public Class<?> d() {
        if (this.c instanceof Class) {
            return (Class<?>)this.c;
        }
        return k.a().a(this.c).p();
    }
    
    public Type e() {
        return this.c;
    }
    
    public i f() {
        return this.a;
    }
    
    public int g() {
        return this.d;
    }
    
    @Override
    public Class<?> h() {
        return this.a.h();
    }
    
    @Override
    public Member i() {
        return this.a.i();
    }
    
    @Override
    public String toString() {
        return "[parameter #" + this.g() + ", annotations: " + this.b + "]";
    }
}
