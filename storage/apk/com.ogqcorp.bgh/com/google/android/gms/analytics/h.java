// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class h<T extends h>
{
    private Map<String, String> a;
    
    protected h() {
        this.a = new HashMap<String, String>();
    }
    
    public final T a(final String s, final String s2) {
        bd.a().a(be.a);
        if (s != null) {
            this.a.put(s, s2);
            return (T)this;
        }
        p.d(" HitBuilder.set() called with a null paramName.");
        return (T)this;
    }
    
    public Map<String, String> a() {
        return this.a;
    }
    
    public T d(final String s) {
        bd.a().a(be.d);
        final String b = ab.b(s);
        if (TextUtils.isEmpty((CharSequence)b)) {
            return (T)this;
        }
        final Map<String, String> a = ab.a(b);
        this.a("&cc", a.get("utm_content"));
        this.a("&cm", a.get("utm_medium"));
        this.a("&cn", a.get("utm_campaign"));
        this.a("&cs", a.get("utm_source"));
        this.a("&ck", a.get("utm_term"));
        this.a("&ci", a.get("utm_id"));
        this.a("&gclid", a.get("gclid"));
        this.a("&dclid", a.get("dclid"));
        this.a("&gmob_t", a.get("gmob_t"));
        return (T)this;
    }
}
