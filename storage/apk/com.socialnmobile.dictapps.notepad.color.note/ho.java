import android.content.Context;
import android.view.animation.AnimationUtils;
import com.socialnmobile.colornote.activity.Main;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ho implements Runnable
{
    final /* synthetic */ Main a;
    
    public ho(final Main a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.p.setVisibility(8);
        this.a.p.startAnimation(AnimationUtils.loadAnimation((Context)this.a.getApplication(), 17432577));
    }
}
