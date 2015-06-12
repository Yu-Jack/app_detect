// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DisconnectRequest implements SafeParcelable
{
    public static final Parcelable$Creator<DisconnectRequest> CREATOR;
    final int a;
    
    static {
        CREATOR = (Parcelable$Creator)new v();
    }
    
    public DisconnectRequest() {
        this(1);
    }
    
    DisconnectRequest(final int a) {
        this.a = a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        v.a(this, parcel, n);
    }
}
