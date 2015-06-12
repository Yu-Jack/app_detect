// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import org.codehaus.jackson.c.i.l;
import java.lang.reflect.Member;

public abstract class e extends a
{
    protected final j b;
    
    protected e(final j b) {
        this.b = b;
    }
    
    public abstract void a(final Object p0, final Object p1);
    
    public abstract Class<?> h();
    
    public abstract Member i();
    
    protected j j() {
        return this.b;
    }
    
    public final void k() {
        l.a(this.i());
    }
}
