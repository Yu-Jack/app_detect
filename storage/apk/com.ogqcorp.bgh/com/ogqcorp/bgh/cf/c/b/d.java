// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b;

import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ImageView;

public class d extends ImageView
{
    public d(final Context context) {
        super(context);
    }
    
    public d(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public d(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    private static void a(final Drawable drawable, final boolean b) {
        if (drawable instanceof c) {
            ((c)drawable).b(b);
        }
        else if (drawable instanceof LayerDrawable) {
            final LayerDrawable layerDrawable = (LayerDrawable)drawable;
            for (int i = 0; i < layerDrawable.getNumberOfLayers(); ++i) {
                a(layerDrawable.getDrawable(i), b);
            }
        }
    }
    
    protected void onDetachedFromWindow() {
        this.setImageDrawable(null);
        super.onDetachedFromWindow();
    }
    
    public void setImageDrawable(final Drawable imageDrawable) {
        final Drawable drawable = this.getDrawable();
        super.setImageDrawable(imageDrawable);
        a(imageDrawable, true);
        a(drawable, false);
    }
}
