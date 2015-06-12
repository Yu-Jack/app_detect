// 
// Decompiled by Procyon v0.5.29
// 

package com.devspark.robototextview.widget;

import android.content.res.TypedArray;
import com.devspark.robototextview.c;
import com.devspark.robototextview.b;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.Button;

public class RobotoButton extends Button
{
    public RobotoButton(final Context context) {
        super(context);
        this.a(context, null, 0);
    }
    
    public RobotoButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.a(context, set, 0);
    }
    
    public RobotoButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a(context, set, n);
    }
    
    private void a(final Context context, final AttributeSet set, final int n) {
        if (this.isInEditMode()) {
            return;
        }
        int int1 = 4;
        if (set != null) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, b.RobotoTextView, n, 0);
            if (obtainStyledAttributes != null) {
                int1 = obtainStyledAttributes.getInt(0, int1);
                obtainStyledAttributes.recycle();
            }
        }
        this.setTypeface(c.a(context, int1));
    }
}
