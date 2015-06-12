// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ac;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.ab;
import org.codehaus.jackson.c.g.s;

@b
public class t extends s<ab>
{
    public static final t a;
    
    static {
        a = new t();
    }
    
    protected t() {
        super(ab.class);
    }
    
    @Override
    public void a(final ab ab, final f f, final ax ax) {
        ab.a(f, ax);
    }
    
    @Override
    public final void a(final ab ab, final f f, final ax ax, final ba ba) {
        if (ab instanceof ac) {
            ((ac)ab).a(f, ax, ba);
            return;
        }
        this.a(ab, f, ax);
    }
}
