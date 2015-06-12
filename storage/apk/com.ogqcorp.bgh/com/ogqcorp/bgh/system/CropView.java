// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.MotionEvent;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Point;
import android.graphics.Paint;
import android.view.View;

public final class CropView extends View
{
    private Paint a;
    private Point b;
    private RectF c;
    private Rect d;
    private PointF e;
    private Float f;
    private Float g;
    private PointF h;
    
    public CropView(final Context context) {
        super(context);
        this.c = new RectF();
        this.d = new Rect();
        this.e = new PointF();
        this.a();
    }
    
    public CropView(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = new RectF();
        this.d = new Rect();
        this.e = new PointF();
        this.a();
    }
    
    public CropView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.c = new RectF();
        this.d = new Rect();
        this.e = new PointF();
        this.a();
    }
    
    private void a() {
        (this.a = new Paint()).setStyle(Paint$Style.STROKE);
        this.a.setStrokeWidth(4.0f);
        this.a.setColor(-33024);
    }
    
    private void b() {
        if (this.b != null && this.f != null && this.g != null) {
            final float viewRatio = this.getViewRatio();
            if (this.f > this.g) {
                this.c = new RectF(0.0f, 0.0f, viewRatio * (this.b.y * this.g / this.f), (float)this.b.y);
            }
            else {
                this.c = new RectF(0.0f, 0.0f, (float)this.b.x, this.b.x / this.g * this.f / viewRatio);
            }
            this.c.offsetTo(this.b.x / 2.0f - this.c.width() / 2.0f, this.b.y / 2.0f - this.c.height() / 2.0f);
        }
    }
    
    private float getViewRatio() {
        return this.b.x / this.b.y;
    }
    
    public void a(final float n, final float n2) {
        this.h = new PointF(n, n2);
        if (this.b != null) {
            this.c.offsetTo(n * this.b.x, n2 * this.b.y);
        }
    }
    
    public RectF getCropRect() {
        final RectF c = this.c;
        return new RectF(c.left / this.b.x, c.top / this.b.y, c.right / this.b.x, c.bottom / this.b.y);
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        this.d.set(2 + Math.round(this.c.left), 2 + Math.round(this.c.top), -2 + Math.round(this.c.right), -2 + Math.round(this.c.bottom));
        canvas.drawRect(this.d, this.a);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.b = new Point(this.getWidth(), this.getHeight());
        this.b();
        if (this.h != null) {
            this.c.offsetTo(this.h.x * this.b.x, this.h.y * this.b.y);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.getParent().requestDisallowInterceptTouchEvent(true);
            this.e.x = motionEvent.getRawX() - this.c.left;
            this.e.y = motionEvent.getRawY() - this.c.top;
        }
        else if (motionEvent.getAction() == 2) {
            final float rawX = motionEvent.getRawX();
            final float rawY = motionEvent.getRawY();
            final float n = this.b.x - this.c.width();
            if (rawX - this.e.x < 0.0f) {
                this.e.x = rawX;
            }
            else if (rawX - this.e.x > n) {
                this.e.x = rawX - n;
            }
            final float n2 = this.b.y - this.c.height();
            if (rawY - this.e.y < 0.0f) {
                this.e.y = rawY;
            }
            else if (rawY - this.e.y > n2) {
                this.e.y = rawY - n2;
            }
            this.c.offsetTo(rawX - this.e.x, rawY - this.e.y);
            this.invalidate();
            return true;
        }
        return true;
    }
    
    public void setCropRatio(final float f) {
        this.g = f;
        this.b();
        this.invalidate();
    }
    
    public void setOriginalRatio(final float f) {
        this.f = f;
        this.b();
        this.invalidate();
    }
}
