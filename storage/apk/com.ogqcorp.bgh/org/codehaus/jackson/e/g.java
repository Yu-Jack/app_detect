// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

public final class g extends f
{
    static final g c;
    final int d;
    
    static {
        c = new g("", 0, 0);
    }
    
    g(final String s, final int n, final int d) {
        super(s, n);
        this.d = d;
    }
    
    static final g b() {
        return g.c;
    }
    
    @Override
    public boolean a(final int n) {
        return n == this.d;
    }
    
    @Override
    public boolean a(final int n, final int n2) {
        return n == this.d && n2 == 0;
    }
    
    @Override
    public boolean a(final int[] array, final int n) {
        return n == 1 && array[0] == this.d;
    }
}
