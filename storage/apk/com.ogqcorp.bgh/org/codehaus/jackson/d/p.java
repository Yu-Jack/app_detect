// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;

public final class p extends r
{
    protected final Object c;
    
    public p(final Object c) {
        this.c = c;
    }
    
    @Override
    public String a() {
        if (this.c == null) {
            return "null";
        }
        return this.c.toString();
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        if (this.c == null) {
            f.f();
            return;
        }
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
            final p p = (p)o;
            if (this.c != null) {
                return this.c.equals(p.c);
            }
            if (p.c != null) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.c.hashCode();
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.c);
    }
}
