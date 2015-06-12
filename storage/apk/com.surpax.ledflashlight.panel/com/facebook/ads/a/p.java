// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import org.json.JSONArray;

enum p
{
    a("APP_AD", 0, 0), 
    b("LINK_AD", 1, 1), 
    c("APP_AD_V2", 2, 2), 
    d("LINK_AD_V2", 3, 3), 
    e("APP_ENGAGEMENT_AD", 4, 4), 
    f("AD_CHOICES", 5, 5), 
    g("JS_TRIGGER", 6, 6), 
    h("JS_TRIGGER_NO_AUTO_IMP_LOGGING", 7, 7);
    
    private static final p[] j;
    private static final String k;
    private final int i;
    
    static {
        int i = 0;
        j = new p[] { p.d, p.e, p.f, p.h };
        final JSONArray jsonArray = new JSONArray();
        for (p[] m = p.j; i < m.length; ++i) {
            jsonArray.put(m[i].i);
        }
        k = jsonArray.toString();
    }
    
    private p(final String name, final int ordinal, final int i) {
        this.i = i;
    }
    
    public static String a() {
        return p.k;
    }
}
