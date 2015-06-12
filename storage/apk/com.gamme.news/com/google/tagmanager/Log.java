// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

final class Log
{
    @VisibleForTesting
    static Logger sLogger;
    
    static {
        Log.sLogger = new DefaultLogger();
    }
    
    public static void d(final String s) {
        Log.sLogger.d(s);
    }
    
    public static void d(final String s, final Throwable t) {
        Log.sLogger.d(s, t);
    }
    
    public static void e(final String s) {
        Log.sLogger.e(s);
    }
    
    public static void e(final String s, final Throwable t) {
        Log.sLogger.e(s, t);
    }
    
    public static Logger.LogLevel getLogLevel() {
        return Log.sLogger.getLogLevel();
    }
    
    public static Logger getLogger() {
        if (Log.sLogger.getClass() == NoOpLogger.class) {
            return null;
        }
        return Log.sLogger;
    }
    
    public static void i(final String s) {
        Log.sLogger.i(s);
    }
    
    public static void i(final String s, final Throwable t) {
        Log.sLogger.i(s, t);
    }
    
    public static void setLogger(final Logger sLogger) {
        if (sLogger == null) {
            Log.sLogger = new NoOpLogger();
            return;
        }
        Log.sLogger = sLogger;
    }
    
    public static void v(final String s) {
        Log.sLogger.v(s);
    }
    
    public static void v(final String s, final Throwable t) {
        Log.sLogger.v(s, t);
    }
    
    public static void w(final String s) {
        Log.sLogger.w(s);
    }
    
    public static void w(final String s, final Throwable t) {
        Log.sLogger.w(s, t);
    }
}
