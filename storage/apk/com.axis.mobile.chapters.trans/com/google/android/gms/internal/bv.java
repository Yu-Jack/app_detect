// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;

public interface bv extends IInterface
{
    void onAdClicked();
    
    void onAdClosed();
    
    void onAdFailedToLoad(int p0);
    
    void onAdLeftApplication();
    
    void onAdLoaded();
    
    void onAdOpened();
}
