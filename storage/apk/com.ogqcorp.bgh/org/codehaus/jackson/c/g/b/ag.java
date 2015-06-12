// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.a.b;

@b
public final class ag extends y<short[]>
{
    public ag() {
        this((ba)null);
    }
    
    public ag(final ba ba) {
        super(short[].class, ba, null);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new ag(ba);
    }
    
    @Override
    public void a(final short[] array, final org.codehaus.jackson.f f, final ax ax) {
        for (int i = 0; i < array.length; ++i) {
            f.b(array[i]);
        }
    }
}
