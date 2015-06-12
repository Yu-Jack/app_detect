// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.net.wifi.WifiInfo;
import java.util.regex.Pattern;
import android.net.wifi.WifiManager;
import org.json.JSONObject;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.provider.Settings$Secure;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.os.Build$VERSION;
import android.os.Build;

class DeviceInfo
{
    private static final String LOG_TAG = "DeviceInfo";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    public static final String ORIENTATION_UNKNOWN = "unknown";
    public static final String WIFI_NAME = "Wifi";
    private static final String dt = "android";
    private static final String make;
    private static final String model;
    private static final String os = "Android";
    private static final String osVersion;
    private static String userAgent;
    private boolean bad_mac;
    private boolean bad_serial;
    private boolean bad_udid;
    private String carrier;
    private String country;
    private Size landscapeScreenSize;
    private String language;
    private boolean macFetched;
    private String md5_mac;
    private String md5_serial;
    private String md5_udid;
    private Size portraitScreenSize;
    private float scalingFactor;
    private String scalingFactorAsString;
    private boolean serialFetched;
    private String sha1_mac;
    private String sha1_serial;
    private String sha1_udid;
    private String udid;
    private boolean udidFetched;
    
    static {
        make = Build.MANUFACTURER;
        model = Build.MODEL;
        osVersion = Build$VERSION.RELEASE;
    }
    
    protected DeviceInfo() {
    }
    
    public DeviceInfo(final Context context) {
        this.setCountry();
        this.setCarrier(context);
        this.setLanguage();
        this.setScalingFactor(context);
    }
    
    public static String getDeviceType() {
        return "android";
    }
    
    public static String getMake() {
        return DeviceInfo.make;
    }
    
    public static String getModel() {
        return DeviceInfo.model;
    }
    
    public static String getOS() {
        return "Android";
    }
    
    public static String getOSVersion() {
        return DeviceInfo.osVersion;
    }
    
    public static String getUserAgentString() {
        return DeviceInfo.userAgent;
    }
    
    private void setCarrier(final Context context) {
        final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager != null) {
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName == null || networkOperatorName.length() <= 0) {
                networkOperatorName = null;
            }
            this.carrier = networkOperatorName;
        }
    }
    
    private void setCountry() {
        String country = Locale.getDefault().getCountry();
        if (country == null || country.length() <= 0) {
            country = null;
        }
        this.country = country;
    }
    
    private void setLanguage() {
        String language = Locale.getDefault().getLanguage();
        if (language == null || language.length() <= 0) {
            language = null;
        }
        this.language = language;
    }
    
    private void setMacAddressIfNotFetched() {
        if (!this.macFetched) {
            this.setMacAddress();
        }
    }
    
    private void setScalingFactor(final Context context) {
        if (DeviceInfo.make.equals("motorola") && DeviceInfo.model.equals("MB502")) {
            this.scalingFactor = 1.0f;
        }
        else {
            final WindowManager windowManager = (WindowManager)context.getSystemService("window");
            final DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.scalingFactor = displayMetrics.scaledDensity;
        }
        this.scalingFactorAsString = Float.toString(this.scalingFactor);
    }
    
    private void setSerial() {
    Label_0041_Outer:
        while (true) {
            while (true) {
                String s;
                while (true) {
                    try {
                        s = (String)Build.class.getDeclaredField("SERIAL").get(Build.class);
                        if (s == null || s.length() == 0 || s.equalsIgnoreCase("unknown")) {
                            this.bad_serial = true;
                            this.serialFetched = true;
                            return;
                        }
                    }
                    catch (Exception ex) {
                        s = null;
                        continue Label_0041_Outer;
                    }
                    break;
                }
                this.sha1_serial = Utils.getURLEncodedString(Utils.sha1(s));
                continue;
            }
        }
    }
    
    private void setSerialIfNotFetched() {
        if (!this.serialFetched) {
            this.setSerial();
        }
    }
    
    private void setUdid() {
        final String string = Settings$Secure.getString(InternalAdRegistration.getInstance().getApplicationContext().getContentResolver(), "android_id");
        if (Utils.isNullOrEmpty(string) || string.equalsIgnoreCase("9774d56d682e549c")) {
            this.udid = null;
            this.sha1_udid = null;
            this.bad_udid = true;
        }
        else {
            this.udid = Utils.getURLEncodedString(string);
            this.sha1_udid = Utils.getURLEncodedString(Utils.sha1(string));
        }
        this.udidFetched = true;
    }
    
    private void setUdidIfNotFetched() {
        if (!this.udidFetched) {
            this.setUdid();
        }
    }
    
    public static void setUserAgentString(final String userAgent) {
        if (userAgent != null && !userAgent.equals(DeviceInfo.userAgent)) {
            DeviceInfo.userAgent = userAgent;
        }
    }
    
    public String getCarrier() {
        return this.carrier;
    }
    
    public String getConnectionType() {
        final ConnectivityManager connectivityManager = (ConnectivityManager)InternalAdRegistration.getInstance().getApplicationContext().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        Label_0031: {
            if (connectivityManager == null) {
                final NetworkInfo activeNetworkInfo = null;
                break Label_0031;
            }
            while (true) {
                try {
                    final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    networkInfo = activeNetworkInfo;
                    if (networkInfo == null) {
                        return Integer.toString(0);
                    }
                    if (networkInfo.getType() == 1) {
                        return "Wifi";
                    }
                }
                catch (SecurityException ex) {
                    Log.d("DeviceInfo", "Unable to get active network information: %s", ex);
                    networkInfo = null;
                    continue;
                }
                break;
            }
        }
        return Integer.toString(networkInfo.getSubtype());
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public JSONObject getDInfoProperty() {
        final JSONObject jsonObject = new JSONObject();
        JSONUtils.put(jsonObject, "make", getMake());
        JSONUtils.put(jsonObject, "model", getModel());
        JSONUtils.put(jsonObject, "os", getOS());
        JSONUtils.put(jsonObject, "osVersion", getOSVersion());
        JSONUtils.put(jsonObject, "scalingFactor", this.getScalingFactorAsString());
        JSONUtils.put(jsonObject, "language", this.getLanguage());
        JSONUtils.put(jsonObject, "country", this.getCountry());
        JSONUtils.put(jsonObject, "carrier", this.getCarrier());
        return jsonObject;
    }
    
    public String getLanguage() {
        return this.language;
    }
    
    public String getMacMd5() {
        this.setMacAddressIfNotFetched();
        return this.md5_mac;
    }
    
    public String getMacSha1() {
        this.setMacAddressIfNotFetched();
        return this.sha1_mac;
    }
    
    public String getOrientation() {
        switch (Utils.determineCanonicalScreenOrientation()) {
            default: {
                return "unknown";
            }
            case 1:
            case 9: {
                return "portrait";
            }
            case 0:
            case 8: {
                return "landscape";
            }
        }
    }
    
    public float getScalingFactorAsFloat() {
        return this.scalingFactor;
    }
    
    public String getScalingFactorAsString() {
        return this.scalingFactorAsString;
    }
    
    public Size getScreenSize(final String s) {
        if (s.equals("portrait") && this.portraitScreenSize != null) {
            return this.portraitScreenSize;
        }
        if (s.equals("landscape") && this.landscapeScreenSize != null) {
            return this.landscapeScreenSize;
        }
        final WindowManager windowManager = (WindowManager)InternalAdRegistration.getInstance().getApplicationContext().getSystemService("window");
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        final String string = String.valueOf(displayMetrics.widthPixels) + "x" + String.valueOf(displayMetrics.heightPixels);
        if (s.equals("portrait")) {
            return this.portraitScreenSize = new Size(string);
        }
        if (s.equals("landscape")) {
            return this.landscapeScreenSize = new Size(string);
        }
        return new Size(string);
    }
    
    public String getSerialMd5() {
        this.setSerialIfNotFetched();
        return this.md5_serial;
    }
    
    public String getSerialSha1() {
        this.setSerialIfNotFetched();
        return this.sha1_serial;
    }
    
    public String getUdid() {
        this.setUdidIfNotFetched();
        return this.udid;
    }
    
    public String getUdidMd5() {
        this.setUdidIfNotFetched();
        return this.md5_udid;
    }
    
    public String getUdidSha1() {
        this.setUdidIfNotFetched();
        return this.sha1_udid;
    }
    
    public boolean isMacBad() {
        this.setMacAddressIfNotFetched();
        return this.bad_mac;
    }
    
    public boolean isSerialBad() {
        this.setSerialIfNotFetched();
        return this.bad_serial;
    }
    
    public boolean isUdidBad() {
        this.setUdidIfNotFetched();
        return this.bad_udid;
    }
    
    protected void setMacAddress() {
        final WifiManager wifiManager = (WifiManager)InternalAdRegistration.getInstance().getApplicationContext().getSystemService("wifi");
    Label_0031:
        while (true) {
            Label_0089: {
                if (wifiManager == null) {
                    break Label_0089;
                }
                while (true) {
                    while (true) {
                        WifiInfo connectionInfo = null;
                        Label_0094: {
                            try {
                                connectionInfo = wifiManager.getConnectionInfo();
                                if (connectionInfo == null) {
                                    this.sha1_mac = null;
                                    this.macFetched = true;
                                    return;
                                }
                                break Label_0094;
                            }
                            catch (SecurityException ex) {
                                Log.d("DeviceInfo", "Unable to get Wifi connection information: %s", ex);
                                connectionInfo = null;
                                continue Label_0031;
                            }
                            catch (ExceptionInInitializerError exceptionInInitializerError) {
                                Log.d("DeviceInfo", "Unable to get Wifi connection information: %s", exceptionInInitializerError);
                            }
                            break;
                        }
                        final String macAddress = connectionInfo.getMacAddress();
                        if (macAddress == null || macAddress.length() == 0) {
                            this.sha1_mac = null;
                            this.bad_mac = true;
                            continue;
                        }
                        if (!Pattern.compile("((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})").matcher(macAddress).find()) {
                            this.sha1_mac = null;
                            this.bad_mac = true;
                            continue;
                        }
                        this.sha1_mac = Utils.getURLEncodedString(Utils.sha1(macAddress));
                        continue;
                    }
                }
            }
            WifiInfo connectionInfo = null;
            continue Label_0031;
        }
    }
    
    JSONObject toJsonObject(final String s) {
        final JSONObject dInfoProperty = this.getDInfoProperty();
        JSONUtils.put(dInfoProperty, "orientation", s);
        JSONUtils.put(dInfoProperty, "screenSize", this.getScreenSize(s).toString());
        JSONUtils.put(dInfoProperty, "connectionType", this.getConnectionType());
        return dInfoProperty;
    }
    
    public String toJsonString() {
        return this.toJsonObject(this.getOrientation()).toString();
    }
}
