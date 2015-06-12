// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

import java.io.UnsupportedEncodingException;

public final class Base64
{
    private static final byte[] MAP;
    
    static {
        MAP = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
    }
    
    public static byte[] decode(final byte[] array) {
        return decode(array, array.length);
    }
    
    public static byte[] decode(final byte[] array, int n) {
        final int n2 = 3 * (n / 4);
        if (n2 == 0) {
            return Util.EMPTY_BYTE_ARRAY;
        }
        final byte[] array2 = new byte[n2];
        int n3 = 0;
        while (true) {
            final byte b = array[n - 1];
            if (b != 10 && b != 13 && b != 32 && b != 9) {
                if (b != 61) {
                    break;
                }
                ++n3;
            }
            --n;
        }
        int n4 = 0;
        int n5 = 0;
        int i = 0;
        int n6 = 0;
        while (i < n) {
            final byte b2 = array[i];
            int n7;
            if (b2 != 10 && b2 != 13 && b2 != 32) {
                if (b2 == 9) {
                    n7 = n6;
                }
                else {
                    int n8;
                    if (b2 >= 65 && b2 <= 90) {
                        n8 = b2 - 65;
                    }
                    else if (b2 >= 97 && b2 <= 122) {
                        n8 = b2 - 71;
                    }
                    else if (b2 >= 48 && b2 <= 57) {
                        n8 = b2 + 4;
                    }
                    else if (b2 == 43) {
                        n8 = 62;
                    }
                    else {
                        if (b2 != 47) {
                            return null;
                        }
                        n8 = 63;
                    }
                    n5 = (n5 << 6 | (byte)n8);
                    if (n4 % 4 == 3) {
                        final int n9 = n6 + 1;
                        array2[n6] = (byte)(n5 >> 16);
                        final int n10 = n9 + 1;
                        array2[n9] = (byte)(n5 >> 8);
                        n7 = n10 + 1;
                        array2[n10] = (byte)n5;
                    }
                    else {
                        n7 = n6;
                    }
                    ++n4;
                }
            }
            else {
                n7 = n6;
            }
            ++i;
            n6 = n7;
        }
        int n12 = 0;
        Label_0150: {
            if (n3 > 0) {
                final int n11 = n5 << n3 * 6;
                n12 = n6 + 1;
                array2[n6] = (byte)(n11 >> 16);
                if (n3 != 1) {
                    break Label_0150;
                }
                n6 = n12 + 1;
                array2[n12] = (byte)(n11 >> 8);
            }
            n12 = n6;
        }
        final byte[] array3 = new byte[n12];
        System.arraycopy(array2, 0, array3, 0, n12);
        return array3;
    }
    
    public static String encode(final byte[] array) {
        final byte[] array2 = new byte[4 * (2 + array.length) / 3];
        final int n = array.length - array.length % 3;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            Label_0078: {
                if (n2 < n) {
                    break Label_0078;
                }
                Label_0274: {
                    switch (array.length % 3) {
                        case 1: {
                            break Label_0274;
                        }
                        case 2: {
                            break Label_0274;
                        }
                    }
                    while (true) {
                        int n4 = n3;
                        try {
                            return new String(array2, 0, n4, "US-ASCII");
                            final int n5 = n3 + 1;
                            array2[n3] = Base64.MAP[(0xFF & array[n]) >> 2];
                            final int n6 = n5 + 1;
                            array2[n5] = Base64.MAP[(0x3 & array[n]) << 4 | (0xFF & array[n + 1]) >> 4];
                            final int n7 = n6 + 1;
                            array2[n6] = Base64.MAP[(0xF & array[n + 1]) << 2];
                            n3 = n7 + 1;
                            array2[n7] = 61;
                            continue;
                            final int n8 = n3 + 1;
                            array2[n3] = Base64.MAP[(0xFF & array[n]) >> 2];
                            final int n9 = n8 + 1;
                            array2[n8] = Base64.MAP[(0x3 & array[n]) << 4];
                            final int n10 = n9 + 1;
                            array2[n9] = 61;
                            final int n11 = n10 + 1;
                            array2[n10] = 61;
                            n4 = n11;
                            return new String(array2, 0, n4, "US-ASCII");
                            final int n12 = n3 + 1;
                            array2[n3] = Base64.MAP[(0xFF & array[n2]) >> 2];
                            final int n13 = n12 + 1;
                            array2[n12] = Base64.MAP[(0x3 & array[n2]) << 4 | (0xFF & array[n2 + 1]) >> 4];
                            final int n14 = n13 + 1;
                            array2[n13] = Base64.MAP[(0xF & array[n2 + 1]) << 2 | (0xFF & array[n2 + 2]) >> 6];
                            n3 = n14 + 1;
                            array2[n14] = Base64.MAP[0x3F & array[n2 + 2]];
                            n2 += 3;
                        }
                        catch (UnsupportedEncodingException detailMessage) {
                            throw new AssertionError((Object)detailMessage);
                        }
                        break;
                    }
                }
            }
        }
    }
}
