// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TrashResourceRequest implements SafeParcelable
{
    public static final Parcelable$Creator<TrashResourceRequest> CREATOR;
    final int a;
    final DriveId b;
    
    static {
        CREATOR = (Parcelable$Creator)new m();
    }
    
    TrashResourceRequest(final int a, final DriveId b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        m.a(this, parcel, n);
    }
}
