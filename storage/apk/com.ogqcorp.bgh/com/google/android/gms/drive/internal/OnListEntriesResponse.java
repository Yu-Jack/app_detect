// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListEntriesResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnListEntriesResponse> CREATOR;
    final int a;
    final DataHolder b;
    final boolean c;
    
    static {
        CREATOR = (Parcelable$Creator)new e();
    }
    
    OnListEntriesResponse(final int a, final DataHolder b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        e.a(this, parcel, n);
    }
}
