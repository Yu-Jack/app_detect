// 
// Decompiled by Procyon v0.5.29
// 

public final class xq extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public xq(final String message) {
        super(message);
    }
    
    public xq(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public xq(final Throwable cause) {
        super(cause.getMessage(), cause);
    }
}
