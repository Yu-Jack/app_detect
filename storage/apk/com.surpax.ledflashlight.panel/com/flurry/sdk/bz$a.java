// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.app.Activity;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMException;
import java.util.Map;
import java.util.Collections;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.RequestListener;

final class bz$a implements RequestListener
{
    final /* synthetic */ bz a;
    
    private bz$a(final bz a) {
        this.a = a;
    }
    
    @Override
    public final void MMAdOverlayClosed(final MMAd mmAd) {
        this.a.c(Collections.emptyMap());
        eo.a(3, bz.b, "Millennial MMAdView Interstitial overlay closed.");
    }
    
    @Override
    public final void MMAdOverlayLaunched(final MMAd mmAd) {
        this.a.a(Collections.emptyMap());
        eo.a(3, bz.b, "Millennial MMAdView Interstitial overlay launched." + System.currentTimeMillis());
    }
    
    @Override
    public final void MMAdRequestIsCaching(final MMAd mmAd) {
        eo.a(3, bz.b, "Millennial MMAdView Interstitial request is caching.");
    }
    
    @Override
    public final void onSingleTap(final MMAd mmAd) {
        this.a.b(Collections.emptyMap());
        eo.a(3, bz.b, "Millennial MMAdView Interstitial tapped.");
    }
    
    @Override
    public final void requestCompleted(final MMAd mmAd) {
        eo.a(3, bz.b, "Millennial MMAdView returned interstitial ad: " + System.currentTimeMillis());
        if (!this.a.c) {
            this.a.e.display();
        }
    }
    
    @Override
    public final void requestFailed(final MMAd mmAd, final MMException ex) {
        this.a.d(Collections.emptyMap());
        eo.a(3, bz.b, "Millennial MMAdView Interstitial failed to load ad.");
    }
}
