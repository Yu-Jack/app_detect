// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.graphics.Rect;
import android.view.View$MeasureSpec;
import android.util.Log;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import java.util.List;
import java.util.Collections;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.os.Build$VERSION;
import android.view.ViewConfiguration;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import java.util.ArrayList;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;

public class MyViewPager extends ViewGroup
{
    private static final int[] a;
    private static final Comparator b;
    private static final Interpolator c;
    private float A;
    private float B;
    private int C;
    private VelocityTracker D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private di I;
    private di J;
    private boolean K;
    private boolean L;
    private int M;
    private aac N;
    private aac O;
    private aab P;
    private int Q;
    private final ArrayList d;
    private zt e;
    private int f;
    private int g;
    private Parcelable h;
    private ClassLoader i;
    private Scroller j;
    private aad k;
    private int l;
    private Drawable m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private boolean x;
    private int y;
    private float z;
    
    static {
        a = new int[] { 16842931 };
        b = new zw();
        c = (Interpolator)new zx();
    }
    
    public MyViewPager(final Context context) {
        super(context);
        this.d = new ArrayList();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.v = 1;
        this.C = -1;
        this.K = true;
        this.Q = 0;
        this.e();
    }
    
    public MyViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.d = new ArrayList();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.v = 1;
        this.C = -1;
        this.K = true;
        this.Q = 0;
        this.e();
    }
    
    private zz a(final View view) {
        for (int i = 0; i < this.d.size(); ++i) {
            final zz zz = this.d.get(i);
            if (this.e.a(view, zz.a)) {
                return zz;
            }
        }
        return null;
    }
    
    private void a(final int q) {
        if (this.Q != q) {
            this.Q = q;
            if (this.N != null) {
                this.N.b(q);
            }
        }
    }
    
    private void a(final int b, final int index) {
        final zz zz = new zz();
        zz.b = b;
        zz.a = this.e.a(this, b);
        if (index < 0) {
            this.d.add(zz);
            return;
        }
        this.d.add(index, zz);
    }
    
    private void a(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n + n3;
        if (n2 > 0) {
            final int scrollX = this.getScrollX();
            final int n6 = n2 + n4;
            final int n7 = (scrollX % n6 / n6 + scrollX / n6) * n5;
            this.scrollTo(n7, this.getScrollY());
            if (!this.j.isFinished()) {
                this.j.startScroll(n7, 0, n5 * this.f, 0, this.j.getDuration() - this.j.timePassed());
            }
        }
        else {
            final int n8 = n5 * this.f;
            if (n8 != this.getScrollX()) {
                this.h();
                this.scrollTo(n8, this.getScrollY());
            }
        }
    }
    
    private void a(final int n, final boolean b, final boolean b2) {
        this.a(n, b, b2, 0);
    }
    
    private void a(int f, final boolean b, final boolean b2, final int a) {
        if (this.e != null) {
            final zt e = this.e;
            if (!b2 && this.f == f && this.d.size() != 0) {
                this.a(false);
            }
            else {
                if (f < 0) {
                    f = 0;
                }
                else {
                    final zt e2 = this.e;
                    if (f >= 2) {
                        final zt e3 = this.e;
                        f = 1;
                    }
                }
                final int v = this.v;
                if (f > v + this.f || f < this.f - v) {
                    for (int i = 0; i < this.d.size(); ++i) {
                        ((zz)this.d.get(i)).c = true;
                    }
                }
                boolean b3;
                if (this.f != f) {
                    b3 = true;
                }
                else {
                    b3 = false;
                }
                this.f = f;
                this.f();
                final int n = f * (this.getWidth() + this.l);
                if (!b) {
                    if (b3 && this.N != null) {
                        this.N.c(f);
                    }
                    if (b3 && this.O != null) {
                        this.O.c(f);
                    }
                    this.h();
                    this.scrollTo(n, 0);
                    return;
                }
                if (this.getChildCount() == 0) {
                    this.a(false);
                }
                else {
                    final int scrollX = this.getScrollX();
                    final int scrollY = this.getScrollY();
                    final int n2 = n - scrollX;
                    final int n3 = 0 - scrollY;
                    if (n2 == 0 && n3 == 0) {
                        this.h();
                        this.a(0);
                    }
                    else {
                        this.a(true);
                        this.u = true;
                        this.a(2);
                        final int width = this.getWidth();
                        final int n4 = width / 2;
                        final float n5 = n4 + n4 * (float)Math.sin((float)(0.4712389167638204 * (Math.min(1.0f, 1.0f * Math.abs(n2) / width) - 0.5f)));
                        final int abs = Math.abs(a);
                        int a2;
                        if (abs > 0) {
                            a2 = 4 * Math.round(1000.0f * Math.abs(n5 / abs));
                        }
                        else {
                            a2 = (int)(100.0f * (1.0f + Math.abs(n2) / (width + this.l)));
                        }
                        this.j.startScroll(scrollX, scrollY, n2, n3, Math.min(a2, 600));
                        this.invalidate();
                    }
                }
                if (b3 && this.N != null) {
                    this.N.c(f);
                }
                if (b3 && this.O != null) {
                    this.O.c(f);
                }
            }
            return;
        }
        this.a(false);
    }
    
    private void a(final MotionEvent motionEvent) {
        final int b = bv.b(motionEvent);
        if (bv.b(motionEvent, b) == this.C) {
            int n;
            if (b == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.A = bv.c(motionEvent, n);
            this.C = bv.b(motionEvent, n);
            if (this.D != null) {
                this.D.clear();
            }
        }
    }
    
    private void a(final boolean s) {
        if (this.s != s) {
            this.s = s;
        }
    }
    
    private boolean a(final View view, final boolean b, final int n, final int n2, final int n3) {
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final int scrollX = view.getScrollX();
            final int scrollY = view.getScrollY();
            for (int i = -1 + viewGroup.getChildCount(); i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                if (n2 + scrollX >= child.getLeft() && n2 + scrollX < child.getRight() && n3 + scrollY >= child.getTop() && n3 + scrollY < child.getBottom() && this.a(child, true, n, n2 + scrollX - child.getLeft(), n3 + scrollY - child.getTop())) {
                    return true;
                }
            }
        }
        if (!b || !cf.a(view, -n)) {
            return false;
        }
        return true;
    }
    
    private boolean b(final int n) {
        Object focus = this.findFocus();
        if (focus == this) {
            focus = null;
        }
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)focus, n);
        while (true) {
            Label_0154: {
                boolean b2 = false;
                Label_0062: {
                    boolean b;
                    if (nextFocus != null && nextFocus != focus) {
                        if (n == 17) {
                            if (focus != null && nextFocus.getLeft() >= ((View)focus).getLeft()) {
                                b = this.j();
                            }
                            else {
                                b = nextFocus.requestFocus();
                            }
                        }
                        else {
                            b2 = false;
                            if (n != 66) {
                                break Label_0062;
                            }
                            if (focus != null && nextFocus.getLeft() <= ((View)focus).getLeft()) {
                                break Label_0154;
                            }
                            b = nextFocus.requestFocus();
                        }
                    }
                    else if (n == 17 || n == 1) {
                        b = this.j();
                    }
                    else {
                        if (n == 66) {
                            break Label_0154;
                        }
                        b2 = false;
                        if (n == 2) {
                            break Label_0154;
                        }
                        break Label_0062;
                    }
                    b2 = b;
                }
                if (b2) {
                    this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(n));
                }
                return b2;
            }
            if (this.e != null) {
                final int f = this.f;
                final zt e = this.e;
                if (f <= 0) {
                    this.setCurrentItem(1 + this.f, true);
                    final boolean b = true;
                    continue;
                }
            }
            boolean b = false;
            continue;
        }
    }
    
    private void e() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        final Context context = this.getContext();
        this.j = new Scroller(context, MyViewPager.c);
        final ViewConfiguration value = ViewConfiguration.get(context);
        this.y = cs.a(value);
        this.E = value.getScaledMinimumFlingVelocity();
        this.F = value.getScaledMaximumFlingVelocity();
        if (Build$VERSION.SDK_INT >= 14) {
            this.I = new di(context);
            this.J = new di(context);
        }
        else {
            this.I = new aaa(context);
            this.J = new aaa(context);
        }
        this.G = (int)(25.0f * context.getResources().getDisplayMetrics().density);
    }
    
    private void f() {
        if (this.e != null && !this.t && this.getWindowToken() != null) {
            final zt e = this.e;
            final int v = this.v;
            final int max = Math.max(0, this.f - v);
            final zt e2 = this.e;
            final int min = Math.min(1, v + this.f);
            int i = 0;
            int n = -1;
            while (i < this.d.size()) {
                final zz zz = this.d.get(i);
                int n3;
                if ((zz.b < max || zz.b > min) && !zz.c) {
                    this.d.remove(i);
                    final int n2 = i - 1;
                    this.e.a(this, zz.b, zz.a);
                    n3 = n2;
                }
                else {
                    if (n < min && zz.b > max) {
                        int n4 = n + 1;
                        if (n4 < max) {
                            n4 = max;
                        }
                        while (n4 <= min && n4 < zz.b) {
                            this.a(n4, i);
                            ++n4;
                            ++i;
                        }
                    }
                    n3 = i;
                }
                final int b = zz.b;
                final int n5 = n3 + 1;
                n = b;
                i = n5;
            }
            int b2;
            if (this.d.size() > 0) {
                b2 = this.d.get(-1 + this.d.size()).b;
            }
            else {
                b2 = -1;
            }
            if (b2 < min) {
                int j = b2 + 1;
                if (j <= max) {
                    j = max;
                }
                while (j <= min) {
                    this.a(j, -1);
                    ++j;
                }
            }
            int k = 0;
            while (true) {
                while (k < this.d.size()) {
                    if (((zz)this.d.get(k)).b == this.f) {
                        final zz zz2 = this.d.get(k);
                        final zt e3 = this.e;
                        final int f = this.f;
                        Object a;
                        if (zz2 != null) {
                            a = zz2.a;
                        }
                        else {
                            a = null;
                        }
                        e3.a(a);
                        this.e.a();
                        if (this.hasFocus()) {
                            final View focus = this.findFocus();
                            zz a2 = null;
                            if (focus != null) {
                                View view = focus;
                                while (true) {
                                    final ViewParent parent = view.getParent();
                                    if (parent == this) {
                                        a2 = this.a(view);
                                        break;
                                    }
                                    a2 = null;
                                    if (parent == null) {
                                        break;
                                    }
                                    final boolean b3 = parent instanceof View;
                                    a2 = null;
                                    if (!b3) {
                                        break;
                                    }
                                    view = (View)parent;
                                }
                            }
                            int l = 0;
                            if (a2 != null) {
                                final int b4 = a2.b;
                                final int f2 = this.f;
                                l = 0;
                                if (b4 == f2) {
                                    return;
                                }
                            }
                            while (l < this.getChildCount()) {
                                final View child = this.getChildAt(l);
                                final zz a3 = this.a(child);
                                if (a3 != null && a3.b == this.f && child.requestFocus(2)) {
                                    break;
                                }
                                ++l;
                            }
                        }
                        return;
                    }
                    else {
                        ++k;
                    }
                }
                final zz zz2 = null;
                continue;
            }
        }
    }
    
    private void g() {
        this.getWidth();
        final int l = this.l;
        this.L = false;
        if (this.M > 0) {
            final int scrollX = this.getScrollX();
            int paddingLeft = this.getPaddingLeft();
            int paddingRight = this.getPaddingRight();
            final int width = this.getWidth();
            int n2 = 0;
            int n3 = 0;
            int n10;
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i, n10 = n3, paddingLeft = n2, paddingRight = n10) {
                final View child = this.getChildAt(i);
                final MyViewPager$LayoutParams myViewPager$LayoutParams = (MyViewPager$LayoutParams)child.getLayoutParams();
                if (myViewPager$LayoutParams.a) {
                    int max = 0;
                    switch (0x7 & myViewPager$LayoutParams.b) {
                        default: {
                            max = paddingLeft;
                            final int n = paddingRight;
                            n2 = paddingLeft;
                            n3 = n;
                            break;
                        }
                        case 3: {
                            final int n4 = paddingLeft + child.getWidth();
                            final int n5 = paddingLeft;
                            n3 = paddingRight;
                            n2 = n4;
                            max = n5;
                            break;
                        }
                        case 1: {
                            max = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            final int n6 = paddingRight;
                            n2 = paddingLeft;
                            n3 = n6;
                            break;
                        }
                        case 5: {
                            max = width - paddingRight - child.getMeasuredWidth();
                            final int n7 = paddingRight + child.getMeasuredWidth();
                            n2 = paddingLeft;
                            n3 = n7;
                            break;
                        }
                    }
                    final int n8 = max + scrollX - child.getLeft();
                    if (n8 != 0) {
                        child.offsetLeftAndRight(n8);
                    }
                }
                else {
                    final int n9 = paddingRight;
                    n2 = paddingLeft;
                    n3 = n9;
                }
            }
        }
        if (this.N != null) {
            final aac n11 = this.N;
        }
        if (this.O != null) {
            final aac o = this.O;
        }
        if (!(this.L = true)) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }
    
    private void h() {
        final boolean u = this.u;
        if (u) {
            this.a(false);
            this.j.abortAnimation();
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.j.getCurrX();
            final int currY = this.j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
            }
            this.a(0);
        }
        this.t = false;
        this.u = false;
        int i = 0;
        int n = u ? 1 : 0;
        while (i < this.d.size()) {
            final zz zz = this.d.get(i);
            if (zz.c) {
                n = 1;
                zz.c = false;
            }
            ++i;
        }
        if (n != 0) {
            this.f();
        }
    }
    
    private void i() {
        this.w = false;
        this.x = false;
        if (this.D != null) {
            this.D.recycle();
            this.D = null;
        }
    }
    
    private boolean j() {
        if (this.f > 0) {
            this.setCurrentItem(-1 + this.f, true);
            return true;
        }
        return false;
    }
    
    public final zt a() {
        return this.e;
    }
    
    public void addFocusables(final ArrayList list, final int n, final int n2) {
        final int size = list.size();
        final int descendantFocusability = this.getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 0) {
                    final zz a = this.a(child);
                    if (a != null && a.b == this.f) {
                        child.addFocusables(list, n, n2);
                    }
                }
            }
        }
        if ((descendantFocusability != 262144 || size == list.size()) && this.isFocusable() && ((n2 & 0x1) != 0x1 || !this.isInTouchMode() || this.isFocusableInTouchMode()) && list != null) {
            list.add(this);
        }
    }
    
    public void addTouchables(final ArrayList list) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final zz a = this.a(child);
                if (a != null && a.b == this.f) {
                    child.addTouchables(list);
                }
            }
        }
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        ViewGroup$LayoutParams generateLayoutParams;
        if (!this.checkLayoutParams(viewGroup$LayoutParams)) {
            generateLayoutParams = this.generateLayoutParams(viewGroup$LayoutParams);
        }
        else {
            generateLayoutParams = viewGroup$LayoutParams;
        }
        final MyViewPager$LayoutParams myViewPager$LayoutParams = (MyViewPager$LayoutParams)generateLayoutParams;
        myViewPager$LayoutParams.a |= (view instanceof zy);
        if (!this.r) {
            super.addView(view, n, generateLayoutParams);
            return;
        }
        if (myViewPager$LayoutParams != null && myViewPager$LayoutParams.a) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        this.addViewInLayout(view, n, generateLayoutParams);
        view.measure(this.p, this.q);
    }
    
    public final int b() {
        return this.f;
    }
    
    public final void c() {
        int i = 0;
        while (true) {
            Label_0069: {
                if (this.d.size() >= 3) {
                    break Label_0069;
                }
                final int size = this.d.size();
                final zt e = this.e;
                if (size >= 2) {
                    break Label_0069;
                }
                final int n = 1;
                while (i < this.d.size()) {
                    final zz zz = this.d.get(i);
                    final zt e2 = this.e;
                    final Object a = zz.a;
                    ++i;
                }
                Collections.sort((List<Object>)this.d, MyViewPager.b);
                if (n != 0) {
                    this.f();
                    this.requestLayout();
                }
                return;
            }
            final int n = 0;
            i = 0;
            continue;
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof MyViewPager$LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        if (!this.j.isFinished() && this.j.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.j.getCurrX();
            final int currY = this.j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
                this.g();
            }
            this.invalidate();
            return;
        }
        this.h();
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            boolean b = false;
            Label_0054: {
                if (keyEvent.getAction() == 0) {
                    switch (keyEvent.getKeyCode()) {
                        case 21: {
                            b = this.b(17);
                            break Label_0054;
                        }
                        case 22: {
                            b = this.b(66);
                            break Label_0054;
                        }
                        case 61: {
                            if (Build$VERSION.SDK_INT < 11) {
                                break;
                            }
                            if (bo.a(keyEvent)) {
                                b = this.b(2);
                                break Label_0054;
                            }
                            if (bo.a(keyEvent, 1)) {
                                b = this.b(1);
                                break Label_0054;
                            }
                            break;
                        }
                    }
                }
                b = false;
            }
            if (!b) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final zz a = this.a(child);
                if (a != null && a.b == this.f && child.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void draw(final Canvas canvas) {
        int n = 1;
        boolean b;
        if (Build$VERSION.SDK_INT >= 14) {
            super.draw(canvas);
            final boolean a = this.I.a();
            b = false;
            if (!a) {
                final int save = canvas.save();
                final int n2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n2 + this.getPaddingTop()), 0.0f);
                this.I.a(n2, this.getWidth());
                b = (false | this.I.a(canvas));
                canvas.restoreToCount(save);
            }
            if (!this.J.a()) {
                final int save2 = canvas.save();
                final int width = this.getWidth();
                final int n3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                if (this.e != null) {
                    final zt e = this.e;
                    n = 2;
                }
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), (float)(-n * (width + this.l) + this.l));
                this.J.a(n3, width);
                b |= this.J.a(canvas);
                canvas.restoreToCount(save2);
            }
        }
        else {
            boolean b3;
            int n4;
            if (!this.I.a()) {
                canvas.translate((float)this.getScrollX(), (float)this.getScrollY());
                if (this.getBackground() != null) {
                    this.getBackground().draw(canvas);
                }
                canvas.translate((float)(-this.getScrollX()), (float)(-this.getScrollY()));
                final int save3 = canvas.save();
                canvas.translate(((aaa)this.I).a * gw.c(this.getContext(), 160), 0.0f);
                super.draw(canvas);
                final boolean b2 = false | this.I.a(canvas);
                canvas.restoreToCount(save3);
                b3 = b2;
                n4 = n;
            }
            else {
                n4 = 0;
                b3 = false;
            }
            if (!this.J.a()) {
                canvas.translate((float)this.getScrollX(), (float)this.getScrollY());
                if (this.getBackground() != null) {
                    this.getBackground().draw(canvas);
                }
                canvas.translate((float)(-this.getScrollX()), (float)(-this.getScrollY()));
                final int save4 = canvas.save();
                canvas.translate(-((aaa)this.J).a * gw.c(this.getContext(), 160), 0.0f);
                super.draw(canvas);
                b = (b3 | this.J.a(canvas));
                canvas.restoreToCount(save4);
            }
            else {
                n = n4;
                b = b3;
            }
            if (n == 0) {
                super.draw(canvas);
            }
        }
        if (b) {
            this.invalidate();
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable m = this.m;
        if (m != null && m.isStateful()) {
            m.setState(this.getDrawableState());
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new MyViewPager$LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new MyViewPager$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.generateDefaultLayoutParams();
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = true;
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.l > 0 && this.m != null) {
            final int scrollX = this.getScrollX();
            final int width = this.getWidth();
            final int n = scrollX % (width + this.l);
            if (n != 0) {
                final int n2 = width + (scrollX - n);
                this.m.setBounds(n2, this.n, n2 + this.l, this.o);
                this.m.draw(canvas);
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int n = 0xFF & motionEvent.getAction();
        if (n != 3 && n != 1) {
            if (n != 0) {
                if (this.w) {
                    return true;
                }
                if (this.x) {
                    return false;
                }
            }
            switch (n) {
                case 2: {
                    final int c = this.C;
                    if (c == -1) {
                        break;
                    }
                    final int a = bv.a(motionEvent, c);
                    final float c2 = bv.c(motionEvent, a);
                    final float a2 = c2 - this.A;
                    final float abs = Math.abs(a2);
                    final float d = bv.d(motionEvent, a);
                    final float abs2 = Math.abs(d - this.B);
                    if (this.a((View)this, false, (int)a2, (int)c2, (int)d)) {
                        this.A = c2;
                        this.z = c2;
                        this.B = d;
                        return false;
                    }
                    if (abs > this.y && abs > abs2) {
                        this.w = true;
                        this.a(1);
                        this.A = c2;
                        this.a(true);
                        break;
                    }
                    if (abs2 > this.y) {
                        this.x = true;
                        break;
                    }
                    break;
                }
                case 0: {
                    final float x = motionEvent.getX();
                    this.z = x;
                    this.A = x;
                    this.B = motionEvent.getY();
                    this.C = bv.b(motionEvent, 0);
                    this.h();
                    this.w = false;
                    this.x = false;
                    break;
                }
                case 6: {
                    this.a(motionEvent);
                    break;
                }
            }
            if (!this.w) {
                if (this.D == null) {
                    this.D = VelocityTracker.obtain();
                }
                this.D.addMovement(motionEvent);
            }
            return this.w;
        }
        this.w = false;
        this.x = false;
        this.C = -1;
        if (this.D != null) {
            this.D.recycle();
            this.D = null;
        }
        return false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        this.r = true;
        this.f();
        this.r = false;
        final int childCount = this.getChildCount();
        final int n5 = n3 - n;
        final int n6 = n4 - n2;
        int paddingLeft = this.getPaddingLeft();
        int paddingTop = this.getPaddingTop();
        int paddingRight = this.getPaddingRight();
        int paddingBottom = this.getPaddingBottom();
        final int scrollX = this.getScrollX();
        int m = 0;
        int i = 0;
    Label_0310_Outer:
        while (i < childCount) {
            final View child = this.getChildAt(i);
            while (true) {
                Label_0554: {
                    if (child.getVisibility() == 8) {
                        break Label_0554;
                    }
                    final MyViewPager$LayoutParams myViewPager$LayoutParams = (MyViewPager$LayoutParams)child.getLayoutParams();
                    final int n20;
                    final int n21;
                    final int n22;
                    final int n23;
                    if (myViewPager$LayoutParams.a) {
                        final int n7 = 0x7 & myViewPager$LayoutParams.b;
                        final int n8 = 0x70 & myViewPager$LayoutParams.b;
                        int max = 0;
                        switch (n7) {
                            default: {
                                max = paddingLeft;
                                break;
                            }
                            case 3: {
                                final int n9 = paddingLeft + child.getMeasuredWidth();
                                max = paddingLeft;
                                paddingLeft = n9;
                                break;
                            }
                            case 1: {
                                max = Math.max((n5 - child.getMeasuredWidth()) / 2, paddingLeft);
                                break;
                            }
                            case 5: {
                                final int n10 = n5 - paddingRight - child.getMeasuredWidth();
                                paddingRight += child.getMeasuredWidth();
                                max = n10;
                                break;
                            }
                        }
                        int max2 = 0;
                        int n12 = 0;
                        int n13 = 0;
                        switch (n8) {
                            default: {
                                max2 = paddingTop;
                                final int n11 = paddingBottom;
                                n12 = paddingTop;
                                n13 = n11;
                                break;
                            }
                            case 48: {
                                final int n14 = paddingTop + child.getMeasuredHeight();
                                final int n15 = paddingTop;
                                n13 = paddingBottom;
                                n12 = n14;
                                max2 = n15;
                                break;
                            }
                            case 16: {
                                max2 = Math.max((n6 - child.getMeasuredHeight()) / 2, paddingTop);
                                final int n16 = paddingBottom;
                                n12 = paddingTop;
                                n13 = n16;
                                break;
                            }
                            case 80: {
                                max2 = n6 - paddingBottom - child.getMeasuredHeight();
                                final int n17 = paddingBottom + child.getMeasuredHeight();
                                n12 = paddingTop;
                                n13 = n17;
                                break;
                            }
                        }
                        final int n18 = max + scrollX;
                        final int n19 = m + 1;
                        child.layout(n18, max2, n18 + child.getMeasuredWidth(), max2 + child.getMeasuredHeight());
                        n20 = n19;
                        n21 = n12;
                        paddingBottom = n13;
                        n22 = paddingRight;
                        n23 = paddingLeft;
                    }
                    else {
                        final zz a = this.a(child);
                        if (a != null) {
                            final int n24 = paddingLeft + (n5 + this.l) * a.b;
                            child.layout(n24, paddingTop, n24 + child.getMeasuredWidth(), paddingTop + child.getMeasuredHeight());
                        }
                        break Label_0554;
                    }
                    ++i;
                    paddingLeft = n23;
                    paddingRight = n22;
                    paddingTop = n21;
                    m = n20;
                    continue Label_0310_Outer;
                }
                int n20 = m;
                int n21 = paddingTop;
                int n22 = paddingRight;
                int n23 = paddingLeft;
                continue;
            }
        }
        this.n = paddingTop;
        this.o = n6 - paddingBottom;
        this.M = m;
        this.K = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(getDefaultSize(0, n), getDefaultSize(0, n2));
        int n3 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
        int n4 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        final int childCount = this.getChildCount();
        int i = 0;
    Label_0314_Outer:
        while (i < childCount) {
            final View child = this.getChildAt(i);
            while (true) {
                Label_0433: {
                    if (child.getVisibility() == 8) {
                        break Label_0433;
                    }
                    final MyViewPager$LayoutParams myViewPager$LayoutParams = (MyViewPager$LayoutParams)child.getLayoutParams();
                    if (myViewPager$LayoutParams == null || !myViewPager$LayoutParams.a) {
                        break Label_0433;
                    }
                    final int j = 0x7 & myViewPager$LayoutParams.b;
                    final int k = 0x70 & myViewPager$LayoutParams.b;
                    Log.d("ViewPager", "gravity: " + myViewPager$LayoutParams.b + " hgrav: " + j + " vgrav: " + k);
                    int n5 = Integer.MIN_VALUE;
                    int n6 = Integer.MIN_VALUE;
                    boolean b;
                    if (k != 48 && k != 80) {
                        b = false;
                    }
                    else {
                        b = true;
                    }
                    final boolean b2 = j == 3 || j == 5;
                    if (b) {
                        n5 = 1073741824;
                    }
                    else if (b2) {
                        n6 = 1073741824;
                    }
                    child.measure(View$MeasureSpec.makeMeasureSpec(n3, n5), View$MeasureSpec.makeMeasureSpec(n4, n6));
                    int n7;
                    int n8;
                    if (b) {
                        n7 = n4 - child.getMeasuredHeight();
                        n8 = n3;
                    }
                    else {
                        if (!b2) {
                            break Label_0433;
                        }
                        n8 = n3 - child.getMeasuredWidth();
                        n7 = n4;
                    }
                    ++i;
                    n3 = n8;
                    n4 = n7;
                    continue Label_0314_Outer;
                }
                int n7 = n4;
                int n8 = n3;
                continue;
            }
        }
        this.p = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
        this.q = View$MeasureSpec.makeMeasureSpec(n4, 1073741824);
        this.r = true;
        this.f();
        this.r = false;
        for (int childCount2 = this.getChildCount(), l = 0; l < childCount2; ++l) {
            final View child2 = this.getChildAt(l);
            if (child2.getVisibility() != 8) {
                final MyViewPager$LayoutParams myViewPager$LayoutParams2 = (MyViewPager$LayoutParams)child2.getLayoutParams();
                if (myViewPager$LayoutParams2 == null || !myViewPager$LayoutParams2.a) {
                    child2.measure(this.p, this.q);
                }
            }
        }
    }
    
    protected boolean onRequestFocusInDescendants(final int n, final Rect rect) {
        boolean b = true;
        int n2 = -1;
        int childCount = this.getChildCount();
        int i;
        if ((n & 0x2) != 0x0) {
            n2 = (b ? 1 : 0);
            i = 0;
        }
        else {
            i = childCount - 1;
            childCount = n2;
        }
        while (i != childCount) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final zz a = this.a(child);
                if (a != null && a.b == this.f && child.requestFocus(n, rect)) {
                    return b;
                }
            }
            i += n2;
        }
        b = false;
        return b;
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof MyViewPager$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final MyViewPager$SavedState myViewPager$SavedState = (MyViewPager$SavedState)parcelable;
        super.onRestoreInstanceState(myViewPager$SavedState.getSuperState());
        if (this.e != null) {
            this.e.a(myViewPager$SavedState.b, myViewPager$SavedState.c);
            this.a(myViewPager$SavedState.a, false, true);
            return;
        }
        this.g = myViewPager$SavedState.a;
        this.h = myViewPager$SavedState.b;
        this.i = myViewPager$SavedState.c;
    }
    
    public Parcelable onSaveInstanceState() {
        final MyViewPager$SavedState myViewPager$SavedState = new MyViewPager$SavedState(super.onSaveInstanceState());
        myViewPager$SavedState.a = this.f;
        if (this.e != null) {
            myViewPager$SavedState.b = this.e.b();
        }
        return (Parcelable)myViewPager$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            this.a(n, n3, this.l, this.l);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        boolean b;
        if (this.H) {
            b = true;
        }
        else {
            if (motionEvent.getAction() == 0) {
                final int edgeFlags = motionEvent.getEdgeFlags();
                b = false;
                if (edgeFlags != 0) {
                    return b;
                }
            }
            final zt e = this.e;
            b = false;
            if (e != null) {
                final zt e2 = this.e;
                if (this.D == null) {
                    this.D = VelocityTracker.obtain();
                }
                this.D.addMovement(motionEvent);
                final int n = 0xFF & motionEvent.getAction();
                int n2 = 0;
                switch (n) {
                    case 0: {
                        this.h();
                        final float x = motionEvent.getX();
                        this.z = x;
                        this.A = x;
                        this.C = bv.b(motionEvent, 0);
                        n2 = 0;
                        break;
                    }
                    case 2: {
                        if (!this.w) {
                            final int a = bv.a(motionEvent, this.C);
                            final float c = bv.c(motionEvent, a);
                            final float abs = Math.abs(c - this.A);
                            final float abs2 = Math.abs(bv.d(motionEvent, a) - this.B);
                            if (abs > this.y && abs > abs2) {
                                this.w = true;
                                this.A = c;
                                this.a(1);
                                this.a(true);
                            }
                        }
                        final boolean w = this.w;
                        n2 = 0;
                        if (w) {
                            final float c2 = bv.c(motionEvent, bv.a(motionEvent, this.C));
                            final float n3 = this.A - c2;
                            this.A = c2;
                            final float n4 = n3 + this.getScrollX();
                            final int width = this.getWidth();
                            final int n5 = width + this.l;
                            final zt e3 = this.e;
                            final float n6 = Math.max(0, n5 * (-1 + this.f));
                            final float n7 = n5 * Math.min(1 + this.f, 1);
                            int n9;
                            float n10;
                            if (n4 < n6) {
                                final float n8 = fcmpl(n6, 0.0f);
                                int a2 = 0;
                                if (n8 == 0) {
                                    a2 = (this.I.a(-n4 / width) ? 1 : 0);
                                }
                                n9 = a2;
                                n10 = n6;
                            }
                            else if (n4 > n7) {
                                final float n11 = fcmpl(n7, (float)(n5 * 1));
                                int a3 = 0;
                                if (n11 == 0) {
                                    a3 = (this.J.a((n4 - n7) / width) ? 1 : 0);
                                }
                                n9 = a3;
                                n10 = n7;
                            }
                            else {
                                n10 = n4;
                                n9 = 0;
                            }
                            this.A += n10 - (int)n10;
                            this.scrollTo((int)n10, this.getScrollY());
                            this.g();
                            n2 = n9;
                            break;
                        }
                        break;
                    }
                    case 1: {
                        final boolean w2 = this.w;
                        n2 = 0;
                        if (w2) {
                            final VelocityTracker d = this.D;
                            d.computeCurrentVelocity(1000, (float)this.F);
                            final int a4 = (int)ca.a(d, this.C);
                            this.t = true;
                            final int n12 = this.getWidth() + this.l;
                            final int scrollX = this.getScrollX();
                            int n13 = scrollX / n12;
                            final float n14 = scrollX % n12 / n12;
                            if (Math.abs((int)(bv.c(motionEvent, bv.a(motionEvent, this.C)) - this.z)) > this.G && Math.abs(a4) > this.E) {
                                if (a4 <= 0) {
                                    ++n13;
                                }
                            }
                            else {
                                n13 = (int)(0.5f + (n14 + n13));
                            }
                            this.a(n13, true, true, a4);
                            this.C = -1;
                            this.i();
                            n2 = ((this.I.b() | this.J.b()) ? 1 : 0);
                            break;
                        }
                        break;
                    }
                    case 3: {
                        final boolean w3 = this.w;
                        n2 = 0;
                        if (w3) {
                            this.a(this.f, true, true);
                            this.C = -1;
                            this.i();
                            n2 = ((this.I.b() | this.J.b()) ? 1 : 0);
                            break;
                        }
                        break;
                    }
                    case 5: {
                        final int b2 = bv.b(motionEvent);
                        this.A = bv.c(motionEvent, b2);
                        this.C = bv.b(motionEvent, b2);
                        n2 = 0;
                        break;
                    }
                    case 6: {
                        this.a(motionEvent);
                        this.A = bv.c(motionEvent, bv.a(motionEvent, this.C));
                        n2 = 0;
                        break;
                    }
                }
                if (n2 != 0) {
                    this.invalidate();
                }
                return true;
            }
        }
        return b;
    }
    
    public void setAdapter(final zt e) {
        if (this.e != null) {
            this.e.e.unregisterObserver((Object)this.k);
            final zt e2 = this.e;
            for (int i = 0; i < this.d.size(); ++i) {
                final zz zz = this.d.get(i);
                this.e.a(this, zz.b, zz.a);
            }
            this.e.a();
            this.d.clear();
            for (int j = 0; j < this.getChildCount(); ++j) {
                if (!((MyViewPager$LayoutParams)this.getChildAt(j).getLayoutParams()).a) {
                    this.removeViewAt(j);
                    --j;
                }
            }
            this.scrollTo(this.f = 0, 0);
        }
        final zt e3 = this.e;
        this.e = e;
        if (this.e != null) {
            if (this.k == null) {
                this.k = new aad(this, (byte)0);
            }
            this.e.e.registerObserver((Object)this.k);
            this.t = false;
            if (this.g >= 0) {
                this.e.a(this.h, this.i);
                this.a(this.g, false, true);
                this.g = -1;
                this.h = null;
                this.i = null;
            }
            else {
                this.f();
            }
        }
        if (this.P != null && e3 != e) {
            final aab p = this.P;
        }
    }
    
    public void setCurrentItem(final int n) {
        this.t = false;
        this.a(n, !this.K, false);
    }
    
    public void setCurrentItem(final int n, final boolean b) {
        this.a(n, b, this.t = false);
    }
    
    public void setOffscreenPageLimit(int n) {
        if (n <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + n + " too small; defaulting to 1");
            n = 1;
        }
        if (n != this.v) {
            this.v = n;
            this.f();
        }
    }
    
    public void setOnPageChangeListener(final aac n) {
        this.N = n;
    }
    
    public void setPageMargin(final int l) {
        final int i = this.l;
        this.l = l;
        final int width = this.getWidth();
        this.a(width, width, l, i);
        this.requestLayout();
    }
    
    public void setPageMarginDrawable(final int n) {
        this.setPageMarginDrawable(this.getContext().getResources().getDrawable(n));
    }
    
    public void setPageMarginDrawable(final Drawable m) {
        this.m = m;
        if (m != null) {
            this.refreshDrawableState();
        }
        this.setWillNotDraw(m == null);
        this.invalidate();
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.m;
    }
}
