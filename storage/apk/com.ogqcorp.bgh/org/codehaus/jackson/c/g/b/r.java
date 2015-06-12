// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;

@b
public class r<T> extends v<T>
{
    public r(final Class<?> clazz) {
        super(clazz, false);
    }
    
    @Override
    public void a(final T t, final f f, final ax ax) {
        f.d(t.toString());
    }
    
    @Override
    public void a(final T t, final f f, final ax ax, final ba ba) {
        ba.a(t, f);
        this.a(t, f, ax);
        ba.d(t, f);
    }
}
