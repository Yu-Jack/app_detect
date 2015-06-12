// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Collection;
import com.facebook.c.i;
import java.util.ArrayList;
import android.app.Activity;
import org.json.JSONException;
import com.facebook.a.g;
import java.util.HashMap;
import org.json.JSONObject;
import java.util.Map;
import android.content.Context;
import java.util.List;
import java.io.Serializable;
import com.facebook.b.w;
import android.os.Bundle;
import com.facebook.b.ad;
import com.facebook.b.aj;
import android.content.Intent;

final class t extends s
{
    final /* synthetic */ m d;
    private String e;
    
    t(final m d) {
        this.d = d;
        super(d);
    }
    
    @Override
    final String a() {
        return "katana_proxy_auth";
    }
    
    @Override
    final boolean a(final int n, final Intent intent) {
        v v;
        if (intent == null) {
            v = com.facebook.v.a(this.d.h, "Operation canceled");
        }
        else if (n == 0) {
            v = com.facebook.v.a(this.d.h, intent.getStringExtra("error"));
        }
        else if (n != -1) {
            v = com.facebook.v.a(this.d.h, "Unexpected resultCode from authorization.", null);
        }
        else {
            final Bundle extras = intent.getExtras();
            String s = extras.getString("error");
            if (s == null) {
                s = extras.getString("error_type");
            }
            final String string = extras.getString("error_code");
            String s2 = extras.getString("error_message");
            if (s2 == null) {
                s2 = extras.getString("error_description");
            }
            final String string2 = extras.getString("e2e");
            if (!aj.a(string2)) {
                m.a(this.d, this.e, string2);
            }
            if (s == null && string == null && s2 == null) {
                v = com.facebook.v.a(this.d.h, com.facebook.a.a(this.d.h.b(), extras, com.facebook.b.b));
            }
            else if (ad.a.contains(s)) {
                v = null;
            }
            else if (ad.b.contains(s)) {
                v = com.facebook.v.a(this.d.h, (String)null);
            }
            else {
                v = com.facebook.v.a(this.d.h, s, s2, string);
            }
        }
        if (v != null) {
            this.d.a(v);
        }
        else {
            this.d.b();
        }
        return true;
    }
    
    @Override
    final boolean a(final p p) {
        this.e = p.f();
        final String d = i();
        final Intent a = w.a(this.d.c, p.f(), p.b(), d, p.k(), p.e());
        this.a("e2e", d);
        return this.a(a, p.d());
    }
}
