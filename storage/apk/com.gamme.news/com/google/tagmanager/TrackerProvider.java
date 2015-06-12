// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.tracking.android.Tracker;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.GoogleAnalytics;
import android.content.Context;

class TrackerProvider
{
    private Context mContext;
    private GoogleAnalytics mGoogleAnalytics;
    
    TrackerProvider(final Context mContext) {
        this.mContext = mContext;
    }
    
    TrackerProvider(final GoogleAnalytics mGoogleAnalytics) {
        (this.mGoogleAnalytics = mGoogleAnalytics).setLogger(new LoggerImpl());
    }
    
    private void initTrackProviderIfNecessary() {
        synchronized (this) {
            if (this.mGoogleAnalytics == null) {
                (this.mGoogleAnalytics = GoogleAnalytics.getInstance(this.mContext)).setLogger(new LoggerImpl());
            }
        }
    }
    
    public void close(final Tracker tracker) {
        this.mGoogleAnalytics.closeTracker(tracker.getName());
    }
    
    public Tracker getTracker(final String s) {
        this.initTrackProviderIfNecessary();
        return this.mGoogleAnalytics.getTracker(s);
    }
    
    static class LoggerImpl implements Logger
    {
        private static LogLevel toAnalyticsLogLevel(final com.google.tagmanager.Logger.LogLevel logLevel) {
            switch (logLevel) {
                default: {
                    return LogLevel.ERROR;
                }
                case NONE:
                case ERROR: {
                    return LogLevel.ERROR;
                }
                case WARNING: {
                    return LogLevel.WARNING;
                }
                case INFO:
                case DEBUG: {
                    return LogLevel.INFO;
                }
                case VERBOSE: {
                    return LogLevel.VERBOSE;
                }
            }
        }
        
        @Override
        public void error(final Exception ex) {
            Log.e("", ex);
        }
        
        @Override
        public void error(final String s) {
            Log.e(s);
        }
        
        @Override
        public LogLevel getLogLevel() {
            final com.google.tagmanager.Logger.LogLevel logLevel = Log.getLogLevel();
            if (logLevel == null) {
                return LogLevel.ERROR;
            }
            return toAnalyticsLogLevel(logLevel);
        }
        
        @Override
        public void info(final String s) {
            Log.i(s);
        }
        
        @Override
        public void setLogLevel(final LogLevel logLevel) {
            Log.w("GA uses GTM logger. Please use TagManager.getLogger().setLogLevel(LogLevel) instead.");
        }
        
        @Override
        public void verbose(final String s) {
            Log.v(s);
        }
        
        @Override
        public void warn(final String s) {
            Log.w(s);
        }
    }
}
