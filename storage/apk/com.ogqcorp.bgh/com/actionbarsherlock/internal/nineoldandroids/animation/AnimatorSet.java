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

public final class AnimatorSet extends Animator
{
    private ValueAnimator mDelayAnim;
    private long mDuration;
    private boolean mNeedsSort;
    private HashMap<Animator, AnimatorSet$Node> mNodeMap;
    private ArrayList<AnimatorSet$Node> mNodes;
    private ArrayList<Animator> mPlayingSet;
    private AnimatorSet$AnimatorSetListener mSetListener;
    private ArrayList<AnimatorSet$Node> mSortedNodes;
    private long mStartDelay;
    private boolean mStarted;
    boolean mTerminated;
    
    public AnimatorSet() {
        this.mPlayingSet = new ArrayList<Animator>();
        this.mNodeMap = new HashMap<Animator, AnimatorSet$Node>();
        this.mNodes = new ArrayList<AnimatorSet$Node>();
        this.mSortedNodes = new ArrayList<AnimatorSet$Node>();
        this.mNeedsSort = true;
        this.mSetListener = null;
        this.mTerminated = false;
        this.mStarted = false;
        this.mStartDelay = 0L;
        this.mDelayAnim = null;
        this.mDuration = -1L;
    }
    
    private void sortNodes() {
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            final ArrayList<AnimatorSet$Node> list = new ArrayList<AnimatorSet$Node>();
            for (int size = this.mNodes.size(), i = 0; i < size; ++i) {
                final AnimatorSet$Node e = this.mNodes.get(i);
                if (e.dependencies == null || e.dependencies.size() == 0) {
                    list.add(e);
                }
            }
            final ArrayList<AnimatorSet$Node> c = new ArrayList<AnimatorSet$Node>();
            while (list.size() > 0) {
                for (int size2 = list.size(), j = 0; j < size2; ++j) {
                    final AnimatorSet$Node animatorSet$Node = list.get(j);
                    this.mSortedNodes.add(animatorSet$Node);
                    if (animatorSet$Node.nodeDependents != null) {
                        for (int size3 = animatorSet$Node.nodeDependents.size(), k = 0; k < size3; ++k) {
                            final AnimatorSet$Node e2 = animatorSet$Node.nodeDependents.get(k);
                            e2.nodeDependencies.remove(animatorSet$Node);
                            if (e2.nodeDependencies.size() == 0) {
                                c.add(e2);
                            }
                        }
                    }
                }
                list.clear();
                list.addAll(c);
                c.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
        }
        else {
            for (int size4 = this.mNodes.size(), l = 0; l < size4; ++l) {
                final AnimatorSet$Node animatorSet$Node2 = this.mNodes.get(l);
                if (animatorSet$Node2.dependencies != null && animatorSet$Node2.dependencies.size() > 0) {
                    for (int size5 = animatorSet$Node2.dependencies.size(), index = 0; index < size5; ++index) {
                        final AnimatorSet$Dependency animatorSet$Dependency = animatorSet$Node2.dependencies.get(index);
                        if (animatorSet$Node2.nodeDependencies == null) {
                            animatorSet$Node2.nodeDependencies = new ArrayList<AnimatorSet$Node>();
                        }
                        if (!animatorSet$Node2.nodeDependencies.contains(animatorSet$Dependency.node)) {
                            animatorSet$Node2.nodeDependencies.add(animatorSet$Dependency.node);
                        }
                    }
                }
                animatorSet$Node2.done = false;
            }
        }
    }
    
    @Override
    public void cancel() {
        this.mTerminated = true;
        if (this.isStarted()) {
            ArrayList<Animator$AnimatorListener> list2;
            if (this.mListeners != null) {
                final ArrayList list = (ArrayList)this.mListeners.clone();
                final Iterator<Animator$AnimatorListener> iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next().onAnimationCancel(this);
                }
                list2 = (ArrayList<Animator$AnimatorListener>)list;
            }
            else {
                list2 = null;
            }
            if (this.mDelayAnim != null && this.mDelayAnim.isRunning()) {
                this.mDelayAnim.cancel();
            }
            else if (this.mSortedNodes.size() > 0) {
                final Iterator<AnimatorSet$Node> iterator2 = this.mSortedNodes.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().animation.cancel();
                }
            }
            if (list2 != null) {
                final Iterator<Animator$AnimatorListener> iterator3 = list2.iterator();
                while (iterator3.hasNext()) {
                    iterator3.next().onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }
    
    @Override
    public AnimatorSet clone() {
        final AnimatorSet set = (AnimatorSet)super.clone();
        set.mNeedsSort = true;
        set.mTerminated = false;
        set.mStarted = false;
        set.mPlayingSet = new ArrayList<Animator>();
        set.mNodeMap = new HashMap<Animator, AnimatorSet$Node>();
        set.mNodes = new ArrayList<AnimatorSet$Node>();
        set.mSortedNodes = new ArrayList<AnimatorSet$Node>();
        final HashMap<AnimatorSet$Node, AnimatorSet$Node> hashMap = new HashMap<AnimatorSet$Node, AnimatorSet$Node>();
        for (final AnimatorSet$Node key : this.mNodes) {
            final AnimatorSet$Node clone = key.clone();
            hashMap.put(key, clone);
            set.mNodes.add(clone);
            set.mNodeMap.put(clone.animation, clone);
            clone.dependencies = null;
            clone.tmpDependencies = null;
            clone.nodeDependents = null;
            clone.nodeDependencies = null;
            final ArrayList<Animator$AnimatorListener> listeners = clone.animation.getListeners();
            if (listeners != null) {
                final Iterator<Animator$AnimatorListener> iterator2 = listeners.iterator();
                ArrayList<Animator$AnimatorListener> list = null;
                while (iterator2.hasNext()) {
                    final Animator$AnimatorListener e = iterator2.next();
                    if (e instanceof AnimatorSet$AnimatorSetListener) {
                        if (list == null) {
                            list = new ArrayList<Animator$AnimatorListener>();
                        }
                        list.add(e);
                    }
                }
                if (list == null) {
                    continue;
                }
                final Iterator<Animator$AnimatorListener> iterator3 = list.iterator();
                while (iterator3.hasNext()) {
                    listeners.remove(iterator3.next());
                }
            }
        }
        for (final AnimatorSet$Node key2 : this.mNodes) {
            final AnimatorSet$Node animatorSet$Node = hashMap.get(key2);
            if (key2.dependencies != null) {
                for (final AnimatorSet$Dependency animatorSet$Dependency : key2.dependencies) {
                    animatorSet$Node.addDependency(new AnimatorSet$Dependency(hashMap.get(animatorSet$Dependency.node), animatorSet$Dependency.rule));
                }
            }
        }
        return set;
    }
    
    @Override
    public void end() {
        this.mTerminated = true;
        if (this.isStarted()) {
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                this.sortNodes();
                for (final AnimatorSet$Node animatorSet$Node : this.mSortedNodes) {
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSet$AnimatorSetListener(this, this);
                    }
                    animatorSet$Node.animation.addListener(this.mSetListener);
                }
            }
            if (this.mDelayAnim != null) {
                this.mDelayAnim.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                final Iterator<AnimatorSet$Node> iterator2 = this.mSortedNodes.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().animation.end();
                }
            }
            if (this.mListeners != null) {
                final Iterator<Animator$AnimatorListener> iterator3 = ((ArrayList)this.mListeners.clone()).iterator();
                while (iterator3.hasNext()) {
                    iterator3.next().onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }
    
    public ArrayList<Animator> getChildAnimations() {
        final ArrayList<Animator> list = new ArrayList<Animator>();
        final Iterator<AnimatorSet$Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().animation);
        }
        return list;
    }
    
    @Override
    public long getDuration() {
        return this.mDuration;
    }
    
    @Override
    public long getStartDelay() {
        return this.mStartDelay;
    }
    
    @Override
    public boolean isRunning() {
        final Iterator<AnimatorSet$Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().animation.isRunning()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isStarted() {
        return this.mStarted;
    }
    
    public AnimatorSet$Builder play(final Animator animator) {
        if (animator != null) {
            this.mNeedsSort = true;
            return new AnimatorSet$Builder(this, animator);
        }
        return null;
    }
    
    public void playSequentially(final List<Animator> list) {
        if (list != null && list.size() > 0) {
            this.mNeedsSort = true;
            if (list.size() == 1) {
                this.play(list.get(0));
            }
            else {
                for (int i = 0; i < -1 + list.size(); ++i) {
                    this.play(list.get(i)).before(list.get(i + 1));
                }
            }
        }
    }
    
    public void playSequentially(final Animator... array) {
        if (array != null) {
            this.mNeedsSort = true;
            final int length = array.length;
            int i = 0;
            if (length == 1) {
                this.play(array[0]);
            }
            else {
                while (i < -1 + array.length) {
                    this.play(array[i]).before(array[i + 1]);
                    ++i;
                }
            }
        }
    }
    
    public void playTogether(final Collection<Animator> collection) {
        if (collection != null && collection.size() > 0) {
            this.mNeedsSort = true;
            AnimatorSet$Builder animatorSet$Builder = null;
            for (final Animator animator : collection) {
                AnimatorSet$Builder play;
                if (animatorSet$Builder == null) {
                    play = this.play(animator);
                }
                else {
                    animatorSet$Builder.with(animator);
                    play = animatorSet$Builder;
                }
                animatorSet$Builder = play;
            }
        }
    }
    
    public void playTogether(final Animator... array) {
        int i = 1;
        if (array != null) {
            this.mNeedsSort = (i != 0);
            final AnimatorSet$Builder play = this.play(array[0]);
            while (i < array.length) {
                play.with(array[i]);
                ++i;
            }
        }
    }
    
    @Override
    public AnimatorSet setDuration(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        final Iterator<AnimatorSet$Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setDuration(n);
        }
        this.mDuration = n;
        return this;
    }
    
    @Override
    public void setInterpolator(final Interpolator interpolator) {
        final Iterator<AnimatorSet$Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setInterpolator(interpolator);
        }
    }
    
    @Override
    public void setStartDelay(final long mStartDelay) {
        this.mStartDelay = mStartDelay;
    }
    
    @Override
    public void setTarget(final Object o) {
        final Iterator<AnimatorSet$Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            final Animator animation = iterator.next().animation;
            if (animation instanceof AnimatorSet) {
                ((AnimatorSet)animation).setTarget(o);
            }
            else {
                if (!(animation instanceof ObjectAnimator)) {
                    continue;
                }
                ((ObjectAnimator)animation).setTarget(o);
            }
        }
    }
    
    @Override
    public void setupEndValues() {
        final Iterator<AnimatorSet$Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setupEndValues();
        }
    }
    
    @Override
    public void setupStartValues() {
        final Iterator<AnimatorSet$Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setupStartValues();
        }
    }
    
    @Override
    public void start() {
        int i = 0;
        this.mTerminated = false;
        this.mStarted = true;
        this.sortNodes();
        final int size = this.mSortedNodes.size();
        for (int j = 0; j < size; ++j) {
            final AnimatorSet$Node animatorSet$Node = this.mSortedNodes.get(j);
            final ArrayList<Animator$AnimatorListener> listeners = animatorSet$Node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                for (final Animator$AnimatorListener animator$AnimatorListener : new ArrayList<Animator$AnimatorListener>(listeners)) {
                    if (animator$AnimatorListener instanceof AnimatorSet$DependencyListener || animator$AnimatorListener instanceof AnimatorSet$AnimatorSetListener) {
                        animatorSet$Node.animation.removeListener(animator$AnimatorListener);
                    }
                }
            }
        }
        final ArrayList<AnimatorSet$Node> list = new ArrayList<AnimatorSet$Node>();
        for (int k = 0; k < size; ++k) {
            final AnimatorSet$Node e = this.mSortedNodes.get(k);
            if (this.mSetListener == null) {
                this.mSetListener = new AnimatorSet$AnimatorSetListener(this, this);
            }
            if (e.dependencies == null || e.dependencies.size() == 0) {
                list.add(e);
            }
            else {
                for (int size2 = e.dependencies.size(), l = 0; l < size2; ++l) {
                    final AnimatorSet$Dependency animatorSet$Dependency = e.dependencies.get(l);
                    animatorSet$Dependency.node.animation.addListener(new AnimatorSet$DependencyListener(this, e, animatorSet$Dependency.rule));
                }
                e.tmpDependencies = (ArrayList<AnimatorSet$Dependency>)e.dependencies.clone();
            }
            e.animation.addListener(this.mSetListener);
        }
        if (this.mStartDelay <= 0L) {
            for (final AnimatorSet$Node animatorSet$Node2 : list) {
                animatorSet$Node2.animation.start();
                this.mPlayingSet.add(animatorSet$Node2.animation);
            }
        }
        else {
            (this.mDelayAnim = ValueAnimator.ofFloat(0.0f, 1.0f)).setDuration(this.mStartDelay);
            this.mDelayAnim.addListener(new AnimatorListenerAdapter() {
                boolean canceled = false;
                
                @Override
                public void onAnimationCancel(final Animator animator) {
                    this.canceled = true;
                }
                
                @Override
                public void onAnimationEnd(final Animator animator) {
                    if (!this.canceled) {
                        for (int size = list.size(), i = 0; i < size; ++i) {
                            final AnimatorSet$Node animatorSet$Node = list.get(i);
                            animatorSet$Node.animation.start();
                            AnimatorSet.this.mPlayingSet.add(animatorSet$Node.animation);
                        }
                    }
                }
            });
            this.mDelayAnim.start();
        }
        if (this.mListeners != null) {
            final ArrayList list2 = (ArrayList)this.mListeners.clone();
            for (int size3 = list2.size(), index = 0; index < size3; ++index) {
                list2.get(index).onAnimationStart(this);
            }
        }
        if (this.mNodes.size() == 0 && this.mStartDelay == 0L) {
            this.mStarted = false;
            if (this.mListeners != null) {
                for (ArrayList list3 = (ArrayList)this.mListeners.clone(); i < list3.size(); ++i) {
                    list3.get(i).onAnimationEnd(this);
                }
            }
        }
    }
}
