// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Paint;

public class PagerTabStrip extends PagerTitleStrip
{
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final Paint l;
    private final Rect m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private float s;
    private float t;
    private int u;
    
    public PagerTabStrip(final Context context, final AttributeSet set) {
        super(context, set);
        this.l = new Paint();
        this.m = new Rect();
        this.n = 255;
        this.o = false;
        this.p = false;
        this.f = this.e;
        this.l.setColor(this.f);
        final float density = context.getResources().getDisplayMetrics().density;
        this.g = (int)(0.5f + 3.0f * density);
        this.h = (int)(0.5f + 6.0f * density);
        this.i = (int)(64.0f * density);
        this.k = (int)(0.5f + 16.0f * density);
        this.q = (int)(0.5f + 1.0f * density);
        this.j = (int)(0.5f + density * 32.0f);
        this.u = ViewConfiguration.get(context).getScaledTouchSlop();
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        this.a(this.b());
        this.setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public final void onClick(final View view) {
                PagerTabStrip.this.a.a(-1 + PagerTabStrip.this.a.b());
            }
        });
        this.d.setFocusable(true);
        this.d.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public final void onClick(final View view) {
                PagerTabStrip.this.a.a(1 + PagerTabStrip.this.a.b());
            }
        });
        if (this.getBackground() == null) {
            this.o = true;
        }
    }
    
    @Override
    final int a() {
        return Math.max(super.a(), this.j);
    }
    
    @Override
    public final void a(int i) {
        if (i < this.i) {
            i = this.i;
        }
        super.a(i);
    }
    
    @Override
    final void a(final int n, final float n2, final boolean b) {
        final Rect m = this.m;
        final int height = this.getHeight();
        final int n3 = this.c.getLeft() - this.k;
        final int n4 = this.c.getRight() + this.k;
        final int n5 = height - this.g;
        m.set(n3, n5, n4, height);
        super.a(n, n2, b);
        this.n = (int)(255.0f * (2.0f * Math.abs(n2 - 0.5f)));
        m.union(this.c.getLeft() - this.k, n5, this.c.getRight() + this.k, height);
        this.invalidate(m);
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        final int height = this.getHeight();
        final int n = this.c.getLeft() - this.k;
        final int n2 = this.c.getRight() + this.k;
        final int n3 = height - this.g;
        this.l.setColor(this.n << 24 | (0xFFFFFF & this.f));
        canvas.drawRect((float)n, (float)n3, (float)n2, (float)height, this.l);
        if (this.o) {
            this.l.setColor(0xFF000000 | (0xFFFFFF & this.f));
            canvas.drawRect((float)this.getPaddingLeft(), (float)(height - this.q), (float)(this.getWidth() - this.getPaddingRight()), (float)height, this.l);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (action != 0 && this.r) {
            return false;
        }
        final float x = motionEvent.getX();
        final float y = motionEvent.getY();
        switch (action) {
            case 0: {
                this.s = x;
                this.t = y;
                this.r = false;
                break;
            }
            case 2: {
                if (Math.abs(x - this.s) > this.u || Math.abs(y - this.t) > this.u) {
                    this.r = true;
                    break;
                }
                break;
            }
            case 1: {
                if (x < this.c.getLeft() - this.k) {
                    this.a.a(-1 + this.a.b());
                    break;
                }
                if (x > this.c.getRight() + this.k) {
                    this.a.a(1 + this.a.b());
                    break;
                }
                break;
            }
        }
        return true;
    }
    
    public void setBackgroundColor(final int backgroundColor) {
        super.setBackgroundColor(backgroundColor);
        if (!this.p) {
            this.o = ((0xFF000000 & backgroundColor) == 0x0);
        }
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        if (!this.p) {
            this.o = (backgroundDrawable == null);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        if (!this.p) {
            this.o = (backgroundResource == 0);
        }
    }
    
    public void setPadding(final int n, final int n2, final int n3, int h) {
        if (h < this.h) {
            h = this.h;
        }
        super.setPadding(n, n2, n3, h);
    }
}
