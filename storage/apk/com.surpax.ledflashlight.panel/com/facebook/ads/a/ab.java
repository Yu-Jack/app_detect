// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import java.security.MessageDigest;

public final class ab
{
    public static boolean a(final String s) {
        return s == null || s.length() <= 0;
    }
    
    public static String b(final String s) {
        try {
            final byte[] digest = MessageDigest.getInstance("MD5").digest(s.getBytes("utf-8"));
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; ++i) {
                sb.append(Integer.toString(256 + (0xFF & digest[i]), 16).substring(1));
            }
            return sb.toString();
        }
        catch (Exception ex) {
            return null;
        }
    }
}
