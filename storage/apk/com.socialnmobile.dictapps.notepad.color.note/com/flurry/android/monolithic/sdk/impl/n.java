// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.widget.VideoView;

public class n extends VideoView
{
    public n(final Context context) {
        super(context);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
    }
    
    public void seekTo(final int n) {
        if (n < this.getCurrentPosition()) {
            super.seekTo(n);
        }
    }
}
