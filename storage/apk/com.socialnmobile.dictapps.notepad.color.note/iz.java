import com.socialnmobile.colornote.ColorNote;
import android.content.Context;
import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.SyncStatus;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class iz implements DialogInterface$OnClickListener
{
    final /* synthetic */ SyncStatus a;
    
    public iz(final SyncStatus a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        final rt c = rt.c((Context)this.a);
        if (c != null) {
            ColorNote.a(this.a.getApplicationContext(), "SYNC", "DISCONNECT");
            c.e();
            this.a.finish();
        }
    }
}
