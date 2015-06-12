// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;

public interface db extends IInterface
{
    String getProductId();
    
    void recordPlayBillingResolution(int p0);
    
    void recordResolution(int p0);
}
