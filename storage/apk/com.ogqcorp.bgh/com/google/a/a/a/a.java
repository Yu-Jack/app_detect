// 
// Decompiled by Procyon v0.5.29
// 

package com.google.a.a.a;

import android.view.View;
import com.google.android.gms.ads.c.d;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
import android.text.TextUtils;
import com.google.android.gms.internal.em;
import com.google.android.gms.ads.b;
import android.os.Bundle;
import com.google.android.gms.ads.c.a;
import android.content.Context;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.c.e;
import com.google.android.gms.ads.c.c;

public final class a implements c, e
{
    private com.google.android.gms.ads.e a;
    private f b;
    
    private static com.google.android.gms.ads.b a(final Context context, final com.google.android.gms.ads.c.a a, Bundle bundle, final Bundle bundle2) {
        final com.google.android.gms.ads.c c = new com.google.android.gms.ads.c();
        final Date a2 = a.a();
        if (a2 != null) {
            c.a(a2);
        }
        final int b = a.b();
        if (b != 0) {
            c.a(b);
        }
        final Set<String> c2 = a.c();
        if (c2 != null) {
            final Iterator<String> iterator = c2.iterator();
            while (iterator.hasNext()) {
                c.a(iterator.next());
            }
        }
        if (a.d()) {
            c.b(em.a(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            c.a(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty((CharSequence)bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        c.a(a.class, bundle);
        return c.a();
    }
    
    @Override
    public void a() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }
    
    @Override
    public void a(final Context context, final d d, final Bundle bundle, final com.google.android.gms.ads.d d2, final com.google.android.gms.ads.c.a a, final Bundle bundle2) {
        (this.a = new com.google.android.gms.ads.e(context)).setAdSize(new com.google.android.gms.ads.d(d2.b(), d2.a()));
        this.a.setAdUnitId(bundle.getString("pubid"));
        this.a.setAdListener(new com.google.a.a.a.b(this, d));
        this.a.a(a(context, a, bundle2, bundle));
    }
    
    @Override
    public void a(final Context context, final com.google.android.gms.ads.c.f f, final Bundle bundle, final com.google.android.gms.ads.c.a a, final Bundle bundle2) {
        (this.b = new f(context)).a(bundle.getString("pubid"));
        this.b.a(new com.google.a.a.a.c(this, f));
        this.b.a(a(context, a, bundle2, bundle));
    }
    
    @Override
    public void b() {
        if (this.a != null) {
            this.a.b();
        }
    }
    
    @Override
    public void c() {
        if (this.a != null) {
            this.a.c();
        }
    }
    
    @Override
    public View d() {
        return (View)this.a;
    }
    
    @Override
    public void e() {
        this.b.a();
    }
}
