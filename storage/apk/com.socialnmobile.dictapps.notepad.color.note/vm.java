// 
// Decompiled by Procyon v0.5.29
// 

public final class vm
{
    public static final vm a;
    
    static {
        a = new vm();
    }
    
    public static void a(final vl vl, final xj xj) {
        if ((int)vl.a.c() == 0) {
            throw new IllegalArgumentException("reminder.type should not be NONE");
        }
        xj.a("type", (int)vl.a.c());
        xj.a("when", vl.b.c(), tw.d);
        xj.a("base", vl.c.c(), tw.d);
        xj.a("last", vl.d.c(), tw.d);
        xj.a("repeat", (int)vl.f.c());
        xj.a("repeat_end", vl.h.c(), tw.d);
        xj.a("option", (int)vl.e.c());
        xj.a("duration", (int)vl.g.c());
    }
    
    public static void b(final vl vl, final xj xj) {
        if (xj == null) {
            vl.a.a(0);
            vl.a();
            return;
        }
        try {
            final int intValue = xj.c("type").intValue();
            vl.a.a(intValue);
            if (intValue == 0) {
                vl.a();
                return;
            }
            goto Label_0067;
        }
        catch (xg xg) {
            throw new ux(xg);
        }
        catch (xh xh) {
            throw new ux(xh);
        }
    }
}
