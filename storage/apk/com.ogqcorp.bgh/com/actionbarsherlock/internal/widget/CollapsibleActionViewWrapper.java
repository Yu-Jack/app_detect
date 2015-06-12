// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View;
import android.view.CollapsibleActionView;
import android.widget.FrameLayout;

public class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView
{
    private final com.actionbarsherlock.view.CollapsibleActionView child;
    
    public CollapsibleActionViewWrapper(final View view) {
        super(view.getContext());
        this.child = (com.actionbarsherlock.view.CollapsibleActionView)view;
        this.addView(view);
    }
    
    public void onActionViewCollapsed() {
        this.child.onActionViewCollapsed();
    }
    
    public void onActionViewExpanded() {
        this.child.onActionViewExpanded();
    }
    
    public View unwrap() {
        return this.getChildAt(0);
    }
}
