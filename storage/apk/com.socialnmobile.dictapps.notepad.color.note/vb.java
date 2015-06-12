// 
// Decompiled by Procyon v0.5.29
// 

public final class vb
{
    public static final vb d;
    final vw a;
    final vk b;
    final vh c;
    
    static {
        d = new vb();
    }
    
    public vb() {
        this.a = vw.a;
        this.b = vk.d;
        this.c = vh.c;
    }
    
    public final void a(final va va, final xj xj) {
        xj.a("cid", va.e);
        final vw a = this.a;
        vw.a(va.a, xj);
        final vk b = this.b;
        vk.a(va.b, xj);
        boolean b2;
        if ((0x1 & (int)va.f.b.c()) != 0x0) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (b2 || (long)va.a.b.c() == 0L) {
            final vh c = this.c;
            vh.a(va.c, xj);
        }
    }
}
