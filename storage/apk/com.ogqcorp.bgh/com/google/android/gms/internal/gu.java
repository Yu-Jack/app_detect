// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

public abstract class gu extends Binder implements gt
{
    public static gt a(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (queryLocalInterface != null && queryLocalInterface instanceof gt) {
            return (gt)queryLocalInterface;
        }
        return new gv(binder);
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a = gr.a(parcel.readStrongBinder());
                final int int1 = parcel.readInt();
                final String string = parcel.readString();
                final String string2 = parcel.readString();
                final String[] stringArray = parcel.createStringArray();
                final String string3 = parcel.readString();
                Bundle bundle;
                if (parcel.readInt() != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle = null;
                }
                this.a(a, int1, string, string2, stringArray, string3, bundle);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a2 = gr.a(parcel.readStrongBinder());
                final int int2 = parcel.readInt();
                final String string4 = parcel.readString();
                final int int3 = parcel.readInt();
                Bundle bundle2 = null;
                if (int3 != 0) {
                    bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.a(a2, int2, string4, bundle2);
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(gr.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(gr.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a3 = gr.a(parcel.readStrongBinder());
                final int int4 = parcel.readInt();
                final String string5 = parcel.readString();
                final int int5 = parcel.readInt();
                Bundle bundle3 = null;
                if (int5 != 0) {
                    bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.b(a3, int4, string5, bundle3);
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a4 = gr.a(parcel.readStrongBinder());
                final int int6 = parcel.readInt();
                final String string6 = parcel.readString();
                final int int7 = parcel.readInt();
                Bundle bundle4 = null;
                if (int7 != 0) {
                    bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.c(a4, int6, string6, bundle4);
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a5 = gr.a(parcel.readStrongBinder());
                final int int8 = parcel.readInt();
                final String string7 = parcel.readString();
                final int int9 = parcel.readInt();
                Bundle bundle5 = null;
                if (int9 != 0) {
                    bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.d(a5, int8, string7, bundle5);
                parcel2.writeNoException();
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a6 = gr.a(parcel.readStrongBinder());
                final int int10 = parcel.readInt();
                final String string8 = parcel.readString();
                final int int11 = parcel.readInt();
                Bundle bundle6 = null;
                if (int11 != 0) {
                    bundle6 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.e(a6, int10, string8, bundle6);
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a7 = gr.a(parcel.readStrongBinder());
                final int int12 = parcel.readInt();
                final String string9 = parcel.readString();
                final String string10 = parcel.readString();
                final String[] stringArray2 = parcel.createStringArray();
                final String string11 = parcel.readString();
                final IBinder strongBinder = parcel.readStrongBinder();
                final String string12 = parcel.readString();
                Bundle bundle7;
                if (parcel.readInt() != 0) {
                    bundle7 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle7 = null;
                }
                this.a(a7, int12, string9, string10, stringArray2, string11, strongBinder, string12, bundle7);
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.a(gr.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a8 = gr.a(parcel.readStrongBinder());
                final int int13 = parcel.readInt();
                final String string13 = parcel.readString();
                final int int14 = parcel.readInt();
                Bundle bundle8 = null;
                if (int14 != 0) {
                    bundle8 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.f(a8, int13, string13, bundle8);
                parcel2.writeNoException();
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a9 = gr.a(parcel.readStrongBinder());
                final int int15 = parcel.readInt();
                final String string14 = parcel.readString();
                final int int16 = parcel.readInt();
                Bundle bundle9 = null;
                if (int16 != 0) {
                    bundle9 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.g(a9, int15, string14, bundle9);
                parcel2.writeNoException();
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a10 = gr.a(parcel.readStrongBinder());
                final int int17 = parcel.readInt();
                final String string15 = parcel.readString();
                final int int18 = parcel.readInt();
                Bundle bundle10 = null;
                if (int18 != 0) {
                    bundle10 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.h(a10, int17, string15, bundle10);
                parcel2.writeNoException();
                return true;
            }
            case 14: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a11 = gr.a(parcel.readStrongBinder());
                final int int19 = parcel.readInt();
                final String string16 = parcel.readString();
                final int int20 = parcel.readInt();
                Bundle bundle11 = null;
                if (int20 != 0) {
                    bundle11 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.i(a11, int19, string16, bundle11);
                parcel2.writeNoException();
                return true;
            }
            case 15: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a12 = gr.a(parcel.readStrongBinder());
                final int int21 = parcel.readInt();
                final String string17 = parcel.readString();
                final int int22 = parcel.readInt();
                Bundle bundle12 = null;
                if (int22 != 0) {
                    bundle12 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.j(a12, int21, string17, bundle12);
                parcel2.writeNoException();
                return true;
            }
            case 16: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a13 = gr.a(parcel.readStrongBinder());
                final int int23 = parcel.readInt();
                final String string18 = parcel.readString();
                final int int24 = parcel.readInt();
                Bundle bundle13 = null;
                if (int24 != 0) {
                    bundle13 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.k(a13, int23, string18, bundle13);
                parcel2.writeNoException();
                return true;
            }
            case 17: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a14 = gr.a(parcel.readStrongBinder());
                final int int25 = parcel.readInt();
                final String string19 = parcel.readString();
                final int int26 = parcel.readInt();
                Bundle bundle14 = null;
                if (int26 != 0) {
                    bundle14 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.l(a14, int25, string19, bundle14);
                parcel2.writeNoException();
                return true;
            }
            case 18: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a15 = gr.a(parcel.readStrongBinder());
                final int int27 = parcel.readInt();
                final String string20 = parcel.readString();
                final int int28 = parcel.readInt();
                Bundle bundle15 = null;
                if (int28 != 0) {
                    bundle15 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.m(a15, int27, string20, bundle15);
                parcel2.writeNoException();
                return true;
            }
            case 19: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a16 = gr.a(parcel.readStrongBinder());
                final int int29 = parcel.readInt();
                final String string21 = parcel.readString();
                final IBinder strongBinder2 = parcel.readStrongBinder();
                Bundle bundle16;
                if (parcel.readInt() != 0) {
                    bundle16 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle16 = null;
                }
                this.a(a16, int29, string21, strongBinder2, bundle16);
                parcel2.writeNoException();
                return true;
            }
            case 20: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a17 = gr.a(parcel.readStrongBinder());
                final int int30 = parcel.readInt();
                final String string22 = parcel.readString();
                final String[] stringArray3 = parcel.createStringArray();
                final String string23 = parcel.readString();
                Bundle bundle17;
                if (parcel.readInt() != 0) {
                    bundle17 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle17 = null;
                }
                this.a(a17, int30, string22, stringArray3, string23, bundle17);
                parcel2.writeNoException();
                return true;
            }
            case 21: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.b(gr.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 22: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.c(gr.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 23: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a18 = gr.a(parcel.readStrongBinder());
                final int int31 = parcel.readInt();
                final String string24 = parcel.readString();
                final int int32 = parcel.readInt();
                Bundle bundle18 = null;
                if (int32 != 0) {
                    bundle18 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.n(a18, int31, string24, bundle18);
                parcel2.writeNoException();
                return true;
            }
            case 24: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.d(gr.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 25: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a19 = gr.a(parcel.readStrongBinder());
                final int int33 = parcel.readInt();
                final String string25 = parcel.readString();
                final int int34 = parcel.readInt();
                Bundle bundle19 = null;
                if (int34 != 0) {
                    bundle19 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.o(a19, int33, string25, bundle19);
                parcel2.writeNoException();
                return true;
            }
            case 26: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.e(gr.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 27: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                final gq a20 = gr.a(parcel.readStrongBinder());
                final int int35 = parcel.readInt();
                final String string26 = parcel.readString();
                final int int36 = parcel.readInt();
                Bundle bundle20 = null;
                if (int36 != 0) {
                    bundle20 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.p(a20, int35, string26, bundle20);
                parcel2.writeNoException();
                return true;
            }
            case 28: {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.b(gr.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
