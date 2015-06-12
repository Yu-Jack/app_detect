// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class dh extends dc$a
{
    private final InAppPurchaseListener mB;
    
    public dh(final InAppPurchaseListener mb) {
        this.mB = mb;
    }
    
    public void a(final db db) {
        this.mB.onInAppPurchaseRequested(new dk(db));
    }
}
