// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import java.util.Arrays;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.b;

public final class d extends r
{
    static final d c;
    final byte[] d;
    
    static {
        c = new d(new byte[0]);
    }
    
    public d(final byte[] d) {
        this.d = d;
    }
    
    public static d a(final byte[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0) {
            return d.c;
        }
        return new d(array);
    }
    
    @Override
    public String a() {
        return org.codehaus.jackson.b.a().a(this.d, false);
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        f.a(this.d);
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
                final Class<? extends d> class2 = this.getClass();
                b = false;
                if (class1 == class2) {
                    return Arrays.equals(((d)o).d, this.d);
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        if (this.d == null) {
            return -1;
        }
        return this.d.length;
    }
    
    @Override
    public String toString() {
        return org.codehaus.jackson.b.a().a(this.d, true);
    }
}
