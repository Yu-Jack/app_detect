// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.au;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;

@b
public final class ab extends v<char[]>
{
    public ab() {
        super(char[].class);
    }
    
    private final void a(final f f, final char[] array) {
        for (int i = 0; i < array.length; ++i) {
            f.a(array, i, 1);
        }
    }
    
    @Override
    public void a(final char[] array, final f f, final ax ax) {
        if (ax.a(au.s)) {
            f.b();
            this.a(f, array);
            f.c();
            return;
        }
        f.a(array, 0, array.length);
    }
    
    @Override
    public void a(final char[] array, final f f, final ax ax, final ba ba) {
        if (ax.a(au.s)) {
            ba.c(array, f);
            this.a(f, array);
            ba.f(array, f);
            return;
        }
        ba.a(array, f);
        f.a(array, 0, array.length);
        ba.d(array, f);
    }
}
