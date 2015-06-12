// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.RelativeLayout;

public class NoChildFocusRelativeLayout extends RelativeLayout
{
    public NoChildFocusRelativeLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.setDescendantFocusability(393216);
    }
    
    protected void dispatchSetPressed(final boolean b) {
    }
    
    public void dispatchSetSelected(final boolean b) {
    }
}
