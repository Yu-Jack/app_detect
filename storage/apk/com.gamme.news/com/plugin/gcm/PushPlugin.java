// 
// Decompiled by Procyon v0.5.29
// 

package com.plugin.gcm;

import android.app.NotificationManager;
import org.apache.cordova.CordovaInterface;
import com.google.android.gcm.GCMRegistrar;
import org.apache.cordova.CallbackContext;
import android.content.Context;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import org.json.JSONObject;
import org.apache.cordova.CordovaWebView;
import android.os.Bundle;
import org.apache.cordova.CordovaPlugin;

public class PushPlugin extends CordovaPlugin
{
    public static final String EXIT = "exit";
    public static final String REGISTER = "register";
    public static final String TAG = "PushPlugin";
    public static final String UNREGISTER = "unregister";
    private static Bundle gCachedExtras;
    private static String gECB;
    private static boolean gForeground;
    private static String gSenderID;
    private static CordovaWebView gWebView;
    
    static {
        PushPlugin.gCachedExtras = null;
        PushPlugin.gForeground = false;
    }
    
    private static JSONObject convertBundleToJson(final Bundle bundle) {
        while (true) {
            while (true) {
                JSONObject put = null;
                JSONObject jsonObject = null;
                String s = null;
                Object value = null;
                Label_0144: {
                    try {
                        put = new JSONObject().put("event", (Object)"message");
                        jsonObject = new JSONObject();
                        final Iterator<String> iterator = bundle.keySet().iterator();
                        while (iterator.hasNext()) {
                            s = iterator.next();
                            value = bundle.get(s);
                            if (!s.equals("from") && !s.equals("collapse_key")) {
                                break Label_0144;
                            }
                            put.put(s, value);
                        }
                        put.put("payload", (Object)jsonObject);
                        Log.v("PushPlugin", "extrasToJSON: " + put.toString());
                        return put;
                    }
                    catch (JSONException ex) {
                        Log.e("PushPlugin", "extrasToJSON: JSON exception");
                        return null;
                    }
                }
                if (s.equals("foreground")) {
                    put.put(s, bundle.getBoolean("foreground"));
                    continue;
                }
                if (s.equals("coldstart")) {
                    put.put(s, bundle.getBoolean("coldstart"));
                    continue;
                }
                if (s.equals("message") || s.equals("msgcnt") || s.equals("soundname")) {
                    put.put(s, value);
                }
                if (!(value instanceof String)) {
                    continue;
                }
                final String s2 = (String)value;
                if (s2.startsWith("{")) {
                    try {
                        jsonObject.put(s, (Object)new JSONObject(s2));
                        continue;
                    }
                    catch (Exception ex2) {
                        jsonObject.put(s, value);
                        continue;
                    }
                    continue;
                }
                if (s2.startsWith("[")) {
                    try {
                        jsonObject.put(s, (Object)new JSONArray(s2));
                        continue;
                    }
                    catch (Exception ex3) {
                        jsonObject.put(s, value);
                        continue;
                    }
                    continue;
                }
                jsonObject.put(s, value);
                continue;
            }
        }
    }
    
    private Context getApplicationContext() {
        return this.cordova.getActivity().getApplicationContext();
    }
    
    public static boolean isActive() {
        return PushPlugin.gWebView != null;
    }
    
    public static boolean isInForeground() {
        return PushPlugin.gForeground;
    }
    
    public static void sendExtras(final Bundle gCachedExtras) {
        if (gCachedExtras != null) {
            if (PushPlugin.gECB == null || PushPlugin.gWebView == null) {
                Log.v("PushPlugin", "sendExtras: caching extras to send at a later time.");
                PushPlugin.gCachedExtras = gCachedExtras;
                return;
            }
            sendJavascript(convertBundleToJson(gCachedExtras));
        }
    }
    
    public static void sendJavascript(final JSONObject jsonObject) {
        final String string = "javascript:" + PushPlugin.gECB + "(" + jsonObject.toString() + ")";
        Log.v("PushPlugin", "sendJavascript: " + string);
        if (PushPlugin.gECB != null && PushPlugin.gWebView != null) {
            PushPlugin.gWebView.sendJavascript(string);
        }
    }
    
    @Override
    public boolean execute(final String str, final JSONArray jsonArray, final CallbackContext callbackContext) {
        Log.v("PushPlugin", "execute: action=" + str);
        if ("register".equals(str)) {
            Log.v("PushPlugin", "execute: data=" + jsonArray.toString());
            while (true) {
                try {
                    final JSONObject jsonObject = jsonArray.getJSONObject(0);
                    PushPlugin.gWebView = this.webView;
                    Log.v("PushPlugin", "execute: jo=" + jsonObject.toString());
                    PushPlugin.gECB = (String)jsonObject.get("ecb");
                    PushPlugin.gSenderID = (String)jsonObject.get("senderID");
                    Log.v("PushPlugin", "execute: ECB=" + PushPlugin.gECB + " senderID=" + PushPlugin.gSenderID);
                    GCMRegistrar.register(this.getApplicationContext(), PushPlugin.gSenderID);
                    final boolean b = true;
                    callbackContext.success();
                    if (PushPlugin.gCachedExtras != null) {
                        Log.v("PushPlugin", "sending cached extras");
                        sendExtras(PushPlugin.gCachedExtras);
                        PushPlugin.gCachedExtras = null;
                    }
                    return b;
                }
                catch (JSONException ex) {
                    Log.e("PushPlugin", "execute: Got JSON Exception " + ex.getMessage());
                    callbackContext.error(ex.getMessage());
                    final boolean b = false;
                    continue;
                }
                break;
            }
        }
        if ("unregister".equals(str)) {
            GCMRegistrar.unregister(this.getApplicationContext());
            Log.v("PushPlugin", "UNREGISTER");
            callbackContext.success();
            return true;
        }
        Log.e("PushPlugin", "Invalid action : " + str);
        callbackContext.error("Invalid action : " + str);
        return false;
    }
    
    @Override
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        PushPlugin.gForeground = true;
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        PushPlugin.gForeground = false;
        PushPlugin.gECB = null;
        PushPlugin.gWebView = null;
    }
    
    @Override
    public void onPause(final boolean b) {
        super.onPause(b);
        PushPlugin.gForeground = false;
        ((NotificationManager)this.cordova.getActivity().getSystemService("notification")).cancelAll();
    }
    
    @Override
    public void onResume(final boolean b) {
        super.onResume(b);
        PushPlugin.gForeground = true;
    }
}
