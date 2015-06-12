// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.os.Build$VERSION;

public class o
{
    static final p a;
    
    static {
        if (Build$VERSION.SDK_INT >= 17) {
            a = new r();
            return;
        }
        a = new q();
    }
    
    public static int a(final int n, final int n2) {
        return o.a.a(n, n2);
    }
}
