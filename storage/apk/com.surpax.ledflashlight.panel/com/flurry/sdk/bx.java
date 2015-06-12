// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.Utils$ThreadUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import com.millennialmedia.android.MMAdView$BannerBounds;
import android.graphics.Bitmap;
import com.millennialmedia.android.DTOResizeParameters;
import com.millennialmedia.android.MMRequest;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.ImageView$ScaleType;
import android.view.ViewParent;
import android.view.Window;
import android.view.ViewGroup;
import android.text.TextUtils;
import com.millennialmedia.android.MMLog;
import android.util.AttributeSet;
import com.millennialmedia.android.MMAdView$MMAdViewMMAdImpl;
import com.millennialmedia.android.MMAdView$ResizeView;
import android.widget.ImageView;
import android.view.animation.Animation$AnimationListener;
import android.view.View$OnClickListener;
import com.millennialmedia.android.MMLayout;
import android.view.View;
import com.millennialmedia.android.MMSDK;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.millennialmedia.android.RequestListener;
import com.millennialmedia.android.MMAdView;
import com.flurry.android.AdNetworkView;

public final class bx extends AdNetworkView
{
    private static final String a;
    private final String b;
    private final String c;
    private MMAdView d;
    private RequestListener e;
    
    static {
        a = bx.class.getSimpleName();
    }
    
    public bx(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative adCreative, final Bundle bundle) {
        super(context, flurryAdModule, e, adCreative);
        this.b = bundle.getString("com.flurry.millennial.MYAPID");
        this.c = bundle.getString("com.flurry.millennial.MYAPIDRECTANGLE");
        this.setFocusable(true);
    }
    
    final RequestListener getAdListener() {
        return this.e;
    }
    
    final MMAdView getAdView() {
        return this.d;
    }
    
    @Override
    public final void initLayout() {
        eo.a(3, bx.a, "Millennial initLayout");
        final int width = this.getAdCreative().getWidth();
        final int height = this.getAdCreative().getHeight();
        final int a = by.a(new Point(width, height));
        if (-1 == a) {
            eo.a(3, bx.a, "Could not find Millennial AdSize that matches size " + width + "x" + height);
            eo.a(3, bx.a, "Could not load Millennial Ad");
            return;
        }
        final Point a2 = by.a(a);
        if (a2 == null) {
            eo.a(3, bx.a, "Could not find Millennial AdSize that matches size " + width + "x" + height);
            eo.a(3, bx.a, "Could not load Millennial Ad");
            return;
        }
        final int x = a2.x;
        final int y = a2.y;
        eo.a(3, bx.a, "Determined Millennial AdSize as " + x + "x" + y);
        this.d = new MMAdView(this.getContext());
        this.setId(MMSDK.getDefaultAdId());
        this.d.setApid(this.b);
        if (2 == a) {
            this.d.setApid(this.c);
        }
        this.d.setWidth(x);
        this.d.setHeight(y);
        this.setHorizontalScrollBarEnabled(false);
        this.setVerticalScrollBarEnabled(false);
        this.setGravity(17);
        this.e = new bx$a(this, null);
        this.d.setListener(this.e);
        this.addView((View)this.d);
        this.d.getAd();
    }
    
    @Override
    public final void onDestroy() {
        eo.a(3, bx.a, "Millennial onDestroy");
        if (this.d != null) {
            this.d = null;
        }
        super.onDestroy();
    }
}
