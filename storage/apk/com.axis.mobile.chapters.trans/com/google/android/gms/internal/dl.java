// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseResult;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class dl extends dg$a
{
    private final PlayStorePurchaseListener mC;
    
    public dl(final PlayStorePurchaseListener mc) {
        this.mC = mc;
    }
    
    public void a(final df df) {
        this.mC.onInAppPurchaseFinished(new dj(df));
    }
    
    public boolean isValidPurchase(final String s) {
        return this.mC.isValidPurchase(s);
    }
}
