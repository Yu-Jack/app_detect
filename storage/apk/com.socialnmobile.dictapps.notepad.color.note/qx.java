import android.widget.AbsListView;
import android.widget.AbsListView$OnScrollListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class qx implements AbsListView$OnScrollListener
{
    final /* synthetic */ qs a;
    
    private qx(final qs a) {
        this.a = a;
    }
    
    public final void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
    }
    
    public final void onScrollStateChanged(final AbsListView absListView, final int n) {
        if (n == 1 && !this.a.d() && this.a.a.getContentView() != null) {
            this.a.j.removeCallbacks((Runnable)this.a.i);
            this.a.i.run();
        }
    }
}
