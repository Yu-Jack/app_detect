// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.content.Context;

public final class u
{
    private static String a;
    
    static {
        u.a = null;
    }
    
    public static String a(final Context context) {
        if (u.a == null) {
            final WebView webView = new WebView(context.getApplicationContext());
            u.a = webView.getSettings().getUserAgentString();
            webView.destroy();
        }
        return u.a;
    }
    
    public static void a(final WebView webView, final WebViewClient webViewClient, final t t) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setHorizontalScrollbarOverlay(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVerticalScrollbarOverlay(false);
        webView.addJavascriptInterface((Object)t, "AdControl");
        webView.setWebViewClient(webViewClient);
    }
}
