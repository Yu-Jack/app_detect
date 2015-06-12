// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;

class bt$a$a implements bt
{
    private IBinder kq;
    
    bt$a$a(final IBinder kq) {
        this.kq = kq;
    }
    
    public IBinder asBinder() {
        return this.kq;
    }
    
    @Override
    public bu m(final String s) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            obtain.writeString(s);
            this.kq.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return bu$a.j(obtain2.readStrongBinder());
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
