// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$Node implements Cloneable
{
    public Animator animation;
    public ArrayList<AnimatorSet$Dependency> dependencies;
    public boolean done;
    public ArrayList<AnimatorSet$Node> nodeDependencies;
    public ArrayList<AnimatorSet$Node> nodeDependents;
    public ArrayList<AnimatorSet$Dependency> tmpDependencies;
    
    public AnimatorSet$Node(final Animator animation) {
        this.dependencies = null;
        this.tmpDependencies = null;
        this.nodeDependencies = null;
        this.nodeDependents = null;
        this.done = false;
        this.animation = animation;
    }
    
    public void addDependency(final AnimatorSet$Dependency e) {
        if (this.dependencies == null) {
            this.dependencies = new ArrayList<AnimatorSet$Dependency>();
            this.nodeDependencies = new ArrayList<AnimatorSet$Node>();
        }
        this.dependencies.add(e);
        if (!this.nodeDependencies.contains(e.node)) {
            this.nodeDependencies.add(e.node);
        }
        final AnimatorSet$Node node = e.node;
        if (node.nodeDependents == null) {
            node.nodeDependents = new ArrayList<AnimatorSet$Node>();
        }
        node.nodeDependents.add(this);
    }
    
    public AnimatorSet$Node clone() {
        try {
            final AnimatorSet$Node animatorSet$Node = (AnimatorSet$Node)super.clone();
            animatorSet$Node.animation = this.animation.clone();
            return animatorSet$Node;
        }
        catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }
}
