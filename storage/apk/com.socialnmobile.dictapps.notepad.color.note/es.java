import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import com.flurry.android.monolithic.sdk.impl.jc;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.Set;

// 
// Decompiled by Procyon v0.5.29
// 

public class es implements ft, gk
{
    static String a;
    static String b;
    static String c;
    private static final String f;
    fe d;
    Set e;
    private boolean g;
    private ExecutorService h;
    private ExecutorService i;
    
    static {
        f = es.class.getSimpleName();
        es.b = "http://data.flurry.com/aap.do";
        es.c = "https://data.flurry.com/aap.do";
    }
    
    public es() {
        this((byte)0);
    }
    
    private es(final byte b) {
        this.e = new HashSet();
        jc.a().a(this);
        this.h = Executors.newSingleThreadExecutor();
        this.i = Executors.newCachedThreadPool();
        final fs a = fr.a();
        this.g = (boolean)a.a("UseHttps");
        a.a("UseHttps", this);
        final String f = es.f;
        gj.a(4, "initSettings, UseHttps = " + this.g);
        final String str = (String)a.a("ReportUrl");
        a.a("ReportUrl", this);
        a(str);
        final String f2 = es.f;
        gj.a(4, "initSettings, ReportUrl = " + str);
        this.h.submit(new et(this));
        this.c();
    }
    
    private static void a(final String a) {
        if (a != null && !a.endsWith(".do")) {
            final String f = es.f;
            gj.a(5, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        es.a = a;
    }
    
    private void c() {
        this.h.submit(new eu(this));
    }
    
    private boolean d() {
        return this.e.size() <= 8;
    }
    
    @Override
    public final void a(final String s, final Object o) {
        if (s.equals("UseHttps")) {
            this.g = (boolean)o;
            final String f = es.f;
            gj.a(4, "onSettingUpdate, UseHttps = " + this.g);
            return;
        }
        if (s.equals("ReportUrl")) {
            final String str = (String)o;
            a(str);
            final String f2 = es.f;
            gj.a(4, "onSettingUpdate, ReportUrl = " + str);
            return;
        }
        final String f3 = es.f;
        gj.a(6, "onSettingUpdate internal error!");
    }
    
    @Override
    public final void a(final boolean b) {
        final String f = es.f;
        gj.a(4, "onNetworkStateChanged : isNetworkEnable = " + b);
        if (b) {
            this.c();
        }
    }
    
    public final void a(final byte[] array, final String s, final String s2) {
        if (array == null || array.length == 0) {
            final String f = es.f;
            gj.a(6, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        this.h.submit(new ev(this, array, s, s2));
        this.c();
    }
    
    final String b(final byte[] array, final String str, final String str2) {
        final String string = "Data_" + str + "_" + str2;
        final fc fc = new fc();
        fc.a(array);
        final String a = fc.a();
        this.d.a(fc, string);
        return a;
    }
}
