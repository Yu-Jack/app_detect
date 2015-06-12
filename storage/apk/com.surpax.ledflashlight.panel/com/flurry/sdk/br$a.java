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
import com.google.android.gms.ads.InterstitialAd;
import java.util.Map;
import java.util.Collections;
import com.google.android.gms.ads.AdListener;

final class br$a extends AdListener
{
    final /* synthetic */ br a;
    
    private br$a(final br a) {
        this.a = a;
    }
    
    @Override
    public final void onAdClosed() {
        this.a.c(Collections.emptyMap());
        eo.a(4, br.b, "GMS AdView onAdClosed.");
    }
    
    @Override
    public final void onAdFailedToLoad(final int i) {
        this.a.d(Collections.emptyMap());
        eo.a(5, br.b, "GMS AdView onAdFailedToLoad: " + i + ".");
    }
    
    @Override
    public final void onAdLeftApplication() {
        this.a.b(Collections.emptyMap());
        eo.a(4, br.b, "GMS AdView onAdLeftApplication.");
    }
    
    @Override
    public final void onAdLoaded() {
        this.a.a(Collections.emptyMap());
        eo.a(4, br.b, "GMS AdView onAdLoaded.");
        this.a.f.show();
    }
    
    @Override
    public final void onAdOpened() {
        eo.a(4, br.b, "GMS AdView onAdOpened.");
    }
}
