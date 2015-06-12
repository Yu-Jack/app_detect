// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.lang.reflect.InvocationTargetException;
import android.util.Log;

class PropertyValuesHolder$FloatPropertyValuesHolder extends PropertyValuesHolder
{
    float mFloatAnimatedValue;
    FloatKeyframeSet mFloatKeyframeSet;
    
    public PropertyValuesHolder$FloatPropertyValuesHolder(final String s, final FloatKeyframeSet mKeyframeSet) {
        super(s, null);
        this.mValueType = Float.TYPE;
        this.mKeyframeSet = mKeyframeSet;
        this.mFloatKeyframeSet = (FloatKeyframeSet)this.mKeyframeSet;
    }
    
    public PropertyValuesHolder$FloatPropertyValuesHolder(final String s, final float... floatValues) {
        super(s, null);
        this.setFloatValues(floatValues);
    }
    
    @Override
    void calculateValue(final float n) {
        this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(n);
    }
    
    @Override
    public PropertyValuesHolder$FloatPropertyValuesHolder clone() {
        final PropertyValuesHolder$FloatPropertyValuesHolder propertyValuesHolder$FloatPropertyValuesHolder = (PropertyValuesHolder$FloatPropertyValuesHolder)super.clone();
        propertyValuesHolder$FloatPropertyValuesHolder.mFloatKeyframeSet = (FloatKeyframeSet)propertyValuesHolder$FloatPropertyValuesHolder.mKeyframeSet;
        return propertyValuesHolder$FloatPropertyValuesHolder;
    }
    
    @Override
    Object getAnimatedValue() {
        return this.mFloatAnimatedValue;
    }
    
    @Override
    void setAnimatedValue(final Object obj) {
        if (this.mSetter == null) {
            return;
        }
        try {
            this.mTmpValueArray[0] = this.mFloatAnimatedValue;
            this.mSetter.invoke(obj, this.mTmpValueArray);
        }
        catch (InvocationTargetException ex) {
            Log.e("PropertyValuesHolder", ex.toString());
        }
        catch (IllegalAccessException ex2) {
            Log.e("PropertyValuesHolder", ex2.toString());
        }
    }
    
    @Override
    public void setFloatValues(final float... floatValues) {
        super.setFloatValues(floatValues);
        this.mFloatKeyframeSet = (FloatKeyframeSet)this.mKeyframeSet;
    }
    
    @Override
    void setupSetter(final Class clazz) {
        super.setupSetter(clazz);
    }
}
