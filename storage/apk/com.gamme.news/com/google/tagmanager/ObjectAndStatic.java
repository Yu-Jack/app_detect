// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class ObjectAndStatic<T>
{
    private final boolean mIsStatic;
    private final T mObject;
    
    ObjectAndStatic(final T mObject, final boolean mIsStatic) {
        this.mObject = mObject;
        this.mIsStatic = mIsStatic;
    }
    
    public T getObject() {
        return this.mObject;
    }
    
    public boolean isStatic() {
        return this.mIsStatic;
    }
}
