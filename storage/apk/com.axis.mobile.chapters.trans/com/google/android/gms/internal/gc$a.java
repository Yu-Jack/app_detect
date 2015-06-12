// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

public abstract class gc$a extends Binder implements gc
{
    public static gc F(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
        if (queryLocalInterface != null && queryLocalInterface instanceof gc) {
            return (gc)queryLocalInterface;
        }
        return new gc$a$a(binder);
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                return true;
            }
            case 5001: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                final int du = this.dU();
                parcel2.writeNoException();
                parcel2.writeInt(du);
                return true;
            }
            case 5002: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                final int dv = this.dV();
                parcel2.writeNoException();
                parcel2.writeInt(dv);
                return true;
            }
            case 5003: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                this.a(gb$a.E(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            }
            case 5004: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                this.a(gb$a.E(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 5005: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                this.a(gb$a.E(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 5006: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                this.a(gb$a.E(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            }
            case 5007: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                this.b(gb$a.E(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 5008: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                this.b(gb$a.E(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 5009: {
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                this.c(gb$a.E(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
