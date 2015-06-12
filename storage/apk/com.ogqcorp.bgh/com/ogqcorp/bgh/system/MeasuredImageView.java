// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.graphics.drawable.Drawable;
import android.view.View$MeasureSpec;
import android.util.AttributeSet;
import android.content.Context;

public final class MeasuredImageView extends SafeImageView
{
    private double a;
    
    public MeasuredImageView(final Context context) {
        super(context);
    }
    
    public MeasuredImageView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public MeasuredImageView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public double getImageRatio() {
        return this.a;
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (View$MeasureSpec.getMode(n) == 1073741824) {
            final int size = View$MeasureSpec.getSize(n);
            this.setMeasuredDimension(size, (int)Math.round(size / this.a));
            return;
        }
        final int size2 = View$MeasureSpec.getSize(n2);
        this.setMeasuredDimension((int)Math.round(size2 * this.a), size2);
    }
    
    public void setImageDrawable(final Drawable imageDrawable) {
        super.setImageDrawable(imageDrawable);
        if (imageDrawable != null) {
            this.setImageRatio(imageDrawable.getIntrinsicWidth() / imageDrawable.getIntrinsicHeight());
        }
    }
    
    public void setImageRatio(final double a) {
        this.a = a;
        this.requestLayout();
    }
}
