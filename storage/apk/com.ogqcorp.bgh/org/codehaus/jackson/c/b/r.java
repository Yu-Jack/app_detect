// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.x;

public final class r extends x<Object>
{
    final az a;
    final x<Object> b;
    
    public r(final az a, final x<Object> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public Object a(final k k, final p p2) {
        return this.b.a(k, p2, this.a);
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }
}
