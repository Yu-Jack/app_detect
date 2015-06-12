// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.util.Log;

class DefaultLogger implements Logger
{
    private static final String LOG_TAG = "GoogleTagManager";
    private LogLevel mLogLevel;
    
    DefaultLogger() {
        this.mLogLevel = LogLevel.WARNING;
    }
    
    @Override
    public void d(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.DEBUG.ordinal()) {
            Log.d("GoogleTagManager", s);
        }
    }
    
    @Override
    public void d(final String s, final Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.DEBUG.ordinal()) {
            Log.d("GoogleTagManager", s, t);
        }
    }
    
    @Override
    public void e(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GoogleTagManager", s);
        }
    }
    
    @Override
    public void e(final String s, final Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GoogleTagManager", s, t);
        }
    }
    
    @Override
    public LogLevel getLogLevel() {
        return this.mLogLevel;
    }
    
    @Override
    public void i(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i("GoogleTagManager", s);
        }
    }
    
    @Override
    public void i(final String s, final Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i("GoogleTagManager", s, t);
        }
    }
    
    @Override
    public void setLogLevel(final LogLevel mLogLevel) {
        this.mLogLevel = mLogLevel;
    }
    
    @Override
    public void v(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v("GoogleTagManager", s);
        }
    }
    
    @Override
    public void v(final String s, final Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v("GoogleTagManager", s, t);
        }
    }
    
    @Override
    public void w(final String s) {
        if (this.mLogLevel.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w("GoogleTagManager", s);
        }
    }
    
    @Override
    public void w(final String s, final Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w("GoogleTagManager", s, t);
        }
    }
}
