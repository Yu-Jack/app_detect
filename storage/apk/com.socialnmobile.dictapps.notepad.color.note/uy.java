// 
// Decompiled by Procyon v0.5.29
// 

public class uy extends acl
{
    public final vu a;
    public final vi b;
    public final vf c;
    
    public uy() {
        this.a = (vu)this.a(new vu());
        this.b = (vi)this.a(new vi());
        this.c = (vf)this.a(new vf());
    }
    
    private static Object a(final acf acf) {
        try {
            return acf.c();
        }
        catch (acg acg) {
            return null;
        }
    }
    
    private static void a(final boolean b, final acf acf, final Object o) {
        if (a(acf) == null) {
            if (!b) {
                acf.b();
                return;
            }
            acf.a(o);
        }
    }
    
    public final void a(final boolean b) {
        a(b, this.b.f, 0);
        a(b, this.b.g, 0);
        a(b, this.b.c, 0);
        a(b, this.b.j, 0);
        a(b, this.b.h, new tw(0L));
        a(b, this.c.d, new tw(0L));
        a(b, this.c.a, "");
        a(b, this.c.b, "");
    }
}
