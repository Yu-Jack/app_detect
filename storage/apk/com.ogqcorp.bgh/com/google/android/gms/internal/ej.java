// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.view.Window;
import android.graphics.Paint;
import android.view.View;
import android.webkit.WebSettings;
import android.content.Context;

public final class ej
{
    public static void a(final Context context, final WebSettings webSettings) {
        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        webSettings.setAppCacheMaxSize(0L);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }
    
    public static void a(final View view) {
        view.setLayerType(1, (Paint)null);
    }
    
    public static void a(final Window window) {
        window.setFlags(16777216, 16777216);
    }
    
    public static void a(final WebView webView) {
        webView.onPause();
    }
    
    public static void b(final View view) {
        view.setLayerType(0, (Paint)null);
    }
    
    public static void b(final WebView webView) {
        webView.onResume();
    }
}
