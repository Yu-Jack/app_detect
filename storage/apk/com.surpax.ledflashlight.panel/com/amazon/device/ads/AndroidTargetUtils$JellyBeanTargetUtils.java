// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.widget.ImageButton;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.annotation.TargetApi;

@TargetApi(16)
class AndroidTargetUtils$JellyBeanTargetUtils
{
    public static void setBackgroundForLinerLayout(final View view, final Drawable background) {
        view.setBackground(background);
    }
    
    protected static void setImageButtonAlpha(final ImageButton imageButton, final int imageAlpha) {
        imageButton.setImageAlpha(imageAlpha);
    }
}
