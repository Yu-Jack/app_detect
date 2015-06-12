// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.a$a;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class dt implements Parcelable$Creator
{
    static void a(final ds ds, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, ds.versionCode);
        b.a(parcel, 2, ds.pW, false);
        b.a(parcel, 3, (Parcelable)ds.pX, n, false);
        b.a(parcel, 4, (Parcelable)ds.kT, n, false);
        b.a(parcel, 5, ds.kN, false);
        b.a(parcel, 6, (Parcelable)ds.applicationInfo, n, false);
        b.a(parcel, 7, (Parcelable)ds.pY, n, false);
        b.a(parcel, 8, ds.pZ, false);
        b.a(parcel, 9, ds.qa, false);
        b.a(parcel, 10, ds.qb, false);
        b.a(parcel, 11, (Parcelable)ds.kQ, n, false);
        b.a(parcel, 12, ds.qc, false);
        b.a(parcel, 13, ds.qd, false);
        b.G(parcel, c);
    }
    
    public ds h(final Parcel parcel) {
        final int b = a.B(parcel);
        int g = 0;
        Bundle q = null;
        ai ai = null;
        al al = null;
        String o = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String o2 = null;
        String o3 = null;
        String o4 = null;
        ev ev = null;
        Bundle q2 = null;
        String o5 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
                case 3: {
                    ai = (ai)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.ai.CREATOR);
                    continue;
                }
                case 4: {
                    al = (al)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.al.CREATOR);
                    continue;
                }
                case 5: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 6: {
                    applicationInfo = (ApplicationInfo)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, ApplicationInfo.CREATOR);
                    continue;
                }
                case 7: {
                    packageInfo = (PackageInfo)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, PackageInfo.CREATOR);
                    continue;
                }
                case 8: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 9: {
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 10: {
                    o4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 11: {
                    ev = (ev)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.ev.CREATOR);
                    continue;
                }
                case 12: {
                    q2 = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
                case 13: {
                    o5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new ds(g, q, ai, al, o, applicationInfo, packageInfo, o2, o3, o4, ev, q2, o5);
    }
    
    public ds[] m(final int n) {
        return new ds[n];
    }
}
