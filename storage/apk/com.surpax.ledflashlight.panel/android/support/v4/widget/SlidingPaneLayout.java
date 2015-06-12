// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Paint;
import android.support.v4.view.a;
import android.support.v4.view.ah;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.graphics.Rect;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class SlidingPaneLayout extends ViewGroup
{
    static final s a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private final int f;
    private boolean g;
    private View h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private r p;
    private final z q;
    private boolean r;
    private boolean s;
    private final Rect t;
    private final ArrayList u;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 17) {
            a = new v();
            return;
        }
        if (sdk_INT >= 16) {
            a = new u();
            return;
        }
        a = new t();
    }
    
    public SlidingPaneLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public SlidingPaneLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.b = -858993460;
        this.s = true;
        this.t = new Rect();
        this.u = new ArrayList();
        final float density = context.getResources().getDisplayMetrics().density;
        this.f = (int)(0.5f + 32.0f * density);
        ViewConfiguration.get(context);
        this.setWillNotDraw(false);
        ah.a((View)this, new o(this));
        ah.b((View)this, 1);
        (this.q = z.a(this, 0.5f, new q(this, (byte)0))).a(density * 400.0f);
    }
    
    private void a(final View view, final float n, final int n2) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        if (n > 0.0f && n2 != 0) {
            final int n3 = (int)(n * ((0xFF000000 & n2) >>> 24)) << 24 | (0xFFFFFF & n2);
            if (slidingPaneLayout$LayoutParams.d == null) {
                slidingPaneLayout$LayoutParams.d = new Paint();
            }
            slidingPaneLayout$LayoutParams.d.setColorFilter((ColorFilter)new PorterDuffColorFilter(n3, PorterDuff$Mode.SRC_OVER));
            if (ah.e(view) != 2) {
                ah.a(view, 2, slidingPaneLayout$LayoutParams.d);
            }
            this.c(view);
        }
        else if (ah.e(view) != 0) {
            if (slidingPaneLayout$LayoutParams.d != null) {
                slidingPaneLayout$LayoutParams.d.setColorFilter((ColorFilter)null);
            }
            final p e = new p(this, view);
            this.u.add(e);
            ah.a((View)this, e);
        }
    }
    
    private boolean a(final float n) {
        if (!this.g) {
            return false;
        }
        final boolean e = this.e();
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.h.getLayoutParams();
        int n2;
        if (e) {
            n2 = (int)(this.getWidth() - (this.getPaddingRight() + slidingPaneLayout$LayoutParams.rightMargin + n * this.k + this.h.getWidth()));
        }
        else {
            n2 = (int)(this.getPaddingLeft() + slidingPaneLayout$LayoutParams.leftMargin + n * this.k);
        }
        if (this.q.a(this.h, n2, this.h.getTop())) {
            this.c();
            ah.c((View)this);
            return true;
        }
        return false;
    }
    
    private void b(final float j) {
        final boolean e = this.e();
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.h.getLayoutParams();
        while (true) {
            Label_0169: {
                if (!slidingPaneLayout$LayoutParams.c) {
                    break Label_0169;
                }
                int n;
                if (e) {
                    n = slidingPaneLayout$LayoutParams.rightMargin;
                }
                else {
                    n = slidingPaneLayout$LayoutParams.leftMargin;
                }
                if (n > 0) {
                    break Label_0169;
                }
                final int n2 = 1;
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.getChildAt(i);
                    if (child != this.h) {
                        final int n3 = (int)((1.0f - this.j) * this.m);
                        this.j = j;
                        int n4 = n3 - (int)((1.0f - j) * this.m);
                        if (e) {
                            n4 = -n4;
                        }
                        child.offsetLeftAndRight(n4);
                        if (n2 != 0) {
                            float n5;
                            if (e) {
                                n5 = this.j - 1.0f;
                            }
                            else {
                                n5 = 1.0f - this.j;
                            }
                            this.a(child, n5, this.c);
                        }
                    }
                }
                return;
            }
            final int n2 = 0;
            continue;
        }
    }
    
    private void c(final View view) {
        SlidingPaneLayout.a.a(this, view);
    }
    
    private boolean d() {
        if (!this.s) {
            final boolean a = this.a(0.0f);
            final boolean b = false;
            if (!a) {
                return b;
            }
        }
        this.r = false;
        return true;
    }
    
    private boolean e() {
        return ah.f((View)this) == 1;
    }
    
    final void a() {
        if (this.p != null) {
            final r p = this.p;
        }
        this.sendAccessibilityEvent(32);
    }
    
    final void a(final View view) {
        final boolean e = this.e();
        int paddingLeft;
        if (e) {
            paddingLeft = this.getWidth() - this.getPaddingRight();
        }
        else {
            paddingLeft = this.getPaddingLeft();
        }
        int paddingLeft2;
        if (e) {
            paddingLeft2 = this.getPaddingLeft();
        }
        else {
            paddingLeft2 = this.getWidth() - this.getPaddingRight();
        }
        final int paddingTop = this.getPaddingTop();
        final int a = this.getHeight() - this.getPaddingBottom();
        while (true) {
            Label_0294: {
                if (view == null) {
                    break Label_0294;
                }
                int n = 0;
                Label_0060: {
                    if (ah.h(view)) {
                        n = 1;
                    }
                    else {
                        if (Build$VERSION.SDK_INT < 18) {
                            final Drawable background = view.getBackground();
                            if (background != null) {
                                if (background.getOpacity() == -1) {
                                    n = 1;
                                    break Label_0060;
                                }
                                n = 0;
                                break Label_0060;
                            }
                        }
                        n = 0;
                    }
                }
                if (n == 0) {
                    break Label_0294;
                }
                final int left = view.getLeft();
                final int right = view.getRight();
                final int top = view.getTop();
                final int bottom = view.getBottom();
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.getChildAt(i);
                    if (child == view) {
                        break;
                    }
                    int a2;
                    if (e) {
                        a2 = paddingLeft2;
                    }
                    else {
                        a2 = paddingLeft;
                    }
                    final int max = Math.max(a2, child.getLeft());
                    final int max2 = Math.max(paddingTop, child.getTop());
                    int a3;
                    if (e) {
                        a3 = paddingLeft;
                    }
                    else {
                        a3 = paddingLeft2;
                    }
                    final int min = Math.min(a3, child.getRight());
                    final int min2 = Math.min(a, child.getBottom());
                    int visibility;
                    if (max >= left && max2 >= top && min <= right && min2 <= bottom) {
                        visibility = 4;
                    }
                    else {
                        visibility = 0;
                    }
                    child.setVisibility(visibility);
                }
                return;
            }
            final int bottom = 0;
            final int top = 0;
            final int right = 0;
            final int left = 0;
            continue;
        }
    }
    
    final void b() {
        if (this.p != null) {
            final r p = this.p;
        }
        this.sendAccessibilityEvent(32);
    }
    
    final boolean b(final View view) {
        if (view == null) {
            return false;
        }
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        return this.g && slidingPaneLayout$LayoutParams.c && this.i > 0.0f;
    }
    
    final void c() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 4) {
                child.setVisibility(0);
            }
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof SlidingPaneLayout$LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        if (this.q.g()) {
            if (this.g) {
                ah.c((View)this);
                return;
            }
            this.q.f();
        }
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        Drawable drawable;
        if (this.e()) {
            drawable = this.e;
        }
        else {
            drawable = this.d;
        }
        View child;
        if (this.getChildCount() > 1) {
            child = this.getChildAt(1);
        }
        else {
            child = null;
        }
        if (child == null || drawable == null) {
            return;
        }
        final int top = child.getTop();
        final int bottom = child.getBottom();
        final int intrinsicWidth = drawable.getIntrinsicWidth();
        int right;
        int left;
        if (this.e()) {
            right = child.getRight();
            left = right + intrinsicWidth;
        }
        else {
            left = child.getLeft();
            right = left - intrinsicWidth;
        }
        drawable.setBounds(right, top, left, bottom);
        drawable.draw(canvas);
    }
    
    protected boolean drawChild(final Canvas canvas, final View obj, final long n) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)obj.getLayoutParams();
        final int save = canvas.save(2);
        if (this.g && !slidingPaneLayout$LayoutParams.b && this.h != null) {
            canvas.getClipBounds(this.t);
            if (this.e()) {
                this.t.left = Math.max(this.t.left, this.h.getRight());
            }
            else {
                this.t.right = Math.min(this.t.right, this.h.getLeft());
            }
            canvas.clipRect(this.t);
        }
        while (true) {
            Label_0225: {
                if (Build$VERSION.SDK_INT >= 11) {
                    break Label_0225;
                }
                final boolean drawChild;
                if (slidingPaneLayout$LayoutParams.c && this.i > 0.0f) {
                    if (!obj.isDrawingCacheEnabled()) {
                        obj.setDrawingCacheEnabled(true);
                    }
                    final Bitmap drawingCache = obj.getDrawingCache();
                    if (drawingCache == null) {
                        Log.e("SlidingPaneLayout", "drawChild: child view " + obj + " returned null drawing cache");
                        break Label_0225;
                    }
                    canvas.drawBitmap(drawingCache, (float)obj.getLeft(), (float)obj.getTop(), slidingPaneLayout$LayoutParams.d);
                    drawChild = false;
                }
                else {
                    if (obj.isDrawingCacheEnabled()) {
                        obj.setDrawingCacheEnabled(false);
                    }
                    break Label_0225;
                }
                canvas.restoreToCount(save);
                return drawChild;
            }
            boolean drawChild = super.drawChild(canvas, obj, n);
            continue;
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new SlidingPaneLayout$LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new SlidingPaneLayout$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return (ViewGroup$LayoutParams)new SlidingPaneLayout$LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)new SlidingPaneLayout$LayoutParams(viewGroup$LayoutParams);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        for (int size = this.u.size(), i = 0; i < size; ++i) {
            ((p)this.u.get(i)).run();
        }
        this.u.clear();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int a = android.support.v4.view.s.a(motionEvent);
        if (!this.g && a == 0 && this.getChildCount() > 1) {
            final View child = this.getChildAt(1);
            if (child != null) {
                final z q = this.q;
                this.r = !z.b(child, (int)motionEvent.getX(), (int)motionEvent.getY());
            }
        }
        boolean onInterceptTouchEvent;
        if (!this.g || (this.l && a != 0)) {
            this.q.e();
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        }
        else {
            if (a == 3 || a == 1) {
                this.q.e();
                return false;
            }
            int n = 0;
            Label_0155: {
                switch (a) {
                    case 0: {
                        this.l = false;
                        final float x = motionEvent.getX();
                        final float y = motionEvent.getY();
                        this.n = x;
                        this.o = y;
                        final z q2 = this.q;
                        if (z.b(this.h, (int)x, (int)y) && this.b(this.h)) {
                            n = 1;
                            break Label_0155;
                        }
                        break;
                    }
                    case 2: {
                        final float x2 = motionEvent.getX();
                        final float y2 = motionEvent.getY();
                        final float abs = Math.abs(x2 - this.n);
                        final float abs2 = Math.abs(y2 - this.o);
                        if (abs > this.q.d() && abs2 > abs) {
                            this.q.e();
                            this.l = true;
                            return false;
                        }
                        break;
                    }
                }
                n = 0;
            }
            if (!this.q.a(motionEvent)) {
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
        final boolean e = this.e();
        if (e) {
            this.q.a(2);
        }
        else {
            this.q.a(1);
        }
        final int n5 = n3 - n;
        int a;
        if (e) {
            a = this.getPaddingRight();
        }
        else {
            a = this.getPaddingLeft();
        }
        int n6;
        if (e) {
            n6 = this.getPaddingLeft();
        }
        else {
            n6 = this.getPaddingRight();
        }
        final int paddingTop = this.getPaddingTop();
        final int childCount = this.getChildCount();
        if (this.s) {
            float i;
            if (this.g && this.r) {
                i = 1.0f;
            }
            else {
                i = 0.0f;
            }
            this.i = i;
        }
        int j = 0;
        int n7 = a;
        while (j < childCount) {
            final View child = this.getChildAt(j);
            int n15;
            int n16;
            if (child.getVisibility() != 8) {
                final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)child.getLayoutParams();
                final int measuredWidth = child.getMeasuredWidth();
                int n8 = 0;
                int n11;
                if (slidingPaneLayout$LayoutParams.b) {
                    final int k = Math.min(a, n5 - n6 - this.f) - n7 - (slidingPaneLayout$LayoutParams.leftMargin + slidingPaneLayout$LayoutParams.rightMargin);
                    this.k = k;
                    int n9;
                    if (e) {
                        n9 = slidingPaneLayout$LayoutParams.rightMargin;
                    }
                    else {
                        n9 = slidingPaneLayout$LayoutParams.leftMargin;
                    }
                    slidingPaneLayout$LayoutParams.c = (k + (n7 + n9) + measuredWidth / 2 > n5 - n6);
                    final int n10 = (int)(k * this.i);
                    n11 = n7 + (n9 + n10);
                    this.i = n10 / this.k;
                }
                else {
                    int n12;
                    if (this.g && this.m != 0) {
                        n12 = (int)((1.0f - this.i) * this.m);
                    }
                    else {
                        n12 = 0;
                    }
                    n8 = n12;
                    n11 = a;
                }
                int n13;
                int n14;
                if (e) {
                    n13 = n8 + (n5 - n11);
                    n14 = n13 - measuredWidth;
                }
                else {
                    n14 = n11 - n8;
                    n13 = n14 + measuredWidth;
                }
                child.layout(n14, paddingTop, n13, paddingTop + child.getMeasuredHeight());
                n15 = a + child.getWidth();
                n16 = n11;
            }
            else {
                n15 = a;
                n16 = n7;
            }
            ++j;
            a = n15;
            n7 = n16;
        }
        if (this.s) {
            if (this.g) {
                if (this.m != 0) {
                    this.b(this.i);
                }
                if (((SlidingPaneLayout$LayoutParams)this.h.getLayoutParams()).c) {
                    this.a(this.h, this.i, this.b);
                }
            }
            else {
                for (int l = 0; l < childCount; ++l) {
                    this.a(this.getChildAt(l), 0.0f, this.b);
                }
            }
            this.a(this.h);
        }
        this.s = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        final int size2 = View$MeasureSpec.getSize(n2);
        while (true) {
            Label_1107: {
                int n3;
                int n4;
                int n5;
                if (mode != 1073741824) {
                    if (!this.isInEditMode()) {
                        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                    }
                    if (mode == Integer.MIN_VALUE || mode != 0) {
                        break Label_1107;
                    }
                    n3 = mode2;
                    n4 = 300;
                    n5 = size2;
                }
                else {
                    if (mode2 != 0) {
                        break Label_1107;
                    }
                    if (!this.isInEditMode()) {
                        throw new IllegalStateException("Height must not be UNSPECIFIED");
                    }
                    if (mode2 != 0) {
                        break Label_1107;
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
                boolean g = false;
                final int n7 = n4 - this.getPaddingLeft() - this.getPaddingRight();
                final int childCount = this.getChildCount();
                if (childCount > 2) {
                    Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
                }
                this.h = null;
                int i = 0;
                int b2 = n7;
                int min = n6;
                float n8 = 0.0f;
                while (i < childCount) {
                    final View child = this.getChildAt(i);
                    final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)child.getLayoutParams();
                    int n9 = 0;
                    int n10 = 0;
                    float n11 = 0.0f;
                    boolean b3 = false;
                    Label_0209: {
                        if (child.getVisibility() == 8) {
                            slidingPaneLayout$LayoutParams.c = false;
                            n9 = b2;
                            n10 = min;
                            n11 = n8;
                            b3 = g;
                        }
                        else {
                            if (slidingPaneLayout$LayoutParams.a > 0.0f) {
                                n8 += slidingPaneLayout$LayoutParams.a;
                                if (slidingPaneLayout$LayoutParams.width == 0) {
                                    n9 = b2;
                                    n10 = min;
                                    n11 = n8;
                                    b3 = g;
                                    break Label_0209;
                                }
                            }
                            final int n12 = slidingPaneLayout$LayoutParams.leftMargin + slidingPaneLayout$LayoutParams.rightMargin;
                            int n13;
                            if (slidingPaneLayout$LayoutParams.width == -2) {
                                n13 = View$MeasureSpec.makeMeasureSpec(n7 - n12, Integer.MIN_VALUE);
                            }
                            else if (slidingPaneLayout$LayoutParams.width == -1) {
                                n13 = View$MeasureSpec.makeMeasureSpec(n7 - n12, 1073741824);
                            }
                            else {
                                n13 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams.width, 1073741824);
                            }
                            int n14;
                            if (slidingPaneLayout$LayoutParams.height == -2) {
                                n14 = View$MeasureSpec.makeMeasureSpec(b, Integer.MIN_VALUE);
                            }
                            else if (slidingPaneLayout$LayoutParams.height == -1) {
                                n14 = View$MeasureSpec.makeMeasureSpec(b, 1073741824);
                            }
                            else {
                                n14 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams.height, 1073741824);
                            }
                            child.measure(n13, n14);
                            final int measuredWidth = child.getMeasuredWidth();
                            final int measuredHeight = child.getMeasuredHeight();
                            if (n3 == Integer.MIN_VALUE && measuredHeight > min) {
                                min = Math.min(measuredHeight, b);
                            }
                            final int n15 = b2 - measuredWidth;
                            final boolean b4 = n15 < 0;
                            slidingPaneLayout$LayoutParams.b = b4;
                            final boolean b5 = b4 | g;
                            if (slidingPaneLayout$LayoutParams.b) {
                                this.h = child;
                            }
                            n9 = n15;
                            n11 = n8;
                            b3 = b5;
                            n10 = min;
                        }
                    }
                    ++i;
                    g = b3;
                    min = n10;
                    b2 = n9;
                    n8 = n11;
                }
                if (g || n8 > 0.0f) {
                    final int n16 = n7 - this.f;
                    for (int j = 0; j < childCount; ++j) {
                        final View child2 = this.getChildAt(j);
                        if (child2.getVisibility() != 8) {
                            final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams2 = (SlidingPaneLayout$LayoutParams)child2.getLayoutParams();
                            if (child2.getVisibility() != 8) {
                                boolean b6;
                                if (slidingPaneLayout$LayoutParams2.width == 0 && slidingPaneLayout$LayoutParams2.a > 0.0f) {
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
                                if (g && child2 != this.h) {
                                    if (slidingPaneLayout$LayoutParams2.width < 0 && (measuredWidth2 > n16 || slidingPaneLayout$LayoutParams2.a > 0.0f)) {
                                        int n17;
                                        if (b6) {
                                            if (slidingPaneLayout$LayoutParams2.height == -2) {
                                                n17 = View$MeasureSpec.makeMeasureSpec(b, Integer.MIN_VALUE);
                                            }
                                            else if (slidingPaneLayout$LayoutParams2.height == -1) {
                                                n17 = View$MeasureSpec.makeMeasureSpec(b, 1073741824);
                                            }
                                            else {
                                                n17 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams2.height, 1073741824);
                                            }
                                        }
                                        else {
                                            n17 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                                        }
                                        child2.measure(View$MeasureSpec.makeMeasureSpec(n16, 1073741824), n17);
                                    }
                                }
                                else if (slidingPaneLayout$LayoutParams2.a > 0.0f) {
                                    int n18;
                                    if (slidingPaneLayout$LayoutParams2.width == 0) {
                                        if (slidingPaneLayout$LayoutParams2.height == -2) {
                                            n18 = View$MeasureSpec.makeMeasureSpec(b, Integer.MIN_VALUE);
                                        }
                                        else if (slidingPaneLayout$LayoutParams2.height == -1) {
                                            n18 = View$MeasureSpec.makeMeasureSpec(b, 1073741824);
                                        }
                                        else {
                                            n18 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams2.height, 1073741824);
                                        }
                                    }
                                    else {
                                        n18 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                                    }
                                    if (g) {
                                        final int n19 = n7 - (slidingPaneLayout$LayoutParams2.leftMargin + slidingPaneLayout$LayoutParams2.rightMargin);
                                        final int measureSpec = View$MeasureSpec.makeMeasureSpec(n19, 1073741824);
                                        if (measuredWidth2 != n19) {
                                            child2.measure(measureSpec, n18);
                                        }
                                    }
                                    else {
                                        child2.measure(View$MeasureSpec.makeMeasureSpec(measuredWidth2 + (int)(slidingPaneLayout$LayoutParams2.a * Math.max(0, b2) / n8), 1073741824), n18);
                                    }
                                }
                            }
                        }
                    }
                }
                this.setMeasuredDimension(n4, min + this.getPaddingTop() + this.getPaddingBottom());
                this.g = g;
                if (this.q.a() != 0 && !g) {
                    this.q.f();
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
            final View h = this.h;
            if (this.s || this.a(1.0f)) {
                this.r = true;
            }
        }
        else {
            final View h2 = this.h;
            this.d();
        }
        this.r = slidingPaneLayout$SavedState.a;
    }
    
    protected Parcelable onSaveInstanceState() {
        final SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = new SlidingPaneLayout$SavedState(super.onSaveInstanceState());
        boolean r;
        if (this.g) {
            r = (!this.g || this.i == 1.0f);
        }
        else {
            r = this.r;
        }
        slidingPaneLayout$SavedState.a = r;
        return (Parcelable)slidingPaneLayout$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            this.s = true;
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (!this.g) {
            return super.onTouchEvent(motionEvent);
        }
        this.q.b(motionEvent);
        switch (0xFF & motionEvent.getAction()) {
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                this.n = x;
                this.o = y;
                break;
            }
            case 1: {
                if (!this.b(this.h)) {
                    break;
                }
                final float x2 = motionEvent.getX();
                final float y2 = motionEvent.getY();
                final float n = x2 - this.n;
                final float n2 = y2 - this.o;
                final int d = this.q.d();
                if (n * n + n2 * n2 >= d * d) {
                    break;
                }
                final z q = this.q;
                if (z.b(this.h, (int)x2, (int)y2)) {
                    final View h = this.h;
                    this.d();
                    break;
                }
                break;
            }
        }
        return true;
    }
    
    public void requestChildFocus(final View view, final View view2) {
        super.requestChildFocus(view, view2);
        if (!this.isInTouchMode() && !this.g) {
            this.r = (view == this.h);
        }
    }
}
