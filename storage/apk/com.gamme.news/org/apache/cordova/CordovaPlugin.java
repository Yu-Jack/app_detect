// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.net.Uri;
import android.content.Intent;
import org.json.JSONException;
import org.json.JSONArray;

public class CordovaPlugin
{
    public CordovaInterface cordova;
    @Deprecated
    public String id;
    protected CordovaPreferences preferences;
    public CordovaWebView webView;
    
    public boolean execute(final String s, final String s2, final CallbackContext callbackContext) throws JSONException {
        return this.execute(s, new JSONArray(s2), callbackContext);
    }
    
    public boolean execute(final String s, final CordovaArgs cordovaArgs, final CallbackContext callbackContext) throws JSONException {
        return false;
    }
    
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        return this.execute(s, new CordovaArgs(jsonArray), callbackContext);
    }
    
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
    }
    
    public void onDestroy() {
    }
    
    public Object onMessage(final String s, final Object o) {
        return null;
    }
    
    public void onNewIntent(final Intent intent) {
    }
    
    public boolean onOverrideUrlLoading(final String s) {
        return false;
    }
    
    public void onPause(final boolean b) {
    }
    
    public void onReset() {
    }
    
    public void onResume(final boolean b) {
    }
    
    protected void pluginInitialize() {
    }
    
    public final void privateInitialize(final CordovaInterface cordova, final CordovaWebView webView, final CordovaPreferences preferences) {
        assert this.cordova == null;
        this.cordova = cordova;
        this.webView = webView;
        this.preferences = preferences;
        this.initialize(cordova, webView);
        this.pluginInitialize();
    }
    
    public Uri remapUri(final Uri uri) {
        return null;
    }
}
