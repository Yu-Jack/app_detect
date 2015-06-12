// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.content.res.TypedArray;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.R$bool;
import com.actionbarsherlock.R$attr;
import com.actionbarsherlock.R$styleable;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import android.view.View$MeasureSpec;
import android.view.View;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import android.content.Context;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import android.view.animation.Interpolator;
import com.actionbarsherlock.internal.nineoldandroids.view.NineViewGroup;

public abstract class AbsActionBarView extends NineViewGroup
{
    private static final int FADE_DURATION = 200;
    private static final Interpolator sAlphaInterpolator;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    final Context mContext;
    protected ActionMenuView mMenuView;
    protected boolean mSplitActionBar;
    protected ActionBarContainer mSplitView;
    protected boolean mSplitWhenNarrow;
    protected final AbsActionBarView$VisibilityAnimListener mVisAnimListener;
    protected Animator mVisibilityAnim;
    
    static {
        sAlphaInterpolator = (Interpolator)new DecelerateInterpolator();
    }
    
    public AbsActionBarView(final Context mContext) {
        super(mContext);
        this.mVisAnimListener = new AbsActionBarView$VisibilityAnimListener(this);
        this.mContext = mContext;
    }
    
    public AbsActionBarView(final Context mContext, final AttributeSet set) {
        super(mContext, set);
        this.mVisAnimListener = new AbsActionBarView$VisibilityAnimListener(this);
        this.mContext = mContext;
    }
    
    public AbsActionBarView(final Context mContext, final AttributeSet set, final int n) {
        super(mContext, set, n);
        this.mVisAnimListener = new AbsActionBarView$VisibilityAnimListener(this);
        this.mContext = mContext;
    }
    
    public void animateToVisibility(final int n) {
        if (this.mVisibilityAnim != null) {
            this.mVisibilityAnim.cancel();
        }
        if (n == 0) {
            if (this.getVisibility() != 0) {
                this.setAlpha(0.0f);
                if (this.mSplitView != null && this.mMenuView != null) {
                    this.mMenuView.setAlpha(0.0f);
                }
            }
            final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(AbsActionBarView.sAlphaInterpolator);
            if (this.mSplitView != null && this.mMenuView != null) {
                final AnimatorSet set = new AnimatorSet();
                final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mMenuView, "alpha", 1.0f);
                ofFloat2.setDuration(200L);
                set.addListener(this.mVisAnimListener.withFinalVisibility(n));
                set.play(ofFloat).with(ofFloat2);
                set.start();
                return;
            }
            ofFloat.addListener(this.mVisAnimListener.withFinalVisibility(n));
            ofFloat.start();
        }
        else {
            final ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "alpha", 0.0f);
            ofFloat3.setDuration(200L);
            ofFloat3.setInterpolator(AbsActionBarView.sAlphaInterpolator);
            if (this.mSplitView != null && this.mMenuView != null) {
                final AnimatorSet set2 = new AnimatorSet();
                final ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mMenuView, "alpha", 0.0f);
                ofFloat4.setDuration(200L);
                set2.addListener(this.mVisAnimListener.withFinalVisibility(n));
                set2.play(ofFloat3).with(ofFloat4);
                set2.start();
                return;
            }
            ofFloat3.addListener(this.mVisAnimListener.withFinalVisibility(n));
            ofFloat3.start();
        }
    }
    
    public void dismissPopupMenus() {
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
    }
    
    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim != null) {
            return this.mVisAnimListener.mFinalVisibility;
        }
        return this.getVisibility();
    }
    
    public int getContentHeight() {
        return this.mContentHeight;
    }
    
    public boolean hideOverflowMenu() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.hideOverflowMenu();
    }
    
    public boolean isOverflowMenuShowing() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.isOverflowMenuShowing();
    }
    
    public boolean isOverflowReserved() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.isOverflowReserved();
    }
    
    protected int measureChildView(final View view, final int n, final int n2, final int n3) {
        view.measure(View$MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE), n2);
        return Math.max(0, n - view.getMeasuredWidth() - n3);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (Build$VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        else if (this.mMenuView != null) {
            this.mMenuView.onConfigurationChanged(configuration);
        }
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes((AttributeSet)null, R$styleable.SherlockActionBar, R$attr.actionBarStyle, 0);
        this.setContentHeight(obtainStyledAttributes.getLayoutDimension(4, 0));
        obtainStyledAttributes.recycle();
        if (this.mSplitWhenNarrow) {
            this.setSplitActionBar(ResourcesCompat.getResources_getBoolean(this.getContext(), R$bool.abs__split_action_bar_is_narrow));
        }
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.onConfigurationChanged(configuration);
        }
    }
    
    protected int positionChild(final View view, final int n, final int n2, final int n3) {
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        final int n4 = n2 + (n3 - measuredHeight) / 2;
        view.layout(n, n4, n + measuredWidth, measuredHeight + n4);
        return measuredWidth;
    }
    
    protected int positionChildInverse(final View view, final int n, final int n2, final int n3) {
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        final int n4 = n2 + (n3 - measuredHeight) / 2;
        view.layout(n - measuredWidth, n4, n, measuredHeight + n4);
        return measuredWidth;
    }
    
    public void postShowOverflowMenu() {
        this.post((Runnable)new Runnable() {
            @Override
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }
    
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
        this.requestLayout();
    }
    
    public void setSplitActionBar(final boolean mSplitActionBar) {
        this.mSplitActionBar = mSplitActionBar;
    }
    
    public void setSplitView(final ActionBarContainer mSplitView) {
        this.mSplitView = mSplitView;
    }
    
    public void setSplitWhenNarrow(final boolean mSplitWhenNarrow) {
        this.mSplitWhenNarrow = mSplitWhenNarrow;
    }
    
    @Override
    public void setVisibility(final int visibility) {
        if (this.mVisibilityAnim != null) {
            this.mVisibilityAnim.end();
        }
        super.setVisibility(visibility);
    }
    
    public boolean showOverflowMenu() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.showOverflowMenu();
    }
}
