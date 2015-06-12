// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class am extends s<AtomicBoolean>
{
    public am() {
        super(AtomicBoolean.class, false);
    }
    
    @Override
    public void a(final AtomicBoolean atomicBoolean, final f f, final ax ax) {
        f.a(atomicBoolean.get());
    }
}
