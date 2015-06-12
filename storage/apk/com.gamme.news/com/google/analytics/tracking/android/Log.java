// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

public class Log
{
    private static GoogleAnalytics sGaInstance;
    
    @VisibleForTesting
    static void clearGaInstance() {
        Log.sGaInstance = null;
    }
    
    public static void e(final Exception ex) {
        final Logger logger = getLogger();
        if (logger != null) {
            logger.error(ex);
        }
    }
    
    public static void e(final String s) {
        final Logger logger = getLogger();
        if (logger != null) {
            logger.error(s);
        }
    }
    
    private static Logger getLogger() {
        if (Log.sGaInstance == null) {
            Log.sGaInstance = GoogleAnalytics.getInstance();
        }
        if (Log.sGaInstance != null) {
            return Log.sGaInstance.getLogger();
        }
        return null;
    }
    
    public static void i(final String s) {
        final Logger logger = getLogger();
        if (logger != null) {
            logger.info(s);
        }
    }
    
    public static boolean isVerbose() {
        return getLogger() != null && Logger.LogLevel.VERBOSE.equals(getLogger().getLogLevel());
    }
    
    public static void v(final String s) {
        final Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(s);
        }
    }
    
    public static void w(final String s) {
        final Logger logger = getLogger();
        if (logger != null) {
            logger.warn(s);
        }
    }
}
