// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

public class dk implements InAppPurchase
{
    private final db pi;
    
    public dk(final db pi) {
        this.pi = pi;
    }
    
    @Override
    public String getProductId() {
        try {
            return this.pi.getProductId();
        }
        catch (RemoteException ex) {
            eu.c("Could not forward getProductId to InAppPurchase", (Throwable)ex);
            return null;
        }
    }
    
    @Override
    public void recordPlayBillingResolution(final int n) {
        try {
            this.pi.recordPlayBillingResolution(n);
        }
        catch (RemoteException ex) {
            eu.c("Could not forward recordPlayBillingResolution to InAppPurchase", (Throwable)ex);
        }
    }
    
    @Override
    public void recordResolution(final int n) {
        try {
            this.pi.recordResolution(n);
        }
        catch (RemoteException ex) {
            eu.c("Could not forward recordResolution to InAppPurchase", (Throwable)ex);
        }
    }
}
