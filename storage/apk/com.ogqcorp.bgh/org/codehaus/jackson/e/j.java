// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

public final class j extends f
{
    final int[] c;
    final int d;
    
    j(final String s, final int n, final int[] c, final int d) {
        super(s, n);
        if (d < 3) {
            throw new IllegalArgumentException("Qlen must >= 3");
        }
        this.c = c;
        this.d = d;
    }
    
    @Override
    public boolean a(final int n) {
        return false;
    }
    
    @Override
    public boolean a(final int n, final int n2) {
        return false;
    }
    
    @Override
    public boolean a(final int[] array, final int n) {
        if (n == this.d) {
            for (int i = 0; i < n; ++i) {
                if (array[i] != this.c[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
