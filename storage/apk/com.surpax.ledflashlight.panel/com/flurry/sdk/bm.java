// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.facebook.ads.b;
import java.util.Map;
import java.util.Collections;
import com.facebook.ads.a;
import com.facebook.ads.d;
import android.view.View;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.facebook.ads.f;
import com.facebook.ads.c;
import com.flurry.android.AdNetworkView;

public class bm extends AdNetworkView implements c
{
    private static final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private f e;
    
    static {
        a = bm.class.getSimpleName();
    }
    
    public bm(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative adCreative, final Bundle bundle) {
        super(context, flurryAdModule, e, adCreative);
        this.b = bundle.getString("com.flurry.fan.MY_APP_ID");
        this.c = bundle.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
        this.d = bundle.getBoolean("com.flurry.fan.test");
        this.setFocusable(true);
    }
    
    @Override
    public void initLayout() {
        eo.a(4, bm.a, "FAN banner initLayout.");
        (this.e = new f(this.getContext(), this.b, com.facebook.ads.e.a)).a(this);
        this.addView((View)this.e);
        if (this.d) {
            com.facebook.ads.d.a(this.c);
        }
        this.e.a();
    }
    
    @Override
    public void onAdClicked(final a a) {
        eo.a(4, bm.a, "FAN banner onAdClicked.");
        this.onAdClicked(Collections.emptyMap());
    }
    
    @Override
    public void onAdLoaded(final a a) {
        this.onAdShown(Collections.emptyMap());
        eo.a(4, bm.a, "FAN banner onAdLoaded.");
    }
    
    @Override
    public void onDestroy() {
        eo.a(4, bm.a, "FAN banner onDestroy.");
        if (this.e != null) {
            this.e.b();
            this.e = null;
        }
        super.onDestroy();
    }
    
    @Override
    public void onError(final a a, final b b) {
        this.onRenderFailed(Collections.emptyMap());
        if (this.e != null) {
            this.e.b();
            this.e = null;
        }
        eo.a(6, bm.a, "FAN banner onError.");
    }
}
