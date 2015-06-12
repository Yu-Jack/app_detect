// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import java.util.Arrays;
import android.support.v4.view.ad;
import android.support.v4.view.s;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public final class z
{
    private static final Interpolator v;
    private int a;
    private int b;
    private int c;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private j q;
    private final aa r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w;
    
    static {
        v = (Interpolator)new Interpolator() {
            public final float getInterpolation(final float n) {
                final float n2 = n - 1.0f;
                return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
            }
        };
    }
    
    private z(final Context context, final ViewGroup u, final aa r) {
        this.c = -1;
        this.w = new Runnable() {
            @Override
            public final void run() {
                z.this.b(0);
            }
        };
        if (u == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (r == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = u;
        this.r = r;
        final ViewConfiguration value = ViewConfiguration.get(context);
        this.o = (int)(0.5f + 20.0f * context.getResources().getDisplayMetrics().density);
        this.b = value.getScaledTouchSlop();
        this.m = value.getScaledMaximumFlingVelocity();
        this.n = value.getScaledMinimumFlingVelocity();
        this.q = new j(context, z.v);
    }
    
    private static float a(final float a, final float n, float n2) {
        final float abs = Math.abs(a);
        if (abs < n) {
            n2 = 0.0f;
        }
        else {
            if (abs <= n2) {
                return a;
            }
            if (a <= 0.0f) {
                return -n2;
            }
        }
        return n2;
    }
    
    private int a(final int n, final int a, final int n2) {
        if (n == 0) {
            return 0;
        }
        final int width = this.u.getWidth();
        final int n3 = width / 2;
        final float n4 = n3 + n3 * (float)Math.sin((float)(0.4712389167638204 * (Math.min(1.0f, Math.abs(n) / width) - 0.5f)));
        final int abs = Math.abs(a);
        int a2;
        if (abs > 0) {
            a2 = 4 * Math.round(1000.0f * Math.abs(n4 / abs));
        }
        else {
            a2 = (int)(256.0f * (1.0f + Math.abs(n) / n2));
        }
        return Math.min(a2, 600);
    }
    
    public static z a(final ViewGroup viewGroup, final float n, final aa aa) {
        final z z = new z(viewGroup.getContext(), viewGroup, aa);
        z.b *= (int)(1.0f / n);
        return z;
    }
    
    private void a(final float n, final float n2, final int n3) {
        if (this.d == null || this.d.length <= n3) {
            final float[] d = new float[n3 + 1];
            final float[] e = new float[n3 + 1];
            final float[] f = new float[n3 + 1];
            final float[] g = new float[n3 + 1];
            final int[] h = new int[n3 + 1];
            final int[] i = new int[n3 + 1];
            final int[] j = new int[n3 + 1];
            if (this.d != null) {
                System.arraycopy(this.d, 0, d, 0, this.d.length);
                System.arraycopy(this.e, 0, e, 0, this.e.length);
                System.arraycopy(this.f, 0, f, 0, this.f.length);
                System.arraycopy(this.g, 0, g, 0, this.g.length);
                System.arraycopy(this.h, 0, h, 0, this.h.length);
                System.arraycopy(this.i, 0, i, 0, this.i.length);
                System.arraycopy(this.j, 0, j, 0, this.j.length);
            }
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
        }
        this.d[n3] = (this.f[n3] = n);
        this.e[n3] = (this.g[n3] = n2);
        final int[] h2 = this.h;
        final int n4 = (int)n;
        final int n5 = (int)n2;
        final int n6 = this.u.getLeft() + this.o;
        int n7 = 0;
        if (n4 < n6) {
            n7 = 1;
        }
        if (n5 < this.u.getTop() + this.o) {
            n7 |= 0x4;
        }
        if (n4 > this.u.getRight() - this.o) {
            n7 |= 0x2;
        }
        if (n5 > this.u.getBottom() - this.o) {
            n7 |= 0x8;
        }
        h2[n3] = n7;
        this.k |= 1 << n3;
    }
    
    private boolean a(final float a, final float a2, final int n, final int n2) {
        final float abs = Math.abs(a);
        final float abs2 = Math.abs(a2);
        if ((n2 & this.h[n]) == n2 && (n2 & this.p) != 0x0 && (n2 & this.j[n]) != n2 && (n2 & this.i[n]) != n2 && (abs > this.b || abs2 > this.b)) {
            if (abs < abs2 * 0.5f) {
                final aa r = this.r;
            }
            if ((n2 & this.i[n]) == 0x0 && abs > this.b) {
                return true;
            }
        }
        return false;
    }
    
    private boolean a(final int n, final int n2, final int n3, final int n4) {
        final int left = this.s.getLeft();
        final int top = this.s.getTop();
        final int a = n - left;
        final int a2 = n2 - top;
        if (a == 0 && a2 == 0) {
            this.q.c();
            this.b(0);
            return false;
        }
        final View s = this.s;
        final int b = b(n3, (int)this.n, (int)this.m);
        final int b2 = b(n4, (int)this.n, (int)this.m);
        final int abs = Math.abs(a);
        final int abs2 = Math.abs(a2);
        final int abs3 = Math.abs(b);
        final int abs4 = Math.abs(b2);
        final int n5 = abs3 + abs4;
        final int n6 = abs + abs2;
        float n7;
        if (b != 0) {
            n7 = abs3 / n5;
        }
        else {
            n7 = abs / n6;
        }
        float n8;
        if (b2 != 0) {
            n8 = abs4 / n5;
        }
        else {
            n8 = abs2 / n6;
        }
        final int a3 = this.a(a, b, this.r.c(s));
        final aa r = this.r;
        final int n9 = (int)(n7 * a3 + n8 * this.a(a2, b2, 0));
        final j q = this.q;
        q.b.a(q.a, left, top, a, a2, n9);
        this.b(2);
        return true;
    }
    
    private boolean a(final View view, final float a) {
        if (view != null) {
            boolean b;
            if (this.r.c(view) > 0) {
                b = true;
            }
            else {
                b = false;
            }
            final aa r = this.r;
            if (b && Math.abs(a) > this.b) {
                return true;
            }
        }
        return false;
    }
    
    private static int b(final int a, final int n, int n2) {
        final int abs = Math.abs(a);
        if (abs < n) {
            n2 = 0;
        }
        else {
            if (abs <= n2) {
                return a;
            }
            if (a <= 0) {
                return -n2;
            }
        }
        return n2;
    }
    
    private void b(final float n) {
        this.t = true;
        this.r.a(this.s, n);
        this.t = false;
        if (this.a == 1) {
            this.b(0);
        }
    }
    
    private void b(final float n, final float n2, final int n3) {
        int n4 = 1;
        if (!this.a(n, n2, n3, n4)) {
            n4 = 0;
        }
        if (this.a(n2, n, n3, 4)) {
            n4 |= 0x4;
        }
        if (this.a(n, n2, n3, 2)) {
            n4 |= 0x2;
        }
        if (this.a(n2, n, n3, 8)) {
            n4 |= 0x8;
        }
        if (n4 != 0) {
            final int[] i = this.i;
            i[n3] |= n4;
            this.r.a(n4, n3);
        }
    }
    
    private boolean b(final View view, final int c) {
        if (view == this.s && this.c == c) {
            return true;
        }
        if (view != null && this.r.a(view)) {
            this.a(view, this.c = c);
            return true;
        }
        return false;
    }
    
    public static boolean b(final View view, final int n, final int n2) {
        return view != null && n >= view.getLeft() && n < view.getRight() && n2 >= view.getTop() && n2 < view.getBottom();
    }
    
    private void c(final int n) {
        if (this.d == null) {
            return;
        }
        this.d[n] = 0.0f;
        this.e[n] = 0.0f;
        this.f[n] = 0.0f;
        this.g[n] = 0.0f;
        this.h[n] = 0;
        this.i[n] = 0;
        this.j[n] = 0;
        this.k &= (-1 ^ 1 << n);
    }
    
    private void c(final MotionEvent motionEvent) {
        for (int c = android.support.v4.view.s.c(motionEvent), i = 0; i < c; ++i) {
            final int b = android.support.v4.view.s.b(motionEvent, i);
            final float c2 = android.support.v4.view.s.c(motionEvent, i);
            final float d = android.support.v4.view.s.d(motionEvent, i);
            this.f[b] = c2;
            this.g[b] = d;
        }
    }
    
    private void i() {
        this.l.computeCurrentVelocity(1000, this.m);
        final float a = a(ad.a(this.l, this.c), this.n, this.m);
        a(ad.b(this.l, this.c), this.n, this.m);
        this.b(a);
    }
    
    public final int a() {
        return this.a;
    }
    
    public final void a(final float n) {
        this.n = n;
    }
    
    public final void a(final int p) {
        this.p = p;
    }
    
    public final void a(final View s, final int c) {
        if (s.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = s;
        this.c = c;
        this.r.b(s);
        this.b(1);
    }
    
    public final boolean a(final int n, final int n2) {
        if (!this.t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return this.a(n, n2, (int)ad.a(this.l, this.c), (int)ad.b(this.l, this.c));
    }
    
    public final boolean a(final MotionEvent motionEvent) {
        final int a = android.support.v4.view.s.a(motionEvent);
        final int b = android.support.v4.view.s.b(motionEvent);
        if (a == 0) {
            this.e();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (a) {
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                final int b2 = android.support.v4.view.s.b(motionEvent, 0);
                this.a(x, y, b2);
                final View b3 = this.b((int)x, (int)y);
                if (b3 == this.s && this.a == 2) {
                    this.b(b3, b2);
                }
                if ((this.h[b2] & this.p) != 0x0) {
                    final aa r = this.r;
                    final int p = this.p;
                    r.b();
                    break;
                }
                break;
            }
            case 5: {
                final int b4 = android.support.v4.view.s.b(motionEvent, b);
                final float c = android.support.v4.view.s.c(motionEvent, b);
                final float d = android.support.v4.view.s.d(motionEvent, b);
                this.a(c, d, b4);
                if (this.a == 0) {
                    if ((this.h[b4] & this.p) != 0x0) {
                        final aa r2 = this.r;
                        final int p2 = this.p;
                        r2.b();
                        break;
                    }
                    break;
                }
                else {
                    if (this.a != 2) {
                        break;
                    }
                    final View b5 = this.b((int)c, (int)d);
                    if (b5 == this.s) {
                        this.b(b5, b4);
                        break;
                    }
                    break;
                }
                break;
            }
            case 2: {
                for (int c2 = android.support.v4.view.s.c(motionEvent), i = 0; i < c2; ++i) {
                    final int b6 = android.support.v4.view.s.b(motionEvent, i);
                    final float c3 = android.support.v4.view.s.c(motionEvent, i);
                    final float d2 = android.support.v4.view.s.d(motionEvent, i);
                    final float n = c3 - this.d[b6];
                    this.b(n, d2 - this.e[b6], b6);
                    if (this.a == 1) {
                        break;
                    }
                    final View b7 = this.b((int)c3, (int)d2);
                    if (b7 != null && this.a(b7, n) && this.b(b7, b6)) {
                        break;
                    }
                }
                this.c(motionEvent);
                break;
            }
            case 6: {
                this.c(android.support.v4.view.s.b(motionEvent, b));
                break;
            }
            case 1:
            case 3: {
                this.e();
                break;
            }
        }
        return this.a == 1;
    }
    
    public final boolean a(final View s, final int n, final int n2) {
        this.s = s;
        this.c = -1;
        return this.a(n, n2, 0, 0);
    }
    
    public final int b() {
        return this.o;
    }
    
    public final View b(final int n, final int n2) {
        for (int i = -1 + this.u.getChildCount(); i >= 0; --i) {
            final ViewGroup u = this.u;
            final aa r = this.r;
            final View child = u.getChildAt(i);
            if (n >= child.getLeft() && n < child.getRight() && n2 >= child.getTop() && n2 < child.getBottom()) {
                return child;
            }
        }
        return null;
    }
    
    final void b(final int a) {
        if (this.a != a) {
            this.a = a;
            this.r.a(a);
            if (a == 0) {
                this.s = null;
            }
        }
    }
    
    public final void b(final MotionEvent motionEvent) {
        int i = 0;
        final int a = android.support.v4.view.s.a(motionEvent);
        final int b = android.support.v4.view.s.b(motionEvent);
        if (a == 0) {
            this.e();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (a) {
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                final int b2 = android.support.v4.view.s.b(motionEvent, 0);
                final View b3 = this.b((int)x, (int)y);
                this.a(x, y, b2);
                this.b(b3, b2);
                if ((this.h[b2] & this.p) != 0x0) {
                    final aa r = this.r;
                    final int p = this.p;
                    r.b();
                    return;
                }
                break;
            }
            case 5: {
                final int b4 = android.support.v4.view.s.b(motionEvent, b);
                final float c = android.support.v4.view.s.c(motionEvent, b);
                final float d = android.support.v4.view.s.d(motionEvent, b);
                this.a(c, d, b4);
                if (this.a == 0) {
                    this.b(this.b((int)c, (int)d), b4);
                    if ((this.h[b4] & this.p) != 0x0) {
                        final aa r2 = this.r;
                        final int p2 = this.p;
                        r2.b();
                        return;
                    }
                    break;
                }
                else {
                    if (b(this.s, (int)c, (int)d)) {
                        this.b(this.s, b4);
                        return;
                    }
                    break;
                }
                break;
            }
            case 2: {
                if (this.a == 1) {
                    final int a2 = android.support.v4.view.s.a(motionEvent, this.c);
                    final float c2 = android.support.v4.view.s.c(motionEvent, a2);
                    final float d2 = android.support.v4.view.s.d(motionEvent, a2);
                    final int n = (int)(c2 - this.f[this.c]);
                    final int n2 = (int)(d2 - this.g[this.c]);
                    int b5 = n + this.s.getLeft();
                    this.s.getTop();
                    final int left = this.s.getLeft();
                    final int top = this.s.getTop();
                    if (n != 0) {
                        b5 = this.r.b(this.s, b5);
                        this.s.offsetLeftAndRight(b5 - left);
                    }
                    if (n2 != 0) {
                        this.s.offsetTopAndBottom(this.r.d(this.s) - top);
                    }
                    if (n != 0 || n2 != 0) {
                        this.r.a(this.s, b5);
                    }
                    this.c(motionEvent);
                    return;
                }
                while (i < android.support.v4.view.s.c(motionEvent)) {
                    final int b6 = android.support.v4.view.s.b(motionEvent, i);
                    final float c3 = android.support.v4.view.s.c(motionEvent, i);
                    final float d3 = android.support.v4.view.s.d(motionEvent, i);
                    final float n3 = c3 - this.d[b6];
                    this.b(n3, d3 - this.e[b6], b6);
                    if (this.a == 1) {
                        break;
                    }
                    final View b7 = this.b((int)c3, (int)d3);
                    if (this.a(b7, n3) && this.b(b7, b6)) {
                        break;
                    }
                    ++i;
                }
                this.c(motionEvent);
            }
            case 6: {
                final int b8 = android.support.v4.view.s.b(motionEvent, b);
                Label_0720: {
                    if (this.a == 1 && b8 == this.c) {
                        while (true) {
                            while (i < android.support.v4.view.s.c(motionEvent)) {
                                final int b9 = android.support.v4.view.s.b(motionEvent, i);
                                if (b9 != this.c && this.b((int)android.support.v4.view.s.c(motionEvent, i), (int)android.support.v4.view.s.d(motionEvent, i)) == this.s && this.b(this.s, b9)) {
                                    final int c4 = this.c;
                                    if (c4 == -1) {
                                        this.i();
                                    }
                                    break Label_0720;
                                }
                                else {
                                    ++i;
                                }
                            }
                            final int c4 = -1;
                            continue;
                        }
                    }
                }
                this.c(b8);
            }
            case 1: {
                if (this.a == 1) {
                    this.i();
                }
                this.e();
            }
            case 3: {
                if (this.a == 1) {
                    this.b(0.0f);
                }
                this.e();
            }
        }
    }
    
    public final View c() {
        return this.s;
    }
    
    public final int d() {
        return this.b;
    }
    
    public final void e() {
        this.c = -1;
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }
    
    public final void f() {
        this.e();
        if (this.a == 2) {
            this.q.a();
            this.q.b();
            this.q.c();
            final int a = this.q.a();
            this.q.b();
            this.r.a(this.s, a);
        }
        this.b(0);
    }
    
    public final boolean g() {
        if (this.a == 2) {
            final j q = this.q;
            boolean b = q.b.d(q.a);
            final int a = this.q.a();
            final int b2 = this.q.b();
            final int n = a - this.s.getLeft();
            final int n2 = b2 - this.s.getTop();
            if (n != 0) {
                this.s.offsetLeftAndRight(n);
            }
            if (n2 != 0) {
                this.s.offsetTopAndBottom(n2);
            }
            if (n != 0 || n2 != 0) {
                this.r.a(this.s, a);
            }
            if (b) {
                final j q2 = this.q;
                if (a == q2.b.f(q2.a)) {
                    final j q3 = this.q;
                    if (b2 == q3.b.g(q3.a)) {
                        this.q.c();
                        final j q4 = this.q;
                        b = q4.b.a(q4.a);
                    }
                }
            }
            if (!b) {
                this.u.post(this.w);
            }
        }
        return this.a == 2;
    }
    
    public final boolean h() {
        for (int length = this.d.length, i = 0; i < length; ++i) {
            int n;
            if ((this.k & 1 << i) != 0x0) {
                n = 1;
            }
            else {
                n = 0;
            }
            int n4;
            if (n != 0) {
                final float n2 = this.f[i] - this.d[i];
                final float n3 = this.g[i] - this.e[i];
                if (n2 * n2 + n3 * n3 > this.b * this.b) {
                    n4 = 1;
                }
                else {
                    n4 = 0;
                }
            }
            else {
                n4 = 0;
            }
            if (n4 != 0) {
                return true;
            }
        }
        return false;
    }
}
