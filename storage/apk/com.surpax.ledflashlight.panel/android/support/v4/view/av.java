// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.os.Build$VERSION;

public final class av
{
    static final ay a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 18) {
            a = new az();
            return;
        }
        if (sdk_INT >= 14) {
            a = new ax();
            return;
        }
        if (sdk_INT >= 11) {
            a = new aw();
            return;
        }
        a = new ba();
    }
    
    public static void a(final ViewGroup viewGroup) {
        av.a.a(viewGroup);
    }
}
