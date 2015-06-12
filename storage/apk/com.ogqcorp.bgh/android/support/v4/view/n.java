// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.MotionEvent;
import android.os.Handler;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;
import android.view.GestureDetector;

class n implements k
{
    private final GestureDetector a;
    
    public n(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener, final Handler handler) {
        this.a = new GestureDetector(context, gestureDetector$OnGestureListener, handler);
    }
    
    @Override
    public void a(final boolean isLongpressEnabled) {
        this.a.setIsLongpressEnabled(isLongpressEnabled);
    }
    
    @Override
    public boolean a(final MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
