// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class fh implements Parcelable$Creator
{
    static void a(final fg fg, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.a(parcel, 1, (Parcelable[])fg.xN, n, false);
        b.c(parcel, 1000, fg.xM);
        b.a(parcel, 2, fg.xO, false);
        b.a(parcel, 3, fg.xP);
        b.G(parcel, c);
    }
    
    public fg[] D(final int n) {
        return new fg[n];
    }
    
    public fg l(final Parcel parcel) {
        String s = null;
        boolean b = false;
        final int b2 = a.B(parcel);
        fk[] array = null;
        int n = 0;
        while (parcel.dataPosition() < b2) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            boolean c = false;
            String s2 = null;
            fk[] array2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    c = b;
                    s2 = s;
                    array2 = array;
                    n2 = n;
                    break;
                }
                case 1: {
                    final fk[] array3 = (fk[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, (Parcelable$Creator)fk.CREATOR);
                    n2 = n;
                    final String s3 = s;
                    array2 = array3;
                    c = b;
                    s2 = s3;
                    break;
                }
                case 1000: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final boolean b3 = b;
                    s2 = s;
                    array2 = array;
                    n2 = g;
                    c = b3;
                    break;
                }
                case 2: {
                    final String o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    array2 = array;
                    n2 = n;
                    final boolean b4 = b;
                    s2 = o;
                    c = b4;
                    break;
                }
                case 3: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    s2 = s;
                    array2 = array;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            array = array2;
            s = s2;
            b = c;
        }
        if (parcel.dataPosition() != b2) {
            throw new a$a("Overread allowed size end=" + b2, parcel);
        }
        return new fg(n, array, s, b);
    }
}
