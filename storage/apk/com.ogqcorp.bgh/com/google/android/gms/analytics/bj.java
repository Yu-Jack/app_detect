// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Iterator;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class bj
{
    static String a(final bi bi, final long n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(bi.a());
        if (bi.c() > 0L) {
            final long lng = n - bi.c();
            if (lng >= 0L) {
                sb.append("&qt").append("=").append(lng);
            }
        }
        sb.append("&z").append("=").append(bi.b());
        return sb.toString();
    }
    
    static String a(final String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError((Object)("URL encoding failed for: " + s));
        }
    }
    
    static Map<String, String> a(final Map<String, String> map) {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("&") && entry.getValue() != null) {
                final String substring = entry.getKey().substring(1);
                if (TextUtils.isEmpty((CharSequence)substring)) {
                    continue;
                }
                hashMap.put(substring, entry.getValue());
            }
        }
        return (Map<String, String>)hashMap;
    }
}
