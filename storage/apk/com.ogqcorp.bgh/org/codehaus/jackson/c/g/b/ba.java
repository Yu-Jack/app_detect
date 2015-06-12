// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;

@b
public class ba extends v<Object>
{
    public static final ba a;
    
    static {
        a = new ba();
    }
    
    public ba() {
        super(Object.class);
    }
    
    @Override
    public void a(final Object o, final f f, final ax ax) {
        f.b(o.toString());
    }
    
    @Override
    public void a(final Object o, final f f, final ax ax, final org.codehaus.jackson.c.ba ba) {
        ba.a(o, f);
        this.a(o, f, ax);
        ba.d(o, f);
    }
}
