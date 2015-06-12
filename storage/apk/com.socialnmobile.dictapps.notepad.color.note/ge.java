import java.util.zip.CRC32;
import java.security.MessageDigest;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ge extends MessageDigest
{
    private CRC32 a;
    
    public ge() {
        super("CRC");
        this.a = new CRC32();
    }
    
    public final byte[] a() {
        return this.engineDigest();
    }
    
    @Override
    protected final byte[] engineDigest() {
        final long value = this.a.getValue();
        return new byte[] { (byte)((0xFFFFFFFFFF000000L & value) >> 24), (byte)((0xFF0000L & value) >> 16), (byte)((0xFF00L & value) >> 8), (byte)((value & 0xFFL) >> 0) };
    }
    
    @Override
    protected final void engineReset() {
        this.a.reset();
    }
    
    @Override
    protected final void engineUpdate(final byte b) {
        this.a.update(b);
    }
    
    @Override
    protected final void engineUpdate(final byte[] b, final int off, final int len) {
        this.a.update(b, off, len);
    }
}
