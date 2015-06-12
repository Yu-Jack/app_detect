// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.t;
import android.view.KeyEvent;
import android.support.v4.view.aa;
import android.view.MotionEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.o;
import android.support.v4.view.al;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.ViewGroup;

public class DrawerLayout extends ViewGroup
{
    private static final int[] a;
    private int b;
    private int c;
    private float d;
    private Paint e;
    private final ac f;
    private final ac g;
    private final h h;
    private final h i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private f q;
    private float r;
    private float s;
    private Drawable t;
    private Drawable u;
    
    static {
        a = new int[] { 16842931 };
    }
    
    static String b(final int i) {
        if ((i & 0x3) == 0x3) {
            return "LEFT";
        }
        if ((i & 0x5) == 0x5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }
    
    private boolean d() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            if (((g)this.getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }
    
    private boolean e() {
        return this.f() != null;
    }
    
    private View f() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.g(child) && this.k(child)) {
                return child;
            }
        }
        return null;
    }
    
    private static boolean l(final View view) {
        final Drawable background = view.getBackground();
        boolean b = false;
        if (background != null) {
            final int opacity = background.getOpacity();
            b = false;
            if (opacity == -1) {
                b = true;
            }
        }
        return b;
    }
    
    public int a(final View view) {
        final int e = this.e(view);
        if (e == 3) {
            return this.m;
        }
        if (e == 5) {
            return this.n;
        }
        return 0;
    }
    
    View a() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (((g)child.getLayoutParams()).d) {
                return child;
            }
        }
        return null;
    }
    
    View a(final int n) {
        final int n2 = 0x7 & android.support.v4.view.o.a(n, al.e((View)this));
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((0x7 & this.e(child)) == n2) {
                return child;
            }
        }
        return null;
    }
    
    public void a(final int n, final int n2) {
        final int a = android.support.v4.view.o.a(n2, al.e((View)this));
        if (a == 3) {
            this.m = n;
        }
        else if (a == 5) {
            this.n = n;
        }
        if (n != 0) {
            ac ac;
            if (a == 3) {
                ac = this.f;
            }
            else {
                ac = this.g;
            }
            ac.e();
        }
        switch (n) {
            case 2: {
                final View a2 = this.a(a);
                if (a2 != null) {
                    this.h(a2);
                    return;
                }
                break;
            }
            case 1: {
                final View a3 = this.a(a);
                if (a3 != null) {
                    this.i(a3);
                    return;
                }
                break;
            }
        }
    }
    
    void a(final int n, final int n2, final View view) {
        int j = 1;
        final int a = this.f.a();
        final int a2 = this.g.a();
        if (a != j && a2 != j) {
            if (a == 2 || a2 == 2) {
                j = 2;
            }
            else {
                j = 0;
            }
        }
        if (view != null && n2 == 0) {
            final g g = (g)view.getLayoutParams();
            if (g.b == 0.0f) {
                this.b(view);
            }
            else if (g.b == 1.0f) {
                this.c(view);
            }
        }
        if (j != this.j) {
            this.j = j;
            if (this.q != null) {
                this.q.onDrawerStateChanged(j);
            }
        }
    }
    
    void a(final View view, final float n) {
        if (this.q != null) {
            this.q.onDrawerSlide(view, n);
        }
    }
    
    void a(final boolean b) {
        final int childCount = this.getChildCount();
        int i = 0;
        boolean b2 = false;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            final g g = (g)child.getLayoutParams();
            if (this.g(child) && (!b || g.c)) {
                final int width = child.getWidth();
                if (this.a(child, 3)) {
                    b2 |= this.f.a(child, -width, child.getTop());
                }
                else {
                    b2 |= this.g.a(child, this.getWidth(), child.getTop());
                }
                g.c = false;
            }
            ++i;
        }
        this.h.a();
        this.i.a();
        if (b2) {
            this.invalidate();
        }
    }
    
    boolean a(final View view, final int n) {
        return (n & this.e(view)) == n;
    }
    
    public void b() {
        this.a(false);
    }
    
    void b(final View view) {
        final g g = (g)view.getLayoutParams();
        if (g.d) {
            g.d = false;
            if (this.q != null) {
                this.q.onDrawerClosed(view);
            }
            if (this.hasWindowFocus()) {
                final View rootView = this.getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }
    
    void b(final View view, final float b) {
        final g g = (g)view.getLayoutParams();
        if (b == g.b) {
            return;
        }
        this.a(view, g.b = b);
    }
    
    public void c(final int n) {
        final View a = this.a(n);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + b(n));
        }
        this.h(a);
    }
    
    void c(final View view) {
        final g g = (g)view.getLayoutParams();
        if (!g.d) {
            g.d = true;
            if (this.q != null) {
                this.q.onDrawerOpened(view);
            }
            this.sendAccessibilityEvent(32);
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof g && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        final int childCount = this.getChildCount();
        float max = 0.0f;
        for (int i = 0; i < childCount; ++i) {
            max = Math.max(max, ((g)this.getChildAt(i).getLayoutParams()).b);
        }
        this.d = max;
        if (this.f.a(true) | this.g.a(true)) {
            al.b((View)this);
        }
    }
    
    float d(final View view) {
        return ((g)view.getLayoutParams()).b;
    }
    
    public void d(final int n) {
        final View a = this.a(n);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + b(n));
        }
        this.i(a);
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final int height = this.getHeight();
        final boolean f = this.f(view);
        int width = this.getWidth();
        final int save = canvas.save();
        int n2 = 0;
        if (f) {
            final int childCount = this.getChildCount();
            int i = 0;
        Label_0102_Outer:
            while (i < childCount) {
                final View child = this.getChildAt(i);
                while (true) {
                    Label_0161: {
                        if (child == view || child.getVisibility() != 0 || !l(child) || !this.g(child)) {
                            break Label_0161;
                        }
                        int left;
                        if (child.getHeight() < height) {
                            left = width;
                        }
                        else if (this.a(child, 3)) {
                            int right = child.getRight();
                            if (right <= n2) {
                                right = n2;
                            }
                            n2 = right;
                            left = width;
                        }
                        else {
                            left = child.getLeft();
                            if (left >= width) {
                                break Label_0161;
                            }
                        }
                        ++i;
                        width = left;
                        continue Label_0102_Outer;
                    }
                    int left = width;
                    continue;
                }
            }
            canvas.clipRect(n2, 0, width, this.getHeight());
        }
        final int n3 = width;
        final boolean drawChild = super.drawChild(canvas, view, n);
        canvas.restoreToCount(save);
        if (this.d > 0.0f && f) {
            this.e.setColor((int)(((0xFF000000 & this.c) >>> 24) * this.d) << 24 | (0xFFFFFF & this.c));
            canvas.drawRect((float)n2, 0.0f, (float)n3, (float)this.getHeight(), this.e);
        }
        else {
            if (this.t != null && this.a(view, 3)) {
                final int intrinsicWidth = this.t.getIntrinsicWidth();
                final int right2 = view.getRight();
                final float max = Math.max(0.0f, Math.min(right2 / this.f.b(), 1.0f));
                this.t.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.t.setAlpha((int)(255.0f * max));
                this.t.draw(canvas);
                return drawChild;
            }
            if (this.u != null && this.a(view, 5)) {
                final int intrinsicWidth2 = this.u.getIntrinsicWidth();
                final int left2 = view.getLeft();
                final float max2 = Math.max(0.0f, Math.min((this.getWidth() - left2) / this.g.b(), 1.0f));
                this.u.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.u.setAlpha((int)(255.0f * max2));
                this.u.draw(canvas);
                return drawChild;
            }
        }
        return drawChild;
    }
    
    int e(final View view) {
        return android.support.v4.view.o.a(((g)view.getLayoutParams()).a, al.e((View)this));
    }
    
    public boolean e(final int n) {
        final View a = this.a(n);
        return a != null && this.j(a);
    }
    
    public boolean f(final int n) {
        final View a = this.a(n);
        return a != null && this.k(a);
    }
    
    boolean f(final View view) {
        return ((g)view.getLayoutParams()).a == 0;
    }
    
    boolean g(final View view) {
        return (0x7 & android.support.v4.view.o.a(((g)view.getLayoutParams()).a, al.e(view))) != 0x0;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new g(-1, -1);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new g(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof g) {
            return (ViewGroup$LayoutParams)new g((g)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return (ViewGroup$LayoutParams)new g((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)new g(viewGroup$LayoutParams);
    }
    
    public void h(final View obj) {
        if (!this.g(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a sliding drawer");
        }
        if (this.l) {
            final g g = (g)obj.getLayoutParams();
            g.b = 1.0f;
            g.d = true;
        }
        else if (this.a(obj, 3)) {
            this.f.a(obj, 0, obj.getTop());
        }
        else {
            this.g.a(obj, this.getWidth() - obj.getWidth(), obj.getTop());
        }
        this.invalidate();
    }
    
    public void i(final View obj) {
        if (!this.g(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a sliding drawer");
        }
        if (this.l) {
            final g g = (g)obj.getLayoutParams();
            g.b = 0.0f;
            g.d = false;
        }
        else if (this.a(obj, 3)) {
            this.f.a(obj, -obj.getWidth(), obj.getTop());
        }
        else {
            this.g.a(obj, this.getWidth(), obj.getTop());
        }
        this.invalidate();
    }
    
    public boolean j(final View obj) {
        if (!this.g(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a drawer");
        }
        return ((g)obj.getLayoutParams()).d;
    }
    
    public boolean k(final View obj) {
        if (!this.g(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a drawer");
        }
        return ((g)obj.getLayoutParams()).b > 0.0f;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = true;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int a = aa.a(motionEvent);
        final boolean b = this.f.a(motionEvent) | this.g.a(motionEvent);
        boolean b2 = false;
        Label_0059: {
            switch (a) {
                case 0: {
                    final float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    this.r = x;
                    this.s = y;
                    if (this.d > 0.0f && this.f(this.f.d((int)x, (int)y))) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    this.o = false;
                    this.p = false;
                    break Label_0059;
                }
                case 2: {
                    if (this.f.c(3)) {
                        this.h.a();
                        this.i.a();
                        b2 = false;
                        break Label_0059;
                    }
                    break;
                }
                case 1:
                case 3: {
                    this.a(true);
                    this.o = false;
                    this.p = false;
                    break;
                }
            }
            b2 = false;
        }
        if (!b && !b2 && !this.d()) {
            final boolean p = this.p;
            final boolean b3 = false;
            if (!p) {
                return b3;
            }
        }
        return true;
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.e()) {
            android.support.v4.view.t.b(keyEvent);
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final View f = this.f();
            if (f != null && this.a(f) == 0) {
                this.b();
            }
            return f != null;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        this.k = true;
        final int n5 = n3 - n;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final g g = (g)child.getLayoutParams();
                if (this.f(child)) {
                    child.layout(g.leftMargin, g.topMargin, g.leftMargin + child.getMeasuredWidth(), g.topMargin + child.getMeasuredHeight());
                }
                else {
                    final int measuredWidth = child.getMeasuredWidth();
                    final int measuredHeight = child.getMeasuredHeight();
                    int n6;
                    float n7;
                    if (this.a(child, 3)) {
                        n6 = -measuredWidth + (int)(measuredWidth * g.b);
                        n7 = (measuredWidth + n6) / measuredWidth;
                    }
                    else {
                        n6 = n5 - (int)(measuredWidth * g.b);
                        n7 = (n5 - n6) / measuredWidth;
                    }
                    int n8;
                    if (n7 != g.b) {
                        n8 = 1;
                    }
                    else {
                        n8 = 0;
                    }
                    switch (0x70 & g.a) {
                        default: {
                            child.layout(n6, g.topMargin, measuredWidth + n6, measuredHeight + g.topMargin);
                            break;
                        }
                        case 80: {
                            final int n9 = n4 - n2;
                            child.layout(n6, n9 - g.bottomMargin - child.getMeasuredHeight(), measuredWidth + n6, n9 - g.bottomMargin);
                            break;
                        }
                        case 16: {
                            final int n10 = n4 - n2;
                            int topMargin = (n10 - measuredHeight) / 2;
                            if (topMargin < g.topMargin) {
                                topMargin = g.topMargin;
                            }
                            else if (topMargin + measuredHeight > n10 - g.bottomMargin) {
                                topMargin = n10 - g.bottomMargin - measuredHeight;
                            }
                            child.layout(n6, topMargin, measuredWidth + n6, measuredHeight + topMargin);
                            break;
                        }
                    }
                    if (n8 != 0) {
                        this.b(child, n7);
                    }
                    int visibility;
                    if (g.b > 0.0f) {
                        visibility = 0;
                    }
                    else {
                        visibility = 4;
                    }
                    if (child.getVisibility() != visibility) {
                        child.setVisibility(visibility);
                    }
                }
            }
        }
        this.k = false;
        this.l = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        int n3 = 300;
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        int size = View$MeasureSpec.getSize(n);
        final int size2 = View$MeasureSpec.getSize(n2);
        while (true) {
            Label_0133: {
                if (mode == 1073741824 && mode2 == 1073741824) {
                    break Label_0133;
                }
                if (!this.isInEditMode()) {
                    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
                }
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = n3;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    n3 = size2;
                }
                else if (mode2 != 0) {
                    break Label_0133;
                }
                this.setMeasuredDimension(size, n3);
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.getChildAt(i);
                    if (child.getVisibility() != 8) {
                        final g g = (g)child.getLayoutParams();
                        if (this.f(child)) {
                            child.measure(View$MeasureSpec.makeMeasureSpec(size - g.leftMargin - g.rightMargin, 1073741824), View$MeasureSpec.makeMeasureSpec(n3 - g.topMargin - g.bottomMargin, 1073741824));
                        }
                        else {
                            if (!this.g(child)) {
                                throw new IllegalStateException("Child " + child + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                            }
                            final int n4 = 0x7 & this.e(child);
                            if ((0x0 & n4) != 0x0) {
                                throw new IllegalStateException("Child drawer has absolute gravity " + b(n4) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                            }
                            child.measure(getChildMeasureSpec(n, this.b + g.leftMargin + g.rightMargin, g.width), getChildMeasureSpec(n2, g.topMargin + g.bottomMargin, g.height));
                        }
                    }
                }
                return;
            }
            n3 = size2;
            continue;
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final DrawerLayout$SavedState drawerLayout$SavedState = (DrawerLayout$SavedState)parcelable;
        super.onRestoreInstanceState(drawerLayout$SavedState.getSuperState());
        if (drawerLayout$SavedState.a != 0) {
            final View a = this.a(drawerLayout$SavedState.a);
            if (a != null) {
                this.h(a);
            }
        }
        this.a(drawerLayout$SavedState.b, 3);
        this.a(drawerLayout$SavedState.c, 5);
    }
    
    protected Parcelable onSaveInstanceState() {
        final DrawerLayout$SavedState drawerLayout$SavedState = new DrawerLayout$SavedState(super.onSaveInstanceState());
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.g(child)) {
                final g g = (g)child.getLayoutParams();
                if (g.d) {
                    drawerLayout$SavedState.a = g.a;
                    break;
                }
            }
        }
        drawerLayout$SavedState.b = this.m;
        drawerLayout$SavedState.c = this.n;
        return (Parcelable)drawerLayout$SavedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.f.b(motionEvent);
        this.g.b(motionEvent);
        switch (0xFF & motionEvent.getAction()) {
            default: {
                return true;
            }
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                this.r = x;
                this.s = y;
                this.o = false;
                this.p = false;
                return true;
            }
            case 1: {
                final float x2 = motionEvent.getX();
                final float y2 = motionEvent.getY();
                final View d = this.f.d((int)x2, (int)y2);
                while (true) {
                    Label_0237: {
                        if (d == null || !this.f(d)) {
                            break Label_0237;
                        }
                        final float n = x2 - this.r;
                        final float n2 = y2 - this.s;
                        final int d2 = this.f.d();
                        if (n * n + n2 * n2 >= d2 * d2) {
                            break Label_0237;
                        }
                        final View a = this.a();
                        if (a == null) {
                            break Label_0237;
                        }
                        final boolean b = this.a(a) == 2;
                        this.a(b);
                        this.o = false;
                        return true;
                    }
                    final boolean b = true;
                    continue;
                }
            }
            case 3: {
                this.a(true);
                this.o = false;
                this.p = false;
                return true;
            }
        }
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean o) {
        super.requestDisallowInterceptTouchEvent(o);
        this.o = o;
        if (o) {
            this.a(true);
        }
    }
    
    public void requestLayout() {
        if (!this.k) {
            super.requestLayout();
        }
    }
    
    public void setDrawerListener(final f q) {
        this.q = q;
    }
    
    public void setDrawerLockMode(final int n) {
        this.a(n, 3);
        this.a(n, 5);
    }
    
    public void setScrimColor(final int c) {
        this.c = c;
        this.invalidate();
    }
}
