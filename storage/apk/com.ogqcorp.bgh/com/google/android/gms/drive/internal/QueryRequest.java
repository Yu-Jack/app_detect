// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.Query;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class QueryRequest implements SafeParcelable
{
    public static final Parcelable$Creator<QueryRequest> CREATOR;
    final int a;
    final Query b;
    
    static {
        CREATOR = (Parcelable$Creator)new k();
    }
    
    QueryRequest(final int a, final Query b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        k.a(this, parcel, n);
    }
}
