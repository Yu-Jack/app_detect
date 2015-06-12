// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.util.Iterator;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class HitBuilder
{
    static String encode(final String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError((Object)("URL encoding failed for: " + s));
        }
    }
    
    static Map<String, String> generateHitParams(final Map<String, String> map) {
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
    
    static String postProcessHit(final Hit hit, final long n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(hit.getHitParams());
        if (hit.getHitTime() > 0L) {
            final long lng = n - hit.getHitTime();
            if (lng >= 0L) {
                sb.append("&qt").append("=").append(lng);
            }
        }
        sb.append("&z").append("=").append(hit.getHitId());
        return sb.toString();
    }
}
