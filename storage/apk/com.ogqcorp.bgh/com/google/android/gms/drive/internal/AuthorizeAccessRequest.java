// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthorizeAccessRequest implements SafeParcelable
{
    public static final Parcelable$Creator<AuthorizeAccessRequest> CREATOR;
    final int a;
    final long b;
    final DriveId c;
    
    static {
        CREATOR = (Parcelable$Creator)new o();
    }
    
    AuthorizeAccessRequest(final int a, final long b, final DriveId c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        o.a(this, parcel, n);
    }
}
