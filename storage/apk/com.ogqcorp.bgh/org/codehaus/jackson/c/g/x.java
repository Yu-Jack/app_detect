// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.g.b.o;

@b
public final class x extends o<Double>
{
    static final x a;
    
    static {
        a = new x();
    }
    
    public x() {
        super(Double.class);
    }
    
    @Override
    public void a(final Double n, final f f, final ax ax) {
        f.a((double)n);
    }
}
