import java.io.IOException;

// 
// Decompiled by Procyon v0.5.29
// 

public final class acz extends acx
{
    public static final acz a;
    
    static {
        a = new acz();
    }
    
    private static String a(final byte[] array) {
        try {
            return acy.a(array);
        }
        catch (IOException cause) {
            throw new RuntimeException(cause);
        }
    }
    
    private static byte[] b(final String s) {
        try {
            return acy.a(s);
        }
        catch (IOException ex) {
            throw new ux(ex);
        }
    }
}
