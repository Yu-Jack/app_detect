// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

public enum o implements ak
{
    a(true), 
    b(true), 
    c(true), 
    d(true), 
    e(true), 
    f(true), 
    g(false), 
    h(false), 
    i(false), 
    j(false), 
    k(true), 
    l(false), 
    m(false), 
    n(true), 
    o(false), 
    p(false), 
    q(false);
    
    final boolean r;
    
    private o(final boolean r) {
        this.r = r;
    }
    
    @Override
    public boolean a() {
        return this.r;
    }
    
    @Override
    public int b() {
        return 1 << this.ordinal();
    }
}
