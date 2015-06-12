import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import android.os.Build;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ua
{
    static String a() {
        try {
            return jl.b();
        }
        catch (RuntimeException ex) {
            return "";
        }
    }
    
    static String a(final String s) {
        final String[] array = { Build.BRAND, Build.MANUFACTURER, Build.MODEL, Build.PRODUCT, s };
        try {
            final MessageDigest instance = MessageDigest.getInstance("SHA1");
            final StringBuffer sb = new StringBuffer();
            final int length = array.length;
            int n = 1;
            for (final String str : array) {
                if (n != 0) {
                    n = 0;
                }
                else {
                    sb.append(":");
                }
                sb.append(str);
            }
            return (String)adb.b.c(instance.digest(sb.toString().getBytes("utf-8")));
        }
        catch (NoSuchAlgorithmException cause) {
            throw new RuntimeException(cause);
        }
        catch (UnsupportedEncodingException cause2) {
            throw new RuntimeException(cause2);
        }
    }
}
