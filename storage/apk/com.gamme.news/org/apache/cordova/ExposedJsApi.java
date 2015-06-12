// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.webkit.JavascriptInterface;
import org.json.JSONException;

class ExposedJsApi
{
    private CordovaBridge bridge;
    
    public ExposedJsApi(final CordovaBridge bridge) {
        this.bridge = bridge;
    }
    
    @JavascriptInterface
    public String exec(final int n, final String s, final String s2, final String s3, final String s4) throws JSONException, IllegalAccessException {
        return this.bridge.jsExec(n, s, s2, s3, s4);
    }
    
    @JavascriptInterface
    public String retrieveJsMessages(final int n, final boolean b) throws IllegalAccessException {
        return this.bridge.jsRetrieveJsMessages(n, b);
    }
    
    @JavascriptInterface
    public void setNativeToJsBridgeMode(final int n, final int n2) throws IllegalAccessException {
        this.bridge.jsSetNativeToJsBridgeMode(n, n2);
    }
}
