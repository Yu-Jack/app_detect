// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.math.BigDecimal;

public final class h extends n
{
    protected final BigDecimal c;
    
    public h(final BigDecimal c) {
        this.c = c;
    }
    
    public static h a(final BigDecimal bigDecimal) {
        return new h(bigDecimal);
    }
    
    @Override
    public String a() {
        return this.c.toString();
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        f.a(this.c);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            b = false;
            if (o != null) {
                final Class<?> class1 = o.getClass();
                final Class<? extends h> class2 = this.getClass();
                b = false;
                if (class1 == class2) {
                    return ((h)o).c.equals(this.c);
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return this.c.hashCode();
    }
}
