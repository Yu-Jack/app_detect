// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

class Keyframe$FloatKeyframe extends Keyframe
{
    float mValue;
    
    Keyframe$FloatKeyframe(final float mFraction) {
        this.mFraction = mFraction;
        this.mValueType = Float.TYPE;
    }
    
    Keyframe$FloatKeyframe(final float mFraction, final float mValue) {
        this.mFraction = mFraction;
        this.mValue = mValue;
        this.mValueType = Float.TYPE;
        this.mHasValue = true;
    }
    
    @Override
    public Keyframe$FloatKeyframe clone() {
        final Keyframe$FloatKeyframe keyframe$FloatKeyframe = new Keyframe$FloatKeyframe(this.getFraction(), this.mValue);
        keyframe$FloatKeyframe.setInterpolator(this.getInterpolator());
        return keyframe$FloatKeyframe;
    }
    
    public float getFloatValue() {
        return this.mValue;
    }
    
    @Override
    public Object getValue() {
        return this.mValue;
    }
    
    @Override
    public void setValue(final Object o) {
        if (o != null && o.getClass() == Float.class) {
            this.mValue = (float)o;
            this.mHasValue = true;
        }
    }
}
