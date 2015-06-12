// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

public abstract class lf extends Binder implements le
{
    public static le a(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (queryLocalInterface != null && queryLocalInterface instanceof le) {
            return (le)queryLocalInterface;
        }
        return new lg(binder);
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final String a = this.a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final boolean a2 = this.a(parcel.readInt() != 0);
                parcel2.writeNoException();
                int n3 = 0;
                if (a2) {
                    n3 = 1;
                }
                parcel2.writeInt(n3);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final String a3 = this.a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final String string = parcel.readString();
                final int int1 = parcel.readInt();
                boolean b = false;
                if (int1 != 0) {
                    b = true;
                }
                this.a(string, b);
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
