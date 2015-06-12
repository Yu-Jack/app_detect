// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.view.View;
import com.millennialmedia.android.MMSDK;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.millennialmedia.android.MMAdView;
import com.flurry.android.AdNetworkView;
import com.millennialmedia.android.MMException;
import java.util.Map;
import java.util.Collections;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.RequestListener;

final class bx$a implements RequestListener
{
    final /* synthetic */ bx a;
    
    private bx$a(final bx a) {
        this.a = a;
    }
    
    @Override
    public final void MMAdOverlayClosed(final MMAd mmAd) {
        eo.a(3, bx.a, "Millennial MMAdView banner overlay closed.");
    }
    
    @Override
    public final void MMAdOverlayLaunched(final MMAd mmAd) {
        eo.a(3, bx.a, "Millennial MMAdView banner overlay launched.");
    }
    
    @Override
    public final void MMAdRequestIsCaching(final MMAd mmAd) {
        eo.a(3, bx.a, "Millennial MMAdView banner request is caching.");
    }
    
    @Override
    public final void onSingleTap(final MMAd mmAd) {
        this.a.onAdClicked(Collections.emptyMap());
        eo.a(3, bx.a, "Millennial MMAdView banner tapped.");
    }
    
    @Override
    public final void requestCompleted(final MMAd mmAd) {
        this.a.onAdShown(Collections.emptyMap());
        eo.a(3, bx.a, "Millennial MMAdView returned ad." + System.currentTimeMillis());
    }
    
    @Override
    public final void requestFailed(final MMAd mmAd, final MMException obj) {
        this.a.onRenderFailed(Collections.emptyMap());
        eo.a(3, bx.a, "Millennial MMAdView failed to load ad with error: " + obj);
    }
}
