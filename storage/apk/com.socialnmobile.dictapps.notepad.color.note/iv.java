import android.widget.Toast;
import android.content.Context;
import android.view.View;
import com.socialnmobile.colornote.activity.SyncStatus;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class iv implements View$OnClickListener
{
    final /* synthetic */ SyncStatus a;
    
    public iv(final SyncStatus a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        final rt c = rt.c((Context)this.a);
        if (c != null) {
            Toast.makeText((Context)this.a, (CharSequence)("ID : " + c.m()), 1).show();
        }
    }
}
