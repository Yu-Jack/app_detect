// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.k;

public abstract class x<T>
{
    public abstract T a(final k p0, final p p1);
    
    public T a(final k k, final p p3, final T t) {
        throw new UnsupportedOperationException();
    }
    
    public Object a(final k k, final p p3, final az az) {
        return az.d(k, p3);
    }
    
    public x<T> a() {
        return this;
    }
    
    public T b() {
        return null;
    }
    
    public T c() {
        return this.b();
    }
}
