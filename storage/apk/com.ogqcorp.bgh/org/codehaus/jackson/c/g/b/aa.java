// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;

@b
public final class aa extends v<byte[]>
{
    public aa() {
        super(byte[].class);
    }
    
    @Override
    public void a(final byte[] array, final f f, final ax ax) {
        f.a(array);
    }
    
    @Override
    public void a(final byte[] array, final f f, final ax ax, final ba ba) {
        ba.a(array, f);
        f.a(array);
        ba.d(array, f);
    }
}
