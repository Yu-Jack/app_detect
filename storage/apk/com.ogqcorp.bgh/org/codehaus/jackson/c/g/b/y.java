// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;

public abstract class y<T> extends e<T>
{
    protected final ba e;
    protected final f f;
    
    protected y(final Class<T> clazz, final ba e, final f f) {
        super(clazz);
        this.e = e;
        this.f = f;
    }
    
    @Override
    public final void a(final T t, final org.codehaus.jackson.f f, final ax ax) {
        f.b();
        this.b(t, f, ax);
        f.c();
    }
    
    @Override
    public final void a(final T t, final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        ba.c(t, f);
        this.b(t, f, ax);
        ba.f(t, f);
    }
    
    protected abstract void b(final T p0, final org.codehaus.jackson.f p1, final ax p2);
}
