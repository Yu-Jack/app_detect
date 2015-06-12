// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.view.animation.Interpolator;

class KeyframeSet
{
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes;
    Keyframe mLastKeyframe;
    int mNumKeyframes;
    
    public KeyframeSet(final Keyframe... a) {
        this.mNumKeyframes = a.length;
        (this.mKeyframes = new ArrayList<Keyframe>()).addAll(Arrays.asList(a));
        this.mFirstKeyframe = this.mKeyframes.get(0);
        this.mLastKeyframe = this.mKeyframes.get(-1 + this.mNumKeyframes);
        this.mInterpolator = this.mLastKeyframe.getInterpolator();
    }
    
    public static KeyframeSet ofFloat(final float... array) {
        int i = 1;
        final int length = array.length;
        final Keyframe$FloatKeyframe[] array2 = new Keyframe$FloatKeyframe[Math.max(length, 2)];
        if (length == i) {
            array2[0] = (Keyframe$FloatKeyframe)Keyframe.ofFloat(0.0f);
            array2[i] = (Keyframe$FloatKeyframe)Keyframe.ofFloat(1.0f, array[0]);
        }
        else {
            array2[0] = (Keyframe$FloatKeyframe)Keyframe.ofFloat(0.0f, array[0]);
            while (i < length) {
                array2[i] = (Keyframe$FloatKeyframe)Keyframe.ofFloat(i / (length - 1), array[i]);
                ++i;
            }
        }
        return new FloatKeyframeSet(array2);
    }
    
    public static KeyframeSet ofInt(final int... array) {
        int i = 1;
        final int length = array.length;
        final Keyframe$IntKeyframe[] array2 = new Keyframe$IntKeyframe[Math.max(length, 2)];
        if (length == i) {
            array2[0] = (Keyframe$IntKeyframe)Keyframe.ofInt(0.0f);
            array2[i] = (Keyframe$IntKeyframe)Keyframe.ofInt(1.0f, array[0]);
        }
        else {
            array2[0] = (Keyframe$IntKeyframe)Keyframe.ofInt(0.0f, array[0]);
            while (i < length) {
                array2[i] = (Keyframe$IntKeyframe)Keyframe.ofInt(i / (length - 1), array[i]);
                ++i;
            }
        }
        return new IntKeyframeSet(array2);
    }
    
    public static KeyframeSet ofKeyframe(final Keyframe... array) {
        int i = 0;
        final int length = array.length;
        int j = 0;
        boolean b = false;
        boolean b2 = false;
        boolean b3 = false;
        while (j < length) {
            if (array[j] instanceof Keyframe$FloatKeyframe) {
                b3 = true;
            }
            else if (array[j] instanceof Keyframe$IntKeyframe) {
                b2 = true;
            }
            else {
                b = true;
            }
            ++j;
        }
        if (b3 && !b2 && !b) {
            final Keyframe$FloatKeyframe[] array2 = new Keyframe$FloatKeyframe[length];
            while (i < length) {
                array2[i] = (Keyframe$FloatKeyframe)array[i];
                ++i;
            }
            return new FloatKeyframeSet(array2);
        }
        if (b2 && !b3 && !b) {
            final Keyframe$IntKeyframe[] array3 = new Keyframe$IntKeyframe[length];
            for (int k = 0; k < length; ++k) {
                array3[k] = (Keyframe$IntKeyframe)array[k];
            }
            return new IntKeyframeSet(array3);
        }
        return new KeyframeSet(array);
    }
    
    public static KeyframeSet ofObject(final Object... array) {
        int i = 1;
        final int length = array.length;
        final Keyframe$ObjectKeyframe[] array2 = new Keyframe$ObjectKeyframe[Math.max(length, 2)];
        if (length == i) {
            array2[0] = (Keyframe$ObjectKeyframe)Keyframe.ofObject(0.0f);
            array2[i] = (Keyframe$ObjectKeyframe)Keyframe.ofObject(1.0f, array[0]);
        }
        else {
            array2[0] = (Keyframe$ObjectKeyframe)Keyframe.ofObject(0.0f, array[0]);
            while (i < length) {
                array2[i] = (Keyframe$ObjectKeyframe)Keyframe.ofObject(i / (length - 1), array[i]);
                ++i;
            }
        }
        return new KeyframeSet((Keyframe[])array2);
    }
    
    public KeyframeSet clone() {
        final ArrayList<Keyframe> mKeyframes = this.mKeyframes;
        final int size = this.mKeyframes.size();
        final Keyframe[] array = new Keyframe[size];
        for (int i = 0; i < size; ++i) {
            array[i] = mKeyframes.get(i).clone();
        }
        return new KeyframeSet(array);
    }
    
    public Object getValue(float n) {
        if (this.mNumKeyframes == 2) {
            if (this.mInterpolator != null) {
                n = this.mInterpolator.getInterpolation(n);
            }
            return this.mEvaluator.evaluate(n, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        }
        if (n <= 0.0f) {
            final Keyframe keyframe = this.mKeyframes.get(1);
            final Interpolator interpolator = keyframe.getInterpolator();
            if (interpolator != null) {
                n = interpolator.getInterpolation(n);
            }
            final float fraction = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((n - fraction) / (keyframe.getFraction() - fraction), this.mFirstKeyframe.getValue(), keyframe.getValue());
        }
        if (n >= 1.0f) {
            final Keyframe keyframe2 = this.mKeyframes.get(-2 + this.mNumKeyframes);
            final Interpolator interpolator2 = this.mLastKeyframe.getInterpolator();
            if (interpolator2 != null) {
                n = interpolator2.getInterpolation(n);
            }
            final float fraction2 = keyframe2.getFraction();
            return this.mEvaluator.evaluate((n - fraction2) / (this.mLastKeyframe.getFraction() - fraction2), keyframe2.getValue(), this.mLastKeyframe.getValue());
        }
        Keyframe mFirstKeyframe = this.mFirstKeyframe;
        Keyframe keyframe3;
        for (int i = 1; i < this.mNumKeyframes; ++i, mFirstKeyframe = keyframe3) {
            keyframe3 = this.mKeyframes.get(i);
            if (n < keyframe3.getFraction()) {
                final Interpolator interpolator3 = keyframe3.getInterpolator();
                if (interpolator3 != null) {
                    n = interpolator3.getInterpolation(n);
                }
                final float fraction3 = mFirstKeyframe.getFraction();
                return this.mEvaluator.evaluate((n - fraction3) / (keyframe3.getFraction() - fraction3), mFirstKeyframe.getValue(), keyframe3.getValue());
            }
        }
        return this.mLastKeyframe.getValue();
    }
    
    public void setEvaluator(final TypeEvaluator mEvaluator) {
        this.mEvaluator = mEvaluator;
    }
    
    @Override
    public String toString() {
        String str = " ";
        String string;
        for (int i = 0; i < this.mNumKeyframes; ++i, str = string) {
            string = str + this.mKeyframes.get(i).getValue() + "  ";
        }
        return str;
    }
}
