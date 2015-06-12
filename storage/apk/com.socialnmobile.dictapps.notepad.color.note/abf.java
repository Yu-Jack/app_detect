import com.socialnmobile.colornote.view.ScreenGridList;
import android.database.DataSetObserver;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abf extends DataSetObserver
{
    final /* synthetic */ ScreenGridList a;
    
    public abf(final ScreenGridList a) {
        this.a = a;
    }
    
    public final void onChanged() {
        this.a.c();
    }
}
