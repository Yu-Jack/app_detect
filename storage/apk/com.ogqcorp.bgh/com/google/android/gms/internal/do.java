// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;

class do implements dm
{
    private IBinder a;
    
    do(final IBinder a) {
        this.a = a;
    }
    
    @Override
    public cz a(final cx cx) {
        while (true) {
            final Parcel obtain = Parcel.obtain();
            final Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                if (cx != null) {
                    obtain.writeInt(1);
                    cx.writeToParcel(obtain, 0);
                }
                else {
                    obtain.writeInt(0);
                }
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    return cz.CREATOR.a(obtain2);
                }
            }
            finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return null;
        }
    }
    
    public IBinder asBinder() {
        return this.a;
    }
}
