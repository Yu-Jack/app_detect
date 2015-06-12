// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import org.codehaus.jackson.s;

public class k implements s
{
    protected final String a;
    protected byte[] b;
    protected byte[] c;
    protected char[] d;
    
    public k(final String a) {
        this.a = a;
    }
    
    @Override
    public final String a() {
        return this.a;
    }
    
    @Override
    public final char[] b() {
        char[] d = this.d;
        if (d == null) {
            d = e.a().a(this.a);
            this.d = d;
        }
        return d;
    }
    
    @Override
    public final byte[] c() {
        byte[] c = this.c;
        if (c == null) {
            c = e.a().c(this.a);
            this.c = c;
        }
        return c;
    }
    
    @Override
    public final byte[] d() {
        byte[] b = this.b;
        if (b == null) {
            b = e.a().b(this.a);
            this.b = b;
        }
        return b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o == this || (o != null && o.getClass() == this.getClass() && this.a.equals(((k)o).a));
    }
    
    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public final String toString() {
        return this.a;
    }
}
