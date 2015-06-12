// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import com.flurry.sdk.fe;
import android.location.Criteria;
import java.util.Date;
import com.flurry.sdk.dl;
import android.content.Context;
import com.flurry.sdk.dp;
import com.flurry.sdk.dn;
import com.flurry.sdk.dz;
import com.flurry.sdk.cx;
import com.flurry.sdk.eo;
import android.os.Build$VERSION;
import java.util.Map;

public final class FlurryAgent
{
    private static final String a;
    
    static {
        a = FlurryAgent.class.getSimpleName();
    }
    
    public static void addOrigin(final String s, final String s2) {
        addOrigin(s, s2, null);
    }
    
    public static void addOrigin(final String s, final String s2, final Map map) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("originName not specified");
        }
        if (s2 == null || s2.length() == 0) {
            throw new IllegalArgumentException("originVersion not specified");
        }
        try {
            cx.a().a(s, s2, map);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "", t);
        }
    }
    
    public static void clearLocation() {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dz.a().e();
    }
    
    public static void endTimedEvent(final String str) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            eo.b(FlurryAgent.a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try {
            cx.a().b(str);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "Failed to signify the end of event: " + str, t);
        }
    }
    
    public static void endTimedEvent(final String str, final Map map) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            eo.b(FlurryAgent.a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        if (map == null) {
            eo.b(FlurryAgent.a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try {
            cx.a().b(str, map);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "Failed to signify the end of event: " + str, t);
        }
    }
    
    public static int getAgentVersion() {
        return dn.a().b();
    }
    
    public static String getReleaseVersion() {
        return dn.a().g();
    }
    
    public static boolean getUseHttps() {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return false;
        }
        return (boolean)dp.a().a("UseHttps");
    }
    
    public static void logEvent(final String str) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            eo.b(FlurryAgent.a, "String eventId passed to logEvent was null.");
            return;
        }
        try {
            cx.a().a(str);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "Failed to log event: " + str, t);
        }
    }
    
    public static void logEvent(final String str, final Map map) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            eo.b(FlurryAgent.a, "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null) {
            eo.b(FlurryAgent.a, "String parameters passed to logEvent was null.");
            return;
        }
        try {
            cx.a().a(str, map);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "Failed to log event: " + str, t);
        }
    }
    
    public static void logEvent(final String str, final Map map, final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            eo.b(FlurryAgent.a, "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null) {
            eo.b(FlurryAgent.a, "String parameters passed to logEvent was null.");
            return;
        }
        try {
            cx.a().a(str, map, b);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "Failed to log event: " + str, t);
        }
    }
    
    public static void logEvent(final String str, final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            eo.b(FlurryAgent.a, "String eventId passed to logEvent was null.");
            return;
        }
        try {
            cx.a().a(str, b);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "Failed to log event: " + str, t);
        }
    }
    
    public static void onEndSession(final Context context) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        try {
            dl.a().a(context);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "", t);
        }
    }
    
    @Deprecated
    public static void onError(final String s, final String s2, final String s3) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (s == null) {
            eo.b(FlurryAgent.a, "String errorId passed to onError was null.");
            return;
        }
        if (s2 == null) {
            eo.b(FlurryAgent.a, "String message passed to onError was null.");
            return;
        }
        if (s3 == null) {
            eo.b(FlurryAgent.a, "String errorClass passed to onError was null.");
            return;
        }
        try {
            cx.a().a(s, s2, s3);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "", t);
        }
    }
    
    public static void onError(final String s, final String s2, final Throwable t) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (s == null) {
            eo.b(FlurryAgent.a, "String errorId passed to onError was null.");
            return;
        }
        if (s2 == null) {
            eo.b(FlurryAgent.a, "String message passed to onError was null.");
            return;
        }
        if (t == null) {
            eo.b(FlurryAgent.a, "Throwable passed to onError was null.");
            return;
        }
        try {
            cx.a().a(s, s2, t);
        }
        catch (Throwable t2) {
            eo.a(FlurryAgent.a, "", t2);
        }
    }
    
    @Deprecated
    public static void onEvent(final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (s == null) {
            eo.b(FlurryAgent.a, "String eventId passed to onEvent was null.");
            return;
        }
        try {
            cx.a().c(s);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "", t);
        }
    }
    
    @Deprecated
    public static void onEvent(final String s, final Map map) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (s == null) {
            eo.b(FlurryAgent.a, "String eventId passed to onEvent was null.");
            return;
        }
        if (map == null) {
            eo.b(FlurryAgent.a, "Parameters Map passed to onEvent was null.");
            return;
        }
        try {
            cx.a().c(s, map);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "", t);
        }
    }
    
    public static void onPageView() {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        try {
            cx.a().c();
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "", t);
        }
    }
    
    public static void onStartSession(final Context context, final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Api key not specified");
        }
        try {
            dl.a().a(context, s);
        }
        catch (Throwable t) {
            eo.a(FlurryAgent.a, "", t);
        }
    }
    
    public static void setAge(final int n) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
        }
        else if (n > 0 && n < 110) {
            dp.a().a("Age", new Date(new Date(System.currentTimeMillis() - 31449600000L * n).getYear(), 1, 1).getTime());
        }
    }
    
    public static void setCaptureUncaughtExceptions(final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dp.a().a("CaptureUncaughtExceptions", b);
    }
    
    public static void setContinueSessionMillis(final long n) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (n < 5000L) {
            eo.b(FlurryAgent.a, "Invalid time set for session resumption: " + n);
            return;
        }
        dp.a().a("ContinueSessionMillis", n);
    }
    
    public static void setGender(final byte b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        switch (b) {
            default: {
                dp.a().a("Gender", (byte)(-1));
            }
            case 0:
            case 1: {
                dp.a().a("Gender", b);
            }
        }
    }
    
    public static void setLocation(final float n, final float n2) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dz.a().a(n, n2);
    }
    
    public static void setLocationCriteria(final Criteria criteria) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dp.a().a("LocationCriteria", criteria);
    }
    
    public static void setLogEnabled(final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (b) {
            eo.b();
            return;
        }
        eo.a();
    }
    
    public static void setLogEvents(final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dp.a().a("LogEvents", b);
    }
    
    public static void setLogLevel(final int n) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        eo.a(n);
    }
    
    public static void setReportLocation(final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dp.a().a("ReportLocation", b);
    }
    
    public static void setReportUrl(final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dp.a().a("ReportUrl", s);
    }
    
    public static void setUseHttps(final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        dp.a().a("UseHttps", b);
    }
    
    public static void setUserId(final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (s == null) {
            eo.b(FlurryAgent.a, "String userId passed to setUserId was null.");
            return;
        }
        dp.a().a("UserId", fe.a(s));
    }
    
    public static void setVersionName(final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAgent.a, "Device SDK Version older than 10");
            return;
        }
        if (s == null) {
            eo.b(FlurryAgent.a, "String versionName passed to setVersionName was null.");
            return;
        }
        dp.a().a("VersionName", s);
    }
}
