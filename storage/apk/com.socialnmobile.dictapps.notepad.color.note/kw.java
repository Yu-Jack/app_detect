import android.database.Cursor;
import android.widget.ListAdapter;
import java.util.List;
import android.content.Context;
import android.widget.GridView;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.widget.AdapterView$OnItemClickListener;
import java.util.HashMap;
import java.util.ArrayList;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemLongClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class kw implements AdapterView$OnItemLongClickListener
{
    final /* synthetic */ ku a;
    
    kw(final ku a) {
        this.a = a;
    }
    
    public final boolean onItemLongClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        final jy jy = (jy)this.a.i.getItem(n);
        if (jy.b != 0) {
            if (this.a.c != -1) {
                this.a.g.a(this.a.c, jy.b);
            }
            return true;
        }
        return false;
    }
}
