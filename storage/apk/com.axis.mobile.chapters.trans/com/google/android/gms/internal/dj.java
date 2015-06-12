// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

public class dj implements InAppPurchaseResult
{
    private final df pw;
    
    public dj(final df pw) {
        this.pw = pw;
    }
    
    @Override
    public void finishPurchase() {
        try {
            this.pw.finishPurchase();
        }
        catch (RemoteException ex) {
            eu.c("Could not forward finishPurchase to InAppPurchaseResult", (Throwable)ex);
        }
    }
    
    @Override
    public String getProductId() {
        try {
            return this.pw.getProductId();
        }
        catch (RemoteException ex) {
            eu.c("Could not forward getProductId to InAppPurchaseResult", (Throwable)ex);
            return null;
        }
    }
    
    @Override
    public Intent getPurchaseData() {
        try {
            return this.pw.getPurchaseData();
        }
        catch (RemoteException ex) {
            eu.c("Could not forward getPurchaseData to InAppPurchaseResult", (Throwable)ex);
            return null;
        }
    }
    
    @Override
    public int getResultCode() {
        try {
            return this.pw.getResultCode();
        }
        catch (RemoteException ex) {
            eu.c("Could not forward getPurchaseData to InAppPurchaseResult", (Throwable)ex);
            return 0;
        }
    }
    
    @Override
    public boolean isVerified() {
        try {
            return this.pw.isVerified();
        }
        catch (RemoteException ex) {
            eu.c("Could not forward isVerified to InAppPurchaseResult", (Throwable)ex);
            return false;
        }
    }
}
