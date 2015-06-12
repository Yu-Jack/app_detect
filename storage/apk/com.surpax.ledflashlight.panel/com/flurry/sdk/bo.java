// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.facebook.ads.b;
import java.util.Map;
import java.util.Collections;
import com.facebook.ads.a;
import com.facebook.ads.d;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.facebook.ads.i;
import com.facebook.ads.l;

public class bo extends ba implements l
{
    private static final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private i f;
    
    static {
        b = bo.class.getSimpleName();
    }
    
    public bo(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit, final Bundle bundle) {
        super(context, flurryAdModule, e, adUnit);
        this.c = bundle.getString("com.flurry.fan.MY_APP_ID");
        this.d = bundle.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
        this.e = bundle.getBoolean("com.flurry.fan.test");
    }
    
    @Override
    public void a() {
        final Context b = this.b();
        if (this.e) {
            com.facebook.ads.d.a(this.d);
        }
        (this.f = new i(b, this.c)).a(this);
        this.f.a();
    }
    
    @Override
    public void onAdClicked(final a a) {
        eo.a(4, bo.b, "FAN interstitial onAdClicked.");
        this.b(Collections.emptyMap());
    }
    
    @Override
    public void onAdLoaded(final a a) {
        eo.a(4, bo.b, "FAN interstitial onAdLoaded.");
        if (this.f != null && this.f.c()) {
            this.f.d();
        }
    }
    
    @Override
    public void onError(final a a, final b b) {
        eo.a(4, bo.b, "FAN interstitial onError.");
        this.d(Collections.emptyMap());
        this.f.b();
        this.f = null;
    }
    
    @Override
    public void onInterstitialDismissed(final a a) {
        eo.a(4, bo.b, "FAN interstitial onInterstitialDismissed.");
        this.c(Collections.emptyMap());
    }
    
    @Override
    public void onInterstitialDisplayed(final a a) {
        eo.a(4, bo.b, "FAN interstitial onInterstitialDisplayed.");
        this.a(Collections.emptyMap());
    }
}
