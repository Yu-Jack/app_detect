// 
// Decompiled by Procyon v0.5.29
// 

public final class ach implements acf
{
    final acf a;
    final adk b;
    
    public ach(final acf a, final adi adi) {
        this.a = a;
        this.b = new adj(adi, adi);
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
        try {
            return this.b.d(this.a.c());
        }
        catch (ux ux) {
            return null;
        }
    }
}
