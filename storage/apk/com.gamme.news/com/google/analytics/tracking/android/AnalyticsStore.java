// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.Collection;
import java.util.Map;

interface AnalyticsStore
{
    void clearHits(long p0);
    
    void close();
    
    void dispatch();
    
    Dispatcher getDispatcher();
    
    void putHit(Map<String, String> p0, long p1, String p2, Collection<Command> p3);
    
    void setDispatch(boolean p0);
}
