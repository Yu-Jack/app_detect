// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.view.WindowManager;
import com.facebook.ads.a.g;
import android.view.View;
import com.facebook.ads.a.u;
import com.facebook.ads.a.t;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.os.Bundle;
import android.support.v4.content.e;
import android.content.Intent;
import com.facebook.ads.a.y;
import com.facebook.ads.a.x;
import android.app.Activity;
import com.facebook.ads.a.a.a;
import android.util.Log;
import java.util.Map;
import android.content.Context;
import com.facebook.ads.a.a.b;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class k extends WebViewClient
{
    final /* synthetic */ InterstitialAdActivity a;
    
    private k(final InterstitialAdActivity a) {
        this.a = a;
    }
    
    public final void onLoadResource(final WebView webView, final String s) {
        this.a.h.f();
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        final Uri parse = Uri.parse(s);
        if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
            this.a.finish();
        }
        else {
            this.a.a("com.facebook.ads.interstitial.clicked");
            final a a = b.a((Context)this.a, parse);
            if (a != null) {
                try {
                    a.a(null);
                    return true;
                }
                catch (Exception ex) {
                    Log.e(InterstitialAdActivity.a, "Error executing action", (Throwable)ex);
                    return true;
                }
            }
        }
        return true;
    }
}
