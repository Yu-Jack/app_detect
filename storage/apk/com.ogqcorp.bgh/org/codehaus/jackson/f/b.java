// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.f;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class b<T> implements Comparable<b<T>>
{
    final Type b;
    
    protected b() {
        final Type genericSuperclass = this.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        this.b = ((ParameterizedType)genericSuperclass).getActualTypeArguments()[0];
    }
    
    public int a(final b<T> b) {
        return 0;
    }
    
    public Type a() {
        return this.b;
    }
}
