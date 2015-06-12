// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.flurry.android.FlurryAgent;
import java.util.Map;
import java.util.HashMap;

public class cx implements dq$a, UncaughtExceptionHandler
{
    private static final String a;
    private static cx b;
    private final HashMap c;
    private boolean d;
    
    static {
        a = cx.class.getSimpleName();
    }
    
    private cx() {
        this.c = new HashMap();
        ec.a().a(this);
        this.d();
    }
    
    public static cx a() {
        synchronized (cx.class) {
            if (cx.b == null) {
                cx.b = new cx();
            }
            return cx.b;
        }
    }
    
    private void d() {
        final dq a = dp.a();
        this.d = (boolean)a.a("CaptureUncaughtExceptions");
        a.a("CaptureUncaughtExceptions", this);
        eo.a(4, cx.a, "initSettings, CrashReportingEnabled = " + this.d);
        final String str = (String)a.a("VersionName");
        a.a("VersionName", this);
        eb.a(str);
        eo.a(4, cx.a, "initSettings, VersionName = " + str);
    }
    
    public void a(final String s) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, null, false);
        }
    }
    
    @Override
    public void a(final String s, final Object o) {
        if (s.equals("CaptureUncaughtExceptions")) {
            this.d = (boolean)o;
            eo.a(4, cx.a, "onSettingUpdate, CrashReportingEnabled = " + this.d);
            return;
        }
        if (s.equals("VersionName")) {
            final String str = (String)o;
            eb.a(str);
            eo.a(4, cx.a, "onSettingUpdate, VersionName = " + str);
            return;
        }
        eo.a(6, cx.a, "onSettingUpdate internal error!");
    }
    
    @Deprecated
    public void a(final String s, final String message, final String s2) {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement[] stackTrace2;
        if (stackTrace != null && stackTrace.length > 2) {
            stackTrace2 = new StackTraceElement[-2 + stackTrace.length];
            System.arraycopy(stackTrace, 2, stackTrace2, 0, stackTrace2.length);
        }
        else {
            stackTrace2 = stackTrace;
        }
        final Throwable t = new Throwable(message);
        t.setStackTrace(stackTrace2);
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, message, s2, t);
        }
    }
    
    public void a(final String s, final String s2, final Throwable t) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, s2, t.getClass().getName(), t);
        }
    }
    
    public void a(final String s, final String s2, Map value) {
        if (value == null) {
            value = new HashMap<String, String>();
        }
        if (value.size() >= 10) {
            eo.d(cx.a, "MaxOriginParams exceeded: " + value.size());
            return;
        }
        value.put("flurryOriginVersion", s2);
        synchronized (this.c) {
            if (this.c.size() >= 10 && !this.c.containsKey(s)) {
                eo.d(cx.a, "MaxOrigins exceeded: " + this.c.size());
                return;
            }
        }
        this.c.put(s, value);
    }
    // monitorexit(hashMap)
    
    public void a(final String s, final Map map) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, map, false);
        }
    }
    
    public void a(final String s, final Map map, final boolean b) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, map, b);
        }
    }
    
    public void a(final String s, final boolean b) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, null, b);
        }
    }
    
    public void a(final boolean b) {
        eo.a(b);
    }
    
    public HashMap b() {
        synchronized (this.c) {
            return new HashMap(this.c);
        }
    }
    
    public void b(final String s) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, null);
        }
    }
    
    public void b(final String s, final Map map) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, map);
        }
    }
    
    public void c() {
        final dj c = dl.a().c();
        if (c != null) {
            c.e();
        }
    }
    
    public void c(final String s) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, null, false);
        }
    }
    
    public void c(final String s, final Map map) {
        final dj c = dl.a().c();
        if (c != null) {
            c.a(s, map, false);
        }
    }
    
    @Override
    public void uncaughtException(final Thread thread, final Throwable t) {
        t.printStackTrace();
        if (this.d) {
            String s = "";
            final StackTraceElement[] stackTrace = t.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                final StringBuilder sb = new StringBuilder();
                if (t.getMessage() != null) {
                    sb.append(" (" + t.getMessage() + ")\n");
                }
                s = sb.toString();
            }
            else if (t.getMessage() != null) {
                s = t.getMessage();
            }
            FlurryAgent.onError("uncaught", s, t);
        }
        dl.a().d();
        dz.a().g();
    }
}
