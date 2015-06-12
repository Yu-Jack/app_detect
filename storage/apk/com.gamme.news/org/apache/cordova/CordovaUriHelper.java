// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.os.Build$VERSION;
import android.content.ComponentName;
import android.net.Uri;
import android.content.Intent;
import android.webkit.WebView;

class CordovaUriHelper
{
    private static final String TAG = "CordovaUriHelper";
    private CordovaWebView appView;
    private CordovaInterface cordova;
    
    CordovaUriHelper(final CordovaInterface cordova, final CordovaWebView appView) {
        this.appView = appView;
        this.cordova = cordova;
    }
    
    @TargetApi(15)
    boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
        if (!this.appView.pluginManager.onOverrideUrlLoading(str)) {
            if (str.startsWith("file://") | str.startsWith("data:")) {
                return str.contains("app_webview");
            }
            if (this.appView.getWhitelist().isUrlWhiteListed(str)) {
                return false;
            }
            if (this.appView.getExternalWhitelist().isUrlWhiteListed(str)) {
                try {
                    final Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setComponent((ComponentName)null);
                    if (Build$VERSION.SDK_INT >= 15) {
                        intent.setSelector((Intent)null);
                    }
                    this.cordova.getActivity().startActivity(intent);
                    return true;
                }
                catch (ActivityNotFoundException ex) {
                    LOG.e("CordovaUriHelper", "Error loading url " + str, (Throwable)ex);
                    return true;
                }
            }
        }
        return true;
    }
}
