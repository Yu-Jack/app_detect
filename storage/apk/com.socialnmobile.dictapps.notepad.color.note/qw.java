import android.database.DataSetObserver;

// 
// Decompiled by Procyon v0.5.29
// 

final class qw extends DataSetObserver
{
    final /* synthetic */ qs a;
    
    private qw(final qs a) {
        this.a = a;
    }
    
    public final void onChanged() {
        if (this.a.a.isShowing()) {
            this.a.a();
        }
    }
    
    public final void onInvalidated() {
        this.a.b();
    }
}
