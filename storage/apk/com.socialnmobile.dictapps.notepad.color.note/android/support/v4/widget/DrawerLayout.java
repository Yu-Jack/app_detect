// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.KeyEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
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
    private final dt f;
    private final dt g;
    private final dg h;
    private final dg i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private de q;
    private float r;
    private float s;
    private Drawable t;
    private Drawable u;
    private CharSequence v;
    private CharSequence w;
    
    static {
        a = new int[] { 16842931 };
    }
    
    public DrawerLayout(final Context context) {
        this(context, null);
    }
    
    public DrawerLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public DrawerLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.c = -1728053248;
        this.e = new Paint();
        this.l = true;
        final float density = this.getResources().getDisplayMetrics().density;
        this.b = (int)(0.5f + 64.0f * density);
        final float n2 = density * 400.0f;
        this.h = new dg(this, 3);
        this.i = new dg(this, 5);
        (this.f = dt.a(this, this.h)).a(1);
        this.f.a(n2);
        this.h.b = this.f;
        (this.g = dt.a(this, this.i)).a(2);
        this.g.a(n2);
        this.i.b = this.g;
        this.setFocusableInTouchMode(true);
        cf.b((View)this, 1);
        cx.a(this, false);
    }
    
    private void a(final boolean b) {
        final int childCount = this.getChildCount();
        int i = 0;
        boolean b2 = false;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
            if (c(child) && (!b || drawerLayout$LayoutParams.c)) {
                final int width = child.getWidth();
                if (this.a(child, 3)) {
                    b2 |= this.f.a(child, -width, child.getTop());
                }
                else {
                    b2 |= this.g.a(child, this.getWidth(), child.getTop());
                }
                drawerLayout$LayoutParams.c = false;
            }
            ++i;
        }
        this.h.a();
        this.i.a();
        if (b2) {
            this.invalidate();
        }
    }
    
    public static float b(final View view) {
        return ((DrawerLayout$LayoutParams)view.getLayoutParams()).b;
    }
    
    private static String b(final int i) {
        if ((i & 0x3) == 0x3) {
            return "LEFT";
        }
        if ((i & 0x5) == 0x5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }
    
    public static boolean c(final View view) {
        return (0x7 & bj.a(((DrawerLayout$LayoutParams)view.getLayoutParams()).a, cf.b(view))) != 0x0;
    }
    
    private int e(final View view) {
        return bj.a(((DrawerLayout$LayoutParams)view.getLayoutParams()).a, cf.b((View)this));
    }
    
    private View e() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (c(child)) {
                if (!c(child)) {
                    throw new IllegalArgumentException("View " + child + " is not a drawer");
                }
                int n;
                if (((DrawerLayout$LayoutParams)child.getLayoutParams()).b > 0.0f) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (n != 0) {
                    return child;
                }
            }
        }
        return null;
    }
    
    private static boolean f(final View view) {
        return ((DrawerLayout$LayoutParams)view.getLayoutParams()).a == 0;
    }
    
    private void g(final View obj) {
        if (!c(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a sliding drawer");
        }
        if (this.l) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)obj.getLayoutParams();
            drawerLayout$LayoutParams.b = 1.0f;
            drawerLayout$LayoutParams.d = true;
        }
        else if (this.a(obj, 3)) {
            this.f.a(obj, 0, obj.getTop());
        }
        else {
            this.g.a(obj, this.getWidth() - obj.getWidth(), obj.getTop());
        }
        this.invalidate();
    }
    
    public final int a(final View view) {
        final int e = this.e(view);
        if (e == 3) {
            return this.m;
        }
        if (e == 5) {
            return this.n;
        }
        return 0;
    }
    
    public final View a(final int n) {
        final int n2 = 0x7 & bj.a(n, cf.b((View)this));
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((0x7 & this.e(child)) == n2) {
                return child;
            }
        }
        return null;
    }
    
    public final void a() {
        this.a(false);
    }
    
    public final void a(final int n, final View view) {
        final int a = this.f.a();
        final int a2 = this.g.a();
        int j;
        if (a == 1 || a2 == 1) {
            j = 1;
        }
        else if (a == 2 || a2 == 2) {
            j = 2;
        }
        else {
            j = 0;
        }
        if (view != null && n == 0) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            if (drawerLayout$LayoutParams.b == 0.0f) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams2 = (DrawerLayout$LayoutParams)view.getLayoutParams();
                if (drawerLayout$LayoutParams2.d) {
                    drawerLayout$LayoutParams2.d = false;
                    if (this.q != null) {
                        final de q = this.q;
                    }
                    final View child = this.getChildAt(0);
                    if (child != null) {
                        cf.b(child, 1);
                    }
                    cf.b(view, 4);
                    if (this.hasWindowFocus()) {
                        final View rootView = this.getRootView();
                        if (rootView != null) {
                            rootView.sendAccessibilityEvent(32);
                        }
                    }
                }
            }
            else if (drawerLayout$LayoutParams.b == 1.0f) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams3 = (DrawerLayout$LayoutParams)view.getLayoutParams();
                if (!drawerLayout$LayoutParams3.d) {
                    drawerLayout$LayoutParams3.d = true;
                    if (this.q != null) {
                        final de q2 = this.q;
                    }
                    final View child2 = this.getChildAt(0);
                    if (child2 != null) {
                        cf.b(child2, 4);
                    }
                    cf.b(view, 1);
                    this.sendAccessibilityEvent(32);
                    view.requestFocus();
                }
            }
        }
        if (j != this.j) {
            this.j = j;
            if (this.q != null) {
                final de q3 = this.q;
            }
        }
    }
    
    public final void a(final View view, final float b) {
        final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
        if (b != drawerLayout$LayoutParams.b) {
            drawerLayout$LayoutParams.b = b;
            if (this.q != null) {
                final de q = this.q;
            }
        }
    }
    
    public final boolean a(final View view, final int n) {
        return (n & this.e(view)) == n;
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (n > 0 || (n < 0 && this.getChildCount() > 0)) {
            cf.b(view, 4);
        }
        else {
            cf.b(view, 1);
        }
        super.addView(view, n, viewGroup$LayoutParams);
    }
    
    public final void b() {
        final View a = this.a(3);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + b(3));
        }
        this.g(a);
    }
    
    public final void c() {
        int i = 0;
        if (!this.p) {
            final long uptimeMillis = SystemClock.uptimeMillis();
            final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            while (i < this.getChildCount()) {
                this.getChildAt(i).dispatchTouchEvent(obtain);
                ++i;
            }
            obtain.recycle();
            this.p = true;
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof DrawerLayout$LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        final int childCount = this.getChildCount();
        float max = 0.0f;
        for (int i = 0; i < childCount; ++i) {
            max = Math.max(max, ((DrawerLayout$LayoutParams)this.getChildAt(i).getLayoutParams()).b);
        }
        this.d = max;
        if (this.f.f() | this.g.f()) {
            cf.a((View)this);
        }
    }
    
    public final void d(final View obj) {
        if (!c(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a sliding drawer");
        }
        if (this.l) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)obj.getLayoutParams();
            drawerLayout$LayoutParams.b = 0.0f;
            drawerLayout$LayoutParams.d = false;
        }
        else if (this.a(obj, 3)) {
            this.f.a(obj, -obj.getWidth(), obj.getTop());
        }
        else {
            this.g.a(obj, this.getWidth(), obj.getTop());
        }
        this.invalidate();
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final int height = this.getHeight();
        final boolean f = f(view);
        int width = this.getWidth();
        final int save = canvas.save();
        int n2 = 0;
        if (f) {
            final int childCount = this.getChildCount();
            int i = 0;
        Label_0248_Outer:
            while (i < childCount) {
                final View child = this.getChildAt(i);
                while (true) {
                    Label_0512: {
                        if (child == view || child.getVisibility() != 0) {
                            break Label_0512;
                        }
                        final Drawable background = child.getBackground();
                        boolean b;
                        if (background != null) {
                            if (background.getOpacity() == -1) {
                                b = true;
                            }
                            else {
                                b = false;
                            }
                        }
                        else {
                            b = false;
                        }
                        if (!b || !c(child) || child.getHeight() < height) {
                            break Label_0512;
                        }
                        int right;
                        if (this.a(child, 3)) {
                            right = child.getRight();
                            if (right <= n2) {
                                break Label_0512;
                            }
                        }
                        else {
                            final int left = child.getLeft();
                            if (left >= width) {
                                break Label_0512;
                            }
                            width = left;
                            right = n2;
                        }
                        ++i;
                        n2 = right;
                        continue Label_0248_Outer;
                    }
                    int right = n2;
                    continue;
                }
            }
            canvas.clipRect(n2, 0, width, this.getHeight());
        }
        final boolean drawChild = super.drawChild(canvas, view, n);
        canvas.restoreToCount(save);
        if (this.d > 0.0f && f) {
            this.e.setColor((int)(((0xFF000000 & this.c) >>> 24) * this.d) << 24 | (0xFFFFFF & this.c));
            canvas.drawRect((float)n2, 0.0f, (float)width, (float)this.getHeight(), this.e);
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
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new DrawerLayout$LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new DrawerLayout$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof DrawerLayout$LayoutParams) {
            return (ViewGroup$LayoutParams)new DrawerLayout$LayoutParams((DrawerLayout$LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return (ViewGroup$LayoutParams)new DrawerLayout$LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)new DrawerLayout$LayoutParams(viewGroup$LayoutParams);
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
        final int a = bv.a(motionEvent);
        final boolean b = this.f.a(motionEvent) | this.g.a(motionEvent);
        boolean b2 = false;
        Label_0059: {
            switch (a) {
                case 0: {
                    final float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    this.r = x;
                    this.s = y;
                    if (this.d > 0.0f && f(this.f.b((int)x, (int)y))) {
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
                    if (this.f.g()) {
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
        if (!b && !b2) {
            final int childCount = this.getChildCount();
            int i = 0;
            while (true) {
                while (i < childCount) {
                    if (((DrawerLayout$LayoutParams)this.getChildAt(i).getLayoutParams()).c) {
                        final int n = 1;
                        if (n == 0 && !this.p) {
                            return false;
                        }
                        return true;
                    }
                    else {
                        ++i;
                    }
                }
                final int n = 0;
                continue;
            }
        }
        return true;
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            int n2;
            if (this.e() != null) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            if (n2 != 0) {
                bo.b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final View e = this.e();
            if (e != null && this.a(e) == 0) {
                this.a(false);
            }
            boolean b = false;
            if (e != null) {
                b = true;
            }
            return b;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        this.k = true;
        final int n5 = n3 - n;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                if (f(child)) {
                    child.layout(drawerLayout$LayoutParams.leftMargin, drawerLayout$LayoutParams.topMargin, drawerLayout$LayoutParams.leftMargin + child.getMeasuredWidth(), drawerLayout$LayoutParams.topMargin + child.getMeasuredHeight());
                }
                else {
                    final int measuredWidth = child.getMeasuredWidth();
                    final int measuredHeight = child.getMeasuredHeight();
                    int n6;
                    float n7;
                    if (this.a(child, 3)) {
                        n6 = -measuredWidth + (int)(measuredWidth * drawerLayout$LayoutParams.b);
                        n7 = (measuredWidth + n6) / measuredWidth;
                    }
                    else {
                        n6 = n5 - (int)(measuredWidth * drawerLayout$LayoutParams.b);
                        n7 = (n5 - n6) / measuredWidth;
                    }
                    int n8;
                    if (n7 != drawerLayout$LayoutParams.b) {
                        n8 = 1;
                    }
                    else {
                        n8 = 0;
                    }
                    switch (0x70 & drawerLayout$LayoutParams.a) {
                        default: {
                            child.layout(n6, drawerLayout$LayoutParams.topMargin, measuredWidth + n6, measuredHeight + drawerLayout$LayoutParams.topMargin);
                            break;
                        }
                        case 80: {
                            final int n9 = n4 - n2;
                            child.layout(n6, n9 - drawerLayout$LayoutParams.bottomMargin - child.getMeasuredHeight(), measuredWidth + n6, n9 - drawerLayout$LayoutParams.bottomMargin);
                            break;
                        }
                        case 16: {
                            final int n10 = n4 - n2;
                            int topMargin = (n10 - measuredHeight) / 2;
                            if (topMargin < drawerLayout$LayoutParams.topMargin) {
                                topMargin = drawerLayout$LayoutParams.topMargin;
                            }
                            else if (topMargin + measuredHeight > n10 - drawerLayout$LayoutParams.bottomMargin) {
                                topMargin = n10 - drawerLayout$LayoutParams.bottomMargin - measuredHeight;
                            }
                            child.layout(n6, topMargin, measuredWidth + n6, measuredHeight + topMargin);
                            break;
                        }
                    }
                    if (n8 != 0) {
                        this.a(child, n7);
                    }
                    int visibility;
                    if (drawerLayout$LayoutParams.b > 0.0f) {
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
            Label_0358: {
                if (mode == 1073741824 && mode2 == 1073741824) {
                    break Label_0358;
                }
                if (!this.isInEditMode()) {
                    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
                }
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = n3;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 != 0) {
                    break Label_0358;
                }
                this.setMeasuredDimension(size, n3);
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.getChildAt(i);
                    if (child.getVisibility() != 8) {
                        final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                        if (f(child)) {
                            child.measure(View$MeasureSpec.makeMeasureSpec(size - drawerLayout$LayoutParams.leftMargin - drawerLayout$LayoutParams.rightMargin, 1073741824), View$MeasureSpec.makeMeasureSpec(n3 - drawerLayout$LayoutParams.topMargin - drawerLayout$LayoutParams.bottomMargin, 1073741824));
                        }
                        else {
                            if (!c(child)) {
                                throw new IllegalStateException("Child " + child + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            }
                            final int n4 = 0x7 & this.e(child);
                            if ((n4 & 0x0) != 0x0) {
                                throw new IllegalStateException("Child drawer has absolute gravity " + b(n4) + " but this DrawerLayout already has a drawer view along that edge");
                            }
                            child.measure(getChildMeasureSpec(n, this.b + drawerLayout$LayoutParams.leftMargin + drawerLayout$LayoutParams.rightMargin, drawerLayout$LayoutParams.width), getChildMeasureSpec(n2, drawerLayout$LayoutParams.topMargin + drawerLayout$LayoutParams.bottomMargin, drawerLayout$LayoutParams.height));
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
                this.g(a);
            }
        }
        this.setDrawerLockMode(drawerLayout$SavedState.b, 3);
        this.setDrawerLockMode(drawerLayout$SavedState.c, 5);
    }
    
    protected Parcelable onSaveInstanceState() {
        final DrawerLayout$SavedState drawerLayout$SavedState = new DrawerLayout$SavedState(super.onSaveInstanceState());
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (c(child)) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                if (drawerLayout$LayoutParams.d) {
                    drawerLayout$SavedState.a = drawerLayout$LayoutParams.a;
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
                final View b = this.f.b((int)x2, (int)y2);
            Label_0213:
                while (true) {
                    Label_0284: {
                        if (b == null || !f(b)) {
                            break Label_0284;
                        }
                        final float n = x2 - this.r;
                        final float n2 = y2 - this.s;
                        final int d = this.f.d();
                        if (n * n + n2 * n2 < d * d) {
                            final int childCount = this.getChildCount();
                            int i = 0;
                            while (true) {
                                while (i < childCount) {
                                    final View child = this.getChildAt(i);
                                    if (((DrawerLayout$LayoutParams)child.getLayoutParams()).d) {
                                        final View view = child;
                                        if (view != null) {
                                            final boolean b2 = this.a(view) == 2;
                                            break Label_0213;
                                        }
                                        break Label_0284;
                                    }
                                    else {
                                        ++i;
                                    }
                                }
                                final View view = null;
                                continue;
                            }
                        }
                        break Label_0284;
                        boolean b2 = false;
                        this.a(b2);
                        this.o = false;
                        return true;
                    }
                    final boolean b2 = true;
                    continue Label_0213;
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
    
    public void setDrawerListener(final de q) {
        this.q = q;
    }
    
    public void setDrawerLockMode(final int n) {
        this.setDrawerLockMode(n, 3);
        this.setDrawerLockMode(n, 5);
    }
    
    public void setDrawerLockMode(final int n, final int n2) {
        final int a = bj.a(n2, cf.b((View)this));
        if (a == 3) {
            this.m = n;
        }
        else if (a == 5) {
            this.n = n;
        }
        if (n != 0) {
            dt dt;
            if (a == 3) {
                dt = this.f;
            }
            else {
                dt = this.g;
            }
            dt.e();
        }
        switch (n) {
            case 2: {
                final View a2 = this.a(a);
                if (a2 != null) {
                    this.g(a2);
                    return;
                }
                break;
            }
            case 1: {
                final View a3 = this.a(a);
                if (a3 != null) {
                    this.d(a3);
                    return;
                }
                break;
            }
        }
    }
    
    public void setDrawerLockMode(final int n, final View obj) {
        if (!c(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a drawer with appropriate layout_gravity");
        }
        this.setDrawerLockMode(n, ((DrawerLayout$LayoutParams)obj.getLayoutParams()).a);
    }
    
    public void setDrawerShadow(final int n, final int n2) {
        this.setDrawerShadow(this.getResources().getDrawable(n), n2);
    }
    
    public void setDrawerShadow(final Drawable drawable, final int n) {
        final int a = bj.a(n, cf.b((View)this));
        if ((a & 0x3) == 0x3) {
            this.t = drawable;
            this.invalidate();
        }
        if ((a & 0x5) == 0x5) {
            this.u = drawable;
            this.invalidate();
        }
    }
    
    public void setDrawerTitle(final int n, final CharSequence charSequence) {
        final int a = bj.a(n, cf.b((View)this));
        if (a == 3) {
            this.v = charSequence;
        }
        else if (a == 5) {
            this.w = charSequence;
        }
    }
    
    public void setScrimColor(final int c) {
        this.c = c;
        this.invalidate();
    }
}
