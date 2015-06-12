// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.d.o;

final class z extends c<o>
{
    protected static final z a;
    
    static {
        a = new z();
    }
    
    protected z() {
        super(o.class);
    }
    
    public static z d() {
        return z.a;
    }
    
    public o b(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.b) {
            k.b();
            return this.a(k, p2, p2.e());
        }
        if (k.e() == org.codehaus.jackson.p.f) {
            return this.a(k, p2, p2.e());
        }
        throw p2.b(o.class);
    }
}
