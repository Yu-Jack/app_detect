// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;

public class ScrollingTabContainerView$VisibilityAnimListener implements Animator$AnimatorListener
{
    private boolean mCanceled;
    private int mFinalVisibility;
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    protected ScrollingTabContainerView$VisibilityAnimListener(final ScrollingTabContainerView this$0) {
        this.this$0 = this$0;
        this.mCanceled = false;
    }
    
    @Override
    public void onAnimationCancel(final Animator animator) {
        this.mCanceled = true;
    }
    
    @Override
    public void onAnimationEnd(final Animator animator) {
        if (this.mCanceled) {
            return;
        }
        this.this$0.mVisibilityAnim = null;
        this.this$0.setVisibility(this.mFinalVisibility);
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
    
    public ScrollingTabContainerView$VisibilityAnimListener withFinalVisibility(final int mFinalVisibility) {
        this.mFinalVisibility = mFinalVisibility;
        return this;
    }
}
