// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.ArrayList;

class Log
{
    protected static final String LOGTAG = "AmazonMobileAds ";
    private static ILog logger;
    private static boolean loggingEnabled_;
    
    static {
        Log.loggingEnabled_ = false;
        Log.logger = new Log$LogcatLogger(null);
    }
    
    public static boolean canLog() {
        return Log.logger != null && DebugProperties.getDebugPropertyAsBoolean("debug.logging", Log.loggingEnabled_);
    }
    
    public static void d(final String s, final String s2) {
        d(false, s, s2);
    }
    
    public static void d(final String s, final String s2, final Object... array) {
        d(false, s, s2, array);
    }
    
    public static void d(final boolean b, final String str, final String s) {
        if (canLog() || b) {
            Log.logger.d("AmazonMobileAds " + str, s);
        }
    }
    
    public static void d(final boolean b, final String str, final String s, final Object... array) {
        if (canLog() || b) {
            Log.logger.d("AmazonMobileAds " + str, s, array);
        }
    }
    
    public static void e(final String s, final String s2) {
        e(false, s, s2);
    }
    
    public static void e(final String s, final String s2, final Object... array) {
        e(false, s, s2, array);
    }
    
    public static void e(final boolean b, final String str, final String s) {
        if (canLog() || b) {
            Log.logger.e("AmazonMobileAds " + str, s);
        }
    }
    
    public static void e(final boolean b, final String str, final String s, final Object... array) {
        if (canLog() || b) {
            Log.logger.e("AmazonMobileAds " + str, s, array);
        }
    }
    
    public static void enableLogging(final boolean loggingEnabled_) {
        Log.loggingEnabled_ = loggingEnabled_;
    }
    
    public static final void enableLoggingWithSetterNotification(final String s, final boolean b) {
        if (!b) {
            logSetterNotification(s, "Debug logging", b);
        }
        Log.loggingEnabled_ = b;
        if (b) {
            logSetterNotification(s, "Debug logging", b);
            d(false, s, "Amazon Mobile Ads API Version: %s", Version.getRawSDKVersion());
        }
    }
    
    public static ILog getLogger() {
        return Log.logger;
    }
    
    public static void i(final String s, final String s2) {
        i(false, s, s2);
    }
    
    public static void i(final String s, final String s2, final Object... array) {
        i(false, s, s2, array);
    }
    
    public static void i(final boolean b, final String str, final String s) {
        if (canLog() || b) {
            Log.logger.i("AmazonMobileAds " + str, s);
        }
    }
    
    public static void i(final boolean b, final String str, final String s, final Object... array) {
        if (canLog() || b) {
            Log.logger.i("AmazonMobileAds " + str, s, array);
        }
    }
    
    public static final void logSetterNotification(final String s, final String s2, final Object obj) {
        if (!canLog()) {
            return;
        }
        if (obj instanceof Boolean) {
            final Object[] array = { s2, null };
            String s3;
            if (obj) {
                s3 = "enabled";
            }
            else {
                s3 = "disabled";
            }
            array[1] = s3;
            d(false, s, "%s has been %s.", array);
            return;
        }
        d(false, s, "%s has been set: %s", s2, String.valueOf(obj));
    }
    
    public static void setLogger(final ILog logger) {
        Log.logger = logger;
    }
    
    static Iterable split(final String s, final int n) {
        final ArrayList<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return list;
        }
        for (int i = 0; i < s.length(); i += n) {
            list.add(s.substring(i, Math.min(s.length(), i + n)));
        }
        return list;
    }
    
    public static void v(final String s, final String s2) {
        v(false, s, s2);
    }
    
    public static void v(final String s, final String s2, final Object... array) {
        v(false, s, s2, array);
    }
    
    public static void v(final boolean b, final String str, final String s) {
        if (canLog() || b) {
            Log.logger.v("AmazonMobileAds " + str, s);
        }
    }
    
    public static void v(final boolean b, final String str, final String s, final Object... array) {
        if (canLog() || b) {
            Log.logger.v("AmazonMobileAds " + str, s, array);
        }
    }
    
    public static void w(final String s, final String s2) {
        w(false, s, s2);
    }
    
    public static void w(final String s, final String s2, final Object... array) {
        w(false, s, s2, array);
    }
    
    public static void w(final boolean b, final String str, final String s) {
        if (canLog() || b) {
            Log.logger.w("AmazonMobileAds " + str, s);
        }
    }
    
    public static void w(final boolean b, final String str, final String s, final Object... array) {
        if (canLog() || b) {
            Log.logger.w("AmazonMobileAds " + str, s, array);
        }
    }
}
