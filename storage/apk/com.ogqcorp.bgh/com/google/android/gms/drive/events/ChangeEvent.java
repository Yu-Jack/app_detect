// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ChangeEvent implements SafeParcelable, ResourceEvent
{
    public static final Parcelable$Creator<ChangeEvent> CREATOR;
    final int a;
    final DriveId b;
    final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    ChangeEvent(final int a, final DriveId b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        return String.format("ChangeEvent [id=%s,changeFlags=%x]", this.b, this.c);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.events.a.a(this, parcel, n);
    }
}
