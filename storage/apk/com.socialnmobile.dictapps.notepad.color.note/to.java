import java.io.IOException;

// 
// Decompiled by Procyon v0.5.29
// 

public final class to
{
    public final xj a;
    
    public to(final xj a) {
        if (a == null) {
            throw new IllegalArgumentException("json: null");
        }
        this.a = a;
    }
    
    public static xj a(final String s) {
        try {
            return xj.a(s);
        }
        catch (Exception ex) {
            throw new IOException(ex.getMessage());
        }
    }
}
