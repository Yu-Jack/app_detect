// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.util.Locale;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;

public class GoogleAnalytics extends TrackerHandler
{
    private static GoogleAnalytics sInstance;
    private volatile Boolean mAppOptOut;
    private Context mContext;
    private Tracker mDefaultTracker;
    private boolean mDryRun;
    private Logger mLogger;
    private AnalyticsThread mThread;
    private final Map<String, Tracker> mTrackers;
    
    protected GoogleAnalytics(final Context context) {
        this(context, GAThread.getInstance(context));
    }
    
    private GoogleAnalytics(final Context context, final AnalyticsThread mThread) {
        this.mAppOptOut = false;
        this.mTrackers = new HashMap<String, Tracker>();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.mThread = mThread;
        AppFieldsDefaultProvider.initializeProvider(this.mContext);
        ScreenResolutionDefaultProvider.initializeProvider(this.mContext);
        ClientIdDefaultProvider.initializeProvider(this.mContext);
        this.mLogger = new DefaultLoggerImpl();
    }
    
    @VisibleForTesting
    static void clearDefaultProviders() {
        AppFieldsDefaultProvider.dropInstance();
        ScreenResolutionDefaultProvider.dropInstance();
        ClientIdDefaultProvider.dropInstance();
    }
    
    @VisibleForTesting
    static void clearInstance() {
        synchronized (GoogleAnalytics.class) {
            GoogleAnalytics.sInstance = null;
            clearDefaultProviders();
        }
    }
    
    static GoogleAnalytics getInstance() {
        synchronized (GoogleAnalytics.class) {
            return GoogleAnalytics.sInstance;
        }
    }
    
    public static GoogleAnalytics getInstance(final Context context) {
        synchronized (GoogleAnalytics.class) {
            if (GoogleAnalytics.sInstance == null) {
                GoogleAnalytics.sInstance = new GoogleAnalytics(context);
            }
            return GoogleAnalytics.sInstance;
        }
    }
    
    @VisibleForTesting
    static GoogleAnalytics getNewInstance(final Context context, final AnalyticsThread analyticsThread) {
        synchronized (GoogleAnalytics.class) {
            if (GoogleAnalytics.sInstance != null) {
                GoogleAnalytics.sInstance.close();
            }
            return GoogleAnalytics.sInstance = new GoogleAnalytics(context, analyticsThread);
        }
    }
    
    @VisibleForTesting
    void close() {
    }
    
    public void closeTracker(final String s) {
        synchronized (this) {
            GAUsage.getInstance().setUsage(GAUsage.Field.CLOSE_TRACKER);
            if (this.mTrackers.remove(s) == this.mDefaultTracker) {
                this.mDefaultTracker = null;
            }
        }
    }
    
    public boolean getAppOptOut() {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_OPT_OUT);
        return this.mAppOptOut;
    }
    
    public Tracker getDefaultTracker() {
        synchronized (this) {
            GAUsage.getInstance().setUsage(GAUsage.Field.GET_DEFAULT_TRACKER);
            return this.mDefaultTracker;
        }
    }
    
    public Logger getLogger() {
        return this.mLogger;
    }
    
    public Tracker getTracker(final String s) {
        return this.getTracker(s, s);
    }
    
    public Tracker getTracker(final String s, final String s2) {
        synchronized (this) {
            if (TextUtils.isEmpty((CharSequence)s)) {
                throw new IllegalArgumentException("Tracker name cannot be empty");
            }
        }
        Tracker mDefaultTracker = this.mTrackers.get(s);
        if (mDefaultTracker == null) {
            mDefaultTracker = new Tracker(s, s2, this);
            this.mTrackers.put(s, mDefaultTracker);
            if (this.mDefaultTracker == null) {
                this.mDefaultTracker = mDefaultTracker;
            }
        }
        if (!TextUtils.isEmpty((CharSequence)s2)) {
            mDefaultTracker.set("&tid", s2);
        }
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER);
        // monitorexit(this)
        return mDefaultTracker;
    }
    
    public boolean isDryRunEnabled() {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_DRY_RUN);
        return this.mDryRun;
    }
    
    @Override
    void sendHit(final Map<String, String> map) {
        // monitorenter(this)
        if (map == null) {
            try {
                throw new IllegalArgumentException("hit cannot be null");
            }
            finally {
            }
            // monitorexit(this)
        }
        Utils.putIfAbsent(map, "&ul", Utils.getLanguage(Locale.getDefault()));
        Utils.putIfAbsent(map, "&sr", ScreenResolutionDefaultProvider.getProvider().getValue("&sr"));
        map.put("&_u", GAUsage.getInstance().getAndClearSequence());
        GAUsage.getInstance().getAndClearUsage();
        this.mThread.sendHit(map);
    }
    // monitorexit(this)
    
    public void setAppOptOut(final boolean b) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_OPT_OUT);
        this.mAppOptOut = b;
        if (this.mAppOptOut) {
            this.mThread.clearHits();
        }
    }
    
    public void setDefaultTracker(final Tracker mDefaultTracker) {
        synchronized (this) {
            GAUsage.getInstance().setUsage(GAUsage.Field.SET_DEFAULT_TRACKER);
            this.mDefaultTracker = mDefaultTracker;
        }
    }
    
    public void setDryRun(final boolean mDryRun) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_DRY_RUN);
        this.mDryRun = mDryRun;
    }
    
    public void setLogger(final Logger mLogger) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_LOGGER);
        this.mLogger = mLogger;
    }
}
