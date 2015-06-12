// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import java.util.Locale;
import android.util.Log;

public class y
{
    public static String a;
    public static boolean b;
    
    static {
        y.a = "Volley";
        y.b = Log.isLoggable(y.a, 2);
    }
    
    public static void a(final String s, final Object... array) {
        if (y.b) {
            Log.v(y.a, d(s, array));
        }
    }
    
    public static void a(final Throwable t, final String s, final Object... array) {
        Log.e(y.a, d(s, array), t);
    }
    
    public static void b(final String s, final Object... array) {
        Log.d(y.a, d(s, array));
    }
    
    public static void c(final String s, final Object... array) {
        Log.e(y.a, d(s, array));
    }
    
    private static String d(String format, final Object... args) {
        if (args != null) {
            format = String.format(Locale.US, format, args);
        }
        final StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; ++i) {
            if (!stackTrace[i].getClass().equals(y.class)) {
                final String className = stackTrace[i].getClassName();
                final String substring = className.substring(1 + className.lastIndexOf(46));
                final String string = substring.substring(1 + substring.lastIndexOf(36)) + "." + stackTrace[i].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread().getId(), string, format);
            }
        }
        final String string = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread().getId(), string, format);
    }
}
