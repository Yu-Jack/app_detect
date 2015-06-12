// 
// Decompiled by Procyon v0.5.29
// 

public final class acj implements acf
{
    final acf a;
    final adk b;
    
    public acj(final acf a, final adk b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a(final Object o) {
        this.a.a(this.b.c(o));
    }
    
    @Override
    public final void b() {
        this.a.b();
    }
    
    @Override
    public final Object c() {
        final Object c = this.a.c();
        try {
            return this.b.d(c);
        }
        catch (ux ux) {
            return null;
        }
    }
}
