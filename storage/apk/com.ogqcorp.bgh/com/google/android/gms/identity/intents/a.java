// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.identity.intents;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<UserAddressRequest>
{
    static void a(final UserAddressRequest userAddressRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, userAddressRequest.a());
        c.b(parcel, 2, userAddressRequest.a, false);
        c.a(parcel, a);
    }
    
    public UserAddressRequest a(final Parcel parcel) {
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        List<CountrySpecification> c = null;
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
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, CountrySpecification.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new UserAddressRequest(g, c);
    }
    
    public UserAddressRequest[] a(final int n) {
        return new UserAddressRequest[n];
    }
}
