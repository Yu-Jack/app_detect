import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ml implements DialogInterface$OnClickListener
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public ml(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.Q();
    }
}
