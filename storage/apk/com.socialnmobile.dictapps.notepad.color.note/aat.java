import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView$OnItemClickListener;
import com.socialnmobile.colornote.fragment.ScreenFragment;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.socialnmobile.colornote.view.NotesOptions;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aat extends zt
{
    final /* synthetic */ NotesOptions a;
    
    public aat(final NotesOptions a) {
        this.a = a;
    }
    
    @Override
    public final Object a(final ViewGroup viewGroup, final int n) {
        final Context context = viewGroup.getContext();
        final LayoutInflater from = LayoutInflater.from(context);
        if (n == 0) {
            final ListView listView = (ListView)from.inflate(2130903091, viewGroup, false);
            final TopBarSubMenuInfo a = rh.a(this.a.a, this.a.a.c("BAR"));
            listView.setAdapter(a.b(context));
            listView.setOnItemClickListener((AdapterView$OnItemClickListener)new aau(this.a, a));
            viewGroup.addView((View)listView);
            return listView;
        }
        if (n == 1) {
            final ListView listView2 = (ListView)from.inflate(2130903091, viewGroup, false);
            final TopBarSubMenuInfo a2 = rh.a(context, this.a.a.d("BAR"));
            listView2.setAdapter(a2.b(context));
            listView2.setOnItemClickListener((AdapterView$OnItemClickListener)new aau(this.a, a2));
            viewGroup.addView((View)listView2);
            return listView2;
        }
        return null;
    }
    
    @Override
    public final void a(final ViewGroup viewGroup, final int n, final Object o) {
        viewGroup.removeView((View)o);
    }
    
    @Override
    public final boolean a(final View view, final Object o) {
        return view == o;
    }
}
