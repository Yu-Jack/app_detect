import android.view.MotionEvent;

// 
// Decompiled by Procyon v0.5.29
// 

final class bz
{
    public static int a(final MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
    
    public static int a(final MotionEvent motionEvent, final int n) {
        return motionEvent.findPointerIndex(n);
    }
    
    public static int b(final MotionEvent motionEvent, final int n) {
        return motionEvent.getPointerId(n);
    }
    
    public static float c(final MotionEvent motionEvent, final int n) {
        return motionEvent.getX(n);
    }
    
    public static float d(final MotionEvent motionEvent, final int n) {
        return motionEvent.getY(n);
    }
}
