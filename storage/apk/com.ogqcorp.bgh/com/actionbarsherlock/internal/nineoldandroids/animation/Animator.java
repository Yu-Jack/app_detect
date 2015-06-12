// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator implements Cloneable
{
    ArrayList<Animator$AnimatorListener> mListeners;
    
    public Animator() {
        this.mListeners = null;
    }
    
    public void addListener(final Animator$AnimatorListener e) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<Animator$AnimatorListener>();
        }
        this.mListeners.add(e);
    }
    
    public void cancel() {
    }
    
    public Animator clone() {
        Animator animator;
        try {
            animator = (Animator)super.clone();
            if (this.mListeners != null) {
                final ArrayList<Animator$AnimatorListener> mListeners = this.mListeners;
                animator.mListeners = new ArrayList<Animator$AnimatorListener>();
                for (int size = mListeners.size(), i = 0; i < size; ++i) {
                    animator.mListeners.add(mListeners.get(i));
                }
            }
        }
        catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
        return animator;
    }
    
    public void end() {
    }
    
    public abstract long getDuration();
    
    public ArrayList<Animator$AnimatorListener> getListeners() {
        return this.mListeners;
    }
    
    public abstract long getStartDelay();
    
    public abstract boolean isRunning();
    
    public boolean isStarted() {
        return this.isRunning();
    }
    
    public void removeAllListeners() {
        if (this.mListeners != null) {
            this.mListeners.clear();
            this.mListeners = null;
        }
    }
    
    public void removeListener(final Animator$AnimatorListener o) {
        if (this.mListeners != null) {
            this.mListeners.remove(o);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
    }
    
    public abstract Animator setDuration(final long p0);
    
    public abstract void setInterpolator(final Interpolator p0);
    
    public abstract void setStartDelay(final long p0);
    
    public void setTarget(final Object o) {
    }
    
    public void setupEndValues() {
    }
    
    public void setupStartValues() {
    }
    
    public void start() {
    }
}
