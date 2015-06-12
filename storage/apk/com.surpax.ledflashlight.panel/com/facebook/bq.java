// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.lang.reflect.Field;
import android.os.AsyncTask;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import android.content.SharedPreferences$Editor;
import com.facebook.c.c;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
import com.facebook.c.d;
import com.facebook.b.a;
import java.net.HttpURLConnection;
import com.facebook.b.aj;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Collection;
import java.util.Arrays;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.Executor;
import java.util.HashSet;

public final class bq
{
    private static final String a;
    private static final HashSet b;
    private static volatile Executor c;
    private static volatile boolean d;
    private static volatile String e;
    private static volatile String f;
    private static volatile String g;
    private static volatile boolean h;
    private static volatile String i;
    private static AtomicLong j;
    private static volatile boolean k;
    private static volatile boolean l;
    private static final Object m;
    private static final Uri n;
    private static final BlockingQueue o;
    private static final ThreadFactory p;
    private static Boolean q;
    
    static {
        a = bq.class.getCanonicalName();
        b = new HashSet((Collection<? extends E>)Arrays.asList(ak.f));
        bq.h = false;
        bq.i = "facebook.com";
        bq.j = new AtomicLong(65536L);
        bq.l = true;
        m = new Object();
        n = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        o = new LinkedBlockingQueue(10);
        p = new ThreadFactory() {
            private final AtomicInteger a = new AtomicInteger(0);
            
            @Override
            public final Thread newThread(final Runnable target) {
                return new Thread(target, "FacebookSdk #" + this.a.incrementAndGet());
            }
        };
        bq.q = false;
    }
    
    static bb a(final Context context, final String s) {
        Label_0044: {
            if (context != null) {
                if (s != null) {
                    break Label_0044;
                }
            }
            try {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            catch (Exception ex) {
                aj.a("Facebook-publish", ex);
                return new bb(null, null, new ae(null, ex));
            }
        }
        final a a = com.facebook.b.a.a(context);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        final String string = String.valueOf(s) + "ping";
        final String string2 = String.valueOf(s) + "json";
        final long long1 = sharedPreferences.getLong(string, 0L);
        final String string3 = sharedPreferences.getString(string2, (String)null);
        final c a2 = com.facebook.c.d.a();
        a2.f();
        aj.a(a2, a, aj.a(context, s), a(context));
        true;
        a2.f();
        context.getPackageName();
        a2.f();
        final Request a3 = Request.a(String.format("%s/activities", s), a2);
        while (true) {
            Label_0277: {
                if (long1 == 0L) {
                    break Label_0277;
                }
                if (string3 == null) {
                    break Label_0277;
                }
                try {
                    final c a4 = com.facebook.c.d.a(new JSONObject(string3));
                    if (a4 == null) {
                        return (bb)bb.a("true", null, new aw(new Request[] { a3 }), true).get(0);
                    }
                    return new bb(null, null, null, a4, true);
                    // iftrue(Label_0305:, a != null && a.b() != null || a.a() != null)
                    // iftrue(Label_0400:, f.b() == null || f.b().d() == null)
                    while (true) {
                        final SharedPreferences$Editor edit;
                        final bb f;
                        edit.putString(string2, f.b().d().toString());
                        Label_0400: {
                            break Label_0400;
                            throw new ab("No attribution id available to send to server.");
                        }
                        edit.commit();
                        return f;
                        Label_0327: {
                            f = a3.f();
                        }
                        edit = sharedPreferences.edit();
                        edit.putLong(string, System.currentTimeMillis());
                        continue;
                    }
                    Label_0305: {
                        throw new ab("Install attribution has been disabled on the server.");
                    }
                }
                // iftrue(Label_0327:, aj.a(s, false).a())
                catch (JSONException ex2) {}
            }
            final c a4 = null;
            continue;
        }
    }
    
    public static final boolean a() {
        return bq.l;
    }
    
    public static boolean a(final Context context) {
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }
    
    public static final boolean a(final ak o) {
        synchronized (bq.b) {
            return bq.l && bq.b.contains(o);
        }
    }
    
    public static Executor b() {
        synchronized (bq.m) {
            if (bq.c == null) {
                Executor j = j();
                if (j == null) {
                    j = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, bq.o, bq.p);
                }
                bq.c = j;
            }
            return bq.c;
        }
    }
    
    public static void b(final Context context) {
        bq.h = true;
        if (context != null) {
            try {
                final ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (bq.f == null) {
                        bq.f = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationId");
                    }
                    if (bq.g == null) {
                        bq.g = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                }
            }
            catch (PackageManager$NameNotFoundException ex) {}
        }
    }
    
    public static String c() {
        return bq.i;
    }
    
    @Deprecated
    public static boolean d() {
        return bq.d;
    }
    
    public static String e() {
        return bq.e;
    }
    
    public static long f() {
        return bq.j.get();
    }
    
    public static boolean g() {
        return bq.k;
    }
    
    public static String h() {
        return bq.f;
    }
    
    public static String i() {
        return bq.g;
    }
    
    private static Executor j() {
        Object o3 = null;
        Label_0028: {
            Field field;
            try {
                final Field field2;
                field = (field2 = AsyncTask.class.getField("THREAD_POOL_EXECUTOR"));
                final Object o = null;
                final Object o2 = field2.get(o);
                final Object o4;
                o3 = (o4 = o2);
                if (o4 == null) {
                    return null;
                }
                break Label_0028;
            }
            catch (NoSuchFieldException ex) {
                return null;
            }
            try {
                final Field field2 = field;
                final Object o = null;
                final Object o2 = field2.get(o);
                final Object o4;
                o3 = (o4 = o2);
                if (o4 == null) {
                    return null;
                }
            }
            catch (IllegalAccessException ex2) {
                return null;
            }
        }
        if (!(o3 instanceof Executor)) {
            return null;
        }
        return (Executor)o3;
    }
}
