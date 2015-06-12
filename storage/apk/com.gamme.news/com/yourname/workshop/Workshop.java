// 
// Decompiled by Procyon v0.5.29
// 

package com.yourname.workshop;

import org.apache.cordova.Config;
import android.webkit.WebViewClient;
import android.webkit.WebResourceResponse;
import android.util.Log;
import android.webkit.WebView;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebViewClient;
import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

public class Workshop extends CordovaActivity
{
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        super.init();
        this.appView.clearCache(true);
        this.appView.clearHistory();
        this.appView.setWebViewClient(new CordovaWebViewClient(this, this.appView) {
            public void onLoadResource(final WebView webView, final String str) {
                Log.d("DEBUG", "onLoadResource" + str);
                super.onLoadResource(webView, str);
            }
            
            @Override
            public void onPageFinished(final WebView webView, final String str) {
                Log.d("DEBUG", "On page finished " + str);
                super.onPageFinished(webView, str);
            }
            
            public WebResourceResponse shouldInterceptRequest(final WebView webView, final String str) {
                Log.d("DEBUG", "Should intercept request" + str);
                return super.shouldInterceptRequest(webView, str);
            }
            
            @Override
            public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
                Log.d("DEBUG", "should override url loading " + s);
                if (s.contains("/login.php")) {
                    Log.d("DEBUG", s);
                    webView.loadUrl("javascript:showlog('" + s + "')");
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, s);
            }
        });
        super.loadUrl(Config.getStartUrl());
    }
}
