// 
// Decompiled by Procyon v0.5.29
// 

public final class si extends adi
{
    public static final si a;
    final sj b;
    
    static {
        a = new si();
    }
    
    public si() {
        this.b = new sj();
    }
    
    public final sh a(final xj xj) {
        final sh a = this.b.a(xj);
        try {
            a.h = (xj.c("hidden").intValue() != 0);
            return a;
        }
        catch (ux ux) {
            a.h = false;
            return a;
        }
    }
}
