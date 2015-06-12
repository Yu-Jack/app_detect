// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ArrayList;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

public class cz
{
    private static final String a;
    
    static {
        a = cz.class.getSimpleName();
    }
    
    public Map a(final String str) {
        eo.a(3, cz.a, "Parsing referrer map");
        if (str == null) {
            return Collections.emptyMap();
        }
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final String[] split = str.split("&");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                eo.a(5, cz.a, "Invalid referrer Element: " + split[i] + " in referrer tag " + str);
            }
            else {
                final String decode = URLDecoder.decode(split2[0]);
                final String decode2 = URLDecoder.decode(split2[1]);
                if (hashMap.get(decode) == null) {
                    hashMap.put(decode, new ArrayList<String>());
                }
                hashMap.get(decode).add(decode2);
            }
        }
        for (final Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
            eo.a(3, cz.a, "entry: " + entry.getKey() + "=" + entry.getValue());
        }
        final StringBuilder sb = new StringBuilder();
        if (hashMap.get("utm_source") == null) {
            sb.append("Campaign Source is missing.\n");
        }
        if (hashMap.get("utm_medium") == null) {
            sb.append("Campaign Medium is missing.\n");
        }
        if (hashMap.get("utm_campaign") == null) {
            sb.append("Campaign Name is missing.\n");
        }
        if (sb.length() > 0) {
            eo.a(5, cz.a, "Detected missing referrer keys : " + sb.toString());
        }
        return hashMap;
    }
}
