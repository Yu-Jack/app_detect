// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.cast;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<ApplicationMetadata>
{
    static void a(final ApplicationMetadata applicationMetadata, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, applicationMetadata.a());
        c.a(parcel, 2, applicationMetadata.b(), false);
        c.a(parcel, 3, applicationMetadata.c(), false);
        c.b(parcel, 4, applicationMetadata.f(), false);
        c.a(parcel, 5, applicationMetadata.d, false);
        c.a(parcel, 6, applicationMetadata.d(), false);
        c.a(parcel, 7, (Parcelable)applicationMetadata.e(), n, false);
        c.a(parcel, a);
    }
    
    public ApplicationMetadata a(final Parcel parcel) {
        Uri uri = null;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        String n = null;
        List<String> a = null;
        List<WebImage> c = null;
        String n2 = null;
        String n3 = null;
        while (parcel.dataPosition() < b) {
            final int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a2)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    continue;
                }
                case 2: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    continue;
                }
                case 4: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2, WebImage.CREATOR);
                    continue;
                }
                case 5: {
                    a = com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
                    continue;
                }
                case 6: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    continue;
                }
                case 7: {
                    uri = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ApplicationMetadata(g, n3, n2, c, a, n, uri);
    }
    
    public ApplicationMetadata[] a(final int n) {
        return new ApplicationMetadata[n];
    }
}
