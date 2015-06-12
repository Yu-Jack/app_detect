// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;

class dw$a$a implements dw
{
    private IBinder kq;
    
    dw$a$a(final IBinder kq) {
        this.kq = kq;
    }
    
    public IBinder asBinder() {
        return this.kq;
    }
    
    @Override
    public du b(final ds ds) {
        while (true) {
            final Parcel obtain = Parcel.obtain();
            final Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                if (ds != null) {
                    obtain.writeInt(1);
                    ds.writeToParcel(obtain, 0);
                }
                else {
                    obtain.writeInt(0);
                }
                this.kq.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    return du.CREATOR.i(obtain2);
                }
            }
            finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return null;
        }
    }
}
