// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.a.b;

@b
public final class ae extends y<int[]>
{
    public ae() {
        super(int[].class, null, null);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return this;
    }
    
    @Override
    public void a(final int[] array, final org.codehaus.jackson.f f, final ax ax) {
        for (int i = 0; i < array.length; ++i) {
            f.b(array[i]);
        }
    }
}
