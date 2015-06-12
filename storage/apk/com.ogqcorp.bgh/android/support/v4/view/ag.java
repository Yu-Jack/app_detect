// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.VelocityTracker;
import android.os.Build$VERSION;

public class ag
{
    static final aj a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new ai();
            return;
        }
        a = new ah();
    }
    
    public static float a(final VelocityTracker velocityTracker, final int n) {
        return ag.a.a(velocityTracker, n);
    }
    
    public static float b(final VelocityTracker velocityTracker, final int n) {
        return ag.a.b(velocityTracker, n);
    }
}
