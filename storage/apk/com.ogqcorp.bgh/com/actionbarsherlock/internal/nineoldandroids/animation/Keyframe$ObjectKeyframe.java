// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

class Keyframe$ObjectKeyframe extends Keyframe
{
    Object mValue;
    
    Keyframe$ObjectKeyframe(final float mFraction, final Object mValue) {
        this.mFraction = mFraction;
        this.mValue = mValue;
        this.mHasValue = (mValue != null);
        Class<?> class1;
        if (this.mHasValue) {
            class1 = mValue.getClass();
        }
        else {
            class1 = Object.class;
        }
        this.mValueType = class1;
    }
    
    @Override
    public Keyframe$ObjectKeyframe clone() {
        final Keyframe$ObjectKeyframe keyframe$ObjectKeyframe = new Keyframe$ObjectKeyframe(this.getFraction(), this.mValue);
        keyframe$ObjectKeyframe.setInterpolator(this.getInterpolator());
        return keyframe$ObjectKeyframe;
    }
    
    @Override
    public Object getValue() {
        return this.mValue;
    }
    
    @Override
    public void setValue(final Object mValue) {
        this.mValue = mValue;
        this.mHasValue = (mValue != null);
    }
}
