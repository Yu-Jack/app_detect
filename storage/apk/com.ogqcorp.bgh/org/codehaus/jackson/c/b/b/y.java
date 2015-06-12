// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.d.a;

final class y extends c<a>
{
    protected static final y a;
    
    static {
        a = new y();
    }
    
    protected y() {
        super(a.class);
    }
    
    public static y d() {
        return y.a;
    }
    
    public a b(final k k, final p p2) {
        if (k.j()) {
            return this.b(k, p2, p2.e());
        }
        throw p2.b(a.class);
    }
}
