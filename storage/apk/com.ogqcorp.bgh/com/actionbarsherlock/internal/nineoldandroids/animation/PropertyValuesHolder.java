// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.Iterator;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.lang.reflect.Method;
import java.util.HashMap;

public class PropertyValuesHolder implements Cloneable
{
    private static Class[] DOUBLE_VARIANTS;
    private static Class[] FLOAT_VARIANTS;
    private static Class[] INTEGER_VARIANTS;
    private static final TypeEvaluator sFloatEvaluator;
    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap;
    private static final TypeEvaluator sIntEvaluator;
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap;
    private Object mAnimatedValue;
    private TypeEvaluator mEvaluator;
    private Method mGetter;
    KeyframeSet mKeyframeSet;
    final ReentrantReadWriteLock mPropertyMapLock;
    String mPropertyName;
    Method mSetter;
    final Object[] mTmpValueArray;
    Class mValueType;
    
    static {
        sIntEvaluator = new IntEvaluator();
        sFloatEvaluator = new FloatEvaluator();
        PropertyValuesHolder.FLOAT_VARIANTS = new Class[] { Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class };
        PropertyValuesHolder.INTEGER_VARIANTS = new Class[] { Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class };
        PropertyValuesHolder.DOUBLE_VARIANTS = new Class[] { Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class };
        sSetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
        sGetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
    }
    
    private PropertyValuesHolder(final String mPropertyName) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mPropertyName = mPropertyName;
    }
    
    static String getMethodName(final String str, final String s) {
        if (s == null || s.length() == 0) {
            return str;
        }
        return str + Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
    
    private Method getPropertyFunction(final Class clazz, final String str, final Class clazz2) {
        Method method = null;
        final String methodName = getMethodName(str, this.mPropertyName);
        if (clazz2 == null) {
            try {
                return clazz.getMethod(methodName, (Class[])null);
            }
            catch (NoSuchMethodException obj) {
                Log.e("PropertyValuesHolder", clazz.getSimpleName() + " - " + "Couldn't find no-arg method for property " + this.mPropertyName + ": " + obj);
                return null;
            }
        }
        final Class[] parameterTypes = { null };
        Label_0153: {
            if (!this.mValueType.equals(Float.class)) {
                break Label_0153;
            }
            Class[] array = PropertyValuesHolder.FLOAT_VARIANTS;
        Label_0114_Outer:
            while (true) {
                final int length = array.length;
                int n = 0;
                while (true) {
                    if (n >= length) {
                        break Label_0153;
                    }
                    final Class mValueType = array[n];
                    parameterTypes[0] = mValueType;
                    try {
                        method = clazz.getMethod(methodName, (Class[])parameterTypes);
                        this.mValueType = mValueType;
                        return method;
                        // iftrue(Label_0173:, !this.mValueType.equals((Object)Integer.class))
                        // iftrue(Label_0193:, !this.mValueType.equals((Object)Double.class))
                        Block_8: {
                            break Block_8;
                            Label_0173: {
                                array = PropertyValuesHolder.DOUBLE_VARIANTS;
                            }
                            continue Label_0114_Outer;
                        }
                        array = PropertyValuesHolder.INTEGER_VARIANTS;
                        continue Label_0114_Outer;
                        Label_0193: {
                            array = new Class[] { this.mValueType };
                        }
                        continue Label_0114_Outer;
                    }
                    catch (NoSuchMethodException ex) {
                        ++n;
                        continue;
                    }
                    break;
                }
                break;
            }
        }
        Log.e("PropertyValuesHolder", "Couldn't find " + str + "ter property " + this.mPropertyName + " for " + clazz.getSimpleName() + " with value type " + this.mValueType);
        return method;
    }
    
    public static PropertyValuesHolder ofFloat(final String s, final float... array) {
        return new PropertyValuesHolder$FloatPropertyValuesHolder(s, array);
    }
    
    public static PropertyValuesHolder ofInt(final String s, final int... array) {
        return new PropertyValuesHolder$IntPropertyValuesHolder(s, array);
    }
    
    public static PropertyValuesHolder ofKeyframe(final String s, final Keyframe... array) {
        final KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(array);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new PropertyValuesHolder$IntPropertyValuesHolder(s, (IntKeyframeSet)ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new PropertyValuesHolder$FloatPropertyValuesHolder(s, (FloatKeyframeSet)ofKeyframe);
        }
        final PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(s);
        propertyValuesHolder.mKeyframeSet = ofKeyframe;
        propertyValuesHolder.mValueType = array[0].getType();
        return propertyValuesHolder;
    }
    
    public static PropertyValuesHolder ofObject(final String s, final TypeEvaluator evaluator, final Object... objectValues) {
        final PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(s);
        propertyValuesHolder.setObjectValues(objectValues);
        propertyValuesHolder.setEvaluator(evaluator);
        return propertyValuesHolder;
    }
    
    private void setupGetter(final Class clazz) {
        this.mGetter = this.setupSetterOrGetter(clazz, PropertyValuesHolder.sGetterPropertyMap, "get", null);
    }
    
    private Method setupSetterOrGetter(final Class clazz, final HashMap<Class, HashMap<String, Method>> hashMap, final String s, final Class clazz2) {
        try {
            this.mPropertyMapLock.writeLock().lock();
            HashMap<String, Method> value = hashMap.get(clazz);
            Method propertyFunction = null;
            if (value != null) {
                propertyFunction = value.get(this.mPropertyName);
            }
            if (propertyFunction == null) {
                propertyFunction = this.getPropertyFunction(clazz, s, clazz2);
                if (value == null) {
                    value = new HashMap<String, Method>();
                    hashMap.put(clazz, value);
                }
                value.put(this.mPropertyName, propertyFunction);
            }
            return propertyFunction;
        }
        finally {
            this.mPropertyMapLock.writeLock().unlock();
        }
    }
    
    private void setupValue(final Object obj, final Keyframe keyframe) {
        try {
            if (this.mGetter == null) {
                this.setupGetter(obj.getClass());
            }
            keyframe.setValue(this.mGetter.invoke(obj, new Object[0]));
        }
        catch (InvocationTargetException ex) {
            Log.e("PropertyValuesHolder", ex.toString());
        }
        catch (IllegalAccessException ex2) {
            Log.e("PropertyValuesHolder", ex2.toString());
        }
    }
    
    void calculateValue(final float n) {
        this.mAnimatedValue = this.mKeyframeSet.getValue(n);
    }
    
    public PropertyValuesHolder clone() {
        try {
            final PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder)super.clone();
            propertyValuesHolder.mPropertyName = this.mPropertyName;
            propertyValuesHolder.mKeyframeSet = this.mKeyframeSet.clone();
            propertyValuesHolder.mEvaluator = this.mEvaluator;
            return propertyValuesHolder;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    Object getAnimatedValue() {
        return this.mAnimatedValue;
    }
    
    public String getPropertyName() {
        return this.mPropertyName;
    }
    
    void init() {
        if (this.mEvaluator == null) {
            TypeEvaluator mEvaluator;
            if (this.mValueType == Integer.class) {
                mEvaluator = PropertyValuesHolder.sIntEvaluator;
            }
            else if (this.mValueType == Float.class) {
                mEvaluator = PropertyValuesHolder.sFloatEvaluator;
            }
            else {
                mEvaluator = null;
            }
            this.mEvaluator = mEvaluator;
        }
        if (this.mEvaluator != null) {
            this.mKeyframeSet.setEvaluator(this.mEvaluator);
        }
    }
    
    void setAnimatedValue(final Object obj) {
        if (this.mSetter == null) {
            return;
        }
        try {
            this.mTmpValueArray[0] = this.getAnimatedValue();
            this.mSetter.invoke(obj, this.mTmpValueArray);
        }
        catch (InvocationTargetException ex) {
            Log.e("PropertyValuesHolder", ex.toString());
        }
        catch (IllegalAccessException ex2) {
            Log.e("PropertyValuesHolder", ex2.toString());
        }
    }
    
    public void setEvaluator(final TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
        this.mKeyframeSet.setEvaluator(typeEvaluator);
    }
    
    public void setFloatValues(final float... array) {
        this.mValueType = Float.TYPE;
        this.mKeyframeSet = KeyframeSet.ofFloat(array);
    }
    
    public void setIntValues(final int... array) {
        this.mValueType = Integer.TYPE;
        this.mKeyframeSet = KeyframeSet.ofInt(array);
    }
    
    public void setKeyframes(final Keyframe... array) {
        int i = 0;
        final int length = array.length;
        final Keyframe[] array2 = new Keyframe[Math.max(length, 2)];
        this.mValueType = array[0].getType();
        while (i < length) {
            array2[i] = array[i];
            ++i;
        }
        this.mKeyframeSet = new KeyframeSet(array2);
    }
    
    public void setObjectValues(final Object... array) {
        this.mValueType = array[0].getClass();
        this.mKeyframeSet = KeyframeSet.ofObject(array);
    }
    
    public void setPropertyName(final String mPropertyName) {
        this.mPropertyName = mPropertyName;
    }
    
    void setupEndValue(final Object o) {
        this.setupValue(o, this.mKeyframeSet.mKeyframes.get(-1 + this.mKeyframeSet.mKeyframes.size()));
    }
    
    void setupSetter(final Class clazz) {
        this.mSetter = this.setupSetterOrGetter(clazz, PropertyValuesHolder.sSetterPropertyMap, "set", this.mValueType);
    }
    
    void setupSetterAndGetter(final Object obj) {
        final Class<?> class1 = obj.getClass();
        if (this.mSetter == null) {
            this.setupSetter(class1);
        }
        for (final Keyframe keyframe : this.mKeyframeSet.mKeyframes) {
            if (!keyframe.hasValue()) {
                if (this.mGetter == null) {
                    this.setupGetter(class1);
                }
                try {
                    keyframe.setValue(this.mGetter.invoke(obj, new Object[0]));
                }
                catch (InvocationTargetException ex) {
                    Log.e("PropertyValuesHolder", ex.toString());
                }
                catch (IllegalAccessException ex2) {
                    Log.e("PropertyValuesHolder", ex2.toString());
                }
            }
        }
    }
    
    void setupStartValue(final Object o) {
        this.setupValue(o, this.mKeyframeSet.mKeyframes.get(0));
    }
    
    @Override
    public String toString() {
        return this.mPropertyName + ": " + this.mKeyframeSet.toString();
    }
}
