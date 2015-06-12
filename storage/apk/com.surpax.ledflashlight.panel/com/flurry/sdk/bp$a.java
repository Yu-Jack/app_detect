// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest$Builder;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.RelativeLayout$LayoutParams;
import com.google.android.gms.ads.AdSize;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.google.android.gms.ads.AdView;
import com.flurry.android.AdNetworkView;
import java.util.Map;
import java.util.Collections;
import com.google.android.gms.ads.AdListener;

final class bp$a extends AdListener
{
    final /* synthetic */ bp a;
    
    private bp$a(final bp a) {
        this.a = a;
    }
    
    @Override
    public final void onAdClosed() {
        this.a.onAdClosed(Collections.emptyMap());
        eo.a(4, bp.a, "GMS AdView onAdClosed.");
    }
    
    @Override
    public final void onAdFailedToLoad(final int i) {
        this.a.onRenderFailed(Collections.emptyMap());
        eo.a(5, bp.a, "GMS AdView onAdFailedToLoad: " + i + ".");
    }
    
    @Override
    public final void onAdLeftApplication() {
        this.a.onAdClicked(Collections.emptyMap());
        eo.a(4, bp.a, "GMS AdView onAdLeftApplication.");
    }
    
    @Override
    public final void onAdLoaded() {
        this.a.onAdShown(Collections.emptyMap());
        eo.a(4, bp.a, "GMS AdView onAdLoaded.");
    }
    
    @Override
    public final void onAdOpened() {
        eo.a(4, bp.a, "GMS AdView onAdOpened.");
    }
}
