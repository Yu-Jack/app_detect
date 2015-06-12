// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d$a;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class bu$a extends Binder implements bu
{
    public bu$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }
    
    public static bu j(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (queryLocalInterface != null && queryLocalInterface instanceof bu) {
            return (bu)queryLocalInterface;
        }
        return new bu$a$a(binder);
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
                final d ag = d$a.ag(parcel.readStrongBinder());
                al c;
                if (parcel.readInt() != 0) {
                    c = al.CREATOR.c(parcel);
                }
                else {
                    c = null;
                }
                ai b;
                if (parcel.readInt() != 0) {
                    b = ai.CREATOR.b(parcel);
                }
                else {
                    b = null;
                }
                this.a(ag, c, b, parcel.readString(), bv$a.k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final d view = this.getView();
                parcel2.writeNoException();
                IBinder binder = null;
                if (view != null) {
                    binder = view.asBinder();
                }
                parcel2.writeStrongBinder(binder);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final d ag2 = d$a.ag(parcel.readStrongBinder());
                final int int1 = parcel.readInt();
                ai b2 = null;
                if (int1 != 0) {
                    b2 = ai.CREATOR.b(parcel);
                }
                this.a(ag2, b2, parcel.readString(), bv$a.k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.showInterstitial();
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.destroy();
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final d ag3 = d$a.ag(parcel.readStrongBinder());
                al c2;
                if (parcel.readInt() != 0) {
                    c2 = al.CREATOR.c(parcel);
                }
                else {
                    c2 = null;
                }
                ai b3;
                if (parcel.readInt() != 0) {
                    b3 = ai.CREATOR.b(parcel);
                }
                else {
                    b3 = null;
                }
                this.a(ag3, c2, b3, parcel.readString(), parcel.readString(), bv$a.k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                final d ag4 = d$a.ag(parcel.readStrongBinder());
                ai b4;
                if (parcel.readInt() != 0) {
                    b4 = ai.CREATOR.b(parcel);
                }
                else {
                    b4 = null;
                }
                this.a(ag4, b4, parcel.readString(), parcel.readString(), bv$a.k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.pause();
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                this.resume();
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
