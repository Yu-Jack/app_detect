// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.util.List;

interface Dispatcher
{
    void close();
    
    int dispatchHits(List<Hit> p0);
    
    boolean okToDispatch();
    
    void overrideHostUrl(String p0);
}
