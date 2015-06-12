// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons.support;

import android.graphics.Canvas;
import android.view.View$MeasureSpec;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;

public final class Space extends View
{
    public Space(final Context context) {
        this(context, null);
    }
    
    public Space(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public Space(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        if (this.getVisibility() == 0) {
            this.setVisibility(4);
        }
    }
    
    private static int a(final int a, final int n) {
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        switch (mode) {
            default: {
                return a;
            }
            case Integer.MIN_VALUE: {
                return Math.min(a, size);
            }
            case 1073741824: {
                return size;
            }
        }
    }
    
    public void draw(final Canvas canvas) {
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(a(this.getSuggestedMinimumWidth(), n), a(this.getSuggestedMinimumHeight(), n2));
    }
}
