// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public class Base64
{
    private static final String ENCODE_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    
    public static byte[] decode(final String s) {
        int index = 0;
        if (Utils.isNullOrWhiteSpace(s)) {
            throw new IllegalArgumentException("Encoded String must not be null or white space");
        }
        final int decodedLength = getDecodedLength(s);
        if (decodedLength <= 0) {
            throw new IllegalArgumentException("Encoded String decodes to zero bytes");
        }
        final byte[] array = new byte[decodedLength];
        int n = 0;
    Label_0128_Outer:
        while (index < s.length() && n < decodedLength && (index % 4 != 0 || s.length() >= index + 4)) {
            final int index2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index));
            if (index2 != -1) {
                while (true) {
                    int n2 = 0;
                    Label_0260: {
                        switch (index % 4) {
                            case 0: {
                                array[n] = (byte)(index2 << 2);
                                break;
                            }
                            case 1: {
                                n2 = n + 1;
                                array[n] |= (byte)(0x3 & index2 >> 4);
                                if (n2 < decodedLength) {
                                    array[n2] = (byte)(index2 << 4);
                                    n = n2;
                                    break;
                                }
                                break Label_0260;
                            }
                            case 2: {
                                n2 = n + 1;
                                array[n] |= (byte)(0xF & index2 >> 2);
                                if (n2 < decodedLength) {
                                    array[n2] = (byte)(index2 << 6);
                                    n = n2;
                                    break;
                                }
                                break Label_0260;
                            }
                            case 3: {
                                n2 = n + 1;
                                array[n] |= (byte)(index2 & 0x3F);
                                break Label_0260;
                            }
                        }
                        ++index;
                        continue Label_0128_Outer;
                    }
                    n = n2;
                    continue;
                }
            }
            break;
        }
        return array;
    }
    
    private static int getDecodedLength(final String s) {
        final int index = s.indexOf("=");
        int n = 0;
        if (index >= 0) {
            n = s.length() - index;
        }
        return 3 * ((3 + s.length()) / 4) - n;
    }
}
