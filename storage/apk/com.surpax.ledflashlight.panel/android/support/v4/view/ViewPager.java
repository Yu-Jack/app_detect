// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.os.Build$VERSION;
import android.view.KeyEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import java.util.List;
import java.util.Collections;
import android.content.res.Resources$NotFoundException;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.View;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import android.graphics.Rect;
import java.util.ArrayList;
import android.support.v4.widget.f;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;

public class ViewPager extends ViewGroup
{
    private static final int[] a;
    private static final bh ad;
    private static final Comparator c;
    private static final Interpolator d;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private int I;
    private VelocityTracker J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private f P;
    private f Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private bf V;
    private bf W;
    private be Z;
    private bg aa;
    private int ab;
    private ArrayList ac;
    private final Runnable ae;
    private int af;
    private int b;
    private final ArrayList e;
    private final bc f;
    private final Rect g;
    private w h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private int n;
    private Drawable o;
    private int p;
    private int q;
    private float r;
    private float s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;
    
    static {
        a = new int[] { 16842931 };
        c = new Comparator() {};
        d = (Interpolator)new Interpolator() {
            public final float getInterpolation(final float n) {
                final float n2 = n - 1.0f;
                return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
            }
        };
        ad = new bh();
    }
    
    public ViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.e = new ArrayList();
        this.f = new bc();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.r = -3.4028235E38f;
        this.s = Float.MAX_VALUE;
        this.y = 1;
        this.I = -1;
        this.R = true;
        this.S = false;
        this.ae = new Runnable() {
            @Override
            public final void run() {
                ViewPager.a(ViewPager.this);
                ViewPager.this.c();
            }
        };
        this.af = 0;
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        final Context context2 = this.getContext();
        this.m = new Scroller(context2, ViewPager.d);
        final ViewConfiguration value = ViewConfiguration.get(context2);
        final float density = context2.getResources().getDisplayMetrics().density;
        this.D = ar.a(value);
        this.K = (int)(400.0f * density);
        this.L = value.getScaledMaximumFlingVelocity();
        this.P = new f(context2);
        this.Q = new f(context2);
        this.M = (int)(25.0f * density);
        this.N = (int)(2.0f * density);
        this.B = (int)(16.0f * density);
        ah.a((View)this, new bd(this));
        if (ah.d((View)this) == 0) {
            ah.b((View)this, 1);
        }
    }
    
    private Rect a(final Rect rect, final View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        }
        else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager viewPager;
        for (ViewParent viewParent = view.getParent(); viewParent instanceof ViewGroup && viewParent != this; viewParent = viewPager.getParent()) {
            viewPager = (ViewPager)viewParent;
            rect2.left += viewPager.getLeft();
            rect2.right += viewPager.getRight();
            rect2.top += viewPager.getTop();
            rect2.bottom += viewPager.getBottom();
        }
        return rect2;
    }
    
    private bc a(View view) {
        while (true) {
            final ViewParent parent = view.getParent();
            if (parent == this) {
                return this.g();
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View)parent;
        }
    }
    
    private void a(final int n, final float n2) {
        if (this.U > 0) {
            final int scrollX = this.getScrollX();
            int paddingLeft = this.getPaddingLeft();
            int paddingRight = this.getPaddingRight();
            final int width = this.getWidth();
            int n4 = 0;
            int n5 = 0;
            int n12;
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i, n12 = n5, paddingLeft = n4, paddingRight = n12) {
                final View child = this.getChildAt(i);
                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)child.getLayoutParams();
                if (viewPager$LayoutParams.a) {
                    int max = 0;
                    switch (0x7 & viewPager$LayoutParams.b) {
                        default: {
                            max = paddingLeft;
                            final int n3 = paddingRight;
                            n4 = paddingLeft;
                            n5 = n3;
                            break;
                        }
                        case 3: {
                            final int n6 = paddingLeft + child.getWidth();
                            final int n7 = paddingLeft;
                            n5 = paddingRight;
                            n4 = n6;
                            max = n7;
                            break;
                        }
                        case 1: {
                            max = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            final int n8 = paddingRight;
                            n4 = paddingLeft;
                            n5 = n8;
                            break;
                        }
                        case 5: {
                            max = width - paddingRight - child.getMeasuredWidth();
                            final int n9 = paddingRight + child.getMeasuredWidth();
                            n4 = paddingLeft;
                            n5 = n9;
                            break;
                        }
                    }
                    final int n10 = max + scrollX - child.getLeft();
                    if (n10 != 0) {
                        child.offsetLeftAndRight(n10);
                    }
                }
                else {
                    final int n11 = paddingRight;
                    n4 = paddingLeft;
                    n5 = n11;
                }
            }
        }
        if (this.V != null) {
            this.V.a(n, n2);
        }
        if (this.W != null) {
            this.W.a(n, n2);
        }
        if (this.aa != null) {
            this.getScrollX();
            for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
                final View child2 = this.getChildAt(j);
                if (!((ViewPager$LayoutParams)child2.getLayoutParams()).a) {
                    child2.getLeft();
                    this.e();
                    final bg aa = this.aa;
                }
            }
        }
        this.T = true;
    }
    
    private void a(final int n, final boolean b, final int a, final boolean b2) {
        final bc f = this.f(n);
        int n2 = 0;
        if (f != null) {
            n2 = (int)(this.e() * Math.max(this.r, Math.min(f.e, this.s)));
        }
        if (b) {
            if (this.getChildCount() == 0) {
                this.b(false);
            }
            else {
                final int scrollX = this.getScrollX();
                final int scrollY = this.getScrollY();
                final int n3 = n2 - scrollX;
                final int n4 = 0 - scrollY;
                if (n3 == 0 && n4 == 0) {
                    this.a(false);
                    this.c();
                    this.b(0);
                }
                else {
                    this.b(true);
                    this.b(2);
                    final int e = this.e();
                    final int n5 = e / 2;
                    final float n6 = n5 + n5 * (float)Math.sin((float)(0.4712389167638204 * (Math.min(1.0f, 1.0f * Math.abs(n3) / e) - 0.5f)));
                    final int abs = Math.abs(a);
                    int a2;
                    if (abs > 0) {
                        a2 = 4 * Math.round(1000.0f * Math.abs(n6 / abs));
                    }
                    else {
                        final float n7 = e;
                        final w h = this.h;
                        final int i = this.i;
                        a2 = (int)(100.0f * (1.0f + Math.abs(n3) / (n7 * 1.0f + this.n)));
                    }
                    this.m.startScroll(scrollX, scrollY, n3, n4, Math.min(a2, 600));
                    ah.c((View)this);
                }
            }
            if (b2 && this.V != null) {
                this.V.a();
            }
            if (b2 && this.W != null) {
                this.W.a();
            }
            return;
        }
        if (b2 && this.V != null) {
            this.V.a();
        }
        if (b2 && this.W != null) {
            this.W.a();
        }
        this.a(false);
        this.scrollTo(n2, 0);
        this.g(n2);
    }
    
    private void a(final int n, final boolean b, final boolean b2) {
        this.a(n, b, b2, 0);
    }
    
    private void a(int i, final boolean b, final boolean b2, final int n) {
        if (this.h == null || this.h.a() <= 0) {
            this.b(false);
            return;
        }
        if (!b2 && this.i == i && this.e.size() != 0) {
            this.b(false);
            return;
        }
        if (i < 0) {
            i = 0;
        }
        else if (i >= this.h.a()) {
            i = -1 + this.h.a();
        }
        final int y = this.y;
        if (i > y + this.i || i < this.i - y) {
            for (int j = 0; j < this.e.size(); ++j) {
                ((bc)this.e.get(j)).c = true;
            }
        }
        final int k = this.i;
        boolean b3 = false;
        if (k != i) {
            b3 = true;
        }
        if (this.R) {
            this.i = i;
            if (b3 && this.V != null) {
                this.V.a();
            }
            if (b3 && this.W != null) {
                this.W.a();
            }
            this.requestLayout();
            return;
        }
        this.e(i);
        this.a(i, b, n, b3);
    }
    
    static /* synthetic */ void a(final ViewPager viewPager) {
        viewPager.b(0);
    }
    
    private void a(final bc bc, final int n, final bc bc2) {
        final int a = this.h.a();
        final int e = this.e();
        float n2;
        if (e > 0) {
            n2 = this.n / e;
        }
        else {
            n2 = 0.0f;
        }
        if (bc2 != null) {
            final int b = bc2.b;
            if (b < bc.b) {
                float e2 = n2 + (bc2.e + bc2.d);
                for (int i = b + 1, n3 = 0; i <= bc.b && n3 < this.e.size(); ++i) {
                    bc bc3;
                    for (bc3 = this.e.get(n3); i > bc3.b && n3 < -1 + this.e.size(); ++n3, bc3 = this.e.get(n3)) {}
                    while (i < bc3.b) {
                        final w h = this.h;
                        e2 += 1.0f + n2;
                        ++i;
                    }
                    bc3.e = e2;
                    e2 += n2 + bc3.d;
                }
            }
            else if (b > bc.b) {
                int n4 = -1 + this.e.size();
                float e3 = bc2.e;
                for (int j = b - 1; j >= bc.b && n4 >= 0; --j) {
                    bc bc4;
                    for (bc4 = this.e.get(n4); j < bc4.b && n4 > 0; --n4, bc4 = this.e.get(n4)) {}
                    while (j > bc4.b) {
                        final w h2 = this.h;
                        e3 -= 1.0f + n2;
                        --j;
                    }
                    e3 -= n2 + bc4.d;
                    bc4.e = e3;
                }
            }
        }
        final int size = this.e.size();
        float e4 = bc.e;
        int k = -1 + bc.b;
        float e5;
        if (bc.b == 0) {
            e5 = bc.e;
        }
        else {
            e5 = -3.4028235E38f;
        }
        this.r = e5;
        float s;
        if (bc.b == a - 1) {
            s = bc.e + bc.d - 1.0f;
        }
        else {
            s = Float.MAX_VALUE;
        }
        this.s = s;
        int n5;
        for (int l = n - 1; l >= 0; l = n5) {
            bc bc5;
            for (bc5 = this.e.get(l); k > bc5.b; --k, e4 -= 1.0f + n2) {
                final w h3 = this.h;
            }
            e4 -= n2 + bc5.d;
            bc5.e = e4;
            if (bc5.b == 0) {
                this.r = e4;
            }
            n5 = l - 1;
            --k;
        }
        float e6 = n2 + (bc.e + bc.d);
        int n6 = 1 + bc.b;
        int n7;
        for (int index = n + 1; index < size; index = n7) {
            bc bc6;
            for (bc6 = this.e.get(index); n6 < bc6.b; ++n6, e6 += 1.0f + n2) {
                final w h4 = this.h;
            }
            if (bc6.b == a - 1) {
                this.s = e6 + bc6.d - 1.0f;
            }
            bc6.e = e6;
            e6 += n2 + bc6.d;
            n7 = index + 1;
            ++n6;
        }
        this.S = false;
    }
    
    private void a(final MotionEvent motionEvent) {
        final int b = android.support.v4.view.s.b(motionEvent);
        if (android.support.v4.view.s.b(motionEvent, b) == this.I) {
            int n;
            if (b == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.E = android.support.v4.view.s.c(motionEvent, n);
            this.I = android.support.v4.view.s.b(motionEvent, n);
            if (this.J != null) {
                this.J.clear();
            }
        }
    }
    
    private void a(final boolean b) {
        boolean b2;
        if (this.af == 2) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (b2) {
            this.b(false);
            this.m.abortAnimation();
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.m.getCurrX();
            final int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
            }
        }
        this.x = false;
        int i = 0;
        int n = b2 ? 1 : 0;
        while (i < this.e.size()) {
            final bc bc = this.e.get(i);
            if (bc.c) {
                bc.c = false;
                n = 1;
            }
            ++i;
        }
        if (n != 0) {
            if (!b) {
                this.ae.run();
                return;
            }
            ah.a((View)this, this.ae);
        }
    }
    
    private boolean a(final float e) {
        boolean b = true;
        final float n = this.E - e;
        this.E = e;
        final float n2 = n + this.getScrollX();
        final int e2 = this.e();
        float n3 = e2 * this.r;
        final float n4 = e2 * this.s;
        final bc bc = this.e.get(0);
        final bc bc2 = this.e.get(-1 + this.e.size());
        boolean b2;
        if (bc.b != 0) {
            n3 = bc.e * e2;
            b2 = false;
        }
        else {
            b2 = b;
        }
        float n5;
        if (bc2.b != -1 + this.h.a()) {
            n5 = bc2.e * e2;
            b = false;
        }
        else {
            n5 = n4;
        }
        boolean b3;
        if (n2 < n3) {
            b3 = false;
            if (b2) {
                b3 = this.P.a(Math.abs(n3 - n2) / e2);
            }
        }
        else if (n2 > n5) {
            b3 = false;
            if (b) {
                b3 = this.Q.a(Math.abs(n2 - n5) / e2);
            }
            n3 = n5;
        }
        else {
            n3 = n2;
            b3 = false;
        }
        this.E += n3 - (int)n3;
        this.scrollTo((int)n3, this.getScrollY());
        this.g((int)n3);
        return b3;
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
        Label_0141: {
            break Label_0141;
        }
        if (!b || !ah.a(view, -n)) {
            return false;
        }
        return true;
    }
    
    private void b(final int af) {
        if (this.af != af) {
            this.af = af;
            if (this.aa != null) {
                int n;
                if (af != 0) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    int n2;
                    if (n != 0) {
                        n2 = 2;
                    }
                    else {
                        n2 = 0;
                    }
                    ah.a(this.getChildAt(i), n2, null);
                }
            }
            if (this.V != null) {
                this.V.a(af);
            }
        }
    }
    
    private void b(final boolean w) {
        if (this.w != w) {
            this.w = w;
        }
    }
    
    private void c(final int n) {
        this.a(n, true, this.x = false);
    }
    
    private bc d(final int b) {
        new bc().b = b;
        final w h = this.h;
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }
    
    private int e() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }
    
    private void e(final int i) {
        bc bc;
        int n2;
        if (this.i != i) {
            int n;
            if (this.i < i) {
                n = 66;
            }
            else {
                n = 17;
            }
            final bc f = this.f(this.i);
            this.i = i;
            bc = f;
            n2 = n;
        }
        else {
            n2 = 2;
            bc = null;
        }
        if (this.h == null) {
            this.f();
        }
        else {
            if (this.x) {
                this.f();
                return;
            }
            if (this.getWindowToken() != null) {
                final w h = this.h;
                final int y = this.y;
                final int max = Math.max(0, this.i - y);
                final int a = this.h.a();
                final int min = Math.min(a - 1, y + this.i);
                if (a != this.b) {
                    try {
                        final String s = this.getResources().getResourceName(this.getId());
                        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + a + " Pager id: " + s + " Pager class: " + this.getClass() + " Problematic adapter: " + this.h.getClass());
                    }
                    catch (Resources$NotFoundException ex) {
                        final String s = Integer.toHexString(this.getId());
                        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + a + " Pager id: " + s + " Pager class: " + this.getClass() + " Problematic adapter: " + this.h.getClass());
                    }
                }
                int j = 0;
                while (true) {
                    while (j < this.e.size()) {
                        final bc bc2 = this.e.get(j);
                        if (bc2.b >= this.i) {
                            if (bc2.b != this.i) {
                                break;
                            }
                            bc d;
                            if (bc2 == null && a > 0) {
                                d = this.d(this.i);
                            }
                            else {
                                d = bc2;
                            }
                            if (d != null) {
                                final int index = j - 1;
                                bc bc3;
                                if (index >= 0) {
                                    bc3 = this.e.get(index);
                                }
                                else {
                                    bc3 = null;
                                }
                                final int e = this.e();
                                float n3;
                                if (e <= 0) {
                                    n3 = 0.0f;
                                }
                                else {
                                    n3 = 2.0f - d.d + this.getPaddingLeft() / e;
                                }
                                final int n4 = -1 + this.i;
                                float n5 = 0.0f;
                                int k = n4;
                                int n6 = j;
                                int n7 = index;
                                while (k >= 0) {
                                    if (n5 >= n3 && k < max) {
                                        if (bc3 == null) {
                                            break;
                                        }
                                        if (k == bc3.b && !bc3.c) {
                                            this.e.remove(n7);
                                            final w h2 = this.h;
                                            final Object a2 = bc3.a;
                                            android.support.v4.view.w.b();
                                            --n7;
                                            --n6;
                                            if (n7 >= 0) {
                                                bc3 = (bc)this.e.get(n7);
                                            }
                                            else {
                                                bc3 = null;
                                            }
                                        }
                                    }
                                    else if (bc3 != null && k == bc3.b) {
                                        n5 += bc3.d;
                                        if (--n7 >= 0) {
                                            bc3 = (bc)this.e.get(n7);
                                        }
                                        else {
                                            bc3 = null;
                                        }
                                    }
                                    else {
                                        n5 += this.d(k).d;
                                        ++n6;
                                        if (n7 >= 0) {
                                            bc3 = (bc)this.e.get(n7);
                                        }
                                        else {
                                            bc3 = null;
                                        }
                                    }
                                    --k;
                                }
                                float d2 = d.d;
                                final int index2 = n6 + 1;
                                if (d2 < 2.0f) {
                                    bc bc4;
                                    if (index2 < this.e.size()) {
                                        bc4 = this.e.get(index2);
                                    }
                                    else {
                                        bc4 = null;
                                    }
                                    float n8;
                                    if (e <= 0) {
                                        n8 = 0.0f;
                                    }
                                    else {
                                        n8 = 2.0f + this.getPaddingRight() / e;
                                    }
                                    final int n9 = 1 + this.i;
                                    final bc bc5 = bc4;
                                    int n10 = index2;
                                    int l = n9;
                                    bc bc6 = bc5;
                                    while (l < a) {
                                        bc bc8;
                                        float n12;
                                        if (d2 >= n8 && l > min) {
                                            if (bc6 == null) {
                                                break;
                                            }
                                            if (l == bc6.b && !bc6.c) {
                                                this.e.remove(n10);
                                                final w h3 = this.h;
                                                final Object a3 = bc6.a;
                                                android.support.v4.view.w.b();
                                                bc bc7;
                                                if (n10 < this.e.size()) {
                                                    bc7 = this.e.get(n10);
                                                }
                                                else {
                                                    bc7 = null;
                                                }
                                                final float n11 = d2;
                                                bc8 = bc7;
                                                n12 = n11;
                                            }
                                            else {
                                                final float n13 = d2;
                                                bc8 = bc6;
                                                n12 = n13;
                                            }
                                        }
                                        else if (bc6 != null && l == bc6.b) {
                                            final float n14 = d2 + bc6.d;
                                            bc bc9;
                                            if (++n10 < this.e.size()) {
                                                bc9 = this.e.get(n10);
                                            }
                                            else {
                                                bc9 = null;
                                            }
                                            bc8 = bc9;
                                            n12 = n14;
                                        }
                                        else {
                                            final bc d3 = this.d(l);
                                            ++n10;
                                            final float n15 = d2 + d3.d;
                                            bc bc10;
                                            if (n10 < this.e.size()) {
                                                bc10 = this.e.get(n10);
                                            }
                                            else {
                                                bc10 = null;
                                            }
                                            bc8 = bc10;
                                            n12 = n15;
                                        }
                                        ++l;
                                        final float n16 = n12;
                                        bc6 = bc8;
                                        d2 = n16;
                                    }
                                }
                                this.a(d, n6, bc);
                            }
                            final w h4 = this.h;
                            final int m = this.i;
                            if (d != null) {
                                final Object a4 = d.a;
                            }
                            final w h5 = this.h;
                            for (int childCount = this.getChildCount(), f2 = 0; f2 < childCount; ++f2) {
                                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)this.getChildAt(f2).getLayoutParams();
                                viewPager$LayoutParams.f = f2;
                                if (!viewPager$LayoutParams.a && viewPager$LayoutParams.c == 0.0f) {
                                    final bc g = this.g();
                                    if (g != null) {
                                        viewPager$LayoutParams.c = g.d;
                                        viewPager$LayoutParams.e = g.b;
                                    }
                                }
                            }
                            this.f();
                            if (!this.hasFocus()) {
                                return;
                            }
                            final View focus = this.findFocus();
                            bc a5;
                            if (focus != null) {
                                a5 = this.a(focus);
                            }
                            else {
                                a5 = null;
                            }
                            if (a5 == null || a5.b != this.i) {
                                for (int n17 = 0; n17 < this.getChildCount(); ++n17) {
                                    final View child = this.getChildAt(n17);
                                    final bc g2 = this.g();
                                    if (g2 != null && g2.b == this.i && child.requestFocus(n2)) {
                                        break;
                                    }
                                }
                            }
                            return;
                        }
                        else {
                            ++j;
                        }
                    }
                    final bc bc2 = null;
                    continue;
                }
            }
        }
    }
    
    private bc f(final int n) {
        for (int i = 0; i < this.e.size(); ++i) {
            final bc bc = this.e.get(i);
            if (bc.b == n) {
                return bc;
            }
        }
        return null;
    }
    
    private void f() {
        if (this.ab != 0) {
            if (this.ac == null) {
                this.ac = new ArrayList();
            }
            else {
                this.ac.clear();
            }
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                this.ac.add(this.getChildAt(i));
            }
            Collections.sort((List<Object>)this.ac, ViewPager.ad);
        }
    }
    
    private bc g() {
        for (int i = 0; i < this.e.size(); ++i) {
            final bc bc = this.e.get(i);
            final w h = this.h;
            final Object a = bc.a;
            if (h.c()) {
                return bc;
            }
        }
        return null;
    }
    
    private boolean g(final int n) {
        boolean b;
        if (this.e.size() == 0) {
            this.T = false;
            this.a(0, 0.0f);
            final boolean t = this.T;
            b = false;
            if (!t) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        }
        else {
            final bc i = this.i();
            final int e = this.e();
            final int n2 = this.n;
            final float n3 = this.n / e;
            final int b2 = i.b;
            final float n4 = (n / e - i.e) / (n3 + i.d);
            this.T = false;
            this.a(b2, n4);
            if (!this.T) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            b = true;
        }
        return b;
    }
    
    private void h() {
        final ViewParent parent = this.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
    
    private boolean h(final int n) {
        final View focus = this.findFocus();
        View view = null;
        Label_0012: {
            if (focus == this) {
                view = null;
            }
            else {
                Label_0399: {
                    if (focus != null) {
                        ViewParent viewParent = focus.getParent();
                        while (true) {
                            while (viewParent instanceof ViewGroup) {
                                if (viewParent == this) {
                                    final int n2 = 1;
                                    if (n2 == 0) {
                                        final StringBuilder sb = new StringBuilder();
                                        sb.append(focus.getClass().getSimpleName());
                                        for (ViewParent viewParent2 = focus.getParent(); viewParent2 instanceof ViewGroup; viewParent2 = viewParent2.getParent()) {
                                            sb.append(" => ").append(viewParent2.getClass().getSimpleName());
                                        }
                                        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                                        view = null;
                                        break Label_0012;
                                    }
                                    break Label_0399;
                                }
                                else {
                                    viewParent = viewParent.getParent();
                                }
                            }
                            final int n2 = 0;
                            continue;
                        }
                    }
                }
                view = focus;
            }
        }
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view, n);
        while (true) {
            Label_0354: {
                boolean b2 = false;
                Label_0090: {
                    boolean b;
                    if (nextFocus != null && nextFocus != view) {
                        if (n == 17) {
                            final int left = this.a(this.g, nextFocus).left;
                            final int left2 = this.a(this.g, view).left;
                            if (view != null && left >= left2) {
                                b = this.k();
                            }
                            else {
                                b = nextFocus.requestFocus();
                            }
                        }
                        else {
                            b2 = false;
                            if (n != 66) {
                                break Label_0090;
                            }
                            final int left3 = this.a(this.g, nextFocus).left;
                            final int left4 = this.a(this.g, view).left;
                            if (view != null && left3 <= left4) {
                                break Label_0354;
                            }
                            b = nextFocus.requestFocus();
                        }
                    }
                    else if (n == 17 || n == 1) {
                        b = this.k();
                    }
                    else {
                        if (n == 66) {
                            break Label_0354;
                        }
                        b2 = false;
                        if (n == 2) {
                            break Label_0354;
                        }
                        break Label_0090;
                    }
                    b2 = b;
                }
                if (b2) {
                    this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(n));
                }
                return b2;
            }
            if (this.h != null && this.i < -1 + this.h.a()) {
                this.c(1 + this.i);
                final boolean b = true;
                continue;
            }
            boolean b = false;
            continue;
        }
    }
    
    private bc i() {
        final int e = this.e();
        float n;
        if (e > 0) {
            n = this.getScrollX() / e;
        }
        else {
            n = 0.0f;
        }
        float n2;
        if (e > 0) {
            n2 = this.n / e;
        }
        else {
            n2 = 0.0f;
        }
        float n3 = 0.0f;
        float n4 = 0.0f;
        int n5 = -1;
        int i = 0;
        int n6 = 1;
        bc bc = null;
        while (i < this.e.size()) {
            final bc bc2 = this.e.get(i);
            int n7;
            bc bc3;
            if (n6 == 0 && bc2.b != n5 + 1) {
                final bc f = this.f;
                f.e = n2 + (n3 + n4);
                f.b = n5 + 1;
                final w h = this.h;
                final int b = f.b;
                f.d = 1.0f;
                n7 = i - 1;
                bc3 = f;
            }
            else {
                n7 = i;
                bc3 = bc2;
            }
            final float e2 = bc3.e;
            final float n8 = n2 + (e2 + bc3.d);
            if (n6 == 0 && n < e2) {
                break;
            }
            if (n < n8 || n7 == -1 + this.e.size()) {
                bc = bc3;
                break;
            }
            final int b2 = bc3.b;
            final float d = bc3.d;
            final int n9 = n7 + 1;
            n4 = e2;
            n5 = b2;
            n3 = d;
            bc = bc3;
            i = n9;
            n6 = 0;
        }
        return bc;
    }
    
    private void j() {
        this.z = false;
        this.A = false;
        if (this.J != null) {
            this.J.recycle();
            this.J = null;
        }
    }
    
    private boolean k() {
        if (this.i > 0) {
            this.c(-1 + this.i);
            return true;
        }
        return false;
    }
    
    final bf a(final bf w) {
        final bf w2 = this.W;
        this.W = w;
        return w2;
    }
    
    public final w a() {
        return this.h;
    }
    
    public final void a(final int n) {
        this.x = false;
        this.a(n, !this.R, false);
    }
    
    final void a(final be z) {
        this.Z = z;
    }
    
    public void addFocusables(final ArrayList list, final int n, final int n2) {
        final int size = list.size();
        final int descendantFocusability = this.getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 0) {
                    final bc g = this.g();
                    if (g != null && g.b == this.i) {
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
                final bc g = this.g();
                if (g != null && g.b == this.i) {
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
        final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)generateLayoutParams;
        viewPager$LayoutParams.a |= (view instanceof bb);
        if (!this.v) {
            super.addView(view, n, generateLayoutParams);
            return;
        }
        if (viewPager$LayoutParams != null && viewPager$LayoutParams.a) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        viewPager$LayoutParams.d = true;
        this.addViewInLayout(view, n, generateLayoutParams);
    }
    
    public final int b() {
        return this.i;
    }
    
    final void c() {
        this.e(this.i);
    }
    
    public boolean canScrollHorizontally(final int n) {
        if (this.h != null) {
            final int e = this.e();
            final int scrollX = this.getScrollX();
            if (n < 0) {
                if (scrollX > (int)(e * this.r)) {
                    return true;
                }
            }
            else if (n > 0 && scrollX < (int)(e * this.s)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof ViewPager$LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.m.getCurrX();
            final int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
                if (!this.g(currX)) {
                    this.m.abortAnimation();
                    this.scrollTo(0, currY);
                }
            }
            ah.c((View)this);
            return;
        }
        this.a(true);
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            boolean b = false;
            Label_0054: {
                if (keyEvent.getAction() == 0) {
                    switch (keyEvent.getKeyCode()) {
                        case 21: {
                            b = this.h(17);
                            break Label_0054;
                        }
                        case 22: {
                            b = this.h(66);
                            break Label_0054;
                        }
                        case 61: {
                            if (Build$VERSION.SDK_INT < 11) {
                                break;
                            }
                            if (android.support.v4.view.n.b(keyEvent)) {
                                b = this.h(2);
                                break Label_0054;
                            }
                            if (android.support.v4.view.n.a(keyEvent)) {
                                b = this.h(1);
                                break Label_0054;
                            }
                            break;
                        }
                    }
                }
                b = false;
            }
            final boolean b2 = false;
            if (!b) {
                return b2;
            }
        }
        return true;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 4096) {
            final int childCount = this.getChildCount();
            int n = 0;
            while (true) {
                final boolean dispatchPopulateAccessibilityEvent = false;
                if (n >= childCount) {
                    return dispatchPopulateAccessibilityEvent;
                }
                final View child = this.getChildAt(n);
                if (child.getVisibility() == 0) {
                    final bc g = this.g();
                    if (g != null && g.b == this.i && child.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                        break;
                    }
                }
                ++n;
            }
            return true;
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        final int b = ah.b((View)this);
        boolean b2;
        if (b == 0 || (b == 1 && this.h != null && this.h.a() > 1)) {
            final boolean a = this.P.a();
            b2 = false;
            if (!a) {
                final int save = canvas.save();
                final int n = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                final int width = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n + this.getPaddingTop()), this.r * width);
                this.P.a(n, width);
                b2 = (false | this.P.a(canvas));
                canvas.restoreToCount(save);
            }
            if (!this.Q.a()) {
                final int save2 = canvas.save();
                final int width2 = this.getWidth();
                final int n2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(1.0f + this.s) * width2);
                this.Q.a(n2, width2);
                b2 |= this.Q.a(canvas);
                canvas.restoreToCount(save2);
            }
        }
        else {
            this.P.b();
            this.Q.b();
            b2 = false;
        }
        if (b2) {
            ah.c((View)this);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable o = this.o;
        if (o != null && o.isStateful()) {
            o.setState(this.getDrawableState());
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new ViewPager$LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new ViewPager$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.generateDefaultLayoutParams();
    }
    
    protected int getChildDrawingOrder(final int n, int index) {
        if (this.ab == 2) {
            index = n - 1 - index;
        }
        return ((ViewPager$LayoutParams)this.ac.get(index).getLayoutParams()).f;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.R = true;
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.ae);
        super.onDetachedFromWindow();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.n > 0 && this.o != null && this.e.size() > 0 && this.h != null) {
            final int scrollX = this.getScrollX();
            final int width = this.getWidth();
            final float n = this.n / width;
            bc bc = this.e.get(0);
            float e = bc.e;
            final int size = this.e.size();
            final int b = bc.b;
            final int b2 = this.e.get(size - 1).b;
            int index = 0;
            for (int i = b; i < b2; ++i) {
                while (i > bc.b && index < size) {
                    final ArrayList e2 = this.e;
                    ++index;
                    bc = e2.get(index);
                }
                float n2;
                if (i == bc.b) {
                    n2 = (bc.e + bc.d) * width;
                    e = n + (bc.e + bc.d);
                }
                else {
                    final w h = this.h;
                    n2 = (1.0f + e) * width;
                    e += 1.0f + n;
                }
                if (n2 + this.n > scrollX) {
                    this.o.setBounds((int)n2, this.p, (int)(0.5f + (n2 + this.n)), this.q);
                    this.o.draw(canvas);
                }
                if (n2 > scrollX + width) {
                    break;
                }
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int n = 0xFF & motionEvent.getAction();
        if (n != 3 && n != 1) {
            if (n != 0) {
                if (this.z) {
                    return true;
                }
                if (this.A) {
                    return false;
                }
            }
            switch (n) {
                case 2: {
                    final int i = this.I;
                    if (i == -1) {
                        break;
                    }
                    final int a = android.support.v4.view.s.a(motionEvent, i);
                    final float c = android.support.v4.view.s.c(motionEvent, a);
                    final float a2 = c - this.E;
                    final float abs = Math.abs(a2);
                    final float d = android.support.v4.view.s.d(motionEvent, a);
                    final float abs2 = Math.abs(d - this.H);
                    if (a2 != 0.0f) {
                        final float e = this.E;
                        boolean b;
                        if ((e < this.C && a2 > 0.0f) || (e > this.getWidth() - this.C && a2 < 0.0f)) {
                            b = true;
                        }
                        else {
                            b = false;
                        }
                        if (!b && this.a((View)this, false, (int)a2, (int)c, (int)d)) {
                            this.E = c;
                            this.F = d;
                            this.A = true;
                            return false;
                        }
                    }
                    if (abs > this.D && 0.5f * abs > abs2) {
                        this.z = true;
                        this.h();
                        this.b(1);
                        float e2;
                        if (a2 > 0.0f) {
                            e2 = this.G + this.D;
                        }
                        else {
                            e2 = this.G - this.D;
                        }
                        this.E = e2;
                        this.F = d;
                        this.b(true);
                    }
                    else if (abs2 > this.D) {
                        this.A = true;
                    }
                    if (this.z && this.a(c)) {
                        ah.c((View)this);
                        break;
                    }
                    break;
                }
                case 0: {
                    final float x = motionEvent.getX();
                    this.G = x;
                    this.E = x;
                    final float y = motionEvent.getY();
                    this.H = y;
                    this.F = y;
                    this.I = android.support.v4.view.s.b(motionEvent, 0);
                    this.A = false;
                    this.m.computeScrollOffset();
                    if (this.af == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.N) {
                        this.m.abortAnimation();
                        this.x = false;
                        this.c();
                        this.z = true;
                        this.h();
                        this.b(1);
                        break;
                    }
                    this.a(false);
                    this.z = false;
                    break;
                }
                case 6: {
                    this.a(motionEvent);
                    break;
                }
            }
            if (this.J == null) {
                this.J = VelocityTracker.obtain();
            }
            this.J.addMovement(motionEvent);
            return this.z;
        }
        this.z = false;
        this.A = false;
        this.I = -1;
        if (this.J != null) {
            this.J.recycle();
            this.J = null;
        }
        return false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int childCount = this.getChildCount();
        final int n5 = n3 - n;
        final int n6 = n4 - n2;
        int paddingLeft = this.getPaddingLeft();
        int paddingTop = this.getPaddingTop();
        int paddingRight = this.getPaddingRight();
        int paddingBottom = this.getPaddingBottom();
        final int scrollX = this.getScrollX();
        int u = 0;
        int i = 0;
    Label_0262_Outer:
        while (i < childCount) {
            final View child = this.getChildAt(i);
            while (true) {
                Label_0657: {
                    if (child.getVisibility() == 8) {
                        break Label_0657;
                    }
                    final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)child.getLayoutParams();
                    if (!viewPager$LayoutParams.a) {
                        break Label_0657;
                    }
                    final int n7 = 0x7 & viewPager$LayoutParams.b;
                    final int n8 = 0x70 & viewPager$LayoutParams.b;
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
                    child.layout(n18, max2, n18 + child.getMeasuredWidth(), max2 + child.getMeasuredHeight());
                    final int n19 = u + 1;
                    final int n20 = n12;
                    paddingBottom = n13;
                    final int n21 = paddingRight;
                    final int n22 = paddingLeft;
                    ++i;
                    paddingLeft = n22;
                    paddingRight = n21;
                    paddingTop = n20;
                    u = n19;
                    continue Label_0262_Outer;
                }
                final int n19 = u;
                final int n20 = paddingTop;
                final int n21 = paddingRight;
                final int n22 = paddingLeft;
                continue;
            }
        }
        final int n23 = n5 - paddingLeft - paddingRight;
        for (int j = 0; j < childCount; ++j) {
            final View child2 = this.getChildAt(j);
            if (child2.getVisibility() != 8) {
                final ViewPager$LayoutParams viewPager$LayoutParams2 = (ViewPager$LayoutParams)child2.getLayoutParams();
                if (!viewPager$LayoutParams2.a) {
                    final bc g = this.g();
                    if (g != null) {
                        final int n24 = paddingLeft + (int)(n23 * g.e);
                        if (viewPager$LayoutParams2.d) {
                            viewPager$LayoutParams2.d = false;
                            child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n23 * viewPager$LayoutParams2.c), 1073741824), View$MeasureSpec.makeMeasureSpec(n6 - paddingTop - paddingBottom, 1073741824));
                        }
                        child2.layout(n24, paddingTop, n24 + child2.getMeasuredWidth(), paddingTop + child2.getMeasuredHeight());
                    }
                }
            }
        }
        this.p = paddingTop;
        this.q = n6 - paddingBottom;
        this.U = u;
        if (this.R) {
            this.a(this.i, false, 0, false);
        }
        this.R = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(getDefaultSize(0, n), getDefaultSize(0, n2));
        final int measuredWidth = this.getMeasuredWidth();
        this.C = Math.min(measuredWidth / 10, this.B);
        int n3 = measuredWidth - this.getPaddingLeft() - this.getPaddingRight();
        int n4 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
    Label_0288:
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)child.getLayoutParams();
                if (viewPager$LayoutParams != null && viewPager$LayoutParams.a) {
                    final int n5 = 0x7 & viewPager$LayoutParams.b;
                    final int n6 = 0x70 & viewPager$LayoutParams.b;
                    int n7 = Integer.MIN_VALUE;
                    int n8 = Integer.MIN_VALUE;
                    boolean b;
                    if (n6 == 48 || n6 == 80) {
                        b = true;
                    }
                    else {
                        b = false;
                    }
                    final boolean b2 = n5 == 3 || n5 == 5;
                    if (b) {
                        n7 = 1073741824;
                    }
                    else if (b2) {
                        n8 = 1073741824;
                    }
                    int n9;
                    int width;
                    if (viewPager$LayoutParams.width != -2) {
                        n9 = 1073741824;
                        if (viewPager$LayoutParams.width != -1) {
                            width = viewPager$LayoutParams.width;
                        }
                        else {
                            width = n3;
                        }
                    }
                    else {
                        n9 = n7;
                        width = n3;
                    }
                    while (true) {
                        Label_0464: {
                            if (viewPager$LayoutParams.height == -2) {
                                break Label_0464;
                            }
                            n8 = 1073741824;
                            if (viewPager$LayoutParams.height == -1) {
                                break Label_0464;
                            }
                            final int height = viewPager$LayoutParams.height;
                            child.measure(View$MeasureSpec.makeMeasureSpec(width, n9), View$MeasureSpec.makeMeasureSpec(height, n8));
                            if (b) {
                                n4 -= child.getMeasuredHeight();
                                continue Label_0288;
                            }
                            if (b2) {
                                n3 -= child.getMeasuredWidth();
                            }
                            continue Label_0288;
                        }
                        final int height = n4;
                        continue;
                    }
                }
            }
        }
        this.t = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
        this.u = View$MeasureSpec.makeMeasureSpec(n4, 1073741824);
        this.v = true;
        this.c();
        this.v = false;
        for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
            final View child2 = this.getChildAt(j);
            if (child2.getVisibility() != 8) {
                final ViewPager$LayoutParams viewPager$LayoutParams2 = (ViewPager$LayoutParams)child2.getLayoutParams();
                if (viewPager$LayoutParams2 == null || !viewPager$LayoutParams2.a) {
                    child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n3 * viewPager$LayoutParams2.c), 1073741824), this.u);
                }
            }
        }
    }
    
    protected boolean onRequestFocusInDescendants(final int n, final Rect rect) {
        int n2 = -1;
        int childCount = this.getChildCount();
        int i;
        if ((n & 0x2) != 0x0) {
            n2 = 1;
            i = 0;
        }
        else {
            i = childCount - 1;
            childCount = n2;
        }
        while (i != childCount) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final bc g = this.g();
                if (g != null && g.b == this.i && child.requestFocus(n, rect)) {
                    return true;
                }
            }
            i += n2;
        }
        return false;
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof ViewPager$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final ViewPager$SavedState viewPager$SavedState = (ViewPager$SavedState)parcelable;
        super.onRestoreInstanceState(viewPager$SavedState.getSuperState());
        if (this.h != null) {
            final w h = this.h;
            final Parcelable b = viewPager$SavedState.b;
            final ClassLoader c = viewPager$SavedState.c;
            this.a(viewPager$SavedState.a, false, true);
            return;
        }
        this.j = viewPager$SavedState.a;
        this.k = viewPager$SavedState.b;
        this.l = viewPager$SavedState.c;
    }
    
    public Parcelable onSaveInstanceState() {
        final ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(super.onSaveInstanceState());
        viewPager$SavedState.a = this.i;
        if (this.h != null) {
            final w h = this.h;
            viewPager$SavedState.b = null;
        }
        return (Parcelable)viewPager$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            final int n5 = this.n;
            final int n6 = this.n;
            if (n3 > 0 && !this.e.isEmpty()) {
                final int n7 = this.getScrollX() / (n6 + (n3 - this.getPaddingLeft() - this.getPaddingRight())) * (n5 + (n - this.getPaddingLeft() - this.getPaddingRight()));
                this.scrollTo(n7, this.getScrollY());
                if (!this.m.isFinished()) {
                    this.m.startScroll(n7, 0, (int)(this.f(this.i).e * n), 0, this.m.getDuration() - this.m.timePassed());
                }
            }
            else {
                final bc f = this.f(this.i);
                float min;
                if (f != null) {
                    min = Math.min(f.e, this.s);
                }
                else {
                    min = 0.0f;
                }
                final int n8 = (int)(min * (n - this.getPaddingLeft() - this.getPaddingRight()));
                if (n8 != this.getScrollX()) {
                    this.a(false);
                    this.scrollTo(n8, this.getScrollY());
                }
            }
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.O) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.h == null || this.h.a() == 0) {
            return false;
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        final int n = 0xFF & motionEvent.getAction();
        int n2 = 0;
        switch (n) {
            case 0: {
                this.m.abortAnimation();
                this.x = false;
                this.c();
                final float x = motionEvent.getX();
                this.G = x;
                this.E = x;
                final float y = motionEvent.getY();
                this.H = y;
                this.F = y;
                this.I = android.support.v4.view.s.b(motionEvent, 0);
                n2 = 0;
                break;
            }
            case 2: {
                if (!this.z) {
                    final int a = android.support.v4.view.s.a(motionEvent, this.I);
                    final float c = android.support.v4.view.s.c(motionEvent, a);
                    final float abs = Math.abs(c - this.E);
                    final float d = android.support.v4.view.s.d(motionEvent, a);
                    final float abs2 = Math.abs(d - this.F);
                    if (abs > this.D && abs > abs2) {
                        this.z = true;
                        this.h();
                        float e;
                        if (c - this.G > 0.0f) {
                            e = this.G + this.D;
                        }
                        else {
                            e = this.G - this.D;
                        }
                        this.E = e;
                        this.F = d;
                        this.b(1);
                        this.b(true);
                        final ViewParent parent = this.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                final boolean z = this.z;
                n2 = 0;
                if (z) {
                    n2 = ((false | this.a(android.support.v4.view.s.c(motionEvent, android.support.v4.view.s.a(motionEvent, this.I)))) ? 1 : 0);
                    break;
                }
                break;
            }
            case 1: {
                final boolean z2 = this.z;
                n2 = 0;
                if (z2) {
                    final VelocityTracker j = this.J;
                    j.computeCurrentVelocity(1000, (float)this.L);
                    final int a2 = (int)android.support.v4.view.ad.a(j, this.I);
                    this.x = true;
                    final int e2 = this.e();
                    final int scrollX = this.getScrollX();
                    final bc i = this.i();
                    int b = i.b;
                    final float n3 = (scrollX / e2 - i.e) / i.d;
                    int max;
                    if (Math.abs((int)(android.support.v4.view.s.c(motionEvent, android.support.v4.view.s.a(motionEvent, this.I)) - this.G)) > this.M && Math.abs(a2) > this.K) {
                        if (a2 <= 0) {
                            ++b;
                        }
                        max = b;
                    }
                    else {
                        float n4;
                        if (b >= this.i) {
                            n4 = 0.4f;
                        }
                        else {
                            n4 = 0.6f;
                        }
                        max = (int)(n4 + (n3 + b));
                    }
                    if (this.e.size() > 0) {
                        max = Math.max(this.e.get(0).b, Math.min(max, this.e.get(-1 + this.e.size()).b));
                    }
                    this.a(max, true, true, a2);
                    this.I = -1;
                    this.j();
                    n2 = ((this.P.c() | this.Q.c()) ? 1 : 0);
                    break;
                }
                break;
            }
            case 3: {
                final boolean z3 = this.z;
                n2 = 0;
                if (z3) {
                    this.a(this.i, true, 0, false);
                    this.I = -1;
                    this.j();
                    n2 = ((this.P.c() | this.Q.c()) ? 1 : 0);
                    break;
                }
                break;
            }
            case 5: {
                final int b2 = android.support.v4.view.s.b(motionEvent);
                this.E = android.support.v4.view.s.c(motionEvent, b2);
                this.I = android.support.v4.view.s.b(motionEvent, b2);
                n2 = 0;
                break;
            }
            case 6: {
                this.a(motionEvent);
                this.E = android.support.v4.view.s.c(motionEvent, android.support.v4.view.s.a(motionEvent, this.I));
                n2 = 0;
                break;
            }
        }
        if (n2 != 0) {
            ah.c((View)this);
        }
        return true;
    }
    
    public void removeView(final View view) {
        if (this.v) {
            this.removeViewInLayout(view);
            return;
        }
        super.removeView(view);
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }
}
