// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet
{
    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;
    
    public IntKeyframeSet(final Keyframe$IntKeyframe... array) {
        super((Keyframe[])array);
        this.firstTime = true;
    }
    
    @Override
    public IntKeyframeSet clone() {
        final ArrayList<Keyframe> mKeyframes = this.mKeyframes;
        final int size = this.mKeyframes.size();
        final Keyframe$IntKeyframe[] array = new Keyframe$IntKeyframe[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (Keyframe$IntKeyframe)mKeyframes.get(i).clone();
        }
        return new IntKeyframeSet(array);
    }
    
    public int getIntValue(float n) {
        int i = 1;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = this.mKeyframes.get(0).getIntValue();
                this.lastValue = ((Keyframe$IntKeyframe)this.mKeyframes.get(i)).getIntValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                n = this.mInterpolator.getInterpolation(n);
            }
            if (this.mEvaluator == null) {
                return this.firstValue + (int)(n * this.deltaValue);
            }
            return this.mEvaluator.evaluate(n, this.firstValue, this.lastValue).intValue();
        }
        else if (n <= 0.0f) {
            final Keyframe$IntKeyframe keyframe$IntKeyframe = this.mKeyframes.get(0);
            final Keyframe$IntKeyframe keyframe$IntKeyframe2 = this.mKeyframes.get(i);
            final int intValue = keyframe$IntKeyframe.getIntValue();
            final int intValue2 = keyframe$IntKeyframe2.getIntValue();
            final float fraction = keyframe$IntKeyframe.getFraction();
            final float fraction2 = keyframe$IntKeyframe2.getFraction();
            final Interpolator interpolator = keyframe$IntKeyframe2.getInterpolator();
            if (interpolator != null) {
                n = interpolator.getInterpolation(n);
            }
            final float n2 = (n - fraction) / (fraction2 - fraction);
            if (this.mEvaluator == null) {
                return intValue + (int)(n2 * (intValue2 - intValue));
            }
            return this.mEvaluator.evaluate(n2, intValue, intValue2).intValue();
        }
        else {
            if (n < 1.0f) {
                Keyframe$IntKeyframe keyframe$IntKeyframe3 = this.mKeyframes.get(0);
                while (i < this.mNumKeyframes) {
                    final Keyframe$IntKeyframe keyframe$IntKeyframe4 = this.mKeyframes.get(i);
                    if (n < keyframe$IntKeyframe4.getFraction()) {
                        final Interpolator interpolator2 = keyframe$IntKeyframe4.getInterpolator();
                        if (interpolator2 != null) {
                            n = interpolator2.getInterpolation(n);
                        }
                        final float n3 = (n - keyframe$IntKeyframe3.getFraction()) / (keyframe$IntKeyframe4.getFraction() - keyframe$IntKeyframe3.getFraction());
                        final int intValue3 = keyframe$IntKeyframe3.getIntValue();
                        final int intValue4 = keyframe$IntKeyframe4.getIntValue();
                        if (this.mEvaluator == null) {
                            return intValue3 + (int)(n3 * (intValue4 - intValue3));
                        }
                        return this.mEvaluator.evaluate(n3, intValue3, intValue4).intValue();
                    }
                    else {
                        ++i;
                        keyframe$IntKeyframe3 = keyframe$IntKeyframe4;
                    }
                }
                return ((Number)this.mKeyframes.get(-1 + this.mNumKeyframes).getValue()).intValue();
            }
            final Keyframe$IntKeyframe keyframe$IntKeyframe5 = this.mKeyframes.get(-2 + this.mNumKeyframes);
            final Keyframe$IntKeyframe keyframe$IntKeyframe6 = this.mKeyframes.get(-1 + this.mNumKeyframes);
            final int intValue5 = keyframe$IntKeyframe5.getIntValue();
            final int intValue6 = keyframe$IntKeyframe6.getIntValue();
            final float fraction3 = keyframe$IntKeyframe5.getFraction();
            final float fraction4 = keyframe$IntKeyframe6.getFraction();
            final Interpolator interpolator3 = keyframe$IntKeyframe6.getInterpolator();
            if (interpolator3 != null) {
                n = interpolator3.getInterpolation(n);
            }
            final float n4 = (n - fraction3) / (fraction4 - fraction3);
            if (this.mEvaluator == null) {
                return intValue5 + (int)(n4 * (intValue6 - intValue5));
            }
            return this.mEvaluator.evaluate(n4, intValue5, intValue6).intValue();
        }
    }
    
    @Override
    public Object getValue(final float n) {
        return this.getIntValue(n);
    }
}
