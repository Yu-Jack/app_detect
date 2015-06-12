// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.lang.reflect.InvocationTargetException;
import android.util.Log;

class PropertyValuesHolder$IntPropertyValuesHolder extends PropertyValuesHolder
{
    int mIntAnimatedValue;
    IntKeyframeSet mIntKeyframeSet;
    
    public PropertyValuesHolder$IntPropertyValuesHolder(final String s, final IntKeyframeSet mKeyframeSet) {
        super(s, null);
        this.mValueType = Integer.TYPE;
        this.mKeyframeSet = mKeyframeSet;
        this.mIntKeyframeSet = (IntKeyframeSet)this.mKeyframeSet;
    }
    
    public PropertyValuesHolder$IntPropertyValuesHolder(final String s, final int... intValues) {
        super(s, null);
        this.setIntValues(intValues);
    }
    
    @Override
    void calculateValue(final float n) {
        this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(n);
    }
    
    @Override
    public PropertyValuesHolder$IntPropertyValuesHolder clone() {
        final PropertyValuesHolder$IntPropertyValuesHolder propertyValuesHolder$IntPropertyValuesHolder = (PropertyValuesHolder$IntPropertyValuesHolder)super.clone();
        propertyValuesHolder$IntPropertyValuesHolder.mIntKeyframeSet = (IntKeyframeSet)propertyValuesHolder$IntPropertyValuesHolder.mKeyframeSet;
        return propertyValuesHolder$IntPropertyValuesHolder;
    }
    
    @Override
    Object getAnimatedValue() {
        return this.mIntAnimatedValue;
    }
    
    @Override
    void setAnimatedValue(final Object obj) {
        if (this.mSetter == null) {
            return;
        }
        try {
            this.mTmpValueArray[0] = this.mIntAnimatedValue;
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
    public void setIntValues(final int... intValues) {
        super.setIntValues(intValues);
        this.mIntKeyframeSet = (IntKeyframeSet)this.mKeyframeSet;
    }
    
    @Override
    void setupSetter(final Class clazz) {
        super.setupSetter(clazz);
    }
}
