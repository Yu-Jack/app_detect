// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View$MeasureSpec;
import android.content.res.Configuration;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import android.widget.SpinnerAdapter;
import android.view.View$OnClickListener;
import android.widget.AbsListView$LayoutParams;
import android.graphics.drawable.Drawable;
import com.actionbarsherlock.R$layout;
import android.widget.LinearLayout$LayoutParams;
import android.content.res.TypedArray;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import com.actionbarsherlock.R$attr;
import com.actionbarsherlock.R$styleable;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineHorizontalScrollView;
import com.actionbarsherlock.app.ActionBar$Tab;
import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;

class ScrollingTabContainerView$TabAdapter extends BaseAdapter
{
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    private ScrollingTabContainerView$TabAdapter(final ScrollingTabContainerView this$0) {
        this.this$0 = this$0;
    }
    
    public int getCount() {
        return this.this$0.mTabLayout.getChildCount();
    }
    
    public Object getItem(final int n) {
        return ((ScrollingTabContainerView$TabView)this.this$0.mTabLayout.getChildAt(n)).getTab();
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        if (view == null) {
            return (View)this.this$0.createTabView((ActionBar$Tab)this.getItem(n), true);
        }
        ((ScrollingTabContainerView$TabView)view).bindTab((ActionBar$Tab)this.getItem(n));
        return view;
    }
}
