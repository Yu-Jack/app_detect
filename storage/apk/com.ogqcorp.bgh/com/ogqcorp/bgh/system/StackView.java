// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.widget.AdapterView$AdapterContextMenuInfo;
import android.widget.Adapter;
import java.util.Collection;
import java.util.Collections;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import com.ogqcorp.bgh.d;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.util.AttributeSet;
import java.util.LinkedList;
import android.view.MotionEvent;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.content.Context;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.GestureDetector;
import java.lang.ref.WeakReference;
import android.widget.AdapterView$OnItemLongClickListener;
import android.widget.AdapterView$OnItemClickListener;
import android.support.v4.c.m;
import android.view.View;
import java.util.Queue;
import android.util.SparseBooleanArray;
import android.graphics.Rect;
import java.util.ArrayList;
import android.database.DataSetObserver;
import android.view.GestureDetector$OnGestureListener;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import com.ogqcorp.bgh.c.a;
import android.widget.AdapterView;

public final class StackView extends AdapterView<a> implements View$OnClickListener, View$OnLongClickListener
{
    private GestureDetector$OnGestureListener a;
    private DataSetObserver b;
    private int c;
    private int d;
    private boolean e;
    private Integer f;
    private int g;
    private a h;
    private ArrayList<Integer> i;
    private ArrayList<Rect> j;
    private SparseBooleanArray k;
    private Queue<View> l;
    private m<Integer> m;
    private AdapterView$OnItemClickListener n;
    private AdapterView$OnItemLongClickListener o;
    private WeakReference<StackScrollView> p;
    private Rect q;
    private View r;
    private GestureDetector s;
    private ContextMenu$ContextMenuInfo t;
    
    public StackView(final Context context) {
        super(context);
        this.a = (GestureDetector$OnGestureListener)new GestureDetector$SimpleOnGestureListener() {
            public boolean onDown(final MotionEvent motionEvent) {
                for (int i = 0; i < StackView.this.getChildCount(); ++i) {
                    final View child = StackView.this.getChildAt(i);
                    child.setPressed(StackView.this.a(child, motionEvent));
                }
                return true;
            }
            
            public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
                return StackView.this.g();
            }
            
            public void onLongPress(final MotionEvent motionEvent) {
                StackView.this.g();
            }
            
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
                return StackView.this.g();
            }
            
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                return StackView.this.g();
            }
        };
        this.b = new DataSetObserver() {
            public void onChanged() {
                StackView.this.b();
                if (StackView.this.p != null) {
                    final StackScrollView stackScrollView = (StackScrollView)StackView.this.p.get();
                    if (stackScrollView != null) {
                        stackScrollView.scrollTo(0, 0);
                        stackScrollView.requestLayout();
                    }
                }
            }
            
            public void onInvalidated() {
                this.onChanged();
            }
        };
        this.c = 2;
        this.d = 10;
        this.e = false;
        this.i = new ArrayList<Integer>();
        this.j = new ArrayList<Rect>();
        this.k = new SparseBooleanArray();
        this.l = new LinkedList<View>();
        this.m = new m<Integer>();
        this.q = new Rect();
        this.a(context, null, 0);
    }
    
    public StackView(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = (GestureDetector$OnGestureListener)new GestureDetector$SimpleOnGestureListener() {
            public boolean onDown(final MotionEvent motionEvent) {
                for (int i = 0; i < StackView.this.getChildCount(); ++i) {
                    final View child = StackView.this.getChildAt(i);
                    child.setPressed(StackView.this.a(child, motionEvent));
                }
                return true;
            }
            
            public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
                return StackView.this.g();
            }
            
            public void onLongPress(final MotionEvent motionEvent) {
                StackView.this.g();
            }
            
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
                return StackView.this.g();
            }
            
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                return StackView.this.g();
            }
        };
        this.b = new DataSetObserver() {
            public void onChanged() {
                StackView.this.b();
                if (StackView.this.p != null) {
                    final StackScrollView stackScrollView = (StackScrollView)StackView.this.p.get();
                    if (stackScrollView != null) {
                        stackScrollView.scrollTo(0, 0);
                        stackScrollView.requestLayout();
                    }
                }
            }
            
            public void onInvalidated() {
                this.onChanged();
            }
        };
        this.c = 2;
        this.d = 10;
        this.e = false;
        this.i = new ArrayList<Integer>();
        this.j = new ArrayList<Rect>();
        this.k = new SparseBooleanArray();
        this.l = new LinkedList<View>();
        this.m = new m<Integer>();
        this.q = new Rect();
        this.a(context, set, 0);
    }
    
    public StackView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a = (GestureDetector$OnGestureListener)new GestureDetector$SimpleOnGestureListener() {
            public boolean onDown(final MotionEvent motionEvent) {
                for (int i = 0; i < StackView.this.getChildCount(); ++i) {
                    final View child = StackView.this.getChildAt(i);
                    child.setPressed(StackView.this.a(child, motionEvent));
                }
                return true;
            }
            
            public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
                return StackView.this.g();
            }
            
            public void onLongPress(final MotionEvent motionEvent) {
                StackView.this.g();
            }
            
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
                return StackView.this.g();
            }
            
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                return StackView.this.g();
            }
        };
        this.b = new DataSetObserver() {
            public void onChanged() {
                StackView.this.b();
                if (StackView.this.p != null) {
                    final StackScrollView stackScrollView = (StackScrollView)StackView.this.p.get();
                    if (stackScrollView != null) {
                        stackScrollView.scrollTo(0, 0);
                        stackScrollView.requestLayout();
                    }
                }
            }
            
            public void onInvalidated() {
                this.onChanged();
            }
        };
        this.c = 2;
        this.d = 10;
        this.e = false;
        this.i = new ArrayList<Integer>();
        this.j = new ArrayList<Rect>();
        this.k = new SparseBooleanArray();
        this.l = new LinkedList<View>();
        this.m = new m<Integer>();
        this.q = new Rect();
        this.a(context, set, n);
    }
    
    private int a(final int n, final int n2) {
        if (this.e && this.f != null) {
            return this.f;
        }
        Integer value = this.m.a(n);
        if (value == null) {
            (this.r = this.h.a(n, this.r, (ViewGroup)this, true)).measure(View$MeasureSpec.makeMeasureSpec(n2, 1073741824), View$MeasureSpec.makeMeasureSpec(-2, 0));
            value = this.r.getMeasuredHeight();
            this.m.b(n, value);
        }
        this.f = value;
        return value;
    }
    
    private Rect a(final View view) {
        final int[] array = new int[2];
        view.getLocationOnScreen(array);
        return new Rect(array[0], array[1], view.getWidth() + array[0], view.getHeight() + array[1]);
    }
    
    private void a(final int n) {
        if (n == 0) {
            return;
        }
        this.c = Math.max(1, this.c);
        this.g = (n - this.d) / this.c - this.d;
    }
    
    private void a(final Context context, final AttributeSet set, final int n) {
        if (set != null) {
            final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, com.ogqcorp.bgh.d.sv__StackView, n, 0);
            this.c = obtainStyledAttributes.getInteger(0, this.c);
            this.d = obtainStyledAttributes.getDimensionPixelSize(1, this.d);
            this.e = obtainStyledAttributes.getBoolean(2, this.e);
            obtainStyledAttributes.recycle();
        }
        this.s = new GestureDetector(context, this.a);
    }
    
    private void a(final View view, final int n, final int i, final Rect rect) {
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup$LayoutParams(-2, -2);
        }
        view.measure(View$MeasureSpec.makeMeasureSpec(this.g, 1073741824), View$MeasureSpec.makeMeasureSpec(this.a(i, this.g), 1073741824));
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        view.setTag(2131099704, (Object)i);
        this.addViewInLayout(view, n, layoutParams, true);
        this.k.put(i, true);
    }
    
    private boolean a(final View view, final MotionEvent motionEvent) {
        return this.a(view).contains((int)motionEvent.getRawX(), (int)motionEvent.getRawY());
    }
    
    private void b() {
        int i = 0;
        try {
            this.a(this.getMeasuredWidth());
            this.i.clear();
            for (int j = 0; j < this.c; ++j) {
                this.i.add(0);
            }
            this.j.clear();
            this.k.clear();
            while (i < this.getChildCount()) {
                this.l.offer(this.getChildAt(i));
                ++i;
            }
            this.m.c();
            this.removeAllViewsInLayout();
            this.requestLayout();
        }
        catch (Exception ex) {
            com.ogqcorp.bgh.system.l.a(ex);
        }
    }
    
    private void c() {
        this.q.set(this.getLeft(), -10 + this.getScrolledTop(), this.getRight(), 10 + this.getScrolledBottom());
    }
    
    private void d() {
        for (int n = 10 * this.c, size = this.j.size(), n2 = 0; size < this.h.getCount() && n2 < n; ++size, ++n2) {
            final int intValue = Collections.min((Collection<? extends Integer>)this.i);
            final int index = this.i.indexOf(intValue);
            final int a = this.a(size, this.g);
            final int n3 = intValue + this.d;
            final int i = a + n3;
            final int n4 = index * this.g + (index + 1) * this.d;
            final int n5 = n4 + this.g;
            this.i.set(index, i);
            this.j.add(size, new Rect(n4, n3, n5, i));
        }
    }
    
    private void e() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child != null) {
                int n;
                if (child.getBottom() > this.q.top && child.getTop() < this.q.bottom) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (n == 0) {
                    this.k.put((int)child.getTag(2131099704), false);
                    this.l.offer(child);
                    this.removeViewInLayout(child);
                }
            }
        }
    }
    
    private void f() {
        if (this.h != null) {
            for (int i = 0; i < this.j.size(); ++i) {
                final Rect rect = this.j.get(i);
                if (Rect.intersects(rect, this.q) && !this.k.get(i)) {
                    final View view = this.h.getView(i, this.l.poll(), (ViewGroup)this);
                    view.setOnClickListener((View$OnClickListener)this);
                    view.setOnLongClickListener((View$OnLongClickListener)this);
                    this.a(view, 0, i, rect);
                }
            }
        }
    }
    
    private boolean g() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            this.getChildAt(i).setPressed(false);
        }
        return false;
    }
    
    private int getScrolledBottom() {
        if (this.p != null) {
            final StackScrollView stackScrollView = this.p.get();
            if (stackScrollView != null) {
                return stackScrollView.getScrollY() + stackScrollView.getMeasuredHeight();
            }
        }
        return 0;
    }
    
    private int getScrolledTop() {
        if (this.p != null) {
            final StackScrollView stackScrollView = this.p.get();
            if (stackScrollView != null) {
                return stackScrollView.getScrollY() - this.getTop();
            }
        }
        return 0;
    }
    
    public void a() {
        this.k.clear();
        for (int i = 0; i < this.getChildCount(); ++i) {
            this.l.offer(this.getChildAt(i));
        }
        this.removeAllViewsInLayout();
        this.requestLayout();
    }
    
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) || this.s.onTouchEvent(motionEvent);
    }
    
    public a getAdapter() {
        return this.h;
    }
    
    public int getBrickPadding() {
        return this.d;
    }
    
    public int getColumnWidth() {
        return this.g;
    }
    
    protected ContextMenu$ContextMenuInfo getContextMenuInfo() {
        return this.t;
    }
    
    public int getNumColumns() {
        return this.c;
    }
    
    public View getSelectedView() {
        return null;
    }
    
    public void onClick(final View view) {
        if (this.h == null || this.n == null) {
            return;
        }
        final int intValue = (int)view.getTag(2131099704);
        this.n.onItemClick((AdapterView)this, view, intValue, this.h.getItemId(intValue));
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l.clear();
        this.r = null;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (this.h == null) {
            return;
        }
        this.c();
        this.e();
        this.f();
    }
    
    public boolean onLongClick(final View view) {
        if (this.h == null) {
            return false;
        }
        final int intValue = (int)view.getTag(2131099704);
        final long itemId = this.h.getItemId(intValue);
        if (this.o != null && this.o.onItemLongClick((AdapterView)this, view, intValue, itemId)) {
            return true;
        }
        this.t = (ContextMenu$ContextMenuInfo)new AdapterView$AdapterContextMenuInfo(view, intValue, itemId);
        final boolean showContextMenuForChild = super.showContextMenuForChild((View)this);
        this.t = null;
        return showContextMenuForChild;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.h == null) {
            return;
        }
        final int size = View$MeasureSpec.getSize(n);
        this.a(size);
        this.d();
        this.setMeasuredDimension(size, Collections.max((Collection<? extends Integer>)this.i) + this.d);
    }
    
    public void setAdapter(final a h) {
        if (this.h != null) {
            this.h.unregisterDataSetObserver(this.b);
        }
        this.h = h;
        if (this.h != null) {
            this.h.registerDataSetObserver(this.b);
        }
        this.b();
    }
    
    public void setOnItemClickListener(final AdapterView$OnItemClickListener n) {
        this.n = n;
    }
    
    public void setOnItemLongClickListener(final AdapterView$OnItemLongClickListener o) {
        this.o = o;
    }
    
    public void setScrollView(final StackScrollView referent) {
        this.p = new WeakReference<StackScrollView>(referent);
        referent.setScrollViewListener(new ab() {
            @Override
            public void a(final StackScrollView stackScrollView, final int n, final int n2, final int n3, final int n4) {
                StackView.this.g();
                StackView.this.requestLayout();
                stackScrollView.requestLayout();
            }
        });
    }
    
    public void setSelection(final int n) {
    }
}
