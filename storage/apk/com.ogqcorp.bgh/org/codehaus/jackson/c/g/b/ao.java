// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.util.concurrent.atomic.AtomicLong;

public final class ao extends s<AtomicLong>
{
    public ao() {
        super(AtomicLong.class, false);
    }
    
    @Override
    public void a(final AtomicLong atomicLong, final f f, final ax ax) {
        f.a(atomicLong.get());
    }
}
