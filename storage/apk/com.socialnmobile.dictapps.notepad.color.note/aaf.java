import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aaf extends Drawable
{
    Drawable a;
    Paint b;
    
    public aaf(final Drawable a, final float strokeWidth) {
        this.a = a;
        (this.b = new Paint()).setColor(1149798536);
        this.b.setStrokeWidth(strokeWidth);
    }
    
    public final void draw(final Canvas canvas) {
        this.a.draw(canvas);
        canvas.drawLine((float)this.getIntrinsicWidth(), 0.0f, 0.0f, (float)this.getIntrinsicHeight(), this.b);
    }
    
    public final int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }
    
    public final int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }
    
    public final int getOpacity() {
        return this.a.getOpacity();
    }
    
    protected final void onBoundsChange(final Rect bounds) {
        this.a.setBounds(bounds);
    }
    
    public final void setAlpha(final int alpha) {
        this.a.setAlpha(alpha);
    }
    
    public final void setColorFilter(final ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
