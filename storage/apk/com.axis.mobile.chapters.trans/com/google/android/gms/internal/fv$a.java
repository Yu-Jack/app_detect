// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class fv$a extends Binder implements fv
{
    public fv$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
    }
    
    public static fv B(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        if (queryLocalInterface != null && queryLocalInterface instanceof fv) {
            return (fv)queryLocalInterface;
        }
        return new fv$a$a(binder);
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
                parcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                final int int1 = parcel.readInt();
                Status fromParcel = null;
                if (int1 != 0) {
                    fromParcel = Status.CREATOR.createFromParcel(parcel);
                }
                this.a(fromParcel);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                Status fromParcel2;
                if (parcel.readInt() != 0) {
                    fromParcel2 = Status.CREATOR.createFromParcel(parcel);
                }
                else {
                    fromParcel2 = null;
                }
                final int int2 = parcel.readInt();
                ParcelFileDescriptor parcelFileDescriptor = null;
                if (int2 != 0) {
                    parcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                }
                this.a(fromParcel2, parcelFileDescriptor);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                final int int3 = parcel.readInt();
                Status fromParcel3 = null;
                if (int3 != 0) {
                    fromParcel3 = Status.CREATOR.createFromParcel(parcel);
                }
                this.a(fromParcel3, parcel.readInt() != 0);
                return true;
            }
        }
    }
}
