// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

interface AnalyticsClient
{
    void clearHits();
    
    void connect();
    
    void disconnect();
    
    void sendHit(Map<String, String> p0, long p1, String p2, List<Command> p3);
}
