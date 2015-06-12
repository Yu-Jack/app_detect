import android.location.Criteria;

// 
// Decompiled by Procyon v0.5.29
// 

public final class fr
{
    public static final Integer a;
    public static final String b;
    public static final Boolean c;
    public static final Boolean d;
    public static final String e;
    public static final Boolean f;
    public static final Criteria g;
    public static final Long h;
    public static final Boolean i;
    public static final Long j;
    public static final Byte k;
    private static fs l;
    
    static {
        a = 151;
        b = null;
        c = true;
        d = false;
        e = null;
        f = true;
        g = null;
        h = 10000L;
        i = true;
        j = 0L;
        k = -1;
    }
    
    public static fs a() {
        synchronized (fr.class) {
            if (fr.l == null) {
                (fr.l = new fs()).a("AgentVersion", fr.a);
                fr.l.a("VesionName", fr.b);
                fr.l.a("CaptureUncaughtExceptions", fr.c);
                fr.l.a("UseHttps", fr.d);
                fr.l.a("ReportUrl", fr.e);
                fr.l.a("ReportLocation", fr.f);
                fr.l.a("LocationCriteria", fr.g);
                fr.l.a("ContinueSessionMillis", fr.h);
                fr.l.a("LogEvents", fr.i);
                fr.l.a("Age", fr.j);
                fr.l.a("Gender", fr.k);
                fr.l.a("UserId", "");
            }
            return fr.l;
        }
    }
}
