// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

public abstract class ServiceManager
{
    @Deprecated
    public abstract void dispatchLocalHits();
    
    abstract void onRadioPowered();
    
    @Deprecated
    public abstract void setForceLocalDispatch();
    
    @Deprecated
    public abstract void setLocalDispatchPeriod(final int p0);
    
    abstract void updateConnectivityStatus(final boolean p0);
}
