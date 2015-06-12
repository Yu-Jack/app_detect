import android.database.Cursor;
import android.widget.ListAdapter;
import java.util.List;
import android.content.Context;
import android.widget.GridView;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.widget.AdapterView$OnItemLongClickListener;
import java.util.HashMap;
import java.util.ArrayList;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class kv implements AdapterView$OnItemClickListener
{
    final /* synthetic */ ku a;
    
    kv(final ku a) {
        this.a = a;
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.a.g.b(((jy)this.a.i.getItem(n)).b);
        this.a.dismiss();
    }
}
