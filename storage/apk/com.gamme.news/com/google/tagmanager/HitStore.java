// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

interface HitStore
{
    void close();
    
    void dispatch();
    
    Dispatcher getDispatcher();
    
    void putHit(long p0, String p1);
}
