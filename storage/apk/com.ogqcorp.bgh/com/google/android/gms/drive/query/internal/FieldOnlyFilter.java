// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldOnlyFilter implements SafeParcelable, a
{
    public static final Parcelable$Creator<FieldOnlyFilter> CREATOR;
    final MetadataBundle a;
    final int b;
    private final com.google.android.gms.drive.metadata.a<?> c;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    FieldOnlyFilter(final int b, final MetadataBundle a) {
        this.b = b;
        this.a = a;
        this.c = e.a(a);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.query.internal.b.a(this, parcel, n);
    }
}
