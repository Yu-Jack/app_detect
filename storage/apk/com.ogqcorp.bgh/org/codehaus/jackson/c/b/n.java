// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.f.a;

public final class n
{
    private final Object a;
    private final boolean b;
    private final Class<?> c;
    
    protected n(final a a, final Object a2) {
        this.a = a2;
        this.b = a.t();
        this.c = a.p();
    }
    
    public Object a(final p p) {
        if (this.b && p.a(o.l)) {
            throw p.b("Can not map JSON null into type " + this.c.getName() + " (set DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
        }
        return this.a;
    }
}
