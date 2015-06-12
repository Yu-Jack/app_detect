// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View$MeasureSpec;
import android.content.res.Configuration;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import android.widget.SpinnerAdapter;
import android.widget.AbsListView$LayoutParams;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.actionbarsherlock.R$layout;
import android.widget.LinearLayout$LayoutParams;
import com.actionbarsherlock.app.ActionBar$Tab;
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
import android.view.View;
import android.view.View$OnClickListener;

class ScrollingTabContainerView$TabClickListener implements View$OnClickListener
{
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    private ScrollingTabContainerView$TabClickListener(final ScrollingTabContainerView this$0) {
        this.this$0 = this$0;
    }
    
    public void onClick(final View view) {
        ((ScrollingTabContainerView$TabView)view).getTab().select();
        for (int childCount = this.this$0.mTabLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.this$0.mTabLayout.getChildAt(i);
            child.setSelected(child == view);
        }
    }
}
