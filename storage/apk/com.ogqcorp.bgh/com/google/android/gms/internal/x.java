// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class x extends Binder implements w
{
    public x() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }
    
    public static w a(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (queryLocalInterface != null && queryLocalInterface instanceof w) {
            return (w)queryLocalInterface;
        }
        return new y(binder);
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
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAppEventListener");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                this.a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
