// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnSyncMoreResponse> CREATOR;
    final int a;
    final boolean b;
    
    static {
        CREATOR = (Parcelable$Creator)new h();
    }
    
    OnSyncMoreResponse(final int a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        h.a(this, parcel, n);
    }
}
