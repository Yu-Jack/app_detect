// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.util.service;

public interface ServiceJob$JobListener
{
    void onException(Exception p0);
    
    void onFinalize();
    
    void onFinished(Object p0);
    
    void onInit();
}
