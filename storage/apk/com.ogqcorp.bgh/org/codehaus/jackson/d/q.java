// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.g.e;

public final class q extends r
{
    static final q c;
    final String d;
    
    static {
        c = new q("");
    }
    
    public q(final String d) {
        this.d = d;
    }
    
    protected static void a(final StringBuilder sb, final String s) {
        sb.append('\"');
        e.a(sb, s);
        sb.append('\"');
    }
    
    public static q b(final String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return q.c;
        }
        return new q(s);
    }
    
    @Override
    public String a() {
        return this.d;
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        if (this.d == null) {
            f.f();
            return;
        }
        f.b(this.d);
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
                final Class<? extends q> class2 = this.getClass();
                b = false;
                if (class1 == class2) {
                    return ((q)o).d.equals(this.d);
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return this.d.hashCode();
    }
    
    @Override
    public String toString() {
        final int length = this.d.length();
        final StringBuilder sb = new StringBuilder(length + 2 + (length >> 4));
        a(sb, this.d);
        return sb.toString();
    }
}
