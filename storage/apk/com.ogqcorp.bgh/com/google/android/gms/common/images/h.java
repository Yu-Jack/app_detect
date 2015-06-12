// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.images;

import com.google.android.gms.common.internal.safeparcel.b;
import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class h implements Parcelable$Creator<WebImage>
{
    static void a(final WebImage webImage, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, webImage.a());
        c.a(parcel, 2, (Parcelable)webImage.b(), n, false);
        c.a(parcel, 3, webImage.c());
        c.a(parcel, 4, webImage.d());
        c.a(parcel, a);
    }
    
    public WebImage a(final Parcel parcel) {
        int n = 0;
        final int b = a.b(parcel);
        Uri uri = null;
        int n2 = 0;
        int n3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            int g = 0;
            int n4 = 0;
            Uri uri2 = null;
            int n5 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    g = n;
                    n4 = n2;
                    uri2 = uri;
                    n5 = n3;
                    break;
                }
                case 1: {
                    final int g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final int n6 = n;
                    n4 = n2;
                    uri2 = uri;
                    n5 = g2;
                    g = n6;
                    break;
                }
                case 2: {
                    final Uri uri3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    n5 = n3;
                    final int n7 = n2;
                    uri2 = uri3;
                    g = n;
                    n4 = n7;
                    break;
                }
                case 3: {
                    final int g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    uri2 = uri;
                    n5 = n3;
                    final int n8 = n;
                    n4 = g3;
                    g = n8;
                    break;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    n4 = n2;
                    uri2 = uri;
                    n5 = n3;
                    break;
                }
            }
            n3 = n5;
            uri = uri2;
            n2 = n4;
            n = g;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new WebImage(n3, uri, n2, n);
    }
    
    public WebImage[] a(final int n) {
        return new WebImage[n];
    }
}
