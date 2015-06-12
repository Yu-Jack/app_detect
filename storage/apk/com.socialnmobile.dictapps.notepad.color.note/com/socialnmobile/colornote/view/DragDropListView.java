// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.ViewGroup$LayoutParams;
import android.graphics.Bitmap$Config;
import android.view.ViewGroup;
import android.view.GestureDetector$OnGestureListener;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

public class DragDropListView extends ListView
{
    private ImageView a;
    private WindowManager b;
    private WindowManager$LayoutParams c;
    private int d;
    private int e;
    private int f;
    private int g;
    private zd h;
    private ze i;
    private zf j;
    private int k;
    private int l;
    private int m;
    private GestureDetector n;
    private int o;
    private Rect p;
    private Rect q;
    private Bitmap r;
    private final int s;
    private int t;
    private int u;
    private GradientDrawable v;
    private int w;
    private int x;
    
    public DragDropListView(final Context context, final AttributeSet set) {
        super(context, set);
        this.o = -1;
        this.p = new Rect();
        this.q = new Rect();
        this.o = -1;
        this.s = ViewConfiguration.get(context).getScaledTouchSlop();
        this.getResources();
        this.t = jp.d(context) / 2;
        this.u = jp.d(context);
        this.v = (GradientDrawable)this.getResources().getDrawable(2130837551).mutate();
    }
    
    private int a(final int n, final int n2) {
        if (n2 >= 0) {
            final Rect p2 = this.p;
            final Rect q = this.q;
            for (int i = -1 + this.getChildCount(); i >= 0; --i) {
                final View child = this.getChildAt(i);
                final View viewById = child.findViewById(2131624104);
                child.getHitRect(p2);
                viewById.getHitRect(q);
                p2.top += q.top;
                child.getHitRect(q);
                if (p2.contains(n, n2)) {
                    return i + this.getFirstVisiblePosition();
                }
                if (q.contains(n, n2)) {
                    return -1 + (i + this.getFirstVisiblePosition());
                }
            }
            return -1;
        }
        final int a = this.a(n, 0);
        if (a > 0) {
            return a;
        }
        return 0;
    }
    
    private void a() {
        if (this.a != null) {
            this.a.setVisibility(8);
            ((WindowManager)this.getContext().getSystemService("window")).removeView((View)this.a);
            this.a.setImageDrawable((Drawable)null);
            this.a = null;
        }
        if (this.r != null) {
            this.r.recycle();
            this.r = null;
        }
    }
    
    private void a(final boolean b) {
        int n = 0;
        while (true) {
            View view = this.getChildAt(n);
            if (view == null) {
                if (b) {
                    final int firstVisiblePosition = this.getFirstVisiblePosition();
                    final int top = this.getChildAt(0).getTop();
                    this.setAdapter(this.getAdapter());
                    this.setSelectionFromTop(firstVisiblePosition, top);
                }
                this.layoutChildren();
                view = this.getChildAt(n);
                if (view == null) {
                    break;
                }
            }
            ((ys)view.getTag()).a(false, null);
            ++n;
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        if (this.j != null && this.n == null && this.o == 0) {
            this.n = new GestureDetector(this.getContext(), (GestureDetector$OnGestureListener)new zc(this));
        }
        if (this.h != null || this.i != null) {
            switch (motionEvent.getAction()) {
                case 0: {
                    final int n = (int)motionEvent.getX();
                    final int n2 = (int)motionEvent.getY();
                    final int pointToPosition = this.pointToPosition(n, n2);
                    if (pointToPosition == -1) {
                        break;
                    }
                    final View child = this.getChildAt(pointToPosition - this.getFirstVisiblePosition());
                    if (!(child instanceof ViewGroup)) {
                        break;
                    }
                    final ViewGroup viewGroup = (ViewGroup)child;
                    final View viewById = viewGroup.findViewById(2131624107);
                    if (viewById == null) {
                        break;
                    }
                    this.f = n2 - viewGroup.getTop();
                    if (this.f > this.u) {
                        this.f = this.u;
                    }
                    this.g = (int)motionEvent.getRawY() - n2;
                    final Rect p = this.p;
                    viewById.getDrawingRect(p);
                    if (n < 5 + p.right) {
                        viewGroup.setDrawingCacheEnabled(true);
                        viewGroup.invalidate();
                        final Bitmap drawingCache = viewGroup.getDrawingCache();
                        Bitmap bitmap;
                        if (drawingCache == null) {
                            viewGroup.setDrawingCacheEnabled(true);
                            viewGroup.invalidate();
                            final Bitmap drawingCache2 = viewGroup.getDrawingCache();
                            if (drawingCache2 == null) {
                                bitmap = Bitmap.createBitmap(this.getWidth(), this.u, Bitmap$Config.ARGB_4444);
                                bitmap.eraseColor(-1);
                            }
                            else {
                                bitmap = Bitmap.createBitmap(drawingCache2, 0, 0, drawingCache2.getWidth(), this.u);
                            }
                        }
                        else {
                            bitmap = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), this.u);
                        }
                        this.a();
                        this.c = new WindowManager$LayoutParams();
                        this.c.gravity = 48;
                        this.c.x = 0;
                        this.c.y = n2 - this.f + this.g;
                        this.c.height = -2;
                        this.c.width = -2;
                        this.c.flags = 920;
                        this.c.format = -3;
                        this.c.windowAnimations = 0;
                        final Context context = this.getContext();
                        final ImageView a = new ImageView(context);
                        a.setBackgroundColor(context.getResources().getColor(2131165184));
                        a.setImageBitmap(bitmap);
                        this.r = bitmap;
                        (this.b = (WindowManager)context.getSystemService("window")).addView((View)a, (ViewGroup$LayoutParams)this.c);
                        this.a = a;
                        this.d = pointToPosition;
                        this.e = this.d;
                        this.m = this.getHeight();
                        final int s = this.s;
                        this.k = Math.min(n2 - s, this.m / 3);
                        this.l = Math.max(s + n2, 2 * this.m / 3);
                        return false;
                    }
                    this.a();
                    break;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.n != null) {
            this.n.onTouchEvent(motionEvent);
        }
        if ((this.h != null || this.i != null) && this.a != null) {
            final int action = motionEvent.getAction();
            switch (action) {
                case 1:
                case 3: {
                    final Rect p = this.p;
                    this.a.getDrawingRect(p);
                    this.a();
                    if (this.o == 1 && motionEvent.getX() > 3 * p.right / 4) {
                        if (this.j != null) {
                            this.j.a(this.e);
                        }
                        this.a(true);
                        return true;
                    }
                    if (this.i != null && this.d >= 0 && this.d < this.getCount()) {
                        this.i.a(this.e, this.d);
                    }
                    this.a(false);
                    return true;
                }
                case 0:
                case 2: {
                    final int x = (int)motionEvent.getX();
                    final int n = (int)motionEvent.getY();
                    if (this.o == 1) {
                        float alpha = 1.0f;
                        final int width = this.a.getWidth();
                        if (x > width / 2) {
                            alpha = (width - x) / (width / 2);
                        }
                        this.c.alpha = alpha;
                    }
                    if (this.o == 0) {
                        this.c.x = x;
                    }
                    this.c.y = n - this.f + this.g;
                    this.b.updateViewLayout((View)this.a, (ViewGroup$LayoutParams)this.c);
                    final int n2 = n - this.f - this.t;
                    int a = this.a(0, n2);
                    if (a >= 0) {
                        if (a <= this.e) {
                            ++a;
                        }
                    }
                    else if (n2 < 0) {
                        a = 0;
                    }
                    final int firstVisiblePosition = this.getFirstVisiblePosition();
                    final int childCount = this.getChildCount();
                    if (a < 0) {
                        break;
                    }
                    if (action == 0 || a != this.d || this.w != firstVisiblePosition || firstVisiblePosition + childCount != this.w + this.x) {
                        if (this.h != null) {
                            final zd h = this.h;
                            final int d = this.d;
                        }
                        this.w = firstVisiblePosition;
                        this.x = childCount;
                        this.d = a;
                        if (this.d > -1 + (-1 + this.getCount())) {
                            this.d = -1 + (-1 + this.getCount());
                        }
                        final int n3 = this.d - this.getFirstVisiblePosition();
                        int n4;
                        if (this.d > this.e) {
                            n4 = n3 + 1;
                        }
                        else {
                            n4 = n3;
                        }
                        final View child = this.getChildAt(this.e - this.getFirstVisiblePosition());
                        int n5 = 0;
                        while (true) {
                            final View child2 = this.getChildAt(n5);
                            if (child2 == null) {
                                break;
                            }
                            final ys ys = (ys)child2.getTag();
                            if (child2.equals(child)) {
                                ys.e.setVisibility(8);
                                ys.c.setVisibility(0);
                                ys.d.setVisibility(8);
                                int n6;
                                if (this.d == this.e) {
                                    n6 = -2;
                                }
                                else {
                                    n6 = 1;
                                }
                                gw.a(child2, n6);
                            }
                            else if (n5 == n4) {
                                if (this.d < 1 + (-1 + this.getCount())) {
                                    ys.a(true, (Drawable)this.v);
                                }
                            }
                            else {
                                ys.a(false, null);
                            }
                            ++n5;
                        }
                    }
                    if (n >= this.m / 3) {
                        this.k = this.m / 3;
                    }
                    if (n <= 2 * this.m / 3) {
                        this.l = 2 * this.m / 3;
                    }
                    int n8;
                    if (n > this.l) {
                        int n7;
                        if (n > (this.m + this.l) / 2) {
                            n7 = 16;
                        }
                        else {
                            n7 = 4;
                        }
                        n8 = n7;
                    }
                    else if (n < this.k) {
                        int n9;
                        if (n < this.k / 2) {
                            n9 = -16;
                        }
                        else {
                            n9 = -4;
                        }
                        n8 = n9;
                    }
                    else {
                        n8 = 0;
                    }
                    if (n8 == 0) {
                        break;
                    }
                    int n10 = this.pointToPosition(0, this.m / 2);
                    if (n10 == -1) {
                        n10 = this.pointToPosition(0, this.m / 2 + this.getDividerHeight());
                    }
                    if (n10 == -1) {
                        n10 = this.pointToPosition(0, this.m / 2 + this.u);
                    }
                    final View child3 = this.getChildAt(n10 - this.getFirstVisiblePosition());
                    if (child3 != null) {
                        this.setSelectionFromTop(n10, child3.getTop() - n8);
                        return true;
                    }
                    break;
                }
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
    
    public void setColor(final int n) {
        this.v.setColor(gr.a(this.getContext()).d(n));
    }
    
    public void setDragListener(final zd h) {
        this.h = h;
    }
    
    public void setDropListener(final ze i) {
        this.i = i;
    }
    
    public void setRemoveListener(final zf j) {
        this.j = j;
    }
}
