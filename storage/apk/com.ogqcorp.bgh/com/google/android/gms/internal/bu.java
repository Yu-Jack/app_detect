// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.content.Context;
import android.widget.RelativeLayout;

final class bu extends RelativeLayout
{
    private final ei a;
    
    public bu(final Context context, final String s) {
        super(context);
        this.a = new ei(context, s);
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        this.a.a(motionEvent);
        return false;
    }
}
