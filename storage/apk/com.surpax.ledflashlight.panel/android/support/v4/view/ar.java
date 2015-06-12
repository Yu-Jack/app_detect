// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewConfiguration;
import android.os.Build$VERSION;

public final class ar
{
    static final au a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new at();
            return;
        }
        a = new as();
    }
    
    public static int a(final ViewConfiguration viewConfiguration) {
        return ar.a.a(viewConfiguration);
    }
}
