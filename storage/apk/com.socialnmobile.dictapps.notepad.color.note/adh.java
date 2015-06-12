// 
// Decompiled by Procyon v0.5.29
// 

public abstract class adh implements adk
{
    public abstract Object a(final Object p0);
    
    public abstract Object b(final Object p0);
    
    @Override
    public final Object c(final Object o) {
        if (o == null) {
            return null;
        }
        return this.b(o);
    }
    
    @Override
    public final Object d(final Object o) {
        if (o == null) {
            return null;
        }
        try {
            return this.a(o);
        }
        catch (Exception ex) {
            throw new ux(ex);
        }
    }
}
