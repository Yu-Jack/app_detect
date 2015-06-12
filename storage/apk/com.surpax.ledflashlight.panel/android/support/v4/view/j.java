// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.os.Build$VERSION;

public final class j
{
    static final k a;
    
    static {
        if (Build$VERSION.SDK_INT >= 17) {
            a = new m();
            return;
        }
        a = new l();
    }
    
    public static int a(final int n, final int n2) {
        return j.a.a(n, n2);
    }
}
