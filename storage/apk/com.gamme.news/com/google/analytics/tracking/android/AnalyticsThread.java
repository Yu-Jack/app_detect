// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

interface AnalyticsThread
{
    void clearHits();
    
    void dispatch();
    
    LinkedBlockingQueue<Runnable> getQueue();
    
    Thread getThread();
    
    void sendHit(Map<String, String> p0);
    
    void setForceLocalDispatch();
}
