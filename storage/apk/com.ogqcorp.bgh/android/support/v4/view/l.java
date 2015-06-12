// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.VelocityTracker;
import android.view.MotionEvent;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.GestureDetector$OnGestureListener;
import android.os.Handler;

class l implements k
{
    private static final int e;
    private static final int f;
    private static final int g;
    private int a;
    private int b;
    private int c;
    private int d;
    private final Handler h;
    private final GestureDetector$OnGestureListener i;
    private GestureDetector$OnDoubleTapListener j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private MotionEvent p;
    private MotionEvent q;
    private boolean r;
    private float s;
    private float t;
    private float u;
    private float v;
    private boolean w;
    private VelocityTracker x;
    
    static {
        e = ViewConfiguration.getLongPressTimeout();
        f = ViewConfiguration.getTapTimeout();
        g = ViewConfiguration.getDoubleTapTimeout();
    }
    
    public l(final Context context, final GestureDetector$OnGestureListener i, final Handler handler) {
        if (handler != null) {
            this.h = new m(this, handler);
        }
        else {
            this.h = new m(this);
        }
        this.i = i;
        if (i instanceof GestureDetector$OnDoubleTapListener) {
            this.a((GestureDetector$OnDoubleTapListener)i);
        }
        this.a(context);
    }
    
    private void a() {
        this.h.removeMessages(1);
        this.h.removeMessages(2);
        this.h.removeMessages(3);
        this.x.recycle();
        this.x = null;
        this.r = false;
        this.k = false;
        this.n = false;
        this.o = false;
        this.l = false;
        if (this.m) {
            this.m = false;
        }
    }
    
    private void a(final Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (this.i == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        }
        this.w = true;
        final ViewConfiguration value = ViewConfiguration.get(context);
        final int scaledTouchSlop = value.getScaledTouchSlop();
        final int scaledDoubleTapSlop = value.getScaledDoubleTapSlop();
        this.c = value.getScaledMinimumFlingVelocity();
        this.d = value.getScaledMaximumFlingVelocity();
        this.a = scaledTouchSlop * scaledTouchSlop;
        this.b = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }
    
    private boolean a(final MotionEvent motionEvent, final MotionEvent motionEvent2, final MotionEvent motionEvent3) {
        if (this.o && motionEvent3.getEventTime() - motionEvent2.getEventTime() <= android.support.v4.view.l.g) {
            final int n = (int)motionEvent.getX() - (int)motionEvent3.getX();
            final int n2 = (int)motionEvent.getY() - (int)motionEvent3.getY();
            if (n * n + n2 * n2 < this.b) {
                return true;
            }
        }
        return false;
    }
    
    private void b() {
        this.h.removeMessages(1);
        this.h.removeMessages(2);
        this.h.removeMessages(3);
        this.r = false;
        this.n = false;
        this.o = false;
        this.l = false;
        if (this.m) {
            this.m = false;
        }
    }
    
    private void c() {
        this.h.removeMessages(3);
        this.l = false;
        this.m = true;
        this.i.onLongPress(this.p);
    }
    
    public void a(final GestureDetector$OnDoubleTapListener j) {
        this.j = j;
    }
    
    @Override
    public void a(final boolean w) {
        this.w = w;
    }
    
    @Override
    public boolean a(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (this.x == null) {
            this.x = VelocityTracker.obtain();
        }
        this.x.addMovement(motionEvent);
        boolean b;
        if ((action & 0xFF) == 0x6) {
            b = true;
        }
        else {
            b = false;
        }
        int b2;
        if (b) {
            b2 = aa.b(motionEvent);
        }
        else {
            b2 = -1;
        }
        final int c = aa.c(motionEvent);
        int i = 0;
        float n = 0.0f;
        float n2 = 0.0f;
        while (i < c) {
            if (b2 != i) {
                n2 += aa.c(motionEvent, i);
                n += aa.d(motionEvent, i);
            }
            ++i;
        }
        int n3;
        if (b) {
            n3 = c - 1;
        }
        else {
            n3 = c;
        }
        final float n4 = n2 / n3;
        final float n5 = n / n3;
        switch (action & 0xFF) {
            case 5: {
                this.s = n4;
                this.u = n4;
                this.t = n5;
                this.v = n5;
                this.b();
                return false;
            }
            case 6: {
                this.s = n4;
                this.u = n4;
                this.t = n5;
                this.v = n5;
                this.x.computeCurrentVelocity(1000, (float)this.d);
                final int b3 = aa.b(motionEvent);
                final int b4 = aa.b(motionEvent, b3);
                final float a = ag.a(this.x, b4);
                final float b5 = ag.b(this.x, b4);
                for (int j = 0; j < c; ++j) {
                    if (j != b3) {
                        final int b6 = aa.b(motionEvent, j);
                        if (a * ag.a(this.x, b6) + b5 * ag.b(this.x, b6) < 0.0f) {
                            this.x.clear();
                            return false;
                        }
                    }
                }
                break;
            }
            case 0: {
                while (true) {
                    Label_0634: {
                        if (this.j == null) {
                            break Label_0634;
                        }
                        final boolean hasMessages = this.h.hasMessages(3);
                        if (hasMessages) {
                            this.h.removeMessages(3);
                        }
                        if (this.p == null || this.q == null || !hasMessages || !this.a(this.p, this.q, motionEvent)) {
                            this.h.sendEmptyMessageDelayed(3, (long)android.support.v4.view.l.g);
                            break Label_0634;
                        }
                        this.r = true;
                        final boolean b7 = false | this.j.onDoubleTap(this.p) | this.j.onDoubleTapEvent(motionEvent);
                        this.s = n4;
                        this.u = n4;
                        this.t = n5;
                        this.v = n5;
                        if (this.p != null) {
                            this.p.recycle();
                        }
                        this.p = MotionEvent.obtain(motionEvent);
                        this.n = true;
                        this.o = true;
                        this.k = true;
                        this.m = false;
                        this.l = false;
                        if (this.w) {
                            this.h.removeMessages(2);
                            this.h.sendEmptyMessageAtTime(2, this.p.getDownTime() + android.support.v4.view.l.f + android.support.v4.view.l.e);
                        }
                        this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + android.support.v4.view.l.f);
                        return b7 | this.i.onDown(motionEvent);
                    }
                    final boolean b7 = false;
                    continue;
                }
            }
            case 2: {
                if (this.m) {
                    break;
                }
                final float a2 = this.s - n4;
                final float a3 = this.t - n5;
                if (this.r) {
                    return false | this.j.onDoubleTapEvent(motionEvent);
                }
                if (this.n) {
                    final int n6 = (int)(n4 - this.u);
                    final int n7 = (int)(n5 - this.v);
                    final int n8 = n6 * n6 + n7 * n7;
                    boolean onScroll;
                    if (n8 > this.a) {
                        onScroll = this.i.onScroll(this.p, motionEvent, a2, a3);
                        this.s = n4;
                        this.t = n5;
                        this.n = false;
                        this.h.removeMessages(3);
                        this.h.removeMessages(1);
                        this.h.removeMessages(2);
                    }
                    else {
                        onScroll = false;
                    }
                    if (n8 > this.a) {
                        this.o = false;
                    }
                    return onScroll;
                }
                if (Math.abs(a2) >= 1.0f || Math.abs(a3) >= 1.0f) {
                    final boolean onScroll2 = this.i.onScroll(this.p, motionEvent, a2, a3);
                    this.s = n4;
                    this.t = n5;
                    return onScroll2;
                }
                break;
            }
            case 1: {
                this.k = false;
                final MotionEvent obtain = MotionEvent.obtain(motionEvent);
                boolean onSingleTapUp;
                if (this.r) {
                    onSingleTapUp = (false | this.j.onDoubleTapEvent(motionEvent));
                }
                else if (this.m) {
                    this.h.removeMessages(3);
                    this.m = false;
                    onSingleTapUp = false;
                }
                else if (this.n) {
                    onSingleTapUp = this.i.onSingleTapUp(motionEvent);
                    if (this.l && this.j != null) {
                        this.j.onSingleTapConfirmed(motionEvent);
                    }
                }
                else {
                    final VelocityTracker x = this.x;
                    final int b8 = aa.b(motionEvent, 0);
                    x.computeCurrentVelocity(1000, (float)this.d);
                    final float b9 = ag.b(x, b8);
                    final float a4 = ag.a(x, b8);
                    onSingleTapUp = ((Math.abs(b9) > this.c || Math.abs(a4) > this.c) && this.i.onFling(this.p, motionEvent, a4, b9));
                }
                if (this.q != null) {
                    this.q.recycle();
                }
                this.q = obtain;
                if (this.x != null) {
                    this.x.recycle();
                    this.x = null;
                }
                this.r = false;
                this.l = false;
                this.h.removeMessages(1);
                this.h.removeMessages(2);
                return onSingleTapUp;
            }
            case 3: {
                this.a();
                return false;
            }
        }
        return false;
    }
}
