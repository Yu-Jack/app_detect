// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet.fragment;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<WalletFragmentInitParams>
{
    static void a(final WalletFragmentInitParams walletFragmentInitParams, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, walletFragmentInitParams.a);
        c.a(parcel, 2, walletFragmentInitParams.a(), false);
        c.a(parcel, 3, (Parcelable)walletFragmentInitParams.b(), n, false);
        c.a(parcel, 4, walletFragmentInitParams.c());
        c.a(parcel, 5, (Parcelable)walletFragmentInitParams.d(), n, false);
        c.a(parcel, a);
    }
    
    public WalletFragmentInitParams a(final Parcel parcel) {
        MaskedWallet maskedWallet = null;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        int g2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String n = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    maskedWalletRequest = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, MaskedWalletRequest.CREATOR);
                    continue;
                }
                case 4: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    maskedWallet = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, MaskedWallet.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new WalletFragmentInitParams(g, n, maskedWalletRequest, g2, maskedWallet);
    }
    
    public WalletFragmentInitParams[] a(final int n) {
        return new WalletFragmentInitParams[n];
    }
}
