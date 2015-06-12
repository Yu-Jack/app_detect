// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListParentsResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnListParentsResponse> CREATOR;
    final int a;
    final DataHolder b;
    
    static {
        CREATOR = (Parcelable$Creator)new f();
    }
    
    OnListParentsResponse(final int a, final DataHolder b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        f.a(this, parcel, n);
    }
}
