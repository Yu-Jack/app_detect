// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe implements Cloneable
{
    float mFraction;
    boolean mHasValue;
    private Interpolator mInterpolator;
    Class mValueType;
    
    public Keyframe() {
        this.mInterpolator = null;
        this.mHasValue = false;
    }
    
    public static Keyframe ofFloat(final float n) {
        return new Keyframe$FloatKeyframe(n);
    }
    
    public static Keyframe ofFloat(final float n, final float n2) {
        return new Keyframe$FloatKeyframe(n, n2);
    }
    
    public static Keyframe ofInt(final float n) {
        return new Keyframe$IntKeyframe(n);
    }
    
    public static Keyframe ofInt(final float n, final int n2) {
        return new Keyframe$IntKeyframe(n, n2);
    }
    
    public static Keyframe ofObject(final float n) {
        return new Keyframe$ObjectKeyframe(n, null);
    }
    
    public static Keyframe ofObject(final float n, final Object o) {
        return new Keyframe$ObjectKeyframe(n, o);
    }
    
    public abstract Keyframe clone();
    
    public float getFraction() {
        return this.mFraction;
    }
    
    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }
    
    public Class getType() {
        return this.mValueType;
    }
    
    public abstract Object getValue();
    
    public boolean hasValue() {
        return this.mHasValue;
    }
    
    public void setFraction(final float mFraction) {
        this.mFraction = mFraction;
    }
    
    public void setInterpolator(final Interpolator mInterpolator) {
        this.mInterpolator = mInterpolator;
    }
    
    public abstract void setValue(final Object p0);
}
