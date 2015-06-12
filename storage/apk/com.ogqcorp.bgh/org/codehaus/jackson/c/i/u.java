// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

public abstract class u<T>
{
    T a;
    v<T> b;
    v<T> c;
    int d;
    
    public T a() {
        this.b();
        if (this.a == null) {
            return this.b(12);
        }
        return this.a;
    }
    
    public final T a(final T t, final int n) {
        final v<T> c = new v<T>(t, n);
        if (this.b == null) {
            this.c = c;
            this.b = c;
        }
        else {
            this.c.a(c);
            this.c = c;
        }
        this.d += n;
        int n2;
        if (n < 16384) {
            n2 = n + n;
        }
        else {
            n2 = n + (n >> 2);
        }
        return this.b(n2);
    }
    
    protected abstract T b(final int p0);
    
    public T b(final T t, final int n) {
        final int i = n + this.d;
        final T b = this.b(i);
        v<T> v = this.b;
        int a = 0;
        while (v != null) {
            a = v.a(b, a);
            v = v.b();
        }
        System.arraycopy(t, 0, b, a, n);
        final int j = a + n;
        if (j != i) {
            throw new IllegalStateException("Should have gotten " + i + " entries, got " + j);
        }
        return b;
    }
    
    protected void b() {
        if (this.c != null) {
            this.a = this.c.a();
        }
        this.c = null;
        this.b = null;
        this.d = 0;
    }
}
