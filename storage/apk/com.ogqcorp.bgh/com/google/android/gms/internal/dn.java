// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class dn extends Binder implements dm
{
    public dn() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }
    
    public static dm a(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (queryLocalInterface != null && queryLocalInterface instanceof dm) {
            return (dm)queryLocalInterface;
        }
        return new do(binder);
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
                parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                cx a;
                if (parcel.readInt() != 0) {
                    a = cx.CREATOR.a(parcel);
                }
                else {
                    a = null;
                }
                final cz a2 = this.a(a);
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                }
                else {
                    parcel2.writeInt(0);
                }
                return true;
            }
        }
    }
}
