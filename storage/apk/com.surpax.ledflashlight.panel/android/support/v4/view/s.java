// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.MotionEvent;
import android.os.Build$VERSION;

public final class s
{
    static final v a;
    
    static {
        if (Build$VERSION.SDK_INT >= 5) {
            a = new u();
            return;
        }
        a = new t();
    }
    
    public static int a(final MotionEvent motionEvent) {
        return 0xFF & motionEvent.getAction();
    }
    
    public static int a(final MotionEvent motionEvent, final int n) {
        return s.a.a(motionEvent, n);
    }
    
    public static int b(final MotionEvent motionEvent) {
        return (0xFF00 & motionEvent.getAction()) >> 8;
    }
    
    public static int b(final MotionEvent motionEvent, final int n) {
        return s.a.b(motionEvent, n);
    }
    
    public static float c(final MotionEvent motionEvent, final int n) {
        return s.a.c(motionEvent, n);
    }
    
    public static int c(final MotionEvent motionEvent) {
        return s.a.a(motionEvent);
    }
    
    public static float d(final MotionEvent motionEvent, final int n) {
        return s.a.d(motionEvent, n);
    }
}
