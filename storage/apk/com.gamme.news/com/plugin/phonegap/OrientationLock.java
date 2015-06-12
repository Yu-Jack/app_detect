// 
// Decompiled by Procyon v0.5.29
// 

package com.plugin.phonegap;

import org.json.JSONException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.apache.cordova.CordovaPlugin;

public class OrientationLock extends CordovaPlugin
{
    private static final String LANSCAPE = "landscape";
    private static final String PORTRAIT = "portrait";
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) {
        if (s.equals("lock")) {
            try {
                final String string = jsonArray.getString(0);
                if (string != null && (string.equals("landscape") || string.equals("portrait"))) {
                    this.lock(string);
                    callbackContext.success();
                    return true;
                }
                return false;
            }
            catch (JSONException ex) {
                callbackContext.error("JSON_EXCEPTION");
                return true;
            }
        }
        if (s.equals("unlock")) {
            this.unlock();
            callbackContext.success();
            return true;
        }
        return false;
    }
    
    public void lock(final String s) {
        if (s.equals("portrait")) {
            this.cordova.getActivity().setRequestedOrientation(1);
            return;
        }
        this.cordova.getActivity().setRequestedOrientation(0);
    }
    
    public void unlock() {
        this.cordova.getActivity().setRequestedOrientation(-1);
    }
}
