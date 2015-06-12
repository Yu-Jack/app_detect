// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.a.a;
import android.os.IBinder;

class v implements t
{
    private IBinder a;
    
    v(final IBinder a) {
        this.a = a;
    }
    
    @Override
    public IBinder a(final a a, final ak ak, final String s, final bb bb, final int n) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            IBinder binder;
            if (a != null) {
                binder = a.asBinder();
            }
            else {
                binder = null;
            }
            obtain.writeStrongBinder(binder);
            if (ak != null) {
                obtain.writeInt(1);
                ak.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            obtain.writeString(s);
            IBinder binder2 = null;
            if (bb != null) {
                binder2 = bb.asBinder();
            }
            obtain.writeStrongBinder(binder2);
            obtain.writeInt(n);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public IBinder asBinder() {
        return this.a;
    }
}
