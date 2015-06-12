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
import android.view.ViewGroup;
import com.actionbarsherlock.R$layout;
import android.widget.LinearLayout$LayoutParams;
import com.actionbarsherlock.app.ActionBar$Tab;
import android.content.res.TypedArray;
import android.view.View;
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

public class ScrollingTabContainerView extends NineHorizontalScrollView implements IcsAdapterView$OnItemSelectedListener
{
    private static final int FADE_DURATION = 200;
    private static final Interpolator sAlphaInterpolator;
    private boolean mAllowCollapse;
    private int mContentHeight;
    private LayoutInflater mInflater;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    private ScrollingTabContainerView$TabClickListener mTabClickListener;
    private IcsLinearLayout mTabLayout;
    Runnable mTabSelector;
    private IcsSpinner mTabSpinner;
    protected final ScrollingTabContainerView$VisibilityAnimListener mVisAnimListener;
    protected Animator mVisibilityAnim;
    
    static {
        sAlphaInterpolator = (Interpolator)new DecelerateInterpolator();
    }
    
    public ScrollingTabContainerView(final Context context) {
        super(context);
        this.mVisAnimListener = new ScrollingTabContainerView$VisibilityAnimListener(this);
        this.setHorizontalScrollBarEnabled(false);
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes((AttributeSet)null, R$styleable.SherlockActionBar, R$attr.actionBarStyle, 0);
        this.setContentHeight(obtainStyledAttributes.getLayoutDimension(4, 0));
        obtainStyledAttributes.recycle();
        this.mInflater = LayoutInflater.from(context);
        this.addView((View)(this.mTabLayout = this.createTabLayout()), new ViewGroup$LayoutParams(-2, -1));
    }
    
    private IcsSpinner createSpinner() {
        final IcsSpinner icsSpinner = new IcsSpinner(this.getContext(), null, R$attr.actionDropDownStyle);
        icsSpinner.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -1));
        icsSpinner.setOnItemSelectedListener(this);
        return icsSpinner;
    }
    
    private IcsLinearLayout createTabLayout() {
        final TabsLinearLayout tabsLinearLayout = (TabsLinearLayout)LayoutInflater.from(this.getContext()).inflate(R$layout.abs__action_bar_tab_bar_view, (ViewGroup)null);
        tabsLinearLayout.setMeasureWithLargestChildEnabled(true);
        tabsLinearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -1));
        return tabsLinearLayout;
    }
    
    private ScrollingTabContainerView$TabView createTabView(final ActionBar$Tab actionBar$Tab, final boolean b) {
        final ScrollingTabContainerView$TabView scrollingTabContainerView$TabView = (ScrollingTabContainerView$TabView)this.mInflater.inflate(R$layout.abs__action_bar_tab, (ViewGroup)null);
        scrollingTabContainerView$TabView.init(this, actionBar$Tab, b);
        if (b) {
            scrollingTabContainerView$TabView.setBackgroundDrawable((Drawable)null);
            scrollingTabContainerView$TabView.setLayoutParams((ViewGroup$LayoutParams)new AbsListView$LayoutParams(-1, this.mContentHeight));
            return scrollingTabContainerView$TabView;
        }
        scrollingTabContainerView$TabView.setFocusable(true);
        if (this.mTabClickListener == null) {
            this.mTabClickListener = new ScrollingTabContainerView$TabClickListener(this, null);
        }
        scrollingTabContainerView$TabView.setOnClickListener((View$OnClickListener)this.mTabClickListener);
        return scrollingTabContainerView$TabView;
    }
    
    private boolean isCollapsed() {
        return this.mTabSpinner != null && this.mTabSpinner.getParent() == this;
    }
    
    private void performCollapse() {
        if (this.isCollapsed()) {
            return;
        }
        if (this.mTabSpinner == null) {
            this.mTabSpinner = this.createSpinner();
        }
        this.removeView((View)this.mTabLayout);
        this.addView((View)this.mTabSpinner, new ViewGroup$LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter((SpinnerAdapter)new ScrollingTabContainerView$TabAdapter(this, null));
        }
        if (this.mTabSelector != null) {
            this.removeCallbacks(this.mTabSelector);
            this.mTabSelector = null;
        }
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }
    
    private boolean performExpand() {
        if (!this.isCollapsed()) {
            return false;
        }
        this.removeView((View)this.mTabSpinner);
        this.addView((View)this.mTabLayout, new ViewGroup$LayoutParams(-2, -1));
        this.setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n, final boolean b) {
        final ScrollingTabContainerView$TabView tabView = this.createTabView(actionBar$Tab, false);
        this.mTabLayout.addView((View)tabView, n, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -1, 1.0f));
        if (this.mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (b) {
            tabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final boolean b) {
        final ScrollingTabContainerView$TabView tabView = this.createTabView(actionBar$Tab, false);
        this.mTabLayout.addView((View)tabView, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -1, 1.0f));
        if (this.mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (b) {
            tabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void animateToTab(final int n) {
        final View child = this.mTabLayout.getChildAt(n);
        if (this.mTabSelector != null) {
            this.removeCallbacks(this.mTabSelector);
        }
        this.post(this.mTabSelector = new Runnable() {
            @Override
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(child.getLeft() - (ScrollingTabContainerView.this.getWidth() - child.getWidth()) / 2, 0);
                ScrollingTabContainerView.this.mTabSelector = null;
            }
        });
    }
    
    public void animateToVisibility(final int n) {
        if (this.mVisibilityAnim != null) {
            this.mVisibilityAnim.cancel();
        }
        if (n == 0) {
            if (this.getVisibility() != 0) {
                this.setAlpha(0.0f);
            }
            final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(ScrollingTabContainerView.sAlphaInterpolator);
            ofFloat.addListener(this.mVisAnimListener.withFinalVisibility(n));
            ofFloat.start();
            return;
        }
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "alpha", 0.0f);
        ofFloat2.setDuration(200L);
        ofFloat2.setInterpolator(ScrollingTabContainerView.sAlphaInterpolator);
        ofFloat2.addListener(this.mVisAnimListener.withFinalVisibility(n));
        ofFloat2.start();
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mTabSelector != null) {
            this.post(this.mTabSelector);
        }
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes((AttributeSet)null, R$styleable.SherlockActionBar, R$attr.actionBarStyle, 0);
        this.setContentHeight(obtainStyledAttributes.getLayoutDimension(4, 0));
        obtainStyledAttributes.recycle();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mTabSelector != null) {
            this.removeCallbacks(this.mTabSelector);
        }
    }
    
    @Override
    public void onItemSelected(final IcsAdapterView<?> icsAdapterView, final View view, final int n, final long n2) {
        ((ScrollingTabContainerView$TabView)view).getTab().select();
    }
    
    public void onMeasure(final int n, final int n2) {
        int n3 = 1;
        final int mode = View$MeasureSpec.getMode(n);
        int fillViewport;
        if (mode == 1073741824) {
            fillViewport = n3;
        }
        else {
            fillViewport = 0;
        }
        this.setFillViewport((boolean)(fillViewport != 0));
        final int childCount = this.mTabLayout.getChildCount();
        if (childCount > n3 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.mMaxTabWidth = (int)(0.4f * View$MeasureSpec.getSize(n));
            }
            else {
                this.mMaxTabWidth = View$MeasureSpec.getSize(n) / 2;
            }
        }
        else {
            this.mMaxTabWidth = -1;
        }
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (fillViewport || !this.mAllowCollapse) {
            n3 = 0;
        }
        if (n3 != 0) {
            this.mTabLayout.measure(0, measureSpec);
            if (this.mTabLayout.getMeasuredWidth() > View$MeasureSpec.getSize(n)) {
                this.performCollapse();
            }
            else {
                this.performExpand();
            }
        }
        else {
            this.performExpand();
        }
        final int measuredWidth = this.getMeasuredWidth();
        super.onMeasure(n, measureSpec);
        final int measuredWidth2 = this.getMeasuredWidth();
        if (fillViewport && measuredWidth != measuredWidth2) {
            this.setTabSelected(this.mSelectedTabIndex);
        }
    }
    
    @Override
    public void onNothingSelected(final IcsAdapterView<?> icsAdapterView) {
    }
    
    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        if (this.mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void removeTabAt(final int n) {
        this.mTabLayout.removeViewAt(n);
        if (this.mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void setAllowCollapse(final boolean mAllowCollapse) {
        this.mAllowCollapse = mAllowCollapse;
    }
    
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
        this.requestLayout();
    }
    
    public void setTabSelected(final int mSelectedTabIndex) {
        this.mSelectedTabIndex = mSelectedTabIndex;
        for (int childCount = this.mTabLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.mTabLayout.getChildAt(i);
            final boolean selected = i == mSelectedTabIndex;
            child.setSelected(selected);
            if (selected) {
                this.animateToTab(mSelectedTabIndex);
            }
        }
    }
    
    public void updateTab(final int n) {
        ((ScrollingTabContainerView$TabView)this.mTabLayout.getChildAt(n)).update();
        if (this.mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
}
