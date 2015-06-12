// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnMetadataResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnMetadataResponse> CREATOR;
    final int a;
    final MetadataBundle b;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    OnMetadataResponse(final int a, final MetadataBundle b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        g.a(this, parcel, n);
    }
}
