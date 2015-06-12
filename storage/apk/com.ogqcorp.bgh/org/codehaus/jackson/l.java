// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

public enum l
{
    a(true), 
    b(false), 
    c(false), 
    d(false), 
    e(false), 
    f(false), 
    g(false), 
    h(false), 
    i(true), 
    j(true);
    
    final boolean k;
    
    private l(final boolean k) {
        this.k = k;
    }
    
    public static int a() {
        int n = 0;
        for (final l l : values()) {
            if (l.b()) {
                n |= l.c();
            }
        }
        return n;
    }
    
    public boolean a(final int n) {
        return (n & this.c()) != 0x0;
    }
    
    public boolean b() {
        return this.k;
    }
    
    public int c() {
        return 1 << this.ordinal();
    }
}
