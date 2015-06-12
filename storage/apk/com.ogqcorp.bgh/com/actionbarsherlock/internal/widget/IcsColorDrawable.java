// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class IcsColorDrawable extends Drawable
{
    private int color;
    private final Paint paint;
    
    public IcsColorDrawable(final int color) {
        this.paint = new Paint();
        this.color = color;
    }
    
    public IcsColorDrawable(final ColorDrawable colorDrawable) {
        this.paint = new Paint();
        final Bitmap bitmap = Bitmap.createBitmap(1, 1, Bitmap$Config.ARGB_8888);
        colorDrawable.draw(new Canvas(bitmap));
        this.color = bitmap.getPixel(0, 0);
        bitmap.recycle();
    }
    
    public void draw(final Canvas canvas) {
        if (this.color >>> 24 != 0) {
            this.paint.setColor(this.color);
            canvas.drawRect(this.getBounds(), this.paint);
        }
    }
    
    public int getOpacity() {
        return this.color >>> 24;
    }
    
    public void setAlpha(final int n) {
        if (n != this.color >>> 24) {
            this.color = ((0xFFFFFF & this.color) | n << 24);
            this.invalidateSelf();
        }
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
    }
}
