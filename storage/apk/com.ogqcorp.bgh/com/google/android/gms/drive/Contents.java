// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Contents implements SafeParcelable
{
    public static final Parcelable$Creator<Contents> CREATOR;
    final int a;
    final ParcelFileDescriptor b;
    final int c;
    final int d;
    final DriveId e;
    private boolean f;
    private boolean g;
    private boolean h;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    Contents(final int a, final ParcelFileDescriptor b, final int c, final int d, final DriveId e) {
        this.f = false;
        this.g = false;
        this.h = false;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.a.a(this, parcel, n);
    }
}
