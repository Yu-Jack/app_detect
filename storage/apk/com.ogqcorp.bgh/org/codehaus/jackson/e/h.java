// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

public final class h extends f
{
    final int c;
    final int d;
    
    h(final String s, final int n, final int c, final int d) {
        super(s, n);
        this.c = c;
        this.d = d;
    }
    
    @Override
    public boolean a(final int n) {
        return false;
    }
    
    @Override
    public boolean a(final int n, final int n2) {
        return n == this.c && n2 == this.d;
    }
    
    @Override
    public boolean a(final int[] array, final int n) {
        return n == 2 && array[0] == this.c && array[1] == this.d;
    }
}
