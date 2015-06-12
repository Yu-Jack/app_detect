// 
// Decompiled by Procyon v0.5.29
// 

public class bs
{
    private static final be d;
    public byte a;
    public short b;
    public int c;
    private byte e;
    
    static {
        d = dh.a(bs.class);
    }
    
    public bs(final byte b, final byte b2, final short n, final int n2) {
        if (bs.d.b()) {
            bs.d.b("Constructing XModeMsgHeader(protocol=" + b + ", version=" + b2 + ", cmd=" + n + ", len=" + n2 + ")");
        }
        this.a = b;
        this.e = b2;
        this.b = n;
        this.c = n2;
    }
    
    public bs(final byte[] array) {
        if (bs.d.b()) {
            bs.d.b("Constructing XModeMsgHeader(byte[])");
            bs.d.a(array);
        }
        this.a = array[0];
        this.e = array[1];
        this.b = bu.a(array, 2);
        this.c = bu.b(array, 4);
    }
    
    public final byte[] a() {
        if (bs.d.b()) {
            bs.d.b("XModeMsgHeader.getBytes()");
        }
        final byte[] array = new byte[8];
        array[0] = this.a;
        array[1] = this.e;
        bu.a(this.b, array, 2);
        bu.a(this.c, array, 4);
        if (bs.d.b()) {
            bs.d.a("Generated: ");
            bs.d.a(array);
        }
        return array;
    }
}
