// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class gb$a extends Binder implements gb
{
    public gb$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.appstate.internal.IAppStateCallbacks");
    }
    
    public static gb E(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        if (queryLocalInterface != null && queryLocalInterface instanceof gb) {
            return (gb)queryLocalInterface;
        }
        return new gb$a$a(binder);
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
                parcel2.writeString("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                return true;
            }
            case 5001: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                final int int1 = parcel.readInt();
                final int int2 = parcel.readInt();
                DataHolder x = null;
                if (int2 != 0) {
                    x = DataHolder.CREATOR.x(parcel);
                }
                this.a(int1, x);
                parcel2.writeNoException();
                return true;
            }
            case 5002: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                final int int3 = parcel.readInt();
                DataHolder x2 = null;
                if (int3 != 0) {
                    x2 = DataHolder.CREATOR.x(parcel);
                }
                this.a(x2);
                parcel2.writeNoException();
                return true;
            }
            case 5003: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                this.b(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 5004: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                this.dT();
                parcel2.writeNoException();
                return true;
            }
            case 5005: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                this.L(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
