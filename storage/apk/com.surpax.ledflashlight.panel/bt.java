// 
// Decompiled by Procyon v0.5.29
// 

public final class bt
{
    private static byte[] a;
    private static String b;
    
    static {
        bt.b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        bt.a = new byte[64];
        for (int i = 0; i < 64; ++i) {
            bt.a[i] = (byte)bt.b.charAt(i);
        }
    }
    
    public static String a(final byte[] array) {
        final int length = array.length;
        final byte[] bytes = new byte[(length + 2) / 3 << 2];
        final int n = length + 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n8;
        for (int i = 0; i < n; i = n8, n4 = n5) {
            final byte b = array[i];
            switch (++n3) {
                default: {
                    n5 = n4;
                    break;
                }
                case 1: {
                    n5 = n4 + 1;
                    bytes[n4] = bt.a[0x3F & b >> 2];
                    break;
                }
                case 2: {
                    n5 = n4 + 1;
                    bytes[n4] = bt.a[(0x30 & n2 << 4) | (0xF & b >> 4)];
                    break;
                }
                case 3: {
                    final int n6 = n4 + 1;
                    bytes[n4] = bt.a[(0x3C & n2 << 2) | (0x3 & b >> 6)];
                    final int n7 = n6 + 1;
                    bytes[n6] = bt.a[b & 0x3F];
                    n5 = n7;
                    n3 = 0;
                    break;
                }
            }
            n8 = i + 1;
            n2 = b;
        }
        switch (n3) {
            case 1: {
                final int n9 = n4 + 1;
                bytes[n4] = bt.a[0x30 & n2 << 4];
                bytes[n9 + 1] = (bytes[n9] = 61);
                break;
            }
            case 2: {
                final int n10 = n4 + 1;
                bytes[n4] = bt.a[0x3C & n2 << 2];
                bytes[n10] = 61;
                break;
            }
        }
        return new String(bytes);
    }
}
