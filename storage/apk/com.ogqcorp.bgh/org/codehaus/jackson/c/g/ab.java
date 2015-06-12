// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.g.b.s;

@b
public final class ab extends s<Long>
{
    static final ab a;
    
    static {
        a = new ab();
    }
    
    public ab() {
        super(Long.class);
    }
    
    @Override
    public void a(final Long n, final f f, final ax ax) {
        f.a((long)n);
    }
}
