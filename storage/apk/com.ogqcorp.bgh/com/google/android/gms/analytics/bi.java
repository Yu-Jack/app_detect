// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.text.TextUtils;

class bi
{
    private String a;
    private final long b;
    private final long c;
    private String d;
    
    bi(final String a, final long b, final long c) {
        this.d = "https:";
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    String a() {
        return this.a;
    }
    
    void a(final String a) {
        this.a = a;
    }
    
    long b() {
        return this.b;
    }
    
    void b(final String s) {
        if (s != null && !TextUtils.isEmpty((CharSequence)s.trim()) && s.toLowerCase().startsWith("http:")) {
            this.d = "http:";
        }
    }
    
    long c() {
        return this.c;
    }
    
    String d() {
        return this.d;
    }
}
