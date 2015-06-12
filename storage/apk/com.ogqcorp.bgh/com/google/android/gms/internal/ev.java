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

public class ev extends es
{
    public ev(final ep ep, final boolean b) {
        super(ep, b);
    }
    
    protected WebResourceResponse a(final Context context, final String s, final String spec) {
        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(spec).openConnection();
        try {
            eg.a(context, s, true, httpURLConnection);
            httpURLConnection.connect();
            return new WebResourceResponse("application/javascript", "UTF-8", (InputStream)new ByteArrayInputStream(eg.a(new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
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
            if (!(webView instanceof ep)) {
                en.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, pathname);
            }
            final ep ep = (ep)webView;
            ep.f().c();
            if (ep.e().e) {
                en.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return this.a(ep.getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            }
            if (ep.i()) {
                en.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return this.a(ep.getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            }
            en.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
            return this.a(ep.getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
        }
        catch (IOException ex) {
            en.e("Could not fetching MRAID JS. " + ex.getMessage());
            return super.shouldInterceptRequest(webView, pathname);
        }
    }
}
