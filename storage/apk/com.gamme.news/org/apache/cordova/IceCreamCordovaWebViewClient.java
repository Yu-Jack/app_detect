// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.os.Build$VERSION;
import android.net.Uri;
import android.annotation.TargetApi;

@TargetApi(11)
public class IceCreamCordovaWebViewClient extends CordovaWebViewClient
{
    private static final String TAG = "IceCreamCordovaWebViewClient";
    private CordovaUriHelper helper;
    
    public IceCreamCordovaWebViewClient(final CordovaInterface cordovaInterface) {
        super(cordovaInterface);
    }
    
    public IceCreamCordovaWebViewClient(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        super(cordovaInterface, cordovaWebView);
    }
    
    private boolean isUrlHarmful(final String s) {
        return ((s.startsWith("http:") || s.startsWith("https:")) && !this.appView.getWhitelist().isUrlWhiteListed(s)) || s.contains("app_webview");
    }
    
    private static boolean needsKitKatContentUrlFix(final Uri uri) {
        return Build$VERSION.SDK_INT >= 19 && "content".equals(uri.getScheme());
    }
    
    private static boolean needsSpecialsInAssetUrlFix(final Uri uri) {
        if (CordovaResourceApi.getUriType(uri) == 1) {
            if (uri.getQuery() != null || uri.getFragment() != null) {
                return true;
            }
            if (uri.toString().contains("%")) {
                switch (Build$VERSION.SDK_INT) {
                    default: {
                        return false;
                    }
                    case 14:
                    case 15: {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public WebResourceResponse shouldInterceptRequest(final WebView webView, final String str) {
        try {
            if (this.isUrlHarmful(str)) {
                LOG.w("IceCreamCordovaWebViewClient", "URL blocked by whitelist: " + str);
                return new WebResourceResponse("text/plain", "UTF-8", (InputStream)null);
            }
            final CordovaResourceApi resourceApi = this.appView.getResourceApi();
            final Uri parse = Uri.parse(str);
            final Uri remapUri = resourceApi.remapUri(parse);
            if (!parse.equals((Object)remapUri) || needsSpecialsInAssetUrlFix(parse) || needsKitKatContentUrlFix(parse)) {
                final CordovaResourceApi.OpenForReadResult openForRead = resourceApi.openForRead(remapUri, true);
                return new WebResourceResponse(openForRead.mimeType, "UTF-8", openForRead.inputStream);
            }
        }
        catch (IOException ex) {
            if (!(ex instanceof FileNotFoundException)) {
                LOG.e("IceCreamCordovaWebViewClient", "Error occurred while loading a file (returning a 404).", ex);
            }
            return new WebResourceResponse("text/plain", "UTF-8", (InputStream)null);
        }
        return null;
    }
}
