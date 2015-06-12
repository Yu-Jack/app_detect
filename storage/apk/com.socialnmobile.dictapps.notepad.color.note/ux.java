// 
// Decompiled by Procyon v0.5.29
// 

public class ux extends Exception
{
    private static final long serialVersionUID = -6123594830805857200L;
    
    public ux() {
    }
    
    public ux(final String message) {
        super(message);
    }
    
    public ux(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public ux(final Throwable cause) {
        super(cause);
    }
    
    public static void a(final Object o) {
        if (o == null) {
            throw new ux();
        }
    }
}
