// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Map;

public class f extends h<f>
{
    public f() {
        bd.a().a(be.Y);
        this.a("&t", "event");
    }
    
    public f a(final long i) {
        this.a("&ev", Long.toString(i));
        return this;
    }
    
    public f a(final String s) {
        this.a("&ec", s);
        return this;
    }
    
    public f b(final String s) {
        this.a("&ea", s);
        return this;
    }
    
    public f c(final String s) {
        this.a("&el", s);
        return this;
    }
}
