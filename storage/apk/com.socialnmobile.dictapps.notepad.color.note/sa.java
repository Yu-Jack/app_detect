// 
// Decompiled by Procyon v0.5.29
// 

public final class sa
{
    final rv a;
    final xj b;
    final xj c;
    final sl d;
    
    public sa(final rv a) {
        this.a = a;
        this.b = (xj)a.t.c();
        this.c = (xj)a.u.c();
        if (this.b == null) {
            throw new sb(this);
        }
        if (this.c == null) {
            throw new sb(this);
        }
        try {
            final String d = this.c.d("auth_method");
            this.d = sl.a(d);
            if (this.d == null) {
                throw new ux("unsupported authority: " + d);
            }
        }
        catch (xg xg) {
            throw new sb(this);
        }
        catch (xh xh) {
            throw new ux(xh);
        }
    }
    
    private xj b() {
        return this.c.f("creds");
    }
    
    final ur a(final us us) {
        try {
            return (ur)us.d(this.b());
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    final uu a(final uv uv) {
        try {
            return (uu)uv.d(this.b());
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    final xj a() {
        return this.c.j("external_userinfo");
    }
}
