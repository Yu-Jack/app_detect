// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.graphics.drawable.BitmapDrawable;
import android.content.res.Resources;
import android.annotation.TargetApi;

@TargetApi(5)
class AndroidTargetUtils$EclairTargetUtils
{
    protected static BitmapDrawable getNewBitmapDrawable(final Resources resources, final String s) {
        return new BitmapDrawable(resources, s);
    }
}
