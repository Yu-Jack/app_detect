// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.VelocityTracker;

class ak
{
    public static float a(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getXVelocity(n);
    }
    
    public static float b(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getYVelocity(n);
    }
}
