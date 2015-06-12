// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

abstract class ServiceManager
{
    abstract void dispatch();
    
    abstract void onRadioPowered();
    
    abstract void setDispatchPeriod(final int p0);
    
    abstract void updateConnectivityStatus(final boolean p0);
}
