// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

class AnimatorSet$AnimatorSetListener implements Animator$AnimatorListener
{
    private AnimatorSet mAnimatorSet;
    final /* synthetic */ AnimatorSet this$0;
    
    AnimatorSet$AnimatorSetListener(final AnimatorSet this$0, final AnimatorSet mAnimatorSet) {
        this.this$0 = this$0;
        this.mAnimatorSet = mAnimatorSet;
    }
    
    @Override
    public void onAnimationCancel(final Animator animator) {
        if (!this.this$0.mTerminated && this.this$0.mPlayingSet.size() == 0 && this.this$0.mListeners != null) {
            for (int size = this.this$0.mListeners.size(), i = 0; i < size; ++i) {
                this.this$0.mListeners.get(i).onAnimationCancel(this.mAnimatorSet);
            }
        }
    }
    
    @Override
    public void onAnimationEnd(final Animator animator) {
        animator.removeListener(this);
        this.this$0.mPlayingSet.remove(animator);
        this.mAnimatorSet.mNodeMap.get(animator).done = true;
        if (!this.this$0.mTerminated) {
            final ArrayList access$200 = this.mAnimatorSet.mSortedNodes;
            final int size = access$200.size();
            int i = 0;
            while (true) {
                while (i < size) {
                    if (!access$200.get(i).done) {
                        final int n = 0;
                        if (n != 0) {
                            if (this.this$0.mListeners != null) {
                                final ArrayList list = (ArrayList)this.this$0.mListeners.clone();
                                for (int size2 = list.size(), j = 0; j < size2; ++j) {
                                    list.get(j).onAnimationEnd(this.mAnimatorSet);
                                }
                            }
                            this.mAnimatorSet.mStarted = false;
                        }
                        return;
                    }
                    else {
                        ++i;
                    }
                }
                final int n = 1;
                continue;
            }
        }
    }
    
    @Override
    public void onAnimationRepeat(final Animator animator) {
    }
    
    @Override
    public void onAnimationStart(final Animator animator) {
    }
}
