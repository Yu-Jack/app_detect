import java.security.InvalidKeyException;
import java.security.NoSuchProviderException;
import java.security.NoSuchAlgorithmException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;

// 
// Decompiled by Procyon v0.5.29
// 

public final class vr
{
    public static String a(final byte[] key, final String s) {
        try {
            final Mac instance = Mac.getInstance("HMAC-SHA1", "BC");
            instance.init(new SecretKeySpec(key, "RAW"));
            return (String)adb.b.c(instance.doFinal(s.getBytes("UTF-8")));
        }
        catch (NoSuchAlgorithmException cause) {
            throw new RuntimeException(cause);
        }
        catch (NoSuchProviderException cause2) {
            throw new RuntimeException(cause2);
        }
        catch (InvalidKeyException cause3) {
            throw new RuntimeException(cause3);
        }
    }
}
