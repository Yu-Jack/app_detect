// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import com.facebook.c.i;
import android.content.Intent;
import android.app.Activity;
import org.json.JSONException;
import com.facebook.a.g;
import java.util.HashMap;
import org.json.JSONObject;
import java.util.Map;
import android.content.Context;
import java.io.Serializable;
import com.facebook.b.ac;
import java.util.Iterator;
import java.util.List;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import android.os.Bundle;

final class r extends o
{
    final /* synthetic */ m c;
    private transient ai d;
    
    r(final m c) {
        this.c = c;
        super(c);
    }
    
    @Override
    final String a() {
        return "get_token";
    }
    
    final void a(final p p2, final Bundle bundle) {
        this.d = null;
        m.b(this.c);
        if (bundle != null) {
            final ArrayList stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            final List b = p2.b();
            if (stringArrayList != null && (b == null || stringArrayList.containsAll(b))) {
                this.c.a(v.a(this.c.h, com.facebook.a.a(bundle, com.facebook.b.d)));
                return;
            }
            final ArrayList<String> list = new ArrayList<String>();
            for (final String o : b) {
                if (!stringArrayList.contains(o)) {
                    list.add(o);
                }
            }
            if (!list.isEmpty()) {
                this.a("new_permissions", TextUtils.join((CharSequence)",", (Iterable)list));
            }
            p2.a(list);
        }
        this.c.b();
    }
    
    @Override
    final boolean a(final p p) {
        this.d = new ai(this.c.c, p.f());
        if (!this.d.a()) {
            return false;
        }
        this.c.h();
        this.d.a(new ac() {
            @Override
            public final void a(final Bundle bundle) {
                r.this.a(p, bundle);
            }
        });
        return true;
    }
    
    @Override
    final boolean b() {
        return this.d == null;
    }
    
    @Override
    final void d() {
        if (this.d != null) {
            this.d.b();
            this.d = null;
        }
    }
}
