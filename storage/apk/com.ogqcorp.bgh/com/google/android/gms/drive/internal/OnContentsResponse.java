// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.Contents;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnContentsResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnContentsResponse> CREATOR;
    final int a;
    final Contents b;
    
    static {
        CREATOR = (Parcelable$Creator)new z();
    }
    
    OnContentsResponse(final int a, final Contents b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        z.a(this, parcel, n);
    }
}
