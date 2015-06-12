// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.HttpAuthHandler;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Bitmap;
import android.webkit.WebView;
import java.util.Hashtable;
import android.webkit.WebViewClient;

public class CordovaWebViewClient extends WebViewClient
{
    private static final String TAG = "CordovaWebViewClient";
    CordovaWebView appView;
    private Hashtable<String, AuthenticationToken> authenticationTokens;
    CordovaInterface cordova;
    private boolean doClearHistory;
    CordovaUriHelper helper;
    boolean isCurrentlyLoading;
    
    public CordovaWebViewClient(final CordovaInterface cordova) {
        this.doClearHistory = false;
        this.authenticationTokens = new Hashtable<String, AuthenticationToken>();
        this.cordova = cordova;
    }
    
    public CordovaWebViewClient(final CordovaInterface cordova, final CordovaWebView appView) {
        this.doClearHistory = false;
        this.authenticationTokens = new Hashtable<String, AuthenticationToken>();
        this.cordova = cordova;
        this.appView = appView;
        this.helper = new CordovaUriHelper(cordova, appView);
    }
    
    public void clearAuthenticationTokens() {
        this.authenticationTokens.clear();
    }
    
    public AuthenticationToken getAuthenticationToken(final String key, final String s) {
        AuthenticationToken authenticationToken = this.authenticationTokens.get(key.concat(s));
        if (authenticationToken == null) {
            authenticationToken = this.authenticationTokens.get(key);
            if (authenticationToken == null) {
                authenticationToken = this.authenticationTokens.get(s);
            }
            if (authenticationToken == null) {
                authenticationToken = this.authenticationTokens.get("");
            }
        }
        return authenticationToken;
    }
    
    public void onPageFinished(final WebView webView, final String str) {
        super.onPageFinished(webView, str);
        if (this.isCurrentlyLoading) {
            this.isCurrentlyLoading = false;
            LOG.d("CordovaWebViewClient", "onPageFinished(" + str + ")");
            if (this.doClearHistory) {
                webView.clearHistory();
                this.doClearHistory = false;
            }
            final CordovaWebView appView = this.appView;
            ++appView.loadUrlTimeout;
            this.appView.postMessage("onPageFinished", str);
            if (this.appView.getVisibility() == 4) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000L);
                            CordovaWebViewClient.this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                                @Override
                                public void run() {
                                    CordovaWebViewClient.this.appView.postMessage("spinner", "stop");
                                }
                            });
                        }
                        catch (InterruptedException ex) {}
                    }
                }).start();
            }
            if (str.equals("about:blank")) {
                this.appView.postMessage("exit", null);
            }
        }
    }
    
    public void onPageStarted(final WebView webView, final String str, final Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.isCurrentlyLoading = true;
        LOG.d("CordovaWebViewClient", "onPageStarted(" + str + ")");
        this.appView.bridge.reset(str);
        this.appView.postMessage("onPageStarted", str);
        if (this.appView.pluginManager != null) {
            this.appView.pluginManager.onReset();
        }
    }
    
    public void onReceivedError(final WebView webView, final int i, final String s, final String s2) {
        if (!this.isCurrentlyLoading) {
            return;
        }
        LOG.d("CordovaWebViewClient", "CordovaWebViewClient.onReceivedError: Error code=%s Description=%s URL=%s", i, s, s2);
        final CordovaWebView appView = this.appView;
        ++appView.loadUrlTimeout;
        if (i == -10) {
            if (webView.canGoBack()) {
                webView.goBack();
                return;
            }
            super.onReceivedError(webView, i, s, s2);
        }
        final JSONObject jsonObject = new JSONObject();
        while (true) {
            try {
                jsonObject.put("errorCode", i);
                jsonObject.put("description", (Object)s);
                jsonObject.put("url", (Object)s2);
                this.appView.postMessage("onReceivedError", jsonObject);
            }
            catch (JSONException ex) {
                ex.printStackTrace();
                continue;
            }
            break;
        }
    }
    
    public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String s, final String s2) {
        final AuthenticationToken authenticationToken = this.getAuthenticationToken(s, s2);
        if (authenticationToken != null) {
            httpAuthHandler.proceed(authenticationToken.getUserName(), authenticationToken.getPassword());
            return;
        }
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, s, s2);
    }
    
    @TargetApi(8)
    public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        final String packageName = this.cordova.getActivity().getPackageName();
        final PackageManager packageManager = this.cordova.getActivity().getPackageManager();
        try {
            if ((0x2 & packageManager.getApplicationInfo(packageName, 128).flags) != 0x0) {
                sslErrorHandler.proceed();
                return;
            }
            sslErrorHandler.proceed();
        }
        catch (PackageManager$NameNotFoundException ex) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }
    
    public AuthenticationToken removeAuthenticationToken(final String s, final String str) {
        return this.authenticationTokens.remove(s.concat(str));
    }
    
    public void setAuthenticationToken(final AuthenticationToken value, String s, String str) {
        if (s == null) {
            s = "";
        }
        if (str == null) {
            str = "";
        }
        this.authenticationTokens.put(s.concat(str), value);
    }
    
    @Deprecated
    public void setWebView(final CordovaWebView appView) {
        this.appView = appView;
        this.helper = new CordovaUriHelper(this.cordova, appView);
    }
    
    public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        return this.helper.shouldOverrideUrlLoading(webView, s);
    }
}
