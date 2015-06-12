import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.database.DataSetObserver;

// 
// Decompiled by Procyon v0.5.29
// 

final class me implements Runnable
{
    final /* synthetic */ md a;
    
    me(final md a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.a.Z != null) {
            this.a.a.X();
        }
    }
}
