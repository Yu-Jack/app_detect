// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.VelocityTracker;

class ah implements aj
{
    @Override
    public float a(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getXVelocity();
    }
    
    @Override
    public float b(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getYVelocity();
    }
}
