// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.util.Log;

public class LOG
{
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static int LOGLEVEL = 0;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    
    static {
        LOG.LOGLEVEL = 6;
    }
    
    public static void d(final String s, final String s2) {
        if (3 >= LOG.LOGLEVEL) {
            Log.d(s, s2);
        }
    }
    
    public static void d(final String s, final String s2, final Throwable t) {
        if (3 >= LOG.LOGLEVEL) {
            Log.d(s, s2, t);
        }
    }
    
    public static void d(final String s, final String format, final Object... args) {
        if (3 >= LOG.LOGLEVEL) {
            Log.d(s, String.format(format, args));
        }
    }
    
    public static void e(final String s, final String s2) {
        if (6 >= LOG.LOGLEVEL) {
            Log.e(s, s2);
        }
    }
    
    public static void e(final String s, final String s2, final Throwable t) {
        if (6 >= LOG.LOGLEVEL) {
            Log.e(s, s2, t);
        }
    }
    
    public static void e(final String s, final String format, final Object... args) {
        if (6 >= LOG.LOGLEVEL) {
            Log.e(s, String.format(format, args));
        }
    }
    
    public static void i(final String s, final String s2) {
        if (4 >= LOG.LOGLEVEL) {
            Log.i(s, s2);
        }
    }
    
    public static void i(final String s, final String s2, final Throwable t) {
        if (4 >= LOG.LOGLEVEL) {
            Log.i(s, s2, t);
        }
    }
    
    public static void i(final String s, final String format, final Object... args) {
        if (4 >= LOG.LOGLEVEL) {
            Log.i(s, String.format(format, args));
        }
    }
    
    public static boolean isLoggable(final int n) {
        return n >= LOG.LOGLEVEL;
    }
    
    public static void setLogLevel(final int n) {
        LOG.LOGLEVEL = n;
        Log.i("CordovaLog", "Changing log level to " + n);
    }
    
    public static void setLogLevel(final String s) {
        if ("VERBOSE".equals(s)) {
            LOG.LOGLEVEL = 2;
        }
        else if ("DEBUG".equals(s)) {
            LOG.LOGLEVEL = 3;
        }
        else if ("INFO".equals(s)) {
            LOG.LOGLEVEL = 4;
        }
        else if ("WARN".equals(s)) {
            LOG.LOGLEVEL = 5;
        }
        else if ("ERROR".equals(s)) {
            LOG.LOGLEVEL = 6;
        }
        Log.i("CordovaLog", "Changing log level to " + s + "(" + LOG.LOGLEVEL + ")");
    }
    
    public static void v(final String s, final String s2) {
        if (2 >= LOG.LOGLEVEL) {
            Log.v(s, s2);
        }
    }
    
    public static void v(final String s, final String s2, final Throwable t) {
        if (2 >= LOG.LOGLEVEL) {
            Log.v(s, s2, t);
        }
    }
    
    public static void v(final String s, final String format, final Object... args) {
        if (2 >= LOG.LOGLEVEL) {
            Log.v(s, String.format(format, args));
        }
    }
    
    public static void w(final String s, final String s2) {
        if (5 >= LOG.LOGLEVEL) {
            Log.w(s, s2);
        }
    }
    
    public static void w(final String s, final String s2, final Throwable t) {
        if (5 >= LOG.LOGLEVEL) {
            Log.w(s, s2, t);
        }
    }
    
    public static void w(final String s, final String format, final Object... args) {
        if (5 >= LOG.LOGLEVEL) {
            Log.w(s, String.format(format, args));
        }
    }
}
