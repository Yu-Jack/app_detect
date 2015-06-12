// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Locale;
import android.text.TextUtils;

public final class gi
{
    public static boolean a(final Object o, final Object obj) {
        return (o == null && obj == null) || (o != null && obj != null && o.equals(obj));
    }
    
    public static void ak(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if (s.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (!s.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if (s.length() == "urn:x-cast:".length()) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }
    
    public static String al(final String str) {
        return "urn:x-cast:" + str;
    }
    
    public static long b(final double n) {
        return (long)(1000.0 * n);
    }
    
    public static String b(final Locale locale) {
        final StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        final String country = locale.getCountry();
        if (!TextUtils.isEmpty((CharSequence)country)) {
            sb.append('-').append(country);
        }
        final String variant = locale.getVariant();
        if (!TextUtils.isEmpty((CharSequence)variant)) {
            sb.append('-').append(variant);
        }
        return sb.toString();
    }
    
    public static double o(final long n) {
        return n / 1000.0;
    }
}
