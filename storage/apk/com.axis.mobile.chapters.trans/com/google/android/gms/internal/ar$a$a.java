// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import android.os.IBinder;

class ar$a$a implements ar
{
    private IBinder kq;
    
    ar$a$a(final IBinder kq) {
        this.kq = kq;
    }
    
    @Override
    public IBinder a(final d d, final al al, final String s, final bt bt, final int n) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            IBinder binder;
            if (d != null) {
                binder = d.asBinder();
            }
            else {
                binder = null;
            }
            obtain.writeStrongBinder(binder);
            if (al != null) {
                obtain.writeInt(1);
                al.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            obtain.writeString(s);
            IBinder binder2 = null;
            if (bt != null) {
                binder2 = bt.asBinder();
            }
            obtain.writeStrongBinder(binder2);
            obtain.writeInt(n);
            this.kq.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public IBinder asBinder() {
        return this.kq;
    }
}
