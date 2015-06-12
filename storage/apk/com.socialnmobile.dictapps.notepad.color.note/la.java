import android.content.DialogInterface;
import android.content.Intent;
import com.socialnmobile.colornote.dialog.DialogFactory$DownloadColorDictDialogFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class la implements DialogInterface$OnClickListener
{
    final /* synthetic */ DialogFactory$DownloadColorDictDialogFragment a;
    private final /* synthetic */ Intent b;
    
    public la(final DialogFactory$DownloadColorDictDialogFragment a, final Intent b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.a(this.b);
    }
}
