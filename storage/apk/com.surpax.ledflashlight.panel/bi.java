import com.nuance.nmsp.client.sdk.oem.p;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class bi
{
    private static bi a;
    
    static {
        bi.a = new p();
    }
    
    public static String b() {
        return bi.a.a();
    }
    
    public static byte[] b(final byte[] array, final byte[] array2) {
        return bi.a.a(array, array2);
    }
    
    protected abstract String a();
    
    protected abstract byte[] a(final byte[] p0, final byte[] p1);
}
