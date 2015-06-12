// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.commons;

import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.content.Context;
import com.ogqcorp.bgh.cf.c.b.a.g;

public class FadeInNetworkImageView extends g
{
    public FadeInNetworkImageView(final Context context) {
        super(context);
    }
    
    public FadeInNetworkImageView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public FadeInNetworkImageView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    @Override
    public void setImageDrawable(final Drawable drawable) {
        if (drawable == null) {
            super.setImageDrawable(null);
            return;
        }
        final TransitionDrawable imageDrawable = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), drawable });
        super.setImageDrawable((Drawable)imageDrawable);
        imageDrawable.startTransition(250);
    }
}
