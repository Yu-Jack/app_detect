// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import org.codehaus.jackson.p;

public final class o
{
    private static final p[] d;
    protected o a;
    protected long b;
    protected final Object[] c;
    
    static {
        d = new p[16];
        final p[] values = p.values();
        System.arraycopy(values, 1, o.d, 1, Math.min(15, -1 + values.length));
    }
    
    public o() {
        this.c = new Object[16];
    }
    
    public o a() {
        return this.a;
    }
    
    public o a(final int n, final p p2) {
        if (n < 16) {
            this.b(n, p2);
            return null;
        }
        (this.a = new o()).b(0, p2);
        return this.a;
    }
    
    public o a(final int n, final p p3, final Object o) {
        if (n < 16) {
            this.b(n, p3, o);
            return null;
        }
        (this.a = new o()).b(0, p3, o);
        return this.a;
    }
    
    public p a(final int n) {
        long b = this.b;
        if (n > 0) {
            b >>= n << 2;
        }
        return o.d[0xF & (int)b];
    }
    
    public Object b(final int n) {
        return this.c[n];
    }
    
    public void b(final int n, final p p2) {
        long n2 = p2.ordinal();
        if (n > 0) {
            n2 <<= n << 2;
        }
        this.b |= n2;
    }
    
    public void b(final int n, final p p3, final Object o) {
        this.c[n] = o;
        long n2 = p3.ordinal();
        if (n > 0) {
            n2 <<= n << 2;
        }
        this.b |= n2;
    }
}
