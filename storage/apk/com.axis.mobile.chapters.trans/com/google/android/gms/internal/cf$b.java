// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.content.Context;
import android.widget.RelativeLayout;

final class cf$b extends RelativeLayout
{
    private final ep kI;
    
    public cf$b(final Context context, final String s) {
        super(context);
        this.kI = new ep(context, s);
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        this.kI.c(motionEvent);
        return false;
    }
}
