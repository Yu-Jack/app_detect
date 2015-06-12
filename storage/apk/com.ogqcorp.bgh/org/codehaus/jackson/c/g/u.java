// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ad;

final class u extends ad<Object>
{
    protected final ba a;
    protected final ad<Object> b;
    
    public u(final ba a, final ad<Object> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void a(final Object o, final f f, final ax ax) {
        this.b.a(o, f, ax, this.a);
    }
    
    @Override
    public void a(final Object o, final f f, final ax ax, final ba ba) {
        this.b.a(o, f, ax, ba);
    }
    
    @Override
    public Class<Object> c() {
        return Object.class;
    }
}
