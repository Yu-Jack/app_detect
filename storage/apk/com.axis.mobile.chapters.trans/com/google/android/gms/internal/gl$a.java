// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.cast.LaunchOptions;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

public abstract class gl$a extends Binder implements gl
{
    public static gl H(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        if (queryLocalInterface != null && queryLocalInterface instanceof gl) {
            return (gl)queryLocalInterface;
        }
        return new gl$a$a(binder);
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.disconnect();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                final String string = parcel.readString();
                final int int1 = parcel.readInt();
                boolean b = false;
                if (int1 != 0) {
                    b = true;
                }
                this.e(string, b);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.h(parcel.readString(), parcel.readString());
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.ep();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.am(parcel.readString());
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.eg();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.a(parcel.readDouble(), parcel.readDouble(), parcel.readInt() != 0);
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                final boolean b2 = parcel.readInt() != 0;
                final double double1 = parcel.readDouble();
                final int int2 = parcel.readInt();
                boolean b3 = false;
                if (int2 != 0) {
                    b3 = true;
                }
                this.a(b2, double1, b3);
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.a(parcel.readString(), parcel.readString(), parcel.readLong());
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.a(parcel.readString(), parcel.createByteArray(), parcel.readLong());
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.an(parcel.readString());
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                this.ao(parcel.readString());
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                final String string2 = parcel.readString();
                LaunchOptions launchOptions;
                if (parcel.readInt() != 0) {
                    launchOptions = (LaunchOptions)LaunchOptions.CREATOR.createFromParcel(parcel);
                }
                else {
                    launchOptions = null;
                }
                this.a(string2, launchOptions);
                return true;
            }
        }
    }
}
