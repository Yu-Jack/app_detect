// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.View$OnCreateContextMenuListener;
import android.widget.Toast;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.database.DataSetObserver;
import android.database.ContentObserver;
import java.util.List;
import android.content.SharedPreferences$Editor;
import android.preference.PreferenceManager;
import android.widget.Adapter;
import android.database.Cursor;
import java.util.ArrayList;
import android.widget.AbsListView;
import android.view.animation.Animation$AnimationListener;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.AbsListView$OnScrollListener;
import android.view.View$OnTouchListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.os.Handler;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

public class ScreenGridList extends FrameLayout implements w
{
    private static LayoutAnimationController v;
    private static LayoutAnimationController w;
    private int A;
    private int B;
    private float C;
    private boolean D;
    private boolean E;
    private String F;
    private ae G;
    private int H;
    public NoteListFragment a;
    abh b;
    int c;
    ListView d;
    GridView e;
    View f;
    TextView g;
    View h;
    AdapterView i;
    Handler j;
    public pg k;
    public kh l;
    int m;
    gs n;
    boolean o;
    boolean p;
    ListAdapter q;
    AdapterView$OnItemClickListener r;
    View$OnTouchListener s;
    Runnable t;
    AbsListView$OnScrollListener u;
    private int x;
    private boolean y;
    private boolean z;
    
    public ScreenGridList(final Context context) {
        this(context, null);
    }
    
    public ScreenGridList(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ScreenGridList(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.j = new Handler();
        this.y = false;
        this.z = false;
        this.H = 0;
        this.s = (View$OnTouchListener)new aba(this);
        this.t = new abb(this);
        this.u = (AbsListView$OnScrollListener)new abc(this);
        if (ScreenGridList.v == null) {
            ScreenGridList.v = AnimationUtils.loadLayoutAnimation(context, 2130968577);
            ScreenGridList.w = AnimationUtils.loadLayoutAnimation(context, 2130968578);
        }
        this.A = ViewConfiguration.get(context).getScaledTouchSlop();
        this.n = new gs(context);
        this.D = false;
        this.setAlwaysDrawnWithCacheEnabled(this.p = false);
    }
    
    private void a(final ListAdapter listAdapter, final int c, final boolean b) {
        this.c = c;
        this.q = listAdapter;
        if (c == 2 || c == 4) {
            this.setGridAdapter(listAdapter);
            this.e.setVisibility(0);
            this.setListAdapter(null);
            this.d.setVisibility(4);
            this.i = (AdapterView)this.e;
            this.a();
        }
        else if (c == 1 || c == 3) {
            this.setListAdapter(listAdapter);
            this.d.setVisibility(0);
            this.setGridAdapter(null);
            this.e.setVisibility(4);
            this.i = (AdapterView)this.d;
        }
        this.c();
        if (b) {
            this.d.setLayoutAnimation(ScreenGridList.w);
            this.e.setLayoutAnimation(ScreenGridList.v);
            this.i.setLayoutAnimationListener((Animation$AnimationListener)null);
            this.i.startLayoutAnimation();
            return;
        }
        this.d.setLayoutAnimation((LayoutAnimationController)null);
        this.e.setLayoutAnimation((LayoutAnimationController)null);
    }
    
    private static void a(final ArrayList list, final Cursor cursor) {
        list.clear();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                list.add(new kh(cursor));
            } while (cursor.moveToNext());
        }
        gw.a(list);
    }
    
    private Adapter e() {
        switch (this.k.d) {
            default: {
                return null;
            }
            case 1: {
                return (Adapter)this.d.getAdapter();
            }
            case 3: {
                return (Adapter)this.d.getAdapter();
            }
            case 2: {
                return (Adapter)this.e.getAdapter();
            }
            case 4: {
                return (Adapter)this.e.getAdapter();
            }
        }
    }
    
    public final void a() {
        int n = 4;
        if (this.c == n) {
            final Context context = this.getContext();
            final float density = context.getResources().getDisplayMetrics().density;
            final int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
            final int heightPixels = context.getResources().getDisplayMetrics().heightPixels;
            final float n2 = widthPixels / density;
            if (n2 >= 1280.0f) {
                n = 5;
            }
            else if (n2 < 1024.0f) {
                if (n2 >= 720.0f) {
                    n = 3;
                }
                else {
                    n = 2;
                }
            }
            final int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131361798);
            final int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(2131361807);
            final int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(2131361808);
            final int n3 = (widthPixels - dimensionPixelSize * (2 + (n - 1))) / n;
            int n4;
            int i;
            for (n4 = n, i = n3; i > heightPixels - dimensionPixelSize2 - dimensionPixelSize3; i = (widthPixels - dimensionPixelSize * (2 + (n4 - 1))) / n4) {
                ++n4;
            }
            this.B = i;
            this.C = this.getContext().getResources().getDimension(2131361797);
        }
        else {
            final Context context2 = this.getContext();
            final float density2 = context2.getResources().getDisplayMetrics().density;
            final int widthPixels2 = context2.getResources().getDisplayMetrics().widthPixels;
            final int heightPixels2 = context2.getResources().getDisplayMetrics().heightPixels;
            final float n5 = widthPixels2 / density2;
            if (n5 >= 1280.0f) {
                n = 6;
            }
            else if (n5 >= 1024.0f) {
                n = 5;
            }
            else if (n5 < 720.0f) {
                n = 3;
            }
            final int dimensionPixelSize4 = context2.getResources().getDimensionPixelSize(2131361798);
            final int dimensionPixelSize5 = context2.getResources().getDimensionPixelSize(2131361807);
            final int dimensionPixelSize6 = context2.getResources().getDimensionPixelSize(2131361808);
            final int n6 = (widthPixels2 - dimensionPixelSize4 * (2 + (n - 1))) / n;
            int n7;
            int b;
            for (n7 = n, b = n6; b * 2 > heightPixels2 - dimensionPixelSize5 - dimensionPixelSize6; b = (widthPixels2 - dimensionPixelSize4 * (2 + (n7 - 1))) / n7) {
                ++n7;
            }
            this.B = b;
            this.C = this.getContext().getResources().getDimension(2131361796);
        }
        this.e.setColumnWidth(this.B);
        final aag aag = (aag)this.e.getAdapter();
        if (aag != null) {
            aag.a(this.B);
            aag.a(this.C);
        }
        this.e.invalidateViews();
    }
    
    public final void a(final int n) {
        if (n != this.k.g) {
            this.setGridListViewOptions(this.k.b, this.k.c, this.k.e, this.k.f, n, this.k.d, true, true);
        }
    }
    
    public final void a(final int n, final boolean b) {
        if (b) {
            final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(this.getContext()).edit();
            edit.putInt("LAST_SAVED_SORT_ORDER", n);
            edit.commit();
        }
        if (n != this.k.b || this.k.a == null || (this.k.a != null && this.k.a.getCount() <= 0) || this.e() == null) {
            this.setGridListViewOptions(n, this.k.c, this.k.e, this.k.f, this.k.g, this.k.d, true, true);
        }
    }
    
    public final void a(final ae ae) {
        if (this.G == ae) {
            this.k.a = null;
            this.setListAdapter(null);
            this.setGridAdapter(null);
            this.q = null;
            this.f.setVisibility(4);
        }
    }
    
    public final void a(final View$OnClickListener onClickListener) {
        this.f.setOnClickListener(onClickListener);
        this.p = true;
    }
    
    public final void a(final NoteListFragment a, final boolean e, final pg k) {
        this.a = a;
        (this.b = a.ad()).a(1);
        this.d = (ListView)this.findViewById(2131624130);
        this.e = (GridView)this.findViewById(2131624131);
        this.f = this.findViewById(2131624132);
        this.g = (TextView)this.findViewById(2131624134);
        this.h = this.findViewById(2131624133);
        final LayoutInflater from = LayoutInflater.from(this.getContext());
        if (a.Y() == 1) {
            final TextView textView = (TextView)from.inflate(2130903078, (ViewGroup)null);
            textView.setBackgroundResource(2130837512);
            this.d.addHeaderView((View)textView);
        }
        this.k = k;
        this.E = e;
        this.b();
    }
    
    public final void a(final boolean o) {
        this.o = o;
        if (this.a.l()) {
            this.a.q().a(1, null, this);
        }
    }
    
    public final ae a_(final Bundle bundle) {
        this.f.setVisibility(4);
        return new abg(this.getContext(), this);
    }
    
    public final void b() {
        final int n = gr.a(this.getContext()).n(3);
        this.d.setBackgroundColor(n);
        this.e.setBackgroundColor(n);
        this.d.setCacheColorHint(n);
        this.e.setCacheColorHint(n);
        this.d.invalidateViews();
        this.e.invalidateViews();
    }
    
    public final void b(final int n) {
        if (n != this.k.f) {
            this.setGridListViewOptions(this.k.b, this.k.c, this.k.e, n, this.k.g, this.k.d, true, true);
        }
    }
    
    public final void b(final boolean b) {
        if (this.k.a == null || this.e() == null) {
            if ((!b && !this.a.q().a()) || b) {
                if (this.k.a == null) {
                    ++this.H;
                }
                if (this.H <= 15) {
                    this.j.postDelayed((Runnable)new abd(this), 100L);
                    return;
                }
                if (this.a.h().getPackageManager().isSafeMode()) {
                    Toast.makeText((Context)this.a.h(), 2131231064, 1).show();
                }
                else {
                    Toast.makeText((Context)this.a.h(), 2131231065, 1).show();
                }
                this.a.h().finish();
            }
            return;
        }
        this.H = 0;
    }
    
    public final void c() {
        boolean b;
        if (this.q != null && !this.q.isEmpty()) {
            b = false;
        }
        else {
            b = true;
        }
        if (b && this.p && this.k.b != 4) {
            this.f.setVisibility(0);
            if (!jo.b(this.getContext())) {
                this.h.setVisibility(0);
                this.g.setText(2131230806);
                return;
            }
            this.h.setVisibility(8);
            this.g.setText(2131231069);
        }
        else {
            this.f.setVisibility(4);
            if (!b) {
                final Context context = this.getContext();
                if (jo.b(context)) {
                    jo.a(context, "WIPE_OUT_MARK", 0);
                }
            }
        }
    }
    
    public final void c(final int n) {
        if (n != this.k.c) {
            this.setGridListViewOptions(this.k.b, n, this.k.e, this.k.f, this.k.g, this.k.d, true, true);
        }
    }
    
    public final void d() {
        switch (this.k.b) {
            default: {}
            case 0: {
                this.a(1, true);
            }
            case 1: {
                this.a(5, true);
            }
            case 5: {
                this.a(2, true);
            }
            case 2: {
                this.a(3, true);
            }
            case 3: {
                this.a(4, true);
            }
            case 4: {
                this.a(1, true);
            }
        }
    }
    
    public final void d(final int n) {
        if (n != this.k.e) {
            this.setGridListViewOptions(this.k.b, this.k.c, n, this.k.f, this.k.g, this.k.d, true, true);
        }
    }
    
    public final void e(final int n) {
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(this.getContext()).edit();
        edit.putInt("LIST_VIEW_TYPE", n);
        edit.commit();
        if (n != this.k.d) {
            this.setGridListViewOptions(this.k.b, this.k.c, this.k.e, this.k.f, this.k.g, n, true, true);
        }
    }
    
    public void setGridAdapter(final ListAdapter adapter) {
        this.e.setAdapter(adapter);
    }
    
    public void setGridListViewOptions(final int b, final int c, final int e, final int f, final int g, final int d, final boolean b2, final boolean b3) {
        this.k.b = b;
        this.k.c = c;
        this.k.d = d;
        this.k.e = e;
        this.k.f = f;
        this.k.g = g;
        if (b3) {
            this.a(b2);
        }
    }
    
    public void setListAdapter(final ListAdapter adapter) {
        this.d.setAdapter(adapter);
    }
    
    public void setListener(final AdapterView$OnItemClickListener onItemClickListener) {
        this.r = onItemClickListener;
        this.d.setOnItemClickListener(onItemClickListener);
        this.e.setOnItemClickListener(onItemClickListener);
        this.d.setOnScrollListener(this.u);
        this.e.setOnScrollListener(this.u);
        this.d.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this.a);
        this.e.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this.a);
        this.d.setOnTouchListener(this.s);
        this.e.setOnTouchListener(this.s);
    }
    
    public void setMainTitle() {
        if (!this.a.l()) {
            return;
        }
        this.b.b(0);
        this.b.c(this.k.c);
        if (this.F == null) {
            this.b.a();
        }
        else {
            final abh b = this.b;
            final String f = this.F;
            if (b.h != null) {
                b.h.setVisibility(0);
                b.h.setText((CharSequence)f);
            }
        }
        final String string = String.valueOf(this.getContext().getString(2131230996, new Object[] { this.a.ac().get(this.k.b) })) + " \u25bc";
        while (true) {
            Label_0206: {
                if (this.k.c == 0) {
                    break Label_0206;
                }
                final String a = jq.a(this.getContext(), this.k.f, this.k.c);
                if (a == null || a.equals("")) {
                    break Label_0206;
                }
                this.b.a(a);
                return;
            }
            final String a = string;
            continue;
        }
    }
    
    public void setShowSpace(final boolean d) {
        this.D = d;
    }
}
