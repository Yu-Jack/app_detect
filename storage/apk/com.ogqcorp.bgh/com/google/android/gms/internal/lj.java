// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.content.Context;
import android.widget.ViewSwitcher;

final class lj extends ViewSwitcher
{
    private final ei a;
    
    public lj(final Context context) {
        super(context);
        this.a = new ei(context);
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        this.a.a(motionEvent);
        return false;
    }
}
