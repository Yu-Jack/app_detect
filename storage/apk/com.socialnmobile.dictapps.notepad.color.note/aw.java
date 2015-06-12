import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

final class aw extends ba
{
    final /* synthetic */ av a;
    
    aw(final av a) {
        this.a = a;
    }
    
    @Override
    protected final int a() {
        return this.a.h;
    }
    
    @Override
    protected final int a(final Object o) {
        if (o == null) {
            return this.a.a();
        }
        return this.a.a(o, o.hashCode());
    }
    
    @Override
    protected final Object a(final int n, final int n2) {
        return this.a.g[n2 + (n << 1)];
    }
    
    @Override
    protected final Object a(final int n, final Object o) {
        final av a = this.a;
        final int n2 = 1 + (n << 1);
        final Object o2 = a.g[n2];
        a.g[n2] = o;
        return o2;
    }
    
    @Override
    protected final void a(final int n) {
        this.a.c(n);
    }
    
    @Override
    protected final void a(final Object o, final Object o2) {
        this.a.put(o, o2);
    }
    
    @Override
    protected final int b(final Object o) {
        return this.a.a(o);
    }
    
    @Override
    protected final Map b() {
        return this.a;
    }
    
    @Override
    protected final void c() {
        this.a.clear();
    }
}
