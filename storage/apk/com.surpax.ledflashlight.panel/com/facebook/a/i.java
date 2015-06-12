// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.a;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

public final class i
{
    @Deprecated
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
    
    @Deprecated
    private static Bundle b(final String s) {
        int i = 0;
        final Bundle bundle = new Bundle();
        if (s != null) {
            for (String[] split = s.split("&"); i < split.length; ++i) {
                final String[] split2 = split[i].split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    }
                    else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), "");
                    }
                }
                catch (UnsupportedEncodingException ex) {}
            }
        }
        return bundle;
    }
}
