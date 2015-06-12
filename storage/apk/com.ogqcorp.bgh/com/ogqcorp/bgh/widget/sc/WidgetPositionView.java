// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc;

import android.view.MotionEvent;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import com.ogqcorp.bgh.widget.a.h;
import com.ogqcorp.bgh.widget.a.f;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Paint;
import android.graphics.RectF;
import com.ogqcorp.bgh.widget.a.e;

public class WidgetPositionView extends e
{
    private final RectF a;
    private final Paint b;
    private final Paint c;
    private final PointF d;
    
    public WidgetPositionView(final Context context, final AttributeSet set) {
        super(context, set);
        this.b = new Paint();
        this.c = new Paint();
        this.d = new PointF();
        this.a();
        final float c = f.a().c(context);
        final float d = f.a().d(context);
        this.a = new RectF(c, d, c + h.a(this.getContext(), 163.0f), d + h.a(this.getContext(), 100.0f));
    }
    
    private void a() {
        this.b.setStyle(Paint$Style.FILL);
        this.c.setStyle(Paint$Style.STROKE);
        this.c.setStrokeWidth(2.0f);
    }
    
    private void b() {
        f.a().a(this.getContext(), this.a.left);
        f.a().b(this.getContext(), this.a.top);
        com.ogqcorp.bgh.widget.sc.a.a(this.getContext());
    }
    
    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        this.c.setColor(-65409);
        canvas.drawRect(1.0f, 1.0f, (float)(-1 + this.getWidth()), (float)(-1 + this.getHeight()), this.c);
        this.a.inset(1.0f, 1.0f);
        this.b.setColor(1509916416);
        canvas.drawRect(this.a, this.b);
        this.c.setColor(-33024);
        canvas.drawRect(this.a, this.c);
        this.a.inset(-1.0f, -1.0f);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.d.set(motionEvent.getRawX() - this.a.left, motionEvent.getRawY() - this.a.top);
        }
        else if (motionEvent.getAction() == 2) {
            final float rawX = motionEvent.getRawX();
            final float rawY = motionEvent.getRawY();
            final float n = -100 + this.getWidth();
            if (rawX - this.d.x < 0.0f) {
                this.d.x = rawX;
            }
            else if (rawX - this.d.x > n) {
                this.d.x = rawX - n;
            }
            final float n2 = -100 + this.getHeight();
            if (rawY - this.d.y < 0.0f) {
                this.d.y = rawY;
            }
            else if (rawY - this.d.y > n2) {
                this.d.y = rawY - n2;
            }
            this.a.offsetTo(rawX - this.d.x, rawY - this.d.y);
            this.invalidate();
            this.b();
        }
        return true;
    }
}
