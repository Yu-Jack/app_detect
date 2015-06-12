// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<Cart>
{
    static void a(final Cart cart, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, cart.a());
        c.a(parcel, 2, cart.a, false);
        c.a(parcel, 3, cart.b, false);
        c.b(parcel, 4, cart.c, false);
        c.a(parcel, a);
    }
    
    public Cart a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        int g = 0;
        ArrayList<LineItem> c = new ArrayList<LineItem>();
        String n2 = null;
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
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, LineItem.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new Cart(g, n2, n, c);
    }
    
    public Cart[] a(final int n) {
        return new Cart[n];
    }
}
