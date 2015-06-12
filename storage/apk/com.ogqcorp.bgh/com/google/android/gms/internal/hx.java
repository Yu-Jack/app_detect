// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.HashMap;

public class hx
{
    public static void a(final StringBuilder sb, final HashMap<String, String> hashMap) {
        sb.append("{");
        final Iterator<String> iterator = hashMap.keySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final String s = iterator.next();
            int n2;
            if (n == 0) {
                sb.append(",");
                n2 = n;
            }
            else {
                n2 = 0;
            }
            final String str = hashMap.get(s);
            sb.append("\"").append(s).append("\":");
            if (str == null) {
                sb.append("null");
            }
            else {
                sb.append("\"").append(str).append("\"");
            }
            n = n2;
        }
        sb.append("}");
    }
}
