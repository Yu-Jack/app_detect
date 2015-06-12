// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Type;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.h.j;
import java.lang.reflect.AnnotatedElement;
import java.lang.annotation.Annotation;

public abstract class a
{
    public abstract <A extends Annotation> A a(final Class<A> p0);
    
    public abstract AnnotatedElement a();
    
    public org.codehaus.jackson.f.a a(final j j) {
        return j.a(this.c());
    }
    
    public abstract String b();
    
    public final <A extends Annotation> boolean b(final Class<A> clazz) {
        return this.a(clazz) != null;
    }
    
    public abstract Type c();
    
    public abstract Class<?> d();
}
