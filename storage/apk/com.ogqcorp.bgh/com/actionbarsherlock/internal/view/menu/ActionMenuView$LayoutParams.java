// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout$LayoutParams;

public class ActionMenuView$LayoutParams extends LinearLayout$LayoutParams
{
    public int cellsUsed;
    public boolean expandable;
    public boolean expanded;
    public int extraPixels;
    public boolean isOverflowButton;
    public boolean preventEdgeOffset;
    
    public ActionMenuView$LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.isOverflowButton = false;
    }
    
    public ActionMenuView$LayoutParams(final int n, final int n2, final boolean isOverflowButton) {
        super(n, n2);
        this.isOverflowButton = isOverflowButton;
    }
    
    public ActionMenuView$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public ActionMenuView$LayoutParams(final ActionMenuView$LayoutParams actionMenuView$LayoutParams) {
        super((LinearLayout$LayoutParams)actionMenuView$LayoutParams);
        this.isOverflowButton = actionMenuView$LayoutParams.isOverflowButton;
    }
}
