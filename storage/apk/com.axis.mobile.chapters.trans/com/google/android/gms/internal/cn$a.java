// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class cn$a extends Binder implements cn
{
    public cn$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }
    
    public static cn m(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (queryLocalInterface != null && queryLocalInterface instanceof cn) {
            return (cn)queryLocalInterface;
        }
        return new cn$a$a(binder);
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
                parcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                final int int1 = parcel.readInt();
                Bundle bundle = null;
                if (int1 != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.onCreate(bundle);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.onRestart();
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.onStart();
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.onResume();
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.onPause();
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                final int int2 = parcel.readInt();
                Bundle bundle2 = null;
                if (int2 != 0) {
                    bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.onSaveInstanceState(bundle2);
                parcel2.writeNoException();
                if (bundle2 != null) {
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                }
                else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.onStop();
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.onDestroy();
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                this.S();
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
