// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnDownloadProgressResponse> CREATOR;
    final int a;
    final long b;
    final long c;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    OnDownloadProgressResponse(final int a, final long b, final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.internal.b.a(this, parcel, n);
    }
}
