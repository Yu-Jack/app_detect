// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

class WebRequest$QueryStringParameters
{
    private final HashMap params;
    private String rawAppendage;
    
    WebRequest$QueryStringParameters() {
        this.params = new HashMap();
    }
    
    void append(final StringBuilder sb) {
        if (this.size() != 0 || !Utils.isNullOrEmpty(this.rawAppendage)) {
            sb.append("?");
            final Iterator<Map.Entry<String, V>> iterator = this.params.entrySet().iterator();
            int n = 1;
            while (iterator.hasNext()) {
                final Map.Entry<String, V> entry = iterator.next();
                int n2;
                if (n != 0) {
                    n2 = 0;
                }
                else {
                    sb.append("&");
                    n2 = n;
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append((String)entry.getValue());
                n = n2;
            }
            if (this.rawAppendage != null && !this.rawAppendage.equals("")) {
                if (this.size() != 0) {
                    sb.append("&");
                }
                sb.append(this.rawAppendage);
            }
        }
    }
    
    String get(final String key) {
        if (Utils.isNullOrWhiteSpace(key)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        return this.params.get(key);
    }
    
    String putUnencoded(final String s, final String s2) {
        final String urlEncodedString = Utils.getURLEncodedString(s);
        this.putUrlEncoded(urlEncodedString, Utils.getURLEncodedString(s2));
        return urlEncodedString;
    }
    
    void putUrlEncoded(final String s, final String value) {
        if (Utils.isNullOrWhiteSpace(s)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        if (value == null) {
            this.params.remove(s);
            return;
        }
        this.params.put(s, value);
    }
    
    void putUrlEncoded(final String s, final boolean b) {
        this.putUrlEncoded(s, Boolean.toString(b));
    }
    
    void putUrlEncodedIfNotNullOrEmpty(final String s, final String s2) {
        this.putUrlEncodedIfTrue(s, s2, !Utils.isNullOrEmpty(s2));
    }
    
    void putUrlEncodedIfTrue(final String s, final String s2, final boolean b) {
        if (b) {
            this.putUrlEncoded(s, s2);
        }
    }
    
    void setRawAppendage(final String rawAppendage) {
        this.rawAppendage = rawAppendage;
    }
    
    int size() {
        return this.params.size();
    }
}
