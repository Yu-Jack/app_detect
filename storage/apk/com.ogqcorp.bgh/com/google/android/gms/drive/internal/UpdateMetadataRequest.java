// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UpdateMetadataRequest implements SafeParcelable
{
    public static final Parcelable$Creator<UpdateMetadataRequest> CREATOR;
    final int a;
    final DriveId b;
    final MetadataBundle c;
    
    static {
        CREATOR = (Parcelable$Creator)new n();
    }
    
    UpdateMetadataRequest(final int a, final DriveId b, final MetadataBundle c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        n.a(this, parcel, n);
    }
}
