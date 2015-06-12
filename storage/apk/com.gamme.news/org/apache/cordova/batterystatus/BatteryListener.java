// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.batterystatus;

import android.content.Context;
import android.content.IntentFilter;
import org.json.JSONArray;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import android.util.Log;
import org.json.JSONObject;
import android.content.Intent;
import android.content.BroadcastReceiver;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class BatteryListener extends CordovaPlugin
{
    private static final String LOG_TAG = "BatteryManager";
    private CallbackContext batteryCallbackContext;
    BroadcastReceiver receiver;
    
    public BatteryListener() {
        this.batteryCallbackContext = null;
        this.receiver = null;
    }
    
    private JSONObject getBatteryInfo(final Intent intent) {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("level", intent.getIntExtra("level", 0));
            final int intExtra = intent.getIntExtra("plugged", -1);
            boolean b = false;
            if (intExtra > 0) {
                b = true;
            }
            jsonObject.put("isPlugged", b);
            return jsonObject;
        }
        catch (JSONException ex) {
            Log.e("BatteryManager", ex.getMessage(), (Throwable)ex);
            return jsonObject;
        }
    }
    
    private void removeBatteryListener() {
        if (this.receiver == null) {
            return;
        }
        try {
            this.cordova.getActivity().unregisterReceiver(this.receiver);
            this.receiver = null;
        }
        catch (Exception ex) {
            Log.e("BatteryManager", "Error unregistering battery receiver: " + ex.getMessage(), (Throwable)ex);
        }
    }
    
    private void sendUpdate(final JSONObject jsonObject, final boolean keepCallback) {
        if (this.batteryCallbackContext != null) {
            final PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, jsonObject);
            pluginResult.setKeepCallback(keepCallback);
            this.batteryCallbackContext.sendPluginResult(pluginResult);
        }
    }
    
    private void updateBatteryInfo(final Intent intent) {
        this.sendUpdate(this.getBatteryInfo(intent), true);
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext batteryCallbackContext) {
        if (s.equals("start")) {
            if (this.batteryCallbackContext != null) {
                batteryCallbackContext.error("Battery listener already running.");
                return true;
            }
            this.batteryCallbackContext = batteryCallbackContext;
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            if (this.receiver == null) {
                this.receiver = new BroadcastReceiver() {
                    public void onReceive(final Context context, final Intent intent) {
                        BatteryListener.this.updateBatteryInfo(intent);
                    }
                };
                this.cordova.getActivity().registerReceiver(this.receiver, intentFilter);
            }
            final PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(true);
            batteryCallbackContext.sendPluginResult(pluginResult);
            return true;
        }
        else {
            if (s.equals("stop")) {
                this.removeBatteryListener();
                this.sendUpdate(new JSONObject(), false);
                this.batteryCallbackContext = null;
                batteryCallbackContext.success();
                return true;
            }
            return false;
        }
    }
    
    @Override
    public void onDestroy() {
        this.removeBatteryListener();
    }
    
    @Override
    public void onReset() {
        this.removeBatteryListener();
    }
}
