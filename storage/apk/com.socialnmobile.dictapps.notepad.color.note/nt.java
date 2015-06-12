import com.socialnmobile.colornote.fragment.ListEditor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class nt implements Runnable
{
    final /* synthetic */ ListEditor a;
    
    public nt(final ListEditor a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.aq != null) {
            this.a.aq.notifyDataSetChanged();
        }
        if (this.a.ap != null) {
            this.a.ap.notifyDataSetChanged();
        }
    }
}
