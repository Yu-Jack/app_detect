import java.util.concurrent.Callable;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class ss
{
    public static final ta a;
    public static final sw b;
    public static final sy c;
    
    static {
        a = new ta();
        b = new sw();
        c = new sy();
    }
    
    static rt a(final xm xm, final xt xt, final sp sp) {
        return sp.a(xt, (xu)new xv().d(xf.c(xm.a(xt))));
    }
    
    static rt a(final xt xt, final xu xu, final rt rt) {
        final long m = rt.m();
        final long a = xu.a.a;
        if (m != a) {
            throw new IllegalStateException("returned account " + a + " not match with local account id " + m);
        }
        rt.a(xt, xu);
        return rt;
    }
    
    static rt a(final xt xt, final xu xu, final sf sf) {
        final long a = xu.a.a;
        final rt b = sf.b();
        if (b != null) {
            if (a == b.m()) {
                b.a(xt, xu);
                return b;
            }
            b.c();
        }
        return sf.a(xt, xu);
    }
    
    static Callable b(final xm xm, final xt xt, final sp sp) {
        return new sv(xm, xt, sp);
    }
    
    public abstract Callable a(final sf p0, final xm p1, final sl p2, final tt p3);
    
    public abstract xt a(final sl p0, final tt p1, final xj p2, final rv p3);
}
