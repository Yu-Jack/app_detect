// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.RelativeLayout;

public class BlockRequestRelativeLayout extends RelativeLayout
{
    public BlockRequestRelativeLayout(final Context context) {
        super(context);
    }
    
    public BlockRequestRelativeLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public BlockRequestRelativeLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public boolean isLayoutRequested() {
        return true;
    }
}
