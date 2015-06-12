// 
// Decompiled by Procyon v0.5.29
// 

public abstract class vo extends adi
{
    final String f;
    final String g;
    final String h;
    
    public vo(final String f, final String g, final String h) {
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    private tw c(final xj xj) {
        if (this.h == null) {
            return null;
        }
        final String h = xj.h(this.h);
        try {
            return (tw)tw.d.d(h);
        }
        catch (ux ux) {
            return null;
        }
    }
    
    public String a(final xj xj) {
        return xj.d(this.f);
    }
    
    public abstract vn a(final String p0, final int p1, final tw p2, final xj p3);
    
    public void a(final vn vn, final xj xj) {
        xj.a(this.f, vn.b);
        xj.a(this.g, vn.c);
        if (this.h != null) {
            xj.a(this.h, vn.d, tw.d);
        }
    }
    
    public int b(final xj xj) {
        try {
            return xj.c(this.g).intValue();
        }
        catch (Exception ex) {
            return 0;
        }
    }
}
