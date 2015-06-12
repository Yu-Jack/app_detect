// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

interface LoadCallback<T>
{
    void onFailure(Failure p0);
    
    void onSuccess(T p0);
    
    void startLoad();
    
    public enum Failure
    {
        IO_ERROR, 
        NOT_AVAILABLE, 
        SERVER_ERROR;
    }
}
