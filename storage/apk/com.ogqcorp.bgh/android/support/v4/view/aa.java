// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.MotionEvent;
import android.os.Build$VERSION;

public class aa
{
    static final ad a;
    
    static {
        if (Build$VERSION.SDK_INT >= 5) {
            a = new ac();
            return;
        }
        a = new ab();
    }
    
    public static int a(final MotionEvent motionEvent) {
        return 0xFF & motionEvent.getAction();
    }
    
    public static int a(final MotionEvent motionEvent, final int n) {
        return aa.a.a(motionEvent, n);
    }
    
    public static int b(final MotionEvent motionEvent) {
        return (0xFF00 & motionEvent.getAction()) >> 8;
    }
    
    public static int b(final MotionEvent motionEvent, final int n) {
        return aa.a.b(motionEvent, n);
    }
    
    public static float c(final MotionEvent motionEvent, final int n) {
        return aa.a.c(motionEvent, n);
    }
    
    public static int c(final MotionEvent motionEvent) {
        return aa.a.a(motionEvent);
    }
    
    public static float d(final MotionEvent motionEvent, final int n) {
        return aa.a.d(motionEvent, n);
    }
}
