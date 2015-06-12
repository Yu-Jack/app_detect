// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Query implements SafeParcelable
{
    public static final Parcelable$Creator<Query> CREATOR;
    final LogicalFilter a;
    final String b;
    final SortOrder c;
    final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    Query(final int d, final LogicalFilter a, final String b, final SortOrder c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.query.b.a(this, parcel, n);
    }
}
