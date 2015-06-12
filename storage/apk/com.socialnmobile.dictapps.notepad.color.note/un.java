import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class un
{
    public static byte[] a(final byte[] input) {
        try {
            final MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(input);
            return instance.digest();
        }
        catch (NoSuchAlgorithmException cause) {
            throw new RuntimeException(cause);
        }
    }
    
    public abstract String a();
    
    public abstract ul a(final vc p0, final byte[] p1);
    
    public abstract byte[] a(final vc p0, final ul p1);
}
