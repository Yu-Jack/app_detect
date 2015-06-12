// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class aa implements an
{
    String a;
    double b;
    int c;
    int d;
    int e;
    int f;
    Map<String, String> g;
    
    aa() {
        this.b = -1.0;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = new HashMap<String, String>();
    }
    
    public String a(final Activity activity) {
        return this.a(activity.getClass().getCanonicalName());
    }
    
    public String a(final String s) {
        final String s2 = this.g.get(s);
        if (s2 != null) {
            return s2;
        }
        return s;
    }
    
    public boolean a() {
        return this.a != null;
    }
    
    public String b() {
        return this.a;
    }
    
    public boolean c() {
        return this.b >= 0.0;
    }
    
    public double d() {
        return this.b;
    }
    
    public boolean e() {
        return this.c >= 0;
    }
    
    public int f() {
        return this.c;
    }
    
    public boolean g() {
        return this.d != -1;
    }
    
    public boolean h() {
        return this.d == 1;
    }
    
    public boolean i() {
        return this.e != -1;
    }
    
    public boolean j() {
        return this.e == 1;
    }
    
    public boolean k() {
        return this.f == 1;
    }
}
