// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.util.Iterator;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import org.codehaus.jackson.c.i.a;

public final class j implements a
{
    protected HashMap<Class<? extends Annotation>, Annotation> a;
    
    public j() {
    }
    
    private j(final HashMap<Class<? extends Annotation>, Annotation> a) {
        this.a = a;
    }
    
    public static j a(j j, final j i) {
        if (j == null || j.a == null || j.a.isEmpty()) {
            j = i;
        }
        else if (i != null && i.a != null && !i.a.isEmpty()) {
            final HashMap<Class<? extends Annotation>, Annotation> hashMap = new HashMap<Class<? extends Annotation>, Annotation>();
            for (final Annotation value : i.a.values()) {
                hashMap.put(value.annotationType(), value);
            }
            for (final Annotation value2 : j.a.values()) {
                hashMap.put(value2.annotationType(), value2);
            }
            return new j(hashMap);
        }
        return j;
    }
    
    public int a() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }
    
    public <A extends Annotation> A a(final Class<A> key) {
        if (this.a == null) {
            return null;
        }
        return (A)this.a.get(key);
    }
    
    public void a(final Annotation annotation) {
        if (this.a == null || !this.a.containsKey(annotation.annotationType())) {
            this.c(annotation);
        }
    }
    
    public void b(final Annotation annotation) {
        this.c(annotation);
    }
    
    protected final void c(final Annotation value) {
        if (this.a == null) {
            this.a = new HashMap<Class<? extends Annotation>, Annotation>();
        }
        this.a.put(value.annotationType(), value);
    }
    
    @Override
    public String toString() {
        if (this.a == null) {
            return "[null]";
        }
        return this.a.toString();
    }
}
