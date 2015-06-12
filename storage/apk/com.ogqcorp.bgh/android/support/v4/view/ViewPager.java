// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.database.DataSetObserver;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.os.Build$VERSION;
import android.view.KeyEvent;
import android.content.res.Resources$NotFoundException;
import android.view.ViewConfiguration;
import java.util.List;
import java.util.Collections;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.lang.reflect.Method;
import android.support.v4.widget.i;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;

public class ViewPager extends ViewGroup
{
    private static final int[] a;
    private static final bo af;
    private static final Comparator<bh> c;
    private static final Interpolator d;
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int J;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private i Q;
    private i R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private bl W;
    private bl Z;
    private bk aa;
    private bm ab;
    private Method ac;
    private int ad;
    private ArrayList<View> ae;
    private final Runnable ag;
    private int ah;
    private int b;
    private final ArrayList<bh> e;
    private final bh f;
    private final Rect g;
    private af h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private bn n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s;
    private float t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;
    
    static {
        a = new int[] { 16842931 };
        c = new Comparator<bh>() {
            public int a(final bh bh, final bh bh2) {
                return bh.b - bh2.b;
            }
        };
        d = (Interpolator)new Interpolator() {
            public float getInterpolation(final float n) {
                final float n2 = n - 1.0f;
                return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
            }
        };
        af = new bo();
    }
    
    public ViewPager(final Context context) {
        super(context);
        this.e = new ArrayList<bh>();
        this.f = new bh();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.z = 1;
        this.J = -1;
        this.S = true;
        this.T = false;
        this.ag = new Runnable() {
            @Override
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.c();
            }
        };
        this.ah = 0;
        this.a();
    }
    
    public ViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.e = new ArrayList<bh>();
        this.f = new bh();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.z = 1;
        this.J = -1;
        this.S = true;
        this.T = false;
        this.ag = new Runnable() {
            @Override
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.c();
            }
        };
        this.ah = 0;
        this.a();
    }
    
    private int a(int max, final float n, final int a, final int a2) {
        if (Math.abs(a2) > this.N && Math.abs(a) > this.L) {
            if (a <= 0) {
                ++max;
            }
        }
        else {
            float n2;
            if (max >= this.i) {
                n2 = 0.4f;
            }
            else {
                n2 = 0.6f;
            }
            max = (int)(n2 + (n + max));
        }
        if (this.e.size() > 0) {
            max = Math.max(this.e.get(0).b, Math.min(max, this.e.get(-1 + this.e.size()).b));
        }
        return max;
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
    
    private void a(final int n, final int n2, final int n3, final int n4) {
        if (n2 > 0 && !this.e.isEmpty()) {
            final int n5 = this.getScrollX() / (n4 + (n2 - this.getPaddingLeft() - this.getPaddingRight())) * (n3 + (n - this.getPaddingLeft() - this.getPaddingRight()));
            this.scrollTo(n5, this.getScrollY());
            if (!this.m.isFinished()) {
                this.m.startScroll(n5, 0, (int)(this.b(this.i).e * n), 0, this.m.getDuration() - this.m.timePassed());
            }
        }
        else {
            final bh b = this.b(this.i);
            float min;
            if (b != null) {
                min = Math.min(b.e, this.t);
            }
            else {
                min = 0.0f;
            }
            final int n6 = (int)(min * (n - this.getPaddingLeft() - this.getPaddingRight()));
            if (n6 != this.getScrollX()) {
                this.a(false);
                this.scrollTo(n6, this.getScrollY());
            }
        }
    }
    
    private void a(final int n, final boolean b, final int n2, final boolean b2) {
        final bh b3 = this.b(n);
        int n3;
        if (b3 != null) {
            n3 = (int)(this.getClientWidth() * Math.max(this.s, Math.min(b3.e, this.t)));
        }
        else {
            n3 = 0;
        }
        if (b) {
            this.a(n3, 0, n2);
            if (b2 && this.W != null) {
                this.W.a(n);
            }
            if (b2 && this.Z != null) {
                this.Z.a(n);
            }
            return;
        }
        if (b2 && this.W != null) {
            this.W.a(n);
        }
        if (b2 && this.Z != null) {
            this.Z.a(n);
        }
        this.a(false);
        this.scrollTo(n3, 0);
        this.d(n3);
    }
    
    private void a(final bh bh, final int n, final bh bh2) {
        final int count = this.h.getCount();
        final int clientWidth = this.getClientWidth();
        float n2;
        if (clientWidth > 0) {
            n2 = this.o / clientWidth;
        }
        else {
            n2 = 0.0f;
        }
        if (bh2 != null) {
            final int b = bh2.b;
            if (b < bh.b) {
                float e = n2 + (bh2.e + bh2.d);
                for (int i = b + 1, n3 = 0; i <= bh.b && n3 < this.e.size(); ++i) {
                    bh bh3;
                    for (bh3 = this.e.get(n3); i > bh3.b && n3 < -1 + this.e.size(); ++n3, bh3 = this.e.get(n3)) {}
                    while (i < bh3.b) {
                        e += n2 + this.h.getPageWidth(i);
                        ++i;
                    }
                    bh3.e = e;
                    e += n2 + bh3.d;
                }
            }
            else if (b > bh.b) {
                int n4 = -1 + this.e.size();
                float e2 = bh2.e;
                for (int j = b - 1; j >= bh.b && n4 >= 0; --j) {
                    bh bh4;
                    for (bh4 = this.e.get(n4); j < bh4.b && n4 > 0; --n4, bh4 = this.e.get(n4)) {}
                    while (j > bh4.b) {
                        e2 -= n2 + this.h.getPageWidth(j);
                        --j;
                    }
                    e2 -= n2 + bh4.d;
                    bh4.e = e2;
                }
            }
        }
        final int size = this.e.size();
        float e3 = bh.e;
        int k = -1 + bh.b;
        float e4;
        if (bh.b == 0) {
            e4 = bh.e;
        }
        else {
            e4 = -3.4028235E38f;
        }
        this.s = e4;
        float t;
        if (bh.b == count - 1) {
            t = bh.e + bh.d - 1.0f;
        }
        else {
            t = Float.MAX_VALUE;
        }
        this.t = t;
        int n7;
        for (int l = n - 1; l >= 0; l = n7) {
            final bh bh5 = this.e.get(l);
            float n5 = e3;
            while (k > bh5.b) {
                final af h = this.h;
                final int n6 = k - 1;
                n5 -= n2 + h.getPageWidth(k);
                k = n6;
            }
            e3 = n5 - (n2 + bh5.d);
            bh5.e = e3;
            if (bh5.b == 0) {
                this.s = e3;
            }
            n7 = l - 1;
            --k;
        }
        float n8 = n2 + (bh.e + bh.d);
        int n9 = 1 + bh.b;
        int n11;
        for (int index = n + 1; index < size; index = n11) {
            final bh bh6 = this.e.get(index);
            float e5 = n8;
            while (n9 < bh6.b) {
                final af h2 = this.h;
                final int n10 = n9 + 1;
                e5 += n2 + h2.getPageWidth(n9);
                n9 = n10;
            }
            if (bh6.b == count - 1) {
                this.t = e5 + bh6.d - 1.0f;
            }
            bh6.e = e5;
            n8 = e5 + (n2 + bh6.d);
            n11 = index + 1;
            ++n9;
        }
        this.T = false;
    }
    
    private void a(final MotionEvent motionEvent) {
        final int b = android.support.v4.view.aa.b(motionEvent);
        if (android.support.v4.view.aa.b(motionEvent, b) == this.J) {
            int n;
            if (b == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.F = android.support.v4.view.aa.c(motionEvent, n);
            this.J = android.support.v4.view.aa.b(motionEvent, n);
            if (this.K != null) {
                this.K.clear();
            }
        }
    }
    
    private void a(final boolean b) {
        boolean b2;
        if (this.ah == 2) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (b2) {
            this.setScrollingCacheEnabled(false);
            this.m.abortAnimation();
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.m.getCurrX();
            final int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
            }
        }
        this.y = false;
        int i = 0;
        int n = b2 ? 1 : 0;
        while (i < this.e.size()) {
            final bh bh = this.e.get(i);
            if (bh.c) {
                bh.c = false;
                n = 1;
            }
            ++i;
        }
        if (n != 0) {
            if (!b) {
                this.ag.run();
                return;
            }
            al.a((View)this, this.ag);
        }
    }
    
    private boolean a(final float n, final float n2) {
        return (n < this.D && n2 > 0.0f) || (n > this.getWidth() - this.D && n2 < 0.0f);
    }
    
    private void b(final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            int n;
            if (b) {
                n = 2;
            }
            else {
                n = 0;
            }
            al.a(this.getChildAt(i), n, null);
        }
    }
    
    private boolean b(final float f) {
        boolean b = true;
        final float n = this.F - f;
        this.F = f;
        final float n2 = n + this.getScrollX();
        final int clientWidth = this.getClientWidth();
        float n3 = clientWidth * this.s;
        final float n4 = clientWidth * this.t;
        final bh bh = this.e.get(0);
        final bh bh2 = this.e.get(-1 + this.e.size());
        boolean b2;
        if (bh.b != 0) {
            n3 = bh.e * clientWidth;
            b2 = false;
        }
        else {
            b2 = b;
        }
        float n5;
        if (bh2.b != -1 + this.h.getCount()) {
            n5 = bh2.e * clientWidth;
            b = false;
        }
        else {
            n5 = n4;
        }
        boolean b3;
        if (n2 < n3) {
            b3 = false;
            if (b2) {
                b3 = this.Q.a(Math.abs(n3 - n2) / clientWidth);
            }
        }
        else if (n2 > n5) {
            b3 = false;
            if (b) {
                b3 = this.R.a(Math.abs(n2 - n5) / clientWidth);
            }
            n3 = n5;
        }
        else {
            n3 = n2;
            b3 = false;
        }
        this.F += n3 - (int)n3;
        this.scrollTo((int)n3, this.getScrollY());
        this.d((int)n3);
        return b3;
    }
    
    private void c(final boolean b) {
        final ViewParent parent = this.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(b);
        }
    }
    
    private boolean d(final int n) {
        boolean b;
        if (this.e.size() == 0) {
            this.U = false;
            this.a(0, 0.0f, 0);
            final boolean u = this.U;
            b = false;
            if (!u) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        }
        else {
            final bh i = this.i();
            final int clientWidth = this.getClientWidth();
            final int n2 = clientWidth + this.o;
            final float n3 = this.o / clientWidth;
            final int b2 = i.b;
            final float n4 = (n / clientWidth - i.e) / (n3 + i.d);
            final int n5 = (int)(n4 * n2);
            this.U = false;
            this.a(b2, n4, n5);
            if (!this.U) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            b = true;
        }
        return b;
    }
    
    private void g() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            if (!((bi)this.getChildAt(i).getLayoutParams()).a) {
                this.removeViewAt(i);
                --i;
            }
        }
    }
    
    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }
    
    private void h() {
        if (this.ad != 0) {
            if (this.ae == null) {
                this.ae = new ArrayList<View>();
            }
            else {
                this.ae.clear();
            }
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                this.ae.add(this.getChildAt(i));
            }
            Collections.sort(this.ae, ViewPager.af);
        }
    }
    
    private bh i() {
        final int clientWidth = this.getClientWidth();
        float n;
        if (clientWidth > 0) {
            n = this.getScrollX() / clientWidth;
        }
        else {
            n = 0.0f;
        }
        float n2;
        if (clientWidth > 0) {
            n2 = this.o / clientWidth;
        }
        else {
            n2 = 0.0f;
        }
        float n3 = 0.0f;
        float n4 = 0.0f;
        int n5 = -1;
        int i = 0;
        int n6 = 1;
        bh bh = null;
        while (i < this.e.size()) {
            final bh bh2 = this.e.get(i);
            int n7;
            bh bh3;
            if (n6 == 0 && bh2.b != n5 + 1) {
                final bh f = this.f;
                f.e = n2 + (n3 + n4);
                f.b = n5 + 1;
                f.d = this.h.getPageWidth(f.b);
                n7 = i - 1;
                bh3 = f;
            }
            else {
                n7 = i;
                bh3 = bh2;
            }
            final float e = bh3.e;
            final float n8 = n2 + (e + bh3.d);
            if (n6 == 0 && n < e) {
                break;
            }
            if (n < n8 || n7 == -1 + this.e.size()) {
                bh = bh3;
                break;
            }
            final int b = bh3.b;
            final float d = bh3.d;
            final int n9 = n7 + 1;
            n4 = e;
            n5 = b;
            n3 = d;
            bh = bh3;
            i = n9;
            n6 = 0;
        }
        return bh;
    }
    
    private void j() {
        this.A = false;
        this.B = false;
        if (this.K != null) {
            this.K.recycle();
            this.K = null;
        }
    }
    
    private void setScrollState(final int ah) {
        if (this.ah != ah) {
            this.ah = ah;
            if (this.ab != null) {
                this.b(ah != 0);
            }
            if (this.W != null) {
                this.W.b(ah);
            }
        }
    }
    
    private void setScrollingCacheEnabled(final boolean x) {
        if (this.x != x) {
            this.x = x;
        }
    }
    
    float a(final float n) {
        return (float)Math.sin((float)(0.4712389167638204 * (n - 0.5f)));
    }
    
    bh a(final int b, final int index) {
        final bh bh = new bh();
        bh.b = b;
        bh.a = this.h.instantiateItem(this, b);
        bh.d = this.h.getPageWidth(b);
        if (index < 0 || index >= this.e.size()) {
            this.e.add(bh);
            return bh;
        }
        this.e.add(index, bh);
        return bh;
    }
    
    bh a(final View view) {
        for (int i = 0; i < this.e.size(); ++i) {
            final bh bh = this.e.get(i);
            if (this.h.isViewFromObject(view, bh.a)) {
                return bh;
            }
        }
        return null;
    }
    
    void a() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        final Context context = this.getContext();
        this.m = new Scroller(context, ViewPager.d);
        final ViewConfiguration value = ViewConfiguration.get(context);
        final float density = context.getResources().getDisplayMetrics().density;
        this.E = bb.a(value);
        this.L = (int)(400.0f * density);
        this.M = value.getScaledMaximumFlingVelocity();
        this.Q = new i(context);
        this.R = new i(context);
        this.N = (int)(25.0f * density);
        this.O = (int)(2.0f * density);
        this.C = (int)(16.0f * density);
        al.a((View)this, new bj(this));
        if (al.c((View)this) == 0) {
            al.b((View)this, 1);
        }
    }
    
    void a(final int i) {
        bh bh;
        int n2;
        if (this.i != i) {
            int n;
            if (this.i < i) {
                n = 66;
            }
            else {
                n = 17;
            }
            final bh b = this.b(this.i);
            this.i = i;
            bh = b;
            n2 = n;
        }
        else {
            n2 = 2;
            bh = null;
        }
        if (this.h == null) {
            this.h();
        }
        else {
            if (this.y) {
                this.h();
                return;
            }
            if (this.getWindowToken() != null) {
                this.h.startUpdate(this);
                final int z = this.z;
                final int max = Math.max(0, this.i - z);
                final int count = this.h.getCount();
                final int min = Math.min(count - 1, z + this.i);
                if (count != this.b) {
                    try {
                        final String s = this.getResources().getResourceName(this.getId());
                        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + count + " Pager id: " + s + " Pager class: " + this.getClass() + " Problematic adapter: " + this.h.getClass());
                    }
                    catch (Resources$NotFoundException ex) {
                        final String s = Integer.toHexString(this.getId());
                        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + count + " Pager id: " + s + " Pager class: " + this.getClass() + " Problematic adapter: " + this.h.getClass());
                    }
                }
                int j = 0;
                while (true) {
                    while (j < this.e.size()) {
                        final bh bh2 = this.e.get(j);
                        if (bh2.b >= this.i) {
                            if (bh2.b != this.i) {
                                break;
                            }
                            bh a;
                            if (bh2 == null && count > 0) {
                                a = this.a(this.i, j);
                            }
                            else {
                                a = bh2;
                            }
                            if (a != null) {
                                final int index = j - 1;
                                bh bh3;
                                if (index >= 0) {
                                    bh3 = this.e.get(index);
                                }
                                else {
                                    bh3 = null;
                                }
                                final int clientWidth = this.getClientWidth();
                                float n3;
                                if (clientWidth <= 0) {
                                    n3 = 0.0f;
                                }
                                else {
                                    n3 = 2.0f - a.d + this.getPaddingLeft() / clientWidth;
                                }
                                final int n4 = -1 + this.i;
                                float n5 = 0.0f;
                                int k = n4;
                                int n6 = j;
                                int n7 = index;
                                while (k >= 0) {
                                    if (n5 >= n3 && k < max) {
                                        if (bh3 == null) {
                                            break;
                                        }
                                        if (k == bh3.b && !bh3.c) {
                                            this.e.remove(n7);
                                            this.h.destroyItem(this, k, bh3.a);
                                            --n7;
                                            --n6;
                                            if (n7 >= 0) {
                                                bh3 = this.e.get(n7);
                                            }
                                            else {
                                                bh3 = null;
                                            }
                                        }
                                    }
                                    else if (bh3 != null && k == bh3.b) {
                                        n5 += bh3.d;
                                        if (--n7 >= 0) {
                                            bh3 = this.e.get(n7);
                                        }
                                        else {
                                            bh3 = null;
                                        }
                                    }
                                    else {
                                        n5 += this.a(k, n7 + 1).d;
                                        ++n6;
                                        if (n7 >= 0) {
                                            bh3 = this.e.get(n7);
                                        }
                                        else {
                                            bh3 = null;
                                        }
                                    }
                                    --k;
                                }
                                float d = a.d;
                                final int index2 = n6 + 1;
                                if (d < 2.0f) {
                                    bh bh4;
                                    if (index2 < this.e.size()) {
                                        bh4 = this.e.get(index2);
                                    }
                                    else {
                                        bh4 = null;
                                    }
                                    float n8;
                                    if (clientWidth <= 0) {
                                        n8 = 0.0f;
                                    }
                                    else {
                                        n8 = 2.0f + this.getPaddingRight() / clientWidth;
                                    }
                                    final int n9 = 1 + this.i;
                                    bh bh5 = bh4;
                                    int n10 = index2;
                                    bh bh7;
                                    float n12;
                                    float n16;
                                    for (int l = n9; l < count; ++l, n16 = n12, bh5 = bh7, d = n16) {
                                        if (d >= n8 && l > min) {
                                            if (bh5 == null) {
                                                break;
                                            }
                                            if (l == bh5.b && !bh5.c) {
                                                this.e.remove(n10);
                                                this.h.destroyItem(this, l, bh5.a);
                                                bh bh6;
                                                if (n10 < this.e.size()) {
                                                    bh6 = this.e.get(n10);
                                                }
                                                else {
                                                    bh6 = null;
                                                }
                                                final float n11 = d;
                                                bh7 = bh6;
                                                n12 = n11;
                                            }
                                            else {
                                                final float n13 = d;
                                                bh7 = bh5;
                                                n12 = n13;
                                            }
                                        }
                                        else if (bh5 != null && l == bh5.b) {
                                            final float n14 = d + bh5.d;
                                            bh bh8;
                                            if (++n10 < this.e.size()) {
                                                bh8 = this.e.get(n10);
                                            }
                                            else {
                                                bh8 = null;
                                            }
                                            bh7 = bh8;
                                            n12 = n14;
                                        }
                                        else {
                                            final bh a2 = this.a(l, n10);
                                            ++n10;
                                            final float n15 = d + a2.d;
                                            bh bh9;
                                            if (n10 < this.e.size()) {
                                                bh9 = this.e.get(n10);
                                            }
                                            else {
                                                bh9 = null;
                                            }
                                            bh7 = bh9;
                                            n12 = n15;
                                        }
                                    }
                                }
                                this.a(a, n6, bh);
                            }
                            final af h = this.h;
                            final int m = this.i;
                            Object a3;
                            if (a != null) {
                                a3 = a.a;
                            }
                            else {
                                a3 = null;
                            }
                            h.setPrimaryItem(this, m, a3);
                            this.h.finishUpdate(this);
                            for (int childCount = this.getChildCount(), f = 0; f < childCount; ++f) {
                                final View child = this.getChildAt(f);
                                final bi bi = (bi)child.getLayoutParams();
                                bi.f = f;
                                if (!bi.a && bi.c == 0.0f) {
                                    final bh a4 = this.a(child);
                                    if (a4 != null) {
                                        bi.c = a4.d;
                                        bi.e = a4.b;
                                    }
                                }
                            }
                            this.h();
                            if (!this.hasFocus()) {
                                return;
                            }
                            final View focus = this.findFocus();
                            bh b2;
                            if (focus != null) {
                                b2 = this.b(focus);
                            }
                            else {
                                b2 = null;
                            }
                            if (b2 == null || b2.b != this.i) {
                                for (int n17 = 0; n17 < this.getChildCount(); ++n17) {
                                    final View child2 = this.getChildAt(n17);
                                    final bh a5 = this.a(child2);
                                    if (a5 != null && a5.b == this.i && child2.requestFocus(n2)) {
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
                    final bh bh2 = null;
                    continue;
                }
            }
        }
    }
    
    protected void a(final int n, final float n2, final int n3) {
        if (this.V > 0) {
            final int scrollX = this.getScrollX();
            int paddingLeft = this.getPaddingLeft();
            int paddingRight = this.getPaddingRight();
            final int width = this.getWidth();
            int n5 = 0;
            int n6 = 0;
            int n13;
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i, n13 = n6, paddingLeft = n5, paddingRight = n13) {
                final View child = this.getChildAt(i);
                final bi bi = (bi)child.getLayoutParams();
                if (!bi.a) {
                    final int n4 = paddingRight;
                    n5 = paddingLeft;
                    n6 = n4;
                }
                else {
                    int max = 0;
                    switch (0x7 & bi.b) {
                        default: {
                            max = paddingLeft;
                            final int n7 = paddingRight;
                            n5 = paddingLeft;
                            n6 = n7;
                            break;
                        }
                        case 3: {
                            final int n8 = paddingLeft + child.getWidth();
                            final int n9 = paddingLeft;
                            n6 = paddingRight;
                            n5 = n8;
                            max = n9;
                            break;
                        }
                        case 1: {
                            max = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            final int n10 = paddingRight;
                            n5 = paddingLeft;
                            n6 = n10;
                            break;
                        }
                        case 5: {
                            max = width - paddingRight - child.getMeasuredWidth();
                            final int n11 = paddingRight + child.getMeasuredWidth();
                            n5 = paddingLeft;
                            n6 = n11;
                            break;
                        }
                    }
                    final int n12 = max + scrollX - child.getLeft();
                    if (n12 != 0) {
                        child.offsetLeftAndRight(n12);
                    }
                }
            }
        }
        if (this.W != null) {
            this.W.a(n, n2, n3);
        }
        if (this.Z != null) {
            this.Z.a(n, n2, n3);
        }
        if (this.ab != null) {
            final int scrollX2 = this.getScrollX();
            for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
                final View child2 = this.getChildAt(j);
                if (!((bi)child2.getLayoutParams()).a) {
                    this.ab.a(child2, (child2.getLeft() - scrollX2) / this.getClientWidth());
                }
            }
        }
        this.U = true;
    }
    
    void a(final int n, final int n2, final int a) {
        if (this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        final int scrollX = this.getScrollX();
        final int scrollY = this.getScrollY();
        final int n3 = n - scrollX;
        final int n4 = n2 - scrollY;
        if (n3 == 0 && n4 == 0) {
            this.a(false);
            this.c();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        final int clientWidth = this.getClientWidth();
        final int n5 = clientWidth / 2;
        final float n6 = n5 + n5 * this.a(Math.min(1.0f, 1.0f * Math.abs(n3) / clientWidth));
        final int abs = Math.abs(a);
        int a2;
        if (abs > 0) {
            a2 = 4 * Math.round(1000.0f * Math.abs(n6 / abs));
        }
        else {
            a2 = (int)(100.0f * (1.0f + Math.abs(n3) / (clientWidth * this.h.getPageWidth(this.i) + this.o)));
        }
        this.m.startScroll(scrollX, scrollY, n3, n4, Math.min(a2, 600));
        al.b((View)this);
    }
    
    public void a(final int n, final boolean b) {
        this.a(n, b, this.y = false);
    }
    
    void a(final int n, final boolean b, final boolean b2) {
        this.a(n, b, b2, 0);
    }
    
    void a(int i, final boolean b, final boolean b2, final int n) {
        if (this.h == null || this.h.getCount() <= 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        if (!b2 && this.i == i && this.e.size() != 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        }
        else if (i >= this.h.getCount()) {
            i = -1 + this.h.getCount();
        }
        final int z = this.z;
        if (i > z + this.i || i < this.i - z) {
            for (int j = 0; j < this.e.size(); ++j) {
                this.e.get(j).c = true;
            }
        }
        final int k = this.i;
        boolean b3 = false;
        if (k != i) {
            b3 = true;
        }
        if (this.S) {
            this.i = i;
            if (b3 && this.W != null) {
                this.W.a(i);
            }
            if (b3 && this.Z != null) {
                this.Z.a(i);
            }
            this.requestLayout();
            return;
        }
        this.a(i);
        this.a(i, b, n, b3);
    }
    
    public boolean a(final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 21: {
                    return this.c(17);
                }
                case 22: {
                    return this.c(66);
                }
                case 61: {
                    if (Build$VERSION.SDK_INT < 11) {
                        break;
                    }
                    if (android.support.v4.view.t.a(keyEvent)) {
                        return this.c(2);
                    }
                    if (android.support.v4.view.t.a(keyEvent, 1)) {
                        return this.c(1);
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    protected boolean a(final View view, final boolean b, final int n, final int n2, final int n3) {
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
        if (!b || !al.a(view, -n)) {
            return false;
        }
        return true;
    }
    
    public void addFocusables(final ArrayList<View> list, final int n, final int n2) {
        final int size = list.size();
        final int descendantFocusability = this.getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 0) {
                    final bh a = this.a(child);
                    if (a != null && a.b == this.i) {
                        child.addFocusables((ArrayList)list, n, n2);
                    }
                }
            }
        }
        if ((descendantFocusability != 262144 || size == list.size()) && this.isFocusable() && ((n2 & 0x1) != 0x1 || !this.isInTouchMode() || this.isFocusableInTouchMode()) && list != null) {
            list.add((View)this);
        }
    }
    
    public void addTouchables(final ArrayList<View> list) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final bh a = this.a(child);
                if (a != null && a.b == this.i) {
                    child.addTouchables((ArrayList)list);
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
        final bi bi = (bi)generateLayoutParams;
        bi.a |= (view instanceof bg);
        if (!this.w) {
            super.addView(view, n, generateLayoutParams);
            return;
        }
        if (bi != null && bi.a) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        bi.d = true;
        this.addViewInLayout(view, n, generateLayoutParams);
    }
    
    bh b(final int n) {
        for (int i = 0; i < this.e.size(); ++i) {
            final bh bh = this.e.get(i);
            if (bh.b == n) {
                return bh;
            }
        }
        return null;
    }
    
    bh b(View view) {
        while (true) {
            final ViewParent parent = view.getParent();
            if (parent == this) {
                return this.a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View)parent;
        }
    }
    
    void b() {
        final int count = this.h.getCount();
        this.b = count;
        int n;
        if (this.e.size() < 1 + 2 * this.z && this.e.size() < count) {
            n = 1;
        }
        else {
            n = 0;
        }
        final int i = this.i;
        int n2 = 0;
        int n3 = i;
        int n4 = n;
        int n10;
        for (int j = 0; j < this.e.size(); j = n10) {
            final bh bh = this.e.get(j);
            final int itemPosition = this.h.getItemPosition(bh.a);
            int n5;
            int n6;
            int n7;
            int n8;
            if (itemPosition == -1) {
                n5 = j;
                n6 = n2;
                n7 = n3;
                n8 = n4;
            }
            else if (itemPosition == -2) {
                this.e.remove(j);
                final int n9 = j - 1;
                if (n2 == 0) {
                    this.h.startUpdate(this);
                    n2 = 1;
                }
                this.h.destroyItem(this, bh.b, bh.a);
                if (this.i == bh.b) {
                    final int max = Math.max(0, Math.min(this.i, count - 1));
                    n5 = n9;
                    n6 = n2;
                    n7 = max;
                    n8 = 1;
                }
                else {
                    n5 = n9;
                    n6 = n2;
                    n7 = n3;
                    n8 = 1;
                }
            }
            else if (bh.b != itemPosition) {
                if (bh.b == this.i) {
                    n3 = itemPosition;
                }
                bh.b = itemPosition;
                n5 = j;
                n6 = n2;
                n7 = n3;
                n8 = 1;
            }
            else {
                n5 = j;
                n6 = n2;
                n7 = n3;
                n8 = n4;
            }
            n10 = n5 + 1;
            n4 = n8;
            n3 = n7;
            n2 = n6;
        }
        if (n2 != 0) {
            this.h.finishUpdate(this);
        }
        Collections.sort(this.e, ViewPager.c);
        if (n4 != 0) {
            for (int childCount = this.getChildCount(), k = 0; k < childCount; ++k) {
                final bi bi = (bi)this.getChildAt(k).getLayoutParams();
                if (!bi.a) {
                    bi.c = 0.0f;
                }
            }
            this.a(n3, false, true);
            this.requestLayout();
        }
    }
    
    void c() {
        this.a(this.i);
    }
    
    public boolean c(final int n) {
        final View focus = this.findFocus();
        View view = null;
        Label_0012: {
            if (focus == this) {
                view = null;
            }
            else {
                Label_0371: {
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
                                    break Label_0371;
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
            Label_0365: {
                boolean b;
                if (nextFocus != null && nextFocus != view) {
                    if (n == 17) {
                        final int left = this.a(this.g, nextFocus).left;
                        final int left2 = this.a(this.g, view).left;
                        if (view != null && left >= left2) {
                            b = this.d();
                        }
                        else {
                            b = nextFocus.requestFocus();
                        }
                    }
                    else {
                        if (n != 66) {
                            break Label_0365;
                        }
                        final int left3 = this.a(this.g, nextFocus).left;
                        final int left4 = this.a(this.g, view).left;
                        if (view != null && left3 <= left4) {
                            b = this.e();
                        }
                        else {
                            b = nextFocus.requestFocus();
                        }
                    }
                }
                else if (n == 17 || n == 1) {
                    b = this.d();
                }
                else {
                    if (n != 66 && n != 2) {
                        break Label_0365;
                    }
                    b = this.e();
                }
                if (b) {
                    this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(n));
                }
                return b;
            }
            boolean b = false;
            continue;
        }
    }
    
    public boolean canScrollHorizontally(final int n) {
        boolean b = true;
        if (this.h != null) {
            final int clientWidth = this.getClientWidth();
            final int scrollX = this.getScrollX();
            if (n < 0) {
                if (scrollX <= (int)(clientWidth * this.s)) {
                    b = false;
                }
                return b;
            }
            if (n > 0) {
                if (scrollX >= (int)(clientWidth * this.t)) {
                    b = false;
                }
                return b;
            }
        }
        return false;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof bi && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.m.getCurrX();
            final int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
                if (!this.d(currX)) {
                    this.m.abortAnimation();
                    this.scrollTo(0, currY);
                }
            }
            al.b((View)this);
            return;
        }
        this.a(true);
    }
    
    boolean d() {
        if (this.i > 0) {
            this.a(-1 + this.i, true);
            return true;
        }
        return false;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.a(keyEvent);
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
                    final bh a = this.a(child);
                    if (a != null && a.b == this.i && child.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
        final int a = al.a((View)this);
        boolean b;
        if (a == 0 || (a == 1 && this.h != null && this.h.getCount() > 1)) {
            final boolean a2 = this.Q.a();
            b = false;
            if (!a2) {
                final int save = canvas.save();
                final int n = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                final int width = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n + this.getPaddingTop()), this.s * width);
                this.Q.a(n, width);
                b = (false | this.Q.a(canvas));
                canvas.restoreToCount(save);
            }
            if (!this.R.a()) {
                final int save2 = canvas.save();
                final int width2 = this.getWidth();
                final int n2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(1.0f + this.t) * width2);
                this.R.a(n2, width2);
                b |= this.R.a(canvas);
                canvas.restoreToCount(save2);
            }
        }
        else {
            this.Q.b();
            this.R.b();
            b = false;
        }
        if (b) {
            al.b((View)this);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable p = this.p;
        if (p != null && p.isStateful()) {
            p.setState(this.getDrawableState());
        }
    }
    
    boolean e() {
        if (this.h != null && this.i < -1 + this.h.getCount()) {
            this.a(1 + this.i, true);
            return true;
        }
        return false;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new bi();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new bi(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.generateDefaultLayoutParams();
    }
    
    public af getAdapter() {
        return this.h;
    }
    
    protected int getChildDrawingOrder(final int n, int index) {
        if (this.ad == 2) {
            index = n - 1 - index;
        }
        return ((bi)this.ae.get(index).getLayoutParams()).f;
    }
    
    public int getCurrentItem() {
        return this.i;
    }
    
    public int getOffscreenPageLimit() {
        return this.z;
    }
    
    public int getPageMargin() {
        return this.o;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.ag);
        super.onDetachedFromWindow();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.o > 0 && this.p != null && this.e.size() > 0 && this.h != null) {
            final int scrollX = this.getScrollX();
            final int width = this.getWidth();
            final float n = this.o / width;
            bh bh = this.e.get(0);
            float e = bh.e;
            final int size = this.e.size();
            final int b = bh.b;
            final int b2 = this.e.get(size - 1).b;
            int index = 0;
            for (int i = b; i < b2; ++i) {
                while (i > bh.b && index < size) {
                    final ArrayList<bh> e2 = this.e;
                    ++index;
                    bh = e2.get(index);
                }
                float n2;
                if (i == bh.b) {
                    n2 = (bh.e + bh.d) * width;
                    e = n + (bh.e + bh.d);
                }
                else {
                    final float pageWidth = this.h.getPageWidth(i);
                    n2 = (e + pageWidth) * width;
                    e += pageWidth + n;
                }
                if (n2 + this.o > scrollX) {
                    this.p.setBounds((int)n2, this.q, (int)(0.5f + (n2 + this.o)), this.r);
                    this.p.draw(canvas);
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
                if (this.A) {
                    return true;
                }
                if (this.B) {
                    return false;
                }
            }
            switch (n) {
                case 2: {
                    final int j = this.J;
                    if (j == -1) {
                        break;
                    }
                    final int a = android.support.v4.view.aa.a(motionEvent, j);
                    final float c = android.support.v4.view.aa.c(motionEvent, a);
                    final float a2 = c - this.F;
                    final float abs = Math.abs(a2);
                    final float d = android.support.v4.view.aa.d(motionEvent, a);
                    final float abs2 = Math.abs(d - this.I);
                    if (a2 != 0.0f && !this.a(this.F, a2) && this.a((View)this, false, (int)a2, (int)c, (int)d)) {
                        this.F = c;
                        this.G = d;
                        this.B = true;
                        return false;
                    }
                    if (abs > this.E && 0.5f * abs > abs2) {
                        this.c(this.A = true);
                        this.setScrollState(1);
                        float f;
                        if (a2 > 0.0f) {
                            f = this.H + this.E;
                        }
                        else {
                            f = this.H - this.E;
                        }
                        this.F = f;
                        this.G = d;
                        this.setScrollingCacheEnabled(true);
                    }
                    else if (abs2 > this.E) {
                        this.B = true;
                    }
                    if (this.A && this.b(c)) {
                        al.b((View)this);
                        break;
                    }
                    break;
                }
                case 0: {
                    final float x = motionEvent.getX();
                    this.H = x;
                    this.F = x;
                    final float y = motionEvent.getY();
                    this.I = y;
                    this.G = y;
                    this.J = android.support.v4.view.aa.b(motionEvent, 0);
                    this.B = false;
                    this.m.computeScrollOffset();
                    if (this.ah == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.O) {
                        this.m.abortAnimation();
                        this.y = false;
                        this.c();
                        this.c(this.A = true);
                        this.setScrollState(1);
                        break;
                    }
                    this.a(false);
                    this.A = false;
                    break;
                }
                case 6: {
                    this.a(motionEvent);
                    break;
                }
            }
            if (this.K == null) {
                this.K = VelocityTracker.obtain();
            }
            this.K.addMovement(motionEvent);
            return this.A;
        }
        this.A = false;
        this.B = false;
        this.J = -1;
        if (this.K != null) {
            this.K.recycle();
            this.K = null;
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
        int v = 0;
        int i = 0;
    Label_0262_Outer:
        while (i < childCount) {
            final View child = this.getChildAt(i);
            while (true) {
                Label_0659: {
                    if (child.getVisibility() == 8) {
                        break Label_0659;
                    }
                    final bi bi = (bi)child.getLayoutParams();
                    if (!bi.a) {
                        break Label_0659;
                    }
                    final int n7 = 0x7 & bi.b;
                    final int n8 = 0x70 & bi.b;
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
                    final int n19 = v + 1;
                    final int n20 = n12;
                    paddingBottom = n13;
                    final int n21 = paddingRight;
                    final int n22 = paddingLeft;
                    ++i;
                    paddingLeft = n22;
                    paddingRight = n21;
                    paddingTop = n20;
                    v = n19;
                    continue Label_0262_Outer;
                }
                final int n19 = v;
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
                final bi bi2 = (bi)child2.getLayoutParams();
                if (!bi2.a) {
                    final bh a = this.a(child2);
                    if (a != null) {
                        final int n24 = paddingLeft + (int)(n23 * a.e);
                        if (bi2.d) {
                            bi2.d = false;
                            child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n23 * bi2.c), 1073741824), View$MeasureSpec.makeMeasureSpec(n6 - paddingTop - paddingBottom, 1073741824));
                        }
                        child2.layout(n24, paddingTop, n24 + child2.getMeasuredWidth(), paddingTop + child2.getMeasuredHeight());
                    }
                }
            }
        }
        this.q = paddingTop;
        this.r = n6 - paddingBottom;
        this.V = v;
        if (this.S) {
            this.a(this.i, false, 0, false);
        }
        this.S = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(getDefaultSize(0, n), getDefaultSize(0, n2));
        final int measuredWidth = this.getMeasuredWidth();
        this.D = Math.min(measuredWidth / 10, this.C);
        int n3 = measuredWidth - this.getPaddingLeft() - this.getPaddingRight();
        int n4 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
    Label_0288:
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final bi bi = (bi)child.getLayoutParams();
                if (bi != null && bi.a) {
                    final int n5 = 0x7 & bi.b;
                    final int n6 = 0x70 & bi.b;
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
                    if (bi.width != -2) {
                        n9 = 1073741824;
                        if (bi.width != -1) {
                            width = bi.width;
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
                            if (bi.height == -2) {
                                break Label_0464;
                            }
                            n8 = 1073741824;
                            if (bi.height == -1) {
                                break Label_0464;
                            }
                            final int height = bi.height;
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
        this.u = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
        this.v = View$MeasureSpec.makeMeasureSpec(n4, 1073741824);
        this.w = true;
        this.c();
        this.w = false;
        for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
            final View child2 = this.getChildAt(j);
            if (child2.getVisibility() != 8) {
                final bi bi2 = (bi)child2.getLayoutParams();
                if (bi2 == null || !bi2.a) {
                    child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n3 * bi2.c), 1073741824), this.v);
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
                final bh a = this.a(child);
                if (a != null && a.b == this.i && child.requestFocus(n, rect)) {
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
            this.h.restoreState(viewPager$SavedState.b, viewPager$SavedState.c);
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
            viewPager$SavedState.b = this.h.saveState();
        }
        return (Parcelable)viewPager$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            this.a(n, n3, this.o, this.o);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.h == null || this.h.getCount() == 0) {
            return false;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        final int n = 0xFF & motionEvent.getAction();
        int n2 = 0;
        switch (n) {
            case 0: {
                this.m.abortAnimation();
                this.y = false;
                this.c();
                final float x = motionEvent.getX();
                this.H = x;
                this.F = x;
                final float y = motionEvent.getY();
                this.I = y;
                this.G = y;
                this.J = android.support.v4.view.aa.b(motionEvent, 0);
                n2 = 0;
                break;
            }
            case 2: {
                if (!this.A) {
                    final int a = android.support.v4.view.aa.a(motionEvent, this.J);
                    final float c = android.support.v4.view.aa.c(motionEvent, a);
                    final float abs = Math.abs(c - this.F);
                    final float d = android.support.v4.view.aa.d(motionEvent, a);
                    final float abs2 = Math.abs(d - this.G);
                    if (abs > this.E && abs > abs2) {
                        this.c(this.A = true);
                        float f;
                        if (c - this.H > 0.0f) {
                            f = this.H + this.E;
                        }
                        else {
                            f = this.H - this.E;
                        }
                        this.F = f;
                        this.G = d;
                        this.setScrollState(1);
                        this.setScrollingCacheEnabled(true);
                        final ViewParent parent = this.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                final boolean a2 = this.A;
                n2 = 0;
                if (a2) {
                    n2 = ((false | this.b(android.support.v4.view.aa.c(motionEvent, android.support.v4.view.aa.a(motionEvent, this.J)))) ? 1 : 0);
                    break;
                }
                break;
            }
            case 1: {
                final boolean a3 = this.A;
                n2 = 0;
                if (a3) {
                    final VelocityTracker k = this.K;
                    k.computeCurrentVelocity(1000, (float)this.M);
                    final int n3 = (int)android.support.v4.view.ag.a(k, this.J);
                    this.y = true;
                    final int clientWidth = this.getClientWidth();
                    final int scrollX = this.getScrollX();
                    final bh i = this.i();
                    this.a(this.a(i.b, (scrollX / clientWidth - i.e) / i.d, n3, (int)(android.support.v4.view.aa.c(motionEvent, android.support.v4.view.aa.a(motionEvent, this.J)) - this.H)), true, true, n3);
                    this.J = -1;
                    this.j();
                    n2 = ((this.Q.c() | this.R.c()) ? 1 : 0);
                    break;
                }
                break;
            }
            case 3: {
                final boolean a4 = this.A;
                n2 = 0;
                if (a4) {
                    this.a(this.i, true, 0, false);
                    this.J = -1;
                    this.j();
                    n2 = ((this.Q.c() | this.R.c()) ? 1 : 0);
                    break;
                }
                break;
            }
            case 5: {
                final int b = android.support.v4.view.aa.b(motionEvent);
                this.F = android.support.v4.view.aa.c(motionEvent, b);
                this.J = android.support.v4.view.aa.b(motionEvent, b);
                n2 = 0;
                break;
            }
            case 6: {
                this.a(motionEvent);
                this.F = android.support.v4.view.aa.c(motionEvent, android.support.v4.view.aa.a(motionEvent, this.J));
                n2 = 0;
                break;
            }
        }
        if (n2 != 0) {
            al.b((View)this);
        }
        return true;
    }
    
    public void removeView(final View view) {
        if (this.w) {
            this.removeViewInLayout(view);
            return;
        }
        super.removeView(view);
    }
    
    public void setAdapter(final af h) {
        if (this.h != null) {
            this.h.unregisterDataSetObserver(this.n);
            this.h.startUpdate(this);
            for (int i = 0; i < this.e.size(); ++i) {
                final bh bh = this.e.get(i);
                this.h.destroyItem(this, bh.b, bh.a);
            }
            this.h.finishUpdate(this);
            this.e.clear();
            this.g();
            this.scrollTo(this.i = 0, 0);
        }
        final af h2 = this.h;
        this.h = h;
        this.b = 0;
        if (this.h != null) {
            if (this.n == null) {
                this.n = new bn(this, null);
            }
            this.h.registerDataSetObserver(this.n);
            this.y = false;
            final boolean s = this.S;
            this.S = true;
            this.b = this.h.getCount();
            if (this.j >= 0) {
                this.h.restoreState(this.k, this.l);
                this.a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            }
            else if (!s) {
                this.c();
            }
            else {
                this.requestLayout();
            }
        }
        if (this.aa != null && h2 != h) {
            this.aa.a(h2, h);
        }
    }
    
    void setChildrenDrawingOrderEnabledCompat(final boolean p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: bipush          7
        //     5: if_icmplt       71
        //     8: aload_0        
        //     9: getfield        android/support/v4/view/ViewPager.ac:Ljava/lang/reflect/Method;
        //    12: ifnonnull       42
        //    15: iconst_1       
        //    16: anewarray       Ljava/lang/Class;
        //    19: astore          9
        //    21: aload           9
        //    23: iconst_0       
        //    24: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
        //    27: aastore        
        //    28: aload_0        
        //    29: ldc             Landroid/view/ViewGroup;.class
        //    31: ldc_w           "setChildrenDrawingOrderEnabled"
        //    34: aload           9
        //    36: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    39: putfield        android/support/v4/view/ViewPager.ac:Ljava/lang/reflect/Method;
        //    42: aload_0        
        //    43: getfield        android/support/v4/view/ViewPager.ac:Ljava/lang/reflect/Method;
        //    46: astore          4
        //    48: iconst_1       
        //    49: anewarray       Ljava/lang/Object;
        //    52: astore          5
        //    54: aload           5
        //    56: iconst_0       
        //    57: iload_1        
        //    58: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    61: aastore        
        //    62: aload           4
        //    64: aload_0        
        //    65: aload           5
        //    67: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    70: pop            
        //    71: return         
        //    72: astore          7
        //    74: ldc_w           "ViewPager"
        //    77: ldc_w           "Can't find setChildrenDrawingOrderEnabled"
        //    80: aload           7
        //    82: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    85: pop            
        //    86: goto            42
        //    89: astore_2       
        //    90: ldc_w           "ViewPager"
        //    93: ldc_w           "Error changing children drawing order"
        //    96: aload_2        
        //    97: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   100: pop            
        //   101: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  15     42     72     89     Ljava/lang/NoSuchMethodException;
        //  42     71     89     102    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0042:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void setCurrentItem(final int n) {
        this.y = false;
        this.a(n, !this.S, false);
    }
    
    public void setOffscreenPageLimit(int n) {
        if (n < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + n + " too small; defaulting to " + 1);
            n = 1;
        }
        if (n != this.z) {
            this.z = n;
            this.c();
        }
    }
    
    void setOnAdapterChangeListener(final bk aa) {
        this.aa = aa;
    }
    
    public void setOnPageChangeListener(final bl w) {
        this.W = w;
    }
    
    public void setPageMargin(final int o) {
        final int o2 = this.o;
        this.o = o;
        final int width = this.getWidth();
        this.a(width, width, o, o2);
        this.requestLayout();
    }
    
    public void setPageMarginDrawable(final int n) {
        this.setPageMarginDrawable(this.getContext().getResources().getDrawable(n));
    }
    
    public void setPageMarginDrawable(final Drawable p) {
        this.p = p;
        if (p != null) {
            this.refreshDrawableState();
        }
        this.setWillNotDraw(p == null);
        this.invalidate();
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }
}
