// 
// Decompiled by Procyon v0.5.29
// 

public final class co extends cs
{
    protected ci a;
    private String e;
    private int f;
    private cn g;
    private String h;
    private String i;
    private int j;
    
    co(final cn g, final String s) {
        super(s, null, null, g.c);
        this.e = null;
        this.f = 1;
        this.h = g.b.h;
        this.i = g.b.i;
        this.j = g.b.j;
        this.a = null;
        this.b = this;
        this.g = g;
    }
    
    co(final String e, final String h, final String i, final int j, final cl cl, final String s) {
        super(s, null, null, cl);
        this.e = null;
        this.f = 1;
        this.h = h;
        this.i = i;
        this.j = j;
        this.a = null;
        this.e = e;
        this.b = this;
    }
    
    @Override
    protected final dc a() {
        final dc a = super.a();
        cs.a(a, "Application", this.h);
        cs.a(a, "SchemaVersion", this.i);
        cs.a(a, "RetentionDays", new Integer(this.j));
        return a;
    }
    
    public final String b() {
        return this.e;
    }
    
    @Override
    protected final void c() {
        super.c();
        if (this.g != null) {
            this.e = this.g.b();
        }
    }
    
    public final int d() {
        return this.f++;
    }
}
