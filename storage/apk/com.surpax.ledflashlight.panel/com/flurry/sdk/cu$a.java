// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

public class cu$a
{
    private cu a;
    
    public cu$a() {
        this.a = new cu(null);
    }
    
    public cu$a a(final int n) {
        this.a.a = n;
        return this;
    }
    
    public cu$a a(final cv cv) {
        this.a.e = cv;
        return this;
    }
    
    public cu$a a(final ds ds) {
        this.a.c = ds;
        return this;
    }
    
    public cu$a a(final Map map) {
        this.a.d = map;
        return this;
    }
    
    public cu a() {
        return this.a;
    }
    
    public cu$a b(final int n) {
        this.a.b = n;
        return this;
    }
}
