// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.b.h;

public final class l extends n
{
    final long c;
    
    public l(final long c) {
        this.c = c;
    }
    
    public static l a(final long n) {
        return new l(n);
    }
    
    @Override
    public String a() {
        return h.a(this.c);
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        f.a(this.c);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            if (((l)o).c != this.c) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return (int)this.c ^ (int)(this.c >> 32);
    }
}
