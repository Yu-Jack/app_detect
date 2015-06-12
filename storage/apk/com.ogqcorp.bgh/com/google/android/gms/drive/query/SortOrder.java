// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SortOrder implements SafeParcelable
{
    public static final Parcelable$Creator<SortOrder> CREATOR;
    final List<FieldWithSortOrder> a;
    final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new c();
    }
    
    SortOrder(final int b, final List<FieldWithSortOrder> a) {
        this.b = b;
        this.a = a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        c.a(this, parcel, n);
    }
}
