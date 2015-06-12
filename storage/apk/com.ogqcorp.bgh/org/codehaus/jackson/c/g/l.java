// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.ad;

final class l extends d
{
    protected final d p;
    protected final Class<?>[] q;
    
    protected l(final d p2, final Class<?>[] q) {
        super(p2);
        this.p = p2;
        this.q = q;
    }
    
    @Override
    public d a(final ad<Object> ad) {
        return new l(this.p.a(ad), this.q);
    }
    
    @Override
    public void a(final Object o, final org.codehaus.jackson.f f, final ax ax) {
        final Class<?> a = ax.a();
        if (a != null) {
            int n;
            int length;
            for (n = 0, length = this.q.length; n < length && !this.q[n].isAssignableFrom(a); ++n) {}
            if (n == length) {
                return;
            }
        }
        this.p.a(o, f, ax);
    }
}
