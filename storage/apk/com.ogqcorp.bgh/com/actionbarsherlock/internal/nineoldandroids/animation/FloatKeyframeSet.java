// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet
{
    private float deltaValue;
    private boolean firstTime;
    private float firstValue;
    private float lastValue;
    
    public FloatKeyframeSet(final Keyframe$FloatKeyframe... array) {
        super((Keyframe[])array);
        this.firstTime = true;
    }
    
    @Override
    public FloatKeyframeSet clone() {
        final ArrayList<Keyframe> mKeyframes = this.mKeyframes;
        final int size = this.mKeyframes.size();
        final Keyframe$FloatKeyframe[] array = new Keyframe$FloatKeyframe[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (Keyframe$FloatKeyframe)mKeyframes.get(i).clone();
        }
        return new FloatKeyframeSet(array);
    }
    
    public float getFloatValue(float n) {
        int i = 1;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = this.mKeyframes.get(0).getFloatValue();
                this.lastValue = ((Keyframe$FloatKeyframe)this.mKeyframes.get(i)).getFloatValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                n = this.mInterpolator.getInterpolation(n);
            }
            if (this.mEvaluator == null) {
                return this.firstValue + n * this.deltaValue;
            }
            return this.mEvaluator.evaluate(n, this.firstValue, this.lastValue).floatValue();
        }
        else if (n <= 0.0f) {
            final Keyframe$FloatKeyframe keyframe$FloatKeyframe = this.mKeyframes.get(0);
            final Keyframe$FloatKeyframe keyframe$FloatKeyframe2 = this.mKeyframes.get(i);
            final float floatValue = keyframe$FloatKeyframe.getFloatValue();
            final float floatValue2 = keyframe$FloatKeyframe2.getFloatValue();
            final float fraction = keyframe$FloatKeyframe.getFraction();
            final float fraction2 = keyframe$FloatKeyframe2.getFraction();
            final Interpolator interpolator = keyframe$FloatKeyframe2.getInterpolator();
            if (interpolator != null) {
                n = interpolator.getInterpolation(n);
            }
            final float n2 = (n - fraction) / (fraction2 - fraction);
            if (this.mEvaluator == null) {
                return floatValue + n2 * (floatValue2 - floatValue);
            }
            return this.mEvaluator.evaluate(n2, floatValue, floatValue2).floatValue();
        }
        else {
            if (n < 1.0f) {
                Keyframe$FloatKeyframe keyframe$FloatKeyframe3 = this.mKeyframes.get(0);
                while (i < this.mNumKeyframes) {
                    final Keyframe$FloatKeyframe keyframe$FloatKeyframe4 = this.mKeyframes.get(i);
                    if (n < keyframe$FloatKeyframe4.getFraction()) {
                        final Interpolator interpolator2 = keyframe$FloatKeyframe4.getInterpolator();
                        if (interpolator2 != null) {
                            n = interpolator2.getInterpolation(n);
                        }
                        final float n3 = (n - keyframe$FloatKeyframe3.getFraction()) / (keyframe$FloatKeyframe4.getFraction() - keyframe$FloatKeyframe3.getFraction());
                        final float floatValue3 = keyframe$FloatKeyframe3.getFloatValue();
                        final float floatValue4 = keyframe$FloatKeyframe4.getFloatValue();
                        if (this.mEvaluator == null) {
                            return floatValue3 + n3 * (floatValue4 - floatValue3);
                        }
                        return this.mEvaluator.evaluate(n3, floatValue3, floatValue4).floatValue();
                    }
                    else {
                        ++i;
                        keyframe$FloatKeyframe3 = keyframe$FloatKeyframe4;
                    }
                }
                return ((Number)this.mKeyframes.get(-1 + this.mNumKeyframes).getValue()).floatValue();
            }
            final Keyframe$FloatKeyframe keyframe$FloatKeyframe5 = this.mKeyframes.get(-2 + this.mNumKeyframes);
            final Keyframe$FloatKeyframe keyframe$FloatKeyframe6 = this.mKeyframes.get(-1 + this.mNumKeyframes);
            final float floatValue5 = keyframe$FloatKeyframe5.getFloatValue();
            final float floatValue6 = keyframe$FloatKeyframe6.getFloatValue();
            final float fraction3 = keyframe$FloatKeyframe5.getFraction();
            final float fraction4 = keyframe$FloatKeyframe6.getFraction();
            final Interpolator interpolator3 = keyframe$FloatKeyframe6.getInterpolator();
            if (interpolator3 != null) {
                n = interpolator3.getInterpolation(n);
            }
            final float n4 = (n - fraction3) / (fraction4 - fraction3);
            if (this.mEvaluator == null) {
                return floatValue5 + n4 * (floatValue6 - floatValue5);
            }
            return this.mEvaluator.evaluate(n4, floatValue5, floatValue6).floatValue();
        }
    }
    
    @Override
    public Object getValue(final float n) {
        return this.getFloatValue(n);
    }
}
