// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics.internal;

import android.os.Parcelable$Creator;
import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import java.util.List;
import java.util.Map;
import android.os.RemoteException;
import android.os.IInterface;

public interface IAnalyticsService extends IInterface
{
    void clearHits() throws RemoteException;
    
    void sendHit(Map p0, long p1, String p2, List<Command> p3) throws RemoteException;
    
    public abstract static class Stub extends Binder implements IAnalyticsService
    {
        private static final String DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
        static final int TRANSACTION_clearHits = 2;
        static final int TRANSACTION_sendHit = 1;
        
        public Stub() {
            this.attachInterface((IInterface)this, "com.google.android.gms.analytics.internal.IAnalyticsService");
        }
        
        public static IAnalyticsService asInterface(IBinder binder) {
            IInterface queryLocalInterface;
            if (binder == null) {
                return null;
            }
            queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            if (queryLocalInterface != null && queryLocalInterface instanceof IAnalyticsService) {
                return (IAnalyticsService)queryLocalInterface;
            }
            return new Proxy(binder);
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.sendHit(parcel.readHashMap(this.getClass().getClassLoader()), parcel.readLong(), parcel.readString(), parcel.createTypedArrayList((Parcelable$Creator)Command.CREATOR));
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.clearHits();
                    parcel2.writeNoException();
                    return true;
                }
            }
        }
        
        private static class Proxy implements IAnalyticsService
        {
            private IBinder mRemote;
            
            Proxy(IBinder mRemote) {
                this.mRemote = mRemote;
            }
            
            public IBinder asBinder() {
                return this.mRemote;
            }
            
            @Override
            public void clearHits() throws RemoteException {
                Parcel obtain;
                Parcel obtain2;
                obtain = Parcel.obtain();
                obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public String getInterfaceDescriptor() {
                return "com.google.android.gms.analytics.internal.IAnalyticsService";
            }
            
            @Override
            public void sendHit(Map map, long n, String s, List<Command> list) throws RemoteException {
                Parcel obtain;
                Parcel obtain2;
                obtain = Parcel.obtain();
                obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    obtain.writeMap(map);
                    obtain.writeLong(n);
                    obtain.writeString(s);
                    obtain.writeTypedList((List)list);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
