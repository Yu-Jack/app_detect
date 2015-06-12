import android.view.VelocityTracker;

// 
// Decompiled by Procyon v0.5.29
// 

final class ce
{
    public static float a(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getXVelocity(n);
    }
    
    public static float b(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getYVelocity(n);
    }
}
