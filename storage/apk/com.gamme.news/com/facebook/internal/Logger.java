// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

import java.util.Iterator;
import java.util.Map;
import android.util.Log;
import com.facebook.Settings;
import com.facebook.LoggingBehavior;
import java.util.HashMap;

public class Logger
{
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    private static final HashMap<String, String> stringsToReplace;
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority;
    private final String tag;
    
    static {
        stringsToReplace = new HashMap<String, String>();
    }
    
    public Logger(final LoggingBehavior behavior, final String str) {
        this.priority = 3;
        Validate.notNullOrEmpty(str, "tag");
        this.behavior = behavior;
        this.tag = "FacebookSDK." + str;
        this.contents = new StringBuilder();
    }
    
    public static void log(final LoggingBehavior loggingBehavior, final int n, String string, final String s) {
        if (Settings.isLoggingBehaviorEnabled(loggingBehavior)) {
            final String replaceStrings = replaceStrings(s);
            if (!string.startsWith("FacebookSDK.")) {
                string = "FacebookSDK." + string;
            }
            Log.println(n, string, replaceStrings);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }
    
    public static void log(final LoggingBehavior loggingBehavior, final String s, final String s2) {
        log(loggingBehavior, 3, s, s2);
    }
    
    public static void log(final LoggingBehavior loggingBehavior, final String s, final String format, final Object... args) {
        if (Settings.isLoggingBehaviorEnabled(loggingBehavior)) {
            log(loggingBehavior, 3, s, String.format(format, args));
        }
    }
    
    public static void registerAccessToken(final String s) {
        synchronized (Logger.class) {
            if (!Settings.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(s, "ACCESS_TOKEN_REMOVED");
            }
        }
    }
    
    public static void registerStringToReplace(final String key, final String value) {
        synchronized (Logger.class) {
            Logger.stringsToReplace.put(key, value);
        }
    }
    
    private static String replaceStrings(String replace) {
        synchronized (Logger.class) {
            for (final Map.Entry<String, String> entry : Logger.stringsToReplace.entrySet()) {
                replace = replace.replace(entry.getKey(), entry.getValue());
            }
            return replace;
        }
    }
    
    private boolean shouldLog() {
        return Settings.isLoggingBehaviorEnabled(this.behavior);
    }
    
    public void append(final String str) {
        if (this.shouldLog()) {
            this.contents.append(str);
        }
    }
    
    public void append(final String format, final Object... args) {
        if (this.shouldLog()) {
            this.contents.append(String.format(format, args));
        }
    }
    
    public void append(final StringBuilder s) {
        if (this.shouldLog()) {
            this.contents.append((CharSequence)s);
        }
    }
    
    public void appendKeyValue(final String s, final Object o) {
        this.append("  %s:\t%s\n", s, o);
    }
    
    public String getContents() {
        return replaceStrings(this.contents.toString());
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    public void log() {
        this.logString(this.contents.toString());
        this.contents = new StringBuilder();
    }
    
    public void logString(final String s) {
        log(this.behavior, this.priority, this.tag, s);
    }
    
    public void setPriority(final int n) {
        Validate.oneOf(n, "value", 7, 3, 6, 4, 2, 5);
        this.priority = n;
    }
}
