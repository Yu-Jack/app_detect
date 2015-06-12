// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

public class a
{
    protected final byte[][] a;
    protected final char[][] b;
    
    public a() {
        this.a = new byte[org.codehaus.jackson.g.b.values().length][];
        this.b = new char[c.values().length][];
    }
    
    private final byte[] a(final int n) {
        return new byte[n];
    }
    
    private final char[] b(final int n) {
        return new char[n];
    }
    
    public final void a(final b b, final byte[] array) {
        this.a[b.ordinal()] = array;
    }
    
    public final void a(final c c, final char[] array) {
        this.b[c.ordinal()] = array;
    }
    
    public final byte[] a(final b b) {
        final int ordinal = b.ordinal();
        final byte[] array = this.a[ordinal];
        if (array == null) {
            return this.a(b.d);
        }
        this.a[ordinal] = null;
        return array;
    }
    
    public final char[] a(final c c) {
        return this.a(c, 0);
    }
    
    public final char[] a(final c c, int a) {
        if (c.e > a) {
            a = c.e;
        }
        final int ordinal = c.ordinal();
        final char[] array = this.b[ordinal];
        if (array == null || array.length < a) {
            return this.b(a);
        }
        this.b[ordinal] = null;
        return array;
    }
}
