// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.content.res.Configuration;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.facebook.ads.a.g;
import com.facebook.ads.a.o;
import com.facebook.ads.a.l;
import com.facebook.ads.a.q;
import android.view.View;
import com.facebook.ads.a.u;
import com.facebook.ads.a.t;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.ads.a.y;
import com.facebook.ads.a.m;
import android.widget.RelativeLayout;
import java.util.Map;
import android.util.Log;
import java.util.UUID;
import com.facebook.ads.a.x;
import com.facebook.ads.a.a.b;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class g extends WebViewClient
{
    final /* synthetic */ f a;
    
    private g(final f a) {
        this.a = a;
    }
    
    public final void onLoadResource(final WebView webView, final String s) {
        this.a.h.f();
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        if (this.a.e != null) {
            this.a.e.onAdClicked(this.a);
        }
        final com.facebook.ads.a.a.a a = b.a(this.a.getContext(), Uri.parse(s));
        final Map f = ((x)this.a.h.a()).f();
        f.put("adInterstitialUniqueId", UUID.randomUUID().toString());
        if (a == null) {
            return true;
        }
        try {
            a.a(f);
            return true;
        }
        catch (Exception ex) {
            Log.e(com.facebook.ads.f.a, "Error executing action", (Throwable)ex);
            return true;
        }
    }
}
