import android.view.KeyEvent;

// 
// Decompiled by Procyon v0.5.29
// 

class bp implements bs
{
    private static int a(int n, final int n2, final int n3, final int n4, final int n5) {
        int n6 = 1;
        int n7;
        if ((n2 & n3) != 0x0) {
            n7 = n6;
        }
        else {
            n7 = 0;
        }
        final int n8 = n4 | n5;
        if ((n2 & n8) == 0x0) {
            n6 = 0;
        }
        if (n7 != 0) {
            if (n6 != 0) {
                throw new IllegalArgumentException("bad arguments");
            }
            n &= ~n8;
        }
        else if (n6 != 0) {
            return n & ~n3;
        }
        return n;
    }
    
    public int a(final int n) {
        int n2;
        if ((n & 0xC0) != 0x0) {
            n2 = (n | 0x1);
        }
        else {
            n2 = n;
        }
        if ((n2 & 0x30) != 0x0) {
            n2 |= 0x2;
        }
        return n2 & 0xF7;
    }
    
    @Override
    public void a(final KeyEvent keyEvent) {
    }
    
    @Override
    public boolean a(final int n, final int n2) {
        return a(a(0xF7 & this.a(n), n2, 1, 64, 128), n2, 2, 16, 32) == n2;
    }
    
    @Override
    public boolean b(final int n) {
        return (0xF7 & this.a(n)) == 0x0;
    }
}
