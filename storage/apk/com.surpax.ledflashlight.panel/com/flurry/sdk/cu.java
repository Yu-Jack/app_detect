// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

public class cu
{
    private int a;
    private int b;
    private ds c;
    private Map d;
    private cv e;
    
    public static cu a(final cu cu, final cu cu2) {
        if (cu == null || cu2 == null) {
            return null;
        }
        final ds ds = new ds();
        final ds c = cu.c();
        if (c != null) {
            ds.a(c);
        }
        final ds c2 = cu2.c();
        if (c2 != null) {
            ds.a(c2);
        }
        final HashMap hashMap = new HashMap();
        final Map d = cu.d();
        if (d != null) {
            hashMap.putAll(d);
        }
        final Map d2 = cu2.d();
        if (d2 != null) {
            hashMap.putAll(d2);
        }
        final cu$a cu$a = new cu$a();
        cu$a.a(cu2.a());
        cu$a.b(cu2.b());
        cu$a.a(ds);
        cu$a.a(hashMap);
        cu$a.a(cu2.e());
        return cu$a.a();
    }
    
    public int a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
    
    public ds c() {
        return this.c;
    }
    
    public Map d() {
        return this.d;
    }
    
    public cv e() {
        return this.e;
    }
}
