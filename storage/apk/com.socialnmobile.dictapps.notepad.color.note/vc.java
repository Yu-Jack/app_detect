// 
// Decompiled by Procyon v0.5.29
// 

public final class vc
{
    final byte[] a;
    final byte[] b;
    
    public vc(final byte[] array, final byte[] array2) {
        final int length = array.length;
        final int length2 = array2.length;
        if (length != 16) {
            throw new IllegalArgumentException("size of key128 should be 16 bytes; given " + length + " bytes");
        }
        if (length2 != 32) {
            throw new IllegalArgumentException("size of key256 should be 32 bytes; given " + length2 + " bytes");
        }
        this.a = array.clone();
        this.b = array2.clone();
    }
    
    public final byte[] a() {
        return this.a.clone();
    }
    
    public final byte[] b() {
        return this.b.clone();
    }
    
    @Override
    public final String toString() {
        return ((xj)new vd().c(this)).toString();
    }
}
