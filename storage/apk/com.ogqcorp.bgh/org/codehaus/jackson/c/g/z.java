// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.g.b.s;

@b
public final class z extends s<Number>
{
    static final z a;
    
    static {
        a = new z();
    }
    
    public z() {
        super(Number.class);
    }
    
    @Override
    public void a(final Number n, final f f, final ax ax) {
        f.b(n.intValue());
    }
}
