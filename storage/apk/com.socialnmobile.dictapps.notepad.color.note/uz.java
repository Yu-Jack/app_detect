// 
// Decompiled by Procyon v0.5.29
// 

public final class uz
{
    final vc a;
    final un b;
    final um c;
    
    public uz(final vc a) {
        this.b = up.a;
        this.c = um.a;
        this.a = a;
    }
    
    private String b(final xj xj) {
        return new String(((ul)this.c.d(xj)).a(this.a));
    }
    
    public final Object a(final String s) {
        return this.c.c(this.b.a(this.a, s.getBytes()));
    }
    
    public final void a(final xj xj) {
        try {
            xj.a("title", this.b(xj.f("title")));
            xj.a("content", this.b(xj.f("content")));
        }
        catch (xg xg) {
            throw new ux(xg);
        }
        catch (xh xh) {
            throw new ux(xh);
        }
    }
}
