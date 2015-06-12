// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.internal.gz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateFolderRequest implements SafeParcelable
{
    public static final Parcelable$Creator<CreateFolderRequest> CREATOR;
    final int a;
    final DriveId b;
    final MetadataBundle c;
    
    static {
        CREATOR = (Parcelable$Creator)new u();
    }
    
    CreateFolderRequest(final int a, final DriveId driveId, final MetadataBundle metadataBundle) {
        this.a = a;
        this.b = gz.a(driveId);
        this.c = gz.a(metadataBundle);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        u.a(this, parcel, n);
    }
}
