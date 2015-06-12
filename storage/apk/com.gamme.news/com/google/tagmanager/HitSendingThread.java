// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

interface HitSendingThread
{
    void queueToThread(Runnable p0);
    
    void sendHit(String p0);
}
