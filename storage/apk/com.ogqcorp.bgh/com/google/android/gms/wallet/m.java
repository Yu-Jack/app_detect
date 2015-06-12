// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class m implements Parcelable$Creator<NotifyTransactionStatusRequest>
{
    static void a(final NotifyTransactionStatusRequest notifyTransactionStatusRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, notifyTransactionStatusRequest.a);
        c.a(parcel, 2, notifyTransactionStatusRequest.b, false);
        c.a(parcel, 3, notifyTransactionStatusRequest.c);
        c.a(parcel, 4, notifyTransactionStatusRequest.d, false);
        c.a(parcel, a);
    }
    
    public NotifyTransactionStatusRequest a(final Parcel parcel) {
        String n = null;
        int g = 0;
        final int b = a.b(parcel);
        String n2 = null;
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
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new NotifyTransactionStatusRequest(g2, n2, g, n);
    }
    
    public NotifyTransactionStatusRequest[] a(final int n) {
        return new NotifyTransactionStatusRequest[n];
    }
}
