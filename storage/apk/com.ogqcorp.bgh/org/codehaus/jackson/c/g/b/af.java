// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.a.b;

@b
public final class af extends y<long[]>
{
    public af() {
        this((ba)null);
    }
    
    public af(final ba ba) {
        super(long[].class, ba, null);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new af(ba);
    }
    
    @Override
    public void a(final long[] array, final org.codehaus.jackson.f f, final ax ax) {
        for (int i = 0; i < array.length; ++i) {
            f.a(array[i]);
        }
    }
}
