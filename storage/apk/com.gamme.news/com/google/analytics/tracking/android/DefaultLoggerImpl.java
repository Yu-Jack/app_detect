// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

class DefaultLoggerImpl implements Logger
{
    @VisibleForTesting
    static final String LOG_TAG = "GAV3";
    private LogLevel mLogLevel;
    
    DefaultLoggerImpl() {
        this.mLogLevel = LogLevel.INFO;
    }
    
    private String formatMessage(final String str) {
        return Thread.currentThread().toString() + ": " + str;
    }
    
    @Override
    public void error(final Exception ex) {
        if (this.mLogLevel.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GAV3", (String)null, (Throwable)ex);
        }
    }
    
    @Override
    public void error(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GAV3", this.formatMessage(s));
        }
    }
    
    @Override
    public LogLevel getLogLevel() {
        return this.mLogLevel;
    }
    
    @Override
    public void info(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i("GAV3", this.formatMessage(s));
        }
    }
    
    @Override
    public void setLogLevel(final LogLevel mLogLevel) {
        this.mLogLevel = mLogLevel;
    }
    
    @Override
    public void verbose(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v("GAV3", this.formatMessage(s));
        }
    }
    
    @Override
    public void warn(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w("GAV3", this.formatMessage(s));
        }
    }
}
