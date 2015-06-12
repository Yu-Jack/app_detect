import android.view.animation.Animation;
import android.view.View;
import com.socialnmobile.colornote.activity.Main;
import android.view.animation.Animation$AnimationListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hu implements Animation$AnimationListener
{
    final /* synthetic */ Main a;
    private final /* synthetic */ View b;
    
    public hu(final Main a, final View b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onAnimationEnd(final Animation animation) {
        this.b.setVisibility(8);
    }
    
    public final void onAnimationRepeat(final Animation animation) {
    }
    
    public final void onAnimationStart(final Animation animation) {
    }
}
