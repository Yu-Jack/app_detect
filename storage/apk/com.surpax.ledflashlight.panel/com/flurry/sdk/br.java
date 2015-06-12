// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest$Builder;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

public final class br extends ba
{
    private static final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final InterstitialAd f;
    private final AdListener g;
    
    static {
        b = br.class.getSimpleName();
    }
    
    public br(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit, final Bundle bundle) {
        super(context, flurryAdModule, e, adUnit);
        this.c = bundle.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
        this.d = bundle.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
        this.e = bundle.getBoolean("com.flurry.gms.ads.test");
        this.g = new br$a(this, null);
        (this.f = new InterstitialAd(this.b())).setAdUnitId(this.c);
        this.f.setAdListener(this.g);
    }
    
    @Override
    public final void a() {
        final AdRequest$Builder adRequest$Builder = new AdRequest$Builder();
        if (this.e) {
            eo.a(3, br.b, "GMS AdView set to Test Mode.");
            adRequest$Builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            if (!TextUtils.isEmpty((CharSequence)this.d)) {
                adRequest$Builder.addTestDevice(this.d);
            }
        }
        this.f.loadAd(adRequest$Builder.build());
    }
}
