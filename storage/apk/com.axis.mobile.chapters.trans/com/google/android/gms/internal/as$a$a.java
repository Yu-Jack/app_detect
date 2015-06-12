// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;

class as$a$a implements as
{
    private IBinder kq;
    
    as$a$a(final IBinder kq) {
        this.kq = kq;
    }
    
    public IBinder asBinder() {
        return this.kq;
    }
    
    @Override
    public void onAppEvent(final String s, final String s2) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
            obtain.writeString(s);
            obtain.writeString(s2);
            this.kq.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
