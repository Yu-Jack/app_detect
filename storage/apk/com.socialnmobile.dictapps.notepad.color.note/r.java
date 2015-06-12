import android.view.animation.Animation;
import android.support.v4.app.Fragment;
import android.view.animation.Animation$AnimationListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class r implements Animation$AnimationListener
{
    final /* synthetic */ Fragment a;
    final /* synthetic */ o b;
    
    r(final o b, final Fragment a) {
        this.b = b;
        this.a = a;
    }
    
    public final void onAnimationEnd(final Animation animation) {
        if (this.a.k != null) {
            this.a.k = null;
            this.b.a(this.a, this.a.l, 0, 0, false);
        }
    }
    
    public final void onAnimationRepeat(final Animation animation) {
    }
    
    public final void onAnimationStart(final Animation animation) {
    }
}
