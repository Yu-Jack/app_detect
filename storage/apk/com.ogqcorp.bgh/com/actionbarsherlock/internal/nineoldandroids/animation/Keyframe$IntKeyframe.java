// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

class Keyframe$IntKeyframe extends Keyframe
{
    int mValue;
    
    Keyframe$IntKeyframe(final float mFraction) {
        this.mFraction = mFraction;
        this.mValueType = Integer.TYPE;
    }
    
    Keyframe$IntKeyframe(final float mFraction, final int mValue) {
        this.mFraction = mFraction;
        this.mValue = mValue;
        this.mValueType = Integer.TYPE;
        this.mHasValue = true;
    }
    
    @Override
    public Keyframe$IntKeyframe clone() {
        final Keyframe$IntKeyframe keyframe$IntKeyframe = new Keyframe$IntKeyframe(this.getFraction(), this.mValue);
        keyframe$IntKeyframe.setInterpolator(this.getInterpolator());
        return keyframe$IntKeyframe;
    }
    
    public int getIntValue() {
        return this.mValue;
    }
    
    @Override
    public Object getValue() {
        return this.mValue;
    }
    
    @Override
    public void setValue(final Object o) {
        if (o != null && o.getClass() == Integer.class) {
            this.mValue = (int)o;
            this.mHasValue = true;
        }
    }
}
