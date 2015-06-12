import android.view.animation.Animation;
import android.view.View;
import com.socialnmobile.colornote.activity.Main;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hv implements View$OnClickListener
{
    final /* synthetic */ Main a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Animation c;
    
    public hv(final Main a, final View b, final Animation c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void onClick(final View view) {
        this.b.startAnimation(this.c);
    }
}
