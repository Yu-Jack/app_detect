// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NotFilter implements SafeParcelable, a
{
    public static final Parcelable$Creator<NotFilter> CREATOR;
    final FilterHolder a;
    final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new i();
    }
    
    NotFilter(final int b, final FilterHolder a) {
        this.b = b;
        this.a = a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        i.a(this, parcel, n);
    }
}
