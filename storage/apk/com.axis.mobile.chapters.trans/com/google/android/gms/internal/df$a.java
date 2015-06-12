// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class df$a extends Binder implements df
{
    public df$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
    }
    
    public static df t(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        if (queryLocalInterface != null && queryLocalInterface instanceof df) {
            return (df)queryLocalInterface;
        }
        return new df$a$a(binder);
    }
    
    public IBinder asBinder() {
        return (IBinder)this;
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                final String productId = this.getProductId();
                parcel2.writeNoException();
                parcel2.writeString(productId);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                final Intent purchaseData = this.getPurchaseData();
                parcel2.writeNoException();
                if (purchaseData != null) {
                    parcel2.writeInt(1);
                    purchaseData.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                final int resultCode = this.getResultCode();
                parcel2.writeNoException();
                parcel2.writeInt(resultCode);
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                final boolean verified = this.isVerified();
                parcel2.writeNoException();
                int n3 = 0;
                if (verified) {
                    n3 = 1;
                }
                parcel2.writeInt(n3);
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                this.finishPurchase();
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
