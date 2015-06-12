// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.a.a;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class r extends Binder implements q
{
    public r() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.client.IAdManager");
    }
    
    public static q a(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface != null && queryLocalInterface instanceof q) {
            return (q)queryLocalInterface;
        }
        return new s(binder);
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
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final a a = this.a();
                parcel2.writeNoException();
                IBinder binder = null;
                if (a != null) {
                    binder = a.asBinder();
                }
                parcel2.writeStrongBinder(binder);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.b();
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final boolean c = this.c();
                parcel2.writeNoException();
                int n3;
                if (c) {
                    n3 = 1;
                }
                else {
                    n3 = 0;
                }
                parcel2.writeInt(n3);
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final int int1 = parcel.readInt();
                ah a2 = null;
                if (int1 != 0) {
                    a2 = ah.CREATOR.a(parcel);
                }
                final boolean a3 = this.a(a2);
                parcel2.writeNoException();
                int n4 = 0;
                if (a3) {
                    n4 = 1;
                }
                parcel2.writeInt(n4);
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.d();
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.e();
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.a(o.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.a(x.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.f();
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.g();
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.h();
                parcel2.writeNoException();
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final ak i = this.i();
                parcel2.writeNoException();
                if (i != null) {
                    parcel2.writeInt(1);
                    i.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final int int2 = parcel.readInt();
                ak a4 = null;
                if (int2 != 0) {
                    a4 = ak.CREATOR.a(parcel);
                }
                this.a(a4);
                parcel2.writeNoException();
                return true;
            }
            case 14: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.a(cr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
