// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.app.Activity;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.millennialmedia.android.RequestListener;
import com.millennialmedia.android.MMInterstitial;

public final class bz extends ba
{
    private static final String b;
    private boolean c;
    private final String d;
    private MMInterstitial e;
    private RequestListener f;
    
    static {
        b = bz.class.getSimpleName();
    }
    
    public bz(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit, final Bundle bundle) {
        super(context, flurryAdModule, e, adUnit);
        this.d = bundle.getString("com.flurry.millennial.MYAPIDINTERSTITIAL");
    }
    
    @Override
    public final void a() {
        (this.e = new MMInterstitial(this.b())).setApid(this.d);
        this.f = new bz$a(this, null);
        this.e.setListener(this.f);
        this.e.fetch();
        this.c = this.e.display();
        if (this.c) {
            eo.a(3, bz.b, "Millennial MMAdView Interstitial ad displayed immediately:" + System.currentTimeMillis() + " " + this.c);
            return;
        }
        eo.a(3, bz.b, "Millennial MMAdView Interstitial ad did not display immediately:" + System.currentTimeMillis() + " " + this.c);
    }
}
