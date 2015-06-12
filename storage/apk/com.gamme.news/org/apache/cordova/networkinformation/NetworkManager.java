// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.networkinformation;

import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import android.util.Log;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.content.BroadcastReceiver;
import org.json.JSONObject;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class NetworkManager extends CordovaPlugin
{
    public static final String CDMA = "cdma";
    public static final String EDGE = "edge";
    public static final String EHRPD = "ehrpd";
    public static final String GPRS = "gprs";
    public static final String GSM = "gsm";
    public static final String HSDPA = "hsdpa";
    public static final String HSPA = "hspa";
    public static final String HSPA_PLUS = "hspa+";
    public static final String HSUPA = "hsupa";
    private static final String LOG_TAG = "NetworkManager";
    public static final String LTE = "lte";
    public static final String MOBILE = "mobile";
    public static int NOT_REACHABLE = 0;
    public static final String ONEXRTT = "1xrtt";
    public static int REACHABLE_VIA_CARRIER_DATA_NETWORK = 0;
    public static int REACHABLE_VIA_WIFI_NETWORK = 0;
    public static final String TYPE_2G = "2g";
    public static final String TYPE_3G = "3g";
    public static final String TYPE_4G = "4g";
    public static final String TYPE_ETHERNET = "ethernet";
    public static final String TYPE_NONE = "none";
    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_WIFI = "wifi";
    public static final String UMB = "umb";
    public static final String UMTS = "umts";
    public static final String WIFI = "wifi";
    public static final String WIMAX = "wimax";
    private CallbackContext connectionCallbackContext;
    private JSONObject lastInfo;
    BroadcastReceiver receiver;
    private boolean registered;
    ConnectivityManager sockMan;
    
    static {
        NetworkManager.NOT_REACHABLE = 0;
        NetworkManager.REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
        NetworkManager.REACHABLE_VIA_WIFI_NETWORK = 2;
    }
    
    public NetworkManager() {
        this.registered = false;
        this.lastInfo = null;
        this.receiver = null;
    }
    
    private JSONObject getConnectionInfo(final NetworkInfo networkInfo) {
        String type = "none";
        String extraInfo = "";
        Label_0099: {
            while (true) {
                Label_0025: {
                    if (networkInfo == null) {
                        break Label_0025;
                    }
                    if (networkInfo.isConnected()) {
                        break Label_0099;
                    }
                    type = "none";
                    extraInfo = networkInfo.getExtraInfo();
                }
                Log.d("CordovaNetworkManager", "Connection Type: " + type);
                Log.d("CordovaNetworkManager", "Connection Extra Info: " + extraInfo);
                final JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("type", (Object)type);
                    jsonObject.put("extraInfo", (Object)extraInfo);
                    return jsonObject;
                    type = this.getType(networkInfo);
                    continue;
                }
                catch (JSONException ex) {
                    return jsonObject;
                }
                break;
            }
        }
    }
    
    private String getType(final NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "none";
        }
        final String typeName = networkInfo.getTypeName();
        if (typeName.toLowerCase().equals("wifi")) {
            return "wifi";
        }
        if (typeName.toLowerCase().equals("mobile")) {
            final String subtypeName = networkInfo.getSubtypeName();
            if (subtypeName.toLowerCase().equals("gsm") || subtypeName.toLowerCase().equals("gprs") || subtypeName.toLowerCase().equals("edge")) {
                return "2g";
            }
            if (subtypeName.toLowerCase().startsWith("cdma") || subtypeName.toLowerCase().equals("umts") || subtypeName.toLowerCase().equals("1xrtt") || subtypeName.toLowerCase().equals("ehrpd") || subtypeName.toLowerCase().equals("hsupa") || subtypeName.toLowerCase().equals("hsdpa") || subtypeName.toLowerCase().equals("hspa")) {
                return "3g";
            }
            if (subtypeName.toLowerCase().equals("lte") || subtypeName.toLowerCase().equals("umb") || subtypeName.toLowerCase().equals("hspa+")) {
                return "4g";
            }
        }
        return "unknown";
    }
    
    private void sendUpdate(final String s) {
        if (this.connectionCallbackContext != null) {
            final PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, s);
            pluginResult.setKeepCallback(true);
            this.connectionCallbackContext.sendPluginResult(pluginResult);
        }
        this.webView.postMessage("networkconnection", s);
    }
    
    private void updateConnectionInfo(final NetworkInfo networkInfo) {
        final JSONObject connectionInfo = this.getConnectionInfo(networkInfo);
        if (connectionInfo.equals(this.lastInfo)) {
            return;
        }
        String string = "";
        while (true) {
            try {
                string = connectionInfo.get("type").toString();
                this.sendUpdate(string);
                this.lastInfo = connectionInfo;
            }
            catch (JSONException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext connectionCallbackContext) {
        if (!s.equals("getConnectionInfo")) {
            return false;
        }
        this.connectionCallbackContext = connectionCallbackContext;
        final NetworkInfo activeNetworkInfo = this.sockMan.getActiveNetworkInfo();
        String string = "";
        while (true) {
            try {
                string = this.getConnectionInfo(activeNetworkInfo).get("type").toString();
                final PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, string);
                pluginResult.setKeepCallback(true);
                connectionCallbackContext.sendPluginResult(pluginResult);
                return true;
            }
            catch (JSONException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.sockMan = (ConnectivityManager)cordovaInterface.getActivity().getSystemService("connectivity");
        this.connectionCallbackContext = null;
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.receiver == null) {
            this.receiver = new BroadcastReceiver() {
                public void onReceive(final Context context, final Intent intent) {
                    if (NetworkManager.this.webView != null) {
                        NetworkManager.this.updateConnectionInfo(NetworkManager.this.sockMan.getActiveNetworkInfo());
                    }
                }
            };
            cordovaInterface.getActivity().registerReceiver(this.receiver, intentFilter);
            this.registered = true;
        }
    }
    
    @Override
    public void onDestroy() {
        if (this.receiver == null || !this.registered) {
            return;
        }
        try {
            this.cordova.getActivity().unregisterReceiver(this.receiver);
            this.registered = false;
        }
        catch (Exception ex) {
            Log.e("NetworkManager", "Error unregistering network receiver: " + ex.getMessage(), (Throwable)ex);
        }
    }
}
