// 
// Decompiled by Procyon v0.5.29
// 

public final class vs extends RuntimeException
{
    private static final long serialVersionUID = -3085141015199244046L;
    public final xj a;
    
    public vs(final String message, final Throwable cause, final rv rv) {
        super(message, cause);
        this.a = (xj)rw.a.c(rv);
    }
    
    public vs(final String message, final rv rv) {
        super(message);
        this.a = (xj)rw.a.c(rv);
    }
    
    public vs(final Throwable cause, final rv rv) {
        super(cause);
        this.a = (xj)rw.a.c(rv);
    }
}
