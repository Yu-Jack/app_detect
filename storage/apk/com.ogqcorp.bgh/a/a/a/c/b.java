// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.c;

import java.io.Serializable;

public final class b implements Serializable
{
    private byte[] a;
    private int b;
    
    public b(final int n) {
        a.a.a.c.a.a(n, "Buffer capacity");
        this.a = new byte[n];
    }
    
    private void a(final int b) {
        final byte[] a = new byte[Math.max(this.a.length << 1, b)];
        System.arraycopy(this.a, 0, a, 0, this.b);
        this.a = a;
    }
    
    public int a() {
        return this.b;
    }
    
    public void a(final byte[] array, final int i, final int j) {
        if (array != null) {
            if (i < 0 || i > array.length || j < 0 || i + j < 0 || i + j > array.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + j + " b.length: " + array.length);
            }
            if (j != 0) {
                final int b = j + this.b;
                if (b > this.a.length) {
                    this.a(b);
                }
                System.arraycopy(array, i, this.a, this.b, j);
                this.b = b;
            }
        }
    }
    
    public byte[] b() {
        return this.a;
    }
}
