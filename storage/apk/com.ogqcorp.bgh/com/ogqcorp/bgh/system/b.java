// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.animation.AnimationUtils;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.c;
import com.ogqcorp.commons.w;
import android.view.View;
import com.google.android.gms.ads.d;
import android.content.Context;
import com.google.android.gms.ads.e;
import android.view.ViewGroup;
import android.app.Activity;

public final class b
{
    private static final b a;
    
    static {
        a = new b();
    }
    
    public static b a() {
        return b.a;
    }
    
    public void a(final Activity activity, final int n) {
        final ViewGroup viewGroup = (ViewGroup)activity.findViewById(n);
        final e e = new e((Context)activity);
        e.setAdSize(d.a);
        e.setAdUnitId("ca-app-pub-4867084765925572/2215535249");
        e.setTag((Object)b.a);
        viewGroup.addView((View)e, -1, -2);
        final w a = new w(activity).a(2131099752);
        int n2;
        if (h.a().c()) {
            n2 = 0;
        }
        else {
            n2 = 8;
        }
        a.b(n2);
        e.a(new c().b(com.google.android.gms.ads.b.a).a());
    }
    
    public void b(final Activity activity, final int n) {
        final e e = (e)((ViewGroup)activity.findViewById(n)).findViewWithTag((Object)b.a);
        if (e != null) {
            e.setAnimation(AnimationUtils.loadAnimation((Context)activity, 17432576));
            e.setVisibility(0);
            e.c();
        }
    }
    
    public void c(final Activity activity, final int n) {
        final e e = (e)((ViewGroup)activity.findViewById(n)).findViewWithTag((Object)b.a);
        if (e != null) {
            e.setAnimation(AnimationUtils.loadAnimation((Context)activity, 17432577));
            e.setVisibility(8);
            e.b();
        }
    }
    
    public void d(final Activity activity, final int n) {
        final e e = (e)((ViewGroup)activity.findViewById(n)).findViewWithTag((Object)b.a);
        if (e != null) {
            e.a();
        }
    }
}
