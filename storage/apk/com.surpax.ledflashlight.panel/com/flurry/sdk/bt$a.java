// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.graphics.Point;
import com.inmobi.commons.InMobi;
import android.app.Activity;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.flurry.android.AdNetworkView;
import com.inmobi.monetization.IMErrorCode;
import java.util.Collections;
import java.util.Map;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;

final class bt$a implements IMBannerListener
{
    final /* synthetic */ bt a;
    
    private bt$a(final bt a) {
        this.a = a;
    }
    
    @Override
    public final void onBannerInteraction(final IMBanner imBanner, final Map map) {
        this.a.onAdClicked(Collections.emptyMap());
        eo.a(3, bt.a, "InMobi onBannerInteraction");
    }
    
    @Override
    public final void onBannerRequestFailed(final IMBanner imBanner, final IMErrorCode imErrorCode) {
        this.a.onRenderFailed(Collections.emptyMap());
        eo.a(3, bt.a, "InMobi imAdView ad request failed. " + imErrorCode.toString());
    }
    
    @Override
    public final void onBannerRequestSucceeded(final IMBanner imBanner) {
        this.a.onAdShown(Collections.emptyMap());
        eo.a(3, bt.a, "InMobi imAdView ad request completed.");
    }
    
    @Override
    public final void onDismissBannerScreen(final IMBanner imBanner) {
        this.a.onAdClosed(Collections.emptyMap());
        eo.a(3, bt.a, "InMobi imAdView dismiss ad.");
    }
    
    @Override
    public final void onLeaveApplication(final IMBanner imBanner) {
        eo.a(3, bt.a, "InMobi onLeaveApplication");
    }
    
    @Override
    public final void onShowBannerScreen(final IMBanner imBanner) {
        this.a.onAdClicked(Collections.emptyMap());
        eo.a(3, bt.a, "InMobi imAdView ad shown.");
    }
}
