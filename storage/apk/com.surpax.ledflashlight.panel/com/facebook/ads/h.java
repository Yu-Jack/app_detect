// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.content.res.Configuration;
import android.content.IntentFilter;
import com.facebook.ads.a.x;
import com.facebook.ads.a.o;
import com.facebook.ads.a.l;
import com.facebook.ads.a.q;
import android.view.View;
import android.webkit.WebViewClient;
import com.facebook.ads.a.u;
import com.facebook.ads.a.t;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.util.DisplayMetrics;
import com.facebook.ads.a.y;
import com.facebook.ads.a.m;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class h extends BroadcastReceiver
{
    final /* synthetic */ f a;
    
    private h(final f a) {
        this.a = a;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.a.h.c();
            return;
        }
        this.a.h.b();
    }
}
