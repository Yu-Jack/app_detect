import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class qy implements View$OnTouchListener
{
    final /* synthetic */ qs a;
    
    private qy(final qs a) {
        this.a = a;
    }
    
    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        final int n = (int)motionEvent.getX();
        final int n2 = (int)motionEvent.getY();
        if (action == 0 && this.a.a != null && this.a.a.isShowing() && n >= 0 && n < this.a.a.getWidth() && n2 >= 0 && n2 < this.a.a.getHeight()) {
            this.a.j.postDelayed((Runnable)this.a.i, 250L);
        }
        else if (action == 1) {
            this.a.j.removeCallbacks((Runnable)this.a.i);
        }
        return false;
    }
}
