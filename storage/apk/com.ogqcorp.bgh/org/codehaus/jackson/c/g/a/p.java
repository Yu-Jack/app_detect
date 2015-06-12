// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.g.b.b;

public class p extends b
{
    public p(final b b) {
        super(b);
    }
    
    @Override
    public ad<Object> a() {
        return this;
    }
    
    @Override
    public final void a(final Object o, final f f, final ax ax) {
        if (this.e != null) {
            this.c(o, f, ax);
            return;
        }
        this.b(o, f, ax);
    }
    
    @Override
    public boolean b() {
        return true;
    }
    
    @Override
    public String toString() {
        return "UnwrappingBeanSerializer for " + this.c().getName();
    }
}
