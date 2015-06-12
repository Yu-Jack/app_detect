// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.util.concurrent.atomic.AtomicReference;

public final class ap extends v<AtomicReference<?>>
{
    public ap() {
        super(AtomicReference.class, false);
    }
    
    @Override
    public void a(final AtomicReference<?> atomicReference, final f f, final ax ax) {
        ax.a(atomicReference.get(), f);
    }
}
