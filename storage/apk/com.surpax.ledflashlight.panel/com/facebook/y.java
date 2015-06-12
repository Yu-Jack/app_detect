// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import com.facebook.c.i;
import java.util.ArrayList;
import android.content.Intent;
import android.app.Activity;
import org.json.JSONException;
import com.facebook.a.g;
import java.util.HashMap;
import org.json.JSONObject;
import java.util.Map;
import java.util.List;
import java.io.Serializable;
import android.content.Context;
import com.facebook.widget.l;
import android.text.TextUtils;
import java.util.Collection;
import android.content.SharedPreferences$Editor;
import com.facebook.b.aj;
import android.webkit.CookieSyncManager;
import android.os.Bundle;
import com.facebook.widget.k;

final class y extends o
{
    final /* synthetic */ m c;
    private transient k d;
    private String e;
    private String f;
    
    y(final m c) {
        this.c = c;
        super(c);
    }
    
    @Override
    final String a() {
        return "web_view";
    }
    
    final void a(final p p3, final Bundle bundle, final ab ab) {
        v v;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f = bundle.getString("e2e");
            }
            final a a = com.facebook.a.a(p3.b(), bundle, com.facebook.b.e);
            v = com.facebook.v.a(this.c.h, a);
            CookieSyncManager.createInstance(this.c.c).sync();
            final String a2 = a.a();
            final SharedPreferences$Editor edit = ((Context)this.c.c().a()).getSharedPreferences("com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit();
            edit.putString("TOKEN", a2);
            if (!edit.commit()) {
                aj.a("Facebook-AuthorizationClient", "Could not update saved web view auth handler token.");
            }
        }
        else if (ab instanceof ad) {
            v = com.facebook.v.a(this.c.h, "User canceled log in.");
        }
        else {
            this.f = null;
            final String message = ab.getMessage();
            String format;
            String string;
            if (ab instanceof ah) {
                final ae a3 = ((ah)ab).a();
                format = String.format("%d", a3.b());
                string = a3.toString();
            }
            else {
                string = message;
                format = null;
            }
            v = com.facebook.v.a(this.c.h, null, string, format);
        }
        if (!aj.a(this.f)) {
            m.a(this.c, this.e, this.f);
        }
        this.c.a(v);
    }
    
    @Override
    final boolean a(final p p) {
        this.e = p.f();
        final Bundle bundle = new Bundle();
        if (!aj.a(p.b())) {
            final String join = TextUtils.join((CharSequence)",", (Iterable)p.b());
            bundle.putString("scope", join);
            this.a("scope", join);
        }
        bundle.putString("default_audience", p.e().a());
        final String h = p.h();
        if (!aj.a(h) && h.equals(((Context)this.c.c().a()).getSharedPreferences("com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", ""))) {
            bundle.putString("access_token", h);
            this.a("access_token", "1");
        }
        else {
            aj.b(this.c.c);
            this.a("access_token", "0");
        }
        final com.facebook.widget.o o = new com.facebook.widget.o() {
            @Override
            public final void a(final Bundle bundle, final ab ab) {
                y.this.a(p, bundle, ab);
            }
        };
        this.a("e2e", this.f = i());
        (this.d = ((l)new n((Context)this.c.c().a(), this.e, bundle).a(this.f).a(p.k()).a(o)).a()).show();
        return true;
    }
    
    @Override
    final boolean b() {
        return true;
    }
    
    @Override
    final boolean c() {
        return true;
    }
    
    @Override
    final void d() {
        if (this.d != null) {
            this.d.dismiss();
            this.d = null;
        }
    }
}
