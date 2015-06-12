// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.events.ConflictEvent;
import com.google.android.gms.drive.events.ChangeEvent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnEventResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnEventResponse> CREATOR;
    final int a;
    final int b;
    final ChangeEvent c;
    final ConflictEvent d;
    
    static {
        CREATOR = (Parcelable$Creator)new d();
    }
    
    OnEventResponse(final int a, final int b, final ChangeEvent c, final ConflictEvent d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.internal.d.a(this, parcel, n);
    }
}
