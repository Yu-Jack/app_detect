// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.List;

interface Dispatcher
{
    void close();
    
    void dispatchHits(List<Hit> p0);
    
    boolean okToDispatch();
}
