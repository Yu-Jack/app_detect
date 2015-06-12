import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.fragment.ArchiveFragment;
import android.widget.AdapterView$OnItemSelectedListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mx implements AdapterView$OnItemSelectedListener
{
    final /* synthetic */ ArchiveFragment a;
    
    public mx(final ArchiveFragment a) {
        this.a = a;
    }
    
    public final void onItemSelected(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (n == 0) {
            this.a.d.b(-1);
        }
        else {
            if (n == 1) {
                this.a.d.b(0);
                return;
            }
            if (n == 2) {
                this.a.d.b(16);
            }
        }
    }
    
    public final void onNothingSelected(final AdapterView adapterView) {
    }
}
