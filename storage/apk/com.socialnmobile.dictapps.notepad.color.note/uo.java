import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class uo extends un
{
    public abstract SecretKey a(final vc p0);
    
    @Override
    public final ul a(final vc vc, final byte[] input) {
        try {
            final String a = this.a();
            final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            final SecretKey a2 = this.a(vc);
            final SecureRandom secureRandom = new SecureRandom();
            final byte[] array = new byte[instance.getBlockSize()];
            secureRandom.nextBytes(array);
            instance.init(1, a2, new IvParameterSpec(array));
            return new ul(a, array, instance.doFinal(input), un.a(input));
        }
        catch (NoSuchAlgorithmException cause) {
            throw new RuntimeException(cause);
        }
        catch (NoSuchPaddingException cause2) {
            throw new RuntimeException(cause2);
        }
        catch (InvalidKeyException cause3) {
            throw new RuntimeException(cause3);
        }
        catch (InvalidAlgorithmParameterException cause4) {
            throw new RuntimeException(cause4);
        }
        catch (IllegalBlockSizeException ex) {
            throw new tv(ex);
        }
        catch (BadPaddingException ex2) {
            throw new tv(ex2);
        }
    }
    
    @Override
    public final byte[] a(final vc vc, final ul ul) {
        byte[] doFinal;
        try {
            final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, this.a(vc), new IvParameterSpec(ul.b));
            doFinal = instance.doFinal(ul.c);
            final byte[] a = un.a(doFinal);
            if (!Arrays.equals(a, ul.d)) {
                throw new vt(ul.d, a);
            }
        }
        catch (NoSuchAlgorithmException cause) {
            throw new RuntimeException(cause);
        }
        catch (NoSuchPaddingException cause2) {
            throw new RuntimeException(cause2);
        }
        catch (InvalidKeyException cause3) {
            throw new IllegalArgumentException(cause3);
        }
        catch (InvalidAlgorithmParameterException cause4) {
            throw new RuntimeException(cause4);
        }
        catch (IllegalBlockSizeException ex) {
            throw new tv(ex);
        }
        catch (BadPaddingException ex2) {
            throw new tv(ex2);
        }
        return doFinal;
    }
}
