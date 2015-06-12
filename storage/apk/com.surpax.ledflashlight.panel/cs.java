import java.util.Iterator;
import java.util.Hashtable;

// 
// Decompiled by Procyon v0.5.29
// 

public class cs implements ci
{
    private cs a;
    co b;
    cl c;
    int d;
    private String e;
    private Long f;
    private Hashtable g;
    
    cs(final String e, final cs a, final co b, final cl c) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    protected static boolean a(final dc dc, final String s, final Object o) {
        final cw cw = new cw();
        String s2;
        if (o instanceof byte[]) {
            s2 = "bin";
        }
        else if (o instanceof Boolean) {
            s2 = "bool";
        }
        else if (o instanceof Double) {
            s2 = "float";
        }
        else if (o instanceof Integer) {
            s2 = "int";
        }
        else if (o instanceof Long) {
            s2 = "long";
        }
        else if (o instanceof String) {
            s2 = "str";
        }
        else if (o instanceof ci) {
            s2 = "str";
        }
        else {
            s2 = "unknown";
        }
        if (s2.compareTo("unknown") == 0) {
            return false;
        }
        cw.a("t", s2);
        cw.a("k", s);
        if (o instanceof byte[]) {
            cw.a("v", (byte[])o);
        }
        else if (o instanceof Boolean) {
            cw.a("v", ((Boolean)o).toString());
        }
        else if (o instanceof Double) {
            cw.a("v", ((Double)o).toString());
        }
        else if (o instanceof Integer) {
            cw.b("v", (int)o);
        }
        else if (o instanceof Long) {
            cw.a("v", ((Long)o).toString());
        }
        else if (o instanceof String) {
            cw.b("v", (String)o);
        }
        else {
            if (!(o instanceof ci)) {
                return false;
            }
            cw.a("v", ((cs)o).b.b() + "." + ((cs)o).d);
        }
        dc.a(cw);
        return true;
    }
    
    @Override
    public final ck a(final String s) {
        return cp.a(this, s);
    }
    
    protected dc a() {
        final cz cz = new cz();
        a(cz, "RootParentId", this.b.b());
        if (this.a != null) {
            a(cz, "ParentSeqId", new Integer(this.a.d));
        }
        a(cz, "SeqId", new Integer(this.d));
        a(cz, "Name", this.e);
        a(cz, "Timestamp", this.f);
        return cz;
    }
    
    public final void a(final Hashtable g, final cr cr) {
        this.g = g;
        this.f = System.currentTimeMillis();
        this.c.a(this, cr);
    }
    
    protected void c() {
        this.d = this.b.d();
    }
    
    public final ci e() {
        return this.a;
    }
    
    public final byte[] f() {
        final cw cw = new cw();
        final dc a = this.a();
        final cz cz = new cz();
        for (final String key : this.g.keySet()) {
            a(cz, key, this.g.get(key));
        }
        cw.a("meta", a);
        if (cz.a() > 0) {
            cw.a("attr", cz);
        }
        return cw.d();
    }
}
