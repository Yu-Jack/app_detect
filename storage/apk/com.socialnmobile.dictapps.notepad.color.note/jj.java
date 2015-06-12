import android.view.Menu;
import android.view.MenuItem;
import android.view.ActionMode;
import android.view.ActionMode$Callback;

// 
// Decompiled by Procyon v0.5.29
// 

final class jj implements ActionMode$Callback
{
    final /* synthetic */ ji a;
    private final /* synthetic */ yo b;
    
    jj(final ji a, final yo b) {
        this.a = a;
        this.b = b;
    }
    
    public final boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
        return this.b.a(menuItem);
    }
    
    public final boolean onCreateActionMode(final ActionMode actionMode, final Menu menu) {
        return this.b.a(actionMode.getMenuInflater(), menu);
    }
    
    public final void onDestroyActionMode(final ActionMode actionMode) {
        this.b.b();
    }
    
    public final boolean onPrepareActionMode(final ActionMode actionMode, final Menu menu) {
        return this.b.a();
    }
}
