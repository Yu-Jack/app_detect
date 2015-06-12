// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class db$a extends Binder implements db
{
    public db$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
    }
    
    public static db p(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        if (queryLocalInterface != null && queryLocalInterface instanceof db) {
            return (db)queryLocalInterface;
        }
        return new db$a$a(binder);
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
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                final String productId = this.getProductId();
                parcel2.writeNoException();
                parcel2.writeString(productId);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                this.recordResolution(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                this.recordPlayBillingResolution(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
