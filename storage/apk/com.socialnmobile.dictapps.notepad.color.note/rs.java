import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rs
{
    public static byte[] a(final int keysize) {
        try {
            final KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(keysize);
            return instance.generateKey().getEncoded();
        }
        catch (NoSuchAlgorithmException cause) {
            throw new RuntimeException(cause);
        }
    }
}
