// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.splashscreen;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.apache.cordova.CordovaPlugin;

public class SplashScreen extends CordovaPlugin
{
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) {
        if (s.equals("hide")) {
            this.webView.postMessage("splashscreen", "hide");
        }
        else {
            if (!s.equals("show")) {
                return false;
            }
            this.webView.postMessage("splashscreen", "show");
        }
        callbackContext.success();
        return true;
    }
}
