// 
// Decompiled by Procyon v0.5.29
// 

package com.danielcwilson.plugins.analytics;

import org.json.JSONException;
import org.json.JSONArray;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.MapBuilder;
import android.content.Context;
import com.google.analytics.tracking.android.GoogleAnalytics;
import java.util.Iterator;
import com.google.analytics.tracking.android.Fields;
import java.util.Map;
import com.google.analytics.tracking.android.Tracker;
import org.apache.cordova.CallbackContext;
import java.util.HashMap;
import org.apache.cordova.CordovaPlugin;

public class UniversalAnalyticsPlugin extends CordovaPlugin
{
    public static final String ADD_DIMENSION = "addCustomDimension";
    public static final String ADD_TRANSACTION = "addTransaction";
    public static final String ADD_TRANSACTION_ITEM = "addTransactionItem";
    public static final String DEBUG_MODE = "debugMode";
    public static final String SET_USER_ID = "setUserId";
    public static final String START_TRACKER = "startTrackerWithId";
    public static final String TRACK_EVENT = "trackEvent";
    public static final String TRACK_TIMING = "trackTiming";
    public static final String TRACK_VIEW = "trackView";
    public HashMap<String, String> customDimensions;
    public Boolean debugModeEnabled;
    public Boolean trackerStarted;
    
    public UniversalAnalyticsPlugin() {
        this.trackerStarted = false;
        this.debugModeEnabled = false;
        this.customDimensions = new HashMap<String, String>();
    }
    
    private void addCustomDimension(final String key, final String value, final CallbackContext callbackContext) {
        if (key != null && key.length() > 0 && value != null && value.length() > 0) {
            this.customDimensions.put(key, value);
            return;
        }
        callbackContext.error("Expected non-empty string arguments.");
    }
    
    private void addCustomDimensionsToTracker(final Tracker tracker) {
        for (final Map.Entry<String, String> entry : this.customDimensions.entrySet()) {
            tracker.set(Fields.customDimension(Integer.parseInt(entry.getKey())), entry.getValue());
        }
    }
    
    private void addTransaction(final String str, final String s, final double d, final double d2, final double d3, final String s2, final CallbackContext callbackContext) {
        if (!this.trackerStarted) {
            callbackContext.error("Tracker not started");
            return;
        }
        final Tracker defaultTracker = GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getDefaultTracker();
        this.addCustomDimensionsToTracker(defaultTracker);
        if (str != null && str.length() > 0) {
            defaultTracker.send(MapBuilder.createTransaction(str, s, d, d2, d3, s2).build());
            callbackContext.success("Add Transaction: " + str);
            return;
        }
        callbackContext.error("Expected non-empty ID.");
    }
    
    private void addTransactionItem(final String str, final String s, final String s2, final String s3, final double d, final long l, final String s4, final CallbackContext callbackContext) {
        if (!this.trackerStarted) {
            callbackContext.error("Tracker not started");
            return;
        }
        final Tracker defaultTracker = GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getDefaultTracker();
        this.addCustomDimensionsToTracker(defaultTracker);
        if (str != null && str.length() > 0) {
            defaultTracker.send(MapBuilder.createItem(str, s, s2, s3, d, l, s4).build());
            callbackContext.success("Add Transaction Item: " + str);
            return;
        }
        callbackContext.error("Expected non-empty ID.");
    }
    
    private void debugMode(final CallbackContext callbackContext) {
        GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
        this.debugModeEnabled = true;
        callbackContext.success("debugMode enabled");
    }
    
    private void setUserId(final String str, final CallbackContext callbackContext) {
        if (!this.trackerStarted) {
            callbackContext.error("Tracker not started");
            return;
        }
        GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getDefaultTracker().set("&uid", str);
        callbackContext.success("Set user id" + str);
    }
    
    private void startTracker(final String s, final CallbackContext callbackContext) {
        if (s != null && s.length() > 0) {
            GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getTracker(s);
            callbackContext.success("tracker started");
            this.trackerStarted = true;
            GAServiceManager.getInstance().setLocalDispatchPeriod(30);
            return;
        }
        callbackContext.error("tracker id is not valid");
    }
    
    private void trackEvent(final String str, final String s, final String s2, final long l, final CallbackContext callbackContext) {
        if (!this.trackerStarted) {
            callbackContext.error("Tracker not started");
            return;
        }
        final Tracker defaultTracker = GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getDefaultTracker();
        this.addCustomDimensionsToTracker(defaultTracker);
        if (str != null && str.length() > 0) {
            defaultTracker.send(MapBuilder.createEvent(str, s, s2, l).build());
            callbackContext.success("Track Event: " + str);
            return;
        }
        callbackContext.error("Expected non-empty string arguments.");
    }
    
    private void trackTiming(final String str, final long l, final String s, final String s2, final CallbackContext callbackContext) {
        if (!this.trackerStarted) {
            callbackContext.error("Tracker not started");
            return;
        }
        final Tracker defaultTracker = GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getDefaultTracker();
        this.addCustomDimensionsToTracker(defaultTracker);
        if (str != null && str.length() > 0) {
            defaultTracker.send(MapBuilder.createTiming(str, l, s, s2).build());
            callbackContext.success("Track Timing: " + str);
            return;
        }
        callbackContext.error("Expected non-empty string arguments.");
    }
    
    private void trackView(final String str, final CallbackContext callbackContext) {
        if (!this.trackerStarted) {
            callbackContext.error("Tracker not started");
            return;
        }
        final Tracker defaultTracker = GoogleAnalytics.getInstance((Context)this.cordova.getActivity()).getDefaultTracker();
        this.addCustomDimensionsToTracker(defaultTracker);
        if (str != null && str.length() > 0) {
            defaultTracker.set("&cd", str);
            defaultTracker.send(MapBuilder.createAppView().build());
            callbackContext.success("Track Screen: " + str);
            return;
        }
        callbackContext.error("Expected one non-empty string argument.");
    }
    
    @Override
    public boolean execute(final String anObject, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        if ("startTrackerWithId".equals(anObject)) {
            this.startTracker(jsonArray.getString(0), callbackContext);
            return true;
        }
        if ("trackView".equals(anObject)) {
            this.trackView(jsonArray.getString(0), callbackContext);
            return true;
        }
        if ("trackEvent".equals(anObject)) {
            final int length = jsonArray.length();
            if (length > 0) {
                final String string = jsonArray.getString(0);
                String string2;
                if (length > 1) {
                    string2 = jsonArray.getString(1);
                }
                else {
                    string2 = "";
                }
                String string3;
                if (length > 2) {
                    string3 = jsonArray.getString(2);
                }
                else {
                    string3 = "";
                }
                long long1;
                if (length > 3) {
                    long1 = jsonArray.getLong(3);
                }
                else {
                    long1 = 0L;
                }
                this.trackEvent(string, string2, string3, long1, callbackContext);
            }
            return true;
        }
        if ("trackTiming".equals(anObject)) {
            final int length2 = jsonArray.length();
            if (length2 > 0) {
                final String string4 = jsonArray.getString(0);
                long long2;
                if (length2 > 1) {
                    long2 = jsonArray.getLong(1);
                }
                else {
                    long2 = 0L;
                }
                String string5;
                if (length2 > 2) {
                    string5 = jsonArray.getString(2);
                }
                else {
                    string5 = "";
                }
                String string6;
                if (length2 > 3) {
                    string6 = jsonArray.getString(3);
                }
                else {
                    string6 = "";
                }
                this.trackTiming(string4, long2, string5, string6, callbackContext);
            }
            return true;
        }
        if ("addCustomDimension".equals(anObject)) {
            this.addCustomDimension(jsonArray.getString(0), jsonArray.getString(1), callbackContext);
            return true;
        }
        if ("addTransaction".equals(anObject)) {
            final int length3 = jsonArray.length();
            if (length3 > 0) {
                final String string7 = jsonArray.getString(0);
                String string8;
                if (length3 > 1) {
                    string8 = jsonArray.getString(1);
                }
                else {
                    string8 = "";
                }
                double double1;
                if (length3 > 2) {
                    double1 = jsonArray.getDouble(2);
                }
                else {
                    double1 = 0.0;
                }
                double double2;
                if (length3 > 3) {
                    double2 = jsonArray.getDouble(3);
                }
                else {
                    double2 = 0.0;
                }
                double double3;
                if (length3 > 4) {
                    double3 = jsonArray.getDouble(4);
                }
                else {
                    double3 = 0.0;
                }
                String string9;
                if (length3 > 5) {
                    string9 = jsonArray.getString(5);
                }
                else {
                    string9 = null;
                }
                this.addTransaction(string7, string8, double1, double2, double3, string9, callbackContext);
            }
            return true;
        }
        if ("addTransactionItem".equals(anObject)) {
            final int length4 = jsonArray.length();
            if (length4 > 0) {
                final String string10 = jsonArray.getString(0);
                String string11;
                if (length4 > 1) {
                    string11 = jsonArray.getString(1);
                }
                else {
                    string11 = "";
                }
                String string12;
                if (length4 > 2) {
                    string12 = jsonArray.getString(2);
                }
                else {
                    string12 = "";
                }
                String string13;
                if (length4 > 3) {
                    string13 = jsonArray.getString(3);
                }
                else {
                    string13 = "";
                }
                double double4;
                if (length4 > 4) {
                    double4 = jsonArray.getDouble(4);
                }
                else {
                    double4 = 0.0;
                }
                long long3;
                if (length4 > 5) {
                    long3 = jsonArray.getLong(5);
                }
                else {
                    long3 = 0L;
                }
                String string14;
                if (length4 > 6) {
                    string14 = jsonArray.getString(6);
                }
                else {
                    string14 = null;
                }
                this.addTransactionItem(string10, string11, string12, string13, double4, long3, string14, callbackContext);
            }
            return true;
        }
        if ("setUserId".equals(anObject)) {
            this.setUserId(jsonArray.getString(0), callbackContext);
        }
        else if ("debugMode".equals(anObject)) {
            this.debugMode(callbackContext);
        }
        return false;
    }
}
