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

public class AnimatorSet$Builder
{
    private AnimatorSet$Node mCurrentNode;
    final /* synthetic */ AnimatorSet this$0;
    
    AnimatorSet$Builder(final AnimatorSet this$0, final Animator animator) {
        this.this$0 = this$0;
        this.mCurrentNode = this$0.mNodeMap.get(animator);
        if (this.mCurrentNode == null) {
            this.mCurrentNode = new AnimatorSet$Node(animator);
            this$0.mNodeMap.put(animator, this.mCurrentNode);
            this$0.mNodes.add(this.mCurrentNode);
        }
    }
    
    public AnimatorSet$Builder after(final long duration) {
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(duration);
        this.after(ofFloat);
        return this;
    }
    
    public AnimatorSet$Builder after(final Animator animator) {
        AnimatorSet$Node animatorSet$Node = this.this$0.mNodeMap.get(animator);
        if (animatorSet$Node == null) {
            animatorSet$Node = new AnimatorSet$Node(animator);
            this.this$0.mNodeMap.put(animator, animatorSet$Node);
            this.this$0.mNodes.add(animatorSet$Node);
        }
        this.mCurrentNode.addDependency(new AnimatorSet$Dependency(animatorSet$Node, 1));
        return this;
    }
    
    public AnimatorSet$Builder before(final Animator animator) {
        AnimatorSet$Node animatorSet$Node = this.this$0.mNodeMap.get(animator);
        if (animatorSet$Node == null) {
            animatorSet$Node = new AnimatorSet$Node(animator);
            this.this$0.mNodeMap.put(animator, animatorSet$Node);
            this.this$0.mNodes.add(animatorSet$Node);
        }
        animatorSet$Node.addDependency(new AnimatorSet$Dependency(this.mCurrentNode, 1));
        return this;
    }
    
    public AnimatorSet$Builder with(final Animator animator) {
        AnimatorSet$Node animatorSet$Node = this.this$0.mNodeMap.get(animator);
        if (animatorSet$Node == null) {
            animatorSet$Node = new AnimatorSet$Node(animator);
            this.this$0.mNodeMap.put(animator, animatorSet$Node);
            this.this$0.mNodes.add(animatorSet$Node);
        }
        animatorSet$Node.addDependency(new AnimatorSet$Dependency(this.mCurrentNode, 0));
        return this;
    }
}
