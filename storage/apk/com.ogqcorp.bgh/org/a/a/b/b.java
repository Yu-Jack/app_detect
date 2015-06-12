// 
// Decompiled by Procyon v0.5.29
// 

package org.a.a.b;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class b
{
    private static final Pattern a;
    
    static {
        a = Pattern.compile("(?: |\\u00A0|\\s|[\\s&&[^ ]])\\s*");
    }
    
    public static String a(final Object[] array, final char c) {
        if (array == null) {
            return null;
        }
        return a(array, c, 0, array.length);
    }
    
    public static String a(final Object[] array, final char c, final int n, final int n2) {
        if (array == null) {
            return null;
        }
        final int n3 = n2 - n;
        if (n3 <= 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(n3 * 16);
        for (int i = n; i < n2; ++i) {
            if (i > n) {
                sb.append(c);
            }
            if (array[i] != null) {
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
    
    public static String[] a(final String s, final char c) {
        return a(s, c, false);
    }
    
    private static String[] a(final String s, final char c, final boolean b) {
        if (s == null) {
            return null;
        }
        final int length = s.length();
        if (length == 0) {
            return org.a.a.b.a.c;
        }
        final ArrayList<String> list = new ArrayList<String>();
        boolean b2 = false;
        int n = 0;
        int n2 = 0;
        int i = 0;
        while (i < length) {
            if (s.charAt(i) == c) {
                if (n != 0 || b) {
                    list.add(s.substring(n2, i));
                    b2 = true;
                    n = 0;
                }
                n2 = ++i;
            }
            else {
                final int n3 = i + 1;
                n = 1;
                i = n3;
                b2 = false;
            }
        }
        if (n != 0 || (b && b2)) {
            list.add(s.substring(n2, i));
        }
        return list.toArray(new String[list.size()]);
    }
}
