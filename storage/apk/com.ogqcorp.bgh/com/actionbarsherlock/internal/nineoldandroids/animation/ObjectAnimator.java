// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

public final class ObjectAnimator extends ValueAnimator
{
    private static final boolean DBG;
    private String mPropertyName;
    private Object mTarget;
    
    public ObjectAnimator() {
    }
    
    private ObjectAnimator(final Object mTarget, final String propertyName) {
        this.mTarget = mTarget;
        this.setPropertyName(propertyName);
    }
    
    public static ObjectAnimator ofFloat(final Object o, final String s, final float... floatValues) {
        final ObjectAnimator objectAnimator = new ObjectAnimator(o, s);
        objectAnimator.setFloatValues(floatValues);
        return objectAnimator;
    }
    
    public static ObjectAnimator ofInt(final Object o, final String s, final int... intValues) {
        final ObjectAnimator objectAnimator = new ObjectAnimator(o, s);
        objectAnimator.setIntValues(intValues);
        return objectAnimator;
    }
    
    public static ObjectAnimator ofObject(final Object o, final String s, final TypeEvaluator evaluator, final Object... objectValues) {
        final ObjectAnimator objectAnimator = new ObjectAnimator(o, s);
        objectAnimator.setObjectValues(objectValues);
        objectAnimator.setEvaluator(evaluator);
        return objectAnimator;
    }
    
    public static ObjectAnimator ofPropertyValuesHolder(final Object mTarget, final PropertyValuesHolder... values) {
        final ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.mTarget = mTarget;
        objectAnimator.setValues(values);
        return objectAnimator;
    }
    
    @Override
    void animateValue(final float n) {
        super.animateValue(n);
        for (int length = this.mValues.length, i = 0; i < length; ++i) {
            this.mValues[i].setAnimatedValue(this.mTarget);
        }
    }
    
    @Override
    public ObjectAnimator clone() {
        return (ObjectAnimator)super.clone();
    }
    
    public String getPropertyName() {
        return this.mPropertyName;
    }
    
    public Object getTarget() {
        return this.mTarget;
    }
    
    @Override
    void initAnimation() {
        if (!this.mInitialized) {
            for (int length = this.mValues.length, i = 0; i < length; ++i) {
                this.mValues[i].setupSetterAndGetter(this.mTarget);
            }
            super.initAnimation();
        }
    }
    
    @Override
    public ObjectAnimator setDuration(final long duration) {
        super.setDuration(duration);
        return this;
    }
    
    @Override
    public void setFloatValues(final float... floatValues) {
        if (this.mValues == null || this.mValues.length == 0) {
            this.setValues(PropertyValuesHolder.ofFloat(this.mPropertyName, floatValues));
            return;
        }
        super.setFloatValues(floatValues);
    }
    
    @Override
    public void setIntValues(final int... intValues) {
        if (this.mValues == null || this.mValues.length == 0) {
            this.setValues(PropertyValuesHolder.ofInt(this.mPropertyName, intValues));
            return;
        }
        super.setIntValues(intValues);
    }
    
    @Override
    public void setObjectValues(final Object... objectValues) {
        if (this.mValues == null || this.mValues.length == 0) {
            this.setValues(PropertyValuesHolder.ofObject(this.mPropertyName, null, objectValues));
            return;
        }
        super.setObjectValues(objectValues);
    }
    
    public void setPropertyName(final String mPropertyName) {
        if (this.mValues != null) {
            final PropertyValuesHolder value = this.mValues[0];
            final String propertyName = value.getPropertyName();
            value.setPropertyName(mPropertyName);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(mPropertyName, value);
        }
        this.mPropertyName = mPropertyName;
        this.mInitialized = false;
    }
    
    @Override
    public void setTarget(final Object mTarget) {
        if (this.mTarget != mTarget) {
            final Object mTarget2 = this.mTarget;
            this.mTarget = mTarget;
            if (mTarget2 == null || mTarget == null || mTarget2.getClass() != mTarget.getClass()) {
                this.mInitialized = false;
            }
        }
    }
    
    @Override
    public void setupEndValues() {
        this.initAnimation();
        for (int length = this.mValues.length, i = 0; i < length; ++i) {
            this.mValues[i].setupEndValue(this.mTarget);
        }
    }
    
    @Override
    public void setupStartValues() {
        this.initAnimation();
        for (int length = this.mValues.length, i = 0; i < length; ++i) {
            this.mValues[i].setupStartValue(this.mTarget);
        }
    }
    
    @Override
    public void start() {
        super.start();
    }
    
    @Override
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(this.hashCode()) + ", target " + this.mTarget;
        if (this.mValues != null) {
            for (int i = 0; i < this.mValues.length; ++i) {
                str = str + "\n    " + this.mValues[i].toString();
            }
        }
        return str;
    }
}
