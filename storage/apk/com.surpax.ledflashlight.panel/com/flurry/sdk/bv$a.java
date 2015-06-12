// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.inmobi.commons.InMobi;
import android.app.Activity;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import java.lang.reflect.Method;
import com.inmobi.monetization.IMInterstitial$State;
import com.inmobi.monetization.IMErrorCode;
import java.util.Map;
import java.util.Collections;
import com.inmobi.monetization.IMInterstitial;
import com.inmobi.monetization.IMInterstitialListener;

final class bv$a implements IMInterstitialListener
{
    final /* synthetic */ bv a;
    
    private bv$a(final bv a) {
        this.a = a;
    }
    
    @Override
    public final void onDismissInterstitialScreen(final IMInterstitial imInterstitial) {
        this.a.c(Collections.emptyMap());
        eo.a(3, bv.b, "InMobi Interstitial ad dismissed.");
    }
    
    @Override
    public final void onInterstitialFailed(final IMInterstitial imInterstitial, final IMErrorCode imErrorCode) {
        this.a.d(Collections.emptyMap());
        eo.a(3, bv.b, "InMobi imAdView ad request failed. ErrorCode  = " + imErrorCode.toString());
    }
    
    @Override
    public final void onInterstitialInteraction(final IMInterstitial imInterstitial, final Map map) {
        this.a.b(Collections.emptyMap());
        eo.a(3, bv.b, "InMobi onBannerInteraction");
    }
    
    @Override
    public final void onInterstitialLoaded(final IMInterstitial imInterstitial) {
        eo.a(3, bv.b, "InMobi Interstitial ad request completed.");
        if (IMInterstitial$State.READY.equals(imInterstitial.getState())) {
            this.a.a(Collections.emptyMap());
            imInterstitial.show();
        }
    }
    
    @Override
    public final void onLeaveApplication(final IMInterstitial imInterstitial) {
        this.a.b(Collections.emptyMap());
        eo.a(3, bv.b, "InMobi onLeaveApplication");
    }
    
    @Override
    public final void onShowInterstitialScreen(final IMInterstitial imInterstitial) {
        eo.a(3, bv.b, "InMobi Interstitial ad shown.");
    }
}
