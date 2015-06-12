import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.database.DataSetObserver;

// 
// Decompiled by Procyon v0.5.29
// 

public final class md extends DataSetObserver
{
    final /* synthetic */ AbstractEditorViewer a;
    
    public md(final AbstractEditorViewer a) {
        this.a = a;
    }
    
    public final void onChanged() {
        super.onChanged();
        this.a.h().runOnUiThread((Runnable)new me(this));
    }
}
