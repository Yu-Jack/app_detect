import android.view.View;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mu implements View$OnClickListener
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public mu(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (!this.a.b()) {
            this.a.b(-1);
            return;
        }
        if (this.a.S()) {
            return;
        }
    }
}
