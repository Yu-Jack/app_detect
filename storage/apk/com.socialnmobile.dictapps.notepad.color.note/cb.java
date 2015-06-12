import android.view.VelocityTracker;

// 
// Decompiled by Procyon v0.5.29
// 

final class cb implements cd
{
    @Override
    public final float a(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getXVelocity();
    }
    
    @Override
    public final float b(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getYVelocity();
    }
}
