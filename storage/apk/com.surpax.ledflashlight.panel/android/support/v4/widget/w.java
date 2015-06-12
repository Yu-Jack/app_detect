// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.support.v4.view.ah;
import android.view.animation.AnimationUtils;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.graphics.RectF;
import android.graphics.Paint;
import android.view.animation.Interpolator;

final class w
{
    private static final Interpolator a;
    private final Paint b;
    private final RectF c;
    private float d;
    private long e;
    private long f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private View l;
    private Rect m;
    
    static {
        a = (Interpolator)android.support.v4.widget.a.a();
    }
    
    public w(final View l) {
        this.b = new Paint();
        this.c = new RectF();
        this.m = new Rect();
        this.l = l;
        this.h = -1291845632;
        this.i = Integer.MIN_VALUE;
        this.j = 1291845632;
        this.k = 436207616;
    }
    
    private void a(final Canvas canvas, final float n, final float n2, final int color, final float n3) {
        this.b.setColor(color);
        canvas.save();
        canvas.translate(n, n2);
        final float interpolation = w.a.getInterpolation(n3);
        canvas.scale(interpolation, interpolation);
        canvas.drawCircle(0.0f, 0.0f, n, this.b);
        canvas.restore();
    }
    
    private void a(final Canvas canvas, final int n, final int n2) {
        this.b.setColor(this.h);
        canvas.drawCircle((float)n, (float)n2, n * this.d, this.b);
    }
    
    final void a() {
        if (!this.g) {
            this.d = 0.0f;
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.g = true;
            this.l.postInvalidate();
        }
    }
    
    final void a(final float d) {
        this.d = d;
        this.e = 0L;
        ah.c(this.l);
    }
    
    final void a(final int right, final int bottom) {
        this.m.left = 0;
        this.m.top = 0;
        this.m.right = right;
        this.m.bottom = bottom;
    }
    
    final void a(final Canvas canvas) {
        final int width = this.m.width();
        final int height = this.m.height();
        final int n = width / 2;
        final int n2 = height / 2;
        int save = canvas.save();
        canvas.clipRect(this.m);
        if (this.g || this.f > 0L) {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            final long n3 = (currentAnimationTimeMillis - this.e) % 2000L;
            final long n4 = (currentAnimationTimeMillis - this.e) / 2000L;
            final float n5 = n3 / 20.0f;
            boolean b;
            if (!this.g) {
                if (currentAnimationTimeMillis - this.f >= 1000L) {
                    this.f = 0L;
                    return;
                }
                final float n6 = n * w.a.getInterpolation((currentAnimationTimeMillis - this.f) % 1000L / 10.0f / 100.0f);
                this.c.set(n - n6, 0.0f, n6 + n, (float)height);
                canvas.saveLayerAlpha(this.c, 0, 0);
                b = true;
            }
            else {
                b = false;
            }
            if (n4 == 0L) {
                canvas.drawColor(this.h);
            }
            else if (n5 >= 0.0f && n5 < 25.0f) {
                canvas.drawColor(this.k);
            }
            else if (n5 >= 25.0f && n5 < 50.0f) {
                canvas.drawColor(this.h);
            }
            else if (n5 >= 50.0f && n5 < 75.0f) {
                canvas.drawColor(this.i);
            }
            else {
                canvas.drawColor(this.j);
            }
            if (n5 >= 0.0f && n5 <= 25.0f) {
                this.a(canvas, n, n2, this.h, 2.0f * (25.0f + n5) / 100.0f);
            }
            if (n5 >= 0.0f && n5 <= 50.0f) {
                this.a(canvas, n, n2, this.i, 2.0f * n5 / 100.0f);
            }
            if (n5 >= 25.0f && n5 <= 75.0f) {
                this.a(canvas, n, n2, this.j, 2.0f * (n5 - 25.0f) / 100.0f);
            }
            if (n5 >= 50.0f && n5 <= 100.0f) {
                this.a(canvas, n, n2, this.k, 2.0f * (n5 - 50.0f) / 100.0f);
            }
            if (n5 >= 75.0f && n5 <= 100.0f) {
                this.a(canvas, n, n2, this.h, 2.0f * (n5 - 75.0f) / 100.0f);
            }
            int save2;
            if (this.d > 0.0f && b) {
                canvas.restoreToCount(save);
                save2 = canvas.save();
                canvas.clipRect(this.m);
                this.a(canvas, n, n2);
            }
            else {
                save2 = save;
            }
            ah.c(this.l);
            save = save2;
        }
        else if (this.d > 0.0f && this.d <= 1.0) {
            this.a(canvas, n, n2);
        }
        canvas.restoreToCount(save);
    }
    
    final void b() {
        if (this.g) {
            this.d = 0.0f;
            this.f = AnimationUtils.currentAnimationTimeMillis();
            this.g = false;
            this.l.postInvalidate();
        }
    }
}
