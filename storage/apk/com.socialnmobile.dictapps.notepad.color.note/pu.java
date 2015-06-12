import java.util.HashMap;
import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import android.widget.AdapterView$OnItemClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pu implements AdapterView$OnItemClickListener
{
    final /* synthetic */ SideMenuFragment a;
    
    public pu(final SideMenuFragment a) {
        this.a = a;
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int index, final long n) {
        this.a.h.a(this.a.g.get(index).get("MENUID"));
    }
}
