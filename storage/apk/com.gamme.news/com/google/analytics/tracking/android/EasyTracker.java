// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import android.app.Activity;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.Timer;
import android.content.Context;
import java.util.Map;

public class EasyTracker extends Tracker
{
    private static final int DEFAULT_SAMPLE_RATE = 100;
    private static final String EASY_TRACKER_NAME = "easy_tracker";
    static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
    private static EasyTracker sInstance;
    private static String sResourcePackageName;
    private int mActivitiesActive;
    private final Map<String, String> mActivityNameMap;
    private Clock mClock;
    private Context mContext;
    private final GoogleAnalytics mGoogleAnalytics;
    private boolean mIsAutoActivityTracking;
    private boolean mIsInForeground;
    private boolean mIsReportUncaughtExceptionsEnabled;
    private long mLastOnStopTime;
    private ParameterLoader mParameterFetcher;
    private ServiceManager mServiceManager;
    private long mSessionTimeout;
    private boolean mStartSessionOnNextSend;
    private Timer mTimer;
    private TimerTask mTimerTask;
    
    private EasyTracker(final Context context) {
        this(context, new ParameterLoaderImpl(context), GoogleAnalytics.getInstance(context), GAServiceManager.getInstance(), null);
    }
    
    private EasyTracker(final Context context, final ParameterLoader parameterLoader, final GoogleAnalytics mGoogleAnalytics, final ServiceManager serviceManager, TrackerHandler trackerHandler) {
        if (trackerHandler == null) {
            trackerHandler = mGoogleAnalytics;
        }
        super("easy_tracker", null, trackerHandler);
        this.mIsAutoActivityTracking = false;
        this.mActivitiesActive = 0;
        this.mActivityNameMap = new HashMap<String, String>();
        this.mIsInForeground = false;
        this.mStartSessionOnNextSend = false;
        if (EasyTracker.sResourcePackageName != null) {
            parameterLoader.setResourcePackageName(EasyTracker.sResourcePackageName);
        }
        this.mGoogleAnalytics = mGoogleAnalytics;
        this.setContext(context, parameterLoader, serviceManager);
        this.mClock = new Clock() {
            @Override
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
    }
    
    private void clearExistingTimer() {
        synchronized (this) {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }
    }
    
    private String getActivityName(final Activity activity) {
        final String canonicalName = activity.getClass().getCanonicalName();
        if (this.mActivityNameMap.containsKey(canonicalName)) {
            return this.mActivityNameMap.get(canonicalName);
        }
        String string = this.mParameterFetcher.getString(canonicalName);
        if (string == null) {
            string = canonicalName;
        }
        this.mActivityNameMap.put(canonicalName, string);
        return string;
    }
    
    public static EasyTracker getInstance(final Context context) {
        if (EasyTracker.sInstance == null) {
            EasyTracker.sInstance = new EasyTracker(context);
        }
        return EasyTracker.sInstance;
    }
    
    private Logger.LogLevel getLogLevelFromString(final String s) {
        try {
            return Logger.LogLevel.valueOf(s.toUpperCase());
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
    }
    
    @VisibleForTesting
    static EasyTracker getNewInstance(final Context context, final ParameterLoader parameterLoader, final GoogleAnalytics googleAnalytics, final ServiceManager serviceManager, final TrackerHandler trackerHandler) {
        return EasyTracker.sInstance = new EasyTracker(context, parameterLoader, googleAnalytics, serviceManager, trackerHandler);
    }
    
    private void loadParameters() {
        Log.v("Starting EasyTracker.");
        String str = this.mParameterFetcher.getString("ga_trackingId");
        if (TextUtils.isEmpty((CharSequence)str)) {
            str = this.mParameterFetcher.getString("ga_api_key");
        }
        this.set("&tid", str);
        Log.v("[EasyTracker] trackingId loaded: " + str);
        final String string = this.mParameterFetcher.getString("ga_appName");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            Log.v("[EasyTracker] app name loaded: " + string);
            this.set("&an", string);
        }
        final String string2 = this.mParameterFetcher.getString("ga_appVersion");
        if (string2 != null) {
            Log.v("[EasyTracker] app version loaded: " + string2);
            this.set("&av", string2);
        }
        final String string3 = this.mParameterFetcher.getString("ga_logLevel");
        if (string3 != null) {
            final Logger.LogLevel logLevelFromString = this.getLogLevelFromString(string3);
            if (logLevelFromString != null) {
                Log.v("[EasyTracker] log level loaded: " + logLevelFromString);
                this.mGoogleAnalytics.getLogger().setLogLevel(logLevelFromString);
            }
        }
        Double doubleFromString = this.mParameterFetcher.getDoubleFromString("ga_sampleFrequency");
        if (doubleFromString == null) {
            doubleFromString = new Double(this.mParameterFetcher.getInt("ga_sampleRate", 100));
        }
        if (doubleFromString != 100.0) {
            this.set("&sf", Double.toString(doubleFromString));
        }
        Log.v("[EasyTracker] sample rate loaded: " + doubleFromString);
        final int int1 = this.mParameterFetcher.getInt("ga_dispatchPeriod", 1800);
        Log.v("[EasyTracker] dispatch period loaded: " + int1);
        this.mServiceManager.setLocalDispatchPeriod(int1);
        this.mSessionTimeout = 1000 * this.mParameterFetcher.getInt("ga_sessionTimeout", 30);
        Log.v("[EasyTracker] session timeout loaded: " + this.mSessionTimeout);
        this.mIsAutoActivityTracking = (this.mParameterFetcher.getBoolean("ga_autoActivityTracking") || this.mParameterFetcher.getBoolean("ga_auto_activity_tracking"));
        Log.v("[EasyTracker] auto activity tracking loaded: " + this.mIsAutoActivityTracking);
        final boolean boolean1 = this.mParameterFetcher.getBoolean("ga_anonymizeIp");
        if (boolean1) {
            this.set("&aip", "1");
            Log.v("[EasyTracker] anonymize ip loaded: " + boolean1);
        }
        this.mIsReportUncaughtExceptionsEnabled = this.mParameterFetcher.getBoolean("ga_reportUncaughtExceptions");
        if (this.mIsReportUncaughtExceptionsEnabled) {
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new ExceptionReporter(this, this.mServiceManager, Thread.getDefaultUncaughtExceptionHandler(), this.mContext));
            Log.v("[EasyTracker] report uncaught exceptions loaded: " + this.mIsReportUncaughtExceptionsEnabled);
        }
        this.mGoogleAnalytics.setDryRun(this.mParameterFetcher.getBoolean("ga_dryRun"));
    }
    
    private void setContext(final Context context, final ParameterLoader mParameterFetcher, final ServiceManager mServiceManager) {
        if (context == null) {
            Log.e("Context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.mServiceManager = mServiceManager;
        this.mParameterFetcher = mParameterFetcher;
        this.loadParameters();
    }
    
    public static void setResourcePackageName(final String sResourcePackageName) {
        EasyTracker.sResourcePackageName = sResourcePackageName;
    }
    
    public void activityStart(final Activity activity) {
        GAUsage.getInstance().setUsage(GAUsage.Field.EASY_TRACKER_ACTIVITY_START);
        this.clearExistingTimer();
        if (!this.mIsInForeground && this.mActivitiesActive == 0 && this.checkForNewSession()) {
            this.mStartSessionOnNextSend = true;
        }
        this.mIsInForeground = true;
        ++this.mActivitiesActive;
        if (this.mIsAutoActivityTracking) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("&t", "appview");
            GAUsage.getInstance().setDisableUsage(true);
            this.set("&cd", this.getActivityName(activity));
            this.send(hashMap);
            GAUsage.getInstance().setDisableUsage(false);
        }
    }
    
    public void activityStop(final Activity activity) {
        GAUsage.getInstance().setUsage(GAUsage.Field.EASY_TRACKER_ACTIVITY_STOP);
        --this.mActivitiesActive;
        this.mActivitiesActive = Math.max(0, this.mActivitiesActive);
        this.mLastOnStopTime = this.mClock.currentTimeMillis();
        if (this.mActivitiesActive == 0) {
            this.clearExistingTimer();
            this.mTimerTask = new NotInForegroundTimerTask();
            (this.mTimer = new Timer("waitForActivityStart")).schedule(this.mTimerTask, 1000L);
        }
    }
    
    boolean checkForNewSession() {
        return this.mSessionTimeout == 0L || (this.mSessionTimeout > 0L && this.mClock.currentTimeMillis() > this.mLastOnStopTime + this.mSessionTimeout);
    }
    
    @Deprecated
    public void dispatchLocalHits() {
        this.mServiceManager.dispatchLocalHits();
    }
    
    @VisibleForTesting
    int getActivitiesActive() {
        return this.mActivitiesActive;
    }
    
    @VisibleForTesting
    void overrideUncaughtExceptionHandler(final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler) {
        if (this.mIsReportUncaughtExceptionsEnabled) {
            Thread.setDefaultUncaughtExceptionHandler(defaultUncaughtExceptionHandler);
        }
    }
    
    @Override
    public void send(final Map<String, String> map) {
        if (this.mStartSessionOnNextSend) {
            map.put("&sc", "start");
            this.mStartSessionOnNextSend = false;
        }
        super.send(map);
    }
    
    @VisibleForTesting
    void setClock(final Clock mClock) {
        this.mClock = mClock;
    }
    
    private class NotInForegroundTimerTask extends TimerTask
    {
        @Override
        public void run() {
            EasyTracker.this.mIsInForeground = false;
        }
    }
}
