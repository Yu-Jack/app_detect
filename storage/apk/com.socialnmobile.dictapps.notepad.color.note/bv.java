import android.view.MotionEvent;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class bv
{
    static final by a;
    
    static {
        if (Build$VERSION.SDK_INT >= 5) {
            a = new bx();
            return;
        }
        a = new bw();
    }
    
    public static int a(final MotionEvent motionEvent) {
        return 0xFF & motionEvent.getAction();
    }
    
    public static int a(final MotionEvent motionEvent, final int n) {
        return bv.a.a(motionEvent, n);
    }
    
    public static int b(final MotionEvent motionEvent) {
        return (0xFF00 & motionEvent.getAction()) >> 8;
    }
    
    public static int b(final MotionEvent motionEvent, final int n) {
        return bv.a.b(motionEvent, n);
    }
    
    public static float c(final MotionEvent motionEvent, final int n) {
        return bv.a.c(motionEvent, n);
    }
    
    public static int c(final MotionEvent motionEvent) {
        return bv.a.a(motionEvent);
    }
    
    public static float d(final MotionEvent motionEvent, final int n) {
        return bv.a.d(motionEvent, n);
    }
}
