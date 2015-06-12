// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class gm$a extends Binder implements gm
{
    public gm$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
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
                parcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.T(parcel.readInt());
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                final int int1 = parcel.readInt();
                ApplicationMetadata applicationMetadata = null;
                if (int1 != 0) {
                    applicationMetadata = (ApplicationMetadata)ApplicationMetadata.CREATOR.createFromParcel(parcel);
                }
                final String string = parcel.readString();
                final String string2 = parcel.readString();
                final int int2 = parcel.readInt();
                boolean b = false;
                if (int2 != 0) {
                    b = true;
                }
                this.a(applicationMetadata, string, string2, b);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.U(parcel.readInt());
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                final String string3 = parcel.readString();
                final double double1 = parcel.readDouble();
                final int int3 = parcel.readInt();
                boolean b2 = false;
                if (int3 != 0) {
                    b2 = true;
                }
                this.a(string3, double1, b2);
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.g(parcel.readString(), parcel.readString());
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.b(parcel.readString(), parcel.createByteArray());
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.W(parcel.readInt());
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.V(parcel.readInt());
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.onApplicationDisconnected(parcel.readInt());
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.a(parcel.readString(), parcel.readLong(), parcel.readInt());
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                this.a(parcel.readString(), parcel.readLong());
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                final int int4 = parcel.readInt();
                ge ge = null;
                if (int4 != 0) {
                    ge = (ge)com.google.android.gms.internal.ge.CREATOR.createFromParcel(parcel);
                }
                this.b(ge);
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                final int int5 = parcel.readInt();
                gj gj = null;
                if (int5 != 0) {
                    gj = (gj)com.google.android.gms.internal.gj.CREATOR.createFromParcel(parcel);
                }
                this.b(gj);
                return true;
            }
        }
    }
}
