// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable
{
    public static final Parcelable$Creator<CloseContentsAndUpdateMetadataRequest> CREATOR;
    final int a;
    final DriveId b;
    final MetadataBundle c;
    final Contents d;
    
    static {
        CREATOR = (Parcelable$Creator)new p();
    }
    
    CloseContentsAndUpdateMetadataRequest(final int a, final DriveId b, final MetadataBundle c, final Contents d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        p.a(this, parcel, n);
    }
}
