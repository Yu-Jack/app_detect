import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.SyncStatus;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ix implements DialogInterface$OnClickListener
{
    final /* synthetic */ SyncStatus a;
    
    public ix(final SyncStatus a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        gw.c(this.a.getApplicationContext());
    }
}
