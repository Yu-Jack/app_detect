// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.util.AttributeSet;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.al;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Paint;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.graphics.Rect;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class SlidingPaneLayout extends ViewGroup
{
    static final y a;
    private int b;
    private int c;
    private Drawable d;
    private final int e;
    private boolean f;
    private View g;
    private float h;
    private float i;
    private int j;
    private boolean k;
    private int l;
    private float m;
    private float n;
    private x o;
    private final ac p;
    private boolean q;
    private boolean r;
    private final Rect s;
    private final ArrayList<v> t;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 17) {
            a = new ab();
            return;
        }
        if (sdk_INT >= 16) {
            a = new aa();
            return;
        }
        a = new z();
    }
    
    private void a(final float i) {
        int j = 0;
        final w w = (w)this.g.getLayoutParams();
        final boolean b = w.c && w.leftMargin <= 0;
        while (j < this.getChildCount()) {
            final View child = this.getChildAt(j);
            if (child != this.g) {
                final int n = (int)((1.0f - this.i) * this.l);
                this.i = i;
                child.offsetLeftAndRight(n - (int)((1.0f - i) * this.l));
                if (b) {
                    this.a(child, 1.0f - this.i, this.c);
                }
            }
            ++j;
        }
    }
    
    private void a(final View view, final float n, final int n2) {
        final w w = (w)view.getLayoutParams();
        if (n > 0.0f && n2 != 0) {
            final int n3 = (int)(n * ((0xFF000000 & n2) >>> 24)) << 24 | (0xFFFFFF & n2);
            if (w.d == null) {
                w.d = new Paint();
            }
            w.d.setColorFilter((ColorFilter)new PorterDuffColorFilter(n3, PorterDuff$Mode.SRC_OVER));
            if (al.d(view) != 2) {
                al.a(view, 2, w.d);
            }
            this.d(view);
        }
        else if (al.d(view) != 0) {
            if (w.d != null) {
                w.d.setColorFilter((ColorFilter)null);
            }
            final v e = new v(this, view);
            this.t.add(e);
            al.a((View)this, e);
        }
    }
    
    private boolean a(final View view, final int n) {
        if (!this.r) {
            final boolean a = this.a(0.0f, n);
            final boolean b = false;
            if (!a) {
                return b;
            }
        }
        this.q = false;
        return true;
    }
    
    private boolean b(final View view, final int n) {
        return (this.r || this.a(1.0f, n)) && (this.q = true);
    }
    
    private static boolean c(final View view) {
        if (!al.f(view)) {
            if (Build$VERSION.SDK_INT >= 18) {
                return false;
            }
            final Drawable background = view.getBackground();
            if (background == null) {
                return false;
            }
            if (background.getOpacity() != -1) {
                return false;
            }
        }
        return true;
    }
    
    private void d(final View view) {
        SlidingPaneLayout.a.a(this, view);
    }
    
    void a() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 4) {
                child.setVisibility(0);
            }
        }
    }
    
    void a(final View view) {
        final int paddingLeft = this.getPaddingLeft();
        final int a = this.getWidth() - this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int a2 = this.getHeight() - this.getPaddingBottom();
        int left;
        int right;
        int top;
        int bottom;
        if (view != null && c(view)) {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        else {
            bottom = 0;
            top = 0;
            right = 0;
            left = 0;
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child == view) {
                break;
            }
            final int max = Math.max(paddingLeft, child.getLeft());
            final int max2 = Math.max(paddingTop, child.getTop());
            final int min = Math.min(a, child.getRight());
            final int min2 = Math.min(a2, child.getBottom());
            int visibility;
            if (max >= left && max2 >= top && min <= right && min2 <= bottom) {
                visibility = 4;
            }
            else {
                visibility = 0;
            }
            child.setVisibility(visibility);
        }
    }
    
    boolean a(final float n, final int n2) {
        if (!this.f) {
            return false;
        }
        if (this.p.a(this.g, (int)(this.getPaddingLeft() + ((w)this.g.getLayoutParams()).leftMargin + n * this.j), this.g.getTop())) {
            this.a();
            al.b((View)this);
            return true;
        }
        return false;
    }
    
    public boolean b() {
        return this.b(this.g, 0);
    }
    
    boolean b(final View view) {
        if (view == null) {
            return false;
        }
        final w w = (w)view.getLayoutParams();
        return this.f && w.c && this.h > 0.0f;
    }
    
    public boolean c() {
        return this.a(this.g, 0);
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof w && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        if (this.p.a(true)) {
            if (this.f) {
                al.b((View)this);
                return;
            }
            this.p.f();
        }
    }
    
    public boolean d() {
        return !this.f || this.h == 1.0f;
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        View child;
        if (this.getChildCount() > 1) {
            child = this.getChildAt(1);
        }
        else {
            child = null;
        }
        if (child == null || this.d == null) {
            return;
        }
        final int intrinsicWidth = this.d.getIntrinsicWidth();
        final int left = child.getLeft();
        this.d.setBounds(left - intrinsicWidth, child.getTop(), left, child.getBottom());
        this.d.draw(canvas);
    }
    
    protected boolean drawChild(final Canvas canvas, final View obj, final long n) {
        final w w = (w)obj.getLayoutParams();
        final int save = canvas.save(2);
        if (this.f && !w.b && this.g != null) {
            canvas.getClipBounds(this.s);
            this.s.right = Math.min(this.s.right, this.g.getLeft());
            canvas.clipRect(this.s);
        }
        boolean b;
        if (Build$VERSION.SDK_INT >= 11) {
            b = super.drawChild(canvas, obj, n);
        }
        else if (w.c && this.h > 0.0f) {
            if (!obj.isDrawingCacheEnabled()) {
                obj.setDrawingCacheEnabled(true);
            }
            final Bitmap drawingCache = obj.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float)obj.getLeft(), (float)obj.getTop(), w.d);
                b = false;
            }
            else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + obj + " returned null drawing cache");
                b = super.drawChild(canvas, obj, n);
            }
        }
        else {
            if (obj.isDrawingCacheEnabled()) {
                obj.setDrawingCacheEnabled(false);
            }
            b = super.drawChild(canvas, obj, n);
        }
        canvas.restoreToCount(save);
        return b;
    }
    
    public boolean e() {
        return this.f;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new w();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new w(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return (ViewGroup$LayoutParams)new w((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)new w(viewGroup$LayoutParams);
    }
    
    public int getCoveredFadeColor() {
        return this.c;
    }
    
    public int getParallaxDistance() {
        return this.l;
    }
    
    public int getSliderFadeColor() {
        return this.b;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
        for (int size = this.t.size(), i = 0; i < size; ++i) {
            this.t.get(i).run();
        }
        this.t.clear();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int a = android.support.v4.view.aa.a(motionEvent);
        if (!this.f && a == 0 && this.getChildCount() > 1) {
            final View child = this.getChildAt(1);
            if (child != null) {
                this.q = !this.p.b(child, (int)motionEvent.getX(), (int)motionEvent.getY());
            }
        }
        boolean onInterceptTouchEvent;
        if (!this.f || (this.k && a != 0)) {
            this.p.e();
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        }
        else {
            if (a == 3 || a == 1) {
                this.p.e();
                return false;
            }
            int n = 0;
            Label_0155: {
                switch (a) {
                    case 0: {
                        this.k = false;
                        final float x = motionEvent.getX();
                        final float y = motionEvent.getY();
                        this.m = x;
                        this.n = y;
                        if (this.p.b(this.g, (int)x, (int)y) && this.b(this.g)) {
                            n = 1;
                            break Label_0155;
                        }
                        break;
                    }
                    case 2: {
                        final float x2 = motionEvent.getX();
                        final float y2 = motionEvent.getY();
                        final float abs = Math.abs(x2 - this.m);
                        final float abs2 = Math.abs(y2 - this.n);
                        if (abs > this.p.d() && abs2 > abs) {
                            this.p.e();
                            this.k = true;
                            return false;
                        }
                        break;
                    }
                }
                n = 0;
            }
            if (!this.p.a(motionEvent)) {
                onInterceptTouchEvent = false;
                if (n == 0) {
                    return onInterceptTouchEvent;
                }
            }
            return true;
        }
        return onInterceptTouchEvent;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int n5 = n3 - n;
        int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int childCount = this.getChildCount();
        if (this.r) {
            float h;
            if (this.f && this.q) {
                h = 1.0f;
            }
            else {
                h = 0.0f;
            }
            this.h = h;
        }
        int i = 0;
        int n6 = paddingLeft;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            int n7;
            if (child.getVisibility() == 8) {
                n7 = n6;
            }
            else {
                final w w = (w)child.getLayoutParams();
                final int measuredWidth = child.getMeasuredWidth();
                int n10;
                if (w.b) {
                    final int j = Math.min(paddingLeft, n5 - paddingRight - this.e) - n6 - (w.leftMargin + w.rightMargin);
                    this.j = j;
                    w.c = (j + (n6 + w.leftMargin) + measuredWidth / 2 > n5 - paddingRight);
                    final int n8 = (int)(j * this.h);
                    final int n9 = n6 + (n8 + w.leftMargin);
                    this.h = n8 / this.j;
                    n7 = n9;
                    n10 = 0;
                }
                else if (this.f && this.l != 0) {
                    n10 = (int)((1.0f - this.h) * this.l);
                    n7 = paddingLeft;
                }
                else {
                    n7 = paddingLeft;
                    n10 = 0;
                }
                final int n11 = n7 - n10;
                child.layout(n11, paddingTop, n11 + measuredWidth, paddingTop + child.getMeasuredHeight());
                paddingLeft += child.getWidth();
            }
            ++i;
            n6 = n7;
        }
        if (this.r) {
            if (this.f) {
                if (this.l != 0) {
                    this.a(this.h);
                }
                if (((w)this.g.getLayoutParams()).c) {
                    this.a(this.g, this.h, this.b);
                }
            }
            else {
                for (int k = 0; k < childCount; ++k) {
                    this.a(this.getChildAt(k), 0.0f, this.b);
                }
            }
            this.a(this.g);
        }
        this.r = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        final int size2 = View$MeasureSpec.getSize(n2);
        while (true) {
            Label_1116: {
                int n3;
                int n4;
                int n5;
                if (mode != 1073741824) {
                    if (!this.isInEditMode()) {
                        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                    }
                    if (mode == Integer.MIN_VALUE) {
                        n3 = mode2;
                        n4 = size;
                        n5 = size2;
                    }
                    else {
                        if (mode != 0) {
                            break Label_1116;
                        }
                        n3 = mode2;
                        n4 = 300;
                        n5 = size2;
                    }
                }
                else {
                    if (mode2 != 0) {
                        break Label_1116;
                    }
                    if (!this.isInEditMode()) {
                        throw new IllegalStateException("Height must not be UNSPECIFIED");
                    }
                    if (mode2 != 0) {
                        break Label_1116;
                    }
                    n3 = Integer.MIN_VALUE;
                    n4 = size;
                    n5 = 300;
                }
                int n6 = 0;
                int b = 0;
                switch (n3) {
                    default: {
                        n6 = 0;
                        b = -1;
                        break;
                    }
                    case 1073741824: {
                        n6 = (b = n5 - this.getPaddingTop() - this.getPaddingBottom());
                        break;
                    }
                    case Integer.MIN_VALUE: {
                        b = n5 - this.getPaddingTop() - this.getPaddingBottom();
                        n6 = 0;
                        break;
                    }
                }
                boolean f = false;
                int b2 = n4 - this.getPaddingLeft() - this.getPaddingRight();
                final int childCount = this.getChildCount();
                if (childCount > 2) {
                    Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
                }
                this.g = null;
                int i = 0;
                int min = n6;
                float n7 = 0.0f;
                while (i < childCount) {
                    final View child = this.getChildAt(i);
                    final w w = (w)child.getLayoutParams();
                    int n8 = 0;
                    float n9 = 0.0f;
                    int n10 = 0;
                    boolean b3 = false;
                    Label_0201: {
                        if (child.getVisibility() == 8) {
                            w.c = false;
                            n8 = b2;
                            n9 = n7;
                            n10 = min;
                            b3 = f;
                        }
                        else {
                            if (w.a > 0.0f) {
                                n7 += w.a;
                                if (w.width == 0) {
                                    n8 = b2;
                                    n9 = n7;
                                    n10 = min;
                                    b3 = f;
                                    break Label_0201;
                                }
                            }
                            final int n11 = w.leftMargin + w.rightMargin;
                            int n12;
                            if (w.width == -2) {
                                n12 = View$MeasureSpec.makeMeasureSpec(n4 - n11, Integer.MIN_VALUE);
                            }
                            else if (w.width == -1) {
                                n12 = View$MeasureSpec.makeMeasureSpec(n4 - n11, 1073741824);
                            }
                            else {
                                n12 = View$MeasureSpec.makeMeasureSpec(w.width, 1073741824);
                            }
                            int n13;
                            if (w.height == -2) {
                                n13 = View$MeasureSpec.makeMeasureSpec(b, Integer.MIN_VALUE);
                            }
                            else if (w.height == -1) {
                                n13 = View$MeasureSpec.makeMeasureSpec(b, 1073741824);
                            }
                            else {
                                n13 = View$MeasureSpec.makeMeasureSpec(w.height, 1073741824);
                            }
                            child.measure(n12, n13);
                            final int measuredWidth = child.getMeasuredWidth();
                            final int measuredHeight = child.getMeasuredHeight();
                            if (n3 == Integer.MIN_VALUE && measuredHeight > min) {
                                min = Math.min(measuredHeight, b);
                            }
                            final int n14 = b2 - measuredWidth;
                            final boolean b4 = n14 < 0;
                            w.b = b4;
                            final boolean b5 = b4 | f;
                            if (w.b) {
                                this.g = child;
                            }
                            n8 = n14;
                            n10 = min;
                            final float n15 = n7;
                            b3 = b5;
                            n9 = n15;
                        }
                    }
                    ++i;
                    f = b3;
                    min = n10;
                    n7 = n9;
                    b2 = n8;
                }
                if (f || n7 > 0.0f) {
                    final int n16 = n4 - this.e;
                    for (int j = 0; j < childCount; ++j) {
                        final View child2 = this.getChildAt(j);
                        if (child2.getVisibility() != 8) {
                            final w w2 = (w)child2.getLayoutParams();
                            if (child2.getVisibility() != 8) {
                                boolean b6;
                                if (w2.width == 0 && w2.a > 0.0f) {
                                    b6 = true;
                                }
                                else {
                                    b6 = false;
                                }
                                int measuredWidth2;
                                if (b6) {
                                    measuredWidth2 = 0;
                                }
                                else {
                                    measuredWidth2 = child2.getMeasuredWidth();
                                }
                                if (f && child2 != this.g) {
                                    if (w2.width < 0 && (measuredWidth2 > n16 || w2.a > 0.0f)) {
                                        int n17;
                                        if (b6) {
                                            if (w2.height == -2) {
                                                n17 = View$MeasureSpec.makeMeasureSpec(b, Integer.MIN_VALUE);
                                            }
                                            else if (w2.height == -1) {
                                                n17 = View$MeasureSpec.makeMeasureSpec(b, 1073741824);
                                            }
                                            else {
                                                n17 = View$MeasureSpec.makeMeasureSpec(w2.height, 1073741824);
                                            }
                                        }
                                        else {
                                            n17 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                                        }
                                        child2.measure(View$MeasureSpec.makeMeasureSpec(n16, 1073741824), n17);
                                    }
                                }
                                else if (w2.a > 0.0f) {
                                    int n18;
                                    if (w2.width == 0) {
                                        if (w2.height == -2) {
                                            n18 = View$MeasureSpec.makeMeasureSpec(b, Integer.MIN_VALUE);
                                        }
                                        else if (w2.height == -1) {
                                            n18 = View$MeasureSpec.makeMeasureSpec(b, 1073741824);
                                        }
                                        else {
                                            n18 = View$MeasureSpec.makeMeasureSpec(w2.height, 1073741824);
                                        }
                                    }
                                    else {
                                        n18 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                                    }
                                    if (f) {
                                        final int n19 = n4 - (w2.leftMargin + w2.rightMargin);
                                        final int measureSpec = View$MeasureSpec.makeMeasureSpec(n19, 1073741824);
                                        if (measuredWidth2 != n19) {
                                            child2.measure(measureSpec, n18);
                                        }
                                    }
                                    else {
                                        child2.measure(View$MeasureSpec.makeMeasureSpec(measuredWidth2 + (int)(w2.a * Math.max(0, b2) / n7), 1073741824), n18);
                                    }
                                }
                            }
                        }
                    }
                }
                this.setMeasuredDimension(n4, min);
                this.f = f;
                if (this.p.a() != 0 && !f) {
                    this.p.f();
                }
                return;
            }
            int n3 = mode2;
            int n4 = size;
            int n5 = size2;
            continue;
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = (SlidingPaneLayout$SavedState)parcelable;
        super.onRestoreInstanceState(slidingPaneLayout$SavedState.getSuperState());
        if (slidingPaneLayout$SavedState.a) {
            this.b();
        }
        else {
            this.c();
        }
        this.q = slidingPaneLayout$SavedState.a;
    }
    
    protected Parcelable onSaveInstanceState() {
        final SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = new SlidingPaneLayout$SavedState(super.onSaveInstanceState());
        boolean a;
        if (this.e()) {
            a = this.d();
        }
        else {
            a = this.q;
        }
        slidingPaneLayout$SavedState.a = a;
        return (Parcelable)slidingPaneLayout$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            this.r = true;
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        boolean onTouchEvent;
        if (!this.f) {
            onTouchEvent = super.onTouchEvent(motionEvent);
        }
        else {
            this.p.b(motionEvent);
            final int action = motionEvent.getAction();
            onTouchEvent = true;
            switch (action & 0xFF) {
                default: {
                    return onTouchEvent;
                }
                case 0: {
                    final float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    this.m = x;
                    this.n = y;
                    return onTouchEvent;
                }
                case 1: {
                    if (!this.b(this.g)) {
                        break;
                    }
                    final float x2 = motionEvent.getX();
                    final float y2 = motionEvent.getY();
                    final float n = x2 - this.m;
                    final float n2 = y2 - this.n;
                    final int d = this.p.d();
                    if (n * n + n2 * n2 < d * d && this.p.b(this.g, (int)x2, (int)y2)) {
                        this.a(this.g, 0);
                        return onTouchEvent;
                    }
                    break;
                }
            }
        }
        return onTouchEvent;
    }
    
    public void requestChildFocus(final View view, final View view2) {
        super.requestChildFocus(view, view2);
        if (!this.isInTouchMode() && !this.f) {
            this.q = (view == this.g);
        }
    }
    
    public void setCoveredFadeColor(final int c) {
        this.c = c;
    }
    
    public void setPanelSlideListener(final x o) {
        this.o = o;
    }
    
    public void setParallaxDistance(final int l) {
        this.l = l;
        this.requestLayout();
    }
    
    public void setShadowDrawable(final Drawable d) {
        this.d = d;
    }
    
    public void setShadowResource(final int n) {
        this.setShadowDrawable(this.getResources().getDrawable(n));
    }
    
    public void setSliderFadeColor(final int b) {
        this.b = b;
    }
}
