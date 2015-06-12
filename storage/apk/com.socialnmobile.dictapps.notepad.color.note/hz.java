import android.content.Context;
import android.view.animation.AnimationUtils;
import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.NoteWidgetConfigure;
import android.content.DialogInterface$OnCancelListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hz implements DialogInterface$OnCancelListener
{
    final /* synthetic */ NoteWidgetConfigure a;
    
    public hz(final NoteWidgetConfigure a) {
        this.a = a;
    }
    
    public final void onCancel(final DialogInterface dialogInterface) {
        this.a.p.setVisibility(0);
        this.a.p.startAnimation(AnimationUtils.loadAnimation((Context)this.a, 17432576));
    }
}
