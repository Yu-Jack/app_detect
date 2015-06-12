// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.device;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import android.provider.Settings$Secure;
import java.util.TimeZone;
import android.os.Build$VERSION;
import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.apache.cordova.CordovaPlugin;

public class Device extends CordovaPlugin
{
    private static final String AMAZON_DEVICE = "Amazon";
    private static final String AMAZON_PLATFORM = "amazon-fireos";
    private static final String ANDROID_PLATFORM = "Android";
    public static final String TAG = "Device";
    public static String platform;
    public static String uuid;
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        if (s.equals("getDeviceInfo")) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("uuid", (Object)Device.uuid);
            jsonObject.put("version", (Object)this.getOSVersion());
            jsonObject.put("platform", (Object)this.getPlatform());
            jsonObject.put("model", (Object)this.getModel());
            callbackContext.success(jsonObject);
            return true;
        }
        return false;
    }
    
    public String getModel() {
        return Build.MODEL;
    }
    
    public String getOSVersion() {
        return Build$VERSION.RELEASE;
    }
    
    public String getPlatform() {
        if (this.isAmazonDevice()) {
            return "amazon-fireos";
        }
        return "Android";
    }
    
    public String getProductName() {
        return Build.PRODUCT;
    }
    
    public String getSDKVersion() {
        return Build$VERSION.SDK;
    }
    
    public String getTimeZoneID() {
        return TimeZone.getDefault().getID();
    }
    
    public String getUuid() {
        return Settings$Secure.getString(this.cordova.getActivity().getContentResolver(), "android_id");
    }
    
    @Override
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        Device.uuid = this.getUuid();
    }
    
    public boolean isAmazonDevice() {
        return Build.MANUFACTURER.equals("Amazon");
    }
}
