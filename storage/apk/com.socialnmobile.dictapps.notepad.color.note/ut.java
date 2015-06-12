// 
// Decompiled by Procyon v0.5.29
// 

public final class ut extends us
{
    public ut() {
        super("access_token", "expires_in", "expires_at");
    }
    
    @Override
    public final String a(final xj xj) {
        try {
            return ut.b.a(xj);
        }
        catch (Exception ex) {
            return ut.c.a(xj);
        }
    }
    
    @Override
    public final int b(final xj xj) {
        try {
            return xj.c(ut.b.g).intValue();
        }
        catch (Exception ex) {
            try {
                return xj.c(ut.c.g).intValue();
            }
            catch (Exception ex2) {
                return 0;
            }
        }
    }
}
