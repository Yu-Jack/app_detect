// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import java.util.Arrays;

public final class e
{
    static final int[] a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    private static final char[] h;
    private static final byte[] i;
    
    static {
        h = "0123456789ABCDEF".toCharArray();
        final int length = org.codehaus.jackson.g.e.h.length;
        i = new byte[length];
        for (int j = 0; j < length; ++j) {
            org.codehaus.jackson.g.e.i[j] = (byte)org.codehaus.jackson.g.e.h[j];
        }
        final int[] a2 = new int[256];
        for (int k = 0; k < 32; ++k) {
            a2[k] = -1;
        }
        a2[92] = (a2[34] = 1);
        a = a2;
        final int[] b2 = new int[org.codehaus.jackson.g.e.a.length];
        System.arraycopy(org.codehaus.jackson.g.e.a, 0, b2, 0, org.codehaus.jackson.g.e.a.length);
        for (int l = 128; l < 256; ++l) {
            int n;
            if ((l & 0xE0) == 0xC0) {
                n = 2;
            }
            else if ((l & 0xF0) == 0xE0) {
                n = 3;
            }
            else if ((l & 0xF8) == 0xF0) {
                n = 4;
            }
            else {
                n = -1;
            }
            b2[l] = n;
        }
        b = b2;
        final int[] array = new int[256];
        Arrays.fill(array, -1);
        for (int n2 = 33; n2 < 256; ++n2) {
            if (Character.isJavaIdentifierPart((char)n2)) {
                array[n2] = 0;
            }
        }
        array[64] = 0;
        array[42] = (array[35] = 0);
        array[43] = (array[45] = 0);
        c = array;
        final int[] array2 = new int[256];
        System.arraycopy(org.codehaus.jackson.g.e.c, 0, array2, 0, org.codehaus.jackson.g.e.c.length);
        Arrays.fill(array2, 128, 128, 0);
        d = array2;
        e = new int[256];
        System.arraycopy(org.codehaus.jackson.g.e.b, 128, org.codehaus.jackson.g.e.e, 128, 128);
        Arrays.fill(org.codehaus.jackson.g.e.e, 0, 32, -1);
        org.codehaus.jackson.g.e.e[9] = 0;
        org.codehaus.jackson.g.e.e[10] = 10;
        org.codehaus.jackson.g.e.e[13] = 13;
        org.codehaus.jackson.g.e.e[42] = 42;
        final int[] f2 = new int[128];
        for (int n3 = 0; n3 < 32; ++n3) {
            f2[n3] = -1;
        }
        f2[34] = 34;
        f2[92] = 92;
        f2[8] = 98;
        f2[9] = 116;
        f2[12] = 102;
        f2[10] = 110;
        f2[13] = 114;
        f = f2;
        Arrays.fill(g = new int[128], -1);
        for (int n4 = 0; n4 < 10; ++n4) {
            org.codehaus.jackson.g.e.g[n4 + 48] = n4;
        }
        for (int n5 = 0; n5 < 6; ++n5) {
            org.codehaus.jackson.g.e.g[n5 + 97] = n5 + 10;
            org.codehaus.jackson.g.e.g[n5 + 65] = n5 + 10;
        }
    }
    
    public static int a(final int n) {
        if (n > 127) {
            return -1;
        }
        return org.codehaus.jackson.g.e.g[n];
    }
    
    public static void a(final StringBuilder sb, final String s) {
        final int[] f = org.codehaus.jackson.g.e.f;
        final int length = f.length;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 >= length || f[char1] == 0) {
                sb.append(char1);
            }
            else {
                sb.append('\\');
                final int n = f[char1];
                if (n < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    final int n2 = -(n + 1);
                    sb.append(org.codehaus.jackson.g.e.h[n2 >> 4]);
                    sb.append(org.codehaus.jackson.g.e.h[n2 & 0xF]);
                }
                else {
                    sb.append((char)n);
                }
            }
        }
    }
    
    public static final int[] a() {
        return org.codehaus.jackson.g.e.a;
    }
    
    public static final int[] b() {
        return org.codehaus.jackson.g.e.b;
    }
    
    public static final int[] c() {
        return org.codehaus.jackson.g.e.c;
    }
    
    public static final int[] d() {
        return org.codehaus.jackson.g.e.d;
    }
    
    public static final int[] e() {
        return org.codehaus.jackson.g.e.e;
    }
    
    public static final int[] f() {
        return org.codehaus.jackson.g.e.f;
    }
    
    public static char[] g() {
        return org.codehaus.jackson.g.e.h.clone();
    }
    
    public static byte[] h() {
        return org.codehaus.jackson.g.e.i.clone();
    }
}
