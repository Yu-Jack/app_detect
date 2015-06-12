// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;

public abstract class s<T> extends v<T>
{
    protected s(final Class<T> clazz) {
        super(clazz);
    }
    
    protected s(final Class<?> clazz, final boolean b) {
        super(clazz);
    }
    
    @Override
    public void a(final T t, final f f, final ax ax, final ba ba) {
        ba.a(t, f);
        this.a(t, f, ax);
        ba.d(t, f);
    }
}
