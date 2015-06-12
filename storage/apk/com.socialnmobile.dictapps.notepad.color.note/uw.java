// 
// Decompiled by Procyon v0.5.29
// 

public final class uw extends uv
{
    public uw() {
        super("access_token", "expires_in", "expires_at", "refresh_token");
    }
    
    @Override
    public final String a(final xj xj) {
        try {
            return uw.b.a(xj);
        }
        catch (Exception ex) {
            return uw.c.a(xj);
        }
    }
    
    @Override
    public final int b(final xj xj) {
        try {
            return xj.c(uw.b.g).intValue();
        }
        catch (Exception ex) {
            try {
                return xj.c(uw.c.g).intValue();
            }
            catch (Exception ex2) {
                return 0;
            }
        }
    }
    
    @Override
    public final String c(final xj xj) {
        try {
            return xj.d(uw.b.e);
        }
        catch (Exception ex) {
            try {
                return xj.d(uw.c.e);
            }
            catch (Exception ex2) {
                return null;
            }
        }
    }
}
