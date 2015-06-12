// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.dynamic.d;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class aq$a extends Binder implements aq
{
    public aq$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.client.IAdManager");
    }
    
    public static aq f(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface != null && queryLocalInterface instanceof aq) {
            return (aq)queryLocalInterface;
        }
        return new aq$a$a(binder);
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
                final d u = this.U();
                parcel2.writeNoException();
                IBinder binder = null;
                if (u != null) {
                    binder = u.asBinder();
                }
                parcel2.writeStrongBinder(binder);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.destroy();
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final boolean ready = this.isReady();
                parcel2.writeNoException();
                int n3;
                if (ready) {
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
                ai b = null;
                if (int1 != 0) {
                    b = ai.CREATOR.b(parcel);
                }
                final boolean a = this.a(b);
                parcel2.writeNoException();
                int n4 = 0;
                if (a) {
                    n4 = 1;
                }
                parcel2.writeInt(n4);
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.pause();
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.resume();
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.a(ap$a.e(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.a(as$a.h(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.showInterstitial();
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.stopLoading();
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.ag();
                parcel2.writeNoException();
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final al v = this.V();
                parcel2.writeNoException();
                if (v != null) {
                    parcel2.writeInt(1);
                    v.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                final int int2 = parcel.readInt();
                al c = null;
                if (int2 != 0) {
                    c = al.CREATOR.c(parcel);
                }
                this.a(c);
                parcel2.writeNoException();
                return true;
            }
            case 14: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.a(dc$a.q(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 15: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                this.a(dg$a.u(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
