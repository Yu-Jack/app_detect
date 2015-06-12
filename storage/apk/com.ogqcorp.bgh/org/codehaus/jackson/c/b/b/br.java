// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.util.UUID;

final class br extends bc
{
    protected br() {
        super(UUID.class);
    }
    
    public UUID c(final String name, final p p2) {
        return UUID.fromString(name);
    }
}
