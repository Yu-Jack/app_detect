// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OpenContentsRequest implements SafeParcelable
{
    public static final Parcelable$Creator<OpenContentsRequest> CREATOR;
    final int a;
    final DriveId b;
    final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new i();
    }
    
    OpenContentsRequest(final int a, final DriveId b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        i.a(this, parcel, n);
    }
}
