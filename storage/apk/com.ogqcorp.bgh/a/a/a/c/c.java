// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.c;

import java.io.Serializable;

public final class c implements Serializable
{
    private char[] a;
    private int b;
    
    public c(final int n) {
        a.a.a.c.a.a(n, "Buffer capacity");
        this.a = new char[n];
    }
    
    private void b(final int b) {
        final char[] a = new char[Math.max(this.a.length << 1, b)];
        System.arraycopy(this.a, 0, a, 0, this.b);
        this.a = a;
    }
    
    public void a() {
        this.b = 0;
    }
    
    public void a(final char c) {
        final int b = 1 + this.b;
        if (b > this.a.length) {
            this.b(b);
        }
        this.a[this.b] = c;
        this.b = b;
    }
    
    public void a(final int n) {
        if (n > 0 && n > this.a.length - this.b) {
            this.b(n + this.b);
        }
    }
    
    public void a(String s) {
        if (s == null) {
            s = "null";
        }
        final int length = s.length();
        final int b = length + this.b;
        if (b > this.a.length) {
            this.b(b);
        }
        s.getChars(0, length, this.a, this.b);
        this.b = b;
    }
    
    @Override
    public String toString() {
        return new String(this.a, 0, this.b);
    }
}
