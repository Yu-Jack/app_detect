// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;

class bd implements bb
{
    private IBinder a;
    
    bd(final IBinder a) {
        this.a = a;
    }
    
    @Override
    public be a(final String s) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            obtain.writeString(s);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return bf.a(obtain2.readStrongBinder());
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
