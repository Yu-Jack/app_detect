// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONObject;

public final class lp
{
    private final String a;
    private final JSONObject b;
    private final String c;
    private final String d;
    
    public lp(final String c, final dx dx, final String a, final JSONObject b) {
        this.d = dx.b;
        this.b = b;
        this.c = c;
        this.a = a;
    }
    
    public String a() {
        return this.a;
    }
    
    public String b() {
        return this.d;
    }
    
    public JSONObject c() {
        return this.b;
    }
    
    public String d() {
        return this.c;
    }
}
