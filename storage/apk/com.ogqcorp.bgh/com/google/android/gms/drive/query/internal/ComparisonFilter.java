// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ComparisonFilter<T> implements SafeParcelable, a
{
    public static final com.google.android.gms.drive.query.internal.a CREATOR;
    final Operator a;
    final MetadataBundle b;
    final int c;
    final com.google.android.gms.drive.metadata.a<T> d;
    
    static {
        CREATOR = new com.google.android.gms.drive.query.internal.a();
    }
    
    ComparisonFilter(final int c, final Operator a, final MetadataBundle b) {
        this.c = c;
        this.a = a;
        this.b = b;
        this.d = (com.google.android.gms.drive.metadata.a<T>)e.a(b);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.query.internal.a.a(this, parcel, n);
    }
}
