// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.dynamic.d$a;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

public abstract class co$a extends Binder implements co
{
    public static co n(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface != null && queryLocalInterface instanceof co) {
            return (co)queryLocalInterface;
        }
        return new co$a$a(binder);
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                final IBinder a = this.a(d$a.ag(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a);
                return true;
            }
        }
    }
}
