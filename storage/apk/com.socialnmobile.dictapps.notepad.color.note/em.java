import android.text.TextUtils;
import java.util.Iterator;
import android.os.Bundle;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.flurry.android.monolithic.sdk.impl.jc;
import java.util.HashMap;
import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

public class em implements fl, ft, gk, UncaughtExceptionHandler
{
    private static final String a;
    private static em b;
    private String c;
    private boolean d;
    private fh e;
    private Map f;
    private es g;
    
    static {
        a = em.class.getSimpleName();
    }
    
    private em() {
        this.c = "";
        this.f = new HashMap();
        jc.a().a(this);
        final gc a = gc.a();
        synchronized (a.b) {
            a.b.put(this, null);
            // monitorexit(a.b)
            final fs a2 = fr.a();
            this.d = (boolean)a2.a("CaptureUncaughtExceptions");
            a2.a("CaptureUncaughtExceptions", this);
            final String a3 = em.a;
            gj.a(4, "initSettings, CrashReportingEnabled = " + this.d);
            final String str = (String)a2.a("VesionName");
            a2.a("VesionName", this);
            gb.a(str);
            final String a4 = em.a;
            gj.a(4, "initSettings, VersionName = " + str);
        }
    }
    
    public static em a() {
        if (em.b == null) {
            em.b = new em();
        }
        return em.b;
    }
    
    public static int b() {
        final int intValue = (int)fr.a().a("AgentVersion");
        final String a = em.a;
        gj.a(4, "getAgentVersion() = " + intValue);
        return intValue;
    }
    
    public static int e() {
        return 0;
    }
    
    public static Location f() {
        return fx.a().e();
    }
    
    public final void a(final Context context, final String s) {
        jc.a().b();
        fx.a().b();
        if (this.g == null) {
            this.g = new es();
        }
        if (this.f.isEmpty()) {
            fx.a().c();
        }
        fh e;
        if (this.f.containsKey(s)) {
            e = this.f.get(s);
        }
        else {
            final fh fh = new fh(context, s, this);
            final boolean b = context instanceof Activity;
            Map<String, ArrayList> map = null;
            if (b) {
                final Bundle extras = ((Activity)context).getIntent().getExtras();
                map = null;
                if (extras != null) {
                    final String a = em.a;
                    gj.a(3, "Launch Options Bundle is present " + extras.toString());
                    final HashMap<String, ArrayList> hashMap = new HashMap<String, ArrayList>();
                    for (final String str : extras.keySet()) {
                        if (str != null) {
                            final Object value = extras.get(str);
                            String string;
                            if (value != null) {
                                string = value.toString();
                            }
                            else {
                                string = "null";
                            }
                            hashMap.put(str, new ArrayList(Arrays.asList(string)));
                            final String a2 = em.a;
                            gj.a(3, "Launch options Key: " + str + ". Its value: " + string);
                        }
                    }
                    map = hashMap;
                }
            }
            fh.a(map);
            this.f.put(s, fh);
            e = fh;
        }
        e.b();
        this.e = e;
    }
    
    @Override
    public final void a(final String s) {
        if (!this.f.containsKey(s)) {
            final String a = em.a;
            gj.a(6, "Ended session is not in the session map! Maybe it was already destroyed.");
        }
        else {
            final fh e = this.e;
            if (e != null && TextUtils.equals((CharSequence)e.e(), (CharSequence)s)) {
                this.e = null;
            }
            this.f.remove(s);
        }
        if (this.f.isEmpty()) {
            final String a2 = em.a;
            gj.a(5, "LocationProvider is going to be unsubscribed");
            fx.a().d();
        }
    }
    
    @Override
    public final void a(final String s, final Object o) {
        if (s.equals("CaptureUncaughtExceptions")) {
            this.d = (boolean)o;
            final String a = em.a;
            gj.a(4, "onSettingUpdate, CrashReportingEnabled = " + this.d);
            return;
        }
        if (s.equals("VesionName")) {
            final String str = (String)o;
            gb.a(str);
            final String a2 = em.a;
            gj.a(4, "onSettingUpdate, VersionName = " + str);
            return;
        }
        final String a3 = em.a;
        gj.a(6, "onSettingUpdate internal error!");
    }
    
    public final void a(final String s, final String s2, final Throwable t) {
        final fh e = this.e;
        if (e != null) {
            e.a(s, s2, t.getClass().getName(), t);
        }
    }
    
    public final void a(final String s, final Map map) {
        final fh e = this.e;
        if (e != null) {
            e.a(s, map);
        }
    }
    
    @Override
    public final void a(final boolean b) {
    }
    
    public final void c() {
        final fh e = this.e;
        if (e != null) {
            e.c();
        }
    }
    
    public final fh d() {
        return this.e;
    }
    
    public final es g() {
        return this.g;
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
            eg.a("uncaught", s, t);
        }
        for (final fh fh : new HashMap<Object, fh>(this.f).values()) {
            if (fh != null) {
                fh.d();
            }
        }
        fx.a().f();
    }
}
