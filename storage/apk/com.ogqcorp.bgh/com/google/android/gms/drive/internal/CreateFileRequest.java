// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.internal.gz;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateFileRequest implements SafeParcelable
{
    public static final Parcelable$Creator<CreateFileRequest> CREATOR;
    final int a;
    final DriveId b;
    final MetadataBundle c;
    final Contents d;
    
    static {
        CREATOR = (Parcelable$Creator)new t();
    }
    
    CreateFileRequest(final int a, final DriveId driveId, final MetadataBundle metadataBundle, final Contents contents) {
        this.a = a;
        this.b = gz.a(driveId);
        this.c = gz.a(metadataBundle);
        this.d = gz.a(contents);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        t.a(this, parcel, n);
    }
}
