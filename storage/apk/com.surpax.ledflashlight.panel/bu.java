// 
// Decompiled by Procyon v0.5.29
// 

public class bu
{
    private static final be a;
    
    static {
        a = dh.a(bu.class);
    }
    
    public static short a(final byte[] array, final int n) {
        final short i = (short)((0xFF & array[n]) | (0xFF & array[n + 1]) << 8);
        if (bu.a.a()) {
            bu.a.a("Converted [" + array[n] + ", " + array[n + 1] + "] to short " + i);
        }
        return i;
    }
    
    public static void a(final int i, final byte[] array, final int n) {
        final short n2 = (short)i;
        final short n3 = (short)(i >> 16);
        a(n2, array, n);
        a(n3, array, n + 2);
        if (bu.a.a()) {
            bu.a.a("Converted int " + i + " to [" + array[n] + ", " + array[n + 1] + ", " + array[n + 2] + ", " + array[n + 3] + "]");
        }
    }
    
    public static void a(final short i, final byte[] array, final int n) {
        final byte b = (byte)i;
        final byte b2 = (byte)(i >> 8);
        array[n] = b;
        array[n + 1] = b2;
        if (bu.a.a()) {
            bu.a.a("Converted short " + i + " to [" + array[n] + ", " + array[n + 1] + "]");
        }
    }
    
    public static int b(final byte[] array, final int n) {
        final int i = (0xFFFF & a(array, n)) | (0xFFFF & a(array, n + 2)) << 16;
        if (bu.a.a()) {
            bu.a.a("Converted [" + array[n] + ", " + array[n + 1] + ", " + array[n + 2] + ", " + array[n + 3] + "] to int " + i);
        }
        return i;
    }
}
