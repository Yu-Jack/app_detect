// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

interface ServiceProxy
{
    void clearHits();
    
    void createService();
    
    void dispatch();
    
    void putHit(Map<String, String> p0, long p1, String p2, List<Command> p3);
    
    void setForceLocalDispatch();
}
