import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class zh implements View$OnTouchListener
{
    final /* synthetic */ zg a;
    
    public zh(final zg a) {
        this.a = a;
    }
    
    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
        if (this.a.k) {
            this.a.h.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
