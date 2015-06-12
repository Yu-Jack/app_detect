// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.content.pm.ActivityInfo;
import java.util.Collection;
import android.content.Context;
import java.util.HashSet;

class AdUtils
{
    public static final String LOG_TAG;
    public static final String REQUIRED_ACTIVITY = "com.amazon.device.ads.AdActivity";
    private static final HashSet requiredActivities;
    
    static {
        LOG_TAG = AdUtils.class.getSimpleName();
        (requiredActivities = new HashSet()).add("com.amazon.device.ads.AdActivity");
    }
    
    public static boolean checkDefinedActivities(final Context context) {
        boolean containsAll = true;
        final HashSet<String> set = new HashSet<String>();
        try {
            if (Utils.isAtLeastAndroidAPI(8)) {
                final ActivityInfo[] activities = context.getPackageManager().getPackageArchiveInfo(AndroidTargetUtils.getPackageCodePath(context), 1).activities;
                for (int length = activities.length, i = 0; i < length; ++i) {
                    set.add(activities[i].name);
                }
                containsAll = set.containsAll(AdUtils.requiredActivities);
            }
            return containsAll;
        }
        catch (Exception ex) {
            return containsAll;
        }
    }
    
    public static String encloseHtml(String s, final boolean b) {
        if (s != null) {
            if (s.indexOf("<html>") == -1) {
                s = "<html>" + s + "</html>";
            }
            if (b && s.indexOf("<!DOCTYPE html>") == -1) {
                s = "<!DOCTYPE html>" + s;
            }
        }
        return s;
    }
    
    public static double getViewportInitialScale(double n) {
        if (Utils.isAtLeastAndroidAPI(19)) {
            n = 1.0;
        }
        return n;
    }
    
    public static boolean launchActivityForIntentLink(String s, final Context context) {
        if (s == null || s.equals("")) {
            s = "about:blank";
        }
        Log.d(AdUtils.LOG_TAG, "Launch Intent: %s", s);
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        }
        catch (ActivityNotFoundException ex) {
            final String action = intent.getAction();
            final String log_TAG = AdUtils.LOG_TAG;
            final Object[] array = new Object[2];
            String s2;
            if (action.startsWith("market://")) {
                s2 = "market";
            }
            else {
                s2 = "intent";
            }
            array[0] = s2;
            array[1] = action;
            Log.w(log_TAG, "Could not handle %s action: %s", array);
            return false;
        }
    }
    
    public static void setConnectionMetrics(final AdData adData) {
        final String connectionType = adData.getConnectionType();
        if ("Wifi".equals(connectionType)) {
            adData.getMetricsCollector().incrementMetric(Metrics$MetricType.WIFI_PRESENT);
        }
        else {
            adData.getMetricsCollector().setMetricString(Metrics$MetricType.CONNECTION_TYPE, connectionType);
        }
        final DeviceInfo deviceInfo = InternalAdRegistration.getInstance().getDeviceInfo();
        if (deviceInfo.getCarrier() != null) {
            adData.getMetricsCollector().setMetricString(Metrics$MetricType.CARRIER_NAME, deviceInfo.getCarrier());
        }
    }
}
