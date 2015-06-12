// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.inappbrowser;

import org.json.JSONException;
import org.json.JSONArray;
import org.apache.cordova.PluginResult;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions$Callback;
import org.apache.cordova.LOG;
import android.webkit.WebStorage$QuotaUpdater;
import org.apache.cordova.CordovaWebView;
import android.webkit.WebChromeClient;

public class InAppChromeClient extends WebChromeClient
{
    private String LOG_TAG;
    private long MAX_QUOTA;
    private CordovaWebView webView;
    
    public InAppChromeClient(final CordovaWebView webView) {
        this.LOG_TAG = "InAppChromeClient";
        this.MAX_QUOTA = 104857600L;
        this.webView = webView;
    }
    
    public void onExceededDatabaseQuota(final String s, final String s2, final long l, final long i, final long j, final WebStorage$QuotaUpdater webStorage$QuotaUpdater) {
        LOG.d(this.LOG_TAG, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", i, l, j);
        webStorage$QuotaUpdater.updateQuota(this.MAX_QUOTA);
    }
    
    public void onGeolocationPermissionsShowPrompt(final String s, final GeolocationPermissions$Callback geolocationPermissions$Callback) {
        super.onGeolocationPermissionsShowPrompt(s, geolocationPermissions$Callback);
        geolocationPermissions$Callback.invoke(s, true, false);
    }
    
    public boolean onJsPrompt(final WebView webView, final String str, final String s, final String str2, final JsPromptResult jsPromptResult) {
        if (str2 != null && str2.startsWith("gap")) {
            if (!str2.startsWith("gap-iab://")) {
                LOG.w(this.LOG_TAG, "InAppBrowser does not support Cordova API calls: " + str + " " + str2);
                jsPromptResult.cancel();
                return true;
            }
            final String substring = str2.substring(10);
            if (substring.startsWith("InAppBrowser")) {
                PluginResult pluginResult;
                if (s == null || s.length() == 0) {
                    pluginResult = new PluginResult(PluginResult.Status.OK, new JSONArray());
                }
                else {
                    try {
                        pluginResult = new PluginResult(PluginResult.Status.OK, new JSONArray(s));
                    }
                    catch (JSONException ex) {
                        pluginResult = new PluginResult(PluginResult.Status.JSON_EXCEPTION, ex.getMessage());
                    }
                }
                this.webView.sendPluginResult(pluginResult, substring);
                jsPromptResult.confirm("");
                return true;
            }
        }
        return false;
    }
}
