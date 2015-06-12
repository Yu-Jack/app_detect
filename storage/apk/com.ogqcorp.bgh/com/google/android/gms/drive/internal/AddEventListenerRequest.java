// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.app.PendingIntent;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AddEventListenerRequest implements SafeParcelable
{
    public static final Parcelable$Creator<AddEventListenerRequest> CREATOR;
    final int a;
    final DriveId b;
    final int c;
    final PendingIntent d;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    AddEventListenerRequest(final int a, final DriveId b, final int c, final PendingIntent d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.internal.a.a(this, parcel, n);
    }
}
