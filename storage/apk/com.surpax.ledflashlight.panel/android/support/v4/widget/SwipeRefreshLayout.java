// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.view.View$MeasureSpec;
import android.util.Log;
import android.graphics.Canvas;
import android.widget.AbsListView;
import android.support.v4.view.ah;
import android.os.Build$VERSION;
import android.support.v4.view.s;
import android.view.MotionEvent;
import android.content.res.TypedArray;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.util.AttributeSet;
import android.content.Context;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.View;
import android.view.ViewGroup;

public class SwipeRefreshLayout extends ViewGroup
{
    private static final String a;
    private static final int[] v;
    private final Runnable A;
    private final Runnable B;
    private w b;
    private View c;
    private int d;
    private y e;
    private int f;
    private boolean g;
    private int h;
    private float i;
    private int j;
    private float k;
    private float l;
    private int m;
    private int n;
    private float o;
    private float p;
    private boolean q;
    private int r;
    private boolean s;
    private final DecelerateInterpolator t;
    private final AccelerateInterpolator u;
    private final Animation w;
    private Animation x;
    private final Animation$AnimationListener y;
    private final Animation$AnimationListener z;
    
    static {
        a = SwipeRefreshLayout.class.getSimpleName();
        v = new int[] { 16842766 };
    }
    
    public SwipeRefreshLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.g = false;
        this.i = -1.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.r = -1;
        this.w = new Animation() {
            public final void applyTransformation(final float n, final Transformation transformation) {
                final int a = SwipeRefreshLayout.this.f;
                final int b = SwipeRefreshLayout.this.d;
                int n2 = 0;
                if (a != b) {
                    n2 = SwipeRefreshLayout.this.f + (int)(n * (SwipeRefreshLayout.this.d - SwipeRefreshLayout.this.f));
                }
                int n3 = n2 - SwipeRefreshLayout.this.c.getTop();
                final int top = SwipeRefreshLayout.this.c.getTop();
                if (n3 + top < 0) {
                    n3 = 0 - top;
                }
                SwipeRefreshLayout.this.a(n3);
            }
        };
        this.x = new Animation() {
            public final void applyTransformation(final float n, final Transformation transformation) {
                SwipeRefreshLayout.this.b.a(SwipeRefreshLayout.this.k + n * (0.0f - SwipeRefreshLayout.this.k));
            }
        };
        this.y = (Animation$AnimationListener)new x() {
            @Override
            public final void onAnimationEnd(final Animation animation) {
                SwipeRefreshLayout.this.n = 0;
            }
        };
        this.z = (Animation$AnimationListener)new x() {
            @Override
            public final void onAnimationEnd(final Animation animation) {
                SwipeRefreshLayout.this.l = 0.0f;
            }
        };
        this.A = new Runnable() {
            @Override
            public final void run() {
                SwipeRefreshLayout.this.s = true;
                SwipeRefreshLayout.a(SwipeRefreshLayout.this, SwipeRefreshLayout.this.n + SwipeRefreshLayout.this.getPaddingTop(), SwipeRefreshLayout.this.y);
            }
        };
        this.B = new Runnable() {
            @Override
            public final void run() {
                SwipeRefreshLayout.this.s = true;
                if (SwipeRefreshLayout.this.b != null) {
                    SwipeRefreshLayout.this.k = SwipeRefreshLayout.this.l;
                    SwipeRefreshLayout.this.x.setDuration((long)SwipeRefreshLayout.this.j);
                    SwipeRefreshLayout.this.x.setAnimationListener(SwipeRefreshLayout.this.z);
                    SwipeRefreshLayout.this.x.reset();
                    SwipeRefreshLayout.this.x.setInterpolator((Interpolator)SwipeRefreshLayout.this.t);
                    SwipeRefreshLayout.this.startAnimation(SwipeRefreshLayout.this.x);
                }
                SwipeRefreshLayout.a(SwipeRefreshLayout.this, SwipeRefreshLayout.this.n + SwipeRefreshLayout.this.getPaddingTop(), SwipeRefreshLayout.this.y);
            }
        };
        this.h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.j = this.getResources().getInteger(17694721);
        this.setWillNotDraw(false);
        this.b = new w((View)this);
        this.m = (int)(4.0f * this.getResources().getDisplayMetrics().density);
        this.t = new DecelerateInterpolator(2.0f);
        this.u = new AccelerateInterpolator(1.5f);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, SwipeRefreshLayout.v);
        this.setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
    
    private void a() {
        if (this.c == null) {
            if (this.getChildCount() > 1 && !this.isInEditMode()) {
                throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
            }
            this.c = this.getChildAt(0);
            this.d = this.c.getTop() + this.getPaddingTop();
        }
        if (this.i == -1.0f && this.getParent() != null && ((View)this.getParent()).getHeight() > 0) {
            this.i = (int)Math.min(0.6f * ((View)this.getParent()).getHeight(), 120.0f * this.getResources().getDisplayMetrics().density);
        }
    }
    
    private void a(final int n) {
        this.c.offsetTopAndBottom(n);
        this.n = this.c.getTop();
    }
    
    static /* synthetic */ void a(final SwipeRefreshLayout swipeRefreshLayout, final int f, final Animation$AnimationListener animationListener) {
        swipeRefreshLayout.f = f;
        swipeRefreshLayout.w.reset();
        swipeRefreshLayout.w.setDuration((long)swipeRefreshLayout.j);
        swipeRefreshLayout.w.setAnimationListener(animationListener);
        swipeRefreshLayout.w.setInterpolator((Interpolator)swipeRefreshLayout.t);
        swipeRefreshLayout.c.startAnimation(swipeRefreshLayout.w);
    }
    
    private void a(final MotionEvent motionEvent) {
        final int b = android.support.v4.view.s.b(motionEvent);
        if (android.support.v4.view.s.b(motionEvent, b) == this.r) {
            int n;
            if (b == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.p = android.support.v4.view.s.d(motionEvent, n);
            this.r = android.support.v4.view.s.b(motionEvent, n);
        }
    }
    
    private boolean b() {
        if (Build$VERSION.SDK_INT >= 14) {
            return ah.a(this.c);
        }
        if (this.c instanceof AbsListView) {
            final AbsListView absListView = (AbsListView)this.c;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        return this.c.getScrollY() > 0;
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        this.b.a(canvas);
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks(this.B);
        this.removeCallbacks(this.A);
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.A);
        this.removeCallbacks(this.B);
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        this.a();
        final int a = android.support.v4.view.s.a(motionEvent);
        if (this.s && a == 0) {
            this.s = false;
        }
        if (!this.isEnabled() || this.s || this.b()) {
            return false;
        }
        switch (a) {
            case 0: {
                final float y = motionEvent.getY();
                this.o = y;
                this.p = y;
                this.r = android.support.v4.view.s.b(motionEvent, 0);
                this.q = false;
                this.l = 0.0f;
                break;
            }
            case 2: {
                if (this.r == -1) {
                    Log.e(SwipeRefreshLayout.a, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                final int a2 = android.support.v4.view.s.a(motionEvent, this.r);
                if (a2 < 0) {
                    Log.e(SwipeRefreshLayout.a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                final float d = android.support.v4.view.s.d(motionEvent, a2);
                if (d - this.o > this.h) {
                    this.p = d;
                    this.q = true;
                    break;
                }
                break;
            }
            case 6: {
                this.a(motionEvent);
                break;
            }
            case 1:
            case 3: {
                this.q = false;
                this.l = 0.0f;
                this.r = -1;
                break;
            }
        }
        return this.q;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int measuredWidth = this.getMeasuredWidth();
        final int measuredHeight = this.getMeasuredHeight();
        this.b.a(measuredWidth, this.m);
        if (this.getChildCount() == 0) {
            return;
        }
        final View child = this.getChildAt(0);
        final int paddingLeft = this.getPaddingLeft();
        final int n5 = this.n + this.getPaddingTop();
        child.layout(paddingLeft, n5, measuredWidth - this.getPaddingLeft() - this.getPaddingRight() + paddingLeft, measuredHeight - this.getPaddingTop() - this.getPaddingBottom() + n5);
    }
    
    public void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.getChildCount() > 1 && !this.isInEditMode()) {
            throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
        }
        if (this.getChildCount() > 0) {
            this.getChildAt(0).measure(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 1073741824), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int a = android.support.v4.view.s.a(motionEvent);
        if (this.s && a == 0) {
            this.s = false;
        }
        if (!this.isEnabled() || this.s || this.b()) {
            return false;
        }
        switch (a) {
            case 0: {
                final float y = motionEvent.getY();
                this.o = y;
                this.p = y;
                this.r = android.support.v4.view.s.b(motionEvent, 0);
                this.q = false;
                this.l = 0.0f;
                break;
            }
            case 2: {
                final int a2 = android.support.v4.view.s.a(motionEvent, this.r);
                if (a2 < 0) {
                    Log.e(SwipeRefreshLayout.a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                final float d = android.support.v4.view.s.d(motionEvent, a2);
                final float n = d - this.o;
                if (!this.q && n > this.h) {
                    this.q = true;
                }
                if (this.q) {
                    if (n > this.i) {
                        this.removeCallbacks(this.B);
                        this.A.run();
                        if (!this.g) {
                            this.a();
                            this.l = 0.0f;
                            this.g = true;
                            if (this.g) {
                                this.b.a();
                            }
                            else {
                                this.b.b();
                            }
                        }
                        final y e = this.e;
                    }
                    else {
                        final float interpolation = this.u.getInterpolation(n / this.i);
                        if (interpolation == 0.0f) {
                            this.l = 0.0f;
                        }
                        else {
                            this.l = interpolation;
                            this.b.a(interpolation);
                        }
                        final int n2 = (int)n;
                        final int top = this.c.getTop();
                        int n3;
                        if (n2 > this.i) {
                            n3 = (int)this.i;
                        }
                        else {
                            n3 = 0;
                            if (n2 >= 0) {
                                n3 = n2;
                            }
                        }
                        this.a(n3 - top);
                        if (this.p > d && this.c.getTop() == this.getPaddingTop()) {
                            this.removeCallbacks(this.B);
                        }
                        else {
                            this.removeCallbacks(this.B);
                            this.postDelayed(this.B, 300L);
                        }
                    }
                    this.p = d;
                    break;
                }
                break;
            }
            case 5: {
                final int b = android.support.v4.view.s.b(motionEvent);
                this.p = android.support.v4.view.s.d(motionEvent, b);
                this.r = android.support.v4.view.s.b(motionEvent, b);
                break;
            }
            case 6: {
                this.a(motionEvent);
                break;
            }
            case 1:
            case 3: {
                this.q = false;
                this.l = 0.0f;
                this.r = -1;
                return false;
            }
        }
        return true;
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
    }
}
