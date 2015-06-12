// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.b.h;

public final class i extends n
{
    protected final double c;
    
    public i(final double c) {
        this.c = c;
    }
    
    public static i a(final double n) {
        return new i(n);
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
            if (((i)o).c != this.c) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.c);
        return (int)doubleToLongBits ^ (int)(doubleToLongBits >> 32);
    }
}
