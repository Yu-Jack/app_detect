// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.VelocityTracker;

final class ae implements ag
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
