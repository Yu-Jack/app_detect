// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

final class v<T>
{
    final T a;
    final int b;
    v<T> c;
    
    public v(final T a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public int a(final T t, final int n) {
        System.arraycopy(this.a, 0, t, n, this.b);
        return n + this.b;
    }
    
    public T a() {
        return this.a;
    }
    
    public void a(final v<T> c) {
        if (this.c != null) {
            throw new IllegalStateException();
        }
        this.c = c;
    }
    
    public v<T> b() {
        return this.c;
    }
}
