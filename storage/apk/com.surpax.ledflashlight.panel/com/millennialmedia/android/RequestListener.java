// 
// Decompiled by Procyon v0.5.29
// 

package com.millennialmedia.android;

public interface RequestListener
{
    void MMAdOverlayClosed(MMAd p0);
    
    void MMAdOverlayLaunched(MMAd p0);
    
    void MMAdRequestIsCaching(MMAd p0);
    
    void onSingleTap(MMAd p0);
    
    void requestCompleted(MMAd p0);
    
    void requestFailed(MMAd p0, MMException p1);
}
