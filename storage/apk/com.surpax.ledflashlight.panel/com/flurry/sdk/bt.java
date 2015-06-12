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
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMBanner;
import com.flurry.android.AdNetworkView;

public final class bt extends AdNetworkView
{
    private static final String a;
    private final String b;
    private IMBanner c;
    private IMBannerListener d;
    
    static {
        a = bt.class.getSimpleName();
    }
    
    bt(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative adCreative, final Bundle bundle) {
        super(context, flurryAdModule, e, adCreative);
        this.b = bundle.getString("com.flurry.inmobi.MY_APP_ID");
        InMobi.initialize((Activity)this.getContext(), this.b);
        this.setFocusable(true);
    }
    
    final IMBannerListener getAdListener() {
        return this.d;
    }
    
    final IMBanner getAdView() {
        return this.c;
    }
    
    @Override
    public final void initLayout() {
        eo.a(3, bt.a, "InMobi initLayout");
        final int width = this.getAdCreative().getWidth();
        final int height = this.getAdCreative().getHeight();
        int h = fc.h();
        int g = fc.g();
        if (width > 0 && width <= g) {
            g = width;
        }
        if (height > 0 && height <= h) {
            h = height;
        }
        final int a = bu.a(new Point(g, h));
        if (-1 != a) {
            this.c = new IMBanner((Activity)this.getContext(), this.b, a);
            int x = 320;
            int y = 50;
            final Point a2 = bu.a(a);
            if (a2 != null) {
                x = a2.x;
                y = a2.y;
            }
            eo.a(3, bt.a, "Determined InMobi AdSize as " + x + "x" + y);
            final float density = fc.c().density;
            this.c.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams((int)(0.5f + density * x), (int)(0.5f + density * y)));
            this.d = new bt$a(this, null);
            this.c.setIMBannerListener(this.d);
            this.setGravity(17);
            this.addView((View)this.c);
            this.c.setRefreshInterval(-1);
            this.c.loadBanner();
            return;
        }
        eo.a(3, bt.a, "Could not find InMobi AdSize that matches size " + width + "x" + height);
        eo.a(3, bt.a, "Could not load InMobi Ad");
    }
    
    @Override
    public final void onDestroy() {
        eo.a(3, bt.a, "InMobi onDestroy");
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
        super.onDestroy();
    }
}
