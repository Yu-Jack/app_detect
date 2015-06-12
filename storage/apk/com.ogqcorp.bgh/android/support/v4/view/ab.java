// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.MotionEvent;

class ab implements ad
{
    @Override
    public int a(final MotionEvent motionEvent) {
        return 1;
    }
    
    @Override
    public int a(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return 0;
        }
        return -1;
    }
    
    @Override
    public int b(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    @Override
    public float c(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    @Override
    public float d(final MotionEvent motionEvent, final int n) {
        if (n == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}
