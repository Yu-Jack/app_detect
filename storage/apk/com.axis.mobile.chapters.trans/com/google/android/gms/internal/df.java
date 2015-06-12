// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.IInterface;

public interface df extends IInterface
{
    void finishPurchase();
    
    String getProductId();
    
    Intent getPurchaseData();
    
    int getResultCode();
    
    boolean isVerified();
}
