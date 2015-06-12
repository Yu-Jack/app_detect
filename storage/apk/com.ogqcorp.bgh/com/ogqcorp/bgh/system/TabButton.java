// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.text.TextPaint;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import com.ogqcorp.bgh.d;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

public final class TabButton extends CompoundButton
{
    private Drawable a;
    private int b;
    private String c;
    private Point d;
    
    public TabButton(final Context context) {
        super(context);
        this.a(context, null, 0);
    }
    
    public TabButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.a(context, set, 0);
    }
    
    public TabButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a(context, set, n);
    }
    
    private void a(final Context context, final AttributeSet set, final int n) {
        if (set != null) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, com.ogqcorp.bgh.d.tb__TabButton, n, 0);
            final int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            if (resourceId != -1) {
                this.setButtonIcon(resourceId);
            }
            if (this.a != null) {
                this.b = obtainStyledAttributes.getDimensionPixelSize(1, this.a.getIntrinsicHeight());
            }
            final int resourceId2 = obtainStyledAttributes.getResourceId(2, -1);
            if (resourceId2 != -1) {
                this.setButtonText(resourceId2);
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    private void a(final Canvas canvas) {
        if (this.a == null) {
            return;
        }
        final int n = (this.getWidth() >> 1) - (this.b >> 1);
        final int paddingTop = this.getPaddingTop();
        this.a.setBounds(new Rect(n, paddingTop, n + this.b, paddingTop + this.b));
        this.a.draw(canvas);
    }
    
    private void b(final Canvas canvas) {
        if (this.c == null) {
            return;
        }
        final TextPaint paint = this.getPaint();
        if (this.d == null) {
            final Rect rect = new Rect();
            paint.getTextBounds(this.c, 0, this.c.length(), rect);
            this.d = new Point();
            this.d.x = (this.getWidth() >> 1) - (rect.width() >> 1);
            this.d.y = this.getHeight() - this.getPaddingBottom();
        }
        paint.setColor(-1090519040);
        canvas.drawText(this.c, (float)(1 + this.d.x), (float)(1 + this.d.y), (Paint)paint);
        paint.setColor(-1);
        canvas.drawText(this.c, (float)(0 + this.d.x), (float)(0 + this.d.y), (Paint)paint);
    }
    
    private void setButtonIcon(final int n) {
        this.a = this.getResources().getDrawable(n);
        this.invalidate();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        this.a(canvas);
        this.b(canvas);
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        this.d = null;
        super.onSizeChanged(n, n2, n3, n4);
    }
    
    public void setButtonText(final int n) {
        this.c = this.getResources().getString(n);
        this.invalidate();
    }
}
