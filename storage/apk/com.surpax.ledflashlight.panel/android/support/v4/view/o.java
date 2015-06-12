// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.KeyEvent;

class o implements r
{
    private static int a(int n, final int n2, final int n3, final int n4) {
        int n5 = 1;
        int n6;
        if ((n2 & 0x1) != 0x0) {
            n6 = n5;
        }
        else {
            n6 = 0;
        }
        final int n7 = n3 | n4;
        if ((n7 & 0x1) == 0x0) {
            n5 = 0;
        }
        if (n6 != 0) {
            if (n5 != 0) {
                throw new IllegalArgumentException("bad arguments");
            }
            n &= ~n7;
        }
        else if (n5 != 0) {
            return n & ~n2;
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
    public boolean b(final int n) {
        return a(a(0xF7 & this.a(n), 1, 64, 128), 2, 16, 32) == 1;
    }
    
    @Override
    public boolean c(final int n) {
        return (0xF7 & this.a(n)) == 0x0;
    }
}
