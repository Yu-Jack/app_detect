// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model.a;

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;
import android.os.IBinder;

class c implements a
{
    private IBinder a;
    
    c(final IBinder a) {
        this.a = a;
    }
    
    @Override
    public Tile a(final int n, final int n2, final int n3) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            obtain.writeInt(n);
            obtain.writeInt(n2);
            obtain.writeInt(n3);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            Tile a;
            if (obtain2.readInt() != 0) {
                a = Tile.CREATOR.a(obtain2);
            }
            else {
                a = null;
            }
            return a;
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
