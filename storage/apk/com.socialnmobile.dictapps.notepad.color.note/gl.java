import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.io.Closeable;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gl
{
    private static final String a;
    
    static {
        a = gl.class.getSimpleName();
    }
    
    public static String a(String s) {
        if (s == null) {
            s = "";
        }
        else if (s.length() > 255) {
            return s.substring(0, 255);
        }
        return s;
    }
    
    public static void a(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (Throwable t) {}
    }
    
    public static byte[] b(final String s) {
        try {
            final MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(s.getBytes(), 0, s.length());
            return instance.digest();
        }
        catch (NoSuchAlgorithmException ex) {
            final String a = gl.a;
            gj.a(6, "Unsupported SHA1: " + ex.getMessage());
            return null;
        }
    }
}
