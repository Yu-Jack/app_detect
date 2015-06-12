// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;

class AnimatorSet$DependencyListener implements Animator$AnimatorListener
{
    private AnimatorSet mAnimatorSet;
    private AnimatorSet$Node mNode;
    private int mRule;
    
    public AnimatorSet$DependencyListener(final AnimatorSet mAnimatorSet, final AnimatorSet$Node mNode, final int mRule) {
        this.mAnimatorSet = mAnimatorSet;
        this.mNode = mNode;
        this.mRule = mRule;
    }
    
    private void startIfReady(final Animator animator) {
        if (!this.mAnimatorSet.mTerminated) {
            final int size = this.mNode.tmpDependencies.size();
            int i = 0;
            while (true) {
                while (i < size) {
                    final AnimatorSet$Dependency o = this.mNode.tmpDependencies.get(i);
                    if (o.rule == this.mRule && o.node.animation == animator) {
                        animator.removeListener(this);
                        this.mNode.tmpDependencies.remove(o);
                        if (this.mNode.tmpDependencies.size() == 0) {
                            this.mNode.animation.start();
                            this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
                        }
                        return;
                    }
                    else {
                        ++i;
                    }
                }
                final AnimatorSet$Dependency o = null;
                continue;
            }
        }
    }
    
    @Override
    public void onAnimationCancel(final Animator animator) {
    }
    
    @Override
    public void onAnimationEnd(final Animator animator) {
        if (this.mRule == 1) {
            this.startIfReady(animator);
        }
    }
    
    @Override
    public void onAnimationRepeat(final Animator animator) {
    }
    
    @Override
    public void onAnimationStart(final Animator animator) {
        if (this.mRule == 0) {
            this.startIfReady(animator);
        }
    }
}
