// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder implements SafeParcelable
{
    public static final c CREATOR;
    final String a;
    final boolean b;
    final int c;
    
    static {
        CREATOR = new c();
    }
    
    FieldWithSortOrder(final int c, final String a, final boolean b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.query.internal.c.a(this, parcel, n);
    }
}
