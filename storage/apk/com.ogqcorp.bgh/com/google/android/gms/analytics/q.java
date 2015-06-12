// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

class q
{
    private final Map<String, Integer> a;
    private final Map<String, String> b;
    private final boolean c;
    private final String d;
    
    q(final String d, final boolean c) {
        this.a = new HashMap<String, Integer>();
        this.b = new HashMap<String, String>();
        this.c = c;
        this.d = d;
    }
    
    String a() {
        if (!this.c) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.d);
        for (final String str : this.a.keySet()) {
            sb.append("&").append(str).append("=").append(this.a.get(str));
        }
        for (final String str2 : this.b.keySet()) {
            sb.append("&").append(str2).append("=").append(this.b.get(str2));
        }
        return sb.toString();
    }
    
    void a(final String s, final int n) {
        if (!this.c) {
            return;
        }
        Integer value = this.a.get(s);
        if (value == null) {
            value = 0;
        }
        this.a.put(s, n + value);
    }
}
