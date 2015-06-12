// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class an extends s<AtomicInteger>
{
    public an() {
        super(AtomicInteger.class, false);
    }
    
    @Override
    public void a(final AtomicInteger atomicInteger, final f f, final ax ax) {
        f.b(atomicInteger.get());
    }
}
