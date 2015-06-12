// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

public abstract class ay<T> extends bt<T>
{
    final T a;
    
    protected ay(final Class<T> clazz, final T a) {
        super(clazz);
        this.a = a;
    }
    
    @Override
    public final T b() {
        return this.a;
    }
}
