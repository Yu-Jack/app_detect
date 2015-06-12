// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Collection;
import com.facebook.c.i;
import java.util.ArrayList;
import android.content.Intent;
import android.app.Activity;
import org.json.JSONException;
import com.facebook.a.g;
import java.util.HashMap;
import org.json.JSONObject;
import android.os.Bundle;
import java.util.Map;
import android.content.Context;
import java.util.List;
import java.io.Serializable;

final class m implements Serializable
{
    List a;
    o b;
    transient Context c;
    transient x d;
    transient u e;
    transient q f;
    transient boolean g;
    p h;
    Map i;
    private transient d j;
    
    static Bundle a(final String s) {
        final Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", s);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }
    
    private void a(final String s, final String s2, final String s3, final String s4, final Map map) {
        Bundle bundle;
        if (this.h == null) {
            bundle = a("");
            bundle.putString("2_result", w.c.a());
            bundle.putString("5_error_message", "Unexpected call to logAuthorizationMethodComplete with null pendingRequest.");
        }
        else {
            bundle = a(this.h.j());
            if (s2 != null) {
                bundle.putString("2_result", s2);
            }
            if (s3 != null) {
                bundle.putString("5_error_message", s3);
            }
            if (s4 != null) {
                bundle.putString("4_error_code", s4);
            }
            if (map != null && !map.isEmpty()) {
                bundle.putString("6_extras", new JSONObject(map).toString());
            }
        }
        bundle.putString("3_method", s);
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        this.g().b("fb_mobile_login_method_complete", bundle);
    }
    
    private void a(final String s, String string, final boolean b) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        if (this.i.containsKey(s) && b) {
            string = String.valueOf(this.i.get(s)) + "," + string;
        }
        this.i.put(s, string);
    }
    
    private static Request b(final String s) {
        final Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("access_token", s);
        return new Request(null, "me", bundle, aj.a, null);
    }
    
    static /* synthetic */ void b(final m m) {
        if (m.f != null) {
            m.f.b();
        }
    }
    
    private boolean e() {
        if (this.g) {
            return true;
        }
        if (this.c.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            this.b(v.a(this.h, this.c.getString(com.facebook.a.g.b), this.c.getString(com.facebook.a.g.a)));
            return false;
        }
        return this.g = true;
    }
    
    private boolean f() {
        if (this.b.c() && !this.e()) {
            this.a("no_internet_permission", "1", false);
            return false;
        }
        final boolean a = this.b.a(this.h);
        if (a) {
            final String a2 = this.b.a();
            final Bundle a3 = a(this.h.j());
            a3.putLong("1_timestamp_ms", System.currentTimeMillis());
            a3.putString("3_method", a2);
            this.g().b("fb_mobile_login_method_start", a3);
            return a;
        }
        this.a("not_tried", this.b.a(), true);
        return a;
    }
    
    private d g() {
        if (this.j == null || !this.j.b().equals(this.h.f())) {
            this.j = com.facebook.d.a(this.c, this.h.f());
        }
        return this.j;
    }
    
    private void h() {
        if (this.f != null) {
            this.f.a();
        }
    }
    
    private static String i() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("init", System.currentTimeMillis());
            return jsonObject.toString();
        }
        catch (JSONException ex) {
            return jsonObject.toString();
        }
    }
    
    final void a() {
        if (this.b != null) {
            this.b.d();
        }
    }
    
    final void a(final Activity c) {
        this.c = (Context)c;
        this.d = new x() {
            @Override
            public final Activity a() {
                return c;
            }
            
            @Override
            public final void a(final Intent intent, final int n) {
                c.startActivityForResult(intent, n);
            }
        };
    }
    
    final void a(final p h) {
        int n;
        if (this.h != null && this.b != null) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            if (this.h == null || this.b == null) {
                throw new ab("Attempted to continue authorization without a pending request.");
            }
            if (this.b.b()) {
                this.b.d();
                this.f();
            }
        }
        else if (h != null) {
            if (this.h != null) {
                throw new ab("Attempted to authorize while a request is pending.");
            }
            if (!h.i() || this.e()) {
                this.h = h;
                final ArrayList<r> a = new ArrayList<r>();
                final bn c = h.c();
                if (c.a()) {
                    if (!h.g()) {
                        a.add(new r(this));
                    }
                    a.add((r)new t(this));
                }
                if (c.b()) {
                    a.add((r)new y(this));
                }
                this.a = a;
                this.b();
            }
        }
    }
    
    final void a(final q f) {
        this.f = f;
    }
    
    final void a(final u e) {
        this.e = e;
    }
    
    final void a(final v v) {
        if (v.b == null || !this.h.i()) {
            this.b(v);
            return;
        }
        if (v.b == null) {
            throw new ab("Can't validate without a token");
        }
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final String a = v.b.a();
        final aq aq = new aq() {
            @Override
            public final void a(final bb bb) {
                try {
                    final i i = (i)bb.a(i.class);
                    if (i != null) {
                        list.add(i.a());
                    }
                }
                catch (Exception ex) {}
            }
        };
        final String h = this.h.h();
        final Request b = b(h);
        b.a(aq);
        final Request b2 = b(a);
        b2.a(aq);
        final Bundle bundle = new Bundle();
        bundle.putString("access_token", h);
        final Request request = new Request(null, "me/permissions", bundle, aj.a, null);
        request.a(new aq() {
            @Override
            public final void a(final bb bb) {
                try {
                    final bh a = bc.a(bb);
                    if (a != null) {
                        list2.addAll(a.a);
                        list3.addAll(a.b);
                    }
                }
                catch (Exception ex) {}
            }
        });
        final aw aw = new aw(new Request[] { b, b2, request });
        aw.a(this.h.f());
        aw.a(new ax() {
            @Override
            public final void a() {
                try {
                    v v;
                    if (list.size() == 2 && list.get(0) != null && list.get(1) != null && list.get(0).equals(list.get(1))) {
                        v = com.facebook.v.a(m.this.h, com.facebook.a.a(v.b, list2, list3));
                    }
                    else {
                        v = com.facebook.v.a(m.this.h, "User logged in as different Facebook user.", null);
                    }
                    m.this.b(v);
                }
                catch (Exception ex) {
                    m.this.b(v.a(m.this.h, "Caught exception", ex.getMessage()));
                }
                finally {
                    m.b(m.this);
                }
            }
        });
        this.h();
        aw.h();
    }
    
    final boolean a(final int n, final int n2, final Intent intent) {
        return n == this.h.d() && this.b.a(n2, intent);
    }
    
    final void b() {
        if (this.b != null) {
            this.a(this.b.a(), "skipped", null, null, this.b.a);
        }
        while (this.a != null && !this.a.isEmpty()) {
            this.b = this.a.remove(0);
            if (this.f()) {
                return;
            }
        }
        if (this.h != null) {
            this.b(v.a(this.h, "Login attempt failed.", null));
        }
    }
    
    final void b(final v v) {
        if (this.b != null) {
            this.a(this.b.a(), v.a.a(), v.c, v.d, this.b.a);
        }
        if (this.i != null) {
            v.f = this.i;
        }
        this.a = null;
        this.b = null;
        this.h = null;
        this.i = null;
        if (this.e != null) {
            this.e.a(v);
        }
    }
    
    final x c() {
        if (this.d != null) {
            return this.d;
        }
        if (this.h != null) {
            return new x() {
                @Override
                public final Activity a() {
                    return m.this.h.a().a();
                }
                
                @Override
                public final void a(final Intent intent, final int n) {
                    m.this.h.a().a(intent, n);
                }
            };
        }
        return null;
    }
}
