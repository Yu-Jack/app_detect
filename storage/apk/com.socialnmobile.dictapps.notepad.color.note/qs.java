import android.widget.ListView;
import android.view.ViewParent;
import android.view.View$OnTouchListener;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.AbsListView$OnScrollListener;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.widget.AbsListView$LayoutParams;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.widget.AdapterView$OnItemSelectedListener;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View;
import android.database.DataSetObserver;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

// 
// Decompiled by Procyon v0.5.29
// 

public final class qs
{
    PopupWindow a;
    ListAdapter b;
    qu c;
    int d;
    int e;
    DataSetObserver f;
    View g;
    AdapterView$OnItemClickListener h;
    final qz i;
    Handler j;
    Rect k;
    boolean l;
    private Context m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private View r;
    private int s;
    private Drawable t;
    private AdapterView$OnItemSelectedListener u;
    private final qy v;
    private final qx w;
    private final qv x;
    private boolean y;
    
    public qs(final Context m, final boolean y) {
        this.n = -2;
        this.d = -2;
        this.e = Integer.MAX_VALUE;
        this.s = 0;
        this.i = new qz(this, (byte)0);
        this.v = new qy(this, (byte)0);
        this.w = new qx(this, (byte)0);
        this.x = new qv(this, (byte)0);
        this.j = new Handler();
        this.k = new Rect();
        this.m = m;
        (this.a = new PopupWindow(m, (AttributeSet)null, 2130771968)).setInputMethodMode(1);
        this.y = y;
    }
    
    private int a(int n) {
        final ListAdapter b = this.b;
        if (b != null) {
            int n2 = this.c.getListPaddingTop() + this.c.getListPaddingBottom();
            int dividerHeight;
            if (this.c.getDividerHeight() > 0 && this.c.getDivider() != null) {
                dividerHeight = this.c.getDividerHeight();
            }
            else {
                dividerHeight = 0;
            }
            for (int n3 = -1 + b.getCount(), i = 0; i <= n3; ++i) {
                final View view = this.b.getView(i, (View)null, (ViewGroup)this.c);
                if (this.c.getCacheColorHint() != 0) {
                    view.setDrawingCacheBackgroundColor(this.c.getCacheColorHint());
                }
                AbsListView$LayoutParams layoutParams = (AbsListView$LayoutParams)view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new AbsListView$LayoutParams(-1, -2, 0);
                    view.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                }
                final int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, this.c.getPaddingLeft() + this.c.getPaddingRight(), layoutParams.width);
                final int height = layoutParams.height;
                int n4;
                if (height > 0) {
                    n4 = View$MeasureSpec.makeMeasureSpec(height, 1073741824);
                }
                else {
                    n4 = View$MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(childMeasureSpec, n4);
                int n5;
                if (i > 0) {
                    n5 = n2 + dividerHeight;
                }
                else {
                    n5 = n2;
                }
                n2 = n5 + view.getMeasuredHeight();
                if (n2 >= n) {
                    return n;
                }
            }
            return n2;
        }
        n = this.c.getListPaddingTop() + this.c.getListPaddingBottom();
        return n;
    }
    
    public final void a() {
        int selection = -1;
        int n;
        if (this.c == null) {
            final Context m = this.m;
            this.c = new qu(m, !this.l);
            if (this.t != null) {
                this.c.setSelector(this.t);
            }
            this.c.setAdapter(this.b);
            this.c.setOnItemClickListener(this.h);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new qt(this));
            this.c.setOnScrollListener((AbsListView$OnScrollListener)this.w);
            if (this.u != null) {
                this.c.setOnItemSelectedListener(this.u);
            }
            final qu c = this.c;
            final View r = this.r;
            Object contentView;
            if (r != null) {
                contentView = new LinearLayout(m);
                ((LinearLayout)contentView).setOrientation(1);
                final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(selection, 0, 1.0f);
                switch (this.s) {
                    case 1: {
                        ((LinearLayout)contentView).addView((View)c, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        ((LinearLayout)contentView).addView(r);
                        break;
                    }
                    case 0: {
                        ((LinearLayout)contentView).addView(r);
                        ((LinearLayout)contentView).addView((View)c, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        break;
                    }
                }
                r.measure(View$MeasureSpec.makeMeasureSpec(this.d, Integer.MIN_VALUE), 0);
                final LinearLayout$LayoutParams linearLayout$LayoutParams2 = (LinearLayout$LayoutParams)r.getLayoutParams();
                n = r.getMeasuredHeight() + linearLayout$LayoutParams2.topMargin + linearLayout$LayoutParams2.bottomMargin;
            }
            else {
                contentView = c;
                n = 0;
            }
            this.a.setContentView((View)contentView);
        }
        else {
            this.a.getContentView();
            final View r2 = this.r;
            if (r2 != null) {
                final LinearLayout$LayoutParams linearLayout$LayoutParams3 = (LinearLayout$LayoutParams)r2.getLayoutParams();
                n = r2.getMeasuredHeight() + linearLayout$LayoutParams3.topMargin + linearLayout$LayoutParams3.bottomMargin;
            }
            else {
                n = 0;
            }
        }
        final Drawable background = this.a.getBackground();
        int n2;
        if (background != null) {
            background.getPadding(this.k);
            n2 = this.k.top + this.k.bottom;
            if (!this.q) {
                this.p = -this.k.top;
            }
        }
        else {
            n2 = 0;
        }
        int n3;
        if (this.a.getInputMethodMode() == 2) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        final View g = this.g;
        final int p = this.p;
        final Rect rect = new Rect();
        g.getWindowVisibleDisplayFrame(rect);
        final int[] array = new int[2];
        g.getLocationOnScreen(array);
        final int bottom = rect.bottom;
        int heightPixels;
        if (n3 != 0) {
            heightPixels = g.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        else {
            heightPixels = bottom;
        }
        int max = Math.max(heightPixels - (array[1] + g.getHeight()) - p, p + (array[1] - rect.top));
        if (this.a.getBackground() != null) {
            this.a.getBackground().getPadding(this.k);
            max -= this.k.top + this.k.bottom;
        }
        int height;
        if (this.n == selection) {
            height = max + n2;
        }
        else {
            final int a = this.a(max - n);
            if (a > 0) {
                n += n2;
            }
            height = n + a;
        }
        final boolean d = this.d();
        if (this.a.isShowing()) {
            int n4;
            if (this.d == selection) {
                n4 = selection;
            }
            else if (this.d == -2) {
                n4 = this.g.getWidth();
            }
            else {
                n4 = this.d;
            }
            int n5;
            if (this.n == selection) {
                if (d) {
                    n5 = height;
                }
                else {
                    n5 = selection;
                }
                if (d) {
                    final PopupWindow a2 = this.a;
                    if (this.d != selection) {
                        selection = 0;
                    }
                    a2.setWindowLayoutMode(selection, 0);
                }
                else {
                    final PopupWindow a3 = this.a;
                    final int d2 = this.d;
                    int n6 = 0;
                    if (d2 == selection) {
                        n6 = selection;
                    }
                    a3.setWindowLayoutMode(n6, selection);
                }
            }
            else if (this.n == -2) {
                n5 = height;
            }
            else {
                n5 = this.n;
            }
            this.a.setOutsideTouchable(true);
            this.a.update(this.g, this.o, this.p, n4, n5);
        }
        else {
            int n7;
            if (this.d == selection) {
                n7 = selection;
            }
            else if (this.d == -2) {
                this.a.setWidth(this.g.getWidth());
                n7 = 0;
            }
            else {
                this.a.setWidth(this.d);
                n7 = 0;
            }
            int n8;
            if (this.n == selection) {
                n8 = selection;
            }
            else if (this.n == -2) {
                this.a.setHeight(height);
                n8 = 0;
            }
            else {
                this.a.setHeight(this.n);
                n8 = 0;
            }
            this.a.setWindowLayoutMode(n7, n8);
            this.a.setOutsideTouchable(true);
            this.a.setTouchInterceptor((View$OnTouchListener)this.v);
            this.a.showAsDropDown(this.g, this.o, this.p);
            this.c.setSelection(selection);
            if (!this.l || this.c.isInTouchMode()) {
                this.c();
            }
            if (!this.l) {
                this.j.post((Runnable)this.x);
            }
        }
    }
    
    public final void b() {
        this.a.dismiss();
        if (this.r != null) {
            final ViewParent parent = this.r.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(this.r);
            }
        }
        this.a.setContentView((View)null);
        this.c = null;
        this.j.removeCallbacks((Runnable)this.i);
    }
    
    public final void c() {
        final qu c = this.c;
        if (c != null) {
            qu.a(c, true);
            c.requestLayout();
        }
    }
    
    final boolean d() {
        return this.a.getInputMethodMode() == 2;
    }
}
