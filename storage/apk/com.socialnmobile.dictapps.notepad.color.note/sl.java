// 
// Decompiled by Procyon v0.5.29
// 

public abstract class sl
{
    public static final sm a;
    public static final sn b;
    public static final so c;
    public static final sl d;
    public final String e;
    public final tu f;
    public final tu g;
    
    static {
        a = new sm();
        b = new sn();
        c = new so();
        d = null;
    }
    
    public sl(final String e, final adi adi, final adi adi2) {
        this.e = e;
        this.f = new tu(adi);
        this.g = new tu(adi2);
    }
    
    public static String a(final rv rv) {
        return rv.i();
    }
    
    public static final sl a(final String anObject) {
        for (final sl sl : new sl[] { sl.a, sl.b, sl.c }) {
            if (sl.e.equals(anObject)) {
                return sl;
            }
        }
        return null;
    }
    
    public tt a(final rv rv, final tt tt) {
        return tt;
    }
}
