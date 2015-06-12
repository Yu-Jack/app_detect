import android.view.VelocityTracker;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ca
{
    static final cd a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new cc();
            return;
        }
        a = new cb();
    }
    
    public static float a(final VelocityTracker velocityTracker, final int n) {
        return ca.a.a(velocityTracker, n);
    }
    
    public static float b(final VelocityTracker velocityTracker, final int n) {
        return ca.a.b(velocityTracker, n);
    }
}
