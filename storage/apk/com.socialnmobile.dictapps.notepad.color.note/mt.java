import android.view.MotionEvent;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.view.GestureDetector$SimpleOnGestureListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mt extends GestureDetector$SimpleOnGestureListener
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public mt(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final boolean onDoubleTap(final MotionEvent motionEvent) {
        if (this.a.aa()) {
            this.a.a(false, "BARTAP");
            this.a.ac.c.requestFocus();
        }
        return true;
    }
}
