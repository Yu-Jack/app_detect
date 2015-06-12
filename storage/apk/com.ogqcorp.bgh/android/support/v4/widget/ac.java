// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.support.v4.view.ag;
import java.util.Arrays;
import android.support.v4.view.aa;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.View;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public class ac
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
    private o q;
    private final ad r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w;
    
    static {
        v = (Interpolator)new Interpolator() {
            public float getInterpolation(final float n) {
                final float n2 = n - 1.0f;
                return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
            }
        };
    }
    
    private float a(final float n) {
        return (float)Math.sin((float)(0.4712389167638204 * (n - 0.5f)));
    }
    
    private float a(final float a, final float n, float n2) {
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
        final float n4 = n3 + n3 * this.a(Math.min(1.0f, Math.abs(n) / width));
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
    
    private int a(final View view, final int a, final int a2, final int n, final int n2) {
        final int b = this.b(n, (int)this.n, (int)this.m);
        final int b2 = this.b(n2, (int)this.n, (int)this.m);
        final int abs = Math.abs(a);
        final int abs2 = Math.abs(a2);
        final int abs3 = Math.abs(b);
        final int abs4 = Math.abs(b2);
        final int n3 = abs3 + abs4;
        final int n4 = abs + abs2;
        float n5;
        if (b != 0) {
            n5 = abs3 / n3;
        }
        else {
            n5 = abs / n4;
        }
        float n6;
        if (b2 != 0) {
            n6 = abs4 / n3;
        }
        else {
            n6 = abs2 / n4;
        }
        return (int)(n5 * this.a(a, b, this.r.a(view)) + n6 * this.a(a2, b2, this.r.b(view)));
    }
    
    private void a(final float n, final float n2) {
        this.t = true;
        this.r.a(this.s, n, n2);
        this.t = false;
        if (this.a == 1) {
            this.b(0);
        }
    }
    
    private void a(final float n, final float n2, final int n3) {
        this.e(n3);
        this.d[n3] = (this.f[n3] = n);
        this.e[n3] = (this.g[n3] = n2);
        this.h[n3] = this.e((int)n, (int)n2);
        this.k |= 1 << n3;
    }
    
    private boolean a(final float a, final float a2, final int n, final int n2) {
        final float abs = Math.abs(a);
        final float abs2 = Math.abs(a2);
        if ((n2 & this.h[n]) == n2 && (n2 & this.p) != 0x0 && (n2 & this.j[n]) != n2 && (n2 & this.i[n]) != n2 && (abs > this.b || abs2 > this.b)) {
            if (abs < abs2 * 0.5f && this.r.b(n2)) {
                final int[] j = this.j;
                j[n] |= n2;
                return false;
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
        final int n5 = n - left;
        final int n6 = n2 - top;
        if (n5 == 0 && n6 == 0) {
            this.q.h();
            this.b(0);
            return false;
        }
        this.q.a(left, top, n5, n6, this.a(this.s, n5, n6, n3, n4));
        this.b(2);
        return true;
    }
    
    private boolean a(final View view, final float a, final float a2) {
        boolean b = true;
        if (view == null) {
            b = false;
        }
        else {
            final boolean b2 = this.r.a(view) > 0 && b;
            final boolean b3 = this.r.b(view) > 0 && b;
            if (b2 && b3) {
                if (a * a + a2 * a2 <= this.b * this.b) {
                    return false;
                }
            }
            else if (b2) {
                if (Math.abs(a) <= this.b) {
                    return false;
                }
            }
            else {
                if (!b3) {
                    return false;
                }
                if (Math.abs(a2) <= this.b) {
                    return false;
                }
            }
        }
        return b;
    }
    
    private int b(final int a, final int n, int n2) {
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
            this.r.b(n4, n3);
        }
    }
    
    private void b(final int n, final int n2, final int n3, final int n4) {
        final int left = this.s.getLeft();
        final int top = this.s.getTop();
        int a;
        if (n3 != 0) {
            a = this.r.a(this.s, n, n3);
            this.s.offsetLeftAndRight(a - left);
        }
        else {
            a = n;
        }
        int b;
        if (n4 != 0) {
            b = this.r.b(this.s, n2, n4);
            this.s.offsetTopAndBottom(b - top);
        }
        else {
            b = n2;
        }
        if (n3 != 0 || n4 != 0) {
            this.r.a(this.s, a, b, a - left, b - top);
        }
    }
    
    private void c(final MotionEvent motionEvent) {
        for (int c = aa.c(motionEvent), i = 0; i < c; ++i) {
            final int b = aa.b(motionEvent, i);
            final float c2 = aa.c(motionEvent, i);
            final float d = aa.d(motionEvent, i);
            this.f[b] = c2;
            this.g[b] = d;
        }
    }
    
    private void d(final int n) {
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
    
    private int e(final int n, final int n2) {
        final int n3 = this.u.getLeft() + this.o;
        int n4 = 0;
        if (n < n3) {
            n4 = 1;
        }
        if (n2 < this.u.getTop() + this.o) {
            n4 |= 0x4;
        }
        if (n > this.u.getRight() - this.o) {
            n4 |= 0x2;
        }
        if (n2 > this.u.getBottom() - this.o) {
            n4 |= 0x8;
        }
        return n4;
    }
    
    private void e(final int n) {
        if (this.d == null || this.d.length <= n) {
            final float[] d = new float[n + 1];
            final float[] e = new float[n + 1];
            final float[] f = new float[n + 1];
            final float[] g = new float[n + 1];
            final int[] h = new int[n + 1];
            final int[] i = new int[n + 1];
            final int[] j = new int[n + 1];
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
    }
    
    private void g() {
        if (this.d == null) {
            return;
        }
        Arrays.fill(this.d, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }
    
    private void h() {
        this.l.computeCurrentVelocity(1000, this.m);
        this.a(this.a(ag.a(this.l, this.c), this.n, this.m), this.a(ag.b(this.l, this.c), this.n, this.m));
    }
    
    public int a() {
        return this.a;
    }
    
    public void a(final View s, final int c) {
        if (s.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = s;
        this.c = c;
        this.r.b(s, c);
        this.b(1);
    }
    
    public boolean a(final int n) {
        return (this.k & 1 << n) != 0x0;
    }
    
    public boolean a(final int n, final int n2) {
        if (!this.t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return this.a(n, n2, (int)ag.a(this.l, this.c), (int)ag.b(this.l, this.c));
    }
    
    public boolean a(final MotionEvent motionEvent) {
        final int a = aa.a(motionEvent);
        final int b = aa.b(motionEvent);
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
                final int b2 = aa.b(motionEvent, 0);
                this.a(x, y, b2);
                final View d = this.d((int)x, (int)y);
                if (d == this.s && this.a == 2) {
                    this.b(d, b2);
                }
                final int n = this.h[b2];
                if ((n & this.p) != 0x0) {
                    this.r.a(n & this.p, b2);
                    break;
                }
                break;
            }
            case 5: {
                final int b3 = aa.b(motionEvent, b);
                final float c = aa.c(motionEvent, b);
                final float d2 = aa.d(motionEvent, b);
                this.a(c, d2, b3);
                if (this.a == 0) {
                    final int n2 = this.h[b3];
                    if ((n2 & this.p) != 0x0) {
                        this.r.a(n2 & this.p, b3);
                        break;
                    }
                    break;
                }
                else {
                    if (this.a != 2) {
                        break;
                    }
                    final View d3 = this.d((int)c, (int)d2);
                    if (d3 == this.s) {
                        this.b(d3, b3);
                        break;
                    }
                    break;
                }
                break;
            }
            case 2: {
                for (int c2 = aa.c(motionEvent), i = 0; i < c2; ++i) {
                    final int b4 = aa.b(motionEvent, i);
                    final float c3 = aa.c(motionEvent, i);
                    final float d4 = aa.d(motionEvent, i);
                    final float n3 = c3 - this.d[b4];
                    final float n4 = d4 - this.e[b4];
                    this.b(n3, n4, b4);
                    if (this.a == 1) {
                        break;
                    }
                    final View d5 = this.d((int)c3, (int)d4);
                    if (d5 != null && this.a(d5, n3, n4) && this.b(d5, b4)) {
                        break;
                    }
                }
                this.c(motionEvent);
                break;
            }
            case 6: {
                this.d(aa.b(motionEvent, b));
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
    
    public boolean a(final View s, final int n, final int n2) {
        this.s = s;
        this.c = -1;
        return this.a(n, n2, 0, 0);
    }
    
    public boolean a(final boolean b) {
        if (this.a == 2) {
            final boolean g = this.q.g();
            final int b2 = this.q.b();
            final int c = this.q.c();
            final int n = b2 - this.s.getLeft();
            final int n2 = c - this.s.getTop();
            if (n != 0) {
                this.s.offsetLeftAndRight(n);
            }
            if (n2 != 0) {
                this.s.offsetTopAndBottom(n2);
            }
            if (n != 0 || n2 != 0) {
                this.r.a(this.s, b2, c, n, n2);
            }
            boolean a;
            if (g && b2 == this.q.d() && c == this.q.e()) {
                this.q.h();
                a = this.q.a();
            }
            else {
                a = g;
            }
            if (!a) {
                if (b) {
                    this.u.post(this.w);
                }
                else {
                    this.b(0);
                }
            }
        }
        return this.a == 2;
    }
    
    public int b() {
        return this.o;
    }
    
    void b(final int a) {
        if (this.a != a) {
            this.a = a;
            this.r.a(a);
            if (a == 0) {
                this.s = null;
            }
        }
    }
    
    public void b(final MotionEvent motionEvent) {
        int i = 0;
        final int a = aa.a(motionEvent);
        final int b = aa.b(motionEvent);
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
                final int b2 = aa.b(motionEvent, 0);
                final View d = this.d((int)x, (int)y);
                this.a(x, y, b2);
                this.b(d, b2);
                final int n = this.h[b2];
                if ((n & this.p) != 0x0) {
                    this.r.a(n & this.p, b2);
                    return;
                }
                break;
            }
            case 5: {
                final int b3 = aa.b(motionEvent, b);
                final float c = aa.c(motionEvent, b);
                final float d2 = aa.d(motionEvent, b);
                this.a(c, d2, b3);
                if (this.a == 0) {
                    this.b(this.d((int)c, (int)d2), b3);
                    final int n2 = this.h[b3];
                    if ((n2 & this.p) != 0x0) {
                        this.r.a(n2 & this.p, b3);
                        return;
                    }
                    break;
                }
                else {
                    if (this.c((int)c, (int)d2)) {
                        this.b(this.s, b3);
                        return;
                    }
                    break;
                }
                break;
            }
            case 2: {
                if (this.a == 1) {
                    final int a2 = aa.a(motionEvent, this.c);
                    final float c2 = aa.c(motionEvent, a2);
                    final float d3 = aa.d(motionEvent, a2);
                    final int n3 = (int)(c2 - this.f[this.c]);
                    final int n4 = (int)(d3 - this.g[this.c]);
                    this.b(n3 + this.s.getLeft(), n4 + this.s.getTop(), n3, n4);
                    this.c(motionEvent);
                    return;
                }
                while (i < aa.c(motionEvent)) {
                    final int b4 = aa.b(motionEvent, i);
                    final float c3 = aa.c(motionEvent, i);
                    final float d4 = aa.d(motionEvent, i);
                    final float n5 = c3 - this.d[b4];
                    final float n6 = d4 - this.e[b4];
                    this.b(n5, n6, b4);
                    if (this.a == 1) {
                        break;
                    }
                    final View d5 = this.d((int)c3, (int)d4);
                    if (this.a(d5, n5, n6) && this.b(d5, b4)) {
                        break;
                    }
                    ++i;
                }
                this.c(motionEvent);
            }
            case 6: {
                final int b5 = aa.b(motionEvent, b);
                Label_0634: {
                    if (this.a == 1 && b5 == this.c) {
                        while (true) {
                            while (i < aa.c(motionEvent)) {
                                final int b6 = aa.b(motionEvent, i);
                                if (b6 != this.c && this.d((int)aa.c(motionEvent, i), (int)aa.d(motionEvent, i)) == this.s && this.b(this.s, b6)) {
                                    final int c4 = this.c;
                                    if (c4 == -1) {
                                        this.h();
                                    }
                                    break Label_0634;
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
                this.d(b5);
            }
            case 1: {
                if (this.a == 1) {
                    this.h();
                }
                this.e();
            }
            case 3: {
                if (this.a == 1) {
                    this.a(0.0f, 0.0f);
                }
                this.e();
            }
        }
    }
    
    public boolean b(final int n, final int n2) {
        boolean b = true;
        if (!this.a(n2)) {
            b = false;
        }
        else {
            final boolean b2 = (n & 0x1) == (b ? 1 : 0) && b;
            final boolean b3 = (n & 0x2) == 0x2 && b;
            final float a = this.f[n2] - this.d[n2];
            final float a2 = this.g[n2] - this.e[n2];
            if (b2 && b3) {
                if (a * a + a2 * a2 <= this.b * this.b) {
                    return false;
                }
            }
            else if (b2) {
                if (Math.abs(a) <= this.b) {
                    return false;
                }
            }
            else {
                if (!b3) {
                    return false;
                }
                if (Math.abs(a2) <= this.b) {
                    return false;
                }
            }
        }
        return b;
    }
    
    boolean b(final View view, final int c) {
        if (view == this.s && this.c == c) {
            return true;
        }
        if (view != null && this.r.a(view, c)) {
            this.a(view, this.c = c);
            return true;
        }
        return false;
    }
    
    public boolean b(final View view, final int n, final int n2) {
        return view != null && n >= view.getLeft() && n < view.getRight() && n2 >= view.getTop() && n2 < view.getBottom();
    }
    
    public View c() {
        return this.s;
    }
    
    public boolean c(final int n) {
        final int length = this.d.length;
        int n2 = 0;
        boolean b;
        while (true) {
            b = false;
            if (n2 >= length) {
                break;
            }
            if (this.b(n, n2)) {
                b = true;
                break;
            }
            ++n2;
        }
        return b;
    }
    
    public boolean c(final int n, final int n2) {
        return this.b(this.s, n, n2);
    }
    
    public int d() {
        return this.b;
    }
    
    public View d(final int n, final int n2) {
        for (int i = -1 + this.u.getChildCount(); i >= 0; --i) {
            final View child = this.u.getChildAt(this.r.c(i));
            if (n >= child.getLeft() && n < child.getRight() && n2 >= child.getTop() && n2 < child.getBottom()) {
                return child;
            }
        }
        return null;
    }
    
    public void e() {
        this.c = -1;
        this.g();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }
    
    public void f() {
        this.e();
        if (this.a == 2) {
            final int b = this.q.b();
            final int c = this.q.c();
            this.q.h();
            final int b2 = this.q.b();
            final int c2 = this.q.c();
            this.r.a(this.s, b2, c2, b2 - b, c2 - c);
        }
        this.b(0);
    }
}
