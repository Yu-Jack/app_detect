import android.view.View;
import android.view.View$OnClickListener;
import com.socialnmobile.colornote.activity.SyncActivity;

// 
// Decompiled by Procyon v0.5.29
// 

public final class iq implements Runnable
{
    final /* synthetic */ SyncActivity a;
    private final /* synthetic */ View$OnClickListener b;
    private final /* synthetic */ View c;
    
    public iq(final SyncActivity a, final View$OnClickListener b, final View c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        this.b.onClick(this.c);
    }
}
