// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Type;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.f.a;
import java.lang.reflect.TypeVariable;
import java.lang.annotation.Annotation;

public abstract class i extends e
{
    protected final j[] d;
    
    protected i(final j j, final j[] d) {
        super(j);
        this.d = d;
    }
    
    public abstract Object a(final Object p0);
    
    public abstract Object a(final Object[] p0);
    
    @Override
    public final <A extends Annotation> A a(final Class<A> clazz) {
        return this.b.a(clazz);
    }
    
    protected h a(final int n, final j j) {
        this.d[n] = j;
        return this.c(n);
    }
    
    protected org.codehaus.jackson.f.a a(org.codehaus.jackson.c.h.j a, final TypeVariable<?>[] array) {
        if (array != null && array.length > 0) {
            a = a.a();
            for (final TypeVariable<?> typeVariable : array) {
                a.b(typeVariable.getName());
                final Type type = typeVariable.getBounds()[0];
                org.codehaus.jackson.f.a a2;
                if (type == null) {
                    a2 = k.b();
                }
                else {
                    a2 = a.a(type);
                }
                a.a(typeVariable.getName(), a2);
            }
        }
        return a.a(this.c());
    }
    
    public final void a(final int n, final Annotation annotation) {
        j j = this.d[n];
        if (j == null) {
            j = new j();
            this.d[n] = j;
        }
        j.b(annotation);
    }
    
    public final void a(final Annotation annotation) {
        this.b.b(annotation);
    }
    
    public abstract Type b(final int p0);
    
    public final void b(final Annotation annotation) {
        this.b.a(annotation);
    }
    
    public final h c(final int n) {
        return new h(this, this.b(n), this.d[n], n);
    }
    
    public abstract Object g();
}
