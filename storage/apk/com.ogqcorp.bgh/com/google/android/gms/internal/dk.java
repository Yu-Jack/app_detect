// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.b;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class dk implements Parcelable$Creator<cx>
{
    static void a(final cx cx, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, cx.a);
        c.a(parcel, 2, cx.b, false);
        c.a(parcel, 3, (Parcelable)cx.c, n, false);
        c.a(parcel, 4, (Parcelable)cx.d, n, false);
        c.a(parcel, 5, cx.e, false);
        c.a(parcel, 6, (Parcelable)cx.f, n, false);
        c.a(parcel, 7, (Parcelable)cx.g, n, false);
        c.a(parcel, 8, cx.h, false);
        c.a(parcel, 9, cx.i, false);
        c.a(parcel, 10, cx.j, false);
        c.a(parcel, 11, (Parcelable)cx.k, n, false);
        c.a(parcel, 12, cx.l, false);
        c.a(parcel, a);
    }
    
    public cx a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        Bundle p = null;
        ah ah = null;
        ak ak = null;
        String n = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        dx dx = null;
        Bundle p2 = null;
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
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 3: {
                    ah = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ah>)com.google.android.gms.internal.ah.CREATOR);
                    continue;
                }
                case 4: {
                    ak = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ak>)com.google.android.gms.internal.ak.CREATOR);
                    continue;
                }
                case 5: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    applicationInfo = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ApplicationInfo>)ApplicationInfo.CREATOR);
                    continue;
                }
                case 7: {
                    packageInfo = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<PackageInfo>)PackageInfo.CREATOR);
                    continue;
                }
                case 8: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 9: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 10: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 11: {
                    dx = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<dx>)com.google.android.gms.internal.dx.CREATOR);
                    continue;
                }
                case 12: {
                    p2 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new cx(g, p, ah, ak, n, applicationInfo, packageInfo, n2, n3, n4, dx, p2);
    }
    
    public cx[] a(final int n) {
        return new cx[n];
    }
}
