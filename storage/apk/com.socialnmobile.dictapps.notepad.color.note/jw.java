// 
// Decompiled by Procyon v0.5.29
// 

public final class jw
{
    private static char[] a;
    private static byte[] b;
    
    static {
        jw.a = new char[64];
        char c = 'A';
        int n = 0;
        while (c <= 'Z') {
            final char[] a = jw.a;
            final int n2 = n + 1;
            a[n] = c;
            ++c;
            n = n2;
        }
        int n3;
        for (char c2 = 'a'; c2 <= 'z'; ++c2, n = n3) {
            final char[] a2 = jw.a;
            n3 = n + 1;
            a2[n] = c2;
        }
        int n4;
        for (char c3 = '0'; c3 <= '9'; ++c3, n = n4) {
            final char[] a3 = jw.a;
            n4 = n + 1;
            a3[n] = c3;
        }
        final char[] a4 = jw.a;
        final int n5 = n + 1;
        a4[n] = '+';
        jw.a[n5] = '/';
        jw.b = new byte[128];
        int n6 = 0;
        int i;
        while (true) {
            final int length = jw.b.length;
            i = 0;
            if (n6 >= length) {
                break;
            }
            jw.b[n6] = -1;
            ++n6;
        }
        while (i < 64) {
            jw.b[jw.a[i]] = (byte)i;
            ++i;
        }
    }
    
    public static byte[] a(final String s) {
        final char[] charArray = s.toCharArray();
        final int length = charArray.length;
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        int n;
        for (n = length; n > 0 && charArray[n - 1] == '='; --n) {}
        final int n2 = n * 3 / 4;
        final byte[] array = new byte[n2];
        int n3 = 0;
        int i = 0;
        while (i < n) {
            final int n4 = i + 1;
            final char c = charArray[i];
            int n5 = n4 + 1;
            final char c2 = charArray[n4];
            int n7;
            if (n5 < n) {
                final int n6 = n5 + 1;
                n7 = charArray[n5];
                n5 = n6;
            }
            else {
                n7 = 65;
            }
            int n9;
            if (n5 < n) {
                final int n8 = n5 + 1;
                n9 = charArray[n5];
                i = n8;
            }
            else {
                i = n5;
                n9 = 65;
            }
            if (c > '\u007f' || c2 > '\u007f' || n7 > 127 || n9 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            final byte b = jw.b[c];
            final byte b2 = jw.b[c2];
            final byte b3 = jw.b[n7];
            final byte b4 = jw.b[n9];
            if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            final int n10 = b << 2 | b2 >>> 4;
            final int n11 = (b2 & 0xF) << 4 | b3 >>> 2;
            final int n12 = b4 | (b3 & 0x3) << 6;
            final int n13 = n3 + 1;
            array[n3] = (byte)n10;
            int n14;
            if (n13 < n2) {
                n14 = n13 + 1;
                array[n13] = (byte)n11;
            }
            else {
                n14 = n13;
            }
            if (n14 < n2) {
                final int n15 = n14 + 1;
                array[n14] = (byte)n12;
                n3 = n15;
            }
            else {
                n3 = n14;
            }
        }
        return array;
    }
    
    public static char[] a(final byte[] array) {
        final int length = array.length;
        final int n = (2 + length * 4) / 3;
        final char[] array2 = new char[4 * ((length + 2) / 3)];
        int n2 = 0;
        int i = 0;
        while (i < length) {
            int n3 = i + 1;
            final int n4 = 0xFF & array[i];
            int n6;
            if (n3 < length) {
                final int n5 = n3 + 1;
                n6 = (0xFF & array[n3]);
                n3 = n5;
            }
            else {
                n6 = 0;
            }
            int n7;
            if (n3 < length) {
                i = n3 + 1;
                n7 = (0xFF & array[n3]);
            }
            else {
                i = n3;
                n7 = 0;
            }
            final int n8 = n4 >>> 2;
            final int n9 = (n4 & 0x3) << 4 | n6 >>> 4;
            final int n10 = (n6 & 0xF) << 2 | n7 >>> 6;
            final int n11 = n7 & 0x3F;
            final int n12 = n2 + 1;
            array2[n2] = jw.a[n8];
            final int n13 = n12 + 1;
            array2[n12] = jw.a[n9];
            char c;
            if (n13 < n) {
                c = jw.a[n10];
            }
            else {
                c = '=';
            }
            array2[n13] = c;
            final int n14 = n13 + 1;
            char c2;
            if (n14 < n) {
                c2 = jw.a[n11];
            }
            else {
                c2 = '=';
            }
            array2[n14] = c2;
            n2 = n14 + 1;
        }
        return array2;
    }
}
