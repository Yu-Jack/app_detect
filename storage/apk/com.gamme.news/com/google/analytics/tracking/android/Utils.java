// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import android.text.TextUtils;

class Utils
{
    private static final char[] HEXBYTES;
    
    static {
        HEXBYTES = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    }
    
    public static String filterCampaign(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        String decode = s;
        if (s.contains("?")) {
            final String[] split = s.split("[\\?]");
            if (split.length > 1) {
                decode = split[1];
            }
        }
        while (true) {
            Label_0214: {
                if (!decode.contains("%3D")) {
                    break Label_0214;
                }
                try {
                    decode = URLDecoder.decode(decode, "UTF-8");
                    final Map<String, String> urlParameters = parseURLParameters(decode);
                    final String[] array = { "dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t" };
                    final StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < array.length; ++i) {
                        if (!TextUtils.isEmpty((CharSequence)urlParameters.get(array[i]))) {
                            if (sb.length() > 0) {
                                sb.append("&");
                            }
                            sb.append(array[i]).append("=").append(urlParameters.get(array[i]));
                        }
                    }
                    return sb.toString();
                }
                catch (UnsupportedEncodingException ex) {
                    return null;
                }
            }
            if (!decode.contains("=")) {
                return null;
            }
            continue;
        }
    }
    
    static int fromHexDigit(final char c) {
        int n = c - '0';
        if (n > 9) {
            n -= 7;
        }
        return n;
    }
    
    static String getLanguage(final Locale locale) {
        if (locale != null && !TextUtils.isEmpty((CharSequence)locale.getLanguage())) {
            final StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (!TextUtils.isEmpty((CharSequence)locale.getCountry())) {
                sb.append("-").append(locale.getCountry().toLowerCase());
            }
            return sb.toString();
        }
        return null;
    }
    
    static byte[] hexDecode(final String s) {
        final byte[] array = new byte[s.length() / 2];
        for (int i = 0; i < array.length; ++i) {
            array[i] = (byte)(fromHexDigit(s.charAt(i * 2)) << 4 | fromHexDigit(s.charAt(1 + i * 2)));
        }
        return array;
    }
    
    static String hexEncode(final byte[] array) {
        final char[] value = new char[2 * array.length];
        for (int i = 0; i < array.length; ++i) {
            final int n = 0xFF & array[i];
            value[i * 2] = Utils.HEXBYTES[n >> 4];
            value[1 + i * 2] = Utils.HEXBYTES[n & 0xF];
        }
        return new String(value);
    }
    
    public static Map<String, String> parseURLParameters(final String s) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final String[] split = s.split("&");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] split2 = split[i].split("=");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
            else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }
    
    public static void putIfAbsent(final Map<String, String> map, final String s, final String s2) {
        if (!map.containsKey(s)) {
            map.put(s, s2);
        }
    }
    
    public static boolean safeParseBoolean(final String s, boolean b) {
        if (s != null) {
            if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("1")) {
                b = true;
            }
            else if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("no") || s.equalsIgnoreCase("0")) {
                return false;
            }
        }
        return b;
    }
    
    public static double safeParseDouble(final String s) {
        return safeParseDouble(s, 0.0);
    }
    
    public static double safeParseDouble(final String s, final double n) {
        if (s == null) {
            return n;
        }
        try {
            return Double.parseDouble(s);
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public static long safeParseLong(final String s) {
        if (s == null) {
            return 0L;
        }
        try {
            return Long.parseLong(s);
        }
        catch (NumberFormatException ex) {
            return 0L;
        }
    }
}
