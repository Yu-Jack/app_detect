import android.content.Intent;
import com.socialnmobile.colornote.activity.SyncLogIn;
import android.content.Context;
import android.view.View;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pw implements View$OnClickListener
{
    final /* synthetic */ SideMenuFragment a;
    
    public pw(final SideMenuFragment a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (rt.a((Context)this.a.f)) {
            this.a.f.a(true, true, "SIDEMENU");
            this.a.f.j();
            return;
        }
        final Intent intent = new Intent((Context)this.a.f, (Class)SyncLogIn.class);
        intent.putExtra("SYNC_ONLY", true);
        this.a.f.startActivity(intent);
    }
}
