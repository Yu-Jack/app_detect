// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.ScrollView;

public final class StackScrollView extends ScrollView
{
    private ab a;
    
    public StackScrollView(final Context context) {
        super(context);
    }
    
    public StackScrollView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public StackScrollView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public ab getScrollViewListener() {
        return this.a;
    }
    
    protected void onScrollChanged(final int n, final int n2, final int n3, final int n4) {
        if (this.a != null) {
            this.a.a(this, n, n2, n3, n4);
        }
        super.onScrollChanged(n, n2, n3, n4);
    }
    
    public void setScrollViewListener(final ab a) {
        this.a = a;
    }
}
