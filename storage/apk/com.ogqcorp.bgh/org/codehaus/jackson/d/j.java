// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.b.h;

public final class j extends n
{
    private static final j[] d;
    final int c;
    
    static {
        d = new j[12];
        for (int i = 0; i < 12; ++i) {
            j.d[i] = new j(i - 1);
        }
    }
    
    public j(final int c) {
        this.c = c;
    }
    
    public static j a(final int n) {
        if (n > 10 || n < -1) {
            return new j(n);
        }
        return j.d[n + 1];
    }
    
    @Override
    public String a() {
        return h.a(this.c);
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        f.b(this.c);
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
            if (((j)o).c != this.c) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.c;
    }
}
