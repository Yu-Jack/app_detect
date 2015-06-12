// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet.fragment;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<WalletFragmentOptions>
{
    static void a(final WalletFragmentOptions walletFragmentOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, walletFragmentOptions.a);
        c.a(parcel, 2, walletFragmentOptions.a());
        c.a(parcel, 3, walletFragmentOptions.b());
        c.a(parcel, 4, (Parcelable)walletFragmentOptions.c(), n, false);
        c.a(parcel, 5, walletFragmentOptions.d());
        c.a(parcel, a);
    }
    
    public WalletFragmentOptions a(final Parcel parcel) {
        int g = 1;
        int g2 = 0;
        final int b = a.b(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int g3 = g;
        int g4 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    walletFragmentStyle = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, WalletFragmentStyle.CREATOR);
                    continue;
                }
                case 5: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new WalletFragmentOptions(g4, g3, g2, walletFragmentStyle, g);
    }
    
    public WalletFragmentOptions[] a(final int n) {
        return new WalletFragmentOptions[n];
    }
}
