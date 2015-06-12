// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class c implements Parcelable$Creator<WalletFragmentStyle>
{
    static void a(final WalletFragmentStyle walletFragmentStyle, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, walletFragmentStyle.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, walletFragmentStyle.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, walletFragmentStyle.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public WalletFragmentStyle a(final Parcel parcel) {
        int g = 0;
        final int b = a.b(parcel);
        Bundle p = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new WalletFragmentStyle(g2, p, g);
    }
    
    public WalletFragmentStyle[] a(final int n) {
        return new WalletFragmentStyle[n];
    }
}
