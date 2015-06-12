// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.a.b;

@b
public final class ad extends y<float[]>
{
    public ad() {
        this((ba)null);
    }
    
    public ad(final ba ba) {
        super(float[].class, ba, null);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new ad(ba);
    }
    
    @Override
    public void a(final float[] array, final org.codehaus.jackson.f f, final ax ax) {
        for (int i = 0; i < array.length; ++i) {
            f.a(array[i]);
        }
    }
}
