import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.SendToNoteByTitle;
import android.content.DialogInterface$OnCancelListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class im implements DialogInterface$OnCancelListener
{
    final /* synthetic */ SendToNoteByTitle a;
    
    public im(final SendToNoteByTitle a) {
        this.a = a;
    }
    
    public final void onCancel(final DialogInterface dialogInterface) {
        this.a.finish();
    }
}
