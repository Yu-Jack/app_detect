// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import org.json.JSONArray;
import android.util.Log;
import org.json.JSONObject;

public class CallbackContext
{
    private static final String LOG_TAG = "CordovaPlugin";
    private String callbackId;
    private int changingThreads;
    private boolean finished;
    private CordovaWebView webView;
    
    public CallbackContext(final String callbackId, final CordovaWebView webView) {
        this.callbackId = callbackId;
        this.webView = webView;
    }
    
    public void error(final int n) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, n));
    }
    
    public void error(final String s) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, s));
    }
    
    public void error(final JSONObject jsonObject) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, jsonObject));
    }
    
    public String getCallbackId() {
        return this.callbackId;
    }
    
    public boolean isChangingThreads() {
        return this.changingThreads > 0;
    }
    
    public boolean isFinished() {
        return this.finished;
    }
    
    public void sendPluginResult(final PluginResult pluginResult) {
        synchronized (this) {
            if (this.finished) {
                Log.w("CordovaPlugin", "Attempted to send a second callback for ID: " + this.callbackId + "\nResult was: " + pluginResult.getMessage());
                return;
            }
            this.finished = !pluginResult.getKeepCallback();
            // monitorexit(this)
            this.webView.sendPluginResult(pluginResult, this.callbackId);
        }
    }
    
    public void success() {
        this.sendPluginResult(new PluginResult(PluginResult.Status.OK));
    }
    
    public void success(final int n) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.OK, n));
    }
    
    public void success(final String s) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.OK, s));
    }
    
    public void success(final JSONArray jsonArray) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.OK, jsonArray));
    }
    
    public void success(final JSONObject jsonObject) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.OK, jsonObject));
    }
    
    public void success(final byte[] array) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.OK, array));
    }
}
