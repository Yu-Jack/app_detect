// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class TypeOrFailure<T>
{
    private LoadCallback.Failure mFailure;
    private T mType;
    
    public TypeOrFailure(final LoadCallback.Failure mFailure) {
        this.mFailure = mFailure;
    }
    
    public TypeOrFailure(final T mType) {
        this.mType = mType;
    }
    
    public LoadCallback.Failure getFailure() {
        return this.mFailure;
    }
    
    public T getType() {
        return this.mType;
    }
}
