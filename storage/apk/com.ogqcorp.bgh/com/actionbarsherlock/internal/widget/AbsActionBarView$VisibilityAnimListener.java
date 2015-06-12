// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;

public class AbsActionBarView$VisibilityAnimListener implements Animator$AnimatorListener
{
    private boolean mCanceled;
    int mFinalVisibility;
    final /* synthetic */ AbsActionBarView this$0;
    
    protected AbsActionBarView$VisibilityAnimListener(final AbsActionBarView this$0) {
        this.this$0 = this$0;
        this.mCanceled = false;
    }
    
    @Override
    public void onAnimationCancel(final Animator animator) {
        this.mCanceled = true;
    }
    
    @Override
    public void onAnimationEnd(final Animator animator) {
        if (!this.mCanceled) {
            this.this$0.mVisibilityAnim = null;
            this.this$0.setVisibility(this.mFinalVisibility);
            if (this.this$0.mSplitView != null && this.this$0.mMenuView != null) {
                this.this$0.mMenuView.setVisibility(this.mFinalVisibility);
            }
        }
    }
    
    @Override
    public void onAnimationRepeat(final Animator animator) {
    }
    
    @Override
    public void onAnimationStart(final Animator mVisibilityAnim) {
        this.this$0.setVisibility(0);
        this.this$0.mVisibilityAnim = mVisibilityAnim;
        this.mCanceled = false;
    }
    
    public AbsActionBarView$VisibilityAnimListener withFinalVisibility(final int mFinalVisibility) {
        this.mFinalVisibility = mFinalVisibility;
        return this;
    }
}
