import java.io.IOException;
import java.io.UnsupportedEncodingException;

// 
// Decompiled by Procyon v0.5.29
// 

public class acy
{
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] e;
    private static final byte[] f;
    private static final byte[] g;
    
    static {
        a = !acy.class.desiredAssertionStatus();
        b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        c = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
        d = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
        f = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
        g = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
    }
    
    public static String a(final byte[] array) {
        return a(array, array.length);
    }
    
    private static String a(final byte[] array, final int n) {
        if (array == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + n);
        }
        if (n + 0 > array.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, n, array.length));
        }
        final int n2 = 4 * (n / 3);
        Label_0217: {
            if (n % 3 <= 0) {
                break Label_0217;
            }
            int n3 = 4;
        Label_0141_Outer:
            while (true) {
                final int n4 = n3 + n2;
                final byte[] array2 = new byte[n4 + n4 / 76];
                final int n5 = n - 2;
                int n6 = 0;
                int n7 = 0;
                int n8 = 0;
                byte[] bytes;
                Label_0261_Outer:Block_9_Outer:
                while (true) {
                    Label_0222: {
                        if (n8 < n5) {
                            break Label_0222;
                        }
                        if (n8 < n) {
                            a(array, n8 + 0, n - n8, array2, n7);
                            n7 += 4;
                        }
                        Label_0270: {
                            if (n7 > -1 + array2.length) {
                                break Label_0270;
                            }
                            bytes = new byte[n7];
                            System.arraycopy(array2, 0, bytes, 0, n7);
                            try {
                                return new String(bytes, "US-ASCII");
                                while (true) {
                                    while (true) {
                                        n8 += 3;
                                        n7 += 4;
                                        continue Label_0261_Outer;
                                        n3 = 0;
                                        continue Label_0141_Outer;
                                        array2[n7 + 4] = 10;
                                        ++n7;
                                        n6 = 0;
                                        continue Block_9_Outer;
                                    }
                                    bytes = array2;
                                    return new String(bytes, "US-ASCII");
                                    a(array, n8 + 0, 3, array2, n7);
                                    n6 += 4;
                                    continue;
                                }
                            }
                            // iftrue(Label_0261:, n6 < 76)
                            catch (UnsupportedEncodingException ex) {
                                return new String(bytes);
                            }
                        }
                    }
                    break;
                }
                break;
            }
        }
    }
    
    public static byte[] a(final String s) {
        if (s == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            final byte[] array = s.getBytes("US-ASCII");
            return b(array, array.length);
        }
        catch (UnsupportedEncodingException ex) {
            final byte[] array = s.getBytes();
            return b(array, array.length);
        }
    }
    
    private static byte[] a(final byte[] array, final int n, final int n2, final byte[] array2, final int n3) {
        final byte[] b = acy.b;
        int n4;
        if (n2 > 0) {
            n4 = array[n] << 24 >>> 8;
        }
        else {
            n4 = 0;
        }
        int n5;
        if (n2 > 1) {
            n5 = array[n + 1] << 24 >>> 16;
        }
        else {
            n5 = 0;
        }
        final int n6 = n5 | n4;
        int n7 = 0;
        if (n2 > 2) {
            n7 = array[n + 2] << 24 >>> 24;
        }
        final int n8 = n7 | n6;
        switch (n2) {
            default: {
                return array2;
            }
            case 3: {
                array2[n3] = b[n8 >>> 18];
                array2[n3 + 1] = b[0x3F & n8 >>> 12];
                array2[n3 + 2] = b[0x3F & n8 >>> 6];
                array2[n3 + 3] = b[n8 & 0x3F];
                return array2;
            }
            case 2: {
                array2[n3] = b[n8 >>> 18];
                array2[n3 + 1] = b[0x3F & n8 >>> 12];
                array2[n3 + 2] = b[0x3F & n8 >>> 6];
                array2[n3 + 3] = 61;
                return array2;
            }
            case 1: {
                array2[n3] = b[n8 >>> 18];
                array2[n3 + 1] = b[0x3F & n8 >>> 12];
                array2[n3 + 3] = (array2[n3 + 2] = 61);
                return array2;
            }
        }
    }
    
    private static byte[] b(final byte[] array, final int n) {
        if (array == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (n + 0 > array.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", array.length, 0, n));
        }
        if (n == 0) {
            return new byte[0];
        }
        if (n < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + n);
        }
        final byte[] c = acy.c;
        final byte[] array2 = new byte[n * 3 / 4];
        final byte[] array3 = new byte[4];
        int i = 0;
        int n2 = 0;
        int j = 0;
        while (true) {
            while (i < n + 0) {
                final byte b = c[0xFF & array[i]];
                if (b < -5) {
                    throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", 0xFF & array[i], i));
                }
                int n3;
                int n8;
                if (b >= -1) {
                    n3 = n2 + 1;
                    array3[n2] = array[i];
                    if (n3 > 3) {
                        if (3 >= array3.length) {
                            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", array3.length, 0));
                        }
                        if (j < 0 || j + 2 >= array2.length) {
                            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", array2.length, j));
                        }
                        final byte[] c2 = acy.c;
                        int n4;
                        if (array3[2] == 61) {
                            array2[j] = (byte)(((0xFF & c2[array3[0]]) << 18 | (0xFF & c2[array3[1]]) << 12) >>> 16);
                            n4 = 1;
                        }
                        else if (array3[3] == 61) {
                            final int n5 = (0xFF & c2[array3[0]]) << 18 | (0xFF & c2[array3[1]]) << 12 | (0xFF & c2[array3[2]]) << 6;
                            array2[j] = (byte)(n5 >>> 16);
                            array2[j + 1] = (byte)(n5 >>> 8);
                            n4 = 2;
                        }
                        else {
                            final int n6 = (0xFF & c2[array3[0]]) << 18 | (0xFF & c2[array3[1]]) << 12 | (0xFF & c2[array3[2]]) << 6 | (0xFF & c2[array3[3]]);
                            array2[j] = (byte)(n6 >> 16);
                            array2[j + 1] = (byte)(n6 >> 8);
                            array2[j + 2] = (byte)n6;
                            n4 = 3;
                        }
                        final int n7 = n4 + j;
                        if (array[i] == 61) {
                            final byte[] array4 = new byte[n7];
                            System.arraycopy(array2, 0, array4, 0, n7);
                            return array4;
                        }
                        n8 = n7;
                        n3 = 0;
                    }
                    else {
                        n8 = j;
                    }
                }
                else {
                    n3 = n2;
                    n8 = j;
                }
                ++i;
                j = n8;
                n2 = n3;
            }
            final int n7 = j;
            continue;
        }
    }
}
