// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import java.util.ArrayList;
import java.util.List;

public final class g
{
    private static g b;
    List a;
    
    static {
        g.b = new g();
    }
    
    private g() {
        this.a = new ArrayList();
    }
    
    public static g a() {
        return g.b;
    }
    
    public final void a(final String s) {
        this.a.add(new h(s));
    }
}
