import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.view.NotesOptions;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.widget.AdapterView$OnItemClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aau implements AdapterView$OnItemClickListener
{
    TopBarSubMenuInfo a;
    final /* synthetic */ NotesOptions b;
    
    aau(final NotesOptions b, final TopBarSubMenuInfo a) {
        this.b = b;
        this.a = a;
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int index, final long n) {
        final rf rf = this.a.b.get(index);
        if (this.a.e != null) {
            this.a.e.a(rf.a, rf.d);
        }
        this.b.b.dismiss();
    }
}
