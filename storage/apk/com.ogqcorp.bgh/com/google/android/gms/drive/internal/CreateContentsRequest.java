// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateContentsRequest implements SafeParcelable
{
    public static final Parcelable$Creator<CreateContentsRequest> CREATOR;
    final int a;
    
    static {
        CREATOR = (Parcelable$Creator)new r();
    }
    
    public CreateContentsRequest() {
        this(1);
    }
    
    CreateContentsRequest(final int a) {
        this.a = a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        r.a(this, parcel, n);
    }
}
