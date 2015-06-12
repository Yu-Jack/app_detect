// 
// Decompiled by Procyon v0.5.29
// 

public class br
{
    private static final be a;
    
    static {
        a = dh.a(br.class);
    }
    
    public static byte[] a(final byte i, final byte j, final short k, final byte[] array) {
        if (br.a.b()) {
            br.a.b("Building XMode buffer: protocol=" + i + " version=" + j + " cmd=" + k + " payload len:" + array.length);
            br.a.a(array);
        }
        final int length = array.length;
        final byte[] array2 = new byte[length + 8];
        System.arraycopy(new bs(i, j, k, length).a(), 0, array2, 0, 8);
        System.arraycopy(array, 0, array2, 8, length);
        return array2;
    }
    
    public static byte[] a(final byte[] array, final byte[] array2) {
        if (br.a.b()) {
            br.a.b("Appending session ID");
            br.a.a(array2);
            br.a.a(array);
        }
        final byte[] array3 = new byte[16 + array.length];
        System.arraycopy(array2, 0, array3, 0, 16);
        System.arraycopy(array, 0, array3, 16, array.length);
        return array3;
    }
}
