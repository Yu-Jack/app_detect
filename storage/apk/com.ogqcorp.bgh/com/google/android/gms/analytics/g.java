// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Map;

public class g extends h<g>
{
    public g() {
        bd.a().a(be.H);
        this.a("&t", "exception");
    }
    
    public g a(final String s) {
        this.a("&exd", s);
        return this;
    }
    
    public g a(final boolean b) {
        this.a("&exf", ab.a(b));
        return this;
    }
}
