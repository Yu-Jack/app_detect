// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.MotionEvent;

final class t implements v
{
    @Override
    public final int a(final MotionEvent motionEvent) {
        return 1;
    }
    
    @Override
    public final int a(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return 0;
        }
        return -1;
    }
    
    @Override
    public final int b(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    @Override
    public final float c(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    @Override
    public final float d(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}