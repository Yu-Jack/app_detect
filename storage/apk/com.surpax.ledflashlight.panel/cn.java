// 
// Decompiled by Procyon v0.5.29
// 

public final class cn extends cm
{
    protected Boolean a;
    private String e;
    
    cn(final cs cs, final String s) {
        super(cs, s);
        this.a = false;
    }
    
    @Override
    protected final dc a() {
        final dc a = super.a();
        cs.a(a, "RefId", this.e + ".1");
        if (this.a) {
            cs.a(a, "Cancel", new Boolean(true));
        }
        return a;
    }
    
    final String b() {
        return this.e;
    }
    
    @Override
    protected final void c() {
        super.c();
        this.e = this.b.b() + "." + this.d;
    }
}
