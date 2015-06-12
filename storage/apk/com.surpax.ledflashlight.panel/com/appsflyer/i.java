// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import java.util.Formatter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.Map;

public final class i
{
    public static String a(final Map map) {
        final String s = map.get("appsflyerKey");
        final String s2 = map.get("af_timestamp");
        final String s3 = map.get("uid");
        try {
            final MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.reset();
            instance.update((s.substring(0, 7) + s3.substring(0, 7) + s2.substring(-7 + s2.length())).getBytes("UTF-8"));
            return a(instance.digest());
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
        catch (UnsupportedEncodingException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }
    
    private static String a(final byte[] array) {
        final Formatter formatter = new Formatter();
        for (int length = array.length, i = 0; i < length; ++i) {
            formatter.format("%02x", array[i]);
        }
        final String string = formatter.toString();
        formatter.close();
        return string;
    }
}
