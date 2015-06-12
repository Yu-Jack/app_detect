// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.a.b;

@b
public final class z extends y<boolean[]>
{
    public z() {
        super(boolean[].class, null, null);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return this;
    }
    
    @Override
    public void a(final boolean[] array, final org.codehaus.jackson.f f, final ax ax) {
        for (int i = 0; i < array.length; ++i) {
            f.a(array[i]);
        }
    }
}
