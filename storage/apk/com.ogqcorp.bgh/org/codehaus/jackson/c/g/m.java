// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.ad;

final class m extends d
{
    protected final d p;
    protected final Class<?> q;
    
    protected m(final d p2, final Class<?> q) {
        super(p2);
        this.p = p2;
        this.q = q;
    }
    
    @Override
    public d a(final ad<Object> ad) {
        return new m(this.p.a(ad), this.q);
    }
    
    @Override
    public void a(final Object o, final org.codehaus.jackson.f f, final ax ax) {
        final Class<?> a = ax.a();
        if (a == null || this.q.isAssignableFrom(a)) {
            this.p.a(o, f, ax);
        }
    }
}
