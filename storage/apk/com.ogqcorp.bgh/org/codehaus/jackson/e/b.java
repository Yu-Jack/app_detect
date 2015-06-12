// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

final class b
{
    protected final f a;
    protected final b b;
    private final int c;
    
    b(final f a, final b b) {
        this.a = a;
        this.b = b;
        int c;
        if (b == null) {
            c = 1;
        }
        else {
            c = 1 + b.c;
        }
        this.c = c;
    }
    
    public int a() {
        return this.c;
    }
    
    public f a(final int n, final int n2, final int n3) {
        if (this.a.hashCode() != n || !this.a.a(n2, n3)) {
            for (b b = this.b; b != null; b = b.b) {
                final f f = b.a;
                if (f.hashCode() == n && f.a(n2, n3)) {
                    return f;
                }
            }
            return null;
        }
        return this.a;
    }
    
    public f a(final int n, final int[] array, final int n2) {
        if (this.a.hashCode() != n || !this.a.a(array, n2)) {
            for (b b = this.b; b != null; b = b.b) {
                final f f = b.a;
                if (f.hashCode() == n && f.a(array, n2)) {
                    return f;
                }
            }
            return null;
        }
        return this.a;
    }
}
