// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class bf extends Binder implements be
{
    public bf() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }
    
    public static be a(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (queryLocalInterface != null && queryLocalInterface instanceof be) {
            return (be)queryLocalInterface;
        }
        return new bg(binder);
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
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final a a = b.a(parcel.readStrongBinder());
                ak a2;
                if (parcel.readInt() != 0) {
                    a2 = ak.CREATOR.a(parcel);
                }
                else {
                    a2 = null;
                }
                ah a3;
                if (parcel.readInt() != 0) {
                    a3 = ah.CREATOR.a(parcel);
                }
                else {
                    a3 = null;
                }
                this.a(a, a2, a3, parcel.readString(), bi.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final a a4 = this.a();
                parcel2.writeNoException();
                IBinder binder = null;
                if (a4 != null) {
                    binder = a4.asBinder();
                }
                parcel2.writeStrongBinder(binder);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final a a5 = b.a(parcel.readStrongBinder());
                final int int1 = parcel.readInt();
                ah a6 = null;
                if (int1 != 0) {
                    a6 = ah.CREATOR.a(parcel);
                }
                this.a(a5, a6, parcel.readString(), bi.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.b();
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.c();
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final a a7 = b.a(parcel.readStrongBinder());
                ak a8;
                if (parcel.readInt() != 0) {
                    a8 = ak.CREATOR.a(parcel);
                }
                else {
                    a8 = null;
                }
                ah a9;
                if (parcel.readInt() != 0) {
                    a9 = ah.CREATOR.a(parcel);
                }
                else {
                    a9 = null;
                }
                this.a(a7, a8, a9, parcel.readString(), parcel.readString(), bi.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final a a10 = b.a(parcel.readStrongBinder());
                ah a11;
                if (parcel.readInt() != 0) {
                    a11 = ah.CREATOR.a(parcel);
                }
                else {
                    a11 = null;
                }
                this.a(a10, a11, parcel.readString(), parcel.readString(), bi.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.d();
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.e();
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
