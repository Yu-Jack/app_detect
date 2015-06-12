// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.n;
import android.view.KeyEvent;
import android.support.v4.view.s;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.support.v4.view.j;
import android.support.v4.view.av;
import android.support.v4.view.a;
import android.view.View;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.ViewGroup;

public class DrawerLayout extends ViewGroup
{
    private static final int[] a;
    private final c b;
    private int c;
    private int d;
    private float e;
    private Paint f;
    private final z g;
    private final z h;
    private final e i;
    private final e j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private d r;
    private float s;
    private float t;
    private Drawable u;
    private Drawable v;
    private CharSequence w;
    private CharSequence x;
    
    static {
        a = new int[] { 16842931 };
    }
    
    public DrawerLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public DrawerLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.b = new c(this);
        this.d = -1728053248;
        this.f = new Paint();
        this.m = true;
        final float density = this.getResources().getDisplayMetrics().density;
        this.c = (int)(0.5f + 64.0f * density);
        final float n2 = density * 400.0f;
        this.i = new e(this, 3);
        this.j = new e(this, 5);
        (this.g = z.a(this, 1.0f, this.i)).a(1);
        this.g.a(n2);
        this.i.a(this.g);
        (this.h = z.a(this, 1.0f, this.j)).a(2);
        this.h.a(n2);
        this.j.a(this.h);
        this.setFocusableInTouchMode(true);
        ah.b((View)this, 1);
        ah.a((View)this, new b(this));
        av.a(this);
    }
    
    private void a(final int n, final int n2) {
        final int a = android.support.v4.view.j.a(n2, ah.f((View)this));
        if (a == 3) {
            this.n = n;
        }
        else if (a == 5) {
            this.o = n;
        }
        if (n != 0) {
            z z;
            if (a == 3) {
                z = this.g;
            }
            else {
                z = this.h;
            }
            z.e();
        }
        switch (n) {
            case 2: {
                final View b = this.b(a);
                if (b != null) {
                    this.h(b);
                    return;
                }
                break;
            }
            case 1: {
                final View b2 = this.b(a);
                if (b2 != null) {
                    this.e(b2);
                    return;
                }
                break;
            }
        }
    }
    
    private void a(final boolean b) {
        final int childCount = this.getChildCount();
        int i = 0;
        boolean b2 = false;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
            if (d(child) && (!b || drawerLayout$LayoutParams.c)) {
                final int width = child.getWidth();
                if (this.a(child, 3)) {
                    b2 |= this.g.a(child, -width, child.getTop());
                }
                else {
                    b2 |= this.h.a(child, this.getWidth(), child.getTop());
                }
                drawerLayout$LayoutParams.c = false;
            }
            ++i;
        }
        this.i.a();
        this.j.a();
        if (b2) {
            this.invalidate();
        }
    }
    
    static float b(final View view) {
        return ((DrawerLayout$LayoutParams)view.getLayoutParams()).b;
    }
    
    private View c() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (d(child)) {
                if (!d(child)) {
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
    
    static boolean d(final View view) {
        return (0x7 & j.a(((DrawerLayout$LayoutParams)view.getLayoutParams()).a, ah.f(view))) != 0x0;
    }
    
    private static boolean g(final View view) {
        return ((DrawerLayout$LayoutParams)view.getLayoutParams()).a == 0;
    }
    
    private void h(final View obj) {
        if (!d(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a sliding drawer");
        }
        if (this.m) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)obj.getLayoutParams();
            drawerLayout$LayoutParams.b = 1.0f;
            drawerLayout$LayoutParams.d = true;
        }
        else if (this.a(obj, 3)) {
            this.g.a(obj, 0, obj.getTop());
        }
        else {
            this.h.a(obj, this.getWidth() - obj.getWidth(), obj.getTop());
        }
        this.invalidate();
    }
    
    public final int a(final View view) {
        final int c = this.c(view);
        if (c == 3) {
            return this.n;
        }
        if (c == 5) {
            return this.o;
        }
        return 0;
    }
    
    public final CharSequence a(final int n) {
        final int a = android.support.v4.view.j.a(n, ah.f((View)this));
        if (a == 3) {
            return this.w;
        }
        if (a == 5) {
            return this.x;
        }
        return null;
    }
    
    final void a() {
        int i = 0;
        if (!this.q) {
            final long uptimeMillis = SystemClock.uptimeMillis();
            final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            while (i < this.getChildCount()) {
                this.getChildAt(i).dispatchTouchEvent(obtain);
                ++i;
            }
            obtain.recycle();
            this.q = true;
        }
    }
    
    final void a(final int n, final View view) {
        final int a = this.g.a();
        final int a2 = this.h.a();
        int k;
        if (a == 1 || a2 == 1) {
            k = 1;
        }
        else if (a == 2 || a2 == 2) {
            k = 2;
        }
        else {
            k = 0;
        }
        if (view != null && n == 0) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            if (drawerLayout$LayoutParams.b == 0.0f) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams2 = (DrawerLayout$LayoutParams)view.getLayoutParams();
                if (drawerLayout$LayoutParams2.d) {
                    drawerLayout$LayoutParams2.d = false;
                    if (this.r != null) {
                        final d r = this.r;
                    }
                    final View child = this.getChildAt(0);
                    if (child != null) {
                        ah.b(child, 1);
                    }
                    ah.b(view, 4);
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
                    if (this.r != null) {
                        final d r2 = this.r;
                    }
                    final View child2 = this.getChildAt(0);
                    if (child2 != null) {
                        ah.b(child2, 4);
                    }
                    ah.b(view, 1);
                    this.sendAccessibilityEvent(32);
                    view.requestFocus();
                }
            }
        }
        if (k != this.k) {
            this.k = k;
            if (this.r != null) {
                final d r3 = this.r;
            }
        }
    }
    
    final void a(final View view, final float b) {
        final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
        if (b != drawerLayout$LayoutParams.b) {
            drawerLayout$LayoutParams.b = b;
            if (this.r != null) {
                final d r = this.r;
            }
        }
    }
    
    final boolean a(final View view, final int n) {
        return (n & this.c(view)) == n;
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (n > 0 || (n < 0 && this.getChildCount() > 0)) {
            ah.b(view, 4);
            ah.a(view, this.b);
        }
        else {
            ah.b(view, 1);
        }
        super.addView(view, n, viewGroup$LayoutParams);
    }
    
    final View b(final int n) {
        final int n2 = 0x7 & android.support.v4.view.j.a(n, ah.f((View)this));
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((0x7 & this.c(child)) == n2) {
                return child;
            }
        }
        return null;
    }
    
    final int c(final View view) {
        return android.support.v4.view.j.a(((DrawerLayout$LayoutParams)view.getLayoutParams()).a, ah.f((View)this));
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
        this.e = max;
        if (this.g.g() | this.h.g()) {
            ah.c((View)this);
        }
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final int height = this.getHeight();
        final boolean g = g(view);
        int width = this.getWidth();
        final int save = canvas.save();
        int n2 = 0;
        if (g) {
            final int childCount = this.getChildCount();
            int i = 0;
        Label_0149_Outer:
            while (i < childCount) {
                final View child = this.getChildAt(i);
                while (true) {
                    Label_0185: {
                        if (child == view || child.getVisibility() != 0) {
                            break Label_0185;
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
                        if (!b || !d(child) || child.getHeight() < height) {
                            break Label_0185;
                        }
                        int left;
                        if (this.a(child, 3)) {
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
                                break Label_0185;
                            }
                        }
                        ++i;
                        width = left;
                        continue Label_0149_Outer;
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
        if (this.e > 0.0f && g) {
            this.f.setColor((int)(((0xFF000000 & this.d) >>> 24) * this.e) << 24 | (0xFFFFFF & this.d));
            canvas.drawRect((float)n2, 0.0f, (float)n3, (float)this.getHeight(), this.f);
        }
        else {
            if (this.u != null && this.a(view, 3)) {
                final int intrinsicWidth = this.u.getIntrinsicWidth();
                final int right2 = view.getRight();
                final float max = Math.max(0.0f, Math.min(right2 / this.g.b(), 1.0f));
                this.u.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.u.setAlpha((int)(255.0f * max));
                this.u.draw(canvas);
                return drawChild;
            }
            if (this.v != null && this.a(view, 5)) {
                final int intrinsicWidth2 = this.v.getIntrinsicWidth();
                final int left2 = view.getLeft();
                final float max2 = Math.max(0.0f, Math.min((this.getWidth() - left2) / this.h.b(), 1.0f));
                this.v.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.v.setAlpha((int)(255.0f * max2));
                this.v.draw(canvas);
                return drawChild;
            }
        }
        return drawChild;
    }
    
    public final void e(final View obj) {
        if (!d(obj)) {
            throw new IllegalArgumentException("View " + obj + " is not a sliding drawer");
        }
        if (this.m) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)obj.getLayoutParams();
            drawerLayout$LayoutParams.b = 0.0f;
            drawerLayout$LayoutParams.d = false;
        }
        else if (this.a(obj, 3)) {
            this.g.a(obj, -obj.getWidth(), obj.getTop());
        }
        else {
            this.h.a(obj, this.getWidth(), obj.getTop());
        }
        this.invalidate();
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
        this.m = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int a = android.support.v4.view.s.a(motionEvent);
        final boolean b = this.g.a(motionEvent) | this.h.a(motionEvent);
        boolean b2 = false;
        Label_0059: {
            switch (a) {
                case 0: {
                    final float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    this.s = x;
                    this.t = y;
                    if (this.e > 0.0f && g(this.g.b((int)x, (int)y))) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    this.p = false;
                    this.q = false;
                    break Label_0059;
                }
                case 2: {
                    if (this.g.h()) {
                        this.i.a();
                        this.j.a();
                        b2 = false;
                        break Label_0059;
                    }
                    break;
                }
                case 1:
                case 3: {
                    this.a(true);
                    this.p = false;
                    this.q = false;
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
                        if (n != 0) {
                            return true;
                        }
                        final boolean q = this.q;
                        final boolean b3 = false;
                        if (q) {
                            return true;
                        }
                        return b3;
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
            if (this.c() != null) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            if (n2 != 0) {
                n.c(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final View c = this.c();
            if (c != null && this.a(c) == 0) {
                this.a(false);
            }
            boolean b = false;
            if (c != null) {
                b = true;
            }
            return b;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        this.l = true;
        final int n5 = n3 - n;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                if (g(child)) {
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
        this.l = false;
        this.m = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        int n3 = 300;
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        int size = View$MeasureSpec.getSize(n);
        final int size2 = View$MeasureSpec.getSize(n2);
        while (true) {
            Label_0398: {
                if (mode == 1073741824 && mode2 == 1073741824) {
                    break Label_0398;
                }
                if (!this.isInEditMode()) {
                    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
                }
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = n3;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 != 0) {
                    break Label_0398;
                }
                this.setMeasuredDimension(size, n3);
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.getChildAt(i);
                    if (child.getVisibility() != 8) {
                        final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                        if (g(child)) {
                            child.measure(View$MeasureSpec.makeMeasureSpec(size - drawerLayout$LayoutParams.leftMargin - drawerLayout$LayoutParams.rightMargin, 1073741824), View$MeasureSpec.makeMeasureSpec(n3 - drawerLayout$LayoutParams.topMargin - drawerLayout$LayoutParams.bottomMargin, 1073741824));
                        }
                        else {
                            if (!d(child)) {
                                throw new IllegalStateException("Child " + child + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            }
                            final int j = 0x7 & this.c(child);
                            if ((j & 0x0) != 0x0) {
                                final StringBuilder sb = new StringBuilder("Child drawer has absolute gravity ");
                                String hexString;
                                if ((j & 0x3) == 0x3) {
                                    hexString = "LEFT";
                                }
                                else if ((j & 0x5) == 0x5) {
                                    hexString = "RIGHT";
                                }
                                else {
                                    hexString = Integer.toHexString(j);
                                }
                                throw new IllegalStateException(sb.append(hexString).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                            }
                            child.measure(getChildMeasureSpec(n, this.c + drawerLayout$LayoutParams.leftMargin + drawerLayout$LayoutParams.rightMargin, drawerLayout$LayoutParams.width), getChildMeasureSpec(n2, drawerLayout$LayoutParams.topMargin + drawerLayout$LayoutParams.bottomMargin, drawerLayout$LayoutParams.height));
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
            final View b = this.b(drawerLayout$SavedState.a);
            if (b != null) {
                this.h(b);
            }
        }
        this.a(drawerLayout$SavedState.b, 3);
        this.a(drawerLayout$SavedState.c, 5);
    }
    
    protected Parcelable onSaveInstanceState() {
        final DrawerLayout$SavedState drawerLayout$SavedState = new DrawerLayout$SavedState(super.onSaveInstanceState());
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (d(child)) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                if (drawerLayout$LayoutParams.d) {
                    drawerLayout$SavedState.a = drawerLayout$LayoutParams.a;
                    break;
                }
            }
        }
        drawerLayout$SavedState.b = this.n;
        drawerLayout$SavedState.c = this.o;
        return (Parcelable)drawerLayout$SavedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.g.b(motionEvent);
        this.h.b(motionEvent);
        switch (0xFF & motionEvent.getAction()) {
            default: {
                return true;
            }
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                this.s = x;
                this.t = y;
                this.p = false;
                this.q = false;
                return true;
            }
            case 1: {
                final float x2 = motionEvent.getX();
                final float y2 = motionEvent.getY();
                final View b = this.g.b((int)x2, (int)y2);
            Label_0236:
                while (true) {
                    Label_0284: {
                        if (b == null || !g(b)) {
                            break Label_0284;
                        }
                        final float n = x2 - this.s;
                        final float n2 = y2 - this.t;
                        final int d = this.g.d();
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
                                            break Label_0236;
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
                        this.p = false;
                        return true;
                    }
                    final boolean b2 = true;
                    continue Label_0236;
                }
            }
            case 3: {
                this.a(true);
                this.p = false;
                this.q = false;
                return true;
            }
        }
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean p) {
        super.requestDisallowInterceptTouchEvent(p);
        this.p = p;
        if (p) {
            this.a(true);
        }
    }
    
    public void requestLayout() {
        if (!this.l) {
            super.requestLayout();
        }
    }
}
