import java.util.zip.CRC32;

// 
// Decompiled by Procyon v0.5.29
// 

public final class um extends adi
{
    public static final um a;
    
    static {
        a = new um();
    }
    
    private static long a(final byte[] b) {
        final CRC32 crc32 = new CRC32();
        crc32.update(b);
        return crc32.getValue();
    }
}
