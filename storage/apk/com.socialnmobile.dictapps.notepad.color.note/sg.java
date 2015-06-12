import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class sg implements sf
{
    final Context a;
    final ki b;
    
    public sg(final Context a, final ki b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final rt a() {
        return rt.a(this.a, this.b);
    }
    
    @Override
    public final rt a(final xt xt, final xu xu) {
        return rt.a(this.a, this.b, xt, xu);
    }
    
    @Override
    public final rt b() {
        return rt.b(this.a, this.b);
    }
    
    @Override
    public final xj c() {
        final xj xj = new xj();
        final Context a = this.a;
        xj.a("id", ua.a(ua.a()));
        xj.a("info", ub.a(this.a).a());
        return xj;
    }
}
