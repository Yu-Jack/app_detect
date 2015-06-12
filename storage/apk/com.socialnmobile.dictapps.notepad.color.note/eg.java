import java.util.Map;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class eg
{
    private static final String a;
    
    static {
        a = eg.class.getSimpleName();
    }
    
    public static int a() {
        em.a();
        return em.b();
    }
    
    public static void a(final Context context) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        try {
            em.a().c();
        }
        catch (Throwable t) {
            final String a = eg.a;
            gj.a("", t);
        }
    }
    
    public static void a(final Context context, final String s) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Api key not specified");
        }
        fq.a(context);
        try {
            em.a().a(context, s);
        }
        catch (Throwable t) {
            final String a = eg.a;
            gj.a("", t);
        }
    }
    
    public static void a(final String s, final String s2, final Throwable t) {
        if (s == null) {
            final String a = eg.a;
            gj.b("String errorId passed to onError was null.");
            return;
        }
        if (s2 == null) {
            final String a2 = eg.a;
            gj.b("String message passed to onError was null.");
            return;
        }
        if (t == null) {
            final String a3 = eg.a;
            gj.b("Throwable passed to onError was null.");
            return;
        }
        try {
            em.a().a(s, s2, t);
        }
        catch (Throwable t2) {
            final String a4 = eg.a;
            gj.a("", t2);
        }
    }
    
    public static void a(final String str, final Map map) {
        if (str == null) {
            final String a = eg.a;
            gj.b("String eventId passed to logEvent was null.");
            return;
        }
        if (map == null) {
            final String a2 = eg.a;
            gj.b("String parameters passed to logEvent was null.");
            return;
        }
        try {
            em.a().a(str, map);
        }
        catch (Throwable t) {
            final String a3 = eg.a;
            gj.a("Failed to log event: " + str, t);
        }
    }
    
    public static void b() {
        gj.a();
    }
    
    public static void c() {
        gj.c();
    }
    
    public static void d() {
        fr.a().a("CaptureUncaughtExceptions", false);
    }
}
