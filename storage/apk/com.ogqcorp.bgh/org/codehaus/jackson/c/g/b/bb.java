// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.g.m;

@b
public class bb extends v<m>
{
    public bb() {
        super(m.class);
    }
    
    @Override
    public void a(final m m, final f f, final ax ax) {
        m.a(f);
    }
    
    @Override
    public final void a(final m m, final f f, final ax ax, final ba ba) {
        ba.a(m, f);
        this.a(m, f, ax);
        ba.d(m, f);
    }
}
