// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.MotionEvent;
import android.os.Build$VERSION;
import android.os.Handler;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;

public class j
{
    private final k a;
    
    public j(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener) {
        this(context, gestureDetector$OnGestureListener, null);
    }
    
    public j(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener, final Handler handler) {
        if (Build$VERSION.SDK_INT > 17) {
            this.a = new n(context, gestureDetector$OnGestureListener, handler);
            return;
        }
        this.a = new l(context, gestureDetector$OnGestureListener, handler);
    }
    
    public void a(final boolean b) {
        this.a.a(b);
    }
    
    public boolean a(final MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }
}
