import android.content.Context;
import android.os.Looper;
import android.location.LocationListener;
import android.text.TextUtils;
import android.location.Location;
import android.location.Criteria;
import android.location.LocationManager;

// 
// Decompiled by Procyon v0.5.29
// 

public class fx implements ft
{
    private static final String c;
    private static fx l;
    boolean a;
    boolean b;
    private final long d;
    private final long e;
    private LocationManager f;
    private Criteria g;
    private Location h;
    private fy i;
    private String j;
    private int k;
    
    static {
        c = fx.class.getSimpleName();
    }
    
    private fx() {
        this.d = 1800000L;
        this.e = 0L;
        this.a = false;
        this.k = 0;
        this.i = new fy(this);
        final fs a = fr.a();
        this.g = (Criteria)a.a("LocationCriteria");
        a.a("LocationCriteria", this);
        final String c = fx.c;
        gj.a(4, "initSettings, LocationCriteria = " + this.g);
        this.b = (boolean)a.a("ReportLocation");
        a.a("ReportLocation", this);
        final String c2 = fx.c;
        gj.a(4, "initSettings, ReportLocation = " + this.b);
    }
    
    private Location a(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        Location lastKnownLocation = null;
        if (!empty) {
            lastKnownLocation = this.f.getLastKnownLocation(s);
        }
        return lastKnownLocation;
    }
    
    public static fx a() {
        synchronized (fx.class) {
            if (fx.l == null) {
                fx.l = new fx();
            }
            return fx.l;
        }
    }
    
    private void g() {
        this.f.removeUpdates((LocationListener)this.i);
        this.a = false;
        final String c = fx.c;
        gj.a(4, "LocationProvider stoped");
    }
    
    private void h() {
        if (this.b) {
            final Context b = fq.a.b;
            if (b.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.g();
                final String i = this.i();
                if (!TextUtils.isEmpty((CharSequence)i)) {
                    this.f.requestLocationUpdates(i, 1800000L, 0.0f, (LocationListener)this.i, Looper.getMainLooper());
                }
                this.h = this.a(i);
                this.a = true;
                final String c = fx.c;
                gj.a(4, "LocationProvider started");
            }
        }
    }
    
    private String i() {
        Criteria g = this.g;
        if (g == null) {
            g = new Criteria();
        }
        String str;
        if (TextUtils.isEmpty((CharSequence)this.j)) {
            str = this.f.getBestProvider(g, true);
        }
        else {
            str = this.j;
        }
        final String c = fx.c;
        gj.a(4, "provider = " + str);
        return str;
    }
    
    @Override
    public final void a(final String s, final Object o) {
        if (s.equals("LocationCriteria")) {
            this.g = (Criteria)o;
            final String c = fx.c;
            gj.a(4, "onSettingUpdate, LocationCriteria = " + this.g);
            if (this.a) {
                this.h();
            }
        }
        else {
            if (!s.equals("ReportLocation")) {
                final String c2 = fx.c;
                gj.a(6, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
                return;
            }
            this.b = (boolean)o;
            final String c3 = fx.c;
            gj.a(4, "onSettingUpdate, ReportLocation = " + this.b);
            if (!this.b) {
                this.g();
                return;
            }
            if (!this.a && this.k > 0) {
                this.h();
            }
        }
    }
    
    public final void b() {
        synchronized (this) {
            if (this.f == null) {
                this.f = (LocationManager)fq.a.b.getSystemService("location");
            }
        }
    }
    
    public final void c() {
        synchronized (this) {
            final String c = fx.c;
            gj.a(4, "Location provider subscribed");
            ++this.k;
            if (!this.a) {
                this.h();
            }
        }
    }
    
    public final void d() {
        synchronized (this) {
            final String c = fx.c;
            gj.a(4, "Location provider unsubscribed");
            if (this.k <= 0) {
                final String c2 = fx.c;
                gj.a(6, "Error! Unsubscribed too many times!");
                this.g();
            }
            else {
                --this.k;
                if (this.k == 0) {
                    this.g();
                }
            }
        }
    }
    
    public final Location e() {
        final boolean b = this.b;
        Object h = null;
        if (b) {
            final Location a = this.a(this.i());
            if (a != null) {
                this.h = a;
            }
            h = this.h;
        }
        final String c = fx.c;
        gj.a(4, "getLocation() = " + h);
        return (Location)h;
    }
    
    public final void f() {
        this.k = 0;
        this.g();
    }
}
