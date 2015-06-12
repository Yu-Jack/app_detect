// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

public enum au implements ak
{
    a(true), 
    b(true), 
    c(true), 
    d(true), 
    e(true), 
    f(false), 
    g(true), 
    h(false), 
    i(true), 
    j(false), 
    k(false), 
    l(false), 
    m(true), 
    n(true), 
    o(false), 
    p(true), 
    q(true), 
    r(false), 
    s(false), 
    t(false), 
    u(false), 
    v(true), 
    w(true);
    
    final boolean x;
    
    private au(final boolean x) {
        this.x = x;
    }
    
    @Override
    public boolean a() {
        return this.x;
    }
    
    @Override
    public int b() {
        return 1 << this.ordinal();
    }
}
