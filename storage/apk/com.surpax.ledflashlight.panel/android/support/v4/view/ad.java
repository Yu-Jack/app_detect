// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.VelocityTracker;
import android.os.Build$VERSION;

public final class ad
{
    static final ag a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new af();
            return;
        }
        a = new ae();
    }
    
    public static float a(final VelocityTracker velocityTracker, final int n) {
        return ad.a.a(velocityTracker, n);
    }
    
    public static float b(final VelocityTracker velocityTracker, final int n) {
        return ad.a.b(velocityTracker, n);
    }
}
