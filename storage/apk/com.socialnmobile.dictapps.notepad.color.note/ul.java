import java.security.NoSuchAlgorithmException;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ul
{
    final String a;
    final byte[] b;
    final byte[] c;
    final byte[] d;
    
    public ul(final String a, final byte[] b, final byte[] c, final byte[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final byte[] a(final vc vc) {
        un un;
        while (true) {
            int n = 0;
            while (true) {
                String a;
                un[] array;
                try {
                    a = this.a;
                    array = new un[] { up.a, uq.a };
                    final int length = array.length;
                    if (n >= length) {
                        throw new NoSuchAlgorithmException(a);
                    }
                }
                catch (NoSuchAlgorithmException ex) {
                    throw new tv(ex);
                }
                un = array[n];
                if (un.a().equals(a)) {
                    break;
                }
                ++n;
                continue;
            }
        }
        return un.a(vc, this);
    }
}
