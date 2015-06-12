// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;
import android.telephony.TelephonyManager;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;

public class App extends CordovaPlugin
{
    protected static final String TAG = "CordovaApp";
    private BroadcastReceiver telephonyReceiver;
    
    private void initTelephonyReceiver() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        this.telephonyReceiver = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                if (intent != null && intent.getAction().equals("android.intent.action.PHONE_STATE") && intent.hasExtra("state")) {
                    final String stringExtra = intent.getStringExtra("state");
                    if (stringExtra.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                        LOG.i("CordovaApp", "Telephone RINGING");
                        App.this.webView.postMessage("telephone", "ringing");
                    }
                    else {
                        if (stringExtra.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                            LOG.i("CordovaApp", "Telephone OFFHOOK");
                            App.this.webView.postMessage("telephone", "offhook");
                            return;
                        }
                        if (stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                            LOG.i("CordovaApp", "Telephone IDLE");
                            App.this.webView.postMessage("telephone", "idle");
                        }
                    }
                }
            }
        };
        this.cordova.getActivity().registerReceiver(this.telephonyReceiver, intentFilter);
    }
    
    public void backHistory() {
        this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
            @Override
            public void run() {
                App.this.webView.backHistory();
            }
        });
    }
    
    public void clearCache() {
        this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
            @Override
            public void run() {
                App.this.webView.clearCache(true);
            }
        });
    }
    
    public void clearHistory() {
        this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
            @Override
            public void run() {
                App.this.webView.clearHistory();
            }
        });
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        while (true) {
            final PluginResult.Status ok = PluginResult.Status.OK;
            while (true) {
                Label_0085: {
                    try {
                        if (s.equals("clearCache")) {
                            this.clearCache();
                        }
                        else {
                            if (!s.equals("show")) {
                                break Label_0085;
                            }
                            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                                @Override
                                public void run() {
                                    App.this.webView.postMessage("spinner", "stop");
                                }
                            });
                        }
                        callbackContext.sendPluginResult(new PluginResult(ok, ""));
                        return true;
                    }
                    catch (JSONException ex) {
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
                        return false;
                    }
                }
                if (s.equals("loadUrl")) {
                    this.loadUrl(jsonArray.getString(0), jsonArray.optJSONObject(1));
                    continue;
                }
                if (s.equals("cancelLoadUrl")) {
                    continue;
                }
                if (s.equals("clearHistory")) {
                    this.clearHistory();
                    continue;
                }
                if (s.equals("backHistory")) {
                    this.backHistory();
                    continue;
                }
                if (s.equals("overrideButton")) {
                    this.overrideButton(jsonArray.getString(0), jsonArray.getBoolean(1));
                    continue;
                }
                if (s.equals("overrideBackbutton")) {
                    this.overrideBackbutton(jsonArray.getBoolean(0));
                    continue;
                }
                if (s.equals("exitApp")) {
                    this.exitApp();
                    continue;
                }
                continue;
            }
        }
    }
    
    public void exitApp() {
        this.webView.postMessage("exit", null);
    }
    
    public boolean isBackbuttonOverridden() {
        return this.webView.isButtonPlumbedToJs(4);
    }
    
    public void loadUrl(final String str, final JSONObject obj) throws JSONException {
        LOG.d("App", "App.loadUrl(" + str + "," + obj + ")");
        final HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        boolean boolean1 = false;
        boolean boolean2 = false;
        int int1 = 0;
    Label_0095_Outer:
        while (true) {
            Label_0109: {
                Label_0075: {
                    if (obj == null) {
                        break Label_0075;
                    }
                    final JSONArray names = obj.names();
                    final int n = 0;
                    if (n < names.length()) {
                        break Label_0109;
                    }
                }
            Label_0136_Outer:
                while (true) {
                    if (int1 <= 0) {
                        break Label_0095;
                    }
                    try {
                        // monitorenter(this)
                        final long n2 = int1;
                        try {
                            this.wait(n2);
                            // monitorexit(this)
                            this.webView.showWebPage(str, boolean2, boolean1, (HashMap<String, Object>)hashMap);
                            return;
                            // iftrue(Label_0163:, !string.equalsIgnoreCase("openexternal"))
                            // iftrue(Label_0136:, !value.getClass().equals((Object)Integer.class))
                            // iftrue(Label_0184:, !string.equalsIgnoreCase("clearhistory"))
                            // iftrue(Label_0142:, !string.equals((Object)"wait"))
                            // iftrue(Label_0253:, !value.getClass().equals((Object)Boolean.class))
                            // iftrue(Label_0225:, !value.getClass().equals((Object)String.class))
                            final JSONArray names;
                            int n = 0;
                            String string = null;
                            final Object value;
                            Label_0136:Block_10_Outer:
                            while (true) {
                                Block_8: {
                                    while (true) {
                                        while (true) {
                                            while (true) {
                                                Block_7: {
                                                    break Block_7;
                                                    int1 = obj.getInt(string);
                                                    break Label_0136;
                                                    Block_12: {
                                                        break Block_12;
                                                        hashMap.put(string, (Integer)value);
                                                        break Label_0136;
                                                        Label_0163: {
                                                            break Block_8;
                                                        }
                                                    }
                                                    hashMap.put(string, (Integer)value);
                                                    break Label_0136;
                                                }
                                                boolean2 = obj.getBoolean(string);
                                                ++n;
                                                continue Label_0095_Outer;
                                                string = names.getString(n);
                                                continue Label_0136_Outer;
                                            }
                                            hashMap.put(string, (Integer)value);
                                            continue Label_0136;
                                            Label_0225: {
                                                continue Block_10_Outer;
                                            }
                                        }
                                        continue;
                                    }
                                }
                                boolean1 = obj.getBoolean(string);
                                continue Label_0136;
                            }
                            Label_0184: {
                                value = obj.get(string);
                            }
                        }
                        // iftrue(Label_0136:, value == null)
                        finally {
                        }
                        // monitorexit(this)
                    }
                    catch (InterruptedException ex) {
                        ex.printStackTrace();
                        continue;
                    }
                    break;
                }
            }
            break;
        }
    }
    
    @Override
    public void onDestroy() {
        this.cordova.getActivity().unregisterReceiver(this.telephonyReceiver);
    }
    
    public void overrideBackbutton(final boolean b) {
        LOG.i("App", "WARNING: Back Button Default Behavior will be overridden.  The backbutton event will be fired!");
        this.webView.setButtonPlumbedToJs(4, b);
    }
    
    public void overrideButton(final String s, final boolean b) {
        LOG.i("App", "WARNING: Volume Button Default Behavior will be overridden.  The volume event will be fired!");
        if (s.equals("volumeup")) {
            this.webView.setButtonPlumbedToJs(24, b);
        }
        else if (s.equals("volumedown")) {
            this.webView.setButtonPlumbedToJs(25, b);
        }
    }
    
    public void pluginInitialize() {
        this.initTelephonyReceiver();
    }
}
