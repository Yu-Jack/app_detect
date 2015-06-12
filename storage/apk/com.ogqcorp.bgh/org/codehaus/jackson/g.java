// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

public enum g
{
    a(true), 
    b(true), 
    c(true), 
    d(true), 
    e(false), 
    f(true), 
    g(false);
    
    final boolean h;
    final int i;
    
    private g(final boolean h) {
        this.h = h;
        this.i = 1 << this.ordinal();
    }
    
    public static int a() {
        int n = 0;
        for (final g g : values()) {
            if (g.b()) {
                n |= g.c();
            }
        }
        return n;
    }
    
    public boolean b() {
        return this.h;
    }
    
    public int c() {
        return this.i;
    }
}
