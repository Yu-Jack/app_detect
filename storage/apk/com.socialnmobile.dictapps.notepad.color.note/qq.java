import android.view.KeyEvent;
import android.widget.AdapterView;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import com.socialnmobile.colornote.view.MyImageButton;
import android.widget.FrameLayout;
import android.view.View$MeasureSpec;
import android.widget.ListAdapter;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnKeyListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class qq implements View$OnKeyListener, ViewTreeObserver$OnGlobalLayoutListener, AdapterView$OnItemClickListener, PopupWindow$OnDismissListener, zp
{
    private Context a;
    private LayoutInflater b;
    private qs c;
    private int d;
    private View e;
    private boolean f;
    private ViewTreeObserver g;
    private qr h;
    private ViewGroup i;
    private rg j;
    private ArrayList k;
    private ArrayList l;
    
    public qq(final Context context, final View view, final ArrayList list, final rg rg) {
        this(context, view, list, rg, (byte)0);
    }
    
    private qq(final Context a, final View e, final ArrayList k, final rg j, final byte b) {
        this.a = a;
        this.b = LayoutInflater.from(a);
        this.f = false;
        this.k = k;
        this.j = j;
        a.getResources();
        this.d = gw.c(a, 260);
        this.e = e;
    }
    
    public qq(final Context context, final View view, final ra ra) {
        this(context, view, ra.ab().c, ra, (byte)0);
        ra.b(ra.ab());
    }
    
    private int a(final ListAdapter listAdapter) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int count = listAdapter.getCount();
        int i = 0;
        int n = 0;
        View view = null;
        int max = 0;
        while (i < count) {
            int itemViewType = listAdapter.getItemViewType(i);
            View view2;
            if (itemViewType != n) {
                view2 = null;
            }
            else {
                itemViewType = n;
                view2 = view;
            }
            if (this.i == null) {
                this.i = (ViewGroup)new FrameLayout(this.a);
            }
            view = listAdapter.getView(i, view2, this.i);
            view.measure(measureSpec, measureSpec2);
            max = Math.max(max, view.getMeasuredWidth());
            ++i;
            n = itemViewType;
        }
        return max;
    }
    
    public final void a() {
        boolean b = true;
        final yc a = gr.a(this.a);
        this.c = new qs(this.a, a.a());
        this.c.a.setOnDismissListener((PopupWindow$OnDismissListener)this);
        this.c.h = (AdapterView$OnItemClickListener)this;
        this.l = new ArrayList();
        for (final rf e : this.k) {
            if (e.h && e.i) {
                this.l.add(e);
            }
        }
        this.h = new qr(this, this.a, this.l, a.a());
        final qs c = this.c;
        final qr h = this.h;
        if (c.f == null) {
            c.f = new qw(c, (byte)0);
        }
        else if (c.b != null) {
            c.b.unregisterDataSetObserver(c.f);
        }
        c.b = (ListAdapter)h;
        if (c.b != null) {
            ((ListAdapter)h).registerDataSetObserver(c.f);
        }
        if (c.c != null) {
            c.c.setAdapter(c.b);
        }
        final qs c2 = this.c;
        c2.l = b;
        c2.a.setFocusable(b);
        final View e2 = this.e;
        if (e2 != null) {
            final boolean b2 = this.g == null && b;
            this.g = e2.getViewTreeObserver();
            if (b2) {
                this.g.addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
            }
            ((MyImageButton)e2).a(this);
            this.c.g = e2;
            final qs c3 = this.c;
            final int min = Math.min(this.a((ListAdapter)this.h), this.d);
            final Drawable background = c3.a.getBackground();
            if (background != null) {
                background.getPadding(c3.k);
                c3.d = min + (c3.k.left + c3.k.right);
            }
            else {
                c3.d = min;
            }
            this.c.a.setInputMethodMode(2);
            this.c.a();
            this.c.c.setOnKeyListener((View$OnKeyListener)this);
        }
        else {
            b = false;
        }
        if (!b) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }
    
    public final void a(final View view) {
        if (this.g != null) {
            if (!this.g.isAlive()) {
                this.g = view.getViewTreeObserver();
            }
            this.g.removeGlobalOnLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
        }
        ((MyImageButton)view).b(this);
    }
    
    public final void b() {
        if (this.c()) {
            this.c.b();
        }
    }
    
    public final boolean c() {
        return this.c != null && this.c.a.isShowing();
    }
    
    public final void onDismiss() {
        this.c = null;
        if (this.g != null) {
            if (!this.g.isAlive()) {
                this.g = this.e.getViewTreeObserver();
            }
            this.g.removeGlobalOnLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
            this.g = null;
        }
        ((MyImageButton)this.e).b(this);
    }
    
    public final void onGlobalLayout() {
        if (this.c()) {
            final View e = this.e;
            if (e == null || !e.isShown()) {
                this.b();
            }
            else if (this.c()) {
                this.c.a();
            }
        }
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int index, final long n) {
        final qr h = this.h;
        final rf rf = this.l.get(index);
        this.j.a(rf.a, rf.d);
        this.b();
    }
    
    public final boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n == 82) {
            this.b();
            return true;
        }
        return false;
    }
}
