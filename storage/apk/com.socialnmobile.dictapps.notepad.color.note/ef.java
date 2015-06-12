import java.net.URLDecoder;
import java.util.Iterator;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ef
{
    public static Bundle a(final String s) {
        final String replace = s.replace("fbconnect", "http");
        try {
            final URL url = new URL(replace);
            final Bundle b = b(url.getQuery());
            b.putAll(b(url.getRef()));
            return b;
        }
        catch (MalformedURLException ex) {
            return new Bundle();
        }
    }
    
    public static String a(final Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        final Iterator<String> iterator = (Iterator<String>)bundle.keySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final String s = iterator.next();
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append("&");
            }
            sb.append(String.valueOf(URLEncoder.encode(s)) + "=" + URLEncoder.encode(bundle.getString(s)));
        }
        return sb.toString();
    }
    
    private static Bundle b(final String s) {
        final Bundle bundle = new Bundle();
        if (s != null) {
            final String[] split = s.split("&");
            for (int length = split.length, i = 0; i < length; ++i) {
                final String[] split2 = split[i].split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }
}
