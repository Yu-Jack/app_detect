// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.view.Display;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.ads.a.x;
import com.facebook.ads.a.q;
import java.util.UUID;
import com.facebook.ads.a.o;
import com.facebook.ads.a.m;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.e;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;

final class j extends BroadcastReceiver
{
    final /* synthetic */ i a;
    
    private j(final i a) {
        this.a = a;
    }
    
    public final void a() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.displayed");
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed");
        intentFilter.addAction("com.facebook.ads.interstitial.clicked");
        e.a(this.a.a).a(this, intentFilter);
    }
    
    public final void b() {
        e.a(this.a.a).a(this);
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if (this.a.e != null && this.a.b.equals(intent.getStringExtra("adInterstitialUniqueId"))) {
            final String action = intent.getAction();
            if ("com.facebook.ads.interstitial.clicked".equals(action)) {
                this.a.e.onAdClicked(this.a);
                return;
            }
            if ("com.facebook.ads.interstitial.dismissed".equals(action)) {
                this.a.e.onInterstitialDismissed(this.a);
                return;
            }
            if ("com.facebook.ads.interstitial.displayed".equals(action)) {
                this.a.e.onInterstitialDisplayed(this.a);
            }
        }
    }
}
