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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.flurry.android.AdNetworkView;

public final class bp extends AdNetworkView
{
    private static final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private AdView e;
    private AdListener f;
    
    static {
        a = bp.class.getSimpleName();
    }
    
    public bp(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative adCreative, final Bundle bundle) {
        super(context, flurryAdModule, e, adCreative);
        this.b = bundle.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
        this.c = bundle.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
        this.d = bundle.getBoolean("com.flurry.gms.ads.test");
        this.setFocusable(true);
    }
    
    private AdSize a(final int n, final int n2) {
        if (n >= 728 && n2 >= 90) {
            return AdSize.LEADERBOARD;
        }
        if (n >= 468 && n2 >= 60) {
            return AdSize.FULL_BANNER;
        }
        if (n >= 320 && n2 >= 50) {
            return AdSize.BANNER;
        }
        if (n >= 300 && n2 >= 250) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        eo.a(3, bp.a, "Could not find GMS AdSize that matches size");
        return null;
    }
    
    private AdSize a(final Context context, int n, int n2) {
        final int h = fc.h();
        final int g = fc.g();
        if (n <= 0 || n > g) {
            n = g;
        }
        if (n2 <= 0 || n2 > h) {
            n2 = h;
        }
        return this.a(n, n2);
    }
    
    final AdListener getAdListener() {
        return this.f;
    }
    
    final AdView getAdView() {
        return this.e;
    }
    
    @Override
    public final void initLayout() {
        eo.a(4, bp.a, "GMS AdView initLayout.");
        final Context context = this.getContext();
        final int width = this.getAdCreative().getWidth();
        final int height = this.getAdCreative().getHeight();
        final AdSize a = this.a(context, width, height);
        if (a == null) {
            eo.a(6, bp.a, "Could not find GMS AdSize that matches {width = " + width + ", height " + height + "}");
            return;
        }
        eo.a(3, bp.a, "Determined GMS AdSize as " + a + " that best matches {width = " + width + ", height = " + height + "}");
        this.f = new bp$a(this, null);
        (this.e = new AdView(context)).setAdSize(a);
        this.e.setAdUnitId(this.b);
        this.e.setAdListener(this.f);
        this.setGravity(17);
        this.addView((View)this.e, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(a.getWidthInPixels(context), a.getHeightInPixels(context)));
        final AdRequest$Builder adRequest$Builder = new AdRequest$Builder();
        if (this.d) {
            eo.a(3, bp.a, "GMS AdView set to Test Mode.");
            adRequest$Builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            if (!TextUtils.isEmpty((CharSequence)this.c)) {
                adRequest$Builder.addTestDevice(this.c);
            }
        }
        this.e.loadAd(adRequest$Builder.build());
    }
    
    @Override
    public final void onDestroy() {
        eo.a(4, bp.a, "GMS AdView onDestroy.");
        if (this.e != null) {
            this.e.destroy();
            this.e = null;
        }
        super.onDestroy();
    }
}
