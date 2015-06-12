// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetMetadataRequest implements SafeParcelable
{
    public static final Parcelable$Creator<GetMetadataRequest> CREATOR;
    final int a;
    final DriveId b;
    
    static {
        CREATOR = (Parcelable$Creator)new w();
    }
    
    GetMetadataRequest(final int a, final DriveId b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        w.a(this, parcel, n);
    }
}
