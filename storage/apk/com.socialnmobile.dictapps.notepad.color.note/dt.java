import java.util.Arrays;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class dt
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
    private dn q;
    private final dw r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w;
    
    static {
        v = (Interpolator)new du();
    }
    
    private dt(final Context context, final ViewGroup u, final dw r) {
        this.c = -1;
        this.w = new dv(this);
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
        this.q = dn.a(context, dt.v);
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
    
    public static dt a(final ViewGroup viewGroup, final dw dw) {
        final dt dt = new dt(viewGroup.getContext(), viewGroup, dw);
        dt.b *= (int)1.0f;
        return dt;
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
                final dw r = this.r;
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
            this.q.a();
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
        final dw r = this.r;
        final int n9 = (int)(n7 * a3 + n8 * this.a(a2, b2, 0));
        final dn q = this.q;
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
            final dw r = this.r;
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
        for (int c = bv.c(motionEvent), i = 0; i < c; ++i) {
            final int b = bv.b(motionEvent, i);
            final float c2 = bv.c(motionEvent, i);
            final float d = bv.d(motionEvent, i);
            this.f[b] = c2;
            this.g[b] = d;
        }
    }
    
    private void h() {
        this.l.computeCurrentVelocity(1000, this.m);
        final float a = a(ca.a(this.l, this.c), this.n, this.m);
        a(ca.b(this.l, this.c), this.n, this.m);
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
        return this.a(n, n2, (int)ca.a(this.l, this.c), (int)ca.b(this.l, this.c));
    }
    
    public final boolean a(final MotionEvent motionEvent) {
        final int a = bv.a(motionEvent);
        final int b = bv.b(motionEvent);
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
                final int b2 = bv.b(motionEvent, 0);
                this.a(x, y, b2);
                final View b3 = this.b((int)x, (int)y);
                if (b3 == this.s && this.a == 2) {
                    this.b(b3, b2);
                }
                if ((this.h[b2] & this.p) != 0x0) {
                    final dw r = this.r;
                    final int p = this.p;
                    r.c();
                    break;
                }
                break;
            }
            case 5: {
                final int b4 = bv.b(motionEvent, b);
                final float c = bv.c(motionEvent, b);
                final float d = bv.d(motionEvent, b);
                this.a(c, d, b4);
                if (this.a == 0) {
                    if ((this.h[b4] & this.p) != 0x0) {
                        final dw r2 = this.r;
                        final int p2 = this.p;
                        r2.c();
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
                for (int c2 = bv.c(motionEvent), i = 0; i < c2; ++i) {
                    final int b6 = bv.b(motionEvent, i);
                    final float c3 = bv.c(motionEvent, i);
                    final float d2 = bv.d(motionEvent, i);
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
                this.c(bv.b(motionEvent, b));
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
            final dw r = this.r;
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
        final int a = bv.a(motionEvent);
        final int b = bv.b(motionEvent);
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
                final int b2 = bv.b(motionEvent, 0);
                final View b3 = this.b((int)x, (int)y);
                this.a(x, y, b2);
                this.b(b3, b2);
                if ((this.h[b2] & this.p) != 0x0) {
                    final dw r = this.r;
                    final int p = this.p;
                    r.c();
                    return;
                }
                break;
            }
            case 5: {
                final int b4 = bv.b(motionEvent, b);
                final float c = bv.c(motionEvent, b);
                final float d = bv.d(motionEvent, b);
                this.a(c, d, b4);
                if (this.a == 0) {
                    this.b(this.b((int)c, (int)d), b4);
                    if ((this.h[b4] & this.p) != 0x0) {
                        final dw r2 = this.r;
                        final int p2 = this.p;
                        r2.c();
                        return;
                    }
                    break;
                }
                else {
                    final int n = (int)c;
                    final int n2 = (int)d;
                    final View s = this.s;
                    boolean b5 = false;
                    if (s != null) {
                        final int left = s.getLeft();
                        b5 = false;
                        if (n >= left) {
                            final int right = s.getRight();
                            b5 = false;
                            if (n < right) {
                                final int top = s.getTop();
                                b5 = false;
                                if (n2 >= top) {
                                    final int bottom = s.getBottom();
                                    b5 = false;
                                    if (n2 < bottom) {
                                        b5 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (b5) {
                        this.b(this.s, b4);
                        return;
                    }
                    break;
                }
                break;
            }
            case 2: {
                if (this.a == 1) {
                    final int a2 = bv.a(motionEvent, this.c);
                    final float c2 = bv.c(motionEvent, a2);
                    final float d2 = bv.d(motionEvent, a2);
                    final int n3 = (int)(c2 - this.f[this.c]);
                    final int n4 = (int)(d2 - this.g[this.c]);
                    int b6 = n3 + this.s.getLeft();
                    this.s.getTop();
                    final int left2 = this.s.getLeft();
                    final int top2 = this.s.getTop();
                    if (n3 != 0) {
                        b6 = this.r.b(this.s, b6);
                        this.s.offsetLeftAndRight(b6 - left2);
                    }
                    if (n4 != 0) {
                        this.s.offsetTopAndBottom(this.r.d(this.s) - top2);
                    }
                    if (n3 != 0 || n4 != 0) {
                        this.r.a(this.s, b6);
                    }
                    this.c(motionEvent);
                    return;
                }
                while (i < bv.c(motionEvent)) {
                    final int b7 = bv.b(motionEvent, i);
                    final float c3 = bv.c(motionEvent, i);
                    final float d3 = bv.d(motionEvent, i);
                    final float n5 = c3 - this.d[b7];
                    this.b(n5, d3 - this.e[b7], b7);
                    if (this.a == 1) {
                        break;
                    }
                    final View b8 = this.b((int)c3, (int)d3);
                    if (this.a(b8, n5) && this.b(b8, b7)) {
                        break;
                    }
                    ++i;
                }
                this.c(motionEvent);
            }
            case 6: {
                final int b9 = bv.b(motionEvent, b);
                Label_0733: {
                    if (this.a == 1 && b9 == this.c) {
                        while (true) {
                            while (i < bv.c(motionEvent)) {
                                final int b10 = bv.b(motionEvent, i);
                                if (b10 != this.c && this.b((int)bv.c(motionEvent, i), (int)bv.d(motionEvent, i)) == this.s && this.b(this.s, b10)) {
                                    final int c4 = this.c;
                                    if (c4 == -1) {
                                        this.h();
                                    }
                                    break Label_0733;
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
                this.c(b9);
            }
            case 1: {
                if (this.a == 1) {
                    this.h();
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
    
    public final boolean f() {
        if (this.a == 2) {
            final dn q = this.q;
            boolean b = q.b.d(q.a);
            final dn q2 = this.q;
            final int b2 = q2.b.b(q2.a);
            final dn q3 = this.q;
            final int c = q3.b.c(q3.a);
            final int n = b2 - this.s.getLeft();
            final int n2 = c - this.s.getTop();
            if (n != 0) {
                this.s.offsetLeftAndRight(n);
            }
            if (n2 != 0) {
                this.s.offsetTopAndBottom(n2);
            }
            if (n != 0 || n2 != 0) {
                this.r.a(this.s, b2);
            }
            if (b) {
                final dn q4 = this.q;
                if (b2 == q4.b.f(q4.a)) {
                    final dn q5 = this.q;
                    if (c == q5.b.g(q5.a)) {
                        this.q.a();
                        final dn q6 = this.q;
                        b = q6.b.a(q6.a);
                    }
                }
            }
            if (!b) {
                this.u.post(this.w);
            }
        }
        return this.a == 2;
    }
    
    public final boolean g() {
        int n = 1;
        for (int length = this.d.length, i = 0; i < length; ++i) {
            int n2;
            if ((this.k & n << i) != 0x0) {
                n2 = n;
            }
            else {
                n2 = 0;
            }
            int n5;
            if (n2 != 0) {
                final float n3 = this.f[i] - this.d[i];
                final float n4 = this.g[i] - this.e[i];
                if (n3 * n3 + n4 * n4 > this.b * this.b) {
                    n5 = n;
                }
                else {
                    n5 = 0;
                }
            }
            else {
                n5 = 0;
            }
            if (n5 != 0) {
                return n != 0;
            }
        }
        n = 0;
        return n != 0;
    }
}
