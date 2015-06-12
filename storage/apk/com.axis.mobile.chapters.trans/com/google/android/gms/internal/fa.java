// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.io.File;
import android.webkit.WebView;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import android.webkit.WebResourceResponse;
import android.content.Context;

public class fa extends ey
{
    public fa(final ex ex, final boolean b) {
        super(ex, b);
    }
    
    protected WebResourceResponse c(final Context context, final String s, final String spec) {
        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(spec).openConnection();
        try {
            eo.a(context, s, true, httpURLConnection);
            httpURLConnection.connect();
            return new WebResourceResponse("application/javascript", "UTF-8", (InputStream)new ByteArrayInputStream(eo.a(new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
        }
        finally {
            httpURLConnection.disconnect();
        }
    }
    
    public WebResourceResponse shouldInterceptRequest(final WebView webView, final String pathname) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(pathname).getName())) {
                return super.shouldInterceptRequest(webView, pathname);
            }
            if (!(webView instanceof ex)) {
                eu.D("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, pathname);
            }
            final ex ex = (ex)webView;
            ex.cb().aS();
            if (ex.V().mf) {
                eu.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return this.c(ex.getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            }
            if (ex.ce()) {
                eu.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return this.c(ex.getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            }
            eu.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
            return this.c(ex.getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
        }
        catch (IOException ex2) {
            eu.D("Could not fetching MRAID JS. " + ex2.getMessage());
            return super.shouldInterceptRequest(webView, pathname);
        }
    }
}
