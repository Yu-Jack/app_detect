import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.content.DialogInterface$OnCancelListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mo implements DialogInterface$OnCancelListener
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public mo(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final void onCancel(final DialogInterface dialogInterface) {
        if (!this.a.ag) {
            this.a.b(0);
        }
    }
}
