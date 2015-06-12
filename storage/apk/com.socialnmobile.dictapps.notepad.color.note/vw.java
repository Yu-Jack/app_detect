import java.util.UUID;

// 
// Decompiled by Procyon v0.5.29
// 

public final class vw
{
    public static final vw a;
    
    static {
        a = new vw();
    }
    
    public static void a(final vu vu, final xj xj) {
        xj.a("uuid", vu.a.c(), adf.a);
        xj.a("revision", (long)vu.b.c());
    }
    
    public static void b(final vu vu, final xj xj) {
        try {
            vu.a.a(xj.a("uuid", adf.a));
            vu.b.a(xj.c("revision").longValue());
        }
        catch (xg xg) {
            throw new ux(xg);
        }
        catch (xh xh) {
            throw new ux(xh);
        }
    }
}
