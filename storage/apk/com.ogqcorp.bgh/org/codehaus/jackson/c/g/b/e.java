// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;

public abstract class e<T> extends v<T>
{
    protected e(final Class<T> clazz) {
        super(clazz);
    }
    
    protected e(final Class<?> clazz, final boolean b) {
        super(clazz, b);
    }
    
    public abstract e<?> a(final ba p0);
    
    public e<?> b(final ba ba) {
        if (ba == null) {
            return this;
        }
        return this.a(ba);
    }
}
