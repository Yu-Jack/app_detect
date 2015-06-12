import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.fragment.ArchiveFragment;
import android.widget.AdapterView$OnItemSelectedListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class my implements AdapterView$OnItemSelectedListener
{
    final /* synthetic */ ArchiveFragment a;
    
    public my(final ArchiveFragment a) {
        this.a = a;
    }
    
    public final void onItemSelected(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (n == 0) {
            if (this.a.Y() == 1) {
                this.a.d.setShowSpace(false);
            }
            else {
                this.a.d.setShowSpace(true);
            }
            this.a.d.a(-1);
        }
        else {
            if (n == 1) {
                this.a.d.setShowSpace(false);
                this.a.d.a(0);
                return;
            }
            if (n == 2) {
                this.a.d.setShowSpace(false);
                this.a.d.a(16);
            }
        }
    }
    
    public final void onNothingSelected(final AdapterView adapterView) {
    }
}
