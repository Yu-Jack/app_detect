// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.MotionEvent;

final class u implements v
{
    @Override
    public final int a(final MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
    
    @Override
    public final int a(final MotionEvent motionEvent, final int n) {
        return motionEvent.findPointerIndex(n);
    }
    
    @Override
    public final int b(final MotionEvent motionEvent, final int n) {
        return motionEvent.getPointerId(n);
    }
    
    @Override
    public final float c(final MotionEvent motionEvent, final int n) {
        return motionEvent.getX(n);
    }
    
    @Override
    public final float d(final MotionEvent motionEvent, final int n) {
        return motionEvent.getY(n);
    }
}
