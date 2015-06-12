import com.socialnmobile.colornote.activity.SyncLogIn;
import android.content.Intent;
import com.socialnmobile.colornote.activity.SyncStatus;
import android.content.Context;
import android.view.View;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pv implements View$OnClickListener
{
    final /* synthetic */ SideMenuFragment a;
    
    public pv(final SideMenuFragment a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (rt.a((Context)this.a.f)) {
            this.a.f.startActivity(new Intent((Context)this.a.f, (Class)SyncStatus.class));
            return;
        }
        final Intent intent = new Intent((Context)this.a.f, (Class)SyncLogIn.class);
        intent.putExtra("SYNC_ONLY", true);
        this.a.f.startActivity(intent);
    }
}
