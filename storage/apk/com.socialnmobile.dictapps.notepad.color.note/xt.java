// 
// Decompiled by Procyon v0.5.29
// 

public final class xt extends xr
{
    public final ss b;
    public final sl c;
    public final tt d;
    public final xj e;
    public final vc f;
    public final long g;
    
    public xt(final sw b, final sl c, final tt d, final xj e) {
        super("login", a(c, d, e));
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = null;
        this.g = 0L;
    }
    
    public xt(final sy b, final sl c, final tt d, final xj e, final long n) {
        final xj a = a(c, d, e);
        a.a("account", n);
        super("login", a);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = null;
        this.g = n;
    }
    
    public xt(final ta b, final sl c, final tt d, final xj e, final vc f) {
        final xj a = a(c, d, e);
        a.a("nek", f, vd.a);
        super("signup", a);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = 0L;
    }
    
    private static xj a(final sl sl, final tt tt, final xj xj) {
        final xj xj2 = new xj();
        xj2.a("authority", sl.e);
        xj2.a("credentials", tt, sl.f);
        xj2.a("device", xj);
        return xj2;
    }
}
