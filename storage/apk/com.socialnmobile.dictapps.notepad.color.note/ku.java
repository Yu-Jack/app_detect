import android.database.Cursor;
import android.widget.ListAdapter;
import java.util.List;
import android.content.Context;
import android.widget.GridView;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.widget.AdapterView$OnItemLongClickListener;
import android.widget.AdapterView$OnItemClickListener;
import java.util.HashMap;
import java.util.ArrayList;
import android.app.Dialog;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ku extends Dialog implements pf
{
    ArrayList a;
    HashMap b;
    int c;
    int d;
    AdapterView$OnItemClickListener e;
    AdapterView$OnItemLongClickListener f;
    private NoteListFragment g;
    private GridView h;
    private yx i;
    
    public ku(final NoteListFragment g) {
        super((Context)g.h());
        this.a = new ArrayList();
        this.b = new HashMap();
        this.e = (AdapterView$OnItemClickListener)new kv(this);
        this.f = (AdapterView$OnItemLongClickListener)new kw(this);
        this.setTitle(2131230803);
        this.g = g;
        this.setContentView(2130903051);
        this.setCanceledOnTouchOutside(true);
        (this.h = (GridView)this.findViewById(2131624010)).setOnItemLongClickListener(this.f);
        this.h.setOnItemClickListener(this.e);
        this.i = new yx(this.getContext(), this.a);
        this.h.setAdapter((ListAdapter)this.i);
        this.h.setBackgroundColor(gr.a((Context)g.h()).n(12));
    }
    
    private void a(final int i) {
        this.a.add(new jy(i, jq.a(this.getContext(), this.c, i), this.b.get(i)));
    }
    
    private void b() {
        final int f = this.g.W().f;
        final int g = this.g.W().g;
        this.c = f;
        this.d = g;
        if (this.c != -1) {
            this.i.a(true);
        }
        else {
            this.i.a(false);
        }
        this.c();
        this.a.clear();
        this.c();
        int n;
        if (this.c != -1) {
            final Context context = this.getContext();
            final int c = this.c;
            final int d = this.d;
            String obj = "active_state = 0 AND account_id = 0 AND folder_id = " + c;
            if (d != -1) {
                obj = String.valueOf(obj) + " AND space = " + d;
            }
            final Cursor query = context.getContentResolver().query(kf.c, (String[])null, obj, (String[])null, (String)null);
            if (query.moveToFirst()) {
                n = 0;
                do {
                    final int int1 = query.getInt(query.getColumnIndex("color_index"));
                    final int int2 = query.getInt(query.getColumnIndex("notes_count"));
                    this.b.put(int1, int2);
                    n += int2;
                } while (query.moveToNext());
            }
            else {
                n = 0;
            }
            query.close();
        }
        else {
            n = 0;
        }
        this.a.add(new jy(0, this.getContext().getString(2131230768), n));
        this.a(1);
        this.a(2);
        this.a(3);
        this.a(4);
        this.a(5);
        this.a(6);
        this.a(7);
        this.a(8);
        this.a(9);
        this.i.notifyDataSetChanged();
    }
    
    private void c() {
        this.b.put(1, 0);
        this.b.put(2, 0);
        this.b.put(3, 0);
        this.b.put(4, 0);
        this.b.put(5, 0);
        this.b.put(6, 0);
        this.b.put(7, 0);
        this.b.put(8, 0);
        this.b.put(9, 0);
    }
    
    public final void a() {
        this.b();
    }
    
    protected final void onStart() {
        this.b();
        this.g.a(this);
    }
    
    protected final void onStop() {
        super.onStop();
        this.g.b(this);
    }
}
